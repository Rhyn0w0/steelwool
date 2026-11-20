package dev.steelwool.mixin.patch;

import java.util.Collection;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * NeoForge's additions to {@code CreativeModeTab.Builder}.
 *
 * <p>Tab ordering ({@code withTabsBefore} / {@code withTabsAfter}) and the visual options (search
 * bar, label colour, scroll bar sprite) are accepted but not applied yet: tabs appear in Fabric's
 * paged creative inventory in registration order.
 */
@Mixin(CreativeModeTab.Builder.class)
public abstract class CreativeModeTabBuilderMixin {
	@Shadow
	public abstract CreativeModeTab.Builder displayItems(CreativeModeTab.DisplayItemsGenerator generator);

	private CreativeModeTab.Builder steelwool$self() {
		return (CreativeModeTab.Builder) (Object) this;
	}

	@SafeVarargs
	public final CreativeModeTab.Builder withTabsBefore(ResourceKey<CreativeModeTab>... tabs) {
		return steelwool$self();
	}

	@SafeVarargs
	public final CreativeModeTab.Builder withTabsAfter(ResourceKey<CreativeModeTab>... tabs) {
		return steelwool$self();
	}

	public CreativeModeTab.Builder withTabsBefore(Identifier... tabs) {
		return steelwool$self();
	}

	public CreativeModeTab.Builder withTabsAfter(Identifier... tabs) {
		return steelwool$self();
	}

	public CreativeModeTab.Builder withSearchBar() {
		return steelwool$self();
	}

	public CreativeModeTab.Builder withSearchBar(int searchBarWidth) {
		return steelwool$self();
	}

	public CreativeModeTab.Builder withLabelColor(int labelColor) {
		return steelwool$self();
	}

	public CreativeModeTab.Builder withScrollBarSpriteLocation(Identifier scrollBarSpriteLocation) {
		return steelwool$self();
	}

	public CreativeModeTab.Builder displayItems(Collection<ItemStack> items) {
		return displayItems((parameters, output) -> output.acceptAll(items));
	}
}
