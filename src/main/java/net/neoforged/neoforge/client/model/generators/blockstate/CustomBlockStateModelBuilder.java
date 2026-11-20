package net.neoforged.neoforge.client.model.generators.blockstate;

import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomBlockStateModelBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class CustomBlockStateModelBuilder {
	protected CustomBlockStateModelBuilder() {
		super();
	}

	public abstract net.neoforged.neoforge.client.model.generators.blockstate.CustomBlockStateModelBuilder with(VariantMutator arg0);

	public abstract net.neoforged.neoforge.client.model.generators.blockstate.CustomBlockStateModelBuilder with(UnbakedMutator arg0);

	public abstract CustomUnbakedBlockStateModel toUnbaked();

	public static final class Simple extends net.neoforged.neoforge.client.model.generators.blockstate.CustomBlockStateModelBuilder {
		private final CustomUnbakedBlockStateModel blockStateModel;

		public Simple(CustomUnbakedBlockStateModel blockStateModel) {
			super();
			this.blockStateModel = blockStateModel;
		}

		public net.neoforged.neoforge.client.model.generators.blockstate.CustomBlockStateModelBuilder.Simple with(VariantMutator arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement CustomBlockStateModelBuilder.Simple.with yet");
		}

		public net.neoforged.neoforge.client.model.generators.blockstate.CustomBlockStateModelBuilder with(UnbakedMutator arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement CustomBlockStateModelBuilder.Simple.with yet");
		}

		public CustomUnbakedBlockStateModel toUnbaked() {
			return this.blockStateModel;
		}
	}
}
