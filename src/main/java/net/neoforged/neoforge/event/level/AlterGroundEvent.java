package net.neoforged.neoforge.event.level;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code AlterGroundEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AlterGroundEvent extends Event {
	private final TreeDecorator.Context ctx;
	private final List<BlockPos> positions;
	private net.neoforged.neoforge.event.level.AlterGroundEvent.StateProvider provider;

	public AlterGroundEvent(TreeDecorator.Context ctx, List<BlockPos> arg1, net.neoforged.neoforge.event.level.AlterGroundEvent.StateProvider arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the AlterGroundEvent constructor yet");
	}

	public TreeDecorator.Context getContext() {
		return this.ctx;
	}

	public List<BlockPos> getPositions() {
		return this.positions;
	}

	public net.neoforged.neoforge.event.level.AlterGroundEvent.StateProvider getStateProvider() {
		return this.provider;
	}

	public void setStateProvider(net.neoforged.neoforge.event.level.AlterGroundEvent.StateProvider arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AlterGroundEvent.setStateProvider yet");
	}

	public interface StateProvider {
		BlockState getState(WorldGenLevel arg0, RandomSource arg1, BlockPos arg2);
	}
}
