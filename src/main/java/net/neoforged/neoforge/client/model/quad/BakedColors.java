package net.neoforged.neoforge.client.model.quad;

/**
 * SteelWool re-implementation of NeoForge's {@code BakedColors}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface BakedColors {
	public static final net.neoforged.neoforge.client.model.quad.BakedColors DEFAULT = null /* SteelWool: TODO */;

	int color(int arg0);

	static net.neoforged.neoforge.client.model.quad.BakedColors of(int arg0, int arg1, int arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedColors.of yet");
	}

	static net.neoforged.neoforge.client.model.quad.BakedColors of(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BakedColors.of yet");
	}

	public static record PerQuad(int color) implements net.neoforged.neoforge.client.model.quad.BakedColors {
		public int color(int arg0) {
			return this.color;
		}
	}

	public static record PerVertex(int color0, int color1, int color2, int color3) implements net.neoforged.neoforge.client.model.quad.BakedColors {
		public int color(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BakedColors.PerVertex.color yet");
		}
	}
}
