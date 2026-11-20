package dev.steelwool.mixin;

import java.util.function.Consumer;

import dev.steelwool.resource.NeoForgeModPacks;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.BuiltInPackSource;
import net.minecraft.server.packs.repository.Pack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Adds each NeoForge mod jar as a built-in pack: its {@code data/} to server data packs
 * ({@code ServerPacksSource}) and its {@code assets/} to client resource packs ({@code ClientPackSource}).
 */
@Mixin(BuiltInPackSource.class)
public abstract class BuiltInPackSourceMixin {
	@Shadow
	@Final
	private PackType packType;

	@Inject(method = "loadPacks", at = @At("RETURN"))
	private void steelwool$addNeoForgeModPacks(Consumer<Pack> consumer, CallbackInfo ci) {
		NeoForgeModPacks.loadPacks(packType, consumer);
	}
}
