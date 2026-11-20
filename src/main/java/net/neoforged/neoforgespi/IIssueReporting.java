package net.neoforged.neoforgespi;

import net.neoforged.fml.ModLoadingIssue;

/**
 * SteelWool re-implementation of NeoForge's {@code IIssueReporting}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IIssueReporting {
	void addIssue(ModLoadingIssue arg0);
}
