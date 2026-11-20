package net.neoforged.neoforge.client.model.generators.template;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.math.Transformation;
import net.neoforged.neoforge.common.util.TransformationHelper;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/**
 * SteelWool re-implementation of NeoForge's {@code RootTransformsBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RootTransformsBuilder {
	private static final Vector3f ONE = null /* SteelWool: TODO */;
	private Vector3fc translation;
	private Quaternionfc leftRotation;
	private Quaternionfc rightRotation;
	private Vector3fc scale;
	private TransformationHelper.TransformOrigin origin;
	private Vector3fc originVec;

	public RootTransformsBuilder() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RootTransformsBuilder constructor yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder translation(Vector3f arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.translation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder translation(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.translation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder rotation(Quaternionf arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.rotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder rotation(float arg0, float arg1, float arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.rotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder leftRotation(Quaternionf arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.leftRotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder leftRotation(float arg0, float arg1, float arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.leftRotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder rightRotation(Quaternionf arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.rightRotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder rightRotation(float arg0, float arg1, float arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.rightRotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder postRotation(Quaternionf arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.postRotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder postRotation(float arg0, float arg1, float arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.postRotation yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder scale(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.scale yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder scale(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.scale yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder scale(Vector3f arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.scale yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder transform(Transformation arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.transform yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder origin(Vector3f arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.origin yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder origin(TransformationHelper.TransformOrigin arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.origin yet");
	}

	JsonObject toJson() {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.toJson yet");
	}

	private static JsonArray writeVec3(Vector3fc arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.writeVec3 yet");
	}

	private static JsonArray writeQuaternion(Quaternionfc arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.writeQuaternion yet");
	}

	void copyFrom(net.neoforged.neoforge.client.model.generators.template.RootTransformsBuilder arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootTransformsBuilder.copyFrom yet");
	}
}
