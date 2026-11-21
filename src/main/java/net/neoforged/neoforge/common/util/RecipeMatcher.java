package net.neoforged.neoforge.common.util;

import java.util.BitSet;
import java.util.List;
import java.util.function.Predicate;

/**
 * SteelWool re-implementation of NeoForge's {@code RecipeMatcher}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RecipeMatcher {
	public RecipeMatcher() {
		super();
	}

	public static <T extends Object> int[] findMatches(List<T> arg0, List<? extends Predicate<T>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeMatcher.findMatches yet");
	}

	private static boolean claim(int[] arg0, BitSet arg1, int arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeMatcher.claim yet");
	}

	private static boolean backtrack(BitSet arg0, int[] arg1, int arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeMatcher.backtrack yet");
	}
}
