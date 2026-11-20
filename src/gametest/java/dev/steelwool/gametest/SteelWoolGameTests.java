package dev.steelwool.gametest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;

import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.loading.LoadingModList;
import net.neoforged.neoforge.server.permission.PermissionAPI;
import net.neoforged.neoforge.server.permission.nodes.PermissionNode;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import org.objectweb.asm.Type;

/**
 * Checks that SteelWool loaded the NeoForge test mod ({@code testmod/}) and that each supported
 * NeoForge feature reached it. Run with {@code ./gradlew runGameTest}.
 */
public class SteelWoolGameTests {
	private static final String MODID = "steelwool_testmod";

	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MODID, path);
	}

	/** Reads a static field of a test mod class. Test mod classes live in the NeoForge mod jar, not on this source set's classpath. */
	private static Object testModField(String className, String field) {
		try {
			Class<?> clazz = Class.forName("dev.steelwool.testmod." + className, true, SteelWoolGameTests.class.getClassLoader());
			Field f = clazz.getDeclaredField(field);
			f.setAccessible(true);
			return f.get(null);
		} catch (ReflectiveOperationException e) {
			throw new AssertionError("Could not read " + className + "." + field, e);
		}
	}

	private static void assertFlag(GameTestHelper helper, String flag) {
		helper.assertTrue(Boolean.TRUE.equals(testModField("TestModState", flag)), Component.literal("Expected TestModState." + flag + " to be true"));
	}

	@GameTest
	public void modIsListed(GameTestHelper helper) {
		helper.assertTrue(ModList.get().isLoaded(MODID), Component.literal("ModList does not contain " + MODID));
		helper.assertTrue(ModList.get().getModContainerById(MODID).isPresent(), Component.literal("No ModContainer for " + MODID));
		helper.succeed();
	}

	/** FML's file-level APIs, which mods use to read their metadata and find annotated plugin classes. */
	@GameTest
	public void modFileMetadataIsAvailable(GameTestHelper helper) {
		IModFileInfo file = ModList.get().getModFileById(MODID);
		helper.assertTrue(file != null, Component.literal("ModList.getModFileById returned null"));
		helper.assertTrue(file == LoadingModList.get().getModFileById(MODID), Component.literal("LoadingModList disagrees with ModList"));
		helper.assertTrue(FMLLoader.getCurrent().getLoadingModList() == LoadingModList.get(), Component.literal("FMLLoader has a different LoadingModList"));

		IModInfo info = file.getMods().getFirst();
		helper.assertTrue(info.getModId().equals(MODID), Component.literal("Wrong mod id " + info.getModId()));
		helper.assertTrue(info.getOwningFile() == file, Component.literal("IModInfo.getOwningFile is not the mod file"));
		helper.assertTrue(info.getVersion() != null, Component.literal("No version"));
		helper.assertTrue(file.getFile().getFilePath().toString().endsWith(".jar"), Component.literal("Unexpected file path " + file.getFile().getFilePath()));

		Type modAnnotation = Type.getType(Mod.class);
		boolean foundMod = ModList.get().getAllScanData().stream()
				.flatMap(data -> data.getAnnotations().stream())
				.anyMatch(a -> a.annotationType().equals(modAnnotation) && MODID.equals(a.annotationData().get("value")));
		helper.assertTrue(foundMod, Component.literal("Scan data has no @Mod(\"" + MODID + "\") annotation"));
		helper.succeed();
	}

	/** RegisterPayloadHandlersEvent reached the mod and its payload is registered with Fabric's networking API. */
	@GameTest
	public void payloadIsRegisteredWithFabric(GameTestHelper helper) {
		assertFlag(helper, "payloadsRegistered");
		helper.assertTrue(ServerPlayNetworking.getGlobalReceivers().contains(id("test_payload")),
				Component.literal("No Fabric server receiver for steelwool_testmod:test_payload"));
		helper.succeed();
	}

	/** Game events posted from Fabric callbacks and SteelWool's mixins reach the mod's listeners. */
	@GameTest
	public void gameEventsFire(GameTestHelper helper) {
		assertFlag(helper, "serverTickFired");
		assertFlag(helper, "levelLoadFired");
		helper.succeed();
	}

	/** The mod's permission node is registered through PermissionGatherEvent and resolves to its default. */
	@GameTest
	public void permissionNodeResolves(GameTestHelper helper) {
		@SuppressWarnings("unchecked")
		PermissionNode<Integer> node = (PermissionNode<Integer>) testModField("TestMod", "TEST_PERMISSION");
		helper.assertTrue(PermissionAPI.getRegisteredNodes().contains(node), Component.literal("Permission node is not registered"));
		helper.assertTrue(PermissionAPI.getOfflinePermission(java.util.UUID.randomUUID(), node) == 42, Component.literal("Permission did not resolve to 42"));
		helper.succeed();
	}

	@GameTest
	public void deferredRegisterEntriesAreRegistered(GameTestHelper helper) {
		helper.assertTrue(BuiltInRegistries.BLOCK.containsKey(id("test_block")), Component.literal("test_block is not registered"));
		helper.assertTrue(BuiltInRegistries.ITEM.containsKey(id("test_block")), Component.literal("test_block item is not registered"));
		helper.assertTrue(BuiltInRegistries.ITEM.containsKey(id("test_item")), Component.literal("test_item is not registered"));
		helper.assertTrue(BuiltInRegistries.CREATIVE_MODE_TAB.containsKey(id("test_tab")), Component.literal("test_tab is not registered"));

		// The mod's DeferredItem must resolve to the registered object.
		Object deferredItem = testModField("TestMod", "TEST_ITEM");
		Item registered = BuiltInRegistries.ITEM.getValue(id("test_item"));
		helper.assertTrue(registered == ((java.util.function.Supplier<?>) deferredItem).get(), Component.literal("DeferredItem does not resolve to the registered item"));
		helper.succeed();
	}

	@GameTest
	public void modBlockCanBePlaced(GameTestHelper helper) {
		Block block = BuiltInRegistries.BLOCK.getValue(id("test_block"));
		BlockPos pos = new BlockPos(1, 1, 1);
		helper.setBlock(pos, block);
		helper.assertBlockPresent(block, pos);
		helper.succeed();
	}

	@GameTest
	public void lifecycleEventsFired(GameTestHelper helper) {
		assertFlag(helper, "constructed");
		assertFlag(helper, "constructEventFired");
		assertFlag(helper, "configLoadingEventFired");
		assertFlag(helper, "commonSetupFired");
		assertFlag(helper, "deferredWorkRan");
		assertFlag(helper, "dedicatedServerSetupFired");
		assertFlag(helper, "loadCompleteFired");
		helper.succeed();
	}

	@GameTest
	public void gameBusEventsFired(GameTestHelper helper) {
		assertFlag(helper, "serverStartingFired");
		assertFlag(helper, "serverStartedFiredViaSubscriber");
		helper.succeed();
	}

	@GameTest
	public void configFileWasCreatedAndRead(GameTestHelper helper) {
		helper.assertTrue(Files.isRegularFile(FMLPaths.CONFIGDIR.get().resolve(MODID + "-local.toml")), Component.literal("Config file was not created"));
		helper.assertTrue(Integer.valueOf(42).equals(testModField("TestModState", "magicNumberAtCommonSetup")), Component.literal("Config value was not readable at common setup"));
		helper.succeed();
	}

	@GameTest
	public void dataPackFromModJarIsLoaded(GameTestHelper helper) {
		var recipe = helper.getLevel().getServer().getRecipeManager()
				.byKey(ResourceKey.create(Registries.RECIPE, id("test_item_from_dirt")));
		helper.assertTrue(recipe.isPresent(), Component.literal("Recipe from the mod jar's data/ folder was not loaded"));
		helper.succeed();
	}

	@GameTest
	public void commandIsRegistered(GameTestHelper helper) {
		var node = helper.getLevel().getServer().getCommands().getDispatcher().getRoot().getChild("steelwooltest");
		helper.assertTrue(node != null, Component.literal("/steelwooltest was not registered"));
		helper.succeed();
	}

	@GameTest
	public void mixinFromModIsApplied(GameTestHelper helper) {
		assertFlag(helper, "mixinApplied");
		helper.succeed();
	}

	@GameTest
	public void patchedCreativeTabBuilderWorks(GameTestHelper helper) {
		// TestMod.TEST_TAB was built with NeoForge's no-arg CreativeModeTab.builder(), which SteelWool provides.
		try {
			Method builder = net.minecraft.world.item.CreativeModeTab.class.getMethod("builder");
			helper.assertTrue(builder.invoke(null) != null, Component.literal("CreativeModeTab.builder() returned null"));
		} catch (ReflectiveOperationException e) {
			throw new AssertionError("CreativeModeTab.builder() is missing", e);
		}

		helper.succeed();
	}
}
