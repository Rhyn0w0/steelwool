package net.neoforged.neoforge.capabilities;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.jspecify.annotations.Nullable;

/** A capability that entities can provide. */
public final class EntityCapability<T, C> extends BaseCapability<T, C> {
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static final CapabilityRegistry<EntityCapability<?, ?>> registry = new CapabilityRegistry<>(EntityCapability::new);

	final Map<EntityType<?>, List<ICapabilityProvider<Entity, C, T>>> providers = new IdentityHashMap<>();

	@SuppressWarnings("unchecked")
	public static <T, C> EntityCapability<T, C> create(Identifier name, Class<T> typeClass, Class<C> contextClass) {
		return (EntityCapability<T, C>) registry.create(name, typeClass, contextClass);
	}

	public static <T> EntityCapability<T, Void> createVoid(Identifier name, Class<T> typeClass) {
		return create(name, typeClass, Void.class);
	}

	public static <T> EntityCapability<T, Direction> createSided(Identifier name, Class<T> typeClass) {
		return create(name, typeClass, Direction.class);
	}

	public static synchronized List<EntityCapability<?, ?>> getAll() {
		return registry.getAll();
	}

	private EntityCapability(Identifier name, Class<T> typeClass, Class<C> contextClass) {
		super(name, typeClass, contextClass);
	}

	public @Nullable T getCapability(Entity entity, C context) {
		List<ICapabilityProvider<Entity, C, T>> list = providers.get(entity.getType());
		if (list == null) {
			return null;
		}

		for (ICapabilityProvider<Entity, C, T> provider : list) {
			T capability = provider.getCapability(entity, context);
			if (capability != null) {
				return capability;
			}
		}

		return null;
	}
}
