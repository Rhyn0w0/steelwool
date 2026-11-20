package net.neoforged.fml.javafmlmod;

import java.util.EnumSet;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.Type;

/**
 * SteelWool re-implementation of NeoForge's {@code AutomaticEventSubscriber}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AutomaticEventSubscriber {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static final Type AUTO_SUBSCRIBER = null /* SteelWool: TODO */;
	private static final Type MOD_TYPE = null /* SteelWool: TODO */;

	public AutomaticEventSubscriber() {
		super();
	}

	public static void inject(ModContainer arg0, ModFileScanData arg1, Module arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement AutomaticEventSubscriber.inject yet");
	}

	public static EnumSet<Dist> getSides(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AutomaticEventSubscriber.getSides yet");
	}
}
