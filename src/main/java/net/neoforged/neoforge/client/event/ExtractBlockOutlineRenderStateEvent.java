package net.neoforged.neoforge.client.event;

import java.util.List;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.extract.LevelExtractor;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.client.CustomBlockOutlineRenderer;

/**
 * SteelWool re-implementation of NeoForge's {@code ExtractBlockOutlineRenderStateEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ExtractBlockOutlineRenderStateEvent extends Event implements ICancellableEvent {
	private final LevelExtractor levelExtractor;
	private final ClientLevel level;
	private final BlockPos pos;
	private final BlockState state;
	private final BlockHitResult hitResult;
	private final CollisionContext collisionContext;
	private final boolean inTranslucentPass;
	private final boolean highContrast;
	private final Camera camera;
	private final LevelRenderState levelRenderState;
	private final List<CustomBlockOutlineRenderer> customRenderers;

	public ExtractBlockOutlineRenderStateEvent(LevelExtractor arg0, ClientLevel arg1, BlockPos arg2, BlockState arg3, BlockHitResult arg4, CollisionContext arg5, boolean arg6, boolean arg7, Camera arg8, LevelRenderState arg9) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ExtractBlockOutlineRenderStateEvent constructor yet");
	}

	public void addCustomRenderer(CustomBlockOutlineRenderer arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtractBlockOutlineRenderStateEvent.addCustomRenderer yet");
	}

	public LevelExtractor getLevelExtractor() {
		return this.levelExtractor;
	}

	public ClientLevel getLevel() {
		return this.level;
	}

	public BlockPos getBlockPos() {
		return this.pos;
	}

	public BlockState getBlockState() {
		return this.state;
	}

	public BlockHitResult getHitResult() {
		return this.hitResult;
	}

	public CollisionContext getCollisionContext() {
		return this.collisionContext;
	}

	public boolean isInTranslucentPass() {
		return this.inTranslucentPass;
	}

	public boolean isHighContrast() {
		return this.highContrast;
	}

	public Camera getCamera() {
		return this.camera;
	}

	public LevelRenderState getLevelRenderState() {
		return this.levelRenderState;
	}

	public List<CustomBlockOutlineRenderer> getCustomRenderers() {
		return this.customRenderers;
	}
}
