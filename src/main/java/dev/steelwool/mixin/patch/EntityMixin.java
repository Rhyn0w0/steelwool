package dev.steelwool.mixin.patch;

import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.capabilities.EntityCapability;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

/** Adds NeoForge's {@code Entity.getCapability} methods. */
@Mixin(Entity.class)
public abstract class EntityMixin {
	public final <T, C> @Nullable T getCapability(EntityCapability<T, C> capability, C context) {
		return capability.getCapability((Entity) (Object) this, context);
	}

	public final <T> @Nullable T getCapability(EntityCapability<T, Void> capability) {
		return capability.getCapability((Entity) (Object) this, null);
	}
}
