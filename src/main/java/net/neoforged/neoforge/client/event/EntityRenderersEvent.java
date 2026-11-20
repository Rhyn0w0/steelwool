package net.neoforged.neoforge.client.event;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.client.entity.ClientMannequin;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.PlayerModelType;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityRenderersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class EntityRenderersEvent extends Event implements IModBusEvent {
	protected EntityRenderersEvent() {
		super();
	}

	public static class AddLayers extends net.neoforged.neoforge.client.event.EntityRenderersEvent {
		private final Map<EntityType<?>, EntityRenderer<?, ?>> renderers;
		private final Map<PlayerModelType, AvatarRenderer<AbstractClientPlayer>> playerRenderers;
		private final Map<PlayerModelType, AvatarRenderer<ClientMannequin>> mannequinRenderers;
		private final EntityRendererProvider.Context context;

		public AddLayers(Map<EntityType<?>, EntityRenderer<?, ?>> renderers, Map<PlayerModelType, AvatarRenderer<AbstractClientPlayer>> playerRenderers, Map<PlayerModelType, AvatarRenderer<ClientMannequin>> mannequinRenderers, EntityRendererProvider.Context context) {
			super();
			this.renderers = renderers;
			this.playerRenderers = playerRenderers;
			this.mannequinRenderers = mannequinRenderers;
			this.context = context;
		}

		public Set<PlayerModelType> getSkins() {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.AddLayers.getSkins yet");
		}

		public <R extends AvatarRenderer<AbstractClientPlayer>> R getPlayerRenderer(PlayerModelType arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.AddLayers.getPlayerRenderer yet");
		}

		public <R extends AvatarRenderer<ClientMannequin>> R getMannequinRenderer(PlayerModelType arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.AddLayers.getMannequinRenderer yet");
		}

		public Set<EntityType<?>> getEntityTypes() {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.AddLayers.getEntityTypes yet");
		}

		public <T extends Entity, R extends EntityRenderer<T, ?>> R getRenderer(EntityType<? extends T> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.AddLayers.getRenderer yet");
		}

		public EntityModelSet getEntityModels() {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.AddLayers.getEntityModels yet");
		}

		public EntityRendererProvider.Context getContext() {
			return this.context;
		}
	}

	public static class CreateSkullModels extends net.neoforged.neoforge.client.event.EntityRenderersEvent {
		private final Map<SkullBlock.Type, Function<EntityModelSet, SkullModelBase>> skullModels;
		private final Map<SkullBlock.Type, Identifier> skullTextures;

		public CreateSkullModels(Map<SkullBlock.Type, Function<EntityModelSet, SkullModelBase>> skullModels, Map<SkullBlock.Type, Identifier> skullTextures) {
			super();
			this.skullModels = skullModels;
			this.skullTextures = skullTextures;
		}

		public void registerSkullModel(SkullBlock.Type arg0, ModelLayerLocation arg1, Identifier arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.CreateSkullModels.registerSkullModel yet");
		}

		public void registerSkullModel(SkullBlock.Type arg0, ModelLayerLocation arg1, Function<ModelPart, SkullModelBase> arg2, Identifier arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.CreateSkullModels.registerSkullModel yet");
		}

		public void registerSkullModel(SkullBlock.Type arg0, Function<EntityModelSet, SkullModelBase> arg1, Identifier arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.CreateSkullModels.registerSkullModel yet");
		}
	}

	public static class RegisterLayerDefinitions extends net.neoforged.neoforge.client.event.EntityRenderersEvent {
		public RegisterLayerDefinitions() {
			super();
		}

		public void registerLayerDefinition(ModelLayerLocation arg0, Supplier<LayerDefinition> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.RegisterLayerDefinitions.registerLayerDefinition yet");
		}
	}

	public static class RegisterRenderers extends net.neoforged.neoforge.client.event.EntityRenderersEvent {
		public RegisterRenderers() {
			super();
		}

		public <T extends Entity> void registerEntityRenderer(EntityType<? extends T> arg0, EntityRendererProvider<T> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.RegisterRenderers.registerEntityRenderer yet");
		}

		public <T extends BlockEntity, S extends BlockEntityRenderState> void registerBlockEntityRenderer(BlockEntityType<? extends T> arg0, BlockEntityRendererProvider<T, S> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement EntityRenderersEvent.RegisterRenderers.registerBlockEntityRenderer yet");
		}
	}
}
