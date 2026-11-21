package dev.steelwool.mixin;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Fires NeoForge's {@link PlayerTickEvent}s around each player tick, on both sides. */
@Mixin(Player.class)
public abstract class PlayerTickMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void steelwool$preTick(CallbackInfo ci) {
		NeoForge.EVENT_BUS.post(new PlayerTickEvent.Pre((Player) (Object) this));
	}

	@Inject(method = "tick", at = @At("TAIL"))
	private void steelwool$postTick(CallbackInfo ci) {
		NeoForge.EVENT_BUS.post(new PlayerTickEvent.Post((Player) (Object) this));
	}
}
