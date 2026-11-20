package net.neoforged.neoforge.client.event;

import java.util.function.Supplier;

import it.unimi.dsi.fastutil.objects.ObjectBooleanBiConsumer;
import net.minecraft.util.debug.DebugSubscription;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code AddDebugSubscriptionFlagsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class AddDebugSubscriptionFlagsEvent extends Event {
	private final ObjectBooleanBiConsumer<DebugSubscription<?>> registrar;

	public AddDebugSubscriptionFlagsEvent(ObjectBooleanBiConsumer<DebugSubscription<?>> registrar) {
		super();
		this.registrar = registrar;
	}

	public void addFlag(DebugSubscription<?> arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement AddDebugSubscriptionFlagsEvent.addFlag yet");
	}

	public void addFlag(Supplier<? extends DebugSubscription<?>> arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement AddDebugSubscriptionFlagsEvent.addFlag yet");
	}

	public void addActiveInDev(DebugSubscription<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AddDebugSubscriptionFlagsEvent.addActiveInDev yet");
	}

	public void addActiveInDev(Supplier<? extends DebugSubscription<?>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AddDebugSubscriptionFlagsEvent.addActiveInDev yet");
	}
}
