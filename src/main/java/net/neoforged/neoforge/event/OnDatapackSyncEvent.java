package net.neoforged.neoforge.event;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import it.unimi.dsi.fastutil.objects.ReferenceSet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code OnDatapackSyncEvent}, with the same API.
 */
public class OnDatapackSyncEvent extends Event {
	private final PlayerList playerList;
	private final ServerPlayer player;
	private final ReferenceSet<RecipeType<?>> recipeTypesToSend;

	public OnDatapackSyncEvent(PlayerList playerList, ServerPlayer player) {
		this.playerList = playerList;
		this.player = player;
		this.recipeTypesToSend = new ReferenceOpenHashSet<>();
	}

	public PlayerList getPlayerList() {
		return this.playerList;
	}

	public Stream<ServerPlayer> getRelevantPlayers() {
		return player == null ? playerList.getPlayers().stream() : Stream.of(player);
	}

	public ServerPlayer getPlayer() {
		return this.player;
	}

	public void sendRecipes(RecipeType<?>... recipeTypes) {
		Collections.addAll(recipeTypesToSend, recipeTypes);
	}

	public void sendRecipes(Iterable<RecipeType<?>> recipeTypes) {
		recipeTypes.forEach(recipeTypesToSend::add);
	}

	public Set<RecipeType<?>> getRecipeTypesToSend() {
		return Collections.unmodifiableSet(recipeTypesToSend);
	}
}
