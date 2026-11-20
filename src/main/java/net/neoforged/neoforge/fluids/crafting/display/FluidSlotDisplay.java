package net.neoforged.neoforge.fluids.crafting.display;

import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.item.crafting.display.DisplayContentsFactory;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.material.Fluid;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidSlotDisplay}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record FluidSlotDisplay(Holder<Fluid> fluid) implements SlotDisplay {
	public static final MapCodec<net.neoforged.neoforge.fluids.crafting.display.FluidSlotDisplay> MAP_CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.crafting.display.FluidSlotDisplay> STREAM_CODEC = null /* SteelWool: TODO */;

	public SlotDisplay.Type<net.neoforged.neoforge.fluids.crafting.display.FluidSlotDisplay> type() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidSlotDisplay.type yet");
	}

	public <T extends Object> Stream<T> resolve(ContextMap arg0, DisplayContentsFactory<T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidSlotDisplay.resolve yet");
	}
}
