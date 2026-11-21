package net.neoforged.neoforge.capabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * Fired on the mod event bus once registration is done, to attach capability providers to blocks,
 * block entities, entities and items. Providers registered earlier are asked first.
 */
public class RegisterCapabilitiesEvent extends Event implements IModBusEvent {
	RegisterCapabilitiesEvent() {
	}

	public <T, C> void registerBlock(BlockCapability<T, C> capability, IBlockCapabilityProvider<T, C> provider, Block... blocks) {
		Objects.requireNonNull(provider);
		if (blocks.length == 0) {
			throw new IllegalArgumentException("registerBlock needs at least one block");
		}
		for (Block block : blocks) {
			capability.providers.computeIfAbsent(Objects.requireNonNull(block), b -> new ArrayList<>()).add(provider);
		}
	}

	@SuppressWarnings("unchecked")
	public <T, C, BE extends BlockEntity> void registerBlockEntity(BlockCapability<T, C> capability, BlockEntityType<BE> type, ICapabilityProvider<? super BE, C, T> provider) {
		Objects.requireNonNull(provider);
		IBlockCapabilityProvider<T, C> blockProvider = (level, pos, state, blockEntity, context) ->
				blockEntity != null && blockEntity.getType() == type ? provider.getCapability((BE) blockEntity, context) : null;

		for (Block block : BuiltInRegistries.BLOCK) {
			if (type.isValid(block.defaultBlockState())) {
				registerBlock(capability, blockProvider, block);
			}
		}
	}

	public boolean isBlockRegistered(BlockCapability<?, ?> capability, Block block) {
		return capability.providers.containsKey(block);
	}

	public void setProxyable(BlockCapability<?, ?> capability) {
		capability.setProxyable(true);
	}

	public void setNonProxyable(BlockCapability<?, ?> capability) {
		capability.setProxyable(false);
	}

	@SuppressWarnings("unchecked")
	public <T, C, E extends Entity> void registerEntity(EntityCapability<T, C> capability, EntityType<E> type, ICapabilityProvider<? super E, C, T> provider) {
		capability.providers.computeIfAbsent(Objects.requireNonNull(type), t -> new ArrayList<>())
				.add((ICapabilityProvider<Entity, C, T>) (ICapabilityProvider<?, C, T>) Objects.requireNonNull(provider));
	}

	public boolean isEntityRegistered(EntityCapability<?, ?> capability, EntityType<?> type) {
		return capability.providers.containsKey(type);
	}

	public <T, C> void registerItem(ItemCapability<T, C> capability, ICapabilityProvider<ItemStack, C, T> provider, ItemLike... items) {
		Objects.requireNonNull(provider);
		if (items.length == 0) {
			throw new IllegalArgumentException("registerItem needs at least one item");
		}
		for (ItemLike item : items) {
			capability.providers.computeIfAbsent(Objects.requireNonNull(item.asItem()), i -> new ArrayList<>()).add(provider);
		}
	}

	public boolean isItemRegistered(ItemCapability<?, ?> capability, Item item) {
		return capability.providers.containsKey(item);
	}
}
