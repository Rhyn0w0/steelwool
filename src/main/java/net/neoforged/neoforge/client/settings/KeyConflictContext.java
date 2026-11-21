package net.neoforged.neoforge.client.settings;

import net.minecraft.client.Minecraft;

/** When a key mapping is used: always, only while a screen is open, or only while none is. */
public enum KeyConflictContext implements IKeyConflictContext {
	UNIVERSAL,
	GUI,
	IN_GAME;

	@Override
	public boolean isActive() {
		return switch (this) {
			case UNIVERSAL -> true;
			case GUI -> Minecraft.getInstance().gui.screen() != null;
			case IN_GAME -> Minecraft.getInstance().gui.screen() == null;
		};
	}

	@Override
	public boolean conflicts(IKeyConflictContext other) {
		return this == UNIVERSAL || this == other;
	}
}
