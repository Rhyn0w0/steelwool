package net.neoforged.neoforge.client.model.pipeline;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.renderpearl.api.vertex.VertexFormatElement;

/**
 * SteelWool re-implementation of NeoForge's {@code VertexConsumerWrapper}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class VertexConsumerWrapper implements VertexConsumer {
	protected final VertexConsumer parent;

	public VertexConsumerWrapper(VertexConsumer parent) {
		super();
		this.parent = parent;
	}

	public VertexConsumer addVertex(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.addVertex yet");
	}

	public VertexConsumer setColor(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.setColor yet");
	}

	public VertexConsumer setColor(int arg0, int arg1, int arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.setColor yet");
	}

	public VertexConsumer setUv(float arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.setUv yet");
	}

	public VertexConsumer setUv1(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.setUv1 yet");
	}

	public VertexConsumer setUv2(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.setUv2 yet");
	}

	public VertexConsumer setUv3(float arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.setUv3 yet");
	}

	public VertexConsumer setNormal(float arg0, float arg1, float arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.setNormal yet");
	}

	public VertexConsumer setLineWidth(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.setLineWidth yet");
	}

	public VertexConsumer misc(VertexFormatElement arg0, int... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VertexConsumerWrapper.misc yet");
	}
}
