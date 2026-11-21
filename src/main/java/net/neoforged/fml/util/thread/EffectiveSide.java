package net.neoforged.fml.util.thread;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.loading.FMLEnvironment;

/**
 * SteelWool re-implementation of FML's {@code EffectiveSide}: the logical side of the current thread.
 * On a client, the integrated server's threads are {@link LogicalSide#SERVER}, everything else is
 * {@link LogicalSide#CLIENT}.
 */
public class EffectiveSide {
	public EffectiveSide() {
	}

	public static LogicalSide get() {
		if (FMLEnvironment.getDist() == Dist.DEDICATED_SERVER) {
			return LogicalSide.SERVER;
		}

		String name = Thread.currentThread().getName();
		return name.equals("Server thread") || name.startsWith("Netty Server IO") ? LogicalSide.SERVER : LogicalSide.CLIENT;
	}
}
