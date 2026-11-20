package net.neoforged.fml.util.thread;

import net.neoforged.fml.LogicalSide;

/**
 * The thread groups of the two logical sides. SteelWool starts the server thread in {@link #SERVER},
 * as NeoForge does; mods check it to tell whether they run on the server thread.
 */
public final class SidedThreadGroups {
	public static final SidedThreadGroup CLIENT = new SidedThreadGroup(LogicalSide.CLIENT);
	public static final SidedThreadGroup SERVER = new SidedThreadGroup(LogicalSide.SERVER);

	private SidedThreadGroups() {
	}
}
