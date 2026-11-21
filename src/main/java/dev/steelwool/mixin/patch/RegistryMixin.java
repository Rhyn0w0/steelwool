package dev.steelwool.mixin.patch;

import net.minecraft.core.Registry;
import net.neoforged.neoforge.registries.IRegistryExtension;
import org.spongepowered.asm.mixin.Mixin;

/** Makes every {@link Registry} an {@link IRegistryExtension}, as NeoForge does. */
@Mixin(Registry.class)
public interface RegistryMixin<T> extends IRegistryExtension<T> {
}
