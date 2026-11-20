package net.neoforged.neoforge.common;

/**
 * SteelWool re-implementation of NeoForge's {@code NeoForgeBuildType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public enum NeoForgeBuildType {
	STABLE, BETA, PULL_REQUEST;
}
