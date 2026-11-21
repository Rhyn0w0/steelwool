package net.neoforged.neoforge.common;

import java.util.List;

import com.google.common.collect.Multimap;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.world.item.CreativeModeTab;
import org.slf4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code CreativeModeTabRegistry}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class CreativeModeTabRegistry {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static final Identifier CREATIVE_MODE_TAB_ORDERING_JSON = null /* SteelWool: TODO */;
	private static final List<CreativeModeTab> SORTED_TABS = null /* SteelWool: TODO */;
	private static final List<CreativeModeTab> SORTED_TABS_VIEW = null /* SteelWool: TODO */;
	private static final List<CreativeModeTab> DEFAULT_TABS = null /* SteelWool: TODO */;
	private static final Multimap<Identifier, Identifier> edges = null /* SteelWool: TODO */;

	public CreativeModeTabRegistry() {
		super();
	}

	public static List<CreativeModeTab> getSortedCreativeModeTabs() {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.getSortedCreativeModeTabs yet");
	}

	public static List<CreativeModeTab> getDefaultTabs() {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.getDefaultTabs yet");
	}

	public static CreativeModeTab getTab(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.getTab yet");
	}

	public static Identifier getName(CreativeModeTab arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.getName yet");
	}

	static PreparableReloadListener getReloadListener() {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.getReloadListener yet");
	}

	private static void recalculateItemCreativeModeTabs() {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.recalculateItemCreativeModeTabs yet");
	}

	private static void setCreativeModeTabOrder(List<CreativeModeTab> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.setCreativeModeTabOrder yet");
	}

	private static void runInServerThreadIfPossible(BooleanConsumer arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.runInServerThreadIfPossible yet");
	}

	public static void sortTabs() {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.sortTabs yet");
	}

	private static void addTabOrder(CreativeModeTab arg0, Identifier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CreativeModeTabRegistry.addTabOrder yet");
	}
}
