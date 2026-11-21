package net.neoforged.neoforge.client.model.quad;

import com.mojang.blaze3d.platform.Transparency;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/**
 * SteelWool re-implementation of NeoForge's {@code MutableQuad}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class MutableQuad {
	private final Vector3f[] positions;
	private final long[] uvs;
	private final int[] normals;
	private final int[] colors;
	private Direction direction;
	private TextureAtlasSprite sprite;
	private ChunkSectionLayer chunkLayer;
	private RenderType itemRenderType;
	private RenderType itemGlintRenderType;
	private RenderType itemGlintSpecialRenderType;
	private int tintIndex;
	private Direction shadeOverride;
	private int lightEmission;
	private boolean ambientOcclusion;
	private BakedQuad lastSourceQuad;

	public MutableQuad() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the MutableQuad constructor yet");
	}

	public float x(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.x yet");
	}

	public float y(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.y yet");
	}

	public float z(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.z yet");
	}

	public float positionComponent(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.positionComponent yet");
	}

	public Vector3f copyPosition(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.copyPosition yet");
	}

	public Vector3f copyPosition(int arg0, Vector3f arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.copyPosition yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setX(int arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setX yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setY(int arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setY yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setZ(int arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setZ yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setPositionComponent(int arg0, int arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setPositionComponent yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setPosition(int arg0, float arg1, float arg2, float arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setPosition yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setPosition(int arg0, Vector3fc arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setPosition yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setCubeFaceFromSpriteCoords(Direction arg0, float arg1, float arg2, float arg3, float arg4, float arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setCubeFaceFromSpriteCoords yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setFullCubeFace(Direction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setFullCubeFace yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setCubeFace(Direction arg0, Vector3fc arg1, Vector3fc arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setCubeFace yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setCubeFace(Direction arg0, float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setCubeFace yet");
	}

	public float u(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.u yet");
	}

	public float v(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.v yet");
	}

	public float uvComponent(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.uvComponent yet");
	}

	public long packedUv(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.packedUv yet");
	}

	public Vector2f copyUv(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.copyUv yet");
	}

	public Vector2f copyUv(int arg0, Vector2f arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.copyUv yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setUv(int arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setUv yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setUv(int arg0, Vector2fc arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setUv yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setUvComponent(int arg0, int arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setUvComponent yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setPackedUv(int arg0, long arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setPackedUv yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setUvFromSprite(int arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setUvFromSprite yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setUvFromSprite(int arg0, Vector2fc arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setUvFromSprite yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad bakeUvsFromPosition() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.bakeUvsFromPosition yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad bakeUvsFromPosition(UVTransform arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.bakeUvsFromPosition yet");
	}

	public int tintIndex() {
		return this.tintIndex;
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setTintIndex(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setTintIndex yet");
	}

	public Direction direction() {
		return this.direction;
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setDirection(Direction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setDirection yet");
	}

	public TextureAtlasSprite sprite() {
		return this.sprite;
	}

	public TextureAtlasSprite requiredSprite() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.requiredSprite yet");
	}

	public ChunkSectionLayer chunkLayer() {
		return this.chunkLayer;
	}

	public ChunkSectionLayer requiredChunkLayer() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.requiredChunkLayer yet");
	}

	public RenderType itemRenderType() {
		return this.itemRenderType;
	}

	public RenderType requiredItemRenderType() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.requiredItemRenderType yet");
	}

	public RenderType itemGlintRenderType() {
		return this.itemRenderType;
	}

	public RenderType requiredItemGlintRenderType() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.requiredItemGlintRenderType yet");
	}

	public RenderType itemGlintSpecialRenderType() {
		return this.itemGlintSpecialRenderType;
	}

	public RenderType requiredItemGlintSpecialRenderType() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.requiredItemGlintSpecialRenderType yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setSprite(Material.Baked arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setSprite yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setSprite(Material.Baked arg0, Transparency arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setSprite yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setSprite(TextureAtlasSprite arg0, ChunkSectionLayer arg1, RenderType arg2, RenderType arg3, RenderType arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setSprite yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setSpriteAndMoveUv(Material.Baked arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setSpriteAndMoveUv yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setSpriteAndMoveUv(Material.Baked arg0, Transparency arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setSpriteAndMoveUv yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setSpriteAndMoveUv(TextureAtlasSprite arg0, ChunkSectionLayer arg1, RenderType arg2, RenderType arg3, RenderType arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setSpriteAndMoveUv yet");
	}

	public Direction shadeOverride() {
		return this.shadeOverride;
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setShadeOverride(Direction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setShadeOverride yet");
	}

	public int lightEmission() {
		return this.lightEmission;
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setLightEmission(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setLightEmission yet");
	}

	public float normalX(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.normalX yet");
	}

	public float normalY(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.normalY yet");
	}

	public float normalZ(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.normalZ yet");
	}

	public float normalComponent(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.normalComponent yet");
	}

	public int packedNormal(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.packedNormal yet");
	}

	public Vector3f copyNormal(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.copyNormal yet");
	}

	public Vector3f copyNormal(int arg0, Vector3f arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.copyNormal yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setNormal(int arg0, float arg1, float arg2, float arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setNormal yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setNormal(int arg0, Vector3fc arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setNormal yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setNormalComponent(int arg0, int arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setNormalComponent yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setPackedNormal(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setPackedNormal yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setNormal(BakedNormals arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setNormal yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad recomputeNormals(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.recomputeNormals yet");
	}

	public int color(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.color yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setColor(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setColor yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setColor(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setColor yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setColor(int arg0, int arg1, int arg2, int arg3, int arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setColor yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setColor(BakedColors arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setColor yet");
	}

	public boolean hasAmbientOcclusion() {
		return this.ambientOcclusion;
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setAmbientOcclusion(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setAmbientOcclusion yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad setFrom(BakedQuad arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.setFrom yet");
	}

	private void transformUvsFromSpriteToAtlas() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.transformUvsFromSpriteToAtlas yet");
	}

	private void transformUvsFromAtlasToSprite() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.transformUvsFromAtlasToSprite yet");
	}

	public BakedQuad toBakedQuad() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.toBakedQuad yet");
	}

	private static Vector3fc reuseVector(BakedQuad arg0, Vector3f arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.reuseVector yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad transform(Matrix4f arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.transform yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad recalculateWinding() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.recalculateWinding yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad copy() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.copy yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad copyInto(net.neoforged.neoforge.client.model.quad.MutableQuad arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.copyInto yet");
	}

	public net.neoforged.neoforge.client.model.quad.MutableQuad reset() {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.reset yet");
	}

	private static Transparency getTransparency(Material.Baked arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableQuad.getTransparency yet");
	}
}
