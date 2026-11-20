package net.neoforged.neoforge.client.event;

import java.util.Map;

import net.minecraft.client.gui.components.debug.DebugScreenEntry;
import net.minecraft.client.gui.components.debug.DebugScreenEntryStatus;
import net.minecraft.client.gui.components.debug.DebugScreenProfile;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterDebugEntriesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RegisterDebugEntriesEvent extends Event implements IModBusEvent {
	private final Map<Identifier, DebugScreenEntry> entries;
	private final Map<Identifier, DebugScreenEntryStatus> defaultProfile;
	private final Map<Identifier, DebugScreenEntryStatus> performanceProfile;

	public RegisterDebugEntriesEvent(Map<Identifier, DebugScreenEntry> entries, Map<DebugScreenProfile, Map<Identifier, DebugScreenEntryStatus>> arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RegisterDebugEntriesEvent constructor yet");
	}

	public void register(Identifier arg0, DebugScreenEntry arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugEntriesEvent.register yet");
	}

	public boolean isRegistered(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugEntriesEvent.isRegistered yet");
	}

	public void includeInProfile(Identifier arg0, DebugScreenProfile arg1, DebugScreenEntryStatus arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugEntriesEvent.includeInProfile yet");
	}

	public boolean isIncludedInProfile(Identifier arg0, DebugScreenProfile arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugEntriesEvent.isIncludedInProfile yet");
	}

	private Map<Identifier, DebugScreenEntryStatus> getProfileMap(DebugScreenProfile arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugEntriesEvent.getProfileMap yet");
	}

	public Map<DebugScreenProfile, Map<Identifier, DebugScreenEntryStatus>> validateProfiles() {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugEntriesEvent.validateProfiles yet");
	}

	private IllegalStateException validateProfile(DebugScreenProfile arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugEntriesEvent.validateProfile yet");
	}
}
