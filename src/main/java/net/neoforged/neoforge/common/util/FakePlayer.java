package net.neoforged.neoforge.common.util;

import java.nio.file.Path;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Consumer;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.DataFixer;
import io.netty.channel.ChannelFutureListener;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.DisconnectionDetails;
import net.minecraft.network.PacketListener;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.ServerboundClientInformationPacket;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.ServerboundKeepAlivePacket;
import net.minecraft.network.protocol.common.ServerboundResourcePackPacket;
import net.minecraft.network.protocol.game.ServerboundAcceptTeleportationPacket;
import net.minecraft.network.protocol.game.ServerboundBlockEntityTagQueryPacket;
import net.minecraft.network.protocol.game.ServerboundChangeDifficultyPacket;
import net.minecraft.network.protocol.game.ServerboundChatAckPacket;
import net.minecraft.network.protocol.game.ServerboundChatCommandPacket;
import net.minecraft.network.protocol.game.ServerboundChatPacket;
import net.minecraft.network.protocol.game.ServerboundChatSessionUpdatePacket;
import net.minecraft.network.protocol.game.ServerboundClientCommandPacket;
import net.minecraft.network.protocol.game.ServerboundCommandSuggestionPacket;
import net.minecraft.network.protocol.game.ServerboundContainerButtonClickPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClickPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.network.protocol.game.ServerboundEditBookPacket;
import net.minecraft.network.protocol.game.ServerboundEntityTagQueryPacket;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import net.minecraft.network.protocol.game.ServerboundJigsawGeneratePacket;
import net.minecraft.network.protocol.game.ServerboundLockDifficultyPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.network.protocol.game.ServerboundMoveVehiclePacket;
import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
import net.minecraft.network.protocol.game.ServerboundPlaceRecipePacket;
import net.minecraft.network.protocol.game.ServerboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerInputPacket;
import net.minecraft.network.protocol.game.ServerboundPunchPacket;
import net.minecraft.network.protocol.game.ServerboundRecipeBookChangeSettingsPacket;
import net.minecraft.network.protocol.game.ServerboundRecipeBookSeenRecipePacket;
import net.minecraft.network.protocol.game.ServerboundRenameItemPacket;
import net.minecraft.network.protocol.game.ServerboundSeenAdvancementsPacket;
import net.minecraft.network.protocol.game.ServerboundSelectTradePacket;
import net.minecraft.network.protocol.game.ServerboundSetBeaconPacket;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.network.protocol.game.ServerboundSetCommandBlockPacket;
import net.minecraft.network.protocol.game.ServerboundSetCommandMinecartPacket;
import net.minecraft.network.protocol.game.ServerboundSetCreativeModeSlotPacket;
import net.minecraft.network.protocol.game.ServerboundSetJigsawBlockPacket;
import net.minecraft.network.protocol.game.ServerboundSetStructureBlockPacket;
import net.minecraft.network.protocol.game.ServerboundSignUpdatePacket;
import net.minecraft.network.protocol.game.ServerboundTeleportToEntityPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemOnPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.players.PlayerList;
import net.minecraft.stats.Stat;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.entity.player.Player;

