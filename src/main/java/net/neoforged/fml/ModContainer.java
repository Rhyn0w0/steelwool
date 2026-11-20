package net.neoforged.fml;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import dev.steelwool.config.SteelWoolConfigs;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforgespi.language.IModInfo;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SteelWool re-implementation of FML's {@code ModContainer}: the runtime handle for one NeoForge mod.
 */
public abstract class ModContainer {
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool/ModContainer");

	protected final String modId;
	protected final String namespace;
	protected final IModInfo modInfo;
	protected final Map<Class<? extends IExtensionPoint>, Supplier<?>> extensionPoints = new IdentityHashMap<>();

	public ModContainer(IModInfo info) {
		this.modId = info.getModId();
		this.namespace = this.modId;
		this.modInfo = info;
	}

	public final String getModId() {
		return modId;
	}

	public final String getNamespace() {
		return namespace;
	}

	public IModInfo getModInfo() {
		return modInfo;
	}

	@SuppressWarnings("unchecked")
	public <T extends IExtensionPoint> Optional<T> getCustomExtension(Class<T> point) {
		Supplier<?> supplier = extensionPoints.get(point);
		return supplier == null ? Optional.empty() : Optional.ofNullable((T) supplier.get());
	}

	public <T extends IExtensionPoint> void registerExtensionPoint(Class<T> point, T extension) {
		extensionPoints.put(point, () -> extension);
	}

	public <T extends IExtensionPoint> void registerExtensionPoint(Class<T> point, Supplier<T> extension) {
		extensionPoints.put(point, extension);
	}

	public void registerConfig(ModConfig.Type type, IConfigSpec configSpec) {
		registerConfig(type, configSpec, SteelWoolConfigs.defaultFileName(modId, type));
	}

	public void registerConfig(ModConfig.Type type, IConfigSpec configSpec, String fileName) {
		if (configSpec.isEmpty()) {
			LOGGER.debug("Ignoring empty {} config for mod {}", type, modId);
			return;
		}

		SteelWoolConfigs.register(new ModConfig(type, configSpec, this, fileName));
	}

	protected void constructMod() {
	}

	public abstract @Nullable IEventBus getEventBus();

	public final <T extends Event & IModBusEvent> void acceptEvent(T e) {
		IEventBus bus = getEventBus();

		if (bus != null) {
			bus.post(e);
		}
	}

	public final <T extends Event & IModBusEvent> void acceptEvent(EventPriority phase, T e) {
		IEventBus bus = getEventBus();

		if (bus != null) {
			bus.post(phase, e);
		}
	}
}
