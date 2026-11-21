package dev.steelwool.patch;

import com.mojang.serialization.DynamicOps;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import net.minecraft.resources.DelegatingOps;
import net.minecraft.resources.RegistryOps;

/**
 * Reads the parts of a {@link RegistryOps}, so a subclass can copy one. NeoForge patches a copy
 * constructor into {@code RegistryOps}; vanilla only has {@code RegistryOps(DynamicOps, RegistryInfoLookup)}.
 */
public final class RegistryOpsParts {
	private static final VarHandle DELEGATE;
	private static final VarHandle LOOKUP;

	static {
		try {
			DELEGATE = MethodHandles.privateLookupIn(DelegatingOps.class, MethodHandles.lookup())
					.findVarHandle(DelegatingOps.class, "delegate", DynamicOps.class);
			LOOKUP = MethodHandles.privateLookupIn(RegistryOps.class, MethodHandles.lookup())
					.findVarHandle(RegistryOps.class, "lookupProvider", RegistryOps.RegistryInfoLookup.class);
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	private RegistryOpsParts() {
	}

	@SuppressWarnings("unchecked")
	public static <T> DynamicOps<T> delegate(RegistryOps<T> ops) {
		return (DynamicOps<T>) DELEGATE.get(ops);
	}

	public static RegistryOps.RegistryInfoLookup lookup(RegistryOps<?> ops) {
		return (RegistryOps.RegistryInfoLookup) LOOKUP.get(ops);
	}
}
