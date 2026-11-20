package net.neoforged.fml;

import java.util.function.Supplier;

import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of FML's {@code ModLoadingContext}: tracks which mod is currently
 * being loaded.
 */
public class ModLoadingContext {
	private static final ThreadLocal<ModLoadingContext> CONTEXT = ThreadLocal.withInitial(ModLoadingContext::new);

	private @Nullable ModContainer activeContainer;

	public static ModLoadingContext get() {
		return CONTEXT.get();
	}

	public void setActiveContainer(@Nullable ModContainer container) {
		this.activeContainer = container;
	}

	public @Nullable ModContainer getActiveContainer() {
		return activeContainer;
	}

	public String getActiveNamespace() {
		return activeContainer == null ? "minecraft" : activeContainer.getNamespace();
	}

	public <T extends IExtensionPoint> void registerExtensionPoint(Class<T> point, Supplier<T> extension) {
		if (activeContainer == null) {
			throw new IllegalStateException("No mod is currently being loaded");
		}

		activeContainer.registerExtensionPoint(point, extension);
	}
}
