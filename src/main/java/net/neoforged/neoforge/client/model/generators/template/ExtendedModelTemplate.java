package net.neoforged.neoforge.client.model.generators.template;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.neoforge.client.model.ExtraFaceData;
import org.joml.Vector3fc;

/**
 * SteelWool re-implementation of NeoForge's {@code ExtendedModelTemplate}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ExtendedModelTemplate extends ModelTemplate {
	final Map<ItemDisplayContext, TransformVecBuilder> transforms;
	final List<ElementBuilder> elements;
	final CustomLoaderBuilder customLoader;
	final RootTransformsBuilder rootTransforms;
	final Map<String, Boolean> partVisibilities;
	final Boolean ambientOcclusion;
	final UnbakedModel.GuiLight guiLight;
	final Map<String, ExtraFaceData> itemLayerFaceData;

	ExtendedModelTemplate(ExtendedModelTemplateBuilder arg0) {
		super((Optional) null, (Optional) null, (TextureSlot[]) null);
		throw new UnsupportedOperationException("SteelWool does not implement the ExtendedModelTemplate constructor yet");
	}

	public JsonObject createBaseTemplate(Identifier arg0, Map<TextureSlot, Material> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplate.createBaseTemplate yet");
	}

	private static String serializeLocOrKey(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplate.serializeLocOrKey yet");
	}

	private static JsonArray serializeVector3f(Vector3fc arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplate.serializeVector3f yet");
	}

	private static Number serializeFloat(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplate.serializeFloat yet");
	}
}
