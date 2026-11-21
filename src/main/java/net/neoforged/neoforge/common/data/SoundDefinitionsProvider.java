package net.neoforged.neoforge.common.data;

import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonObject;
import net.minecraft.core.Holder;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code SoundDefinitionsProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class SoundDefinitionsProvider implements DataProvider {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private final PackOutput output;
	private final String modId;
	private final Map<String, SoundDefinition> sounds;

	protected SoundDefinitionsProvider(PackOutput arg0, String arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the SoundDefinitionsProvider constructor yet");
	}

	public abstract void registerSounds();

	public CompletableFuture<?> run(CachedOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.run yet");
	}

	public String getName() {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.getName yet");
	}

	protected static SoundDefinition definition() {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.definition yet");
	}

	protected static SoundDefinition.Sound sound(Identifier arg0, SoundDefinition.SoundType arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.sound yet");
	}

	protected static SoundDefinition.Sound sound(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.sound yet");
	}

	protected static SoundDefinition.Sound sound(String arg0, SoundDefinition.SoundType arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.sound yet");
	}

	protected static SoundDefinition.Sound sound(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.sound yet");
	}

	protected void add(Holder<SoundEvent> arg0, SoundDefinition arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.add yet");
	}

	protected void add(SoundEvent arg0, SoundDefinition arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.add yet");
	}

	protected void add(Identifier arg0, SoundDefinition arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.add yet");
	}

	protected void add(String arg0, SoundDefinition arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.add yet");
	}

	private void addSounds(String arg0, SoundDefinition arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.addSounds yet");
	}

	private void validate() {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.validate yet");
	}

	private boolean validate(String arg0, SoundDefinition arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.validate yet");
	}

	private CompletableFuture<?> save(CachedOutput arg0, Path arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.save yet");
	}

	private JsonObject mapToJson(Map<String, SoundDefinition> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinitionsProvider.mapToJson yet");
	}
}
