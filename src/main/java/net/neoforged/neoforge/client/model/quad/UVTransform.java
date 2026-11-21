package net.neoforged.neoforge.client.model.quad;

import com.mojang.math.Quadrant;

/**
 * SteelWool re-implementation of NeoForge's {@code UVTransform}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class UVTransform {
	private static final net.neoforged.neoforge.client.model.quad.UVTransform[] TRANSFORMS = null /* SteelWool: TODO */;
	public static final net.neoforged.neoforge.client.model.quad.UVTransform IDENTITY = null /* SteelWool: TODO */;
	final int rotation;
	final boolean flipU;
	final boolean flipV;
	final Quadrant quadrant;

	private UVTransform(Quadrant arg0, boolean arg1, boolean arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the UVTransform constructor yet");
	}

	public boolean isIdentity() {
		throw new UnsupportedOperationException("SteelWool does not implement UVTransform.isIdentity yet");
	}

	public static net.neoforged.neoforge.client.model.quad.UVTransform of(Quadrant arg0, boolean arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement UVTransform.of yet");
	}

	public long transformPacked(long arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement UVTransform.transformPacked yet");
	}

	private static net.neoforged.neoforge.client.model.quad.UVTransform[] createTransforms() {
		throw new UnsupportedOperationException("SteelWool does not implement UVTransform.createTransforms yet");
	}

	private static int makeIndex(int arg0, boolean arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement UVTransform.makeIndex yet");
	}
}
