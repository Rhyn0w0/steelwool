package net.neoforged.neoforge.common.util;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.Multimap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.TooltipDisplay;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code AttributeUtil}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AttributeUtil {
	public static final Identifier BASE_ATTACK_DAMAGE_ID = null /* SteelWool: TODO */;
	public static final Identifier BASE_ATTACK_SPEED_ID = null /* SteelWool: TODO */;
	public static final Identifier BASE_ENTITY_REACH_ID = null /* SteelWool: TODO */;
	public static final Identifier FAKE_MERGED_ID = null /* SteelWool: TODO */;
	public static final Comparator<AttributeModifier> ATTRIBUTE_MODIFIER_COMPARATOR = null /* SteelWool: TODO */;
	private static final Logger LOGGER = null /* SteelWool: TODO */;

	public AttributeUtil() {
		super();
	}

	public static void addAttributeTooltips(ItemStack arg0, Consumer<Component> arg1, TooltipDisplay arg2, AttributeTooltipContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement AttributeUtil.addAttributeTooltips yet");
	}

	public static void applyModifierTooltips(ItemStack arg0, Consumer<Component> arg1, AttributeTooltipContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement AttributeUtil.applyModifierTooltips yet");
	}

	public static void applyTextFor(ItemStack arg0, Consumer<Component> arg1, Multimap<Holder<Attribute>, AttributeModifier> arg2, AttributeTooltipContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement AttributeUtil.applyTextFor yet");
	}

	public static void addPotionTooltip(List<Pair<Holder<Attribute>, AttributeModifier>> arg0, Consumer<Component> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement AttributeUtil.addPotionTooltip yet");
	}

	public static Multimap<Holder<Attribute>, AttributeModifier> sortedMap() {
		throw new UnsupportedOperationException("SteelWool does not implement AttributeUtil.sortedMap yet");
	}

	public static Multimap<Holder<Attribute>, AttributeModifier> getSortedModifiers(ItemStack arg0, EquipmentSlotGroup arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement AttributeUtil.getSortedModifiers yet");
	}

	private static MutableComponent listHeader() {
		throw new UnsupportedOperationException("SteelWool does not implement AttributeUtil.listHeader yet");
	}

	static record BaseModifier(AttributeModifier base, List<AttributeModifier> children) {
	}

	static class MergedModifierData {
		double sum;
		boolean isMerged;
		private List<AttributeModifier> children;

		private MergedModifierData() {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the AttributeUtil.MergedModifierData constructor yet");
		}
	}
}
