package net.neoforged.neoforge.network.registration;

/**
 * SteelWool re-implementation of NeoForge's {@code HandlerThread}. Under SteelWool, Fabric runs payload
 * receivers on the main thread, so {@link #NETWORK} handlers also run there.
 */
public enum HandlerThread {
	MAIN,
	NETWORK
}
