package net.neoforged.neoforge.common;

import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.advancements.predicates.entity.EntitySubPredicate;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.commands.synchronization.SingletonArgumentInfo;
import net.minecraft.core.Holder;
import net.minecraft.core.component.predicates.DataComponentPredicate;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.TicketType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.attribute.AttributeType;
import net.minecraft.world.attribute.EnvironmentAttribute;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.common.advancements.critereon.ItemAbilityPredicate;
import net.neoforged.neoforge.common.advancements.critereon.PiglinCurrencyItemPredicate;
import net.neoforged.neoforge.common.advancements.critereon.PiglinNeutralArmorEntityPredicate;
import net.neoforged.neoforge.common.advancements.critereon.SnowBootsEntityPredicate;
import net.neoforged.neoforge.common.advancements.critereon.TridentEntityPredicate;
import net.neoforged.neoforge.common.conditions.AlwaysCondition;
import net.neoforged.neoforge.common.conditions.AndCondition;
import net.neoforged.neoforge.common.conditions.FeatureFlagsEnabledCondition;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NeverCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.conditions.OrCondition;
import net.neoforged.neoforge.common.conditions.RegisteredCondition;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;
import net.neoforged.neoforge.common.crafting.BlockTagIngredient;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.neoforge.common.crafting.CustomDisplayIngredient;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;
import net.neoforged.neoforge.common.crafting.IngredientType;
import net.neoforged.neoforge.common.crafting.IntersectionIngredient;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.common.world.StructureModifier;
import net.neoforged.neoforge.common.world.StructureModifiers;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.crafting.CompoundFluidIngredient;
import net.neoforged.neoforge.fluids.crafting.CustomDisplayFluidIngredient;
import net.neoforged.neoforge.fluids.crafting.DataComponentFluidIngredient;
import net.neoforged.neoforge.fluids.crafting.DifferenceFluidIngredient;
import net.neoforged.neoforge.fluids.crafting.FluidIngredientType;
import net.neoforged.neoforge.fluids.crafting.IntersectionFluidIngredient;
import net.neoforged.neoforge.fluids.crafting.SimpleFluidIngredient;
import net.neoforged.neoforge.fluids.crafting.display.FluidSlotDisplay;
import net.neoforged.neoforge.fluids.crafting.display.FluidStackSlotDisplay;
import net.neoforged.neoforge.fluids.crafting.display.FluidTagSlotDisplay;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.holdersets.HolderSetType;
import net.neoforged.neoforge.server.command.ModIdArgument;
import net.neoforged.neoforge.server.permission.events.PermissionGatherEvent;
import net.neoforged.neoforge.server.permission.nodes.PermissionNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

