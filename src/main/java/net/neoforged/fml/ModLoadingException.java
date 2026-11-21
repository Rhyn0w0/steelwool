package net.neoforged.fml;

import java.util.List;

/**
 * SteelWool re-implementation of NeoForge's {@code ModLoadingException}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ModLoadingException extends RuntimeException {
	private final List<ModLoadingIssue> issues;

	public ModLoadingException(ModLoadingIssue arg0) {
		this((List) null);
		throw new UnsupportedOperationException("SteelWool does not implement the ModLoadingException constructor yet");
	}

	public ModLoadingException(List<ModLoadingIssue> arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ModLoadingException constructor yet");
	}

	public List<ModLoadingIssue> getIssues() {
		return this.issues;
	}

	public String getMessage() {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoadingException.getMessage yet");
	}

	private void appendIssue(ModLoadingIssue arg0, StringBuilder arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoadingException.appendIssue yet");
	}
}
