package net.neoforged.neoforgespi.language;

import java.util.List;
import java.util.Optional;

/**
 * SteelWool re-implementation of FML's {@code IConfigurable}: read access to a TOML table of
 * {@code neoforge.mods.toml}, by key path.
 */
public interface IConfigurable {
	<T> Optional<T> getConfigElement(String... key);

	List<? extends IConfigurable> getConfigList(String... key);
}
