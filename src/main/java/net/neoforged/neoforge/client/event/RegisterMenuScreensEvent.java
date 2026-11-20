package net.neoforged.neoforge.client.event;

import java.util.Map;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterMenuScreensEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterMenuScreensEvent extends Event implements IModBusEvent {
	private final Map<MenuType<?>, MenuScreens.ScreenConstructor<?, ?>> registeredScreens;

	public RegisterMenuScreensEvent(Map<MenuType<?>, MenuScreens.ScreenConstructor<?, ?>> registeredScreens) {
		super();
		this.registeredScreens = registeredScreens;
	}

	public <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void register(MenuType<? extends M> arg0, MenuScreens.ScreenConstructor<M, U> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterMenuScreensEvent.register yet");
	}
}
