package net.neoforged.neoforge.event;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.google.common.graph.Graph;
import com.google.common.graph.MutableGraph;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code SortedReloadListenerEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class SortedReloadListenerEvent extends Event {
	private final Map<Identifier, PreparableReloadListener> registry;
	private final Map<PreparableReloadListener, Identifier> keys;
	private final MutableGraph<PreparableReloadListener> graph;
	private final PreparableReloadListener lastVanilla;

	protected SortedReloadListenerEvent(List<PreparableReloadListener> arg0, net.neoforged.neoforge.event.SortedReloadListenerEvent.NameLookup arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the SortedReloadListenerEvent constructor yet");
	}

	public void addListener(Identifier arg0, PreparableReloadListener arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SortedReloadListenerEvent.addListener yet");
	}

	public void addDependency(Identifier arg0, Identifier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SortedReloadListenerEvent.addDependency yet");
	}

	public Graph<PreparableReloadListener> getGraph() {
		return this.graph;
	}

	public Map<Identifier, PreparableReloadListener> getRegistry() {
		throw new UnsupportedOperationException("SteelWool does not implement SortedReloadListenerEvent.getRegistry yet");
	}

	public net.neoforged.neoforge.event.SortedReloadListenerEvent.NameLookup getNameLookup() {
		throw new UnsupportedOperationException("SteelWool does not implement SortedReloadListenerEvent.getNameLookup yet");
	}

	public PreparableReloadListener getLastVanillaListener() {
		return this.lastVanilla;
	}

	private PreparableReloadListener getOrThrow(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SortedReloadListenerEvent.getOrThrow yet");
	}

	private Identifier getOrThrow(PreparableReloadListener arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SortedReloadListenerEvent.getOrThrow yet");
	}

	public interface NameLookup extends Function<PreparableReloadListener, Identifier> {
		Identifier apply(PreparableReloadListener arg0);
	}
}
