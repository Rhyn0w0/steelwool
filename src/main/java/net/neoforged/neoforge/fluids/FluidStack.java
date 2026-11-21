package net.neoforged.neoforge.fluids;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.core.component.TypedDataComponent;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import org.jspecify.annotations.Nullable;

/**
 * An amount of fluid with data components, the fluid counterpart of {@code ItemStack}. Amounts are in
 * millibuckets ({@link FluidType#BUCKET_VOLUME} is one bucket). {@link #EMPTY} is the only empty
 * stack instance that should be shared; a stack with a non-positive amount also counts as empty.
 */
public final class FluidStack implements MutableDataComponentHolder, FluidInstance {
	/** {@code {"id": fluid, "amount": n, "components": {...}}}; the amount must be positive. */
	public static final MapCodec<FluidStack> MAP_CODEC = MapCodec.recursive("FluidStack", self -> RecordCodecBuilder.mapCodec(instance -> instance.group(
			FLUID_HOLDER_CODEC_WITH_BOUND_COMPONENTS.fieldOf(FIELD_ID).forGetter(FluidStack::typeHolder),
			ExtraCodecs.POSITIVE_INT.fieldOf(FIELD_AMOUNT).forGetter(FluidStack::getAmount),
			DataComponentPatch.CODEC.optionalFieldOf(FIELD_COMPONENTS, DataComponentPatch.EMPTY).forGetter(stack -> stack.components.asPatch()))
			.apply(instance, FluidStack::new)));
	public static final Codec<FluidStack> CODEC = Codec.lazyInitialized(MAP_CODEC::codec);
	/** Like {@link #CODEC}, but an empty map decodes to {@link #EMPTY} and {@link #EMPTY} encodes to one. */
	public static final Codec<FluidStack> OPTIONAL_CODEC = ExtraCodecs.optionalEmptyMap(CODEC)
			.xmap(optional -> optional.orElse(FluidStack.EMPTY), stack -> stack.isEmpty() ? Optional.empty() : Optional.of(stack));
	/** Amount, then (if positive) fluid and component patch; an amount of 0 means empty. */
	public static final StreamCodec<RegistryFriendlyByteBuf, FluidStack> OPTIONAL_STREAM_CODEC = new StreamCodec<>() {
		@Override
		public FluidStack decode(RegistryFriendlyByteBuf buf) {
			int amount = buf.readVarInt();
			if (amount <= 0) {
				return EMPTY;
			}
			Holder<Fluid> fluid = FLUID_HOLDER_STREAM_CODEC.decode(buf);
			DataComponentPatch patch = DataComponentPatch.STREAM_CODEC.decode(buf);
			return new FluidStack(fluid, amount, patch);
		}

		@Override
		public void encode(RegistryFriendlyByteBuf buf, FluidStack stack) {
			if (stack.isEmpty()) {
				buf.writeVarInt(0);
				return;
			}
			buf.writeVarInt(stack.getAmount());
			FLUID_HOLDER_STREAM_CODEC.encode(buf, stack.typeHolder());
			DataComponentPatch.STREAM_CODEC.encode(buf, stack.components.asPatch());
		}
	};
	/** {@link #OPTIONAL_STREAM_CODEC}, but empty stacks are an error. */
	public static final StreamCodec<RegistryFriendlyByteBuf, FluidStack> STREAM_CODEC = new StreamCodec<>() {
		@Override
		public FluidStack decode(RegistryFriendlyByteBuf buf) {
			FluidStack stack = OPTIONAL_STREAM_CODEC.decode(buf);
			if (stack.isEmpty()) {
				throw new DecoderException("Empty FluidStack not allowed");
			}
			return stack;
		}

		@Override
		public void encode(RegistryFriendlyByteBuf buf, FluidStack stack) {
			if (stack.isEmpty()) {
				throw new EncoderException("Empty FluidStack not allowed");
			}
			OPTIONAL_STREAM_CODEC.encode(buf, stack);
		}
	};
	public static final FluidStack EMPTY = new FluidStack((Void) null);

