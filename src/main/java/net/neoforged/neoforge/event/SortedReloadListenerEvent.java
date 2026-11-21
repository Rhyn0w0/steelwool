package net.neoforged.neoforge.event;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.neoforged.bus.api.Event;
import org.jspecify.annotations.Nullable;

/**
 * Collects reload listeners by name, with ordering between them. It starts with the existing
 * (vanilla) listeners in their order; listeners added in the event run after the last of those
 * unless a dependency says otherwise. {@link #sortedListeners()} gives the final order.
 */
public abstract class SortedReloadListenerEvent extends Event {
	private final Map<Identifier, PreparableReloadListener> registry = new LinkedHashMap<>();
	private final Map<PreparableReloadListener, Identifier> keys = new IdentityHashMap<>();
	private final MutableGraph<PreparableReloadListener> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
	private final @Nullable PreparableReloadListener lastVanilla;

	protected SortedReloadListenerEvent(List<PreparableReloadListener> vanillaListeners, NameLookup lookup) {
		PreparableReloadListener previous = null;
		for (PreparableReloadListener listener : vanillaListeners) {
			Identifier name;
			try {
				name = lookup.apply(listener);
			} catch (RuntimeException e) {
				name = null;
			}
			if (name == null || registry.containsKey(name)) {
				// Listeners added by other means (such as Fabric API) get a name from their class.
				name = Identifier.fromNamespaceAndPath("steelwool", "unnamed/" + listener.getClass().getName().toLowerCase(java.util.Locale.ROOT).replace('$', '/'));
			}
			register(name, listener);
			if (previous != null) {
				graph.putEdge(previous, listener);
			}
			previous = listener;
		}
		this.lastVanilla = previous;
	}

	private void register(Identifier name, PreparableReloadListener listener) {
		if (registry.containsKey(name)) {
			throw new IllegalArgumentException("A reload listener named " + name + " is already registered");
		}
		if (keys.containsKey(listener)) {
			throw new IllegalArgumentException("Reload listener " + listener + " is already registered as " + keys.get(listener));
		}
		registry.put(name, listener);
		keys.put(listener, name);
		graph.addNode(listener);
	}

	public void addListener(Identifier name, PreparableReloadListener listener) {
		register(name, listener);
		if (lastVanilla != null) {
			graph.putEdge(lastVanilla, listener);
		}
	}

	/** {@code first} runs before {@code second}. */
	public void addDependency(Identifier first, Identifier second) {
		PreparableReloadListener before = getOrThrow(first);
		PreparableReloadListener after = getOrThrow(second);
		graph.putEdge(before, after);
		if (com.google.common.graph.Graphs.hasCycle(graph)) {
			graph.removeEdge(before, after);
			throw new IllegalArgumentException("Ordering " + first + " before " + second + " would create a cycle");
		}
	}

	public Graph<PreparableReloadListener> getGraph() {
		return graph;
	}

	public Map<Identifier, PreparableReloadListener> getRegistry() {
		return Collections.unmodifiableMap(registry);
	}

	public NameLookup getNameLookup() {
		return this::getOrThrow;
	}

	public @Nullable PreparableReloadListener getLastVanillaListener() {
		return lastVanilla;
	}

	private PreparableReloadListener getOrThrow(Identifier name) {
		PreparableReloadListener listener = registry.get(name);
		if (listener == null) {
			throw new IllegalArgumentException("Unknown reload listener " + name);
		}
		return listener;
	}

	private Identifier getOrThrow(PreparableReloadListener listener) {
		Identifier name = keys.get(listener);
		if (name == null) {
			throw new IllegalArgumentException("Unknown reload listener " + listener);
		}
		return name;
	}

	/** The listeners in an order that respects every dependency; otherwise in registration order. */
	public List<PreparableReloadListener> sortedListeners() {
		List<PreparableReloadListener> sorted = new ArrayList<>();
		Map<PreparableReloadListener, Integer> waiting = new IdentityHashMap<>();
		for (PreparableReloadListener listener : registry.values()) {
			waiting.put(listener, graph.inDegree(listener));
		}
		while (sorted.size() < registry.size()) {
			PreparableReloadListener next = null;
			for (PreparableReloadListener listener : registry.values()) {
				if (waiting.get(listener) == 0) {
					next = listener;
					break;
				}
			}
			if (next == null) {
				throw new IllegalStateException("Reload listener ordering has a cycle");
			}
			waiting.put(next, -1);
			sorted.add(next);
			for (PreparableReloadListener successor : graph.successors(next)) {
				waiting.merge(successor, -1, Integer::sum);
			}
		}
		return sorted;
	}

	public interface NameLookup extends Function<PreparableReloadListener, Identifier> {
		@Override
		Identifier apply(PreparableReloadListener listener);
	}
}
