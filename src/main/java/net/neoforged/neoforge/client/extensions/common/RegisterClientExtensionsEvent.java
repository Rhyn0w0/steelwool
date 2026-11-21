package net.neoforged.neoforge.client.extensions.common;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.fluids.FluidType;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterClientExtensionsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RegisterClientExtensionsEvent extends Event implements IModBusEvent {
	RegisterClientExtensionsEvent() {
		super();
	}

	public void registerBlock(IClientBlockExtensions arg0, Block... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.registerBlock yet");
	}

	public final void registerBlock(IClientBlockExtensions arg0, Holder<Block>... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.registerBlock yet");
	}

	public boolean isBlockRegistered(Block arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.isBlockRegistered yet");
	}

	public void registerItem(IClientItemExtensions arg0, Item... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.registerItem yet");
	}

	public final void registerItem(IClientItemExtensions arg0, Holder<Item>... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.registerItem yet");
	}

	public boolean isItemRegistered(Item arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.isItemRegistered yet");
	}

	public void registerMobEffect(IClientMobEffectExtensions arg0, MobEffect... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.registerMobEffect yet");
	}

	public final void registerMobEffect(IClientMobEffectExtensions arg0, Holder<MobEffect>... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.registerMobEffect yet");
	}

	public boolean isMobEffectRegistered(MobEffect arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.isMobEffectRegistered yet");
	}

	public void registerFluidType(IClientFluidTypeExtensions arg0, FluidType... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.registerFluidType yet");
	}

	public final void registerFluidType(IClientFluidTypeExtensions arg0, Holder<FluidType>... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.registerFluidType yet");
	}

	public boolean isFluidTypeRegistered(FluidType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientExtensionsEvent.isFluidTypeRegistered yet");
	}
}
