package net.neoforged.fml.loading.moddiscovery;

import java.lang.annotation.ElementType;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import dev.steelwool.discovery.AnnotationScanResult;
import dev.steelwool.discovery.NeoForgeModFile;
import net.neoforged.fml.jarcontents.JarContents;
import net.neoforged.fml.loading.modscan.ModAnnotation;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.language.ModFileScanData;
import net.neoforged.neoforgespi.locating.IModFile;
import net.neoforged.neoforgespi.locating.ModFileDiscoveryAttributes;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of FML's {@code ModFile}: a NeoForge mod jar SteelWool loaded.
 */
public class ModFile implements IModFile {
	private final NeoForgeModFile source;
	private final ModFileInfo info;
	private final ModFileDiscoveryAttributes discoveryAttributes;
	private final JarContents contents;
	private @Nullable ModFileScanData scanData;

	/** Created by SteelWool's loader; not part of the NeoForge API. */
	public ModFile(NeoForgeModFile source, @Nullable IModFile parent) {
		this.source = source;
		this.discoveryAttributes = parent == null ? ModFileDiscoveryAttributes.DEFAULT : ModFileDiscoveryAttributes.DEFAULT.withParent(parent);
		this.contents = new dev.steelwool.loading.SteelWoolJarContents(source.path());
		this.info = new ModFileInfo(this, source);
	}

	/** The jar SteelWool discovered; not part of the NeoForge API. */
	public NeoForgeModFile steelwool$source() {
		return source;
	}

	@Override
	public String getId() {
		return info.getMods().getFirst().getModId();
	}

	@Override
	public JarContents getContents() {
		return contents;
	}

	@Override
	public Supplier<Map<String, Object>> getSubstitutionMap() {
		return () -> Map.of("file", Map.of("jarVersion", info.versionString()));
	}

	@Override
	public Type getType() {
		return Type.MOD;
	}

	@Override
	public Path getFilePath() {
		return source.path();
	}

	@Override
	public List<IModInfo> getModInfos() {
		return info.getMods();
	}

	@Override
	public synchronized ModFileScanData getScanResult() {
		if (scanData == null) {
			scanData = toScanData(source.scan());
			scanData.addModFileInfo(info);
		}

		return scanData;
	}

	@Override
	public String getFileName() {
		return source.fileName();
	}

	@Override
	public ModFileDiscoveryAttributes getDiscoveryAttributes() {
		return discoveryAttributes;
	}

	@Override
	public IModFileInfo getModFileInfo() {
		return info;
	}

	public ArtifactVersion getJarVersion() {
		return new DefaultArtifactVersion(info.versionString());
	}

	public List<String> getAccessTransformers() {
		return source.modsToml().accessTransformers();
	}

	@Override
	public String toString() {
		return "Mod File: " + source.path();
	}

	private static ModFileScanData toScanData(AnnotationScanResult scan) {
		ModFileScanData data = new ModFileScanData();

		for (AnnotationScanResult.ClassInfo c : scan.classes()) {
			Set<org.objectweb.asm.Type> interfaces = new LinkedHashSet<>();
			c.interfaces().forEach(i -> interfaces.add(org.objectweb.asm.Type.getObjectType(i)));
			org.objectweb.asm.Type parent = c.superName() == null ? null : org.objectweb.asm.Type.getObjectType(c.superName());
			data.getClasses().add(new ModFileScanData.ClassData(org.objectweb.asm.Type.getObjectType(c.internalName()), parent, interfaces));
		}

		for (AnnotationScanResult.Annotation a : scan.annotations()) {
			data.getAnnotations().add(new ModFileScanData.AnnotationData(
					org.objectweb.asm.Type.getType(a.descriptor()),
					ElementType.valueOf(a.targetType()),
					org.objectweb.asm.Type.getObjectType(a.owner()),
					a.memberName(),
					convertMap(a.values())));
		}

		return data;
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> convertMap(Map<String, Object> values) {
		Map<String, Object> result = new LinkedHashMap<>();
		values.forEach((k, v) -> result.put(k, convert(v)));
		return result;
	}

	@SuppressWarnings("unchecked")
	private static Object convert(Object value) {
		if (value instanceof AnnotationScanResult.EnumValue e) {
			return new ModAnnotation.EnumHolder(e.descriptor(), e.value());
		}

		if (value instanceof List<?> list) {
			List<Object> result = new ArrayList<>();
			list.forEach(v -> result.add(convert(v)));
			return result;
		}

		if (value instanceof Map<?, ?> map) {
			return convertMap((Map<String, Object>) map);
		}

		return value;
	}
}