	private int amount;
	private final Holder<Fluid> fluid;
	private final PatchedDataComponentMap components;

	/** A codec for stacks of exactly {@code amount}, which is not written. */
	public static Codec<FluidStack> fixedAmountCodec(int amount) {
		return Codec.lazyInitialized(() -> RecordCodecBuilder.create(instance -> instance.group(
				FLUID_HOLDER_CODEC.fieldOf(FIELD_ID).forGetter(FluidStack::typeHolder),
				DataComponentPatch.CODEC.optionalFieldOf(FIELD_COMPONENTS, DataComponentPatch.EMPTY).forGetter(stack -> stack.components.asPatch()))
				.apply(instance, (fluid, patch) -> new FluidStack(fluid, amount, patch))));
	}

	@Override
	public DataComponentMap getComponents() {
		return components;
	}

	/** The fluid's default components, before this stack's changes. */
	public DataComponentMap getPrototype() {
		return isEmpty() ? DataComponentMap.EMPTY : prototype(fluid);
	}

	public DataComponentPatch getComponentsPatch() {
		return isEmpty() ? DataComponentPatch.EMPTY : components.asPatch();
	}

	public DataComponentMap immutableComponents() {
		return isEmpty() ? DataComponentMap.EMPTY : components.toImmutableMap();
	}

	public boolean hasNonDefault(DataComponentType<?> type) {
		return !isEmpty() && components.hasNonDefault(type);
	}

	public boolean isComponentsPatchEmpty() {
		return isEmpty() || components.asPatch().isEmpty();
	}

	public FluidStack(Fluid fluid, int amount, DataComponentPatch patch) {
		this(fluid.builtInRegistryHolder(), amount, patch);
	}

	public FluidStack(Fluid fluid, int amount) {
		this(fluid.builtInRegistryHolder(), amount);
	}

	public FluidStack(Holder<Fluid> fluid, int amount) {
		this(fluid, amount, new PatchedDataComponentMap(prototype(fluid)));
	}

	public FluidStack(Holder<Fluid> fluid, int amount, DataComponentPatch patch) {
		this(fluid, amount, PatchedDataComponentMap.fromPatch(prototype(fluid), patch));
	}

	private FluidStack(Holder<Fluid> fluid, int amount, PatchedDataComponentMap components) {
		this.fluid = Objects.requireNonNull(fluid, "fluid");
		this.amount = amount;
		this.components = components;
	}

	private FluidStack(@Nullable Void unused) {
		this.fluid = Fluids.EMPTY.builtInRegistryHolder();
		this.amount = 0;
		this.components = new PatchedDataComponentMap(DataComponentMap.EMPTY);
	}

	private static DataComponentMap prototype(Holder<Fluid> fluid) {
		return fluid.areComponentsBound() ? fluid.components() : DataComponentMap.EMPTY;
	}

	public boolean isEmpty() {
		return this == EMPTY || fluid.value() == Fluids.EMPTY || amount <= 0;
	}

	/** Takes up to {@code amount} out of this stack and returns it as a new stack. */
	public FluidStack split(int amount) {
		int taken = Math.min(amount, this.amount);
		FluidStack result = copyWithAmount(taken);
		shrink(taken);
		return result;
	}

	public FluidStack copyAndClear() {
		if (isEmpty()) {
			return EMPTY;
		}
		FluidStack result = copy();
		setAmount(0);
		return result;
	}

	public Fluid getFluid() {
		return isEmpty() ? Fluids.EMPTY : fluid.value();
	}

	@Override
	public Holder<Fluid> typeHolder() {
		return isEmpty() ? Fluids.EMPTY.builtInRegistryHolder() : fluid;
	}

	public boolean is(Predicate<Holder<Fluid>> predicate) {
		return predicate.test(typeHolder());
	}

	public FluidStack copy() {
		return isEmpty() ? EMPTY : new FluidStack(fluid, amount, components.copy());
	}

	public FluidStack copyWithAmount(int amount) {
		if (isEmpty()) {
			return EMPTY;
		}
		FluidStack copy = copy();
		copy.setAmount(amount);
		return copy;
	}

