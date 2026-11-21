package net.neoforged.neoforgespi.language;

import java.util.List;
import java.util.Map;

import net.neoforged.neoforgespi.locating.IModFile;

/**
 * SteelWool re-implementation of FML's {@code IModFileInfo}: a parsed {@code neoforge.mods.toml}.
 *
 * <p>Not supported: {@code requiredLanguageLoaders()}.
 */
public interface IModFileInfo {
	List<IModInfo> getMods();

	boolean showAsResourcePack();

	boolean showAsDataPack();

	Map<String, Object> getFileProperties();

	String getLicense();

	String versionString();

	List<String> usesServices();

	IModFile getFile();

	IConfigurable getConfig();
}
