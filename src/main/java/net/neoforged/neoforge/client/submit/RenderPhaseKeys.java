package net.neoforged.neoforge.client.submit;

import net.minecraft.client.renderer.feature.submit.SubmitNode;
import net.minecraft.client.renderer.feature.submit.TranslucentSubmit;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderPhaseKeys}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RenderPhaseKeys {
	public static final RenderPhaseKey<SubmitNode> SOLID = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> SHADOWS = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> NAME_TAGS = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> TEXTS = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> SHAPE_OUTLINES = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<? super TranslucentSubmit> TRANSLUCENT_BLOCKS_AND_ITEMS = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<? super TranslucentSubmit> TRANSLUCENT_MODELS = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> TRANSLUCENT_CUSTOM_GEOMETRY = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> TRANSLUCENT_GIZMOS = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> BREAKING_OVERLAY = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> WATER_MASK = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> AFTER_TERRAIN = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> ALWAYS_ON_TOP = null /* SteelWool: TODO */;
	public static final RenderPhaseKey<SubmitNode> OUTLINE = null /* SteelWool: TODO */;

	private RenderPhaseKeys() {
		super();
	}
}
