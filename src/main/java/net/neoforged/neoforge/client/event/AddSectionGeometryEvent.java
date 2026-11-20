package net.neoforged.neoforge.client.event;

import java.util.List;
import java.util.function.Function;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code AddSectionGeometryEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AddSectionGeometryEvent extends Event {
	private final List<net.neoforged.neoforge.client.event.AddSectionGeometryEvent.AdditionalSectionRenderer> additionalRenderers;
	private final BlockPos sectionOrigin;
	private final Level level;

	public AddSectionGeometryEvent(BlockPos arg0, Level arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the AddSectionGeometryEvent constructor yet");
	}

	public void addRenderer(net.neoforged.neoforge.client.event.AddSectionGeometryEvent.AdditionalSectionRenderer arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AddSectionGeometryEvent.addRenderer yet");
	}

	public List<net.neoforged.neoforge.client.event.AddSectionGeometryEvent.AdditionalSectionRenderer> getAdditionalRenderers() {
		return this.additionalRenderers;
	}

	public BlockPos getSectionOrigin() {
		return this.sectionOrigin;
	}

	public Level getLevel() {
		throw new UnsupportedOperationException("SteelWool does not implement AddSectionGeometryEvent.getLevel yet");
	}

	public interface AdditionalSectionRenderer {
		void render(net.neoforged.neoforge.client.event.AddSectionGeometryEvent.SectionRenderingContext arg0);
	}

	public static final class SectionRenderingContext {
		private final Function<ChunkSectionLayer, VertexConsumer> getOrCreateLayer;
		private final BlockAndTintGetter region;
		private final ModelBlockRenderer blockRenderer;

		public SectionRenderingContext(Function<ChunkSectionLayer, VertexConsumer> getOrCreateLayer, BlockAndTintGetter region, ModelBlockRenderer blockRenderer) {
			super();
			this.getOrCreateLayer = getOrCreateLayer;
			this.region = region;
			this.blockRenderer = blockRenderer;
		}

		public VertexConsumer getOrCreateChunkBuffer(ChunkSectionLayer arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement AddSectionGeometryEvent.SectionRenderingContext.getOrCreateChunkBuffer yet");
		}

		public ModelBlockRenderer getBlockRenderer() {
			return this.blockRenderer;
		}

		public BlockAndTintGetter getRegion() {
			return this.region;
		}
	}
}
