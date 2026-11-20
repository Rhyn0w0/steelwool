package net.neoforged.neoforge.registries.datamaps.builtin;

import java.util.Map;
import java.util.Optional;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.registries.datamaps.DataMapValueRemover;

/**
 * SteelWool re-implementation of NeoForge's {@code Transformable}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record Transformable(Map<ResourceKey<BlockTransformer>, BlockTransformer.BlockTransformData> transformers) {
	private static final Codec<ResourceKey<BlockTransformer>> KEY_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.Transformable> CODEC = null /* SteelWool: TODO */;

	public Transformable(ResourceKey<BlockTransformer> arg0, BlockTransformer.BlockTransformData arg1) {
		this((Map) null);
		throw new UnsupportedOperationException("SteelWool does not implement the Transformable constructor yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable stripping(Block arg0, Block arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.stripping yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable scraping(Block arg0, Block arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.scraping yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable waxOff(Block arg0, Block arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.waxOff yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable axe(BlockTransformer.BlockTransformData arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.axe yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable flattening(Block arg0, Block arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.flattening yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable shovel(BlockTransformer.BlockTransformData arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.shovel yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable tilling(Block arg0, Block arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.tilling yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable tilling(Block arg0, Block arg1, ResourceKey<LootTable> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.tilling yet");
	}

	public static net.neoforged.neoforge.registries.datamaps.builtin.Transformable hoe(BlockTransformer.BlockTransformData arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.hoe yet");
	}

	private static net.neoforged.neoforge.registries.datamaps.builtin.Transformable unpack(Either<Pair<ResourceKey<BlockTransformer>, BlockTransformer.BlockTransformData>, Map<ResourceKey<BlockTransformer>, BlockTransformer.BlockTransformData>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.unpack yet");
	}

	private static Either<Pair<ResourceKey<BlockTransformer>, BlockTransformer.BlockTransformData>, Map<ResourceKey<BlockTransformer>, BlockTransformer.BlockTransformData>> pack(net.neoforged.neoforge.registries.datamaps.builtin.Transformable arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Transformable.pack yet");
	}

	public static record Remover(ResourceKey<BlockTransformer> toRemove) implements DataMapValueRemover<Block, net.neoforged.neoforge.registries.datamaps.builtin.Transformable> {
		public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.Transformable.Remover> CODEC = null /* SteelWool: TODO */;

		public Optional<net.neoforged.neoforge.registries.datamaps.builtin.Transformable> remove(net.neoforged.neoforge.registries.datamaps.builtin.Transformable arg0, Registry<Block> arg1, Either<TagKey<Block>, ResourceKey<Block>> arg2, Block arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement Transformable.Remover.remove yet");
		}
	}
}
