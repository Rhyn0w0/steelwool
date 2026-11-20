package net.neoforged.neoforge.client.model.generators.blockstate;

import java.util.Map;
import java.util.function.UnaryOperator;

import net.minecraft.client.renderer.block.dispatch.BlockStateModel;

/**
 * SteelWool re-implementation of NeoForge's {@code UnbakedMutator}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class UnbakedMutator {
	private final Map<Class<?>, net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator.Handler<?>> handlers;

	private UnbakedMutator(Map<Class<?>, net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator.Handler<?>> arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the UnbakedMutator constructor yet");
	}

	public <T extends BlockStateModel.Unbaked> T apply(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement UnbakedMutator.apply yet");
	}

	private <T extends BlockStateModel.Unbaked> net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator.Handler<T> getHandler(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement UnbakedMutator.getHandler yet");
	}

	public static net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator.Builder builder() {
		throw new UnsupportedOperationException("SteelWool does not implement UnbakedMutator.builder yet");
	}

	public static final class Builder {
		private final Map<Class<?>, net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator.Handler<?>> handlers;

		private Builder() {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the UnbakedMutator.Builder constructor yet");
		}

		public <T extends BlockStateModel.Unbaked> net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator.Builder add(Class<T> arg0, UnaryOperator<T> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement UnbakedMutator.Builder.add yet");
		}

		public net.neoforged.neoforge.client.model.generators.blockstate.UnbakedMutator build() {
			throw new UnsupportedOperationException("SteelWool does not implement UnbakedMutator.Builder.build yet");
		}
	}

	static record Handler<T extends Object>(Class<T> supportedClass, UnaryOperator<T> operator) {
		public T apply(BlockStateModel.Unbaked arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement UnbakedMutator.Handler.apply yet");
		}
	}
}
