package dev.steelwool.discovery;

import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;

/**
 * The {@code @Mod} and {@code @EventBusSubscriber} classes found in a NeoForge mod jar.
 */
public record AnnotationScanResult(List<ModClass> modClasses, List<SubscriberClass> subscriberClasses) {
	public static final Set<String> ALL_DISTS = Set.of("CLIENT", "DEDICATED_SERVER");

	public AnnotationScanResult {
		modClasses = List.copyOf(modClasses);
		subscriberClasses = List.copyOf(subscriberClasses);
	}

	/**
	 * A class annotated with {@code @Mod}.
	 *
	 * @param dists the {@code Dist} names this entrypoint loads on
	 */
	public record ModClass(String className, String modId, Set<String> dists) {
	}

	/**
	 * A class annotated with {@code @EventBusSubscriber}.
	 *
	 * @param modId the explicit {@code modid} attribute, or {@code null} if absent
	 * @param dists the {@code Dist} names to subscribe on
	 */
	public record SubscriberClass(String className, @Nullable String modId, Set<String> dists) {
	}
}
