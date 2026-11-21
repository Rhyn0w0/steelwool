package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

/** Passes when {@code value} fails. */
public record NotCondition(ICondition value) implements ICondition {
	public static final MapCodec<NotCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			ICondition.CODEC.fieldOf("value").forGetter(NotCondition::value)).apply(instance, NotCondition::new));

	@Override
	public boolean test(IContext context) {
		return !value.test(context);
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}
