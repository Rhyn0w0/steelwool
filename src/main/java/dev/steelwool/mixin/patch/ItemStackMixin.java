package dev.steelwool.mixin.patch;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.extensions.IItemStackExtension;
import org.spongepowered.asm.mixin.Mixin;

/** Makes {@link ItemStack} implement NeoForge's {@link IItemStackExtension} (capability lookups). */
@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements IItemStackExtension {
}
