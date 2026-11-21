package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

/** Passes when the registry entry exists. The registry defaults to items. */
public record RegisteredCondition<T>(ResourceKey<T> registryKey) implements ICondition {
	public static final MapCodec<RegisteredCondition<?>> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			Identifier.CODEC.optionalFieldOf("registry", Registries.ITEM.identifier()).forGetter(condition -> condition.registryKey().registry()),
			Identifier.CODEC.fieldOf("value").forGetter(condition -> condition.registryKey().identifier()))
			.apply(instance, RegisteredCondition::new));

	private RegisteredCondition(Identifier registry, Identifier value) {
		this(ResourceKey.create(ResourceKey.createRegistryKey(registry), value));
	}

	@Override
	public boolean test(IContext context) {
		return context.registries().lookup(ResourceKey.<T>createRegistryKey(registryKey.registry()))
				.flatMap(lookup -> lookup.get(registryKey))
				.isPresent();
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}
