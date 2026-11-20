package net.neoforged.neoforge.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.core.EnumGetMethod;
import com.electronwill.nightconfig.core.UnmodifiableCommentedConfig;
import com.electronwill.nightconfig.core.UnmodifiableConfig;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of NeoForge's {@code ModConfigSpec}: a typed config definition built
 * with {@link Builder}, backed by a TOML file.
 *
 * <p>Supported: booleans, ints, longs, doubles (with ranges), enums, arbitrary values with
 * validators, lists, value-in-list, comments, translation keys, sections ({@code push}/{@code pop}),
 * and reading/writing/correcting the file. Not yet supported: per-world {@code SYNCED} configs and
 * the in-game config screen.
 */
public class ModConfigSpec implements IConfigSpec {
	private final List<ConfigValue<?>> values;
	private final Map<List<String>, String> levelComments;
	private final Map<List<String>, String> levelTranslationKeys;
	private @Nullable ILoadedConfig loadedConfig;

	private ModConfigSpec(List<ConfigValue<?>> values, Map<List<String>, String> levelComments, Map<List<String>, String> levelTranslationKeys) {
		this.values = List.copyOf(values);
		this.levelComments = Map.copyOf(levelComments);
		this.levelTranslationKeys = Map.copyOf(levelTranslationKeys);
	}

	@Override
	public boolean isEmpty() {
		return values.isEmpty();
	}

	public @Nullable String getLevelComment(List<String> path) {
		return levelComments.get(path);
	}

	public @Nullable String getLevelTranslationKey(List<String> path) {
		return levelTranslationKeys.get(path);
	}

	@Override
	public void acceptConfig(@Nullable ILoadedConfig config) {
		this.loadedConfig = config;
		values.forEach(ConfigValue::clearCache);
	}

	@Override
	public void validateSpec(ModConfig config) {
	}

	public boolean isLoaded() {
		return loadedConfig != null;
	}

	public UnmodifiableConfig getValues() {
		if (loadedConfig == null) {
			throw new IllegalStateException("Config is not loaded yet");
		}

		return loadedConfig.config();
	}

	public void afterReload() {
		values.forEach(ConfigValue::clearCache);
	}

	public void save() {
		if (loadedConfig != null) {
			loadedConfig.save();
		}
	}

