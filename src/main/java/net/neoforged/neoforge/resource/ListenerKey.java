package net.neoforged.neoforge.resource;

import java.util.concurrent.ConcurrentMap;

import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;

/**
 * SteelWool re-implementation of NeoForge's {@code ListenerKey}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ListenerKey<T extends PreparableReloadListener> extends Object {
	private static final ConcurrentMap<Identifier, net.neoforged.neoforge.resource.ListenerKey<?>> VALUES = null /* SteelWool: TODO */;
	private final Identifier listenerId;

	public static <T extends PreparableReloadListener> net.neoforged.neoforge.resource.ListenerKey<T> create(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ListenerKey.create yet");
	}

	private ListenerKey(Identifier listenerId) {
		super();
		this.listenerId = listenerId;
	}

	public Identifier getListenerId() {
		return this.listenerId;
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement ListenerKey.toString yet");
	}
}
