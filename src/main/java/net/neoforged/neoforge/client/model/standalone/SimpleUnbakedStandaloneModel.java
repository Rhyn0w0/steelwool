package net.neoforged.neoforge.client.model.standalone;

import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.block.dispatch.ModelState;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelDebugName;
import net.minecraft.client.resources.model.ResolvableModel;
import net.minecraft.client.resources.model.ResolvedModel;
import net.minecraft.client.resources.model.geometry.QuadCollection;
import net.minecraft.resources.Identifier;

/**
 * SteelWool re-implementation of NeoForge's {@code SimpleUnbakedStandaloneModel}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class SimpleUnbakedStandaloneModel<T extends Object> extends Object implements UnbakedStandaloneModel<T> {
	private final Identifier modelId;
	private final net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel.SimpleBaker<T> bake;

	public SimpleUnbakedStandaloneModel(Identifier modelId, net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel.SimpleBaker<T> bake) {
		super();
		this.modelId = modelId;
		this.bake = bake;
	}

	public T bake(ModelBaker arg0, ModelDebugName arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleUnbakedStandaloneModel.bake yet");
	}

	public void resolveDependencies(ResolvableModel.Resolver arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleUnbakedStandaloneModel.resolveDependencies yet");
	}

	public static net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel<BlockStateModelPart> simpleModelWrapper(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleUnbakedStandaloneModel.simpleModelWrapper yet");
	}

	public static net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel<BlockStateModelPart> simpleModelWrapper(Identifier arg0, ModelState arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleUnbakedStandaloneModel.simpleModelWrapper yet");
	}

	public static net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel<BlockStateModel> blockStateModel(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleUnbakedStandaloneModel.blockStateModel yet");
	}

	public static net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel<BlockStateModel> blockStateModel(Identifier arg0, ModelState arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleUnbakedStandaloneModel.blockStateModel yet");
	}

	public static net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel<QuadCollection> quadCollection(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleUnbakedStandaloneModel.quadCollection yet");
	}

	public static net.neoforged.neoforge.client.model.standalone.SimpleUnbakedStandaloneModel<QuadCollection> quadCollection(Identifier arg0, ModelState arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleUnbakedStandaloneModel.quadCollection yet");
	}

	public interface SimpleBaker<T extends Object> {
		T bake(ResolvedModel arg0, ModelBaker arg1, ModelDebugName arg2);
	}
}
