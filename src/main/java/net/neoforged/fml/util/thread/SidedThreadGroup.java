package net.neoforged.fml.util.thread;

import java.util.concurrent.ThreadFactory;

import net.neoforged.fml.LogicalSide;

/**
 * SteelWool re-implementation of NeoForge's {@code SidedThreadGroup}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class SidedThreadGroup extends ThreadGroup implements ThreadFactory {
	private final LogicalSide side;

	SidedThreadGroup(LogicalSide arg0) {
		super((String) null);
		throw new UnsupportedOperationException("SteelWool does not implement the SidedThreadGroup constructor yet");
	}

	public LogicalSide getSide() {
		return this.side;
	}

	public Thread newThread(Runnable arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SidedThreadGroup.newThread yet");
	}
}
