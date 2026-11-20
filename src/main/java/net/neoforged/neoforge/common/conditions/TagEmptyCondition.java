package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;

/** Passes when the tag is empty or not loaded. The registry defaults to items. */
public record TagEmptyCondition<T>(TagKey<T> tag) implements ICondition {
	public static final MapCodec<TagEmptyCondition<?>> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			Identifier.CODEC.optionalFieldOf("registry", Registries.ITEM.identifier()).forGetter(condition -> condition.tag().registry().identifier()),
			Identifier.CODEC.fieldOf("tag").forGetter(condition -> condition.tag().location()))
			.apply(instance, TagEmptyCondition::new));

	private TagEmptyCondition(Identifier registry, Identifier tag) {
		this(TagKey.create(ResourceKey.createRegistryKey(registry), tag));
	}

	@Override
	public boolean test(IContext context) {
		return !context.isTagLoaded(tag) || context.getTag(tag).isEmpty();
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}
