package net.neoforged.fml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * SteelWool re-implementation of FML's {@code InterModComms}: messages mods send each other during
 * {@code InterModEnqueueEvent} and read during {@code InterModProcessEvent}.
 */
public class InterModComms {
	private static final Map<String, ConcurrentLinkedQueue<IMCMessage>> CONTAINER_QUEUES = new ConcurrentHashMap<>();

	public InterModComms() {
	}

	public record IMCMessage(String senderModId, String modId, String method, Supplier<?> messageSupplier) {
	}

	public static boolean sendTo(String modId, String method, Supplier<?> thing) {
		ModContainer active = ModLoadingContext.get().getActiveContainer();
		return sendTo(active == null ? "minecraft" : active.getModId(), modId, method, thing);
	}

	public static boolean sendTo(String senderModId, String modId, String method, Supplier<?> thing) {
		if (!ModList.get().isLoaded(modId)) {
			return false;
		}

		CONTAINER_QUEUES.computeIfAbsent(modId, k -> new ConcurrentLinkedQueue<>()).add(new IMCMessage(senderModId, modId, method, thing));
		return true;
	}

	public static Stream<IMCMessage> getMessages(String modId, Predicate<String> methodMatcher) {
		ConcurrentLinkedQueue<IMCMessage> queue = CONTAINER_QUEUES.get(modId);

		if (queue == null) {
			return Stream.empty();
		}

		List<IMCMessage> taken = new ArrayList<>();

		for (IMCMessage message : queue) {
			if (methodMatcher.test(message.method()) && queue.remove(message)) {
				taken.add(message);
			}
		}

		return taken.stream();
	}

	public static Stream<IMCMessage> getMessages(String modId) {
		return getMessages(modId, s -> true);
	}
}
