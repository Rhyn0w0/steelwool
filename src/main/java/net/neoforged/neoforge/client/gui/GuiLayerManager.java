package net.neoforged.neoforge.client.gui;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;

/**
 * SteelWool re-implementation of NeoForge's {@code GuiLayerManager}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class GuiLayerManager {
	private final List<net.neoforged.neoforge.client.gui.GuiLayerManager.NamedLayer> layers;
	private boolean initialized;

	public GuiLayerManager() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the GuiLayerManager constructor yet");
	}

	public net.neoforged.neoforge.client.gui.GuiLayerManager add(Identifier arg0, GuiLayer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement GuiLayerManager.add yet");
	}

	public net.neoforged.neoforge.client.gui.GuiLayerManager add(Identifier arg0, Consumer<GuiGraphicsExtractor> arg1, BooleanSupplier arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement GuiLayerManager.add yet");
	}

	public net.neoforged.neoforge.client.gui.GuiLayerManager add(Identifier arg0, GuiLayer arg1, BooleanSupplier arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement GuiLayerManager.add yet");
	}

	public net.neoforged.neoforge.client.gui.GuiLayerManager add(net.neoforged.neoforge.client.gui.GuiLayerManager arg0, BooleanSupplier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement GuiLayerManager.add yet");
	}

	public void render(GuiGraphicsExtractor arg0, DeltaTracker arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement GuiLayerManager.render yet");
	}

	private void renderInner(GuiGraphicsExtractor arg0, DeltaTracker arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement GuiLayerManager.renderInner yet");
	}

	public void initModdedLayers() {
		throw new UnsupportedOperationException("SteelWool does not implement GuiLayerManager.initModdedLayers yet");
	}

	public int getLayerCount() {
		throw new UnsupportedOperationException("SteelWool does not implement GuiLayerManager.getLayerCount yet");
	}

	public static record NamedLayer(Identifier name, GuiLayer layer) {
	}
}
