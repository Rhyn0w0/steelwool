package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;

/** Passes when any child passes. */
public record OrCondition(List<ICondition> values) implements ICondition {
	public static final MapCodec<OrCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			LIST_CODEC.fieldOf("values").forGetter(OrCondition::values)).apply(instance, OrCondition::new));

	@Override
	public boolean test(IContext context) {
		return values.stream().anyMatch(value -> value.test(context));
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}
