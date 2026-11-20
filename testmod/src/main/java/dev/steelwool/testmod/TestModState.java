package dev.steelwool.testmod;

/**
 * Flags the test mod sets as NeoForge events reach it. SteelWool's game tests read these
 * reflectively to check each part of the lifecycle ran.
 */
public final class TestModState {
	public static volatile boolean constructed;
	public static volatile boolean constructEventFired;
	public static volatile boolean configLoadingEventFired;
	public static volatile boolean commonSetupFired;
	public static volatile boolean deferredWorkRan;
	public static volatile boolean dedicatedServerSetupFired;
	public static volatile boolean clientSetupFired;
	public static volatile boolean loadCompleteFired;
	public static volatile boolean creativeTabEventFired;
	public static volatile boolean serverStartingFired;
	public static volatile boolean serverStartedFiredViaSubscriber;
	public static volatile boolean mixinApplied;
	public static volatile boolean payloadsRegistered;
	public static volatile int magicNumberAtCommonSetup = -1;

	private TestModState() {
	}
}
