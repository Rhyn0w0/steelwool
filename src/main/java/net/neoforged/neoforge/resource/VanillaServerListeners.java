package net.neoforged.neoforge.resource;

import java.util.Map;

import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;

/**
 * SteelWool re-implementation of NeoForge's {@code VanillaServerListeners}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class VanillaServerListeners {
	private static final Map<Class<?>, Identifier> KNOWN_CLASSES = null /* SteelWool: TODO */;
	public static final Identifier FUNCTIONS = null /* SteelWool: TODO */;
	public static final Identifier FIRST = null /* SteelWool: TODO */;
	public static final Identifier LAST = null /* SteelWool: TODO */;

	public VanillaServerListeners() {
		super();
	}

	private static Identifier key(Class<? extends PreparableReloadListener> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaServerListeners.key yet");
	}

	public static Identifier getNameForClass(Class<? extends PreparableReloadListener> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaServerListeners.getNameForClass yet");
	}
}
