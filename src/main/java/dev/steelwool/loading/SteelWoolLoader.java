package dev.steelwool.loading;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

import dev.steelwool.config.SteelWoolConfigs;
import dev.steelwool.discovery.AccessTransformers;
import dev.steelwool.discovery.AnnotationScanResult;
import dev.steelwool.discovery.NeoForgeModDiscovery;
import dev.steelwool.discovery.NeoForgeModFile;
import dev.steelwool.discovery.NeoForgeModMetadata;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.fabricmc.loader.impl.lib.classtweaker.api.ClassTweakerReader;
import net.fabricmc.loader.impl.launch.FabricLauncherBase;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.event.lifecycle.InterModProcessEvent;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.LoadingModList;
import net.neoforged.fml.loading.moddiscovery.ModFile;
import net.neoforged.fml.loading.moddiscovery.ModInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixins;

/**
 * Drives the NeoForge mod lifecycle on top of Fabric:
 *
 * <ol>
 * <li>{@link #discoverAndAttach()} (Fabric {@code preLaunch}): find jars in {@code mods/neoforge/},
 * put them on the game class path and register their mixin configs.</li>
 * <li>{@link #constructAndRegister()} (Fabric {@code main}): construct {@code @Mod} classes, load
 * configs, fire {@link RegisterEvent} for every registry and {@link FMLCommonSetupEvent}.</li>
 * <li>{@link #finishLoading(Dist)} (Fabric {@code client} / {@code server}): side setup, inter-mod
 * comms and {@link FMLLoadCompleteEvent}.</li>
 * </ol>
 */
public final class SteelWoolLoader {
	public static final String MODS_DIR_PROPERTY = "steelwool.neoforgeModsDir";
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool");
	private static final SteelWoolLoader INSTANCE = new SteelWoolLoader();
	/** Mod ids that NeoForge mods may depend on and that are always "present" under SteelWool. */
	private static final Set<String> PROVIDED_MOD_IDS = Set.of("neoforge", "minecraft", "fml", "javafml");

	private List<NeoForgeModFile> modFiles = List.of();
	private final List<FMLModContainer> containers = new ArrayList<>();
	private final Map<String, ModInfo> modInfos = new HashMap<>();
	private boolean attached;

	private SteelWoolLoader() {
	}

	public static SteelWoolLoader get() {
		return INSTANCE;
	}

	/** The NeoForge mod jars found at startup. */
	public List<NeoForgeModFile> modFiles() {
		return modFiles;
	}

	public List<FMLModContainer> containers() {
		return List.copyOf(containers);
	}

	public static Path neoForgeModsDir() {
		String override = System.getProperty(MODS_DIR_PROPERTY);
		return override != null ? Path.of(override) : FabricLoader.getInstance().getGameDir().resolve("mods").resolve("neoforge");
	}

	// ---- Phase 1: preLaunch ----

	public void discoverAndAttach() {
		if (attached) {
			return;
		}

		attached = true;
		Path dir = neoForgeModsDir();
		NeoForgeModDiscovery.Result result;

		try {
			Files.createDirectories(dir);
			// Mixin config plugins of NeoForge mods may write their own config files before the game creates config/.
			Files.createDirectories(FabricLoader.getInstance().getConfigDir());
			result = new NeoForgeModDiscovery(FabricLoader.getInstance().getGameDir().resolve(".steelwool").resolve("jarjar")).discover(dir);
		} catch (IOException e) {
			throw new UncheckedIOException("SteelWool could not read NeoForge mods from " + dir, e);
		}

		result.skipped().forEach((path, reason) -> LOGGER.warn("Ignoring {} in {}: {}", path.getFileName(), dir, reason));
		modFiles = List.copyOf(result.mods());
		validate(modFiles);
		publishLoadingModList();
		result.libraries().forEach(lib -> FabricLauncherBase.getLauncher().addToClassPath(lib));

		for (NeoForgeModFile file : modFiles) {
			FabricLauncherBase.getLauncher().addToClassPath(file.path());
			file.libraries().forEach(lib -> FabricLauncherBase.getLauncher().addToClassPath(lib));

			for (String mixinConfig : file.modsToml().mixinConfigs()) {
				Mixins.addConfiguration(mixinConfig);
			}

			applyAccessTransformers(file);
		}

		if (modFiles.isEmpty()) {
			LOGGER.info("No NeoForge mods found in {}", dir);
		} else {
			LOGGER.info("Found {} NeoForge mod(s) in {}: {}", modIdCount(), dir,
					modFiles.stream().flatMap(f -> f.modsToml().mods().stream()).map(m -> m.modId() + " " + m.version()).toList());
		}
	}

	/** FML's default when {@code neoforge.mods.toml} lists no access transformers. */
	private static final String DEFAULT_ACCESS_TRANSFORMER = "META-INF/accesstransformer.cfg";

