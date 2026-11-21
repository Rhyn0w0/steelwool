package net.neoforged.neoforge.client.event;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterClientCommandsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterClientCommandsEvent extends Event {
	private final CommandDispatcher<CommandSourceStack> dispatcher;
	private final CommandBuildContext context;

	public RegisterClientCommandsEvent(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext context) {
		super();
		this.dispatcher = dispatcher;
		this.context = context;
	}

	public CommandDispatcher<CommandSourceStack> getDispatcher() {
		return this.dispatcher;
	}

	public CommandBuildContext getBuildContext() {
		return this.context;
	}
}
