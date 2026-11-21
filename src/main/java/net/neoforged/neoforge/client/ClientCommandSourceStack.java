package net.neoforged.neoforge.client;

import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Scoreboard;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientCommandSourceStack}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientCommandSourceStack extends CommandSourceStack {
	public ClientCommandSourceStack(CommandSource arg0, Vec3 arg1, Vec2 arg2, PermissionSet arg3, Entity arg4) {
		super(arg0, arg1, arg2, null, arg3, null, arg4);
	}

	private ClientPacketListener connection() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.connection yet");
	}

	public void sendSuccess(Supplier<Component> arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.sendSuccess yet");
	}

	public Collection<String> getAllTeams() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.getAllTeams yet");
	}

	public Collection<String> getOnlinePlayerNames() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.getOnlinePlayerNames yet");
	}

	public Set<ResourceKey<Level>> levels() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.levels yet");
	}

	public RegistryAccess registryAccess() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.registryAccess yet");
	}

	public FeatureFlagSet enabledFeatures() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.enabledFeatures yet");
	}

	public Scoreboard getScoreboard() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.getScoreboard yet");
	}

	public AdvancementHolder getAdvancement(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.getAdvancement yet");
	}

	public Level getUnsidedLevel() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.getUnsidedLevel yet");
	}

	public MinecraftServer getServer() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.getServer yet");
	}

	public ServerLevel getLevel() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandSourceStack.getLevel yet");
	}
}
