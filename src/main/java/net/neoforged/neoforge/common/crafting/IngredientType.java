package net.neoforged.neoforge.common.crafting;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code IngredientType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record IngredientType<T extends ICustomIngredient>(MapCodec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
	public IngredientType(MapCodec<T> arg0) {
		this((MapCodec) null, (StreamCodec) null);
		throw new UnsupportedOperationException("SteelWool does not implement the IngredientType constructor yet");
	}
}
