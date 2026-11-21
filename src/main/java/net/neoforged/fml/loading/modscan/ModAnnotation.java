package net.neoforged.fml.loading.modscan;

/**
 * SteelWool subset of FML's {@code ModAnnotation}. Only {@link EnumHolder}, the type of enum values in
 * {@code ModFileScanData.AnnotationData#annotationData()}, is provided.
 */
public class ModAnnotation {
	private ModAnnotation() {
	}

	public record EnumHolder(String desc, String value) {
	}
}
