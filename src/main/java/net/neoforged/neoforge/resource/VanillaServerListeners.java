package net.neoforged.neoforge.resource;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import net.minecraft.resources.Identifier;
import net.minecraft.server.ServerFunctionLibrary;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import org.jspecify.annotations.Nullable;

/** Names for vanilla's server reload listeners, so mods can order their listeners around them. */
public class VanillaServerListeners {
	private static final Map<Class<?>, Identifier> KNOWN_CLASSES = new LinkedHashMap<>();

	public static final Identifier FUNCTIONS = key(ServerFunctionLibrary.class);
	/** The first vanilla server listener. */
	public static final Identifier FIRST = FUNCTIONS;
	/** The last vanilla server listener. */
	public static final Identifier LAST = FUNCTIONS;

	private static Identifier key(Class<? extends PreparableReloadListener> type) {
		// ServerFunctionLibrary -> minecraft:server_function_library
		String name = type.getSimpleName().replaceAll("([a-z0-9])([A-Z])", "$1_$2").toLowerCase(Locale.ROOT);
		Identifier key = Identifier.withDefaultNamespace(name);
		KNOWN_CLASSES.put(type, key);
		return key;
	}

	public static @Nullable Identifier getNameForClass(Class<? extends PreparableReloadListener> type) {
		return KNOWN_CLASSES.get(type);
	}
}
