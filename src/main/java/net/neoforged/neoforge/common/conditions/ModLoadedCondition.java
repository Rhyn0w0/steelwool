package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.fml.ModList;

/** Passes when the mod {@code modid} is loaded (a NeoForge mod, or a Fabric mod). */
public record ModLoadedCondition(String modid) implements ICondition {
	public static MapCodec<ModLoadedCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			Codec.STRING.fieldOf("modid").forGetter(ModLoadedCondition::modid)).apply(instance, ModLoadedCondition::new));

	@Override
	public boolean test(IContext context) {
		return ModList.get().isLoaded(modid);
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}
