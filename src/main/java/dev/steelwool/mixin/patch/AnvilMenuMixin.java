package dev.steelwool.mixin.patch;

import net.minecraft.world.inventory.AnvilMenu;
import org.spongepowered.asm.mixin.Mixin;

/** Target for NeoForge's {@code createResultInternal()}, a copy of {@code createResult()} made by {@code SteelWoolMixinPlugin} (applied first so it exists for other mods' mixins). */
@Mixin(value = AnvilMenu.class, priority = 1)
public abstract class AnvilMenuMixin {
}
