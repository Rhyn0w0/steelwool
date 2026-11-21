package net.neoforged.neoforge.capabilities;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.TriState;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

/** A capability that blocks (and their block entities) can provide, looked up by position. */
public final class BlockCapability<T, C> extends BaseCapability<T, C> {
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static final CapabilityRegistry<BlockCapability<?, ?>> registry = new CapabilityRegistry<>(BlockCapability::new);

	final Map<Block, List<IBlockCapabilityProvider<T, C>>> providers = new IdentityHashMap<>();
	private TriState proxyable = TriState.DEFAULT;

	@SuppressWarnings("unchecked")
	public static <T, C> BlockCapability<T, C> create(Identifier name, Class<T> typeClass, Class<C> contextClass) {
		return (BlockCapability<T, C>) registry.create(name, typeClass, contextClass);
	}

	public static <T> BlockCapability<T, Void> createVoid(Identifier name, Class<T> typeClass) {
		return create(name, typeClass, Void.class);
	}

	public static <T> BlockCapability<T, Direction> createSided(Identifier name, Class<T> typeClass) {
		return create(name, typeClass, Direction.class);
	}

	public static synchronized List<BlockCapability<?, ?>> getAll() {
		return registry.getAll();
	}

	public static synchronized List<BlockCapability<?, ?>> getAllProxyable() {
		return registry.getAll().stream().filter(BlockCapability::isProxyable).toList();
	}

	/** Whether requests for this capability can be forwarded to other blocks. Directional capabilities are by default. */
	public boolean isProxyable() {
		return switch (proxyable) {
			case TRUE -> true;
			case FALSE -> false;
			case DEFAULT -> contextClass() == Direction.class;
		};
	}

	private BlockCapability(Identifier name, Class<T> typeClass, Class<C> contextClass) {
		super(name, typeClass, contextClass);
	}

	void setProxyable(boolean proxyable) {
		this.proxyable = proxyable ? TriState.TRUE : TriState.FALSE;
	}

	public @Nullable T getCapability(Level level, BlockPos pos, @Nullable BlockState state, @Nullable BlockEntity blockEntity, C context) {
		pos = pos.immutable();

		if (blockEntity == null) {
			if (state == null) {
				state = level.getBlockState(pos);
			}
			if (state.hasBlockEntity()) {
				blockEntity = level.getBlockEntity(pos);
			}
		} else if (state == null) {
			state = blockEntity.getBlockState();
		}

		List<IBlockCapabilityProvider<T, C>> list = providers.get(state.getBlock());
		if (list == null) {
			return null;
		}

		for (IBlockCapabilityProvider<T, C> provider : list) {
			T capability = provider.getCapability(level, pos, state, blockEntity, context);
			if (capability != null) {
				return capability;
			}
		}

		return null;
	}
}
