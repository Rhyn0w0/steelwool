package net.neoforged.neoforge.capabilities;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

/** A capability that item stacks can provide. */
public final class ItemCapability<T, C> extends BaseCapability<T, C> {
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static final CapabilityRegistry<ItemCapability<?, ?>> registry = new CapabilityRegistry<>(ItemCapability::new);

	final Map<Item, List<ICapabilityProvider<ItemStack, C, T>>> providers = new IdentityHashMap<>();

	@SuppressWarnings("unchecked")
	public static <T, C> ItemCapability<T, C> create(Identifier name, Class<T> typeClass, Class<C> contextClass) {
		return (ItemCapability<T, C>) registry.create(name, typeClass, contextClass);
	}

	public static <T> ItemCapability<T, Void> createVoid(Identifier name, Class<T> typeClass) {
		return create(name, typeClass, Void.class);
	}

	public static synchronized List<ItemCapability<?, ?>> getAll() {
		return registry.getAll();
	}

	private ItemCapability(Identifier name, Class<T> typeClass, Class<C> contextClass) {
		super(name, typeClass, contextClass);
	}

	public @Nullable T getCapability(ItemStack stack, C context) {
		if (stack.isEmpty()) {
			return null;
		}

		List<ICapabilityProvider<ItemStack, C, T>> list = providers.get(stack.getItem());
		if (list == null) {
			return null;
		}

		for (ICapabilityProvider<ItemStack, C, T> provider : list) {
			T capability = provider.getCapability(stack, context);
			if (capability != null) {
				return capability;
			}
		}

		return null;
	}
}
