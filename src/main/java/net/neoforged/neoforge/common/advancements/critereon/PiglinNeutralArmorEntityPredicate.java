package net.neoforged.neoforge.common.advancements.critereon;

import com.mojang.serialization.Codec;
import net.minecraft.advancements.predicates.entity.EntitySubPredicate;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/**
 * SteelWool re-implementation of NeoForge's {@code PiglinNeutralArmorEntityPredicate}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PiglinNeutralArmorEntityPredicate implements EntitySubPredicate {
	public static final net.neoforged.neoforge.common.advancements.critereon.PiglinNeutralArmorEntityPredicate INSTANCE = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.common.advancements.critereon.PiglinNeutralArmorEntityPredicate> CODEC = null /* SteelWool: TODO */;

	private PiglinNeutralArmorEntityPredicate() {
		super();
	}

	public boolean matches(Entity arg0, ServerLevel arg1, Vec3 arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement PiglinNeutralArmorEntityPredicate.matches yet");
	}
}
