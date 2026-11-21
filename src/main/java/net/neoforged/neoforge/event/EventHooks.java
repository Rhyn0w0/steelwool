package net.neoforged.neoforge.event;

import java.io.File;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.datafixers.util.Either;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.players.NameAndId;
import net.minecraft.server.players.PlayerList;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stat;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.Container;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerExplosion;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.extensions.IOwnedSpawner;
import net.neoforged.neoforge.common.util.BlockSnapshot;
import net.neoforged.neoforge.common.util.ClockAdjustment;
import net.neoforged.neoforge.event.entity.EntityEvent;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.MobSplitEvent;
import net.neoforged.neoforge.event.entity.player.AdvancementEvent;
import net.neoforged.neoforge.event.entity.player.BonemealEvent;
import net.neoforged.neoforge.event.entity.player.FluidTooltipEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerRespawnPositionEvent;
import net.neoforged.neoforge.event.entity.player.PlayerSpawnPhantomsEvent;
import net.neoforged.neoforge.event.level.AlterGroundEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.BlockGrowFeatureEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.resource.ListenerKey;
import org.apache.commons.lang3.mutable.MutableFloat;

/**
 * SteelWool re-implementation of NeoForge's {@code EventHooks}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class EventHooks {
	private static final WeightedList<MobSpawnSettings.SpawnerData> NO_SPAWNS = null /* SteelWool: TODO */;

	public EventHooks() {
		super();
	}

	public static boolean onMultiBlockPlace(Entity arg0, List<BlockSnapshot> arg1, Direction arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onMultiBlockPlace yet");
	}

	public static boolean onBlockPlace(Entity arg0, BlockSnapshot arg1, Direction arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onBlockPlace yet");
	}

	public static BlockEvent.NeighborNotifyEvent onNeighborNotify(Level arg0, BlockPos arg1, BlockState arg2, EnumSet<Direction> arg3, boolean arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onNeighborNotify yet");
	}

	public static boolean doPlayerHarvestCheck(Player arg0, BlockState arg1, BlockGetter arg2, BlockPos arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.doPlayerHarvestCheck yet");
	}

	public static float getBreakSpeed(Player arg0, BlockState arg1, float arg2, BlockPos arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getBreakSpeed yet");
	}

	public static void onPlayerDestroyItem(Player arg0, ItemStack arg1, InteractionHand arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPlayerDestroyItem yet");
	}

	public static boolean checkSpawnPlacements(EntityType<?> arg0, ServerLevelAccessor arg1, EntitySpawnReason arg2, BlockPos arg3, RandomSource arg4, boolean arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.checkSpawnPlacements yet");
	}

	public static boolean checkSpawnPosition(Mob arg0, ServerLevelAccessor arg1, EntitySpawnReason arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.checkSpawnPosition yet");
	}

	public static boolean checkSpawnPositionSpawner(Mob arg0, ServerLevelAccessor arg1, EntitySpawnReason arg2, SpawnData arg3, BaseSpawner arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.checkSpawnPositionSpawner yet");
	}

	public static SpawnGroupData finalizeMobSpawn(Mob arg0, ServerLevelAccessor arg1, DifficultyInstance arg2, EntitySpawnReason arg3, SpawnGroupData arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.finalizeMobSpawn yet");
	}

	public static FinalizeSpawnEvent finalizeMobSpawnSpawner(Mob arg0, ServerLevelAccessor arg1, DifficultyInstance arg2, EntitySpawnReason arg3, SpawnGroupData arg4, IOwnedSpawner arg5, boolean arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.finalizeMobSpawnSpawner yet");
	}

	public static PlayerSpawnPhantomsEvent firePlayerSpawnPhantoms(ServerPlayer arg0, ServerLevel arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerSpawnPhantoms yet");
	}

	public static boolean checkMobDespawn(Mob arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.checkMobDespawn yet");
	}

	public static int getExperienceDrop(LivingEntity arg0, Player arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getExperienceDrop yet");
	}

	public static int getMaxSpawnClusterSize(Mob arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getMaxSpawnClusterSize yet");
	}

	public static Component getPlayerDisplayName(Player arg0, Component arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getPlayerDisplayName yet");
	}

	public static Component getPlayerTabListDisplayName(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getPlayerTabListDisplayName yet");
	}

	public static BlockState fireFluidPlaceBlockEvent(LevelAccessor arg0, BlockPos arg1, BlockPos arg2, BlockState arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireFluidPlaceBlockEvent yet");
	}

	public static ItemTooltipEvent onItemTooltip(ItemStack arg0, Player arg1, List<Component> arg2, TooltipFlag arg3, Item.TooltipContext arg4, TooltipDisplay arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onItemTooltip yet");
	}

	public static FluidTooltipEvent onFluidTooltip(FluidStack arg0, Player arg1, List<Component> arg2, TooltipFlag arg3, Item.TooltipContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onFluidTooltip yet");
	}

	public static boolean onEntityStruckByLightning(Entity arg0, LightningBolt arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEntityStruckByLightning yet");
	}

	public static int onItemUseStart(LivingEntity arg0, ItemStack arg1, InteractionHand arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onItemUseStart yet");
	}

	public static int onItemUseTick(LivingEntity arg0, ItemStack arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onItemUseTick yet");
	}

	public static boolean onUseItemStop(LivingEntity arg0, ItemStack arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onUseItemStop yet");
	}

	public static ItemStack onItemUseFinish(LivingEntity arg0, ItemStack arg1, int arg2, ItemStack arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onItemUseFinish yet");
	}

	public static void onStartEntityTracking(Entity arg0, Player arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onStartEntityTracking yet");
	}

	public static void onStopEntityTracking(Entity arg0, Player arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onStopEntityTracking yet");
	}

	public static void firePlayerLoadingEvent(Player arg0, PlayerList arg1, String arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerLoadingEvent yet");
	}

	public static void firePlayerSavingEvent(Player arg0, File arg1, String arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerSavingEvent yet");
	}

	public static BlockState onToolUse(BlockState arg0, UseOnContext arg1, ItemAbility arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onToolUse yet");
	}

	public static BonemealEvent fireBonemealEvent(Player arg0, Level arg1, BlockPos arg2, BlockState arg3, BonemealSource arg4, ItemStack arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireBonemealEvent yet");
	}

	public static PlayLevelSoundEvent.AtEntity onPlaySoundAtEntity(Entity arg0, Holder<SoundEvent> arg1, SoundSource arg2, float arg3, float arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPlaySoundAtEntity yet");
	}

	public static PlayLevelSoundEvent.AtPosition onPlaySoundAtPosition(Level arg0, double arg1, double arg2, double arg3, Holder<SoundEvent> arg4, SoundSource arg5, float arg6, float arg7) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPlaySoundAtPosition yet");
	}

	public static int onItemExpire(ItemEntity arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onItemExpire yet");
	}

	public static ItemEntityPickupEvent.Pre fireItemPickupPre(ItemEntity arg0, Player arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireItemPickupPre yet");
	}

	public static void fireItemPickupPost(ItemEntity arg0, Player arg1, ItemStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireItemPickupPost yet");
	}

	public static boolean canMountEntity(Entity arg0, Entity arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.canMountEntity yet");
	}

	public static boolean onAnimalTame(Animal arg0, Player arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onAnimalTame yet");
	}

	public static Either<Player.BedSleepingProblem, Unit> canPlayerStartSleeping(ServerPlayer arg0, BlockPos arg1, Either<Player.BedSleepingProblem, Unit> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.canPlayerStartSleeping yet");
	}

	public static void onPlayerWakeup(Player arg0, boolean arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPlayerWakeup yet");
	}

	public static void onPlayerFall(Player arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPlayerFall yet");
	}

	public static boolean onPlayerSpawnSet(Player arg0, ServerPlayer.RespawnConfig arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPlayerSpawnSet yet");
	}

	public static void onPlayerClone(Player arg0, Player arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPlayerClone yet");
	}

	public static boolean onExplosionStart(Level arg0, ServerExplosion arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onExplosionStart yet");
	}

	public static void onExplosionDetonate(Level arg0, ServerExplosion arg1, List<Entity> arg2, List<BlockPos> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onExplosionDetonate yet");
	}

	public static Vec3 getExplosionKnockback(Level arg0, ServerExplosion arg1, Entity arg2, Vec3 arg3, List<BlockPos> arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getExplosionKnockback yet");
	}

	public static boolean onCreateWorldSpawn(Level arg0, ServerLevelData arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onCreateWorldSpawn yet");
	}

	public static float onLivingHeal(LivingEntity arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onLivingHeal yet");
	}

	public static boolean onSwitchHotbarSlotPre(Player arg0, int arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onSwitchHotbarSlotPre yet");
	}

	public static void onSwitchHotbarSlotPost(Player arg0, int arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onSwitchHotbarSlotPost yet");
	}

	public static boolean onPotionAttemptBrew(NonNullList<ItemStack> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPotionAttemptBrew yet");
	}

	public static void onPotionBrewed(NonNullList<ItemStack> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPotionBrewed yet");
	}

	public static void onPlayerBrewedPotion(Player arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPlayerBrewedPotion yet");
	}

	public static boolean canEntityContinueSleeping(LivingEntity arg0, Player.BedSleepingProblem arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.canEntityContinueSleeping yet");
	}

	public static InteractionResult onArrowNock(ItemStack arg0, Level arg1, Player arg2, InteractionHand arg3, boolean arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onArrowNock yet");
	}

	public static int onArrowLoose(ItemStack arg0, Level arg1, Player arg2, int arg3, boolean arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onArrowLoose yet");
	}

	public static int onArrowLoose(ItemStack arg0, Level arg1, Player arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onArrowLoose yet");
	}

	public static boolean onProjectileImpact(Projectile arg0, HitResult arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onProjectileImpact yet");
	}

	public static LootTable loadLootTable(HolderGetter.Provider arg0, Identifier arg1, LootTable arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.loadLootTable yet");
	}

	public static boolean canCreateFluidSource(ServerLevel arg0, BlockPos arg1, BlockState arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.canCreateFluidSource yet");
	}

	public static Optional<PortalShape> onTrySpawnPortal(LevelAccessor arg0, BlockPos arg1, Optional<PortalShape> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onTrySpawnPortal yet");
	}

	public static int onEnchantmentLevelSet(Level arg0, BlockPos arg1, int arg2, int arg3, ItemStack arg4, int arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEnchantmentLevelSet yet");
	}

	public static boolean onEntityDestroyBlock(LivingEntity arg0, BlockPos arg1, BlockState arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEntityDestroyBlock yet");
	}

	public static boolean canEntityGrief(ServerLevel arg0, Entity arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.canEntityGrief yet");
	}

	public static BlockGrowFeatureEvent fireBlockGrowFeature(LevelAccessor arg0, RandomSource arg1, BlockPos arg2, Holder<Feature> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireBlockGrowFeature yet");
	}

	public static AlterGroundEvent.StateProvider alterGround(TreeDecorator.Context arg0, List<BlockPos> arg1, AlterGroundEvent.StateProvider arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.alterGround yet");
	}

	public static void fireChunkTicketLevelUpdated(ServerLevel arg0, long arg1, int arg2, int arg3, ChunkHolder arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireChunkTicketLevelUpdated yet");
	}

	public static void fireChunkWatch(ServerPlayer arg0, LevelChunk arg1, ServerLevel arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireChunkWatch yet");
	}

	public static void fireChunkSent(ServerPlayer arg0, LevelChunk arg1, ServerLevel arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireChunkSent yet");
	}

	public static void fireChunkUnWatch(ServerPlayer arg0, ChunkPos arg1, ServerLevel arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireChunkUnWatch yet");
	}

	public static boolean onPistonMovePre(Level arg0, BlockPos arg1, Direction arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPistonMovePre yet");
	}

	public static void onPistonMovePost(Level arg0, BlockPos arg1, Direction arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPistonMovePost yet");
	}

	public static ClockAdjustment onSleepFinished(ServerLevel arg0, ClockAdjustment arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onSleepFinished yet");
	}

	public static List<PreparableReloadListener> onResourceReload(ReloadableServerResources arg0, Map<ListenerKey<?>, PreparableReloadListener> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onResourceReload yet");
	}

	public static void onCommandRegister(CommandDispatcher<CommandSourceStack> arg0, Commands.CommandSelection arg1, CommandBuildContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onCommandRegister yet");
	}

	public static EntityEvent.Size getEntitySizeForge(Entity arg0, Pose arg1, EntityDimensions arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getEntitySizeForge yet");
	}

	public static EntityEvent.Size getEntitySizeForge(Entity arg0, Pose arg1, EntityDimensions arg2, EntityDimensions arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getEntitySizeForge yet");
	}

	public static boolean canLivingConvert(LivingEntity arg0, EntityType<? extends LivingEntity> arg1, Consumer<Integer> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.canLivingConvert yet");
	}

	public static void onLivingConvert(LivingEntity arg0, LivingEntity arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onLivingConvert yet");
	}

	public static EntityTeleportEvent.TeleportCommand onEntityTeleportCommand(Entity arg0, ServerLevel arg1, double arg2, double arg3, double arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEntityTeleportCommand yet");
	}

	public static EntityTeleportEvent.SpreadPlayersCommand onEntityTeleportSpreadPlayersCommand(Entity arg0, ServerLevel arg1, double arg2, double arg3, double arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEntityTeleportSpreadPlayersCommand yet");
	}

	public static EntityTeleportEvent.EnderEntity onEnderTeleport(LivingEntity arg0, double arg1, double arg2, double arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEnderTeleport yet");
	}

	public static EntityTeleportEvent.EnderPearl onEnderPearlLand(ServerPlayer arg0, double arg1, double arg2, double arg3, ThrownEnderpearl arg4, float arg5, HitResult arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEnderPearlLand yet");
	}

	public static EntityTeleportEvent.ItemConsumption onItemConsumptionTeleport(LivingEntity arg0, ItemStack arg1, double arg2, double arg3, double arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onItemConsumptionTeleport yet");
	}

	public static boolean onPermissionChanged(NameAndId arg0, LevelBasedPermissionSet arg1, PlayerList arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onPermissionChanged yet");
	}

	public static void firePlayerChangedDimensionEvent(Player arg0, ResourceKey<Level> arg1, ResourceKey<Level> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerChangedDimensionEvent yet");
	}

	public static void firePlayerLoggedIn(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerLoggedIn yet");
	}

	public static void firePlayerLoggedOut(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerLoggedOut yet");
	}

	public static PlayerRespawnPositionEvent firePlayerRespawnPositionEvent(ServerPlayer arg0, TeleportTransition arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerRespawnPositionEvent yet");
	}

	public static void firePlayerRespawnEvent(ServerPlayer arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerRespawnEvent yet");
	}

	public static void firePlayerCraftingEvent(Player arg0, ItemStack arg1, Container arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerCraftingEvent yet");
	}

	public static void firePlayerSmeltedEvent(Player arg0, ItemStack arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerSmeltedEvent yet");
	}

	public static void firePlayerSmithedEvent(Player arg0, Container arg1, ItemStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerSmithedEvent yet");
	}

	public static EntityTickEvent.Pre fireEntityTickPre(Entity arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireEntityTickPre yet");
	}

	public static void fireEntityTickPost(Entity arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireEntityTickPost yet");
	}

	public static void firePlayerTickPre(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerTickPre yet");
	}

	public static void firePlayerTickPost(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.firePlayerTickPost yet");
	}

	public static void fireLevelTickPre(Level arg0, BooleanSupplier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireLevelTickPre yet");
	}

	public static void fireLevelTickPost(Level arg0, BooleanSupplier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireLevelTickPost yet");
	}

	public static void fireServerTickPre(BooleanSupplier arg0, MinecraftServer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireServerTickPre yet");
	}

	public static void fireServerTickPost(BooleanSupplier arg0, MinecraftServer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.fireServerTickPost yet");
	}

	public static WeightedList<MobSpawnSettings.SpawnerData> getPotentialSpawns(LevelAccessor arg0, MobCategory arg1, BlockPos arg2, WeightedList<MobSpawnSettings.SpawnerData> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getPotentialSpawns yet");
	}

	public static StatAwardEvent onStatAward(Player arg0, Stat<?> arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onStatAward yet");
	}

	public static void onAdvancementEarnedEvent(Player arg0, AdvancementHolder arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onAdvancementEarnedEvent yet");
	}

	public static void onAdvancementProgressedEvent(Player arg0, AdvancementHolder arg1, AdvancementProgress arg2, String arg3, AdvancementEvent.AdvancementProgressEvent.ProgressType arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onAdvancementProgressedEvent yet");
	}

	public static boolean onEffectRemoved(LivingEntity arg0, Holder<MobEffect> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEffectRemoved yet");
	}

	public static boolean onEffectRemoved(LivingEntity arg0, MobEffectInstance arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEffectRemoved yet");
	}

	public static int getEnchantmentLevelSpecific(int arg0, ItemInstance arg1, Holder<Enchantment> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getEnchantmentLevelSpecific yet");
	}

	public static ItemEnchantments getAllEnchantmentLevels(ItemEnchantments arg0, ItemStack arg1, HolderLookup.RegistryLookup<Enchantment> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getAllEnchantmentLevels yet");
	}

	public static void onCreativeModeTabBuildContents(CreativeModeTab arg0, CreativeModeTab.DisplayItemsGenerator arg1, CreativeModeTab.ItemDisplayParameters arg2, CreativeModeTab.Output arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onCreativeModeTabBuildContents yet");
	}

	public static MobSplitEvent onMobSplit(Mob arg0, List<Mob> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onMobSplit yet");
	}

	public static List<CustomSpawner> getCustomSpawners(ServerLevel arg0, List<CustomSpawner> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getCustomSpawners yet");
	}

	public static <T extends Object> void onGameRuleChanged(MinecraftServer arg0, GameRule<T> arg1, T arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onGameRuleChanged yet");
	}

	public static int getBlockLootEnchantmentLevel(ItemInstance arg0, Holder<Enchantment> arg1, int arg2, LootContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getBlockLootEnchantmentLevel yet");
	}

	public static int getEntityLootEnchantmentLevel(Holder<Enchantment> arg0, int arg1, LootContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.getEntityLootEnchantmentLevel yet");
	}

	public static void onEquipmentDropChance(ServerLevel arg0, LivingEntity arg1, DamageSource arg2, MutableFloat arg3, float arg4, EquipmentSlot arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement EventHooks.onEquipmentDropChance yet");
	}
}
