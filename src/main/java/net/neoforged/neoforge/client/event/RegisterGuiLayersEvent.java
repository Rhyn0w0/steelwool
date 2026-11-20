package net.neoforged.neoforge.client.event;

import java.util.List;
import java.util.function.UnaryOperator;

import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.gui.GuiLayer;
import net.neoforged.neoforge.client.gui.GuiLayerManager;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterGuiLayersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterGuiLayersEvent extends Event implements IModBusEvent {
	private final List<GuiLayerManager.NamedLayer> layers;

	public RegisterGuiLayersEvent(List<GuiLayerManager.NamedLayer> layers) {
		super();
		this.layers = layers;
	}

	public void registerBelowAll(Identifier arg0, GuiLayer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGuiLayersEvent.registerBelowAll yet");
	}

	public void registerBelow(Identifier arg0, Identifier arg1, GuiLayer arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGuiLayersEvent.registerBelow yet");
	}

	public void registerAbove(Identifier arg0, Identifier arg1, GuiLayer arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGuiLayersEvent.registerAbove yet");
	}

	public void registerAboveAll(Identifier arg0, GuiLayer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGuiLayersEvent.registerAboveAll yet");
	}

	public void replaceLayer(Identifier arg0, GuiLayer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGuiLayersEvent.replaceLayer yet");
	}

	public void wrapLayer(Identifier arg0, UnaryOperator<GuiLayer> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGuiLayersEvent.wrapLayer yet");
	}

	private void register(net.neoforged.neoforge.client.event.RegisterGuiLayersEvent.Ordering arg0, Identifier arg1, Identifier arg2, GuiLayer arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGuiLayersEvent.register yet");
	}

	enum Ordering {
		BEFORE, AFTER;
	}
}
