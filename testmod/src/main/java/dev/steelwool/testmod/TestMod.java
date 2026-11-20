package dev.steelwool.testmod;

import com.mojang.brigadier.Command;
import com.mojang.logging.LogUtils;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

/**
 * A NeoForge mod used to test SteelWool. It follows NeoForge's example mod (MDK) and adds a
 * command, a recipe and a mixin. It is compiled against the real NeoForge API.
 */
@Mod(TestMod.MODID)
public class TestMod {
	public static final String MODID = "steelwool_testmod";
	public static final Logger LOGGER = LogUtils.getLogger();

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

	public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.registerSimpleBlock("test_block", p -> p.mapColor(MapColor.STONE));
	public static final DeferredItem<BlockItem> TEST_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("test_block", TEST_BLOCK);
	public static final DeferredItem<Item> TEST_ITEM = ITEMS.registerSimpleItem("test_item", p -> p.food(new FoodProperties.Builder()
			.alwaysEdible().nutrition(1).saturationModifier(2f).build()));

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.steelwool_testmod"))
			.withTabsBefore(CreativeModeTabs.COMBAT)
			.icon(() -> TEST_ITEM.get().getDefaultInstance())
			.displayItems((parameters, output) -> output.accept(TEST_ITEM.get()))
			.build());

	public TestMod(IEventBus modEventBus, ModContainer modContainer) {
		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(FMLConstructModEvent.class, event -> TestModState.constructEventFired = true);
		modEventBus.addListener(ModConfigEvent.Loading.class, event -> {
			if (event.getConfig().getModId().equals(MODID)) {
				TestModState.configLoadingEventFired = true;
			}
		});

		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		CREATIVE_MODE_TABS.register(modEventBus);

		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::addCreative);
		modContainer.registerConfig(ModConfig.Type.LOCAL, TestModConfig.SPEC);

		TestModState.constructed = true;
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		LOGGER.info("HELLO FROM COMMON SETUP");

		if (TestModConfig.LOG_DIRT_BLOCK.getAsBoolean()) {
			LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
		}

		LOGGER.info("{}{}", TestModConfig.MAGIC_NUMBER_INTRODUCTION.get(), TestModConfig.MAGIC_NUMBER.getAsInt());
		TestModConfig.ITEM_STRINGS.get().forEach(item -> LOGGER.info("ITEM >> {}", item));

		TestModState.magicNumberAtCommonSetup = TestModConfig.MAGIC_NUMBER.getAsInt();
		TestModState.commonSetupFired = true;
		event.enqueueWork(() -> TestModState.deferredWorkRan = true);
	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		TestModState.creativeTabEventFired = true;

		if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			event.accept(TEST_BLOCK_ITEM);
		}
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		LOGGER.info("HELLO from server starting");
		TestModState.serverStartingFired = true;
	}

	@SubscribeEvent
	public void onRegisterCommands(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("steelwooltest").executes(context -> {
			context.getSource().sendSuccess(() -> Component.literal("Hello from a NeoForge mod running on Fabric!"), false);
			return Command.SINGLE_SUCCESS;
		}));
	}
}
