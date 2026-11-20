package net.neoforged.fml;

import java.nio.file.Path;
import java.util.List;

import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.locating.IModFile;

/**
 * SteelWool re-implementation of NeoForge's {@code ModLoadingIssue}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ModLoadingIssue(net.neoforged.fml.ModLoadingIssue.Severity severity, String translationKey, List<Object> translationArgs, Throwable cause, Path affectedPath, IModFile affectedModFile, IModInfo affectedMod) {
	public ModLoadingIssue(net.neoforged.fml.ModLoadingIssue.Severity arg0, String arg1, List<Object> arg2) {
		this(arg0, arg1, arg2, null, null, null, null);
	}

	public static net.neoforged.fml.ModLoadingIssue error(String arg0, Object... arg1) {
		return new ModLoadingIssue(Severity.ERROR, arg0, java.util.Arrays.asList(arg1));
	}

	public static net.neoforged.fml.ModLoadingIssue warning(String arg0, Object... arg1) {
		return new ModLoadingIssue(Severity.WARNING, arg0, java.util.Arrays.asList(arg1));
	}

	public net.neoforged.fml.ModLoadingIssue withAffectedPath(Path arg0) {
		return new ModLoadingIssue(severity, translationKey, translationArgs, cause, arg0, affectedModFile, affectedMod);
	}

	public net.neoforged.fml.ModLoadingIssue withAffectedModFile(IModFile arg0) {
		return new ModLoadingIssue(severity, translationKey, translationArgs, cause, affectedPath, arg0, affectedMod);
	}

	public net.neoforged.fml.ModLoadingIssue withAffectedMod(IModInfo arg0) {
		return new ModLoadingIssue(severity, translationKey, translationArgs, cause, affectedPath, affectedModFile, arg0);
	}

	public net.neoforged.fml.ModLoadingIssue withCause(Throwable arg0) {
		return new ModLoadingIssue(severity, translationKey, translationArgs, arg0, affectedPath, affectedModFile, affectedMod);
	}

	public net.neoforged.fml.ModLoadingIssue withSeverity(net.neoforged.fml.ModLoadingIssue.Severity arg0) {
		return new ModLoadingIssue(arg0, translationKey, translationArgs, cause, affectedPath, affectedModFile, affectedMod);
	}

	public enum Severity {
		WARNING, ERROR;
	}
}
