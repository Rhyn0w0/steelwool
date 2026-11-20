package net.neoforged.neoforge.client.model.generators.template;

import net.minecraft.client.resources.model.cuboid.ItemTransform;
import net.minecraft.world.item.ItemDisplayContext;
import org.joml.Vector3f;

/**
 * SteelWool re-implementation of NeoForge's {@code TransformVecBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class TransformVecBuilder {
	private Vector3f rotation;
	private Vector3f translation;
	private Vector3f scale;
	private Vector3f rightRotation;

	TransformVecBuilder(ItemDisplayContext arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the TransformVecBuilder constructor yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.TransformVecBuilder rotation(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformVecBuilder.rotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.TransformVecBuilder translation(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformVecBuilder.translation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.TransformVecBuilder scale(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformVecBuilder.scale yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.TransformVecBuilder scale(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformVecBuilder.scale yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.TransformVecBuilder rightRotation(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformVecBuilder.rightRotation yet");
	}

	ItemTransform build() {
		throw new UnsupportedOperationException("SteelWool does not implement TransformVecBuilder.build yet");
	}

	net.neoforged.neoforge.client.model.generators.template.TransformVecBuilder copy() {
		throw new UnsupportedOperationException("SteelWool does not implement TransformVecBuilder.copy yet");
	}
}
