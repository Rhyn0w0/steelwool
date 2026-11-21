package net.neoforged.neoforge.client.entity.animation;

import net.minecraft.client.animation.AnimationChannel;
import org.joml.Vector3f;

/**
 * SteelWool re-implementation of NeoForge's {@code AnimationTarget}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record AnimationTarget(AnimationChannel.Target channelTarget, AnimationKeyframeTarget keyframeTarget, AnimationKeyframeTarget inverseKeyframeTarget) {
	public static final net.neoforged.neoforge.client.entity.animation.AnimationTarget POSITION = null /* SteelWool: TODO */;
	public static final net.neoforged.neoforge.client.entity.animation.AnimationTarget ROTATION = null /* SteelWool: TODO */;
	public static final net.neoforged.neoforge.client.entity.animation.AnimationTarget SCALE = null /* SteelWool: TODO */;

	private static Vector3f inverseDegreeVec(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement AnimationTarget.inverseDegreeVec yet");
	}

	private static Vector3f inverseScaleVec(double arg0, double arg1, double arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement AnimationTarget.inverseScaleVec yet");
	}
}
