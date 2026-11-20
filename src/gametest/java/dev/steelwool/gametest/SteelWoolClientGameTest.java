package dev.steelwool.gametest;

import net.fabricmc.fabric.api.client.gametest.v1.FabricClientGameTest;
import net.fabricmc.fabric.api.client.gametest.v1.context.ClientGameTestContext;
import net.fabricmc.fabric.api.client.gametest.v1.context.TestSingleplayerContext;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

/**
 * Client-side checks: client setup ran, the NeoForge mod's assets (lang file) loaded as a
 * resource pack, and a singleplayer world loads with the mod's data pack.
 * Run with {@code ./gradlew runClientGameTest} (opens a game window).
 */
public class SteelWoolClientGameTest implements FabricClientGameTest {
	private static void check(boolean condition, String message) {
		if (!condition) {
			throw new AssertionError(message);
		}
	}

	private static boolean testModFlag(String name) {
		try {
			Class<?> state = Class.forName("dev.steelwool.testmod.TestModState", true, SteelWoolClientGameTest.class.getClassLoader());
			return state.getField(name).getBoolean(null);
		} catch (ReflectiveOperationException e) {
			throw new AssertionError("Could not read TestModState." + name, e);
		}
	}

	@Override
	public void runTest(ClientGameTestContext context) {
		context.runOnClient(client -> {
			check(testModFlag("clientSetupFired"), "FMLClientSetupEvent did not reach the test mod");
			check(!testModFlag("dedicatedServerSetupFired"), "FMLDedicatedServerSetupEvent fired on the client");
			check("Test Item".equals(I18n.get("item.steelwool_testmod.test_item")),
					"Lang file from the NeoForge mod jar was not loaded; got " + I18n.get("item.steelwool_testmod.test_item"));
		});

		try (TestSingleplayerContext singleplayer = context.worldBuilder().create()) {
			singleplayer.getConnection().waitForChunksRender();
			singleplayer.getServer().runOnServer(server -> check(server.getRecipeManager()
					.byKey(ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath("steelwool_testmod", "test_item_from_dirt")))
					.isPresent(), "Recipe from the NeoForge mod jar was not loaded in singleplayer"));
			singleplayer.getServer().runCommand("steelwooltest");
			context.takeScreenshot("steelwool-singleplayer");
		}
	}
}
