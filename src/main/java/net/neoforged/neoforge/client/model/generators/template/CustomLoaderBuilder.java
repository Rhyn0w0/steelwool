package net.neoforged.neoforge.client.model.generators.template;

import java.util.Map;
import java.util.function.Consumer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.Identifier;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomLoaderBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class CustomLoaderBuilder {
	private static final Identifier DUMMY = null /* SteelWool: TODO */;
	protected final Identifier loaderId;
	protected final Map<String, Boolean> visibility;
	protected final boolean allowInlineElements;
	private boolean optional;

	protected CustomLoaderBuilder(Identifier arg0, boolean arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the CustomLoaderBuilder constructor yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.CustomLoaderBuilder visibility(String arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomLoaderBuilder.visibility yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.CustomLoaderBuilder optional() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomLoaderBuilder.optional yet");
	}

	final net.neoforged.neoforge.client.model.generators.template.CustomLoaderBuilder copy() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomLoaderBuilder.copy yet");
	}

	protected abstract net.neoforged.neoforge.client.model.generators.template.CustomLoaderBuilder copyInternal();

	public JsonObject toJson(JsonObject arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomLoaderBuilder.toJson yet");
	}

	protected static void serializeNestedTemplate(ModelTemplate arg0, TextureMapping arg1, Consumer<JsonElement> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomLoaderBuilder.serializeNestedTemplate yet");
	}
}
