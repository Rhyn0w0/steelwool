package net.neoforged.neoforge.client.model.item;

import java.util.Map;
import java.util.Optional;

import com.mojang.math.Transformation;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.resources.model.ModelDebugName;
import net.minecraft.client.resources.model.ResolvableModel;
import net.minecraft.client.resources.model.cuboid.ItemTransforms;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import org.joml.Matrix4fc;

/**
 * SteelWool re-implementation of NeoForge's {@code DynamicFluidContainerModel}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DynamicFluidContainerModel implements ItemModel {
	private static final Transformation FLUID_TRANSFORM = null /* SteelWool: TODO */;
	private static final Transformation COVER_TRANSFORM = null /* SteelWool: TODO */;
	private static final ModelDebugName DEBUG_NAME = null /* SteelWool: TODO */;
	private static final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes RENDER_TYPES_CUTOUT_BLOCK = null /* SteelWool: TODO */;
	private static final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes RENDER_TYPES_CUTOUT_ITEM = null /* SteelWool: TODO */;
	private static final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes RENDER_TYPES_TRANSLUCENT_BLOCK = null /* SteelWool: TODO */;
	private static final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes RENDER_TYPES_TRANSLUCENT_ITEM = null /* SteelWool: TODO */;
	private static final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes RENDER_TYPES_CUTOUT_UNLIT_BLOCK = null /* SteelWool: TODO */;
	private static final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes RENDER_TYPES_CUTOUT_UNLIT_ITEM = null /* SteelWool: TODO */;
	private static final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes RENDER_TYPES_TRANSLUCENT_UNLIT_BLOCK = null /* SteelWool: TODO */;
	private static final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes RENDER_TYPES_TRANSLUCENT_UNLIT_ITEM = null /* SteelWool: TODO */;
	private final net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.Unbaked unbakedModel;
	private final ItemModel.BakingContext bakingContext;
	private final Matrix4fc transformation;
	private final ItemTransforms itemTransforms;
	private final Map<Fluid, ItemModel> cache;

	private DynamicFluidContainerModel(net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.Unbaked arg0, ItemModel.BakingContext arg1, Matrix4fc arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the DynamicFluidContainerModel constructor yet");
	}

	private ItemModel bakeModelForFluid(Fluid arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DynamicFluidContainerModel.bakeModelForFluid yet");
	}

	private static net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.ItemRenderTypes computeFluidItemRenderType(Material.Baked arg0, boolean arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DynamicFluidContainerModel.computeFluidItemRenderType yet");
	}

	public void update(ItemStackRenderState arg0, ItemStack arg1, ItemModelResolver arg2, ItemDisplayContext arg3, ClientLevel arg4, ItemOwner arg5, int arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement DynamicFluidContainerModel.update yet");
	}

	static record ItemRenderTypes(RenderType item, RenderType itemGlint, RenderType itemGlintSpecial) {
	}

	public static record Textures(Optional<Material> particle, Optional<Material> base, Optional<Material> fluid, Optional<Material> cover) {
		public static final Codec<net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.Textures> CODEC = null /* SteelWool: TODO */;
	}

	public static record Unbaked(net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.Textures textures, Fluid fluid, boolean flipGas, boolean coverIsMask, boolean applyFluidLuminosity, boolean forceOpaqueFluid) implements ItemModel.Unbaked {
		public static final MapCodec<net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.Unbaked> MAP_CODEC = null /* SteelWool: TODO */;

		public Unbaked(net.neoforged.neoforge.client.model.item.DynamicFluidContainerModel.Textures arg0, Fluid arg1, boolean arg2, boolean arg3, boolean arg4) {
			this(arg0, arg1, arg2, arg3, arg4, true);
		}

		public MapCodec<? extends ItemModel.Unbaked> type() {
			throw new UnsupportedOperationException("SteelWool does not implement DynamicFluidContainerModel.Unbaked.type yet");
		}

		public ItemModel bake(ItemModel.BakingContext arg0, Matrix4fc arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement DynamicFluidContainerModel.Unbaked.bake yet");
		}

		public void resolveDependencies(ResolvableModel.Resolver arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement DynamicFluidContainerModel.Unbaked.resolveDependencies yet");
		}
	}
}
