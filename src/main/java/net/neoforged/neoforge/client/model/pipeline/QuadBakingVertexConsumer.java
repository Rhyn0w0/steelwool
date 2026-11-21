package net.neoforged.neoforge.client.model.pipeline;

import com.mojang.blaze3d.platform.Transparency;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.renderpearl.api.vertex.VertexFormatElement;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import org.joml.Vector3f;

/**
 * SteelWool re-implementation of NeoForge's {@code QuadBakingVertexConsumer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class QuadBakingVertexConsumer implements VertexConsumer {
	private final Vector3f[] positions;
	private final long[] uvs;
	private final int[] normals;
	private final int[] colors;
	private int vertexIndex;
	private boolean building;
	private int tintIndex;
	private Direction direction;
	private TextureAtlasSprite sprite;
	private ChunkSectionLayer chunkLayer;
	private RenderType itemRenderType;
	private RenderType itemGlintRenderType;
	private RenderType itemGlintSpecialRenderType;
	private Direction shadeOverride;
	private int lightEmission;
	private boolean ambientOcclusion;

	public QuadBakingVertexConsumer() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the QuadBakingVertexConsumer constructor yet");
	}

	public VertexConsumer addVertex(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.addVertex yet");
	}

	public VertexConsumer setNormal(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setNormal yet");
	}

	public VertexConsumer setColor(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setColor yet");
	}

	public VertexConsumer setColor(int arg0, int arg1, int arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setColor yet");
	}

	public VertexConsumer setUv(float arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setUv yet");
	}

	public VertexConsumer setUv1(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setUv1 yet");
	}

	public VertexConsumer setUv2(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setUv2 yet");
	}

	public VertexConsumer setUv3(float arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setUv3 yet");
	}

	public VertexConsumer misc(VertexFormatElement arg0, int... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.misc yet");
	}

	public VertexConsumer setLineWidth(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setLineWidth yet");
	}

	public void setTintIndex(int tintIndex) {
		this.tintIndex = tintIndex;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setSprite(Material.Baked arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setSprite yet");
	}

	public void setSprite(Material.Baked arg0, Transparency arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setSprite yet");
	}

	public void setSprite(TextureAtlasSprite arg0, ChunkSectionLayer arg1, RenderType arg2, RenderType arg3, RenderType arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.setSprite yet");
	}

	public void setShadeOverride(Direction shadeOverride) {
		this.shadeOverride = shadeOverride;
	}

	public void setLightEmission(int lightEmission) {
		this.lightEmission = lightEmission;
	}

	public void setAmbientOcclusion(boolean ambientOcclusion) {
		this.ambientOcclusion = ambientOcclusion;
	}

	public BakedQuad bakeQuad() {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.bakeQuad yet");
	}

	public BakedQuad bakeQuad(ModelBaker.Interner arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.bakeQuad yet");
	}

	private void clear() {
		throw new UnsupportedOperationException("SteelWool does not implement QuadBakingVertexConsumer.clear yet");
	}
}
