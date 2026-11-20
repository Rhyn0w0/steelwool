package dev.steelwool.testmod.mixin;

import dev.steelwool.testmod.TestModState;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
	@Inject(method = "runServer", at = @At("HEAD"))
	private void steelwoolTestmod$onRunServer(CallbackInfo ci) {
		TestModState.mixinApplied = true;
	}
}
