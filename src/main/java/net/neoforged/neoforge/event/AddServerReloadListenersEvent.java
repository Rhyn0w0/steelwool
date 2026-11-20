package net.neoforged.neoforge.event;

import java.util.List;
import java.util.Map;

import net.minecraft.resources.Identifier;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.resource.ListenerKey;

/**
 * SteelWool re-implementation of NeoForge's {@code AddServerReloadListenersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AddServerReloadListenersEvent extends SortedReloadListenerEvent {
	private final ReloadableServerResources serverResources;
	private final Map<ListenerKey<?>, PreparableReloadListener> retainedListeners;

	public AddServerReloadListenersEvent(ReloadableServerResources arg0, Map<ListenerKey<?>, PreparableReloadListener> arg1) {
		super((List) null, (SortedReloadListenerEvent.NameLookup) null);
		throw new UnsupportedOperationException("SteelWool does not implement the AddServerReloadListenersEvent constructor yet");
	}

	public <T extends PreparableReloadListener> void addRetainedListener(ListenerKey<T> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement AddServerReloadListenersEvent.addRetainedListener yet");
	}

	public ReloadableServerResources getServerResources() {
		return this.serverResources;
	}

	public ICondition.IContext getConditionContext() {
		throw new UnsupportedOperationException("SteelWool does not implement AddServerReloadListenersEvent.getConditionContext yet");
	}

	private static Identifier lookupName(PreparableReloadListener arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AddServerReloadListenersEvent.lookupName yet");
	}
}
