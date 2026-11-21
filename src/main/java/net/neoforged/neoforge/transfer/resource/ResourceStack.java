package net.neoforged.neoforge.transfer.resource;

/**
 * SteelWool re-implementation of NeoForge's {@code ResourceStack}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ResourceStack<T extends Resource>(T resource, int amount) {
	public boolean isEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceStack.isEmpty yet");
	}
}
