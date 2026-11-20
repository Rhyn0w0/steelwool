package dev.steelwool.loading;

import org.jspecify.annotations.Nullable;

/**
 * A NeoForge mod failed to load. The message explains which mod and, where possible, which
 * NeoForge API it needed that SteelWool does not provide yet.
 */
public class ModLoadingFailure extends RuntimeException {
	public ModLoadingFailure(String message, @Nullable Throwable cause) {
		super(message, cause);
	}

	public static ModLoadingFailure of(String modId, String what, @Nullable Throwable cause) {
		StringBuilder message = new StringBuilder("NeoForge mod '").append(modId).append("' failed to load: ").append(what);
		String missing = missingNeoForgeApi(cause);

		if (missing != null) {
			message.append(". It uses NeoForge API ").append(missing)
					.append(", which SteelWool does not support yet");
		}

		return new ModLoadingFailure(message.toString(), cause);
	}

	/** Finds a missing {@code net.neoforged} class or member in the cause chain, if any. */
	static @Nullable String missingNeoForgeApi(@Nullable Throwable cause) {
		for (Throwable t = cause; t != null; t = t.getCause()) {
			if ((t instanceof NoClassDefFoundError || t instanceof ClassNotFoundException
					|| t instanceof NoSuchMethodError || t instanceof NoSuchFieldError)
					&& t.getMessage() != null) {
				String name = t.getMessage().replace('/', '.');

				if (name.contains("net.neoforged")) {
					return "'" + name + "'";
				}
			}
		}

		return null;
	}
}
