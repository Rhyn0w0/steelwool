package net.neoforged.neoforge.event;

import net.minecraft.core.HolderGetter;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LootTableLoadEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LootTableLoadEvent extends Event implements ICancellableEvent {
	private final HolderGetter.Provider registries;
	private final Identifier name;
	private LootTable table;
	private ResourceKey<LootTable> key;

	public LootTableLoadEvent(HolderGetter.Provider registries, Identifier name, LootTable table) {
		super();
		this.registries = registries;
		this.name = name;
		this.table = table;
	}

	public HolderGetter.Provider getRegistries() {
		return this.registries;
	}

	public Identifier getName() {
		return this.name;
	}

	public ResourceKey<LootTable> getKey() {
		throw new UnsupportedOperationException("SteelWool does not implement LootTableLoadEvent.getKey yet");
	}

	public LootTable getTable() {
		return this.table;
	}

	public void setTable(LootTable arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement LootTableLoadEvent.setTable yet");
	}
}
