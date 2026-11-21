package net.neoforged.neoforge.common.world;

import net.minecraft.resources.Identifier;
import net.minecraft.world.attribute.AttributeType;

/** The environment attribute value types NeoForge registers. */
public final class NeoForgeAttributeTypes {
	/** An identifier value, not interpolated between biomes. */
	public static final AttributeType<Identifier> IDENTIFIER = AttributeType.ofNotInterpolated(Identifier.CODEC);

	private NeoForgeAttributeTypes() {
	}
}
