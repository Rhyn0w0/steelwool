package net.neoforged.neoforge.registries.holdersets;

import java.util.List;
import java.util.Set;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;

/**
 * SteelWool re-implementation of NeoForge's {@code OrHolderSet}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class OrHolderSet<T extends Object> extends CompositeHolderSet<T> {
	public OrHolderSet(List<HolderSet<T>> arg0) {
		super(arg0);
	}

	public OrHolderSet(HolderSet<T>... arg0) {
		this((List) null);
		throw new UnsupportedOperationException("SteelWool does not implement the OrHolderSet constructor yet");
	}

	public HolderSetType type() {
		throw new UnsupportedOperationException("SteelWool does not implement OrHolderSet.type yet");
	}

	protected Set<Holder<T>> createSet() {
		throw new UnsupportedOperationException("SteelWool does not implement OrHolderSet.createSet yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement OrHolderSet.toString yet");
	}

	public static class Type implements HolderSetType {
		public Type() {
			super();
		}

		public <T extends Object> MapCodec<? extends ICustomHolderSet<T>> makeCodec(ResourceKey<? extends Registry<T>> arg0, Codec<Holder<T>> arg1, boolean arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement OrHolderSet.Type.makeCodec yet");
		}

		public <T extends Object> StreamCodec<RegistryFriendlyByteBuf, ? extends ICustomHolderSet<T>> makeStreamCodec(ResourceKey<? extends Registry<T>> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement OrHolderSet.Type.makeStreamCodec yet");
		}
	}
}
