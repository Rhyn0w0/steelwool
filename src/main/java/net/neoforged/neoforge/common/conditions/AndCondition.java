package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;

/** Passes when every child passes. */
public record AndCondition(List<ICondition> children) implements ICondition {
	public static final MapCodec<AndCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			LIST_CODEC.fieldOf("values").forGetter(AndCondition::children)).apply(instance, AndCondition::new));

	@Override
	public boolean test(IContext context) {
		return children.stream().allMatch(child -> child.test(context));
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}
