package net.neoforged.fml.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.UnmodifiableCommentedConfig;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of FML's {@code IConfigSpec}: a config definition that can validate,
 * correct and hold a loaded config file.
 */
public interface IConfigSpec {
	boolean isEmpty();

	void validateSpec(ModConfig config);

	boolean isCorrect(UnmodifiableCommentedConfig config);

	void correct(CommentedConfig config);

	void acceptConfig(@Nullable ILoadedConfig config);

	/** A config file loaded from disk. */
	interface ILoadedConfig {
		CommentedConfig config();

		void save();
	}
}
