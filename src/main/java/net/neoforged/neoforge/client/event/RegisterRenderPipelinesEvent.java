package net.neoforged.neoforge.client.event;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import net.minecraft.client.renderer.oit.OitPipelineSet;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterRenderPipelinesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterRenderPipelinesEvent extends Event implements IModBusEvent {
	private final net.neoforged.neoforge.client.event.RegisterRenderPipelinesEvent.Registrar registrar;

	public RegisterRenderPipelinesEvent(net.neoforged.neoforge.client.event.RegisterRenderPipelinesEvent.Registrar registrar) {
		super();
		this.registrar = registrar;
	}

	public void registerPipeline(RenderPipeline arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderPipelinesEvent.registerPipeline yet");
	}

	public void registerOptionalPipeline(RenderPipeline arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderPipelinesEvent.registerOptionalPipeline yet");
	}

	public void registerOitPipelineSet(OitPipelineSet arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderPipelinesEvent.registerOitPipelineSet yet");
	}

	public interface Registrar {
		void register(RenderPipeline arg0, boolean arg1);
	}
}
