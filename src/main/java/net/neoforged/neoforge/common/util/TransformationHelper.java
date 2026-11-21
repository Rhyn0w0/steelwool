package net.neoforged.neoforge.common.util;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.math.Transformation;
import net.minecraft.util.StringRepresentable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;

/**
 * SteelWool re-implementation of NeoForge's {@code TransformationHelper}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class TransformationHelper {
	private static final double THRESHOLD = 0.9995d;

	public TransformationHelper() {
		super();
	}

	public static Quaternionf quatFromXYZ(Vector3f arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.quatFromXYZ yet");
	}

	public static Quaternionf quatFromXYZ(float[] arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.quatFromXYZ yet");
	}

	public static Quaternionf quatFromXYZ(float arg0, float arg1, float arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.quatFromXYZ yet");
	}

	public static Quaternionf makeQuaternion(float[] arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.makeQuaternion yet");
	}

	public static Vector3f lerp(Vector3fc arg0, Vector3fc arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.lerp yet");
	}

	public static Quaternionf slerp(Quaternionfc arg0, Quaternionfc arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.slerp yet");
	}

	public static Transformation slerp(Transformation arg0, Transformation arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.slerp yet");
	}

	public static boolean epsilonEquals(Vector4f arg0, Vector4f arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.epsilonEquals yet");
	}

	public static class Deserializer extends Object implements JsonDeserializer<Transformation> {
		public Deserializer() {
			super();
		}

		public Transformation deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
			throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.Deserializer.deserialize yet");
		}

		private static Vector3f parseOrigin(JsonObject arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.Deserializer.parseOrigin yet");
		}

		public static Matrix4f parseMatrix(JsonElement arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.Deserializer.parseMatrix yet");
		}

		public static float[] parseFloatArray(JsonElement arg0, int arg1, String arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.Deserializer.parseFloatArray yet");
		}

		public static Quaternionf parseAxisRotation(JsonElement arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.Deserializer.parseAxisRotation yet");
		}

		public static Quaternionf parseRotation(JsonElement arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement TransformationHelper.Deserializer.parseRotation yet");
		}
	}

	public enum TransformOrigin implements StringRepresentable {
		CENTER(new Vector3f(0.5f, 0.5f, 0.5f), "center"),
		CORNER(new Vector3f(), "corner"),
		OPPOSING_CORNER(new Vector3f(1, 1, 1), "opposing-corner");

		private final Vector3f vec;
		private final String name;

		TransformOrigin(Vector3f vec, String name) {
			this.vec = vec;
			this.name = name;
		}

		public Vector3f getVector() {
			return this.vec;
		}

		public String getSerializedName() {
			return this.name;
		}

		public static net.neoforged.neoforge.common.util.TransformationHelper.TransformOrigin fromString(String name) {
			for (TransformOrigin origin : values()) {
				if (origin.name.equals(name)) {
					return origin;
				}
			}
			return null;
		}
	}
}
