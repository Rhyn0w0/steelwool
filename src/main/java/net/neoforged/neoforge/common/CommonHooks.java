package net.neoforged.neoforge.common;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.regex.Pattern;

import com.google.common.graph.Graph;
import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.ChatDecorator;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.SyncedDataHolder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.util.CrudeIncrementalIntIdentityHashBiMap;
import net.minecraft.util.Prediction;
import net.minecraft.util.datafix.fixes.StructuresBecomeConfiguredFix;
import net.minecraft.world.Container;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enderman;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.WorldData;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.event.ItemStackedOnOtherEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.entity.living.LivingSwapItemsEvent;
import net.neoforged.neoforge.event.entity.player.AnvilCraftEvent;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.entity.player.SweepAttackEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
import net.neoforged.neoforge.fluids.FluidType;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

/**
 * SteelWool re-implementation of NeoForge's {@code CommonHooks}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class CommonHooks {
	public static final Comparator<Identifier> CMP_BY_NAMESPACE_VANILLA_FIRST = null /* SteelWool: TODO */;
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static final Marker WORLDPERSISTENCE = null /* SteelWool: TODO */;
	static final Pattern URL_PATTERN = null /* SteelWool: TODO */;
	private static final ThreadLocal<Player> craftingPlayer = null /* SteelWool: TODO */;
	public static final int VANILLA_SERIALIZER_LIMIT = 256;
	private static final Set<String> VANILLA_DIMS = null /* SteelWool: TODO */;
	private static final String DIMENSIONS_KEY = "dimensions";
	private static final String SEED_KEY = "seed";
	private static final Map<EntityType<? extends LivingEntity>, AttributeSupplier> FORGE_ATTRIBUTES = null /* SteelWool: TODO */;
	private static ListTag modList;
	private static final Lazy<Map<String, StructuresBecomeConfiguredFix.Conversion>> FORGE_CONVERSION_MAP = null /* SteelWool: TODO */;
	private static final Set<Class<?>> checkedComponentClasses = null /* SteelWool: TODO */;
	public static final List<RecipeBookType> MODDED_RECIPE_BOOK_TYPES = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, Map<RecipeBookType, RecipeBookSettings.TypeSettings>> MODDED_RECIPE_BOOK_TYPES_SETTINGS_STREAM_CODEC = null /* SteelWool: TODO */;
	private static final Set<Class<?>> EDA_CHECKED_CLASSES = null /* SteelWool: TODO */;
	public static final String ERROR_IGNORES_PAUSING_KEY = "commands.time.neoforge.clock_ignores_pausing";
	private static final DynamicCommandExceptionType ERROR_IGNORES_PAUSING = null /* SteelWool: TODO */;
	private static final String STRUCTURE_ROTATION_KEY = "neoforge:structure_rotation";

	public CommonHooks() {
		super();
	}

	public static boolean canContinueUsing(ItemStack arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.canContinueUsing yet");
	}

	public static ItemStackedOnOtherEvent onItemStackedOn(ItemStack arg0, ItemStack arg1, Slot arg2, ClickAction arg3, Player arg4, SlotAccess arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onItemStackedOn yet");
	}

	public static void onDifficultyChange(Difficulty arg0, Difficulty arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onDifficultyChange yet");
	}

	public static LivingChangeTargetEvent onLivingChangeTarget(LivingEntity arg0, LivingEntity arg1, LivingChangeTargetEvent.ILivingTargetType arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingChangeTarget yet");
	}

	public static boolean isEntityInvulnerableTo(Entity arg0, DamageSource arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.isEntityInvulnerableTo yet");
	}

	public static boolean onEntityIncomingDamage(LivingEntity arg0, DamageContainer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onEntityIncomingDamage yet");
	}

	public static LivingKnockBackEvent onLivingKnockBack(LivingEntity arg0, float arg1, double arg2, double arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingKnockBack yet");
	}

	public static boolean onLivingUseTotem(LivingEntity arg0, DamageSource arg1, ItemStack arg2, InteractionHand arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingUseTotem yet");
	}

	public static float onLivingDamagePre(LivingEntity arg0, DamageContainer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingDamagePre yet");
	}

	public static void onLivingDamagePost(LivingEntity arg0, DamageContainer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingDamagePost yet");
	}

	public static void onArmorHurt(DamageSource arg0, EquipmentSlot[] arg1, float arg2, LivingEntity arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onArmorHurt yet");
	}

	public static boolean onLivingDeath(LivingEntity arg0, DamageSource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingDeath yet");
	}

	public static boolean onLivingDrops(LivingEntity arg0, DamageSource arg1, Collection<ItemEntity> arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingDrops yet");
	}

	public static LivingFallEvent onLivingFall(LivingEntity arg0, double arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingFall yet");
	}

	public static double getEntityVisibilityMultiplier(LivingEntity arg0, Entity arg1, double arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getEntityVisibilityMultiplier yet");
	}

	public static Optional<BlockPos> isLivingOnLadder(BlockState arg0, Level arg1, BlockPos arg2, LivingEntity arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.isLivingOnLadder yet");
	}

	public static void onLivingJump(LivingEntity arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingJump yet");
	}

	public static ItemEntity onPlayerTossEvent(Player arg0, ItemStack arg1, boolean arg2, Prediction arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onPlayerTossEvent yet");
	}

	public static boolean onVanillaGameEvent(Level arg0, Holder<GameEvent> arg1, Vec3 arg2, GameEvent.Context arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onVanillaGameEvent yet");
	}

	private static String getRawText(Component arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getRawText yet");
	}

	public static Component onServerChatSubmittedEvent(ServerPlayer arg0, String arg1, Component arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onServerChatSubmittedEvent yet");
	}

	public static ChatDecorator getServerChatSubmittedDecorator() {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getServerChatSubmittedDecorator yet");
	}

	public static Component newChatWithLinks(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.newChatWithLinks yet");
	}

	public static Component newChatWithLinks(String arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.newChatWithLinks yet");
	}

	public static void handleBlockDrops(ServerLevel arg0, BlockPos arg1, BlockState arg2, BlockEntity arg3, List<ItemEntity> arg4, Entity arg5, ItemStack arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.handleBlockDrops yet");
	}

	public static BreakBlockEvent fireBlockBreak(Level arg0, GameType arg1, Player arg2, BlockPos arg3, BlockState arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.fireBlockBreak yet");
	}

	public static InteractionResult onPlaceItemIntoWorld(UseOnContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onPlaceItemIntoWorld yet");
	}

	public static void onPlayerEnchantItem(Player arg0, ItemStack arg1, List<EnchantmentInstance> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onPlayerEnchantItem yet");
	}

	public static void onAnvilUpdate(AnvilMenu arg0, ItemStack arg1, ItemStack arg2, Container arg3, String arg4, Player arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onAnvilUpdate yet");
	}

	public static AnvilCraftEvent.Pre fireAnvilCraftPre(AnvilMenu arg0, Player arg1, ItemStack arg2, ItemStack arg3, ItemStack arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.fireAnvilCraftPre yet");
	}

	public static void fireAnvilCraftPost(AnvilMenu arg0, Player arg1, ItemStack arg2, ItemStack arg3, ItemStack arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.fireAnvilCraftPost yet");
	}

	public static int onGrindstoneChange(ItemStack arg0, ItemStack arg1, Container arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onGrindstoneChange yet");
	}

	public static boolean onGrindstoneTake(Container arg0, ContainerLevelAccess arg1, Player arg2, Function<Level, Integer> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onGrindstoneTake yet");
	}

	public static void setCraftingPlayer(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.setCraftingPlayer yet");
	}

	public static Player getCraftingPlayer() {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getCraftingPlayer yet");
	}

	public static boolean onPlayerAttackTarget(Player arg0, Entity arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onPlayerAttackTarget yet");
	}

	public static boolean onTravelToDimension(Entity arg0, ResourceKey<Level> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onTravelToDimension yet");
	}

	public static InteractionResult onInteractEntity(Player arg0, Entity arg1, InteractionHand arg2, Vec3 arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onInteractEntity yet");
	}

	public static InteractionResult onItemRightClick(Player arg0, InteractionHand arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onItemRightClick yet");
	}

	public static PlayerInteractEvent.LeftClickBlock onLeftClickBlock(Player arg0, BlockPos arg1, Direction arg2, ServerboundPlayerActionPacket.Action arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLeftClickBlock yet");
	}

	public static PlayerInteractEvent.LeftClickBlock onClientMineHold(Player arg0, BlockPos arg1, Direction arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onClientMineHold yet");
	}

	public static PlayerInteractEvent.RightClickBlock onRightClickBlock(Player arg0, InteractionHand arg1, BlockPos arg2, BlockHitResult arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onRightClickBlock yet");
	}

	public static void onEmptyClick(Player arg0, InteractionHand arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onEmptyClick yet");
	}

	public static void onEmptyLeftClick(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onEmptyLeftClick yet");
	}

	public static GameType onChangeGameType(Player arg0, GameType arg1, GameType arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onChangeGameType yet");
	}

	public static Codec<List<LootPool>> lootPoolsCodec(BiConsumer<LootPool, String> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.lootPoolsCodec yet");
	}

	public static FluidType getVanillaFluidType(Fluid arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getVanillaFluidType yet");
	}

	public static Collection<CreativeModeTab> onCheckCreativeTabs(CreativeModeTab... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onCheckCreativeTabs yet");
	}

	public static boolean canCropGrow(Level arg0, BlockPos arg1, BlockState arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.canCropGrow yet");
	}

	public static void fireCropGrowPost(Level arg0, BlockPos arg1, BlockState arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.fireCropGrowPost yet");
	}

	public static CriticalHitEvent fireCriticalHit(Player arg0, Entity arg1, boolean arg2, float arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.fireCriticalHit yet");
	}

	public static SweepAttackEvent fireSweepAttack(Player arg0, Entity arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.fireSweepAttack yet");
	}

	public static ItemAttributeModifiers computeModifiedAttributes(ItemStack arg0, ItemAttributeModifiers arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.computeModifiedAttributes yet");
	}

	public static ItemStack getProjectile(LivingEntity arg0, ItemStack arg1, ItemStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getProjectile yet");
	}

	public static String getDefaultCreatorModId(HolderLookup.Provider arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getDefaultCreatorModId yet");
	}

	public static boolean onFarmlandTrample(ServerLevel arg0, BlockPos arg1, BlockState arg2, double arg3, Entity arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onFarmlandTrample yet");
	}

	public static int onNoteChange(Level arg0, BlockPos arg1, BlockState arg2, int arg3, int arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onNoteChange yet");
	}

	public static EntityDataSerializer<?> getSerializer(int arg0, CrudeIncrementalIntIdentityHashBiMap<EntityDataSerializer<?>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getSerializer yet");
	}

	public static int getSerializerId(EntityDataSerializer<?> arg0, CrudeIncrementalIntIdentityHashBiMap<EntityDataSerializer<?>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getSerializerId yet");
	}

	public static boolean canEntityDestroy(ServerLevel arg0, BlockPos arg1, LivingEntity arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.canEntityDestroy yet");
	}

	public static List<ItemStack> modifyLoot(List<ItemStack> arg0, LootContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.modifyLoot yet");
	}

	public static ObjectArrayList<ItemStack> modifyLoot(Identifier arg0, ObjectArrayList<ItemStack> arg1, LootContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.modifyLoot yet");
	}

	public static List<String> getModDataPacks() {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getModDataPacks yet");
	}

	public static List<String> getModDataPacksWithVanilla() {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getModDataPacksWithVanilla yet");
	}

	public static Map<EntityType<? extends LivingEntity>, AttributeSupplier> getAttributesView() {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getAttributesView yet");
	}

	public static void modifyAttributes() {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.modifyAttributes yet");
	}

	public static void onEntityEnterSection(Entity arg0, long arg1, long arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onEntityEnterSection yet");
	}

	public static LivingShieldBlockEvent onDamageBlock(LivingEntity arg0, DamageContainer arg1, float arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onDamageBlock yet");
	}

	public static LivingSwapItemsEvent.Hands onLivingSwapHandItems(LivingEntity arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingSwapHandItems yet");
	}

	public static void writeAdditionalLevelSaveData(WorldData arg0, CompoundTag arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.writeAdditionalLevelSaveData yet");
	}

	public static void readAdditionalLevelSaveData(CompoundTag arg0, LevelStorageSource.LevelDirectory arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.readAdditionalLevelSaveData yet");
	}

	public static String encodeLifecycle(Lifecycle arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.encodeLifecycle yet");
	}

	public static Lifecycle parseLifecycle(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.parseLifecycle yet");
	}

	public static void saveMobEffect(CompoundTag arg0, String arg1, MobEffect arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.saveMobEffect yet");
	}

	public static MobEffect loadMobEffect(CompoundTag arg0, String arg1, MobEffect arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.loadMobEffect yet");
	}

	public static boolean shouldSuppressEnderManAnger(Enderman arg0, Player arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.shouldSuppressEnderManAnger yet");
	}

	public static StructuresBecomeConfiguredFix.Conversion getStructureConversion(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getStructureConversion yet");
	}

	public static boolean checkStructureNamespace(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.checkStructureNamespace yet");
	}

	public static String prefixNamespace(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.prefixNamespace yet");
	}

	public static boolean canUseEntitySelectors(SharedSuggestionProvider arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.canUseEntitySelectors yet");
	}

	public static void onLivingBreathe(LivingEntity arg0, ServerLevel arg1, int arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onLivingBreathe yet");
	}

	public static void markComponentClassAsValid(Class<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.markComponentClassAsValid yet");
	}

	public static void validateComponent(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.validateComponent yet");
	}

	private static boolean isPotentialRegistryObject(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.isPotentialRegistryObject yet");
	}

	private static boolean overridesEqualsAndHashCode(Class<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.overridesEqualsAndHashCode yet");
	}

	public static void onChunkUnload(PoiManager arg0, ChunkAccess arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onChunkUnload yet");
	}

	public static boolean canMobEffectBeApplied(LivingEntity arg0, MobEffectInstance arg1, Entity arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.canMobEffectBeApplied yet");
	}

	public static <T extends Object> HolderLookup.RegistryLookup<T> resolveLookup(ResourceKey<? extends Registry<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.resolveLookup yet");
	}

	public static HolderLookup.Provider extractLookupProvider(RegistryOps<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.extractLookupProvider yet");
	}

	public static UseOnContext dispenseUseOnContext(BlockSource arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.dispenseUseOnContext yet");
	}

	public static boolean tryDispenseShearsHarvestBlock(BlockSource arg0, ItemStack arg1, ServerLevel arg2, BlockPos arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.tryDispenseShearsHarvestBlock yet");
	}

	public static MapCodec<Map<RecipeBookType, RecipeBookSettings.TypeSettings>> makeModdedRecipeBookTypesSettingsCodec() {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.makeModdedRecipeBookTypesSettingsCodec yet");
	}

	public static void sendRecipes(ServerPlayer arg0, Set<RecipeType<?>> arg1, RecipeMap arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.sendRecipes yet");
	}

	public static void verifyEntityDataAccessorRegistration(Class<?> arg0, Class<? extends SyncedDataHolder> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.verifyEntityDataAccessorRegistration yet");
	}

	public static void throwIfIgnoresPausing(Holder<WorldClock> arg0) throws CommandSyntaxException {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.throwIfIgnoresPausing yet");
	}

	public static CompoundTag captureStructureRotation(CompoundTag arg0, Rotation arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.captureStructureRotation yet");
	}

	public static void applyStructureRotation(BlockEntity arg0, CompoundTag arg1, StructurePlaceSettings arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.applyStructureRotation yet");
	}

	public static boolean onCustomClickAction(ServerPlayer arg0, GameProfile arg1, Identifier arg2, Optional<Tag> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.onCustomClickAction yet");
	}

	public static <T extends Object> List<T> sortGraphChecked(Graph<T> arg0, Collection<T> arg1, String arg2, Function<T, ?> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.sortGraphChecked yet");
	}

	public static StreamCodec<RegistryFriendlyByteBuf, ItemAttributeModifiers> makeItemAttributesStreamCodec(StreamCodec<RegistryFriendlyByteBuf, List<ItemAttributeModifiers.Entry>> arg0, Function<ItemAttributeModifiers, List<ItemAttributeModifiers.Entry>> arg1, Function<List<ItemAttributeModifiers.Entry>, ItemAttributeModifiers> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.makeItemAttributesStreamCodec yet");
	}

	public static String getDimensionDescriptionKey(ResourceKey<Level> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getDimensionDescriptionKey yet");
	}

	public static Component getDimensionDescription(ResourceKey<Level> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.getDimensionDescription yet");
	}

	public static List<StructureTemplate.StructureEntityInfo> processStructureEntityInfos(StructureTemplate arg0, LevelAccessor arg1, BlockPos arg2, StructurePlaceSettings arg3, List<StructureTemplate.StructureEntityInfo> arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonHooks.processStructureEntityInfos yet");
	}

	public interface BiomeCallbackFunction {
		Biome apply(Biome.ClimateSettings arg0, BiomeSpecialEffects arg1, BiomeGenerationSettings arg2, MobSpawnSettings arg3);
	}
}