	@Override
	public boolean isCorrect(UnmodifiableCommentedConfig config) {
		for (ConfigValue<?> value : values) {
			Object raw = config.get(value.getPath());

			if (raw == null || !value.getSpec().test(raw)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void correct(CommentedConfig config) {
		for (ConfigValue<?> value : values) {
			List<String> path = value.getPath();
			Object raw = config.get(path);

			if (raw == null || !value.getSpec().test(raw)) {
				Object corrected = value.getSpec().correct(raw);
				// TOML has no enum type; store enum constants by name.
				config.set(path, corrected instanceof Enum<?> e ? e.name() : corrected);
			}

			String comment = value.getSpec().getComment();

			if (comment != null && !comment.isEmpty()) {
				config.setComment(path, comment);
			}
		}

		levelComments.forEach((path, comment) -> {
			if (config.contains(path)) {
				config.setComment(path, comment);
			}
		});
	}

	public enum RestartType {
		NONE,
		WORLD,
		GAME
	}

	public static class Builder {
		private final List<ConfigValue<?>> values = new ArrayList<>();
		private final Map<List<String>, String> levelComments = new HashMap<>();
		private final Map<List<String>, String> levelTranslationKeys = new HashMap<>();
		private final List<String> currentPath = new ArrayList<>();
		private BuilderContext context = new BuilderContext();

		// ---- Generic values ----

		public <T> ConfigValue<T> define(String path, T defaultValue) {
			return define(split(path), defaultValue);
		}

		public <T> ConfigValue<T> define(List<String> path, T defaultValue) {
			return define(path, defaultValue, o -> o != null && defaultValue.getClass().isAssignableFrom(o.getClass()));
		}

		public <T> ConfigValue<T> define(String path, T defaultValue, Predicate<Object> validator) {
			return define(split(path), defaultValue, validator);
		}

		public <T> ConfigValue<T> define(List<String> path, T defaultValue, Predicate<Object> validator) {
			Objects.requireNonNull(defaultValue, "Default value can not be null");
			return define(path, () -> defaultValue, validator);
		}

		public <T> ConfigValue<T> define(String path, Supplier<T> defaultSupplier, Predicate<Object> validator) {
			return define(split(path), defaultSupplier, validator);
		}

		public <T> ConfigValue<T> define(List<String> path, Supplier<T> defaultSupplier, Predicate<Object> validator) {
			return define(path, defaultSupplier, validator, Object.class);
		}

		public <T> ConfigValue<T> define(List<String> path, Supplier<T> defaultSupplier, Predicate<Object> validator, Class<?> clazz) {
			context.clazz = clazz;
			return define(path, new ValueSpec(defaultSupplier, validator, context), defaultSupplier);
		}

		public <T> ConfigValue<T> define(List<String> path, ValueSpec value, Supplier<T> defaultSupplier) {
			return add(new ConfigValue<>(this, fullPath(path), defaultSupplier, value));
		}

		// ---- Ranges ----

		public <V extends Comparable<? super V>> ConfigValue<V> defineInRange(String path, V defaultValue, V min, V max, Class<V> clazz) {
			return defineInRange(split(path), defaultValue, min, max, clazz);
		}

		public <V extends Comparable<? super V>> ConfigValue<V> defineInRange(List<String> path, V defaultValue, V min, V max, Class<V> clazz) {
			return defineInRange(path, (Supplier<V>) () -> defaultValue, min, max, clazz);
		}

		public <V extends Comparable<? super V>> ConfigValue<V> defineInRange(String path, Supplier<V> defaultSupplier, V min, V max, Class<V> clazz) {
			return defineInRange(split(path), defaultSupplier, min, max, clazz);
		}

		public <V extends Comparable<? super V>> ConfigValue<V> defineInRange(List<String> path, Supplier<V> defaultSupplier, V min, V max, Class<V> clazz) {
			Range<V> range = new Range<>(clazz, min, max);
			context.range = range;
			context.clazz = clazz;
			return define(path, new ValueSpec(defaultSupplier, range, context), defaultSupplier);
		}

		public IntValue defineInRange(String path, int defaultValue, int min, int max) {
			return defineInRange(split(path), defaultValue, min, max);
		}

		public IntValue defineInRange(List<String> path, int defaultValue, int min, int max) {
			return defineInRange(path, (Supplier<Integer>) () -> defaultValue, min, max);
		}

		public IntValue defineInRange(String path, Supplier<Integer> defaultSupplier, int min, int max) {
			return defineInRange(split(path), defaultSupplier, min, max);
		}

		public IntValue defineInRange(List<String> path, Supplier<Integer> defaultSupplier, int min, int max) {
			Range<Integer> range = new Range<>(Integer.class, min, max);
			context.range = range;
			context.clazz = Integer.class;
			return add(new IntValue(this, fullPath(path), defaultSupplier, new ValueSpec(defaultSupplier, range, context)));
		}

		public LongValue defineInRange(String path, long defaultValue, long min, long max) {
			return defineInRange(split(path), defaultValue, min, max);
		}

		public LongValue defineInRange(List<String> path, long defaultValue, long min, long max) {
			return defineInRange(path, (Supplier<Long>) () -> defaultValue, min, max);
		}

		public LongValue defineInRange(String path, Supplier<Long> defaultSupplier, long min, long max) {
			return defineInRange(split(path), defaultSupplier, min, max);
		}

		public LongValue defineInRange(List<String> path, Supplier<Long> defaultSupplier, long min, long max) {
			Range<Long> range = new Range<>(Long.class, min, max);
			context.range = range;
			context.clazz = Long.class;
			return add(new LongValue(this, fullPath(path), defaultSupplier, new ValueSpec(defaultSupplier, range, context)));
		}

		public DoubleValue defineInRange(String path, double defaultValue, double min, double max) {
			return defineInRange(split(path), defaultValue, min, max);
		}

		public DoubleValue defineInRange(List<String> path, double defaultValue, double min, double max) {
			return defineInRange(path, (Supplier<Double>) () -> defaultValue, min, max);
		}

		public DoubleValue defineInRange(String path, Supplier<Double> defaultSupplier, double min, double max) {
			return defineInRange(split(path), defaultSupplier, min, max);
		}

		public DoubleValue defineInRange(List<String> path, Supplier<Double> defaultSupplier, double min, double max) {
			Range<Double> range = new Range<>(Double.class, min, max);
			context.range = range;
			context.clazz = Double.class;
			return add(new DoubleValue(this, fullPath(path), defaultSupplier, new ValueSpec(defaultSupplier, range, context)));
		}

		// ---- Booleans ----

		public BooleanValue define(String path, boolean defaultValue) {
			return define(split(path), defaultValue);
		}

		public BooleanValue define(List<String> path, boolean defaultValue) {
			return define(path, (Supplier<Boolean>) () -> defaultValue);
		}

		public BooleanValue define(String path, Supplier<Boolean> defaultSupplier) {
			return define(split(path), defaultSupplier);
		}

		public BooleanValue define(List<String> path, Supplier<Boolean> defaultSupplier) {
			context.clazz = Boolean.class;
			ValueSpec spec = new ValueSpec(defaultSupplier, o -> o instanceof Boolean
					|| o instanceof String s && ("true".equalsIgnoreCase(s) || "false".equalsIgnoreCase(s)), context);
			return add(new BooleanValue(this, fullPath(path), defaultSupplier, spec));
		}

		// ---- Value in list ----

		public <T> ConfigValue<T> defineInList(String path, T defaultValue, Collection<? extends T> acceptableValues) {
			return defineInList(split(path), defaultValue, acceptableValues);
		}

		public <T> ConfigValue<T> defineInList(String path, Supplier<T> defaultSupplier, Collection<? extends T> acceptableValues) {
			return defineInList(split(path), defaultSupplier, acceptableValues);
		}

		public <T> ConfigValue<T> defineInList(List<String> path, T defaultValue, Collection<? extends T> acceptableValues) {
			return defineInList(path, () -> defaultValue, acceptableValues);
		}

		public <T> ConfigValue<T> defineInList(List<String> path, Supplier<T> defaultSupplier, Collection<? extends T> acceptableValues) {
			return define(path, defaultSupplier, acceptableValues::contains);
		}

		// ---- Lists ----

		public <T> ConfigValue<List<? extends T>> defineList(String path, List<? extends T> defaultValue, Predicate<Object> elementValidator) {
			return defineList(split(path), () -> defaultValue, null, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineList(String path, List<? extends T> defaultValue, Supplier<T> newElementSupplier, Predicate<Object> elementValidator) {
			return defineList(split(path), () -> defaultValue, newElementSupplier, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineList(String path, Supplier<List<? extends T>> defaultSupplier, Predicate<Object> elementValidator) {
			return defineList(split(path), defaultSupplier, null, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineList(String path, Supplier<List<? extends T>> defaultSupplier, Supplier<T> newElementSupplier, Predicate<Object> elementValidator) {
			return defineList(split(path), defaultSupplier, newElementSupplier, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineList(List<String> path, List<? extends T> defaultValue, Predicate<Object> elementValidator) {
			return defineList(path, () -> defaultValue, null, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineList(List<String> path, List<? extends T> defaultValue, Supplier<T> newElementSupplier, Predicate<Object> elementValidator) {
			return defineList(path, () -> defaultValue, newElementSupplier, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineList(List<String> path, Supplier<List<? extends T>> defaultSupplier, Predicate<Object> elementValidator) {
			return defineList(path, defaultSupplier, null, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineList(List<String> path, Supplier<List<? extends T>> defaultSupplier, Supplier<T> newElementSupplier, Predicate<Object> elementValidator) {
			return defineList(path, defaultSupplier, newElementSupplier, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(String path, List<? extends T> defaultValue, Predicate<Object> elementValidator) {
			return defineList(split(path), () -> defaultValue, null, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(String path, List<? extends T> defaultValue, Supplier<T> newElementSupplier, Predicate<Object> elementValidator) {
			return defineList(split(path), () -> defaultValue, newElementSupplier, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(String path, Supplier<List<? extends T>> defaultSupplier, Predicate<Object> elementValidator) {
			return defineList(split(path), defaultSupplier, null, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(String path, Supplier<List<? extends T>> defaultSupplier, Supplier<T> newElementSupplier, Predicate<Object> elementValidator) {
			return defineList(split(path), defaultSupplier, newElementSupplier, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(List<String> path, List<? extends T> defaultValue, Predicate<Object> elementValidator) {
			return defineList(path, () -> defaultValue, null, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(List<String> path, List<? extends T> defaultValue, Supplier<T> newElementSupplier, Predicate<Object> elementValidator) {
			return defineList(path, () -> defaultValue, newElementSupplier, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(List<String> path, Supplier<List<? extends T>> defaultSupplier, Predicate<Object> elementValidator) {
			return defineList(path, defaultSupplier, null, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(List<String> path, Supplier<List<? extends T>> defaultSupplier, Supplier<T> newElementSupplier, Predicate<Object> elementValidator) {
			return defineList(path, defaultSupplier, newElementSupplier, elementValidator, null);
		}

		public <T> ConfigValue<List<? extends T>> defineList(List<String> path, Supplier<List<? extends T>> defaultSupplier, @Nullable Supplier<T> newElementSupplier,
				Predicate<Object> elementValidator, @Nullable Range<Integer> sizeRange) {
			context.clazz = List.class;
			ListValueSpec spec = new ListValueSpec(defaultSupplier, newElementSupplier, elementValidator, sizeRange, context);
			return define(path, spec, defaultSupplier);
		}

		// ---- Enums ----

		public <V extends Enum<V>> EnumValue<V> defineEnum(String path, V defaultValue) {
			return defineEnum(split(path), defaultValue, EnumGetMethod.NAME_IGNORECASE);
		}

		public <V extends Enum<V>> EnumValue<V> defineEnum(String path, V defaultValue, EnumGetMethod converter) {
			return defineEnum(split(path), defaultValue, converter);
		}

		public <V extends Enum<V>> EnumValue<V> defineEnum(List<String> path, V defaultValue) {
			return defineEnum(path, defaultValue, EnumGetMethod.NAME_IGNORECASE);
		}

		public <V extends Enum<V>> EnumValue<V> defineEnum(List<String> path, V defaultValue, EnumGetMethod converter) {
			return defineEnum(path, defaultValue, converter, Arrays.asList(defaultValue.getDeclaringClass().getEnumConstants()));
		}

		@SafeVarargs
		public final <V extends Enum<V>> EnumValue<V> defineEnum(String path, V defaultValue, V... acceptableValues) {
			return defineEnum(split(path), defaultValue, EnumGetMethod.NAME_IGNORECASE, Arrays.asList(acceptableValues));
		}

		public <V extends Enum<V>> EnumValue<V> defineEnum(String path, V defaultValue, Collection<V> acceptableValues) {
			return defineEnum(split(path), defaultValue, EnumGetMethod.NAME_IGNORECASE, acceptableValues);
		}

		public <V extends Enum<V>> EnumValue<V> defineEnum(List<String> path, V defaultValue, Collection<V> acceptableValues) {
			return defineEnum(path, defaultValue, EnumGetMethod.NAME_IGNORECASE, acceptableValues);
		}

		public <V extends Enum<V>> EnumValue<V> defineEnum(List<String> path, V defaultValue, EnumGetMethod converter, Collection<V> acceptableValues) {
			Class<V> clazz = defaultValue.getDeclaringClass();
			return defineEnum(path, () -> defaultValue, converter, o -> o != null && converter.validate(o, clazz)
					&& acceptableValues.contains(converter.get(o, clazz)), clazz);
		}

		public <V extends Enum<V>> EnumValue<V> defineEnum(String path, V defaultValue, Predicate<Object> validator) {
			return defineEnum(split(path), () -> defaultValue, EnumGetMethod.NAME_IGNORECASE, validator, defaultValue.getDeclaringClass());
		}

		public <V extends Enum<V>> EnumValue<V> defineEnum(List<String> path, Supplier<V> defaultSupplier, EnumGetMethod converter, Predicate<Object> validator, Class<V> clazz) {
			context.clazz = clazz;
			ValueSpec spec = new ValueSpec(defaultSupplier, validator, context);
			return add(new EnumValue<>(this, fullPath(path), defaultSupplier, spec, converter, clazz));
		}

		// ---- Comments, sections ----

		public Builder comment(String comment) {
			context.comments.add(comment);
			return this;
		}

		public Builder comment(String... comment) {
			context.comments.addAll(Arrays.asList(comment));
			return this;
		}

		public Builder translation(String translationKey) {
			context.translationKey = translationKey;
			return this;
		}

		public Builder worldRestart() {
			context.restartType = RestartType.WORLD;
			return this;
		}

		public Builder gameRestart() {
			context.restartType = RestartType.GAME;
			return this;
		}

		public Builder push(String path) {
			return push(split(path));
		}

		public Builder push(List<String> path) {
			currentPath.addAll(path);

			if (!context.comments.isEmpty()) {
				levelComments.put(List.copyOf(currentPath), String.join("\n", context.comments));
			}

			if (context.translationKey != null) {
				levelTranslationKeys.put(List.copyOf(currentPath), context.translationKey);
			}

			context = new BuilderContext();
			return this;
		}

		public Builder pop() {
			return pop(1);
		}

		public Builder pop(int count) {
			if (count > currentPath.size()) {
				throw new IllegalArgumentException("Attempted to pop " + count + " levels when only " + currentPath.size() + " exist");
			}

			for (int i = 0; i < count; i++) {
				currentPath.removeLast();
			}

			return this;
		}

		public <T> Pair<T, ModConfigSpec> configure(Function<Builder, T> consumer) {
			T result = consumer.apply(this);
			return Pair.of(result, build());
		}

		public ModConfigSpec build() {
			ModConfigSpec spec = new ModConfigSpec(values, levelComments, levelTranslationKeys);
			values.forEach(value -> value.spec = spec);
			return spec;
		}

		private <V extends ConfigValue<?>> V add(V value) {
			values.add(value);
			context = new BuilderContext();
			return value;
		}

		private List<String> fullPath(List<String> path) {
			List<String> full = new ArrayList<>(currentPath);
			full.addAll(path);
			return List.copyOf(full);
		}

		private static List<String> split(String path) {
			return List.of(path.split("\\."));
		}
	}

	/** Settings collected by the builder for the next value. */
	private static final class BuilderContext {
		private final List<String> comments = new ArrayList<>();
		private @Nullable String translationKey;
		private @Nullable Range<?> range;
		private RestartType restartType = RestartType.NONE;
		private Class<?> clazz = Object.class;
	}

	public static class Range<V extends Comparable<? super V>> implements Predicate<Object> {
		private final Class<? extends V> clazz;
		private final V min;
		private final V max;

		private Range(Class<? extends V> clazz, V min, V max) {
			this.clazz = clazz;
			this.min = min;
			this.max = max;
		}

		public static Range<Integer> of(int min, int max) {
			return new Range<>(Integer.class, min, max);
		}

		public Class<? extends V> getClazz() {
			return clazz;
		}

		public V getMin() {
			return min;
		}

		public V getMax() {
			return max;
		}

		@Override
		public boolean test(Object t) {
			V value = convert(t);
			return value != null && min.compareTo(value) <= 0 && max.compareTo(value) >= 0;
		}

		public Object correct(@Nullable Object value, Object def) {
			V converted = convert(value);

			if (converted == null) {
				return def;
			}

			if (converted.compareTo(min) < 0) {
				return min;
			}

			return converted.compareTo(max) > 0 ? max : converted;
		}

		/** TOML integers may parse as Integer or Long; accept any number of the right magnitude. */
		@SuppressWarnings("unchecked")
		private @Nullable V convert(@Nullable Object value) {
			if (clazz.isInstance(value)) {
				return (V) value;
			}

			if (value instanceof Number n) {
				if (clazz == Integer.class && n.longValue() == n.intValue() && !(n instanceof Double || n instanceof Float)) {
					return (V) Integer.valueOf(n.intValue());
				}

				if (clazz == Long.class && !(n instanceof Double || n instanceof Float)) {
					return (V) Long.valueOf(n.longValue());
				}

				if (clazz == Double.class) {
					return (V) Double.valueOf(n.doubleValue());
				}
			}

			return null;
		}

		@Override
		public String toString() {
			return clazz == Integer.class && max.equals(Integer.MAX_VALUE) ? "> " + min
					: clazz == Integer.class && min.equals(Integer.MIN_VALUE) ? "< " + max
					: min + " ~ " + max;
		}
	}

	public static class ValueSpec {
		private final @Nullable String comment;
		private final @Nullable String translationKey;
		private final @Nullable Range<?> range;
		private final RestartType restartType;
		private final Class<?> clazz;
		private final Supplier<?> defaultSupplier;
		private final Predicate<Object> validator;

		private ValueSpec(Supplier<?> defaultSupplier, Predicate<Object> validator, BuilderContext context) {
			Objects.requireNonNull(defaultSupplier, "Default supplier can not be null");
			Objects.requireNonNull(validator, "Validator can not be null");
			this.comment = context.comments.isEmpty() ? null : String.join("\n", context.comments);
			this.translationKey = context.translationKey;
			this.range = context.range;
			this.restartType = context.restartType;
			this.clazz = context.clazz;
			this.defaultSupplier = defaultSupplier;
			this.validator = validator;
		}

		public @Nullable String getComment() {
			if (range == null) {
				return comment;
			}

			String rangeComment = "Range: " + range;
			return comment == null ? rangeComment : comment + "\n" + rangeComment;
		}

		public @Nullable String getTranslationKey() {
			return translationKey;
		}

		@SuppressWarnings("unchecked")
		public <V extends Comparable<? super V>> @Nullable Range<V> getRange() {
			return (Range<V>) range;
		}

		public RestartType restartType() {
			return restartType;
		}

		public Class<?> getClazz() {
			return clazz;
		}

		public boolean test(@Nullable Object value) {
			return validator.test(value);
		}

		public Object correct(@Nullable Object value) {
			return range == null ? getDefault() : range.correct(value, getDefault());
		}

		public Object getDefault() {
			return defaultSupplier.get();
		}
	}

	public static class ListValueSpec extends ValueSpec {
		private final @Nullable Supplier<?> newElementSupplier;
		private final Predicate<Object> elementValidator;
		private final @Nullable Range<Integer> sizeRange;

		private ListValueSpec(Supplier<?> defaultSupplier, @Nullable Supplier<?> newElementSupplier, Predicate<Object> elementValidator,
				@Nullable Range<Integer> sizeRange, BuilderContext context) {
			super(defaultSupplier, value -> isValidList(value, elementValidator, sizeRange), context);
			this.newElementSupplier = newElementSupplier;
			this.elementValidator = elementValidator;
			this.sizeRange = sizeRange;
		}

		private static boolean isValidList(@Nullable Object value, Predicate<Object> elementValidator, @Nullable Range<Integer> sizeRange) {
			if (!(value instanceof List<?> list)) {
				return false;
			}

			if (sizeRange != null && !sizeRange.test(list.size())) {
				return false;
			}

			for (Object element : list) {
				if (!elementValidator.test(element)) {
					return false;
				}
			}

			return true;
		}

		public @Nullable Supplier<?> getNewElementSupplier() {
			return newElementSupplier;
		}

		public boolean testElement(Object value) {
			return elementValidator.test(value);
		}

		public @Nullable Range<Integer> getSizeRange() {
			return sizeRange;
		}

		/** Drops invalid elements; falls back to the default if the result is still invalid. */
		@Override
		public Object correct(@Nullable Object value) {
			if (value instanceof List<?> list) {
				List<Object> filtered = new ArrayList<>();

				for (Object element : list) {
					if (elementValidator.test(element)) {
						filtered.add(element);
					}
				}

				if (test(filtered)) {
					return filtered;
				}
			}

			return getDefault();
		}
	}

	public static class ConfigValue<T> implements Supplier<T> {
		private final Builder parent;
		private final List<String> path;
		private final Supplier<T> defaultSupplier;
		private final ValueSpec valueSpec;
		private @Nullable ModConfigSpec spec;
		private @Nullable T cachedValue;

		ConfigValue(Builder parent, List<String> path, Supplier<T> defaultSupplier, ValueSpec valueSpec) {
			this.parent = parent;
			this.path = path;
			this.defaultSupplier = defaultSupplier;
			this.valueSpec = valueSpec;
		}

		public List<String> getPath() {
			return path;
		}

		/**
		 * The current value. Before the config file is loaded this returns the default value
		 * (NeoForge throws instead).
		 */
		@Override
		public T get() {
			if (spec == null || spec.loadedConfig == null) {
				return defaultSupplier.get();
			}

			if (cachedValue == null) {
				cachedValue = getRaw(spec.loadedConfig.config(), path, defaultSupplier);
			}

			return cachedValue;
		}

		public T getRaw() {
			if (spec == null || spec.loadedConfig == null) {
				return defaultSupplier.get();
			}

			return getRaw(spec.loadedConfig.config(), path, defaultSupplier);
		}

		public T getRaw(Config config, List<String> path, Supplier<T> defaultSupplier) {
			return config.getOrElse(path, defaultSupplier);
		}

		public T getDefault() {
			return defaultSupplier.get();
		}

		public Builder next() {
			return parent;
		}

		public void save() {
			if (spec == null || spec.loadedConfig == null) {
				throw new IllegalStateException("Cannot save config value before the config is loaded");
			}

			spec.loadedConfig.save();
		}

		public void set(T value) {
			if (spec == null || spec.loadedConfig == null) {
				throw new IllegalStateException("Cannot set config value before the config is loaded");
			}

			spec.loadedConfig.config().set(path, value);
			cachedValue = value;
		}

		public ValueSpec getSpec() {
			return valueSpec;
		}

		public void clearCache() {
			cachedValue = null;
		}
	}

	public static class BooleanValue extends ConfigValue<Boolean> implements BooleanSupplier {
		BooleanValue(Builder parent, List<String> path, Supplier<Boolean> defaultSupplier, ValueSpec spec) {
			super(parent, path, defaultSupplier, spec);
		}

		@Override
		public Boolean getRaw(Config config, List<String> path, Supplier<Boolean> defaultSupplier) {
			Object raw = config.get(path);

			if (raw instanceof Boolean b) {
				return b;
			}

			return raw instanceof String s ? Boolean.parseBoolean(s) : defaultSupplier.get();
		}

		@Override
		public boolean getAsBoolean() {
			return get();
		}

		public boolean isTrue() {
			return getAsBoolean();
		}

		public boolean isFalse() {
			return !getAsBoolean();
		}
	}

	public static class IntValue extends ConfigValue<Integer> implements IntSupplier {
		IntValue(Builder parent, List<String> path, Supplier<Integer> defaultSupplier, ValueSpec spec) {
			super(parent, path, defaultSupplier, spec);
		}

		@Override
		public Integer getRaw(Config config, List<String> path, Supplier<Integer> defaultSupplier) {
			return config.get(path) instanceof Number n ? n.intValue() : defaultSupplier.get();
		}

		@Override
		public int getAsInt() {
			return get();
		}
	}

	public static class LongValue extends ConfigValue<Long> implements LongSupplier {
		LongValue(Builder parent, List<String> path, Supplier<Long> defaultSupplier, ValueSpec spec) {
			super(parent, path, defaultSupplier, spec);
		}

		@Override
		public Long getRaw(Config config, List<String> path, Supplier<Long> defaultSupplier) {
			return config.get(path) instanceof Number n ? n.longValue() : defaultSupplier.get();
		}

		@Override
		public long getAsLong() {
			return get();
		}
	}

	public static class DoubleValue extends ConfigValue<Double> implements DoubleSupplier {
		DoubleValue(Builder parent, List<String> path, Supplier<Double> defaultSupplier, ValueSpec spec) {
			super(parent, path, defaultSupplier, spec);
		}

		@Override
		public Double getRaw(Config config, List<String> path, Supplier<Double> defaultSupplier) {
			return config.get(path) instanceof Number n ? n.doubleValue() : defaultSupplier.get();
		}

		@Override
		public double getAsDouble() {
			return get();
		}
	}

	public static class EnumValue<T extends Enum<T>> extends ConfigValue<T> {
		private final EnumGetMethod converter;
		private final Class<T> clazz;

		EnumValue(Builder parent, List<String> path, Supplier<T> defaultSupplier, ValueSpec spec, EnumGetMethod converter, Class<T> clazz) {
			super(parent, path, defaultSupplier, spec);
			this.converter = converter;
			this.clazz = clazz;
		}

		@Override
		public T getRaw(Config config, List<String> path, Supplier<T> defaultSupplier) {
			Object raw = config.get(path);

			if (raw == null || !converter.validate(raw, clazz)) {
				return defaultSupplier.get();
			}

			return converter.get(raw, clazz);
		}
	}
}
