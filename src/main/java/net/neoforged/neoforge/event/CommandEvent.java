package net.neoforged.neoforge.event;

import com.mojang.brigadier.ParseResults;
import net.minecraft.commands.CommandSourceStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code CommandEvent}, with the same API.
 */
public class CommandEvent extends Event implements ICancellableEvent {
	private ParseResults<CommandSourceStack> parse;
	private Throwable exception;

	public CommandEvent(ParseResults<CommandSourceStack> parse) {
		super();
		this.parse = parse;
	}

	public ParseResults<CommandSourceStack> getParseResults() {
		return this.parse;
	}

	public void setParseResults(ParseResults<CommandSourceStack> parse) {
		this.parse = parse;
	}

	public Throwable getException() {
		return this.exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}
}
