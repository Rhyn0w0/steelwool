package net.neoforged.neoforge.event;

import java.util.function.Consumer;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code AddPackFindersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AddPackFindersEvent extends Event implements IModBusEvent {
	private final PackType packType;
	private final Consumer<RepositorySource> sources;
	private final boolean trusted;

	public AddPackFindersEvent(PackType packType, Consumer<RepositorySource> sources, boolean trusted) {
		super();
		this.packType = packType;
		this.sources = sources;
		this.trusted = trusted;
	}

	public void addRepositorySource(RepositorySource arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AddPackFindersEvent.addRepositorySource yet");
	}

	public PackType getPackType() {
		return this.packType;
	}

	public void addPackFinders(Identifier arg0, PackType arg1, Component arg2, PackSource arg3, boolean arg4, Pack.Position arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement AddPackFindersEvent.addPackFinders yet");
	}

	public boolean isTrusted() {
		return this.trusted;
	}
}
