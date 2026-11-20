package dev.steelwool.bridge;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityLevelChangeEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLevelEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.networking.v1.EntityTrackingEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityLeaveLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.ChunkEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;

/**
 * Posts NeoForge's common gameplay events on {@link NeoForge#EVENT_BUS} from Fabric API callbacks.
 * Where the Fabric callback can veto the action, canceling the NeoForge event does too.
 *
 * <p>Known differences from NeoForge: {@link EntityJoinLevelEvent} fires after the entity was added (so
 * canceling it has no effect), {@link OnDatapackSyncEvent} fires once per player on a reload, and
 * {@code useBlock}/{@code useItem} results of the interaction events are not applied, only cancellation.
 */
public final class GameplayEventBridge {
	private GameplayEventBridge() {
	}

	public static void register() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
				NeoForge.EVENT_BUS.post(new PlayerEvent.PlayerLoggedInEvent(handler.player)));
		ServerPlayConnectionEvents.DISCONNECT.register((handler, server) ->
				NeoForge.EVENT_BUS.post(new PlayerEvent.PlayerLoggedOutEvent(handler.player)));
		ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) ->
				NeoForge.EVENT_BUS.post(new PlayerEvent.Clone(newPlayer, oldPlayer, !alive)));
		ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) ->
				NeoForge.EVENT_BUS.post(new PlayerEvent.PlayerRespawnEvent(newPlayer, alive)));
		ServerEntityLevelChangeEvents.AFTER_PLAYER_CHANGE_LEVEL.register((player, origin, destination) ->
				NeoForge.EVENT_BUS.post(new PlayerEvent.PlayerChangedDimensionEvent(player, origin.dimension(), destination.dimension())));
		EntityTrackingEvents.START_TRACKING.register((entity, player) ->
				NeoForge.EVENT_BUS.post(new PlayerEvent.StartTracking(player, entity)));
		EntityTrackingEvents.STOP_TRACKING.register((entity, player) ->
				NeoForge.EVENT_BUS.post(new PlayerEvent.StopTracking(player, entity)));

		ServerLevelEvents.LOAD.register((server, level) -> NeoForge.EVENT_BUS.post(new LevelEvent.Load(level)));
		ServerLevelEvents.UNLOAD.register((server, level) -> NeoForge.EVENT_BUS.post(new LevelEvent.Unload(level)));
		ServerChunkEvents.CHUNK_LOAD.register((level, chunk, generated) -> NeoForge.EVENT_BUS.post(new ChunkEvent.Load(chunk, generated)));
		ServerChunkEvents.CHUNK_UNLOAD.register((level, chunk) -> NeoForge.EVENT_BUS.post(new ChunkEvent.Unload(chunk)));
		ServerEntityEvents.ENTITY_LOAD.register((entity, level) -> NeoForge.EVENT_BUS.post(new EntityJoinLevelEvent(entity, level)));
		ServerEntityEvents.ENTITY_UNLOAD.register((entity, level) -> NeoForge.EVENT_BUS.post(new EntityLeaveLevelEvent(entity, level)));

		ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player, joined) ->
				NeoForge.EVENT_BUS.post(new OnDatapackSyncEvent(player.level().getServer().getPlayerList(), player)));

		PlayerBlockBreakEvents.BEFORE.register((level, player, pos, state, blockEntity) ->
				!NeoForge.EVENT_BUS.post(new BreakBlockEvent(level, pos, state, player)).isCanceled());
		ServerLivingEntityEvents.ALLOW_DEATH.register((entity, source, amount) ->
				!NeoForge.EVENT_BUS.post(new LivingDeathEvent(entity, source)).isCanceled());

		UseBlockCallback.EVENT.register((player, level, hand, hit) -> {
			PlayerInteractEvent.RightClickBlock event = NeoForge.EVENT_BUS.post(new PlayerInteractEvent.RightClickBlock(player, hand, hit.getBlockPos(), hit));
			return event.isCanceled() ? cancelResult(event.getCancellationResult()) : InteractionResult.PASS;
		});
		AttackBlockCallback.EVENT.register((player, level, hand, pos, direction) -> {
			var event = NeoForge.EVENT_BUS.post(new PlayerInteractEvent.LeftClickBlock(player, pos, direction, PlayerInteractEvent.LeftClickBlock.Action.START));
			return event.isCanceled() ? InteractionResult.FAIL : InteractionResult.PASS;
		});
		UseItemCallback.EVENT.register((player, level, hand) -> {
			PlayerInteractEvent.RightClickItem event = NeoForge.EVENT_BUS.post(new PlayerInteractEvent.RightClickItem(player, hand));
			return event.isCanceled() ? cancelResult(event.getCancellationResult()) : InteractionResult.PASS;
		});
		UseEntityCallback.EVENT.register((player, level, hand, entity, hit) -> {
			Vec3 location = hit != null ? hit.getLocation() : entity.position();
			PlayerInteractEvent.EntityInteract event = NeoForge.EVENT_BUS.post(new PlayerInteractEvent.EntityInteract(player, hand, entity, location));
			return event.isCanceled() ? cancelResult(event.getCancellationResult()) : InteractionResult.PASS;
		});
		AttackEntityCallback.EVENT.register((player, level, hand, entity, hit) ->
				NeoForge.EVENT_BUS.post(new AttackEntityEvent(player, entity)).isCanceled() ? InteractionResult.FAIL : InteractionResult.PASS);
	}

	/** A canceled NeoForge interaction returns its cancellation result; Fabric treats PASS as "not handled", so map it to FAIL. */
	private static InteractionResult cancelResult(InteractionResult result) {
		return result == InteractionResult.PASS ? InteractionResult.FAIL : result;
	}
}
