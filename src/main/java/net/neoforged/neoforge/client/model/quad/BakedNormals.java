package net.neoforged.neoforge.client.model.quad;

import org.joml.Vector3f;
import org.joml.Vector3fc;

/**
 * SteelWool re-implementation of NeoForge's {@code BakedNormals}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface BakedNormals {
	public static final net.neoforged.neoforge.client.model.quad.BakedNormals UNSPECIFIED = null /* SteelWool: TODO */;

	int normal(int arg0);

	static net.neoforged.neoforge.client.model.quad.BakedNormals of(int arg0, int arg1, int arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.of yet");
	}

	static net.neoforged.neoforge.client.model.quad.BakedNormals of(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.of yet");
	}

	static int pack(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.pack yet");
	}

	static int pack(Vector3fc arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.pack yet");
	}

	static float unpackComponent(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.unpackComponent yet");
	}

	static float unpackX(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.unpackX yet");
	}

	static float unpackY(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.unpackY yet");
	}

	static float unpackZ(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.unpackZ yet");
	}

	static Vector3f unpack(int arg0, Vector3f arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.unpack yet");
	}

	static boolean isUnspecified(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.isUnspecified yet");
	}

	static int computeQuadNormal(Vector3fc arg0, Vector3fc arg1, Vector3fc arg2, Vector3fc arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.computeQuadNormal yet");
	}

	public static record PerQuad(int normal) implements net.neoforged.neoforge.client.model.quad.BakedNormals {
		public int normal(int arg0) {
			return this.normal;
		}
	}

	public static record PerVertex(int normal0, int normal1, int normal2, int normal3) implements net.neoforged.neoforge.client.model.quad.BakedNormals {
		public int normal(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BakedNormals.PerVertex.normal yet");
		}
	}
}
