package net.neoforged.neoforge.event;

import java.util.function.Function;

import net.minecraft.core.Holder;
import net.minecraft.core.WritableRegistry;
import net.minecraft.gametest.framework.GameTestInstance;
import net.minecraft.gametest.framework.TestData;
import net.minecraft.gametest.framework.TestEnvironmentDefinition;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterGameTestsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterGameTestsEvent extends Event implements IModBusEvent {
	private final WritableRegistry<TestEnvironmentDefinition<?>> environmentsRegistry;
	private final WritableRegistry<GameTestInstance> testsRegistry;

	public RegisterGameTestsEvent(WritableRegistry<TestEnvironmentDefinition<?>> environmentsRegistry, WritableRegistry<GameTestInstance> testsRegistry) {
		super();
		this.environmentsRegistry = environmentsRegistry;
		this.testsRegistry = testsRegistry;
	}

	public Holder<TestEnvironmentDefinition<?>> registerEnvironment(Identifier arg0, TestEnvironmentDefinition<?>... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGameTestsEvent.registerEnvironment yet");
	}

	public Holder<TestEnvironmentDefinition<?>> registerEnvironment(Identifier arg0, TestEnvironmentDefinition<?> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGameTestsEvent.registerEnvironment yet");
	}

	public void registerTest(Identifier arg0, Function<TestData<Holder<TestEnvironmentDefinition<?>>>, GameTestInstance> arg1, TestData<Holder<TestEnvironmentDefinition<?>>> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGameTestsEvent.registerTest yet");
	}

	public void registerTest(Identifier arg0, GameTestInstance arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterGameTestsEvent.registerTest yet");
	}
}