/**
 * SteelWool re-implementation of NeoForge's {@code NeoForgeMod}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class NeoForgeMod {
	public static final String MOD_ID = "neoforge";
	public static final String VERSION_CHECK_CAT = "version_checking";
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Marker NEOFORGEMOD = null /* SteelWool: TODO */;
	private static final DeferredRegister<Attribute> ATTRIBUTES = null /* SteelWool: TODO */;
	private static final DeferredRegister<ArgumentTypeInfo<?, ?>> COMMAND_ARGUMENT_TYPES = null /* SteelWool: TODO */;
	private static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = null /* SteelWool: TODO */;
	private static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = null /* SteelWool: TODO */;
	private static final DeferredRegister<MapCodec<? extends StructureModifier>> STRUCTURE_MODIFIER_SERIALIZERS = null /* SteelWool: TODO */;
	private static final DeferredRegister<HolderSetType> HOLDER_SET_TYPES = null /* SteelWool: TODO */;
	private static final DeferredRegister<AttributeType<?>> ATTRIBUTE_TYPES = null /* SteelWool: TODO */;
	private static final DeferredRegister<EnvironmentAttribute<?>> ENVIRONMENT_ATTRIBUTES = null /* SteelWool: TODO */;
	private static final Holder<ArgumentTypeInfo<?, ?>> ENUM_COMMAND_ARGUMENT_TYPE = null /* SteelWool: TODO */;
	private static final DeferredHolder<ArgumentTypeInfo<?, ?>, SingletonArgumentInfo<ModIdArgument>> MODID_COMMAND_ARGUMENT_TYPE = null /* SteelWool: TODO */;
	public static final Holder<Attribute> SWIM_SPEED = DeferredHolder.create(net.minecraft.core.registries.Registries.ATTRIBUTE, Identifier.fromNamespaceAndPath("neoforge", "swim_speed"));
	public static final Holder<Attribute> CREATIVE_FLIGHT = DeferredHolder.create(net.minecraft.core.registries.Registries.ATTRIBUTE, Identifier.fromNamespaceAndPath("neoforge", "creative_flight"));
	public static final Holder<Attribute> GLIDING_FLIGHT = DeferredHolder.create(net.minecraft.core.registries.Registries.ATTRIBUTE, Identifier.fromNamespaceAndPath("neoforge", "gliding_flight"));
	public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddTableLootModifier>> ADD_TABLE_LOOT_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "add_table"));
	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<BiomeModifiers.AddFeaturesBiomeModifier>> ADD_FEATURES_BIOME_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "add_features"));
	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<BiomeModifiers.RemoveFeaturesBiomeModifier>> REMOVE_FEATURES_BIOME_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "remove_features"));
	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<BiomeModifiers.AddSpawnsBiomeModifier>> ADD_SPAWNS_BIOME_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "add_spawns"));
	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<BiomeModifiers.RemoveSpawnsBiomeModifier>> REMOVE_SPAWNS_BIOME_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "remove_spawns"));
	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<BiomeModifiers.AddCarversBiomeModifier>> ADD_CARVERS_BIOME_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "add_carvers"));
	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<BiomeModifiers.RemoveCarversBiomeModifier>> REMOVE_CARVERS_BIOME_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "remove_carvers"));
	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<BiomeModifiers.AddSpawnCostsBiomeModifier>> ADD_SPAWN_COSTS_BIOME_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "add_spawn_costs"));
	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<BiomeModifiers.RemoveSpawnCostsBiomeModifier>> REMOVE_SPAWN_COSTS_BIOME_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "remove_spawn_costs"));
	public static final DeferredHolder<MapCodec<? extends StructureModifier>, MapCodec<StructureModifiers.AddSpawnsStructureModifier>> ADD_SPAWNS_STRUCTURE_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "add_spawns"));
	public static final DeferredHolder<MapCodec<? extends StructureModifier>, MapCodec<StructureModifiers.RemoveSpawnsStructureModifier>> REMOVE_SPAWNS_STRUCTURE_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "remove_spawns"));
	public static final DeferredHolder<MapCodec<? extends StructureModifier>, MapCodec<StructureModifiers.ClearSpawnsStructureModifier>> CLEAR_SPAWNS_STRUCTURE_MODIFIER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", "clear_spawns"));
	public static final Holder<HolderSetType> ANY_HOLDER_SET = DeferredHolder.create(NeoForgeRegistries.Keys.HOLDER_SET_TYPES, Identifier.fromNamespaceAndPath("neoforge", "any"));
	public static final Holder<HolderSetType> AND_HOLDER_SET = DeferredHolder.create(NeoForgeRegistries.Keys.HOLDER_SET_TYPES, Identifier.fromNamespaceAndPath("neoforge", "and"));
	public static final Holder<HolderSetType> OR_HOLDER_SET = DeferredHolder.create(NeoForgeRegistries.Keys.HOLDER_SET_TYPES, Identifier.fromNamespaceAndPath("neoforge", "or"));
	public static final Holder<HolderSetType> NOT_HOLDER_SET = DeferredHolder.create(NeoForgeRegistries.Keys.HOLDER_SET_TYPES, Identifier.fromNamespaceAndPath("neoforge", "not"));
	private static final DeferredRegister<SlotDisplay.Type<?>> SLOT_DISPLAY_TYPES = null /* SteelWool: TODO */;
	public static final DeferredHolder<SlotDisplay.Type<?>, SlotDisplay.Type<FluidSlotDisplay>> FLUID_SLOT_DISPLAY = DeferredHolder.create(net.minecraft.core.registries.Registries.SLOT_DISPLAY, Identifier.fromNamespaceAndPath("neoforge", "fluid"));
	public static final DeferredHolder<SlotDisplay.Type<?>, SlotDisplay.Type<FluidStackSlotDisplay>> FLUID_STACK_SLOT_DISPLAY = DeferredHolder.create(net.minecraft.core.registries.Registries.SLOT_DISPLAY, Identifier.fromNamespaceAndPath("neoforge", "fluid_stack"));
	public static final DeferredHolder<SlotDisplay.Type<?>, SlotDisplay.Type<FluidTagSlotDisplay>> FLUID_TAG_SLOT_DISPLAY = DeferredHolder.create(net.minecraft.core.registries.Registries.SLOT_DISPLAY, Identifier.fromNamespaceAndPath("neoforge", "fluid_tag"));
	private static final DeferredRegister<IngredientType<?>> INGREDIENT_TYPES = null /* SteelWool: TODO */;
	public static final DeferredHolder<IngredientType<?>, IngredientType<CompoundIngredient>> COMPOUND_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "compound"));
	public static final DeferredHolder<IngredientType<?>, IngredientType<DataComponentIngredient>> DATA_COMPONENT_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "components"));
	public static final DeferredHolder<IngredientType<?>, IngredientType<DifferenceIngredient>> DIFFERENCE_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "difference"));
	public static final DeferredHolder<IngredientType<?>, IngredientType<IntersectionIngredient>> INTERSECTION_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "intersection"));
	public static final DeferredHolder<IngredientType<?>, IngredientType<BlockTagIngredient>> BLOCK_TAG_INGREDIENT = DeferredHolder.create(NeoForgeRegistries.Keys.INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "block_tag"));
	public static final DeferredHolder<IngredientType<?>, IngredientType<CustomDisplayIngredient>> CUSTOM_DISPLAY_INGREDIENT = DeferredHolder.create(NeoForgeRegistries.Keys.INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "custom_display"));
	private static final DeferredRegister<FluidIngredientType<?>> FLUID_INGREDIENT_TYPES = null /* SteelWool: TODO */;
	public static final DeferredHolder<FluidIngredientType<?>, FluidIngredientType<SimpleFluidIngredient>> SIMPLE_FLUID_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "simple"));
	public static final DeferredHolder<FluidIngredientType<?>, FluidIngredientType<CompoundFluidIngredient>> COMPOUND_FLUID_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "compound"));
	public static final DeferredHolder<FluidIngredientType<?>, FluidIngredientType<DataComponentFluidIngredient>> DATA_COMPONENT_FLUID_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "components"));
	public static final DeferredHolder<FluidIngredientType<?>, FluidIngredientType<DifferenceFluidIngredient>> DIFFERENCE_FLUID_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "difference"));
	public static final DeferredHolder<FluidIngredientType<?>, FluidIngredientType<IntersectionFluidIngredient>> INTERSECTION_FLUID_INGREDIENT_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "intersection"));
	public static final DeferredHolder<FluidIngredientType<?>, FluidIngredientType<CustomDisplayFluidIngredient>> CUSTOM_DISPLAY_FLUID_INGREDIENT = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES, Identifier.fromNamespaceAndPath("neoforge", "custom_display"));
	private static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS = null /* SteelWool: TODO */;
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<AndCondition>> AND_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "and"));
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<NeverCondition>> NEVER_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "never"));
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<RegisteredCondition<?>>> REGISTERED_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "registered"));
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ModLoadedCondition>> MOD_LOADED_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "mod_loaded"));
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<NotCondition>> NOT_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "not"));
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<OrCondition>> OR_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "or"));
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<TagEmptyCondition<?>>> TAG_EMPTY_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "tag_empty"));
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<AlwaysCondition>> ALWAYS_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "always"));
	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<FeatureFlagsEnabledCondition>> FEATURE_FLAGS_ENABLED_CONDITION = DeferredHolder.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Identifier.fromNamespaceAndPath("neoforge", "feature_flags_enabled"));
	private static final DeferredRegister<Codec<? extends EntitySubPredicate>> ENTITY_PREDICATE_CODECS = null /* SteelWool: TODO */;
	public static final DeferredHolder<Codec<? extends EntitySubPredicate>, Codec<PiglinNeutralArmorEntityPredicate>> PIGLIN_NEUTRAL_ARMOR_PREDICATE = DeferredHolder.create(net.minecraft.core.registries.Registries.ENTITY_SUB_PREDICATE_TYPE, Identifier.fromNamespaceAndPath("neoforge", "piglin_neutral_armor"));
	public static final DeferredHolder<Codec<? extends EntitySubPredicate>, Codec<SnowBootsEntityPredicate>> SNOW_BOOTS_PREDICATE = DeferredHolder.create(net.minecraft.core.registries.Registries.ENTITY_SUB_PREDICATE_TYPE, Identifier.fromNamespaceAndPath("neoforge", "snow_boots"));
	public static final DeferredHolder<Codec<? extends EntitySubPredicate>, Codec<TridentEntityPredicate>> IS_TRIDENT_PREDICATE = DeferredHolder.create(net.minecraft.core.registries.Registries.ENTITY_SUB_PREDICATE_TYPE, Identifier.fromNamespaceAndPath("neoforge", "is_trident"));
	private static final DeferredRegister<DataComponentPredicate.Type<?>> DATA_COMPONENT_PREDICATE_TYPES = null /* SteelWool: TODO */;
	public static final DeferredHolder<DataComponentPredicate.Type<?>, DataComponentPredicate.Type<ItemAbilityPredicate>> ITEM_ABILITY_PREDICATE = DeferredHolder.create(net.minecraft.core.registries.Registries.DATA_COMPONENT_PREDICATE_TYPE, Identifier.fromNamespaceAndPath("neoforge", "item_ability"));
	public static final DeferredHolder<DataComponentPredicate.Type<?>, DataComponentPredicate.Type<PiglinCurrencyItemPredicate>> PIGLIN_CURRENCY_PREDICATE = DeferredHolder.create(net.minecraft.core.registries.Registries.DATA_COMPONENT_PREDICATE_TYPE, Identifier.fromNamespaceAndPath("neoforge", "piglin_currency"));
	private static final DeferredRegister<TicketType> TICKET_TYPES = null /* SteelWool: TODO */;
	public static final Holder<TicketType> GENERATE_FORCED_TICKET = DeferredHolder.create(net.minecraft.core.registries.Registries.TICKET_TYPE, Identifier.fromNamespaceAndPath("neoforge", "generate_forced"));
	public static final Holder<TicketType> BLOCK_TICKET = DeferredHolder.create(net.minecraft.core.registries.Registries.TICKET_TYPE, Identifier.fromNamespaceAndPath("neoforge", "block"));
	public static final Holder<TicketType> BLOCK_WITH_NATURAL_SPAWNING_TICKET = DeferredHolder.create(net.minecraft.core.registries.Registries.TICKET_TYPE, Identifier.fromNamespaceAndPath("neoforge", "block_with_natural_spawning"));
	public static final Holder<TicketType> ENTITY_TICKET = DeferredHolder.create(net.minecraft.core.registries.Registries.TICKET_TYPE, Identifier.fromNamespaceAndPath("neoforge", "entity"));
	public static final Holder<TicketType> ENTITY_WITH_NATURAL_SPAWNING_TICKET = DeferredHolder.create(net.minecraft.core.registries.Registries.TICKET_TYPE, Identifier.fromNamespaceAndPath("neoforge", "entity_with_natural_spawning"));
	private static final DeferredRegister<FluidType> VANILLA_FLUID_TYPES = null /* SteelWool: TODO */;
	public static final Holder<FluidType> EMPTY_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_TYPES, Identifier.fromNamespaceAndPath("minecraft", "empty"));
	public static final Holder<FluidType> WATER_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_TYPES, Identifier.fromNamespaceAndPath("minecraft", "water"));
	public static final Holder<FluidType> LAVA_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_TYPES, Identifier.fromNamespaceAndPath("minecraft", "lava"));
	private static boolean enableProperFilenameValidation;
	private static boolean enableMilkFluid;
	private static boolean enableMergedAttributeTooltips;
	public static final DeferredHolder<SoundEvent, SoundEvent> BUCKET_EMPTY_MILK = DeferredHolder.create(net.minecraft.core.registries.Registries.SOUND_EVENT, Identifier.withDefaultNamespace("item.bucket.empty_milk"));
	public static final DeferredHolder<SoundEvent, SoundEvent> BUCKET_FILL_MILK = DeferredHolder.create(net.minecraft.core.registries.Registries.SOUND_EVENT, Identifier.withDefaultNamespace("item.bucket.fill_milk"));
	public static final DeferredHolder<FluidType, FluidType> MILK_TYPE = DeferredHolder.create(NeoForgeRegistries.Keys.FLUID_TYPES, Identifier.withDefaultNamespace("milk"));
	public static final DeferredHolder<Fluid, Fluid> MILK = DeferredHolder.create(net.minecraft.core.registries.Registries.FLUID, Identifier.withDefaultNamespace("milk"));
	public static final DeferredHolder<Fluid, Fluid> FLOWING_MILK = DeferredHolder.create(net.minecraft.core.registries.Registries.FLUID, Identifier.withDefaultNamespace("flowing_milk"));
	public static final ResourceKey<DamageType> POISON_DAMAGE = ResourceKey.create(net.minecraft.core.registries.Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, "poison"));
	public static final PermissionNode<Boolean> USE_SELECTORS_PERMISSION = null /* SteelWool: TODO */;
	private static final AttributeModifier GLIDER_COMPONENT_FLIGHT_MODIFIER = null /* SteelWool: TODO */;

	/** Records the request; SteelWool does not register NeoForge's milk fluid yet. */
	public static void enableMilkFluid() {
		enableMilkFluid = true;
	}

	public static void enableMergedAttributeTooltips() {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.enableMergedAttributeTooltips yet");
	}

	public static void enableProperFilenameValidation() {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.enableProperFilenameValidation yet");
	}

	public static boolean getProperFilenameValidation() {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.getProperFilenameValidation yet");
	}

	public static boolean shouldMergeAttributeTooltips() {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.shouldMergeAttributeTooltips yet");
	}

	public NeoForgeMod(IEventBus arg0, Dist arg1, ModContainer arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the NeoForgeMod constructor yet");
	}

	public void preInit(FMLCommonSetupEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.preInit yet");
	}

	public void loadComplete(FMLLoadCompleteEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.loadComplete yet");
	}

	public void serverStopping(ServerStoppingEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.serverStopping yet");
	}

	public void registerFluids(RegisterEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.registerFluids yet");
	}

	public void registerLootData(RegisterEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.registerLootData yet");
	}

	private static void onConfigLoad(ModConfigEvent.Loading arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.onConfigLoad yet");
	}

	private static void onConfigFileChange(ModConfigEvent.Reloading arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.onConfigFileChange yet");
	}

	public void registerPermissionNodes(PermissionGatherEvent.Nodes arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.registerPermissionNodes yet");
	}

	public void onItemAttributeModifiers(ItemAttributeModifierEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeMod.onItemAttributeModifiers yet");
	}
}
