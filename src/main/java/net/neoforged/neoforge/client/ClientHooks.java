package net.neoforged.neoforge.client;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.framegraph.FrameGraphBuilder;
import com.mojang.blaze3d.pipeline.MainTarget;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Either;
import com.mojang.renderpearl.api.GpuFormat;
import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.Options;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.gui.components.LerpingBossEvent;
import net.minecraft.client.gui.components.debug.DebugEntryCategory;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.client.input.CharacterEvent;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.input.MouseButtonInfo;
import net.minecraft.client.input.PreeditEvent;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.particle.ParticleResources;
import net.minecraft.client.player.ClientInput;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelTargetBundle;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.chunk.RenderSectionRegion;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.client.renderer.texture.SpriteLoader;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.sprite.AtlasManager;
import net.minecraft.client.resources.model.sprite.MaterialBaker;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.core.BlockPos;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.sounds.Music;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FogType;
import net.neoforged.neoforge.client.event.AddSectionGeometryEvent;
import net.neoforged.neoforge.client.event.CalculatePlayerTurnEvent;
import net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent;
import net.neoforged.neoforge.client.event.ExtractBlockScreenEffectEvent;
import net.neoforged.neoforge.client.event.FrameGraphSetupEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.client.event.ScreenshotEvent;
import net.neoforged.neoforge.client.gui.PictureInPictureRendererRegistration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.joml.Matrix4fc;
import org.joml.Vector2ic;
import org.joml.Vector4f;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientHooks}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientHooks {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static final Marker CLIENTHOOKS = null /* SteelWool: TODO */;
	private static int slotMainHand;
	private static final Map<ModelLayerLocation, Supplier<LayerDefinition>> layerDefinitions = null /* SteelWool: TODO */;
	private static final Map<SkullBlock.Type, Function<EntityModelSet, SkullModelBase>> skullModelsByType = null /* SteelWool: TODO */;
	private static final Identifier ICON_SHEET = null /* SteelWool: TODO */;
	private static boolean initializedClientHooks;
	private static boolean initializedClientRegistries;
	private static final HashSet<MetadataSectionType<?>> DEFAULT_METADATA_SECTION_TYPES = null /* SteelWool: TODO */;

	public ClientHooks() {
		super();
	}

	public static Hud.HeartType firePlayerHeartTypeEvent(Player arg0, Hud.HeartType arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.firePlayerHeartTypeEvent yet");
	}

	public static Identifier getArmorTexture(ItemStack arg0, EquipmentClientInfo.LayerType arg1, EquipmentClientInfo.Layer arg2, Identifier arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getArmorTexture yet");
	}

	public static boolean onClientPauseChangePre(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onClientPauseChangePre yet");
	}

	public static void onClientPauseChangePost(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onClientPauseChangePost yet");
	}

	public static boolean renderSpecificFirstPersonHand(InteractionHand arg0, PoseStack arg1, SubmitNodeCollector arg2, PlayerRenderState arg3, float arg4, float arg5, float arg6, float arg7, ItemStack arg8) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.renderSpecificFirstPersonHand yet");
	}

	public static boolean renderSpecificFirstPersonArm(PoseStack arg0, SubmitNodeCollector arg1, int arg2, Identifier arg3, boolean arg4, PlayerRenderState arg5, HumanoidArm arg6, ModelPart arg7) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.renderSpecificFirstPersonArm yet");
	}

	public static void onTextureAtlasStitched(TextureAtlas arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onTextureAtlasStitched yet");
	}

	public static void copyModelProperties(HumanoidModel<?> arg0, HumanoidModel<?> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.copyModelProperties yet");
	}

	private static void copyModelPartProperties(ModelPart arg0, ModelPart arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.copyModelPartProperties yet");
	}

	public static String fixDomain(String arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.fixDomain yet");
	}

	public static float getFieldOfViewModifier(Player arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getFieldOfViewModifier yet");
	}

	public static float getFieldOfView(GameRenderer arg0, Camera arg1, float arg2, float arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getFieldOfView yet");
	}

	public static CalculatePlayerTurnEvent getTurnPlayerValues(double arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getTurnPlayerValues yet");
	}

	public static float getDetachedCameraDistance(Camera arg0, boolean arg1, float arg2, float arg3, float arg4, float arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getDetachedCameraDistance yet");
	}

	public static void renderMainMenu(TitleScreen arg0, GuiGraphicsExtractor arg1, Font arg2, int arg3, int arg4, int arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.renderMainMenu yet");
	}

	public static SoundInstance playSound(SoundEngine arg0, SoundInstance arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.playSound yet");
	}

	public static Music selectMusic(Music arg0, SoundInstance arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.selectMusic yet");
	}

	public static Component getPageButtonComponent(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getPageButtonComponent yet");
	}

	public static void extractScreen(Screen arg0, Stack<Screen> arg1, GuiGraphicsExtractor arg2, int arg3, int arg4, float arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.extractScreen yet");
	}

	private static void extractScreenInternal(Screen arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, float arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.extractScreenInternal yet");
	}

	public static void getFogColor(Camera arg0, float arg1, ClientLevel arg2, int arg3, float arg4, float arg5, float arg6, float arg7, Vector4f arg8) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getFogColor yet");
	}

	public static void onSetupFog(FogEnvironment arg0, FogType arg1, Camera arg2, float arg3, float arg4, FogData arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onSetupFog yet");
	}

	public static void onModifyBakingResult(ModelBakery.BakingResult arg0, MaterialBaker arg1, SpriteLoader.Preparations arg2, SpriteLoader.Preparations arg3, ModelBakery arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onModifyBakingResult yet");
	}

	public static void onModelBake(ModelManager arg0, ModelBakery.BakingResult arg1, ModelBakery arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onModelBake yet");
	}

	public static boolean loadEntityShader(Entity arg0, GameRenderer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.loadEntityShader yet");
	}

	public static boolean shouldCauseReequipAnimation(ItemStack arg0, ItemStack arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.shouldCauseReequipAnimation yet");
	}

	public static CustomizeGuiOverlayEvent.BossEventProgress onCustomizeBossEventProgress(GuiGraphicsExtractor arg0, Window arg1, LerpingBossEvent arg2, int arg3, int arg4, int arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onCustomizeBossEventProgress yet");
	}

	public static ScreenshotEvent onScreenshot(NativeImage arg0, File arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenshot yet");
	}

	public static void onClientChangeGameType(PlayerInfo arg0, GameType arg1, GameType arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onClientChangeGameType yet");
	}

	public static void onMovementInputUpdate(Player arg0, ClientInput arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onMovementInputUpdate yet");
	}

	public static boolean onScreenMouseClickedPre(Screen arg0, MouseButtonEvent arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenMouseClickedPre yet");
	}

	public static boolean onScreenMouseClickedPost(Screen arg0, MouseButtonEvent arg1, boolean arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenMouseClickedPost yet");
	}

	public static boolean onScreenMouseReleasedPre(Screen arg0, MouseButtonEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenMouseReleasedPre yet");
	}

	public static boolean onScreenMouseReleasedPost(Screen arg0, MouseButtonEvent arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenMouseReleasedPost yet");
	}

	public static boolean onScreenMouseDragPre(Screen arg0, MouseButtonEvent arg1, double arg2, double arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenMouseDragPre yet");
	}

	public static void onScreenMouseDragPost(Screen arg0, MouseButtonEvent arg1, double arg2, double arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenMouseDragPost yet");
	}

	public static boolean onScreenMouseScrollPre(MouseHandler arg0, Screen arg1, double arg2, double arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenMouseScrollPre yet");
	}

	public static void onScreenMouseScrollPost(MouseHandler arg0, Screen arg1, double arg2, double arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenMouseScrollPost yet");
	}

	public static boolean onScreenKeyPressedPre(Screen arg0, KeyEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenKeyPressedPre yet");
	}

	public static boolean onScreenKeyPressedPost(Screen arg0, KeyEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenKeyPressedPost yet");
	}

	public static boolean onScreenKeyReleasedPre(Screen arg0, KeyEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenKeyReleasedPre yet");
	}

	public static boolean onScreenKeyReleasedPost(Screen arg0, KeyEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenKeyReleasedPost yet");
	}

	public static boolean onScreenCharTypedPre(Screen arg0, CharacterEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenCharTypedPre yet");
	}

	public static void onScreenCharTypedPost(Screen arg0, CharacterEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenCharTypedPost yet");
	}

	public static boolean onScreenPreeditPre(Screen arg0, PreeditEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenPreeditPre yet");
	}

	public static void onScreenPreeditPost(Screen arg0, PreeditEvent arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenPreeditPost yet");
	}

	public static boolean onMouseButtonPre(MouseButtonInfo arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onMouseButtonPre yet");
	}

	public static void onMouseButtonPost(MouseButtonInfo arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onMouseButtonPost yet");
	}

	public static boolean onMouseScroll(MouseHandler arg0, double arg1, double arg2, Vector2ic arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onMouseScroll yet");
	}

	public static void onKeyInput(KeyEvent arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onKeyInput yet");
	}

	public static InputEvent.InteractionKeyMappingTriggered onClickInput(int arg0, KeyMapping arg1, InteractionHand arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onClickInput yet");
	}

	public static boolean shouldRenderEffect(MobEffectInstance arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.shouldRenderEffect yet");
	}

	public static void registerLayerDefinition(ModelLayerLocation arg0, Supplier<LayerDefinition> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.registerLayerDefinition yet");
	}

	public static void loadLayerDefinitions(ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.loadLayerDefinitions yet");
	}

	public static SkullModelBase getModdedSkullModel(EntityModelSet arg0, SkullBlock.Type arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getModdedSkullModel yet");
	}

	public static void firePlayerLogin(MultiPlayerGameMode arg0, LocalPlayer arg1, Connection arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.firePlayerLogin yet");
	}

	public static void firePlayerLogout(MultiPlayerGameMode arg0, LocalPlayer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.firePlayerLogout yet");
	}

	public static void firePlayerRespawn(MultiPlayerGameMode arg0, LocalPlayer arg1, LocalPlayer arg2, Connection arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.firePlayerRespawn yet");
	}

	public static void onRegisterParticleProviders(ParticleResources arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onRegisterParticleProviders yet");
	}

	public static void onRegisterKeyMappings(Options arg0, List<KeyMapping.Category> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onRegisterKeyMappings yet");
	}

	public static Component onClientChat(ChatType.Bound arg0, Component arg1, UUID arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onClientChat yet");
	}

	public static Component onClientPlayerChat(ChatType.Bound arg0, Component arg1, PlayerChatMessage arg2, UUID arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onClientPlayerChat yet");
	}

	public static Component onClientSystemChat(Component arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onClientSystemChat yet");
	}

	public static String onClientSendMessage(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onClientSendMessage yet");
	}

	public static void handleUpdateRecipes(ClientPacketListener arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.handleUpdateRecipes yet");
	}

	public static Font getTooltipFont(ItemStack arg0, Font arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getTooltipFont yet");
	}

	public static RenderTooltipEvent.Pre onRenderTooltipPre(ItemStack arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, int arg4, int arg5, List<ClientTooltipComponent> arg6, Font arg7, ClientTooltipPositioner arg8) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onRenderTooltipPre yet");
	}

	public static RenderTooltipEvent.Texture onRenderTooltipTexture(ItemStack arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, Font arg4, List<ClientTooltipComponent> arg5, Identifier arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onRenderTooltipTexture yet");
	}

	public static List<ClientTooltipComponent> gatherTooltipComponents(ItemStack arg0, List<? extends FormattedText> arg1, int arg2, int arg3, int arg4, Font arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.gatherTooltipComponents yet");
	}

	public static List<ClientTooltipComponent> gatherTooltipComponents(ItemStack arg0, List<? extends FormattedText> arg1, Optional<TooltipComponent> arg2, int arg3, int arg4, int arg5, Font arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.gatherTooltipComponents yet");
	}

	public static List<ClientTooltipComponent> gatherTooltipComponentsFromElements(ItemStack arg0, List<Either<FormattedText, TooltipComponent>> arg1, int arg2, int arg3, int arg4, Font arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.gatherTooltipComponentsFromElements yet");
	}

	private static Stream<ClientTooltipComponent> splitLine(FormattedText arg0, Font arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.splitLine yet");
	}

	public static ScreenEvent.RenderInventoryMobEffects onScreenPotionSize(Screen arg0, int arg1, boolean arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onScreenPotionSize yet");
	}

	public static boolean onToastAdd(Toast arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.onToastAdd yet");
	}

	public static void extractFireScreenEffect(LocalPlayer arg0, PlayerRenderState arg1, Camera arg2, float arg3, float arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.extractFireScreenEffect yet");
	}

	public static boolean extractWaterScreenEffect(LocalPlayer arg0, PlayerRenderState arg1, Camera arg2, float arg3, float arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.extractWaterScreenEffect yet");
	}

	public static boolean extractBlockScreenEffect(LocalPlayer arg0, PlayerRenderState arg1, BlockPos arg2, BlockState arg3, Camera arg4, float arg5, float arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.extractBlockScreenEffect yet");
	}

	private static boolean extractBlockScreenEffect(LocalPlayer arg0, PlayerRenderState arg1, BlockPos arg2, BlockState arg3, Camera arg4, float arg5, float arg6, ExtractBlockScreenEffectEvent.OverlayType arg7) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.extractBlockScreenEffect yet");
	}

	public static List<AddSectionGeometryEvent.AdditionalSectionRenderer> gatherAdditionalRenderers(BlockPos arg0, Level arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.gatherAdditionalRenderers yet");
	}

	public static void addAdditionalGeometry(List<AddSectionGeometryEvent.AdditionalSectionRenderer> arg0, Function<ChunkSectionLayer, VertexConsumer> arg1, RenderSectionRegion arg2, ModelBlockRenderer arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.addAdditionalGeometry yet");
	}

	public static void initClientHooks(Minecraft arg0, ReloadableResourceManager arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.initClientHooks yet");
	}

	public static void initClientRegistries() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.initClientRegistries yet");
	}

	public static void fireRenderFramePre(DeltaTracker arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.fireRenderFramePre yet");
	}

	public static void fireRenderFramePost(DeltaTracker arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.fireRenderFramePost yet");
	}

	public static void fireResourceLoadFinishedEvent(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.fireResourceLoadFinishedEvent yet");
	}

	public static void fireClientTickPre() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.fireClientTickPre yet");
	}

	public static void fireClientTickPost() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.fireClientTickPost yet");
	}

	public static void fireWindowResize(Window arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.fireWindowResize yet");
	}

	public static List<Component> getEffectTooltip(AbstractContainerScreen<?> arg0, MobEffectInstance arg1, List<Component> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getEffectTooltip yet");
	}

	public static void reloadRenderer() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.reloadRenderer yet");
	}

	public static List<AtlasManager.AtlasConfig> gatherTextureAtlases(List<AtlasManager.AtlasConfig> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.gatherTextureAtlases yet");
	}

	public static FrameGraphSetupEvent fireFrameGraphSetup(FrameGraphBuilder arg0, LevelTargetBundle arg1, CameraRenderState arg2, Matrix4fc arg3, ProfilerFiller arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.fireFrameGraphSetup yet");
	}

	public static MainTarget instantiateMainTarget(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.instantiateMainTarget yet");
	}

	public static GpuFormat getStencilFormat() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getStencilFormat yet");
	}

	public static Set<MetadataSectionType<?>> getSpriteDefaultMetadataSectionTypes(Set<MetadataSectionType<?>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.getSpriteDefaultMetadataSectionTypes yet");
	}

	public static List<PictureInPictureRendererRegistration<?>> gatherPictureInPictureRenderers(List<PictureInPictureRendererRegistration<?>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.gatherPictureInPictureRenderers yet");
	}

	public static joptsimple.ValueConverter<String> convertUsername() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.convertUsername yet");
	}

	public static <T extends Object> joptsimple.ArgumentAcceptingOptionSpec<T> optionalInDev(joptsimple.ArgumentAcceptingOptionSpec<T> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.optionalInDev yet");
	}

	public static void updateDebugScreenEntriesForSearch(String arg0, Consumer<DebugEntryCategory> arg1, Consumer<Identifier> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.updateDebugScreenEntriesForSearch yet");
	}

	private static boolean isValidDebugEntryForSearch(String arg0, Identifier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.isValidDebugEntryForSearch yet");
	}

	public static Map<Fluid, FluidModel> gatherFluidModels(Map<Fluid, FluidModel> arg0, MaterialBaker arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.gatherFluidModels yet");
	}

	public static Object2BooleanMap<ModelPart> updateModelVisibility(Model<?> arg0, Object arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.updateModelVisibility yet");
	}

	public static void resetVisibility(Object2BooleanMap<ModelPart> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientHooks.resetVisibility yet");
	}
}
