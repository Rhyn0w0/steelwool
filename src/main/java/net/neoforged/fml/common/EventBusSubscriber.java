package net.neoforged.fml.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.neoforged.api.distmarker.Dist;

/**
 * SteelWool re-implementation of FML's {@code @EventBusSubscriber}. Static {@code @SubscribeEvent}
 * methods in the annotated class are registered automatically: mod-bus events on the mod's bus,
 * everything else on {@code NeoForge.EVENT_BUS}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EventBusSubscriber {
	Dist[] value() default { Dist.CLIENT, Dist.DEDICATED_SERVER };

	String modid() default "";
}
