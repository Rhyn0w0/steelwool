package dev.steelwool.loading;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.neoforged.neoforgespi.language.IConfigurable;

/**
 * {@link IConfigurable} over a TOML table that was converted to nested maps and lists.
 */
public record MapConfigurable(Map<String, Object> table) implements IConfigurable {
	@Override
	@SuppressWarnings("unchecked")
	public <T> Optional<T> getConfigElement(String... key) {
		return Optional.ofNullable((T) lookup(key));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<? extends IConfigurable> getConfigList(String... key) {
		List<MapConfigurable> result = new ArrayList<>();

		if (lookup(key) instanceof List<?> list) {
			for (Object element : list) {
				if (element instanceof Map<?, ?> map) {
					result.add(new MapConfigurable((Map<String, Object>) map));
				}
			}
		}

		return result;
	}

	private Object lookup(String... key) {
		Object current = table;

		for (String part : key) {
			if (!(current instanceof Map<?, ?> map)) {
				return null;
			}

			current = map.get(part);
		}

		return current;
	}
}
