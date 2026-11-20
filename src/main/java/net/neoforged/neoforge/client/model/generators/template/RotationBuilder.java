package net.neoforged.neoforge.client.model.generators.template;

import net.minecraft.client.resources.model.cuboid.CuboidRotation;
import net.minecraft.core.Direction;
import org.joml.Vector3f;

/**
 * SteelWool re-implementation of NeoForge's {@code RotationBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RotationBuilder {
	private Vector3f origin;
	private CuboidRotation.RotationValue value;
	private boolean rescale;

	public RotationBuilder() {
		super();
	}

	public net.neoforged.neoforge.client.model.generators.template.RotationBuilder origin(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RotationBuilder.origin yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RotationBuilder singleAxis(Direction.Axis arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RotationBuilder.singleAxis yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RotationBuilder eulerXYZ(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RotationBuilder.eulerXYZ yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RotationBuilder rescale(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RotationBuilder.rescale yet");
	}

	CuboidRotation build() {
		throw new UnsupportedOperationException("SteelWool does not implement RotationBuilder.build yet");
	}

	net.neoforged.neoforge.client.model.generators.template.RotationBuilder copy() {
		throw new UnsupportedOperationException("SteelWool does not implement RotationBuilder.copy yet");
	}
}
