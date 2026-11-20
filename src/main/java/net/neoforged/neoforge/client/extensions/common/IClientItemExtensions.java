package net.neoforged.neoforge.client.extensions.common;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * SteelWool re-implementation of NeoForge's {@code IClientItemExtensions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IClientItemExtensions {
	public static final net.neoforged.neoforge.client.extensions.common.IClientItemExtensions DEFAULT = null /* SteelWool: TODO */;

	static net.neoforged.neoforge.client.extensions.common.IClientItemExtensions of(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.of yet");
	}

	static net.neoforged.neoforge.client.extensions.common.IClientItemExtensions of(Item arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.of yet");
	}

	default Font getFont(ItemStack arg0, net.neoforged.neoforge.client.extensions.common.IClientItemExtensions.FontContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.getFont yet");
	}

	default HumanoidModel.ArmPose getArmPose(LivingEntity arg0, InteractionHand arg1, ItemStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.getArmPose yet");
	}

	default boolean applyForgeHandTransform(PoseStack arg0, PlayerRenderState arg1, HumanoidArm arg2, ItemStack arg3, float arg4, float arg5, float arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.applyForgeHandTransform yet");
	}

	default Model getHumanoidArmorModel(ItemStack arg0, EquipmentClientInfo.LayerType arg1, Model arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.getHumanoidArmorModel yet");
	}

	default Model getGenericArmorModel(ItemStack arg0, EquipmentClientInfo.LayerType arg1, Model arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.getGenericArmorModel yet");
	}

	default void setupModelAnimations(LivingEntity arg0, ItemStack arg1, EquipmentSlot arg2, Model arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.setupModelAnimations yet");
	}

	default void renderFirstPersonOverlay(ItemStack arg0, EquipmentSlot arg1, Player arg2, GuiGraphicsExtractor arg3, DeltaTracker arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.renderFirstPersonOverlay yet");
	}

	default boolean shouldBobAsEntity(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.shouldBobAsEntity yet");
	}

	default boolean shouldSpreadAsEntity(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.shouldSpreadAsEntity yet");
	}

	default int getArmorLayerTintColor(ItemStack arg0, EquipmentClientInfo.Layer arg1, int arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.getArmorLayerTintColor yet");
	}

	default int getDefaultDyeColor(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.getDefaultDyeColor yet");
	}

	default Identifier getArmorTexture(ItemStack arg0, EquipmentClientInfo.LayerType arg1, EquipmentClientInfo.Layer arg2, Identifier arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.getArmorTexture yet");
	}

	default Identifier getScopeOverlayTexture(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientItemExtensions.getScopeOverlayTexture yet");
	}

	public enum FontContext {
		ITEM_COUNT, TOOLTIP, SELECTED_ITEM_NAME;
	}
}
