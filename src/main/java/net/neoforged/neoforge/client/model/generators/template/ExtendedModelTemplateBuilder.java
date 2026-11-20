package net.neoforged.neoforge.client.model.generators.template;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.neoforge.client.model.ExtraFaceData;

/**
 * SteelWool re-implementation of NeoForge's {@code ExtendedModelTemplateBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ExtendedModelTemplateBuilder {
	Optional<Identifier> parent;
	Optional<String> suffix;
	final Set<TextureSlot> requiredSlots;
	final Map<ItemDisplayContext, TransformVecBuilder> transforms;
	final List<ElementBuilder> elements;
	CustomLoaderBuilder customLoader;
	final RootTransformsBuilder rootTransforms;
	final Map<String, Boolean> partVisibilities;
	Boolean ambientOcclusion;
	UnbakedModel.GuiLight guiLight;
	final Map<String, ExtraFaceData> itemLayerFaceData;

	public ExtendedModelTemplateBuilder() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ExtendedModelTemplateBuilder constructor yet");
	}

	public static net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder of(ModelTemplate arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.of yet");
	}

	public static net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder builder() {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.builder yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder parent(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.parent yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder suffix(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.suffix yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder requiredTextureSlot(TextureSlot arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.requiredTextureSlot yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder transform(ItemDisplayContext arg0, Consumer<TransformVecBuilder> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.transform yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder ambientOcclusion(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.ambientOcclusion yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder guiLight(UnbakedModel.GuiLight arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.guiLight yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder element(Consumer<ElementBuilder> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.element yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder element(int arg0, Consumer<ElementBuilder> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.element yet");
	}

	public int getElementCount() {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.getElementCount yet");
	}

	public <L extends CustomLoaderBuilder> net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder customLoader(Supplier<L> arg0, Consumer<L> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.customLoader yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder rootTransforms(Consumer<RootTransformsBuilder> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.rootTransforms yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder itemLayerFaceData(String arg0, ExtraFaceData arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.itemLayerFaceData yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder partVisibilities(Map<String, Boolean> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.partVisibilities yet");
	}

	public net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder partVisibility(String arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.partVisibility yet");
	}

	public ExtendedModelTemplate build() {
		throw new UnsupportedOperationException("SteelWool does not implement ExtendedModelTemplateBuilder.build yet");
	}
}
