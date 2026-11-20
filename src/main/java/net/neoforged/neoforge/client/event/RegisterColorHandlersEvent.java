package net.neoforged.neoforge.client.event;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterColorHandlersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class RegisterColorHandlersEvent extends Event implements IModBusEvent {
	protected RegisterColorHandlersEvent() {
		super();
	}

	public static class BlockTintSources extends net.neoforged.neoforge.client.event.RegisterColorHandlersEvent {
		private final BlockColors blockColors;

		public BlockTintSources(BlockColors blockColors) {
			super();
			this.blockColors = blockColors;
		}

		public BlockColors getBlockColors() {
			return this.blockColors;
		}

		public void register(List<BlockTintSource> arg0, Block... arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement RegisterColorHandlersEvent.BlockTintSources.register yet");
		}
	}

	public static class ColorResolvers extends net.neoforged.neoforge.client.event.RegisterColorHandlersEvent {
		private final ImmutableList.Builder<ColorResolver> builder;

		public ColorResolvers(ImmutableList.Builder<ColorResolver> builder) {
			super();
			this.builder = builder;
		}

		public void register(ColorResolver arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement RegisterColorHandlersEvent.ColorResolvers.register yet");
		}
	}

	public static class ItemTintSources extends net.neoforged.neoforge.client.event.RegisterColorHandlersEvent {
		private final ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends ItemTintSource>> idMapper;

		public ItemTintSources(ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends ItemTintSource>> idMapper) {
			super();
			this.idMapper = idMapper;
		}

		public void register(Identifier arg0, MapCodec<? extends ItemTintSource> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement RegisterColorHandlersEvent.ItemTintSources.register yet");
		}
	}
}
