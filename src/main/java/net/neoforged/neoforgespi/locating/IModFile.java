package net.neoforged.neoforgespi.locating;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import net.neoforged.fml.jarcontents.JarContents;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.language.ModFileScanData;

/**
 * SteelWool re-implementation of FML's {@code IModFile}: one NeoForge mod jar.
 *
 * <p>Not supported: the static {@code create(...)} factories, which only mod locators use.
 */
public interface IModFile {
	String getId();

	JarContents getContents();

	Supplier<Map<String, Object>> getSubstitutionMap();

	Type getType();

	Path getFilePath();

	List<IModInfo> getModInfos();

	ModFileScanData getScanResult();

	String getFileName();

	ModFileDiscoveryAttributes getDiscoveryAttributes();

	IModFileInfo getModFileInfo();

	enum Type {
		MOD, LIBRARY, GAMELIBRARY
	}
}
