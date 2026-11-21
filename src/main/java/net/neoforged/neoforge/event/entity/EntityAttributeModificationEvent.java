package net.neoforged.neoforge.event.entity;

import java.util.List;
import java.util.Map;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityAttributeModificationEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class EntityAttributeModificationEvent extends Event implements IModBusEvent {
	private final Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> entityAttributes;
	private final List<EntityType<? extends LivingEntity>> entityTypes;

	public EntityAttributeModificationEvent(Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> entityAttributes) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the EntityAttributeModificationEvent constructor yet");
	}

	public void add(EntityType<? extends LivingEntity> arg0, Holder<Attribute> arg1, double arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement EntityAttributeModificationEvent.add yet");
	}

	public void add(EntityType<? extends LivingEntity> arg0, Holder<Attribute> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EntityAttributeModificationEvent.add yet");
	}

	public boolean has(EntityType<? extends LivingEntity> arg0, Holder<Attribute> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EntityAttributeModificationEvent.has yet");
	}

	public List<EntityType<? extends LivingEntity>> getTypes() {
		return this.entityTypes;
	}
}
