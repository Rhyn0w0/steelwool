package net.neoforged.neoforge.event;

import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code BlockEntityTypeAddBlocksEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BlockEntityTypeAddBlocksEvent extends Event implements IModBusEvent {
	private final Function<BlockEntityType<?>, ? extends Class<?>> memoizedCommonSuperClass;

	public BlockEntityTypeAddBlocksEvent() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the BlockEntityTypeAddBlocksEvent constructor yet");
	}

	public void modify(BlockEntityType<?> arg0, Block... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockEntityTypeAddBlocksEvent.modify yet");
	}

	public void modify(ResourceKey<BlockEntityType<?>> arg0, Block... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockEntityTypeAddBlocksEvent.modify yet");
	}

	public void modify(BiPredicate<ResourceKey<BlockEntityType<?>>, BlockEntityType<?>> arg0, Block... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockEntityTypeAddBlocksEvent.modify yet");
	}

	private void addValidBlock(Block arg0, Class<?> arg1, Set<Block> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockEntityTypeAddBlocksEvent.addValidBlock yet");
	}

	private Class<?> getCommonSuperClassForExistingValidBlocks(Set<Block> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockEntityTypeAddBlocksEvent.getCommonSuperClassForExistingValidBlocks yet");
	}

	private static Class<?> findClosestCommonSuper(Class<?> arg0, Class<?> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockEntityTypeAddBlocksEvent.findClosestCommonSuper yet");
	}
}
