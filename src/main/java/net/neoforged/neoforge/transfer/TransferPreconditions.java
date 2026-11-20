package net.neoforged.neoforge.transfer;

import net.neoforged.neoforge.transfer.resource.Resource;

/**
 * SteelWool re-implementation of NeoForge's {@code TransferPreconditions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class TransferPreconditions {
	private TransferPreconditions() {
		super();
	}

	public static void checkNonEmpty(Resource arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TransferPreconditions.checkNonEmpty yet");
	}

	public static void checkNonNegative(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TransferPreconditions.checkNonNegative yet");
	}

	public static void checkNonEmptyNonNegative(Resource arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement TransferPreconditions.checkNonEmptyNonNegative yet");
	}
}
