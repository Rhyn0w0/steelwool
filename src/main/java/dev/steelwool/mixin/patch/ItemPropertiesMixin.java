package dev.steelwool.mixin.patch;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.extensions.IItemPropertiesExtensions;
import org.spongepowered.asm.mixin.Mixin;

/** Makes {@link Item.Properties} implement NeoForge's {@link IItemPropertiesExtensions}. */
@Mixin(Item.Properties.class)
public abstract class ItemPropertiesMixin implements IItemPropertiesExtensions {
}
