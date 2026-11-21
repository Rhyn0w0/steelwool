package net.neoforged.neoforge.client.event;

import java.util.SequencedMap;

import net.minecraft.client.resources.model.sprite.AtlasManager;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterTextureAtlasesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterTextureAtlasesEvent extends Event implements IModBusEvent {
	private final SequencedMap<Identifier, AtlasManager.AtlasConfig> atlases;

	public RegisterTextureAtlasesEvent(SequencedMap<Identifier, AtlasManager.AtlasConfig> atlases) {
		super();
		this.atlases = atlases;
	}

	public void register(AtlasManager.AtlasConfig arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterTextureAtlasesEvent.register yet");
	}

	public void addAdditionalMetadata(Identifier arg0, MetadataSectionType<?> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterTextureAtlasesEvent.addAdditionalMetadata yet");
	}
}
