package net.neoforged.neoforge.client.extensions.common;

import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Vector3d;

/**
 * SteelWool re-implementation of NeoForge's {@code IClientBlockExtensions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IClientBlockExtensions {
	public static final net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions DEFAULT = null /* SteelWool: TODO */;

	static net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions of(BlockState arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientBlockExtensions.of yet");
	}

	static net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions of(Block arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientBlockExtensions.of yet");
	}

	default boolean addHitEffects(BlockState arg0, Level arg1, BlockPos arg2, Direction arg3, ParticleEngine arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientBlockExtensions.addHitEffects yet");
	}

	default boolean addDestroyEffects(BlockState arg0, Level arg1, BlockPos arg2, ParticleEngine arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientBlockExtensions.addDestroyEffects yet");
	}

	default boolean playHitSound(BlockState arg0, Level arg1, BlockPos arg2, Direction arg3, SoundManager arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientBlockExtensions.playHitSound yet");
	}

	default boolean playBreakSound(BlockState arg0, Level arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientBlockExtensions.playBreakSound yet");
	}

	default Vector3d getFogColor(BlockState arg0, LevelReader arg1, BlockPos arg2, Entity arg3, Vector3d arg4, float arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientBlockExtensions.getFogColor yet");
	}

	default void collectDynamicTintValues(BlockState arg0, BlockAndTintGetter arg1, BlockPos arg2, IntList arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientBlockExtensions.collectDynamicTintValues yet");
	}
}
