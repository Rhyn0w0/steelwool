package net.neoforged.neoforge.client.model.generators.template;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.cuboid.CuboidModelElement;
import net.minecraft.core.Direction;
import org.joml.Vector3f;

/**
 * SteelWool re-implementation of NeoForge's {@code ElementBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ElementBuilder {
	private Vector3f from;
	private Vector3f to;
	private final Map<Direction, FaceBuilder> faces;
	private RotationBuilder rotation;
	private Direction shadeDirectionOverride;
	private int lightEmission;
	private int color;
	private boolean hasAmbientOcclusion;

	public ElementBuilder() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ElementBuilder constructor yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder from(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.from yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder to(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.to yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder face(Direction arg0, Consumer<FaceBuilder> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.face yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder rotation(Consumer<RotationBuilder> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.rotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder shadeDirectionOverride(Direction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.shadeDirectionOverride yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder allFaces(BiConsumer<Direction, FaceBuilder> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.allFaces yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder allFacesExcept(BiConsumer<Direction, FaceBuilder> arg0, Set<Direction> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.allFacesExcept yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder faces(BiConsumer<Direction, FaceBuilder> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.faces yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder textureAll(TextureSlot arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.textureAll yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder texture(TextureSlot arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.texture yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder cube(TextureSlot arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.cube yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder lightEmission(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.lightEmission yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder color(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.color yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ElementBuilder ambientOcclusion(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.ambientOcclusion yet");
	}

	private static BiConsumer<Direction, FaceBuilder> addTexture(TextureSlot arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.addTexture yet");
	}

	private static void validateCoordinate(float arg0, char arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.validateCoordinate yet");
	}

	private static void validatePosition(Vector3f arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.validatePosition yet");
	}

	CuboidModelElement build() {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.build yet");
	}

	net.neoforged.neoforge.client.model.generators.template.ElementBuilder copy() {
		throw new UnsupportedOperationException("SteelWool does not implement ElementBuilder.copy yet");
	}
}
