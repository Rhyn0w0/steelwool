package net.neoforged.neoforge.fluids;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import dev.steelwool.fluid.FluidTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.TypedInstance;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

/** An amount of a fluid, with components: a {@link FluidStack} or a {@link FluidStackTemplate}. */
public interface FluidInstance extends TypedInstance<Fluid>, DataComponentGetter {
	String FIELD_ID = "id";
	String FIELD_AMOUNT = "amount";
	String FIELD_COMPONENTS = "components";

	/** A fluid by name; the empty fluid is not allowed. */
	Codec<Holder<Fluid>> FLUID_HOLDER_CODEC = BuiltInRegistries.FLUID.holderByNameCodec()
			.validate(fluid -> fluid.is(Fluids.EMPTY.builtInRegistryHolder())
					? DataResult.error(() -> "Fluid must not be minecraft:empty")
					: DataResult.success(fluid));

	StreamCodec<RegistryFriendlyByteBuf, Holder<Fluid>> FLUID_HOLDER_STREAM_CODEC = ByteBufCodecs.holderRegistry(Registries.FLUID);

	Codec<Holder<Fluid>> FLUID_HOLDER_CODEC_WITH_BOUND_COMPONENTS = FLUID_HOLDER_CODEC.validate(fluid -> fluid.areComponentsBound()
			? DataResult.success(fluid)
			: DataResult.error(() -> "Fluid " + fluid.getRegisteredName() + " does not have components yet"));

	int amount();

	default FluidType getFluidType() {
		return FluidTypes.of(typeHolder().value());
	}

	default boolean is(FluidType type) {
		return getFluidType() == type;
	}
}
