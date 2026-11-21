package net.neoforged.neoforge.client.model.standalone;

import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelDebugName;
import net.minecraft.client.resources.model.ResolvableModel;

/**
 * SteelWool re-implementation of NeoForge's {@code UnbakedStandaloneModel}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface UnbakedStandaloneModel<T extends Object> extends ResolvableModel {
	T bake(ModelBaker arg0, ModelDebugName arg1);
}
