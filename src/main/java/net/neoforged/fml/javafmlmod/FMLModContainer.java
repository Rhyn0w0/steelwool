package net.neoforged.fml.javafmlmod;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dev.steelwool.discovery.AnnotationScanResult;
import dev.steelwool.loading.ModLoadingFailure;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.BusBuilder;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforgespi.language.IModInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SteelWool re-implementation of FML's {@code FMLModContainer}: a container for a {@code javafml} mod
 * whose entrypoints are {@code @Mod}-annotated classes.
 */
public class FMLModContainer extends ModContainer {
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool/FMLModContainer");

	private final IEventBus eventBus;
	private final List<String> entrypoints;
	private final List<AnnotationScanResult.SubscriberClass> subscribers;
	private final ClassLoader classLoader;
	private final Dist dist;
	private final List<Object> instances = new ArrayList<>();

	public FMLModContainer(IModInfo info, List<String> entrypoints, List<AnnotationScanResult.SubscriberClass> subscribers,
			ClassLoader classLoader, Dist dist) {
		super(info);
		this.entrypoints = List.copyOf(entrypoints);
		this.subscribers = List.copyOf(subscribers);
		this.classLoader = classLoader;
		this.dist = dist;
		this.eventBus = BusBuilder.builder()
				.setExceptionHandler((bus, event, listeners, index, throwable) ->
						LOGGER.error("Exception in mod {} while handling {}", modId, event.getClass().getName(), throwable))
				.markerType(IModBusEvent.class)
				.allowPerPhasePost()
				.build();
	}

	@Override
	public IEventBus getEventBus() {
		return eventBus;
	}

	/** The constructed {@code @Mod} instances, in entrypoint order. */
	public List<Object> getInstances() {
		return List.copyOf(instances);
	}

	@Override
	protected void constructMod() {
		ModLoadingContext context = ModLoadingContext.get();
		context.setActiveContainer(this);

		try {
			for (String entrypoint : entrypoints) {
				instances.add(construct(entrypoint));
			}

			for (AnnotationScanResult.SubscriberClass subscriber : subscribers) {
				registerSubscriber(subscriber);
			}
		} finally {
			context.setActiveContainer(null);
		}
	}

	/** Runs {@link #constructMod()}; public so SteelWool's loader (in another package) can call it. */
	public void construct() {
		constructMod();
	}

	private Object construct(String className) {
		try {
			Class<?> modClass = Class.forName(className, true, classLoader);
			Constructor<?>[] constructors = modClass.getConstructors();

			if (constructors.length != 1) {
				throw new IllegalStateException("Mod class " + className + " must have exactly 1 public constructor, found " + constructors.length);
			}

			Constructor<?> constructor = constructors[0];
			Map<Class<?>, Object> allowedArgs = new HashMap<>();
			allowedArgs.put(IEventBus.class, eventBus);
			allowedArgs.put(ModContainer.class, this);
			allowedArgs.put(FMLModContainer.class, this);
			allowedArgs.put(Dist.class, dist);

			Class<?>[] parameterTypes = constructor.getParameterTypes();
			Object[] args = new Object[parameterTypes.length];
			Set<Class<?>> seen = new HashSet<>();

			for (int i = 0; i < parameterTypes.length; i++) {
				Object arg = allowedArgs.get(parameterTypes[i]);

				if (arg == null) {
					throw new IllegalStateException("Mod constructor of " + className + " has unsupported argument type " + parameterTypes[i].getName()
							+ ". Allowed: IEventBus, ModContainer, FMLModContainer, Dist");
				}

				if (!seen.add(parameterTypes[i])) {
					throw new IllegalStateException("Duplicate mod constructor argument type " + parameterTypes[i].getName() + " in " + className);
				}

				args[i] = arg;
			}

			LOGGER.debug("Constructing {} for mod {}", className, modId);
			return constructor.newInstance(args);
		} catch (InvocationTargetException e) {
			throw ModLoadingFailure.of(modId, "its mod class " + className + " threw an exception while being constructed", e.getCause());
		} catch (ReflectiveOperationException | LinkageError | RuntimeException e) {
			throw ModLoadingFailure.of(modId, "its mod class " + className + " could not be constructed", e);
		}
	}

	private void registerSubscriber(AnnotationScanResult.SubscriberClass subscriber) {
		if (!subscriber.dists().contains(dist.name())) {
			return;
		}

		try {
			Class<?> clazz = Class.forName(subscriber.className(), true, classLoader);

			for (Method method : clazz.getDeclaredMethods()) {
				if (!method.isAnnotationPresent(SubscribeEvent.class)) {
					continue;
				}

				if (!Modifier.isStatic(method.getModifiers())) {
					throw new IllegalArgumentException("Method " + method + " annotated with @SubscribeEvent is not static");
				}

				if (method.getParameterCount() != 1 || !Event.class.isAssignableFrom(method.getParameterTypes()[0])) {
					throw new IllegalArgumentException("Method " + method + " annotated with @SubscribeEvent must have exactly one Event parameter");
				}

				if (IModBusEvent.class.isAssignableFrom(method.getParameterTypes()[0])) {
					eventBus.register(method);
				} else {
					NeoForge.EVENT_BUS.register(method);
				}
			}
		} catch (ReflectiveOperationException | LinkageError | RuntimeException e) {
			throw ModLoadingFailure.of(modId, "its @EventBusSubscriber class " + subscriber.className() + " could not be registered", e);
		}
	}
}
