package net.neoforged.fml.util.thread;

import java.util.concurrent.ThreadFactory;
import net.neoforged.fml.LogicalSide;

/** A thread group for one logical side; threads in it belong to that side. */
public final class SidedThreadGroup extends ThreadGroup implements ThreadFactory {
	private final LogicalSide side;

	SidedThreadGroup(LogicalSide side) {
		super(side.name());
		this.side = side;
	}

	public LogicalSide getSide() {
		return side;
	}

	@Override
	public Thread newThread(Runnable runnable) {
		return new Thread(this, runnable);
	}
}
