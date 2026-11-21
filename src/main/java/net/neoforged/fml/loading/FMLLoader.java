package net.neoforged.fml.loading;

import java.nio.file.Path;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.impl.launch.FabricLauncherBase;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.IBindingsProvider;
import net.neoforged.neoforge.common.NeoForge;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool subset of FML's {@code FMLLoader}, backed by Fabric Loader. There is always a current
 * loader under SteelWool, so {@link #getCurrentOrNull()} never returns {@code null}.
 *
 * <p>Not supported: the class transformer audit log, {@code getModFileByClass}, {@code getProgramArgs},
 * {@code getGameLayer} and {@code getVersionInfo}.
 */
public final class FMLLoader implements AutoCloseable {
	private static final FMLLoader CURRENT = new FMLLoader();
	private static final IBindingsProvider BINDINGS = () -> NeoForge.EVENT_BUS;

	private FMLLoader() {
	}

	public static FMLLoader getCurrent() {
		return CURRENT;
	}

	public static @Nullable FMLLoader getCurrentOrNull() {
		return CURRENT;
	}

	public Dist getDist() {
		return FMLEnvironment.getDist();
	}

	public LoadingModList getLoadingModList() {
		return LoadingModList.get();
	}

	public Path getGameDir() {
		return FabricLoader.getInstance().getGameDir();
	}

	public boolean isProduction() {
		return FMLEnvironment.isProduction();
	}

	public IBindingsProvider getBindings() {
		return BINDINGS;
	}

	public ClassLoader getCurrentClassLoader() {
		return FabricLauncherBase.getLauncher().getTargetClassLoader();
	}

	public void addCloseCallback(AutoCloseable callback) {
	}

	@Override
	public void close() {
	}
}
