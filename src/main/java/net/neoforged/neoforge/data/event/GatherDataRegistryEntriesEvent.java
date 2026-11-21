package net.neoforged.neoforge.data.event;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.SingleRegistryBootstrap;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code GatherDataRegistryEntriesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class GatherDataRegistryEntriesEvent extends Event implements IModBusEvent,GlobalDatapackRegistryGatherer {
	private final ModContainer modContainer;
	private final GlobalDatapackRegistryGatherer delegate;

	public GatherDataRegistryEntriesEvent(ModContainer modContainer, GlobalDatapackRegistryGatherer delegate) {
		super();
		this.modContainer = modContainer;
		this.delegate = delegate;
	}

	public ModContainer getModContainer() {
		return this.modContainer;
	}

	public DatapackRegistryGatherer gatherFor(String arg0, String... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataRegistryEntriesEvent.gatherFor yet");
	}

	public <T extends Object> DatapackRegistryGatherer add(ResourceKey<? extends Registry<T>> arg0, SingleRegistryBootstrap<T> arg1) throws IllegalArgumentException {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataRegistryEntriesEvent.add yet");
	}

	public DatapackRegistryGatherer add(MultiRegistryBootstrap arg0) throws IllegalArgumentException {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataRegistryEntriesEvent.add yet");
	}
}
