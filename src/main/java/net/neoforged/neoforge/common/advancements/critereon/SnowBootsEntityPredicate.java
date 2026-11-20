package net.neoforged.neoforge.common.advancements.critereon;

import com.mojang.serialization.Codec;
import net.minecraft.advancements.predicates.entity.EntitySubPredicate;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/**
 * SteelWool re-implementation of NeoForge's {@code SnowBootsEntityPredicate}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class SnowBootsEntityPredicate implements EntitySubPredicate {
	public static final net.neoforged.neoforge.common.advancements.critereon.SnowBootsEntityPredicate INSTANCE = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.common.advancements.critereon.SnowBootsEntityPredicate> CODEC = null /* SteelWool: TODO */;

	private SnowBootsEntityPredicate() {
		super();
	}

	public boolean matches(Entity arg0, ServerLevel arg1, Vec3 arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement SnowBootsEntityPredicate.matches yet");
	}
}
