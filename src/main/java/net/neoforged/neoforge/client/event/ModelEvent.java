package net.neoforged.neoforge.client.event;

import java.util.Map;

import net.minecraft.client.renderer.texture.SpriteLoader;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.sprite.MaterialBaker;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.model.UnbakedModelLoader;
import net.neoforged.neoforge.client.model.standalone.StandaloneModelKey;
import net.neoforged.neoforge.client.model.standalone.UnbakedStandaloneModel;

/**
 * SteelWool re-implementation of NeoForge's {@code ModelEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ModelEvent extends Event {
	protected ModelEvent() {
		super();
	}

	public static class BakingCompleted extends net.neoforged.neoforge.client.event.ModelEvent implements IModBusEvent {
		private final ModelManager modelManager;
		private final ModelBakery.BakingResult bakingResult;
		private final ModelBakery modelBakery;

		public BakingCompleted(ModelManager modelManager, ModelBakery.BakingResult arg1, ModelBakery arg2) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the ModelEvent.BakingCompleted constructor yet");
		}

		public ModelManager getModelManager() {
			return this.modelManager;
		}

		public ModelBakery.BakingResult getBakingResult() {
			return this.bakingResult;
		}

		public ModelBakery getModelBakery() {
			return this.modelBakery;
		}
	}

	public static class ModifyBakingResult extends net.neoforged.neoforge.client.event.ModelEvent implements IModBusEvent {
		private final ModelBakery.BakingResult bakingResult;
		private final MaterialBaker materialBaker;
		private final SpriteLoader.Preparations blockAtlas;
		private final SpriteLoader.Preparations itemAtlas;
		private final ModelBakery modelBakery;

		public ModifyBakingResult(ModelBakery.BakingResult bakingResult, MaterialBaker materialBaker, SpriteLoader.Preparations blockAtlas, SpriteLoader.Preparations itemAtlas, ModelBakery modelBakery) {
			super();
			this.bakingResult = bakingResult;
			this.materialBaker = materialBaker;
			this.blockAtlas = blockAtlas;
			this.itemAtlas = itemAtlas;
			this.modelBakery = modelBakery;
		}

		public ModelBakery.BakingResult getBakingResult() {
			return this.bakingResult;
		}

		public MaterialBaker getMaterialBaker() {
			return this.materialBaker;
		}

		public SpriteLoader.Preparations getBlockAtlasPreparations() {
			return this.blockAtlas;
		}

		public SpriteLoader.Preparations getItemAtlasPreparations() {
			return this.itemAtlas;
		}

		public ModelBakery getModelBakery() {
			return this.modelBakery;
		}
	}

	public static class RegisterLoaders extends net.neoforged.neoforge.client.event.ModelEvent implements IModBusEvent {
		private final Map<Identifier, UnbakedModelLoader<?>> loaders;

		public RegisterLoaders(Map<Identifier, UnbakedModelLoader<?>> loaders) {
			super();
			this.loaders = loaders;
		}

		public void register(Identifier arg0, UnbakedModelLoader<?> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ModelEvent.RegisterLoaders.register yet");
		}
	}

	public static class RegisterStandalone extends net.neoforged.neoforge.client.event.ModelEvent implements IModBusEvent {
		private final Map<StandaloneModelKey<?>, UnbakedStandaloneModel<?>> modelMap;

		public RegisterStandalone(Map<StandaloneModelKey<?>, UnbakedStandaloneModel<?>> modelMap) {
			super();
			this.modelMap = modelMap;
		}

		public <T extends Object> void register(StandaloneModelKey<T> arg0, UnbakedStandaloneModel<T> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ModelEvent.RegisterStandalone.register yet");
		}
	}
}