/**
 * SteelWool re-implementation of NeoForge's {@code FakePlayer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class FakePlayer extends ServerPlayer {
	public FakePlayer(ServerLevel arg0, GameProfile arg1) {
		super((MinecraftServer) null, (ServerLevel) null, (GameProfile) null, (ClientInformation) null);
		throw new UnsupportedOperationException("SteelWool does not implement the FakePlayer constructor yet");
	}

	public void sendSystemMessage(Component arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.sendSystemMessage yet");
	}

	public void awardStat(Stat<?> arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.awardStat yet");
	}

	public boolean canHarmPlayer(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.canHarmPlayer yet");
	}

	public void die(DamageSource arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.die yet");
	}

	public void tick() {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.tick yet");
	}

	public void updateOptions(ClientInformation arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.updateOptions yet");
	}

	public OptionalInt openMenu(MenuProvider arg0, Consumer<RegistryFriendlyByteBuf> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.openMenu yet");
	}

	public void openHorseInventory(AbstractHorse arg0, Container arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.openHorseInventory yet");
	}

	public boolean startRiding(Entity arg0, boolean arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.startRiding yet");
	}

	public boolean isFakePlayer() {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.isFakePlayer yet");
	}

	static final class FakeConnection extends net.minecraft.network.Connection {
		public FakeConnection() {
			super((PacketFlow) null);
			throw new UnsupportedOperationException("SteelWool does not implement the FakePlayer.FakeConnection constructor yet");
		}

		public void setListenerForServerboundHandshake(PacketListener arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakeConnection.setListenerForServerboundHandshake yet");
		}
	}

	public static class FakePlayerAdvancements extends PlayerAdvancements {
		public FakePlayerAdvancements(DataFixer arg0, PlayerList arg1, ServerAdvancementManager arg2, Path arg3, ServerPlayer arg4) {
			super(arg0, arg1, arg2, arg3, arg4);
		}

		public void load(ServerAdvancementManager manager) {
			// A fake player has no advancements to load.
		}

		public void setPlayer(ServerPlayer arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.setPlayer yet");
		}

		public void clearTriggers() {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.clearTriggers yet");
		}

		public void reload(ServerAdvancementManager arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.reload yet");
		}

		public void save() {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.save yet");
		}

		public boolean award(AdvancementHolder arg0, String arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.award yet");
		}

		public boolean revoke(AdvancementHolder arg0, String arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.revoke yet");
		}

		public void flushDirty(ServerPlayer arg0, boolean arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.flushDirty yet");
		}

		public void setSelectedTab(AdvancementHolder arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.setSelectedTab yet");
		}

		public AdvancementProgress getOrStartProgress(AdvancementHolder arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerAdvancements.getOrStartProgress yet");
		}
	}

	static class FakePlayerNetHandler extends ServerGamePacketListenerImpl {
		private static final net.minecraft.network.Connection DUMMY_CONNECTION = null /* SteelWool: TODO */;

		public FakePlayerNetHandler(MinecraftServer arg0, ServerPlayer arg1) {
			super((MinecraftServer) null, (net.minecraft.network.Connection) null, (ServerPlayer) null, (CommonListenerCookie) null);
			throw new UnsupportedOperationException("SteelWool does not implement the FakePlayer.FakePlayerNetHandler constructor yet");
		}

		public void tick() {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.tick yet");
		}

		public void resetPosition() {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.resetPosition yet");
		}

		public void disconnect(Component arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.disconnect yet");
		}

		public void handlePlayerInput(ServerboundPlayerInputPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handlePlayerInput yet");
		}

		public void handleMoveVehicle(ServerboundMoveVehiclePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleMoveVehicle yet");
		}

		public void handleAcceptTeleportPacket(ServerboundAcceptTeleportationPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleAcceptTeleportPacket yet");
		}

		public void handleRecipeBookSeenRecipePacket(ServerboundRecipeBookSeenRecipePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleRecipeBookSeenRecipePacket yet");
		}

		public void handleRecipeBookChangeSettingsPacket(ServerboundRecipeBookChangeSettingsPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleRecipeBookChangeSettingsPacket yet");
		}

		public void handleSeenAdvancements(ServerboundSeenAdvancementsPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSeenAdvancements yet");
		}

		public void handleCustomCommandSuggestions(ServerboundCommandSuggestionPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleCustomCommandSuggestions yet");
		}

		public void handleSetCommandBlock(ServerboundSetCommandBlockPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSetCommandBlock yet");
		}

		public void handleSetCommandMinecart(ServerboundSetCommandMinecartPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSetCommandMinecart yet");
		}

		public void handleRenameItem(ServerboundRenameItemPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleRenameItem yet");
		}

		public void handleSetBeaconPacket(ServerboundSetBeaconPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSetBeaconPacket yet");
		}

		public void handleSetStructureBlock(ServerboundSetStructureBlockPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSetStructureBlock yet");
		}

		public void handleSetJigsawBlock(ServerboundSetJigsawBlockPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSetJigsawBlock yet");
		}

		public void handleJigsawGenerate(ServerboundJigsawGeneratePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleJigsawGenerate yet");
		}

		public void handleSelectTrade(ServerboundSelectTradePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSelectTrade yet");
		}

		public void handleEditBook(ServerboundEditBookPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleEditBook yet");
		}

		public void handleEntityTagQuery(ServerboundEntityTagQueryPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleEntityTagQuery yet");
		}

		public void handleBlockEntityTagQuery(ServerboundBlockEntityTagQueryPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleBlockEntityTagQuery yet");
		}

		public void handleMovePlayer(ServerboundMovePlayerPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleMovePlayer yet");
		}

		public void teleport(double arg0, double arg1, double arg2, float arg3, float arg4) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.teleport yet");
		}

		public void handlePlayerAction(ServerboundPlayerActionPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handlePlayerAction yet");
		}

		public void handleUseItemOn(ServerboundUseItemOnPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleUseItemOn yet");
		}

		public void handleUseItem(ServerboundUseItemPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleUseItem yet");
		}

		public void handleTeleportToEntityPacket(ServerboundTeleportToEntityPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleTeleportToEntityPacket yet");
		}

		public void handleResourcePackResponse(ServerboundResourcePackPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleResourcePackResponse yet");
		}

		public void handlePaddleBoat(ServerboundPaddleBoatPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handlePaddleBoat yet");
		}

		public void onDisconnect(DisconnectionDetails arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.onDisconnect yet");
		}

		public void send(Packet<?> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.send yet");
		}

		public void send(Packet<?> arg0, ChannelFutureListener arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.send yet");
		}

		public void handleSetCarriedItem(ServerboundSetCarriedItemPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSetCarriedItem yet");
		}

		public void handleChat(ServerboundChatPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleChat yet");
		}

		public void handlePunch(ServerboundPunchPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handlePunch yet");
		}

		public void handlePlayerCommand(ServerboundPlayerCommandPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handlePlayerCommand yet");
		}

		public void handleInteract(ServerboundInteractPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleInteract yet");
		}

		public void handleClientCommand(ServerboundClientCommandPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleClientCommand yet");
		}

		public void handleContainerClose(ServerboundContainerClosePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleContainerClose yet");
		}

		public void handleContainerClick(ServerboundContainerClickPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleContainerClick yet");
		}

		public void handlePlaceRecipe(ServerboundPlaceRecipePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handlePlaceRecipe yet");
		}

		public void handleContainerButtonClick(ServerboundContainerButtonClickPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleContainerButtonClick yet");
		}

		public void handleSetCreativeModeSlot(ServerboundSetCreativeModeSlotPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSetCreativeModeSlot yet");
		}

		public void handleSignUpdate(ServerboundSignUpdatePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleSignUpdate yet");
		}

		public void handleKeepAlive(ServerboundKeepAlivePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleKeepAlive yet");
		}

		public void handleCustomPayload(ServerboundCustomPayloadPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleCustomPayload yet");
		}

		public void handleClientInformation(ServerboundClientInformationPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleClientInformation yet");
		}

		public void handlePlayerAbilities(ServerboundPlayerAbilitiesPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handlePlayerAbilities yet");
		}

		public void handleChangeDifficulty(ServerboundChangeDifficultyPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleChangeDifficulty yet");
		}

		public void handleLockDifficulty(ServerboundLockDifficultyPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleLockDifficulty yet");
		}

		public void teleport(PositionMoveRotation arg0, Set<Relative> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.teleport yet");
		}

		public void ackBlockChangesUpTo(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.ackBlockChangesUpTo yet");
		}

		public void handleChatCommand(ServerboundChatCommandPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleChatCommand yet");
		}

		public void handleChatAck(ServerboundChatAckPacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleChatAck yet");
		}

		public void sendPlayerChatMessage(PlayerChatMessage arg0, ChatType.Bound arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.sendPlayerChatMessage yet");
		}

		public void sendDisguisedChatMessage(Component arg0, ChatType.Bound arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.sendDisguisedChatMessage yet");
		}

		public void handleChatSessionUpdate(ServerboundChatSessionUpdatePacket arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.handleChatSessionUpdate yet");
		}

		public boolean hasChannel(Identifier arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FakePlayer.FakePlayerNetHandler.hasChannel yet");
		}
	}
}
