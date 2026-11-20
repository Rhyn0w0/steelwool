package net.neoforged.neoforge.client.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.client.resources.model.UnbakedModel;

/**
 * SteelWool re-implementation of NeoForge's {@code UnbakedModelLoader}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface UnbakedModelLoader<T extends UnbakedModel> {
	T read(JsonObject arg0, JsonDeserializationContext arg1) throws JsonParseException;
}
