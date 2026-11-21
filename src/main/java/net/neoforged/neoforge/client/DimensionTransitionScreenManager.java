package net.neoforged.neoforge.client;

import java.util.Map;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.gui.screens.LevelLoadingScreen;
import net.minecraft.client.multiplayer.LevelLoadTracker;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

/**
 * SteelWool re-implementation of NeoForge's {@code DimensionTransitionScreenManager}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DimensionTransitionScreenManager {
	private static final Map<Pair<ResourceKey<Level>, ResourceKey<Level>>, net.neoforged.neoforge.client.DimensionTransitionScreenManager.ReceivingLevelScreenFactory> conditionalDimensionEffects = null /* SteelWool: TODO */;
	private static final Map<ResourceKey<Level>, net.neoforged.neoforge.client.DimensionTransitionScreenManager.ReceivingLevelScreenFactory> toDimensionTransitions = null /* SteelWool: TODO */;
	private static final Map<ResourceKey<Level>, net.neoforged.neoforge.client.DimensionTransitionScreenManager.ReceivingLevelScreenFactory> fromDimensionTransitions = null /* SteelWool: TODO */;

	public DimensionTransitionScreenManager() {
		super();
	}

	static void init() {
		throw new UnsupportedOperationException("SteelWool does not implement DimensionTransitionScreenManager.init yet");
	}

	public static net.neoforged.neoforge.client.DimensionTransitionScreenManager.ReceivingLevelScreenFactory getScreenFromLevel(Level arg0, Level arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DimensionTransitionScreenManager.getScreenFromLevel yet");
	}

	public static net.neoforged.neoforge.client.DimensionTransitionScreenManager.ReceivingLevelScreenFactory getScreen(ResourceKey<Level> arg0, ResourceKey<Level> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DimensionTransitionScreenManager.getScreen yet");
	}

	public interface ReceivingLevelScreenFactory {
		LevelLoadingScreen create(LevelLoadTracker arg0, LevelLoadingScreen.Reason arg1);
	}
}
