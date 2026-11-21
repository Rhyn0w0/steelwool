package net.neoforged.neoforge.client.model.generators.template;

import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.cuboid.CuboidFace;
import net.minecraft.core.Direction;

/**
 * SteelWool re-implementation of NeoForge's {@code FaceBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class FaceBuilder {
	private Direction cullface;
	private int tintindex;
	private TextureSlot texture;
	private CuboidFace.UVs uvs;
	private Quadrant rotation;
	private int color;
	private int lightEmission;
	private boolean hasAmbientOcclusion;

	public FaceBuilder() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the FaceBuilder constructor yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.FaceBuilder cullface(Direction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.cullface yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.FaceBuilder tintindex(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.tintindex yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.FaceBuilder texture(TextureSlot arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.texture yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.FaceBuilder uvs(float arg0, float arg1, float arg2, float arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.uvs yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.FaceBuilder rotation(Quadrant arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.rotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.FaceBuilder lightEmission(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.lightEmission yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.FaceBuilder color(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.color yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.FaceBuilder ambientOcclusion(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.ambientOcclusion yet");
	}

	CuboidFace build() {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.build yet");
	}

	net.neoforged.neoforge.client.model.generators.template.FaceBuilder copy() {
		throw new UnsupportedOperationException("SteelWool does not implement FaceBuilder.copy yet");
	}
}
