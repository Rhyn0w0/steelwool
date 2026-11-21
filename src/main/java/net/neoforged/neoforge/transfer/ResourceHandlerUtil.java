package net.neoforged.neoforge.transfer;

import java.util.function.Predicate;

import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.resource.ResourceStack;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code ResourceHandlerUtil}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ResourceHandlerUtil {
	private ResourceHandlerUtil() {
		super();
	}

	public static boolean isEmpty(Resource arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.isEmpty yet");
	}

	public static boolean isEmpty(ResourceHandler<? extends Resource> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.isEmpty yet");
	}

	public static <T extends Resource> boolean isFull(ResourceHandler<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.isFull yet");
	}

	public static <T extends Resource> boolean isValid(ResourceHandler<T> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.isValid yet");
	}

	public static <T extends Resource> int getRedstoneSignalFromResourceHandler(ResourceHandler<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.getRedstoneSignalFromResourceHandler yet");
	}

	public static <T extends Resource> int insertStacking(ResourceHandler<T> arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.insertStacking yet");
	}

	public static <T extends Resource> ResourceStack<T> extractFirst(ResourceHandler<T> arg0, Predicate<T> arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.extractFirst yet");
	}

	public static <T extends Resource> int move(ResourceHandler<T> arg0, ResourceHandler<T> arg1, Predicate<T> arg2, int arg3, TransactionContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.move yet");
	}

	public static <T extends Resource> int moveStacking(ResourceHandler<T> arg0, ResourceHandler<T> arg1, Predicate<T> arg2, int arg3, TransactionContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.moveStacking yet");
	}

	private static <T extends Resource> int moveInternal(ResourceHandler<T> arg0, ResourceHandler<T> arg1, Predicate<T> arg2, int arg3, boolean arg4, TransactionContext arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.moveInternal yet");
	}

	public static <T extends Resource> ResourceStack<T> moveFirst(ResourceHandler<T> arg0, ResourceHandler<T> arg1, Predicate<T> arg2, int arg3, TransactionContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.moveFirst yet");
	}

	public static <T extends Resource> ResourceStack<T> moveFirstStacking(ResourceHandler<T> arg0, ResourceHandler<T> arg1, Predicate<T> arg2, int arg3, TransactionContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.moveFirstStacking yet");
	}

	private static <T extends Resource> ResourceStack<T> moveFirstInternal(ResourceHandler<T> arg0, ResourceHandler<T> arg1, Predicate<T> arg2, int arg3, boolean arg4, TransactionContext arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.moveFirstInternal yet");
	}

	public static <T extends Resource> boolean contains(ResourceHandler<T> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.contains yet");
	}

	public static <T extends Resource> int indexOf(ResourceHandler<T> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.indexOf yet");
	}

	public static <T extends Resource> T findExtractableResource(ResourceHandler<T> arg0, Predicate<T> arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerUtil.findExtractableResource yet");
	}
}
