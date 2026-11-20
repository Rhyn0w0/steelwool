package net.neoforged.fml;

/**
 * SteelWool re-implementation of FML's {@code LogicalSide}.
 */
public enum LogicalSide {
	CLIENT, SERVER;

	public boolean isServer() {
		return !isClient();
	}

	public boolean isClient() {
		return this == CLIENT;
	}
}
