package net.neoforged.neoforge.client.settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.input.InputQuirks;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.Nullable;

/**
 * NeoForge's modifier keys for key mappings. {@link #CONTROL_OR_COMMAND} is the Command key on macOS
 * and Control elsewhere; {@link #CONTROL} is always Control.
 */
public enum KeyModifier {
	CONTROL("neoforge.controlsgui.control", InputConstants.KEY_LCONTROL, InputConstants.KEY_RCONTROL),
	CONTROL_OR_COMMAND("neoforge.controlsgui.control", InputConstants.KEY_LCONTROL, InputConstants.KEY_RCONTROL),
	SHIFT("neoforge.controlsgui.shift", InputConstants.KEY_LSHIFT, InputConstants.KEY_RSHIFT),
	ALT("neoforge.controlsgui.alt", InputConstants.KEY_LALT, InputConstants.KEY_RALT),
	NONE(null);

	public static final KeyModifier[] MODIFIER_VALUES = InputQuirks.ON_OSX
			? new KeyModifier[] { SHIFT, CONTROL_OR_COMMAND, CONTROL, ALT }
			: new KeyModifier[] { SHIFT, CONTROL, ALT };

	private final @Nullable String translationKey;
	private final int[] keyCodes;
	private final InputConstants.Key[] keys;

	KeyModifier(@Nullable String translationKey, int... keyCodes) {
		this.translationKey = translationKey;
		this.keyCodes = keyCodes;
		this.keys = Arrays.stream(keyCodes).mapToObj(InputConstants.Type.KEYBOARD::getOrCreate).toArray(InputConstants.Key[]::new);
	}

	public static List<KeyModifier> getActiveModifiers() {
		List<KeyModifier> active = new ArrayList<>();
		for (KeyModifier modifier : MODIFIER_VALUES) {
			if (modifier.isActive(null)) {
				active.add(modifier);
			}
		}
		return active;
	}

	public static KeyModifier getKeyModifier(InputConstants.Key key) {
		for (KeyModifier modifier : MODIFIER_VALUES) {
			if (modifier.matches(key)) {
				return modifier;
			}
		}
		return NONE;
	}

	public static boolean isKeyCodeModifier(InputConstants.Key key) {
		return getKeyModifier(key) != NONE;
	}

	public static KeyModifier valueFromString(String name) {
		for (KeyModifier modifier : values()) {
			if (modifier.name().equals(name)) {
				return modifier;
			}
		}
		return NONE;
	}

	/** Whether this modifier uses the Command key instead of Control (only on macOS). */
	private boolean usesCommand() {
		return this == CONTROL_OR_COMMAND && InputQuirks.REPLACE_CTRL_KEY_WITH_CMD_KEY;
	}

	public boolean matches(InputConstants.Key key) {
		int code = key.getValue();
		if (usesCommand()) {
			return code == InputConstants.KEY_LGUI || code == InputConstants.KEY_RGUI;
		}
		for (int keyCode : keyCodes) {
			if (keyCode == code) {
				return true;
			}
		}
		return false;
	}

	public boolean isActive(@Nullable IKeyConflictContext conflictContext) {
		Minecraft minecraft = Minecraft.getInstance();
		return switch (this) {
			case CONTROL -> minecraft.hasControlDown();
			case CONTROL_OR_COMMAND -> usesCommand()
					? InputConstants.isKeyDown(InputConstants.KEY_LGUI) || InputConstants.isKeyDown(InputConstants.KEY_RGUI)
					: minecraft.hasControlDown();
			case SHIFT -> minecraft.hasShiftDown();
			case ALT -> minecraft.hasAltDown();
			// No modifier is active when none of the others is held, except in contexts that never
			// overlap with in-game keys.
			case NONE -> conflictContext == null || conflictContext.conflicts(KeyConflictContext.IN_GAME)
					|| Arrays.stream(MODIFIER_VALUES).noneMatch(m -> m.isActive(conflictContext));
		};
	}

	public Component getCombinedName(InputConstants.Key key, Supplier<Component> defaultLogic) {
		if (translationKey == null) {
			return defaultLogic.get();
		}
		return Component.translatable(usesCommand() ? translationKey + ".mac" : translationKey, defaultLogic.get());
	}

	public InputConstants.Key[] codes() {
		if (usesCommand()) {
			return new InputConstants.Key[] {
					InputConstants.Type.KEYBOARD.getOrCreate(InputConstants.KEY_LGUI),
					InputConstants.Type.KEYBOARD.getOrCreate(InputConstants.KEY_RGUI) };
		}
		return keys;
	}
}
