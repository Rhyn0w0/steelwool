package net.neoforged.neoforge.client.data;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.mojang.serialization.Codec;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.WithConditions;
import net.neoforged.neoforge.common.data.JsonCodecProvider;

/**
 * SteelWool re-implementation of NeoForge's {@code SpriteSourceProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class SpriteSourceProvider extends JsonCodecProvider<List<Optional<WithConditions<SpriteSource>>>> {
	private static final Codec<List<Optional<WithConditions<SpriteSource>>>> CODEC = null /* SteelWool: TODO */;
	private final Map<Identifier, net.neoforged.neoforge.client.data.SpriteSourceProvider.SourceList> atlases;

	public SpriteSourceProvider(PackOutput arg0, CompletableFuture<HolderLookup.Provider> arg1, String arg2) {
		super((PackOutput) null, (PackOutput.Target) null, (String) null, (Codec) null, (CompletableFuture) null, (String) null);
		throw new UnsupportedOperationException("SteelWool does not implement the SpriteSourceProvider constructor yet");
	}

	protected final net.neoforged.neoforge.client.data.SpriteSourceProvider.SourceList atlas(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SpriteSourceProvider.atlas yet");
	}

	public static final class SourceList {
		private final List<Optional<WithConditions<SpriteSource>>> sources;

		private SourceList() {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the SpriteSourceProvider.SourceList constructor yet");
		}

		public net.neoforged.neoforge.client.data.SpriteSourceProvider.SourceList addSource(SpriteSource arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SpriteSourceProvider.SourceList.addSource yet");
		}

		public net.neoforged.neoforge.client.data.SpriteSourceProvider.SourceList addSource(SpriteSource arg0, ICondition... arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement SpriteSourceProvider.SourceList.addSource yet");
		}
	}
}
