package dev.steelwool.mixin.patch;

import dev.steelwool.registry.RegistryAliases;
import java.util.Map;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Registry aliases (see {@link RegistryAliases}): looking up a name that is not registered but is an
 * alias looks up the name it points to instead.
 */
@Mixin(MappedRegistry.class)
public abstract class MappedRegistryMixin<T> {
	@Shadow
	@Final
	private ResourceKey<? extends Registry<T>> key;

	@Shadow
	@Final
	private Map<Identifier, Holder.Reference<T>> byLocation;

	@ModifyVariable(method = {
			"get(Lnet/minecraft/resources/Identifier;)Ljava/util/Optional;",
			"getValue(Lnet/minecraft/resources/Identifier;)Ljava/lang/Object;",
			"containsKey(Lnet/minecraft/resources/Identifier;)Z"}, at = @At("HEAD"), argsOnly = true)
	private Identifier steelwool$resolveAlias(Identifier name) {
		if (name == null || byLocation.containsKey(name) || !RegistryAliases.hasAliases(key)) {
			return name;
		}
		return RegistryAliases.resolve(key, name);
	}

	@ModifyVariable(method = {
			"get(Lnet/minecraft/resources/ResourceKey;)Ljava/util/Optional;",
			"getValue(Lnet/minecraft/resources/ResourceKey;)Ljava/lang/Object;",
			"containsKey(Lnet/minecraft/resources/ResourceKey;)Z"}, at = @At("HEAD"), argsOnly = true)
	private ResourceKey<T> steelwool$resolveAlias(ResourceKey<T> entry) {
		if (entry == null || byLocation.containsKey(entry.identifier()) || !RegistryAliases.hasAliases(key)) {
			return entry;
		}
		Identifier target = RegistryAliases.resolve(key, entry.identifier());
		return target.equals(entry.identifier()) ? entry : ResourceKey.create(entry.registryKey(), target);
	}
}
