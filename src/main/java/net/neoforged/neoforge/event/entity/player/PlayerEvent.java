package net.neoforged.neoforge.event.entity.player;

import java.io.File;
import java.util.Optional;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class PlayerEvent extends LivingEvent {
	private final Player player;

	public PlayerEvent(Player player) {
		super(player);
		this.player = player;
	}

	public Player getEntity() {
		return this.player;
	}

	public static class BreakSpeed extends net.neoforged.neoforge.event.entity.player.PlayerEvent implements ICancellableEvent {
		private static final BlockPos LEGACY_UNKNOWN = null /* SteelWool: TODO */;
		private final BlockState state;
		private final float originalSpeed;
		private float newSpeed;
		private final Optional<BlockPos> pos;

		public BreakSpeed(Player player, BlockState state, float originalSpeed, BlockPos pos) {
			super(player);
			this.state = state;
			this.originalSpeed = originalSpeed;
			this.newSpeed = originalSpeed;
			this.pos = Optional.ofNullable(pos);
		}

		public BlockState getState() {
			return this.state;
		}

		public float getOriginalSpeed() {
			return this.originalSpeed;
		}

		public float getNewSpeed() {
			return this.newSpeed;
		}

		public void setNewSpeed(float newSpeed) {
			this.newSpeed = newSpeed;
		}

		public Optional<BlockPos> getPosition() {
			return this.pos;
		}
	}

	public static class Clone extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final Player original;
		private final boolean wasDeath;

		public Clone(Player arg0, Player original, boolean wasDeath) {
			super(arg0);
			this.original = original;
			this.wasDeath = wasDeath;
		}

		public Player getOriginal() {
			return this.original;
		}

		public boolean isWasDeath() {
			return this.wasDeath;
		}
	}

	public static class HarvestCheck extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final BlockState state;
		private final BlockGetter level;
		private final BlockPos pos;
		private boolean success;

		public HarvestCheck(Player arg0, BlockState state, BlockGetter level, BlockPos pos, boolean success) {
			super(arg0);
			this.state = state;
			this.level = level;
			this.pos = pos;
			this.success = success;
		}

		public BlockState getTargetBlock() {
			return this.state;
		}

		public BlockGetter getLevel() {
			return this.level;
		}

		public BlockPos getPos() {
			return this.pos;
		}

		public boolean canHarvest() {
			return this.success;
		}

		public void setCanHarvest(boolean success) {
			this.success = success;
		}
	}

	public static class ItemCraftedEvent extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final ItemStack crafting;
		private final Container craftMatrix;

		public ItemCraftedEvent(Player arg0, ItemStack crafting, Container craftMatrix) {
			super(arg0);
			this.crafting = crafting;
			this.craftMatrix = craftMatrix;
		}

		public ItemStack getCrafting() {
			return this.crafting;
		}

		public Container getInventory() {
			return this.craftMatrix;
		}
	}

	public static class ItemSmeltedEvent extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final ItemStack smelting;
		private final int amountRemoved;

		public ItemSmeltedEvent(Player arg0, ItemStack smelting, int amountRemoved) {
			super(arg0);
			this.smelting = smelting;
			this.amountRemoved = amountRemoved;
		}

		public ItemStack getSmelting() {
			return this.smelting;
		}

		public int getAmountRemoved() {
			return this.amountRemoved;
		}
	}

	public static class ItemSmithedEvent extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final Container inputs;
		private final ItemStack result;

		public ItemSmithedEvent(Player arg0, Container inputs, ItemStack result) {
			super(arg0);
			this.inputs = inputs;
			this.result = result;
		}

		public Container getInputs() {
			return this.inputs;
		}

		public ItemStack getResult() {
			return this.result;
		}
	}

	public static class LoadFromFile extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final File playerDirectory;
		private final String playerUUID;

		public LoadFromFile(Player arg0, File playerDirectory, String playerUUID) {
			super(arg0);
			this.playerDirectory = playerDirectory;
			this.playerUUID = playerUUID;
		}

		public File getPlayerFile(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerEvent.LoadFromFile.getPlayerFile yet");
		}

		public File getPlayerDirectory() {
			return this.playerDirectory;
		}

		public String getPlayerUUID() {
			return this.playerUUID;
		}
	}

	public static class NameFormat extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final Component username;
		private Component displayname;

		public NameFormat(Player player, Component username) {
			super(player);
			this.username = username;
			this.displayname = username;
		}

		public Component getUsername() {
			return this.username;
		}

		public Component getDisplayname() {
			return this.displayname;
		}

		public void setDisplayname(Component displayname) {
			this.displayname = displayname;
		}
	}

	public static class PlayerChangeGameModeEvent extends net.neoforged.neoforge.event.entity.player.PlayerEvent implements ICancellableEvent {
		private final GameType currentGameMode;
		private GameType newGameMode;

		public PlayerChangeGameModeEvent(Player arg0, GameType currentGameMode, GameType newGameMode) {
			super(arg0);
			this.currentGameMode = currentGameMode;
			this.newGameMode = newGameMode;
		}

		public GameType getCurrentGameMode() {
			return this.currentGameMode;
		}

		public GameType getNewGameMode() {
			return this.newGameMode;
		}

		public void setNewGameMode(GameType newGameMode) {
			this.newGameMode = newGameMode;
		}
	}

	public static class PlayerChangedDimensionEvent extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final ResourceKey<Level> fromDim;
		private final ResourceKey<Level> toDim;

		public PlayerChangedDimensionEvent(Player arg0, ResourceKey<Level> fromDim, ResourceKey<Level> toDim) {
			super(arg0);
			this.fromDim = fromDim;
			this.toDim = toDim;
		}

		public ResourceKey<Level> getFrom() {
			return this.fromDim;
		}

		public ResourceKey<Level> getTo() {
			return this.toDim;
		}
	}

	public static class PlayerLoggedInEvent extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		public PlayerLoggedInEvent(Player arg0) {
			super(arg0);
		}
	}

	public static class PlayerLoggedOutEvent extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		public PlayerLoggedOutEvent(Player arg0) {
			super(arg0);
		}
	}

	public static class PlayerRespawnEvent extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final boolean endConquered;

		public PlayerRespawnEvent(Player arg0, boolean endConquered) {
			super(arg0);
			this.endConquered = endConquered;
		}

		public boolean isEndConquered() {
			return this.endConquered;
		}
	}

	public static class SaveToFile extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final File playerDirectory;
		private final String playerUUID;

		public SaveToFile(Player arg0, File playerDirectory, String playerUUID) {
			super(arg0);
			this.playerDirectory = playerDirectory;
			this.playerUUID = playerUUID;
		}

		public File getPlayerFile(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerEvent.SaveToFile.getPlayerFile yet");
		}

		public File getPlayerDirectory() {
			return this.playerDirectory;
		}

		public String getPlayerUUID() {
			return this.playerUUID;
		}
	}

	public static class StartTracking extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final Entity target;

		public StartTracking(Player arg0, Entity target) {
			super(arg0);
			this.target = target;
		}

		public Entity getTarget() {
			return this.target;
		}
	}

	public static class StopTracking extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private final Entity target;

		public StopTracking(Player arg0, Entity target) {
			super(arg0);
			this.target = target;
		}

		public Entity getTarget() {
			return this.target;
		}
	}

	public static class TabListNameFormat extends net.neoforged.neoforge.event.entity.player.PlayerEvent {
		private Component displayName;

		public TabListNameFormat(Player arg0) {
			super(arg0);
		}

		public Component getDisplayName() {
			return this.displayName;
		}

		public void setDisplayName(Component displayName) {
			this.displayName = displayName;
		}
	}
}
