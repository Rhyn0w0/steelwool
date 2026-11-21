package net.neoforged.neoforge.client.event;

import java.io.File;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ScreenshotEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ScreenshotEvent extends Event implements ICancellableEvent {
	public static final Component DEFAULT_CANCEL_REASON = null /* SteelWool: TODO */;
	private final NativeImage image;
	private File screenshotFile;
	private Component resultMessage;

	public ScreenshotEvent(NativeImage image, File screenshotFile) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ScreenshotEvent constructor yet");
	}

	public NativeImage getImage() {
		return this.image;
	}

	public File getScreenshotFile() {
		return this.screenshotFile;
	}

	public void setScreenshotFile(File screenshotFile) {
		this.screenshotFile = screenshotFile;
	}

	public Component getResultMessage() {
		return this.resultMessage;
	}

	public void setResultMessage(Component resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Component getCancelMessage() {
		throw new UnsupportedOperationException("SteelWool does not implement ScreenshotEvent.getCancelMessage yet");
	}
}
