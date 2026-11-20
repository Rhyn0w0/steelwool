package net.neoforged.neoforge.event;

import java.util.List;
import java.util.function.Predicate;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * Fired on each mod bus when a creative tab's contents are built, so mods can add items to any tab.
 * Backed by Fabric API's {@code CreativeModeTabEvents.MODIFY_OUTPUT_ALL}.
 *
 * <p>Not yet supported: {@code getParentEntries()} / {@code getSearchEntries()}.
 */
public final class BuildCreativeModeTabContentsEvent extends Event implements IModBusEvent, CreativeModeTab.Output {
	private final CreativeModeTab tab;
	private final ResourceKey<CreativeModeTab> tabKey;
	private final FabricCreativeModeTabOutput output;

	public BuildCreativeModeTabContentsEvent(CreativeModeTab tab, ResourceKey<CreativeModeTab> tabKey, FabricCreativeModeTabOutput output) {
		this.tab = tab;
		this.tabKey = tabKey;
		this.output = output;
	}

	public CreativeModeTab getTab() {
		return tab;
	}

	public ResourceKey<CreativeModeTab> getTabKey() {
		return tabKey;
	}

	public FeatureFlagSet getFlags() {
		return output.getEnabledFeatures();
	}

	public CreativeModeTab.ItemDisplayParameters getParameters() {
		return output.getContext();
	}

	public boolean hasPermissions() {
		return output.shouldShowOpRestrictedItems();
	}

	@Override
	public void accept(ItemStack newEntry, CreativeModeTab.TabVisibility visibility) {
		output.accept(newEntry, visibility);
	}

	public void insertAfter(ItemStack existingEntry, ItemStack newEntry, CreativeModeTab.TabVisibility visibility) {
		output.insertAfter(existingEntry, List.of(newEntry), visibility);
	}

	public void insertBefore(ItemStack existingEntry, ItemStack newEntry, CreativeModeTab.TabVisibility visibility) {
		output.insertBefore(existingEntry, List.of(newEntry), visibility);
	}

	public void insertFirst(ItemStack newEntry, CreativeModeTab.TabVisibility visibility) {
		output.prepend(newEntry, visibility);
	}

	public void remove(ItemStack existingEntry, CreativeModeTab.TabVisibility visibility) {
		removeIf(stack -> ItemStack.isSameItemSameComponents(stack, existingEntry), visibility);
	}

	public void removeIf(Predicate<? super ItemStack> predicate, CreativeModeTab.TabVisibility visibility) {
		if (visibility != CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY) {
			output.getDisplayStacks().removeIf(predicate);
		}

		if (visibility != CreativeModeTab.TabVisibility.PARENT_TAB_ONLY) {
			output.getSearchTabStacks().removeIf(predicate);
		}
	}
}
