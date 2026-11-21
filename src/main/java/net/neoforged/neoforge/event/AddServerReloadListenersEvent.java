package net.neoforged.neoforge.event;

import java.util.Map;
import net.minecraft.resources.Identifier;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.resource.ListenerKey;
import net.neoforged.neoforge.resource.VanillaServerListeners;

/**
 * Fired on {@code NeoForge.EVENT_BUS} each time server data is (re)loaded, to add reload listeners.
 * SteelWool fires it from {@code ReloadableServerResources.listeners()}.
 */
public class AddServerReloadListenersEvent extends SortedReloadListenerEvent {
	private final ReloadableServerResources serverResources;
	private final Map<ListenerKey<?>, PreparableReloadListener> retainedListeners;

	public AddServerReloadListenersEvent(ReloadableServerResources serverResources, Map<ListenerKey<?>, PreparableReloadListener> retainedListeners) {
		super(serverResources.listeners(), AddServerReloadListenersEvent::lookupName);
		this.serverResources = serverResources;
		this.retainedListeners = retainedListeners;
	}

	/** Adds a listener that can be looked up later with {@code ReloadableServerResources.getListener(key)}. */
	public <T extends PreparableReloadListener> void addRetainedListener(ListenerKey<T> key, T listener) {
		addListener(key.getListenerId(), listener);
		retainedListeners.put(key, listener);
	}

	public ReloadableServerResources getServerResources() {
		return serverResources;
	}

	public ICondition.IContext getConditionContext() {
		throw new UnsupportedOperationException("SteelWool does not implement AddServerReloadListenersEvent.getConditionContext yet");
	}

	private static Identifier lookupName(PreparableReloadListener listener) {
		return VanillaServerListeners.getNameForClass(listener.getClass());
	}
}
