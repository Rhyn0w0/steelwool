package net.neoforged.fml.jarcontents;

import java.nio.file.attribute.FileTime;

/**
 * SteelWool re-implementation of NeoForge's {@code JarResourceAttributes}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record JarResourceAttributes(FileTime lastModified, long size) {
}
