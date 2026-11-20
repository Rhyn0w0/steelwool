package net.neoforged.neoforge.fluids;

import java.util.List;
import java.util.function.Predicate;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.core.component.TypedDataComponent;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.MutableDataComponentHolder;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidStack}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class FluidStack implements MutableDataComponentHolder,FluidInstance {
	public static final MapCodec<net.neoforged.neoforge.fluids.FluidStack> MAP_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.fluids.FluidStack> CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.fluids.FluidStack> OPTIONAL_CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.FluidStack> OPTIONAL_STREAM_CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.FluidStack> STREAM_CODEC = null /* SteelWool: TODO */;
	public static final net.neoforged.neoforge.fluids.FluidStack EMPTY = null /* SteelWool: TODO */;
	private int amount;
	private final Holder<Fluid> fluid;
	private final PatchedDataComponentMap components;

	public static Codec<net.neoforged.neoforge.fluids.FluidStack> fixedAmountCodec(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.fixedAmountCodec yet");
	}

	public DataComponentMap getComponents() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.getComponents yet");
	}

	public DataComponentMap getPrototype() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.getPrototype yet");
	}

	public DataComponentPatch getComponentsPatch() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.getComponentsPatch yet");
	}

	public DataComponentMap immutableComponents() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.immutableComponents yet");
	}

	public boolean hasNonDefault(DataComponentType<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.hasNonDefault yet");
	}

	public boolean isComponentsPatchEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.isComponentsPatchEmpty yet");
	}

	public FluidStack(Fluid arg0, int arg1, DataComponentPatch arg2) {
		this((Holder) null, (int) 0, (DataComponentPatch) null);
		throw new UnsupportedOperationException("SteelWool does not implement the FluidStack constructor yet");
	}

	public FluidStack(Fluid arg0, int arg1) {
		this((Fluid) null, (int) 0, (DataComponentPatch) null);
		throw new UnsupportedOperationException("SteelWool does not implement the FluidStack constructor yet");
	}

	public FluidStack(Holder<Fluid> arg0, int arg1) {
		this((Holder) null, (int) 0, (DataComponentPatch) null);
		throw new UnsupportedOperationException("SteelWool does not implement the FluidStack constructor yet");
	}

	public FluidStack(Holder<Fluid> arg0, int arg1, DataComponentPatch arg2) {
		this((Holder) null, (int) 0, (PatchedDataComponentMap) null);
		throw new UnsupportedOperationException("SteelWool does not implement the FluidStack constructor yet");
	}

	private FluidStack(Holder<Fluid> fluid, int amount, PatchedDataComponentMap components) {
		super();
		this.fluid = fluid;
		this.amount = amount;
		this.components = components;
	}

	private FluidStack(Void arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the FluidStack constructor yet");
	}

	public boolean isEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.isEmpty yet");
	}

	public net.neoforged.neoforge.fluids.FluidStack split(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.split yet");
	}

	public net.neoforged.neoforge.fluids.FluidStack copyAndClear() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.copyAndClear yet");
	}

	public Fluid getFluid() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.getFluid yet");
	}

	public Holder<Fluid> typeHolder() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.typeHolder yet");
	}

	public boolean is(Predicate<Holder<Fluid>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.is yet");
	}

	public net.neoforged.neoforge.fluids.FluidStack copy() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.copy yet");
	}

	public net.neoforged.neoforge.fluids.FluidStack copyWithAmount(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.copyWithAmount yet");
	}

	public net.neoforged.neoforge.fluids.FluidStack transmuteCopy(Fluid arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.transmuteCopy yet");
	}

	public net.neoforged.neoforge.fluids.FluidStack transmuteCopy(Fluid arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.transmuteCopy yet");
	}

	private net.neoforged.neoforge.fluids.FluidStack transmuteCopyIgnoreEmpty(Fluid arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.transmuteCopyIgnoreEmpty yet");
	}

	public static boolean matches(net.neoforged.neoforge.fluids.FluidStack arg0, net.neoforged.neoforge.fluids.FluidStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.matches yet");
	}

	public static boolean matches(net.neoforged.neoforge.fluids.FluidStack arg0, FluidStackTemplate arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.matches yet");
	}

	public static boolean isSameFluid(net.neoforged.neoforge.fluids.FluidStack arg0, net.neoforged.neoforge.fluids.FluidStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.isSameFluid yet");
	}

	public static boolean isSameFluidSameComponents(net.neoforged.neoforge.fluids.FluidStack arg0, net.neoforged.neoforge.fluids.FluidStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.isSameFluidSameComponents yet");
	}

	public static boolean isSameFluid(net.neoforged.neoforge.fluids.FluidStack arg0, FluidStackTemplate arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.isSameFluid yet");
	}

	public static boolean isSameFluidSameComponents(net.neoforged.neoforge.fluids.FluidStack arg0, FluidStackTemplate arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.isSameFluidSameComponents yet");
	}

	public static MapCodec<net.neoforged.neoforge.fluids.FluidStack> lenientOptionalFieldOf(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.lenientOptionalFieldOf yet");
	}

	public static int hashFluidAndComponents(net.neoforged.neoforge.fluids.FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.hashFluidAndComponents yet");
	}

	public String getDescriptionId() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.getDescriptionId yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.toString yet");
	}

	public List<Component> getTooltipLines(Item.TooltipContext arg0, Player arg1, TooltipFlag arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.getTooltipLines yet");
	}

	public <T extends Object> T set(DataComponentType<T> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.set yet");
	}

	public <T extends Object> T set(TypedDataComponent<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.set yet");
	}

	public <T extends Object> T remove(DataComponentType<? extends T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.remove yet");
	}

	public void applyComponents(DataComponentPatch arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.applyComponents yet");
	}

	public void applyComponents(DataComponentMap arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.applyComponents yet");
	}

	public Component getHoverName() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.getHoverName yet");
	}

	public int amount() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.amount yet");
	}

	public int getAmount() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.getAmount yet");
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void limitSize(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.limitSize yet");
	}

	public void grow(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.grow yet");
	}

	public void shrink(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStack.shrink yet");
	}
}
