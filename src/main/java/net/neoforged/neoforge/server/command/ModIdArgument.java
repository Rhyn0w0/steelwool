package net.neoforged.neoforge.server.command;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

/**
 * SteelWool re-implementation of NeoForge's {@code ModIdArgument}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ModIdArgument extends Object implements ArgumentType<String> {
	private static final List<String> EXAMPLES = null /* SteelWool: TODO */;

	public ModIdArgument() {
		super();
	}

	public static net.neoforged.neoforge.server.command.ModIdArgument modIdArgument() {
		throw new UnsupportedOperationException("SteelWool does not implement ModIdArgument.modIdArgument yet");
	}

	public String parse(StringReader arg0) throws CommandSyntaxException {
		throw new UnsupportedOperationException("SteelWool does not implement ModIdArgument.parse yet");
	}

	public <S extends Object> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> arg0, SuggestionsBuilder arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ModIdArgument.listSuggestions yet");
	}

	public Collection<String> getExamples() {
		throw new UnsupportedOperationException("SteelWool does not implement ModIdArgument.getExamples yet");
	}
}
