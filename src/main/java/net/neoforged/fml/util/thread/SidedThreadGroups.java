package net.neoforged.fml.util.thread;

/**
 * SteelWool re-implementation of NeoForge's {@code SidedThreadGroups}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class SidedThreadGroups {
	public static final SidedThreadGroup CLIENT = null /* SteelWool: TODO */;
	public static final SidedThreadGroup SERVER = null /* SteelWool: TODO */;

	private SidedThreadGroups() {
		super();
	}
}
