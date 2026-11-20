package net.neoforged.neoforge.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * SteelWool re-implementation of NeoForge's {@code PartEntity}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class PartEntity<T extends Entity> extends Entity {
	private final T parent;

	public PartEntity(T arg0) {
		super((EntityType) null, (Level) null);
		throw new UnsupportedOperationException("SteelWool does not implement the PartEntity constructor yet");
	}

	public T getParent() {
		return this.parent;
	}

	public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PartEntity.getAddEntityPacket yet");
	}
}
