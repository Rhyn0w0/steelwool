package net.neoforged.neoforge.client.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.mojang.serialization.Codec;

/**
 * SteelWool re-implementation of NeoForge's {@code ExtraFaceData}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ExtraFaceData(int color, int lightEmission, boolean ambientOcclusion) {
	public static final net.neoforged.neoforge.client.model.ExtraFaceData DEFAULT = null /* SteelWool: TODO */;
	public static final Codec<Integer> COLOR = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.client.model.ExtraFaceData> CODEC = null /* SteelWool: TODO */;

	public static net.neoforged.neoforge.client.model.ExtraFaceData read(JsonElement arg0, net.neoforged.neoforge.client.model.ExtraFaceData arg1) throws JsonParseException {
		throw new UnsupportedOperationException("SteelWool does not implement ExtraFaceData.read yet");
	}
}
