package net.neoforged.neoforge.resource;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;

/** Names a retained reload listener; there is one key per name. */
public final class ListenerKey<T extends PreparableReloadListener> {
	private static final ConcurrentMap<Identifier, ListenerKey<?>> VALUES = new ConcurrentHashMap<>();
	private final Identifier listenerId;

	@SuppressWarnings("unchecked")
	public static <T extends PreparableReloadListener> ListenerKey<T> create(Identifier listenerId) {
		return (ListenerKey<T>) VALUES.computeIfAbsent(listenerId, ListenerKey::new);
	}

	private ListenerKey(Identifier listenerId) {
		this.listenerId = listenerId;
	}

	public Identifier getListenerId() {
		return listenerId;
	}

	@Override
	public String toString() {
		return "ListenerKey[" + listenerId + "]";
	}
}
