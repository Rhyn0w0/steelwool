package net.neoforged.neoforge.client;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientCommandHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientCommandHandler {
	private static final Identifier ASK_SERVER_ID = null /* SteelWool: TODO */;
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static CommandDispatcher<CommandSourceStack> commands;

	public ClientCommandHandler() {
		super();
	}

	public static void init() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandHandler.init yet");
	}

	private static void handleClientPlayerLogin(ClientPlayerNetworkEvent.LoggingIn arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandHandler.handleClientPlayerLogin yet");
	}

	public static CommandDispatcher<ClientSuggestionProvider> mergeServerCommands(CommandDispatcher<ClientSuggestionProvider> arg0, CommandBuildContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandHandler.mergeServerCommands yet");
	}

	public static CommandDispatcher<CommandSourceStack> getDispatcher() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandHandler.getDispatcher yet");
	}

	public static ClientCommandSourceStack getSource() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandHandler.getSource yet");
	}

	private static <S extends Object> void copy(CommandNode<S> arg0, CommandNode<S> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandHandler.copy yet");
	}

	public static boolean runCommand(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientCommandHandler.runCommand yet");
	}
}
