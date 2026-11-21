package net.neoforged.neoforge.fluids.crafting;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidIngredientType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record FluidIngredientType<T extends FluidIngredient>(MapCodec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
	public FluidIngredientType(MapCodec<T> arg0) {
		this((MapCodec) null, (StreamCodec) null);
		throw new UnsupportedOperationException("SteelWool does not implement the FluidIngredientType constructor yet");
	}
}
