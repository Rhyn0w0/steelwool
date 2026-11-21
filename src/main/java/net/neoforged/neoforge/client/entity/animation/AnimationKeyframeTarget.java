package net.neoforged.neoforge.client.entity.animation;

import org.joml.Vector3f;

/**
 * SteelWool re-implementation of NeoForge's {@code AnimationKeyframeTarget}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface AnimationKeyframeTarget {
	Vector3f apply(float arg0, float arg1, float arg2);
}
