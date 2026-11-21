package net.neoforged.neoforge.event.entity;

import java.util.Map;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityAttributeCreationEvent}, with the same API.
 */
public class EntityAttributeCreationEvent extends Event implements IModBusEvent {
	private final Map<EntityType<? extends LivingEntity>, AttributeSupplier> map;

	public EntityAttributeCreationEvent(Map<EntityType<? extends LivingEntity>, AttributeSupplier> map) {
		super();
		this.map = map;
	}

	public void put(EntityType<? extends LivingEntity> entity, AttributeSupplier attributes) {
		map.put(entity, attributes);
	}
}