	/**
	 * Applies a mod's access transformers by translating them to Fabric access widener entries, which
	 * Fabric applies to classes as they load. Classes already loaded at this point are not changed.
	 */
	private static void applyAccessTransformers(NeoForgeModFile file) {
		List<String> declared = file.modsToml().accessTransformers();

		try (FileSystem fs = FileSystems.newFileSystem(file.path())) {
			List<String> paths = declared.isEmpty() && Files.exists(fs.getPath(DEFAULT_ACCESS_TRANSFORMER)) ? List.of(DEFAULT_ACCESS_TRANSFORMER) : declared;
			List<AccessTransformers.Entry> entries = new ArrayList<>();

			for (String atPath : paths) {
				Path at = fs.getPath(atPath);

				if (!Files.exists(at)) {
					LOGGER.warn("{} declares access transformer {}, which is not in the jar", file.fileName(), atPath);
					continue;
				}

				try (var reader = Files.newBufferedReader(at)) {
					entries.addAll(AccessTransformers.parse(reader));
				}
			}

			if (entries.isEmpty()) {
				return;
			}

			List<String> problems = new ArrayList<>();
			List<String> lines = AccessTransformers.toAccessWidener(entries, SteelWoolLoader::classBytes, problems);
			problems.forEach(p -> LOGGER.debug("{}: skipping access transformer entry: {}", file.fileName(), p));

			String namespace = FabricLauncherBase.getLauncher().getMappingConfiguration().getRuntimeNamespace();
			String widener = "accessWidener v2 " + namespace + "\n" + String.join("\n", lines) + "\n";
			ClassTweakerReader.create(FabricLoaderImpl.INSTANCE.getClassTweaker()).read(widener.getBytes(StandardCharsets.UTF_8), namespace);
			LOGGER.debug("Applied {} access transformer entries from {}", lines.size(), file.fileName());
		} catch (IOException | RuntimeException e) {
			throw ModLoadingFailure.of(file.modsToml().mods().getFirst().modId(), "its access transformers could not be applied", e);
		}
	}

	private static byte @Nullable [] classBytes(String internalName) {
		try {
			return FabricLauncherBase.getLauncher().getClassByteArray(internalName.replace('/', '.'), false);
		} catch (IOException e) {
			return null;
		}
	}

	/** Makes the discovered mods visible through FML's {@code LoadingModList} / {@code ModList} file APIs. */
	private void publishLoadingModList() {
		Map<Path, ModFile> byPath = new HashMap<>();
		List<ModFile> files = new ArrayList<>();

		for (NeoForgeModFile file : modFiles) {
			ModFile parent = file.parent() == null ? null : byPath.get(file.parent());
			ModFile modFile = new ModFile(file, parent);
			byPath.put(file.path(), modFile);
			files.add(modFile);
		}

		LoadingModList.steelwool$set(files);
		modInfos.clear();

		for (ModFile file : files) {
			for (IModInfo info : file.getModInfos()) {
				modInfos.put(info.getModId(), (ModInfo) info);
			}
		}
	}

	private int modIdCount() {
		return modFiles.stream().mapToInt(f -> f.modsToml().mods().size()).sum();
	}

	/** Checks for duplicate mod ids and missing required / present incompatible dependencies. */
	static void validate(List<NeoForgeModFile> files) {
		validate(files, FabricLoader.getInstance()::isModLoaded);
	}

	static void validate(List<NeoForgeModFile> files, java.util.function.Predicate<String> isFabricModLoaded) {
		Map<String, Path> seen = new HashMap<>();
		List<String> problems = new ArrayList<>();

		for (NeoForgeModFile file : files) {
			for (NeoForgeModMetadata mod : file.modsToml().mods()) {
				Path previous = seen.putIfAbsent(mod.modId(), file.path());

				if (previous != null) {
					problems.add("Mod id '" + mod.modId() + "' is provided by both " + previous.getFileName() + " and " + file.fileName());
				}
			}
		}

		for (NeoForgeModFile file : files) {
			for (NeoForgeModMetadata mod : file.modsToml().mods()) {
				for (NeoForgeModMetadata.Dependency dep : mod.dependencies()) {
					boolean present = PROVIDED_MOD_IDS.contains(dep.modId()) || seen.containsKey(dep.modId()) || isFabricModLoaded.test(dep.modId());

					if (dep.isRequired() && !present && appliesToThisSide(dep)) {
						problems.add("Mod '" + mod.modId() + "' requires '" + dep.modId() + "' " + dep.versionRange() + ", which is not installed");
					} else if (dep.isIncompatible() && present && !PROVIDED_MOD_IDS.contains(dep.modId())) {
						problems.add("Mod '" + mod.modId() + "' is incompatible with '" + dep.modId() + "', which is installed");
					}
				}
			}
		}

		if (!problems.isEmpty()) {
			throw new ModLoadingFailure("SteelWool cannot load the NeoForge mods:\n - " + String.join("\n - ", problems), null);
		}
	}

	private static boolean appliesToThisSide(NeoForgeModMetadata.Dependency dep) {
		return switch (dep.side()) {
			case "CLIENT" -> safeDist() == Dist.CLIENT;
			case "SERVER" -> safeDist() == Dist.DEDICATED_SERVER;
			default -> true;
		};
	}

