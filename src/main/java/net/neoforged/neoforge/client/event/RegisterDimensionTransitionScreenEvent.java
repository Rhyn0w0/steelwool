package net.neoforged.neoforge.client.event;

import java.util.Map;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.DimensionTransitionScreenManager;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterDimensionTransitionScreenEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterDimensionTransitionScreenEvent extends Event implements IModBusEvent {
	private final Map<Pair<ResourceKey<Level>, ResourceKey<Level>>, DimensionTransitionScreenManager.ReceivingLevelScreenFactory> conditionalDimensionEffects;
	private final Map<ResourceKey<Level>, DimensionTransitionScreenManager.ReceivingLevelScreenFactory> toEffects;
	private final Map<ResourceKey<Level>, DimensionTransitionScreenManager.ReceivingLevelScreenFactory> fromEffects;

	public RegisterDimensionTransitionScreenEvent(Map<Pair<ResourceKey<Level>, ResourceKey<Level>>, DimensionTransitionScreenManager.ReceivingLevelScreenFactory> conditionalDimensionEffects, Map<ResourceKey<Level>, DimensionTransitionScreenManager.ReceivingLevelScreenFactory> toEffects, Map<ResourceKey<Level>, DimensionTransitionScreenManager.ReceivingLevelScreenFactory> fromEffects) {
		super();
		this.conditionalDimensionEffects = conditionalDimensionEffects;
		this.toEffects = toEffects;
		this.fromEffects = fromEffects;
	}

	public boolean registerIncomingEffect(ResourceKey<Level> arg0, DimensionTransitionScreenManager.ReceivingLevelScreenFactory arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDimensionTransitionScreenEvent.registerIncomingEffect yet");
	}

	public boolean registerOutgoingEffect(ResourceKey<Level> arg0, DimensionTransitionScreenManager.ReceivingLevelScreenFactory arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDimensionTransitionScreenEvent.registerOutgoingEffect yet");
	}

	public boolean registerConditionalEffect(ResourceKey<Level> arg0, ResourceKey<Level> arg1, DimensionTransitionScreenManager.ReceivingLevelScreenFactory arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDimensionTransitionScreenEvent.registerConditionalEffect yet");
	}
}
