package dev.steelwool.mixin.patch;

import java.util.Map;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.commands.synchronization.ArgumentTypeInfos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Target for NeoForge's static {@code ArgumentTypeInfos.registerByClass(Class, ArgumentTypeInfo)},
 * which {@code SteelWoolMixinPlugin} adds, and access to the map it fills.
 */
@Mixin(ArgumentTypeInfos.class)
public interface ArgumentTypeInfosMixin {
	@Accessor("BY_CLASS")
	static Map<Class<?>, ArgumentTypeInfo<?, ?>> steelwool$byClass() {
		throw new AssertionError();
	}
}
