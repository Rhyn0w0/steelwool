package dev.steelwool.mixin;

import java.util.function.BooleanSupplier;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Fires NeoForge's {@link LevelTickEvent}s around each server level tick and {@link EntityTickEvent}s
 * around each (non-passenger) entity tick; a canceled {@code EntityTickEvent.Pre} skips the entity's tick.
 */
@Mixin(ServerLevel.class)
public abstract class ServerLevelTickMixin {
	@Inject(method = "tick(Ljava/util/function/BooleanSupplier;)V", at = @At("HEAD"))
	private void steelwool$preTick(BooleanSupplier hasTime, CallbackInfo ci) {
		NeoForge.EVENT_BUS.post(new LevelTickEvent.Pre(hasTime, (ServerLevel) (Object) this));
	}

	@Inject(method = "tick(Ljava/util/function/BooleanSupplier;)V", at = @At("TAIL"))
	private void steelwool$postTick(BooleanSupplier hasTime, CallbackInfo ci) {
		NeoForge.EVENT_BUS.post(new LevelTickEvent.Post(hasTime, (ServerLevel) (Object) this));
	}

	@Inject(method = "tickNonPassenger", at = @At("HEAD"), cancellable = true)
	private void steelwool$preEntityTick(Entity entity, CallbackInfo ci) {
		if (NeoForge.EVENT_BUS.post(new EntityTickEvent.Pre(entity)).isCanceled()) {
			ci.cancel();
		}
	}

	@Inject(method = "tickNonPassenger", at = @At("TAIL"))
	private void steelwool$postEntityTick(Entity entity, CallbackInfo ci) {
		NeoForge.EVENT_BUS.post(new EntityTickEvent.Post(entity));
	}
}