	/** A copy with the same amount and component changes, but a different fluid. */
	public FluidStack transmuteCopy(Fluid newFluid) {
		return transmuteCopy(newFluid, amount);
	}

	public FluidStack transmuteCopy(Fluid newFluid, int newAmount) {
		return isEmpty() ? EMPTY : transmuteCopyIgnoreEmpty(newFluid, newAmount);
	}

	private FluidStack transmuteCopyIgnoreEmpty(Fluid newFluid, int newAmount) {
		return new FluidStack(newFluid.builtInRegistryHolder(), newAmount, components.asPatch());
	}

	/** Same fluid, components and amount. */
	public static boolean matches(FluidStack first, FluidStack second) {
		if (first == second) {
			return true;
		}
		return first.getAmount() == second.getAmount() && isSameFluidSameComponents(first, second);
	}

	public static boolean matches(FluidStack stack, FluidStackTemplate template) {
		return stack.getAmount() == template.amount() && isSameFluidSameComponents(stack, template);
	}

	public static boolean isSameFluid(FluidStack first, FluidStack second) {
		return first.getFluid() == second.getFluid();
	}

	public static boolean isSameFluidSameComponents(FluidStack first, FluidStack second) {
		if (!isSameFluid(first, second)) {
			return false;
		}
		return first.isEmpty() && second.isEmpty() || Objects.equals(first.components, second.components);
	}

	public static boolean isSameFluid(FluidStack stack, FluidStackTemplate template) {
		return stack.getFluid() == template.fluid().value();
	}

	public static boolean isSameFluidSameComponents(FluidStack stack, FluidStackTemplate template) {
		return isSameFluid(stack, template) && stack.getComponentsPatch().equals(template.components());
	}

	/** An optional field that reads a missing or invalid stack as {@link #EMPTY}. */
	public static MapCodec<FluidStack> lenientOptionalFieldOf(String name) {
		return CODEC.lenientOptionalFieldOf(name).xmap(optional -> optional.orElse(FluidStack.EMPTY), stack -> stack.isEmpty() ? Optional.empty() : Optional.of(stack));
	}

	public static int hashFluidAndComponents(@Nullable FluidStack stack) {
		if (stack == null) {
			return 0;
		}
		return 31 * stack.getFluid().hashCode() + stack.getComponents().hashCode();
	}

	public String getDescriptionId() {
		return getFluidType().getDescriptionId(this);
	}

	@Override
	public String toString() {
		return getAmount() + " " + getFluid();
	}

	public List<Component> getTooltipLines(Item.TooltipContext context, @Nullable Player player, TooltipFlag flag) {
		List<Component> lines = new ArrayList<>();
		lines.add(getHoverName());
		return lines;
	}

	@Override
	public <T> @Nullable T set(DataComponentType<T> type, @Nullable T value) {
		return components.set(type, value);
	}

	public <T> @Nullable T set(TypedDataComponent<T> component) {
		return components.set(component);
	}

	@Override
	public <T> @Nullable T remove(DataComponentType<? extends T> type) {
		return components.remove(type);
	}

	@Override
	public void applyComponents(DataComponentPatch patch) {
		components.applyPatch(patch);
	}

	@Override
	public void applyComponents(DataComponentMap map) {
		components.setAll(map);
	}

	public Component getHoverName() {
		return getFluidType().getDescription(this);
	}

	@Override
	public int amount() {
		return getAmount();
	}

	public int getAmount() {
		return isEmpty() ? 0 : amount;
	}

	public void setAmount(int amount) {
		if (this == EMPTY) {
			throw new UnsupportedOperationException("Cannot change the amount of FluidStack.EMPTY");
		}
		this.amount = amount;
	}

	public void limitSize(int maxAmount) {
		if (!isEmpty() && amount > maxAmount) {
			setAmount(maxAmount);
		}
	}

	public void grow(int amount) {
		setAmount(this.amount + amount);
	}

	public void shrink(int amount) {
		grow(-amount);
	}
}
