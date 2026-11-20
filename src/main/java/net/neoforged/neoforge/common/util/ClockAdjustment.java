package net.neoforged.neoforge.common.util;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.clock.ClockTimeMarker;
import net.minecraft.world.clock.ServerClockManager;
import net.minecraft.world.clock.WorldClock;

/**
 * SteelWool re-implementation of NeoForge's {@code ClockAdjustment}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ClockAdjustment {
	void apply(ServerClockManager arg0, Holder<WorldClock> arg1);

	public static record Absolute(long ticks) implements net.neoforged.neoforge.common.util.ClockAdjustment {
		public void apply(ServerClockManager arg0, Holder<WorldClock> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ClockAdjustment.Absolute.apply yet");
		}
	}

	public static record Marker(ResourceKey<ClockTimeMarker> marker) implements net.neoforged.neoforge.common.util.ClockAdjustment {
		public void apply(ServerClockManager arg0, Holder<WorldClock> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ClockAdjustment.Marker.apply yet");
		}
	}

	public static record Relative(long ticks) implements net.neoforged.neoforge.common.util.ClockAdjustment {
		public void apply(ServerClockManager arg0, Holder<WorldClock> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ClockAdjustment.Relative.apply yet");
		}
	}
}
