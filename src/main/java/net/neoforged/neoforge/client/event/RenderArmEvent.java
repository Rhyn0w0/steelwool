package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.HumanoidArm;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderArmEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RenderArmEvent extends Event implements ICancellableEvent {
	private final PoseStack poseStack;
	private final SubmitNodeCollector submitNodeCollector;
	private final int lightCoords;
	private final Identifier skinTexture;
	private final boolean hasSleeve;
	private final PlayerRenderState playerRenderState;
	private final HumanoidArm arm;
	private final ModelPart armPart;

	public RenderArmEvent(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, Identifier skinTexture, boolean hasSleeve, PlayerRenderState playerRenderState, HumanoidArm arm, ModelPart armPart) {
		super();
		this.poseStack = poseStack;
		this.submitNodeCollector = submitNodeCollector;
		this.lightCoords = lightCoords;
		this.skinTexture = skinTexture;
		this.hasSleeve = hasSleeve;
		this.playerRenderState = playerRenderState;
		this.arm = arm;
		this.armPart = armPart;
	}

	public HumanoidArm getArm() {
		return this.arm;
	}

	public PoseStack getPoseStack() {
		return this.poseStack;
	}

	public SubmitNodeCollector getSubmitNodeCollector() {
		return this.submitNodeCollector;
	}

	public int getLightCoords() {
		return this.lightCoords;
	}

	public Identifier getSkinTexture() {
		return this.skinTexture;
	}

	public boolean hasSleeve() {
		return this.hasSleeve;
	}

	public ModelPart getArmPart() {
		return this.armPart;
	}

	public PlayerRenderState getPlayerRenderState() {
		return this.playerRenderState;
	}
}
