package net.neoforged.neoforge.registries.holdersets;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;

/**
 * SteelWool re-implementation of NeoForge's {@code HolderSetType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface HolderSetType {
	<T extends Object> MapCodec<? extends ICustomHolderSet<T>> makeCodec(ResourceKey<? extends Registry<T>> arg0, Codec<Holder<T>> arg1, boolean arg2);

	<T extends Object> StreamCodec<RegistryFriendlyByteBuf, ? extends ICustomHolderSet<T>> makeStreamCodec(ResourceKey<? extends Registry<T>> arg0);
}
