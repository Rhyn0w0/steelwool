package net.neoforged.fml.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * SteelWool re-implementation of FML's {@code ObfuscationReflectionHelper}. Minecraft 26.x is not
 * obfuscated, so names are used as they are.
 */
public class ObfuscationReflectionHelper {
	public ObfuscationReflectionHelper() {
	}

	@SuppressWarnings("unchecked")
	public static <T, E> T getPrivateValue(Class<? super E> classToAccess, E instance, String fieldName) {
		try {
			return (T) findField(classToAccess, fieldName).get(instance);
		} catch (IllegalAccessException e) {
			throw new UnableToAccessFieldException(e);
		}
	}

	public static <T, E> void setPrivateValue(Class<? super T> classToAccess, T instance, E value, String fieldName) {
		try {
			findField(classToAccess, fieldName).set(instance, value);
		} catch (IllegalAccessException e) {
			throw new UnableToAccessFieldException(e);
		}
	}

	public static Method findMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
		try {
			Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
			method.setAccessible(true);
			return method;
		} catch (Exception e) {
			throw new UnableToFindMethodException(e);
		}
	}

	public static <T> Constructor<T> findConstructor(Class<T> clazz, Class<?>... parameterTypes) {
		try {
			Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);
			constructor.setAccessible(true);
			return constructor;
		} catch (NoSuchMethodException e) {
			throw new UnknownConstructorException("Could not find constructor of " + clazz.getName(), e);
		}
	}

	public static <T> Field findField(Class<? super T> clazz, String fieldName) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field;
		} catch (Exception e) {
			throw new UnableToFindFieldException(e);
		}
	}

	public static class UnableToAccessFieldException extends RuntimeException {
		private UnableToAccessFieldException(Exception e) {
			super(e);
		}
	}

	public static class UnableToFindFieldException extends RuntimeException {
		private UnableToFindFieldException(Exception e) {
			super(e);
		}
	}

	public static class UnableToFindMethodException extends RuntimeException {
		public UnableToFindMethodException(Throwable failed) {
			super(failed);
		}
	}

	public static class UnknownConstructorException extends RuntimeException {
		public UnknownConstructorException(String message, Throwable cause) {
			super(message, cause);
		}
	}
}
