package dev.steelwool.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.MinecraftServer;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Starts the server thread in FML's {@link SidedThreadGroups#SERVER} group, as NeoForge does. */
@Mixin(MinecraftServer.class)
public abstract class MinecraftServerThreadMixin {
	@WrapOperation(method = "spin", at = @At(value = "NEW", target = "(Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;"))
	private static Thread steelwool$serverThreadGroup(Runnable runnable, String name, Operation<Thread> original) {
		return new Thread(SidedThreadGroups.SERVER, runnable, name);
	}
}
