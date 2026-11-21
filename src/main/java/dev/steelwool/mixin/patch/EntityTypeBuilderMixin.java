package dev.steelwool.mixin.patch;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * NeoForge's extra {@link EntityType.Builder} setters. Tracking range and update interval map to
 * vanilla's settings; the velocity-update and "only op can set NBT" flags are accepted but not used.
 */
@Mixin(EntityType.Builder.class)
public abstract class EntityTypeBuilderMixin<T extends Entity> {
	@Shadow
	public abstract EntityType.Builder<T> clientTrackingRange(int range);

	@Shadow
	public abstract EntityType.Builder<T> updateInterval(int interval);

	public EntityType.Builder<T> setTrackingRange(int range) {
		return clientTrackingRange(range);
	}

	public EntityType.Builder<T> setUpdateInterval(int interval) {
		return updateInterval(interval);
	}

	@SuppressWarnings("unchecked")
	public EntityType.Builder<T> setShouldReceiveVelocityUpdates(boolean value) {
		return (EntityType.Builder<T>) (Object) this;
	}

	@SuppressWarnings("unchecked")
	public EntityType.Builder<T> setOnlyOpCanSetNbt(boolean value) {
		return (EntityType.Builder<T>) (Object) this;
	}
}
