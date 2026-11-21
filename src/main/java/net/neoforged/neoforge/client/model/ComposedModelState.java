package net.neoforged.neoforge.client.model;

import com.mojang.math.Transformation;
import net.minecraft.client.renderer.block.dispatch.ModelState;
import net.minecraft.core.Direction;
import org.joml.Matrix4fc;

/**
 * SteelWool re-implementation of NeoForge's {@code ComposedModelState}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ComposedModelState(ModelState parent, Transformation transformation) implements ModelState {
	public Matrix4fc faceTransformation(Direction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ComposedModelState.faceTransformation yet");
	}

	public Matrix4fc inverseFaceTransformation(Direction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ComposedModelState.inverseFaceTransformation yet");
	}
}
