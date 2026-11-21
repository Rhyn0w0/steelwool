package net.neoforged.neoforge.event;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemAttributeModifierEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ItemAttributeModifierEvent extends Event {
	private final ItemStack stack;
	private final ItemAttributeModifiers defaultModifiers;
	private net.neoforged.neoforge.event.ItemAttributeModifierEvent.ItemAttributeModifiersBuilder builder;

	public ItemAttributeModifierEvent(ItemStack stack, ItemAttributeModifiers defaultModifiers) {
		super();
		this.stack = stack;
		this.defaultModifiers = defaultModifiers;
	}

	public ItemStack getItemStack() {
		return this.stack;
	}

	public ItemAttributeModifiers getDefaultModifiers() {
		return this.defaultModifiers;
	}

	public List<ItemAttributeModifiers.Entry> getModifiers() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.getModifiers yet");
	}

	public boolean addModifier(Holder<Attribute> arg0, AttributeModifier arg1, EquipmentSlotGroup arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.addModifier yet");
	}

	public boolean removeModifier(Holder<Attribute> arg0, Identifier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.removeModifier yet");
	}

	public void replaceModifier(Holder<Attribute> arg0, AttributeModifier arg1, EquipmentSlotGroup arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.replaceModifier yet");
	}

	public boolean removeIf(Predicate<ItemAttributeModifiers.Entry> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.removeIf yet");
	}

	public boolean removeAllModifiersFor(Holder<Attribute> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.removeAllModifiersFor yet");
	}

	public void clearModifiers() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.clearModifiers yet");
	}

	public ItemAttributeModifiers build() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.build yet");
	}

	private net.neoforged.neoforge.event.ItemAttributeModifierEvent.ItemAttributeModifiersBuilder getBuilder() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.getBuilder yet");
	}

	static class ItemAttributeModifiersBuilder {
		private List<ItemAttributeModifiers.Entry> entries;
		private Map<net.neoforged.neoforge.event.ItemAttributeModifierEvent.ItemAttributeModifiersBuilder.Key, ItemAttributeModifiers.Entry> entriesByKey;

		ItemAttributeModifiersBuilder(ItemAttributeModifiers arg0) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the ItemAttributeModifierEvent.ItemAttributeModifiersBuilder constructor yet");
		}

		List<ItemAttributeModifiers.Entry> getEntryView() {
			throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.ItemAttributeModifiersBuilder.getEntryView yet");
		}

		boolean addModifier(Holder<Attribute> arg0, AttributeModifier arg1, EquipmentSlotGroup arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.ItemAttributeModifiersBuilder.addModifier yet");
		}

		boolean removeModifier(Holder<Attribute> arg0, Identifier arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.ItemAttributeModifiersBuilder.removeModifier yet");
		}

		ItemAttributeModifiers.Entry replaceModifier(Holder<Attribute> arg0, AttributeModifier arg1, EquipmentSlotGroup arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.ItemAttributeModifiersBuilder.replaceModifier yet");
		}

		boolean removeIf(Predicate<ItemAttributeModifiers.Entry> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.ItemAttributeModifiersBuilder.removeIf yet");
		}

		void clear() {
			throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.ItemAttributeModifiersBuilder.clear yet");
		}

		public ItemAttributeModifiers build() {
			throw new UnsupportedOperationException("SteelWool does not implement ItemAttributeModifierEvent.ItemAttributeModifiersBuilder.build yet");
		}

		static record Key(Holder<Attribute> attr, Identifier id) {
		}
	}
}
