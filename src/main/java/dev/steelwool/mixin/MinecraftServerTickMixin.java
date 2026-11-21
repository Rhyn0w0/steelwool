package dev.steelwool.mixin;

import java.util.function.BooleanSupplier;

import net.minecraft.server.MinecraftServer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Fires NeoForge's {@link ServerTickEvent}s around each server tick, like NeoForge's patch. */
@Mixin(MinecraftServer.class)
public abstract class MinecraftServerTickMixin {
	@Inject(method = "tickServer", at = @At("HEAD"))
	private void steelwool$preTick(BooleanSupplier hasTime, CallbackInfo ci) {
		NeoForge.EVENT_BUS.post(new ServerTickEvent.Pre(hasTime, (MinecraftServer) (Object) this));
	}

	@Inject(method = "tickServer", at = @At("TAIL"))
	private void steelwool$postTick(BooleanSupplier hasTime, CallbackInfo ci) {
		NeoForge.EVENT_BUS.post(new ServerTickEvent.Post(hasTime, (MinecraftServer) (Object) this));
	}
}
