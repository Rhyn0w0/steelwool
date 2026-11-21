package net.neoforged.neoforge.fluids;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.material.Fluid;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidStackTemplate}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record FluidStackTemplate(Holder<Fluid> fluid, int amount, DataComponentPatch components) implements FluidInstance {
	public static final MapCodec<net.neoforged.neoforge.fluids.FluidStackTemplate> MAP_CODEC = com.mojang.serialization.codecs.RecordCodecBuilder.mapCodec(instance -> instance.group(
			FLUID_HOLDER_CODEC.fieldOf(FIELD_ID).forGetter(FluidStackTemplate::fluid),
			net.minecraft.util.ExtraCodecs.POSITIVE_INT.fieldOf(FIELD_AMOUNT).forGetter(FluidStackTemplate::amount),
			DataComponentPatch.CODEC.optionalFieldOf(FIELD_COMPONENTS, DataComponentPatch.EMPTY).forGetter(FluidStackTemplate::components))
			.apply(instance, FluidStackTemplate::new));
	/** The map form, or just a fluid name for one bucket of it. */
	public static final Codec<net.neoforged.neoforge.fluids.FluidStackTemplate> CODEC = Codec.withAlternative(MAP_CODEC.codec(), FLUID_HOLDER_CODEC,
			fluid -> new FluidStackTemplate(fluid, FluidType.BUCKET_VOLUME));
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.FluidStackTemplate> STREAM_CODEC = StreamCodec.composite(
			FLUID_HOLDER_STREAM_CODEC, FluidStackTemplate::fluid,
			net.minecraft.network.codec.ByteBufCodecs.VAR_INT, FluidStackTemplate::amount,
			DataComponentPatch.STREAM_CODEC, FluidStackTemplate::components,
			FluidStackTemplate::new);

	public FluidStackTemplate(Holder<Fluid> arg0, int arg1) {
		this(arg0, arg1, DataComponentPatch.EMPTY);
	}

	public FluidStackTemplate(Fluid fluid, int amount, DataComponentPatch components) {
		this(fluid.builtInRegistryHolder(), amount, components);
	}

	public FluidStackTemplate(Fluid arg0, int arg1) {
		this(arg0.builtInRegistryHolder(), arg1, DataComponentPatch.EMPTY);
	}

	public static net.neoforged.neoforge.fluids.FluidStackTemplate fromNonEmptyStack(FluidStack arg0) {
		if (arg0.isEmpty()) {
			throw new IllegalArgumentException("FluidStack must not be empty");
		}
		return new FluidStackTemplate(arg0.typeHolder(), arg0.getAmount(), arg0.getComponentsPatch());
	}

	public net.neoforged.neoforge.fluids.FluidStackTemplate withAmount(int arg0) {
		return new FluidStackTemplate(fluid, arg0, components);
	}

	public FluidStack create() {
		return new FluidStack(fluid, amount, components);
	}

	public FluidStack apply(DataComponentPatch arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.apply yet");
	}

	public FluidStack apply(int arg0, DataComponentPatch arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.apply yet");
	}

	public Holder<Fluid> typeHolder() {
		return this.fluid;
	}

	public <T extends Object> T get(DataComponentType<? extends T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.get yet");
	}

	public static Codec<net.neoforged.neoforge.fluids.FluidStackTemplate> fixedAmountCodec(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.fixedAmountCodec yet");
	}

	public static StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.FluidStackTemplate> fixedAmountStreamCodec(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.fixedAmountStreamCodec yet");
	}
}
