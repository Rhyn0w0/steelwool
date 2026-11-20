package net.neoforged.neoforge.network.connection;

/**
 * SteelWool re-implementation of NeoForge's {@code ConnectionType}.
 */
public enum ConnectionType {
	NEOFORGE,
	OTHER;

	public boolean isOther() {
		return this == OTHER;
	}

	public boolean isNeoForge() {
		return this == NEOFORGE;
	}
}
