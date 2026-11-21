package dev.steelwool.discovery;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jspecify.annotations.Nullable;

/**
 * What {@link AnnotationScanner} found in a NeoForge mod jar.
 *
 * @param modClasses        classes annotated with {@code @Mod}
 * @param subscriberClasses classes annotated with {@code @EventBusSubscriber}
 * @param classes           every class with its superclass and interfaces
 * @param annotations       every class, method and field annotation
 */
public record AnnotationScanResult(
		List<ModClass> modClasses,
		List<SubscriberClass> subscriberClasses,
		List<ClassInfo> classes,
		List<Annotation> annotations) {
	public static final Set<String> ALL_DISTS = Set.of("CLIENT", "DEDICATED_SERVER");

	public AnnotationScanResult {
		modClasses = List.copyOf(modClasses);
		subscriberClasses = List.copyOf(subscriberClasses);
		classes = List.copyOf(classes);
		annotations = List.copyOf(annotations);
	}

	public AnnotationScanResult(List<ModClass> modClasses, List<SubscriberClass> subscriberClasses) {
		this(modClasses, subscriberClasses, List.of(), List.of());
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

	/** A class, by internal name, with its superclass ({@code null} for {@code Object}) and interfaces. */
	public record ClassInfo(String internalName, @Nullable String superName, List<String> interfaces) {
	}

	/**
	 * An annotation on a class, method or field.
	 *
	 * @param descriptor  the annotation type's descriptor
	 * @param targetType  {@code TYPE}, {@code METHOD} or {@code FIELD} (a {@code java.lang.annotation.ElementType} name)
	 * @param owner       internal name of the class it is in
	 * @param memberName  the class name for {@code TYPE}, the field name, or the method name followed by its descriptor
	 * @param values      its attributes (see {@link AnnotationScanner})
	 */
	public record Annotation(String descriptor, String targetType, String owner, String memberName, Map<String, Object> values) {
	}

	/** An enum constant in an annotation attribute. */
	public record EnumValue(String descriptor, String value) {
	}
}
