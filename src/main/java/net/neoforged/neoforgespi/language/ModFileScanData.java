package net.neoforged.neoforgespi.language;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.objectweb.asm.Type;

/**
 * SteelWool re-implementation of FML's {@code ModFileScanData}: the classes and annotations in a mod jar.
 */
public class ModFileScanData {
	private final Set<AnnotationData> annotations = new LinkedHashSet<>();
	private final Set<ClassData> classes = new LinkedHashSet<>();
	private final List<IModFileInfo> modFileInfos = new ArrayList<>();

	public ModFileScanData() {
	}

	public Set<ClassData> getClasses() {
		return classes;
	}

	public Set<AnnotationData> getAnnotations() {
		return annotations;
	}

	public Stream<AnnotationData> getAnnotatedBy(Class<? extends Annotation> type, ElementType elementType) {
		Type asmType = Type.getType(type);
		return annotations.stream().filter(a -> a.targetType() == elementType && a.annotationType().equals(asmType));
	}

	public void addModFileInfo(IModFileInfo info) {
		modFileInfos.add(info);
	}

	public List<IModFileInfo> getIModInfoData() {
		return modFileInfos;
	}

	public record AnnotationData(Type annotationType, ElementType targetType, Type clazz, String memberName, Map<String, Object> annotationData) {
	}

	public record ClassData(Type clazz, Type parent, Set<Type> interfaces) {
	}
}
