package net.neoforged.neoforge.client.event;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.entity.animation.AnimationTarget;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterJsonAnimationTypesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterJsonAnimationTypesEvent extends Event implements IModBusEvent {
	private final ImmutableMap.Builder<Identifier, AnimationTarget> targets;
	private final ImmutableMap.Builder<Identifier, AnimationChannel.Interpolation> interpolations;
	private final Map<Identifier, AnimationTarget> registeredTargets;
	private final Map<Identifier, AnimationChannel.Interpolation> registeredInterpolations;

	public RegisterJsonAnimationTypesEvent(ImmutableMap.Builder<Identifier, AnimationTarget> arg0, ImmutableMap.Builder<Identifier, AnimationChannel.Interpolation> arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RegisterJsonAnimationTypesEvent constructor yet");
	}

	public void registerTarget(Identifier arg0, AnimationTarget arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterJsonAnimationTypesEvent.registerTarget yet");
	}

	public void registerInterpolation(Identifier arg0, AnimationChannel.Interpolation arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterJsonAnimationTypesEvent.registerInterpolation yet");
	}

	private static <T extends Object> void checkDuplicate(String arg0, Identifier arg1, Map<Identifier, T> arg2, T arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterJsonAnimationTypesEvent.checkDuplicate yet");
	}
}
