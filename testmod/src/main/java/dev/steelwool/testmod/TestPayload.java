package dev.steelwool.testmod;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

/**
 * A bidirectional play payload, registered the way NeoForge's networking docs show.
 */
public record TestPayload(String message) implements CustomPacketPayload {
	public static final Type<TestPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(TestMod.MODID, "test_payload"));
	public static final StreamCodec<ByteBuf, TestPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, TestPayload::message, TestPayload::new);

	@Override
	public Type<TestPayload> type() {
		return TYPE;
	}

	static void register(RegisterPayloadHandlersEvent event) {
		PayloadRegistrar registrar = event.registrar("1");
		registrar.playBidirectional(TYPE, STREAM_CODEC,
				(payload, context) -> context.reply(new TestPayload("server got " + payload.message())),
				(payload, context) -> TestMod.LOGGER.info("Client got {}", payload.message()));
		TestModState.payloadsRegistered = true;
	}
}
