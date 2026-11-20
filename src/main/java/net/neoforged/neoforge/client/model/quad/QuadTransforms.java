package net.neoforged.neoforge.client.model.quad;

import com.mojang.math.Transformation;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;

/**
 * SteelWool re-implementation of NeoForge's {@code QuadTransforms}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class QuadTransforms {
	private QuadTransforms() {
		super();
	}

	public static BakedQuad applyTransformation(BakedQuad arg0, Transformation arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadTransforms.applyTransformation yet");
	}

	private static Vector3fc transformPosition(Vector4f arg0, Vector3fc arg1, Transformation arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadTransforms.transformPosition yet");
	}

	private static int transformNormal(Vector3f arg0, int arg1, Transformation arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadTransforms.transformNormal yet");
	}
}