	private static Dist safeDist() {
		try {
			return FMLEnvironment.getDist();
		} catch (RuntimeException e) {
			return Dist.DEDICATED_SERVER;
		}
	}

	// ---- Phase 2: main entrypoint ----

	public void constructAndRegister() {
		Dist dist = FMLEnvironment.getDist();
		ClassLoader classLoader = FabricLauncherBase.getLauncher().getTargetClassLoader();

		for (NeoForgeModFile file : modFiles) {
			for (NeoForgeModMetadata mod : file.modsToml().mods()) {
				List<String> entrypoints = file.scan().modClasses().stream()
						.filter(c -> c.modId().equals(mod.modId()) && c.dists().contains(dist.name()))
						.map(AnnotationScanResult.ModClass::className)
						.toList();
				List<AnnotationScanResult.SubscriberClass> subscribers = file.scan().subscriberClasses().stream()
						.filter(s -> mod.modId().equals(subscriberModId(file, s)))
						.toList();

				FMLModContainer container = new FMLModContainer(modInfos.get(mod.modId()), entrypoints, subscribers, classLoader, dist);
				containers.add(container);
				ModList.get().steelwool$add(container);
			}
		}

		for (FMLModContainer container : containers) {
			container.construct();
		}

		// NeoForge.EVENT_BUS is created shut down; NeoForge starts it once mods are constructed.
		NeoForge.EVENT_BUS.start();

		dispatchLifecycle("construct", FMLConstructModEvent::new);
		SteelWoolConfigs.loadAll();
		fireRegisterEvents();
		dispatchLifecycle("common setup", FMLCommonSetupEvent::new);
		postToAllModBuses(new RegisterPayloadHandlersEvent());

		if (!containers.isEmpty()) {
			LOGGER.info("Constructed and registered {} NeoForge mod(s)", containers.size());
		}
	}

	/** Same rule as FML: explicit {@code modid}, else the {@code @Mod} of the same class, else the jar's first mod. */
	private static String subscriberModId(NeoForgeModFile file, AnnotationScanResult.SubscriberClass subscriber) {
		if (subscriber.modId() != null) {
			return subscriber.modId();
		}

		return file.scan().modClasses().stream()
				.filter(c -> c.className().equals(subscriber.className()))
				.map(AnnotationScanResult.ModClass::modId)
				.findFirst()
				.orElse(file.modsToml().mods().getFirst().modId());
	}

	/** Posts {@link RegisterEvent} for every registry, in NeoForge's order. */
	private void fireRegisterEvents() {
		for (Identifier registryName : registrationOrder()) {
			Registry<?> registry = BuiltInRegistries.REGISTRY.getValue(registryName);

			if (registry == null) {
				continue;
			}

			ResourceKey<? extends Registry<?>> key = ResourceKey.createRegistryKey(registryName);
			RegisterEvent event = new RegisterEvent(key, registry);

			for (FMLModContainer container : containers) {
				post(container, event);
			}
		}
	}

	/**
	 * NeoForge registers attributes, data components and particle types first (other entries
	 * depend on them at construction time), then everything else in vanilla's order.
	 */
	static Set<Identifier> registrationOrder() {
		Set<Identifier> ordered = new LinkedHashSet<>();
		ordered.add(Registries.ATTRIBUTE.identifier());
		ordered.add(Registries.DATA_COMPONENT_TYPE.identifier());
		ordered.add(Registries.PARTICLE_TYPE.identifier());

		for (Registry<?> registry : BuiltInRegistries.REGISTRY) {
			ordered.add(registry.key().identifier());
		}

		return ordered;
	}

	// ---- Phase 3: client / server entrypoint ----

	public void finishLoading(Dist dist) {
		if (dist == Dist.CLIENT) {
			dispatchLifecycle("client setup", FMLClientSetupEvent::new);
		} else {
			dispatchLifecycle("dedicated server setup", FMLDedicatedServerSetupEvent::new);
		}

		dispatchLifecycle("inter-mod enqueue", InterModEnqueueEvent::new);
		dispatchLifecycle("inter-mod process", InterModProcessEvent::new);
		dispatchLifecycle("load complete", FMLLoadCompleteEvent::new);
	}

	// ---- Event helpers ----

	private <T extends Event & IModBusEvent> void dispatchLifecycle(String name, BiFunction<ModContainer, DeferredWorkQueue, T> factory) {
		DeferredWorkQueue queue = new DeferredWorkQueue(name);

		for (FMLModContainer container : containers) {
			post(container, factory.apply(container, queue));
		}

		queue.runTasks();
	}

	/** Posts a mod-bus event to every NeoForge mod, in load order. */
	public <T extends Event & IModBusEvent> void postToAllModBuses(T event) {
		for (FMLModContainer container : containers) {
			post(container, event);
		}
	}

	private static <T extends Event & IModBusEvent> void post(FMLModContainer container, T event) {
		try {
			container.acceptEvent(event);
		} catch (ModLoadingFailure e) {
			throw e;
		} catch (Throwable t) {
			throw ModLoadingFailure.of(container.getModId(), "it threw an exception while handling " + event.getClass().getSimpleName(), t);
		}
	}
}
