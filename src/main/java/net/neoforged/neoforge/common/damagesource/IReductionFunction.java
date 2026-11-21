package net.neoforged.neoforge.common.damagesource;

/**
 * SteelWool re-implementation of NeoForge's {@code IReductionFunction}, with the same API.
 */
public interface IReductionFunction {
	float modify(DamageContainer arg0, float arg1);
}
