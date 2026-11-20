package net.neoforged.neoforge.fluids;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.TypedInstance;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.material.Fluid;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidInstance}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface FluidInstance extends TypedInstance<Fluid>, DataComponentGetter {
	public static final String FIELD_ID = "id";
	public static final String FIELD_AMOUNT = "amount";
	public static final String FIELD_COMPONENTS = "components";
	public static final Codec<Holder<Fluid>> FLUID_HOLDER_CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, Holder<Fluid>> FLUID_HOLDER_STREAM_CODEC = null /* SteelWool: TODO */;
	public static final Codec<Holder<Fluid>> FLUID_HOLDER_CODEC_WITH_BOUND_COMPONENTS = null /* SteelWool: TODO */;

	int amount();

	default FluidType getFluidType() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidInstance.getFluidType yet");
	}

	default boolean is(FluidType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidInstance.is yet");
	}
}
