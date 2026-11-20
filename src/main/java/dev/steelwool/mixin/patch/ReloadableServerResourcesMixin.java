package dev.steelwool.mixin.patch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.commands.Commands;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponentInitializers;
import net.minecraft.server.ReloadableServerRegistries;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.world.flag.FeatureFlagSet;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;
import net.neoforged.neoforge.resource.ListenerKey;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * NeoForge's additions to {@link ReloadableServerResources}: the {@code registryAccess} and
 * {@code loadingContext} fields (which mods reach with {@code @Shadow}), {@code getRegistryLookup()},
 * retained listeners ({@code getListener}), and {@code AddServerReloadListenersEvent}, fired the first
 * time the listeners are asked for. Applied before other mods' mixins so their {@code @Shadow}s find
 * the fields.
 */
@Mixin(value = ReloadableServerResources.class, priority = 500)
public abstract class ReloadableServerResourcesMixin {
	@SuppressWarnings("unused")
	private RegistryAccess registryAccess;
	private HolderLookup.Provider loadingContext;
	private final Map<ListenerKey<?>, PreparableReloadListener> retainedListeners = new HashMap<>();
	@Unique
	private @Nullable List<PreparableReloadListener> steelwool$sortedListeners;
	@Unique
	private boolean steelwool$collectingListeners;

	@Inject(method = "<init>", at = @At("TAIL"))
	private void steelwool$storeRegistries(ReloadableServerRegistries.LoadResult loadResult, FeatureFlagSet enabledFeatures, Commands.CommandSelection commandSelection,
			List<Registry.PendingTags<?>> postponedTags, PermissionSet permissions, List<DataComponentInitializers.PendingComponents<?>> newComponents, CallbackInfo ci) {
		registryAccess = loadResult.layers().compositeAccess();
		loadingContext = loadResult.lookupWithUpdatedTags();
	}

	public HolderLookup.Provider getRegistryLookup() {
		return loadingContext;
	}

	@SuppressWarnings("unchecked")
	public <T extends PreparableReloadListener> @Nullable T getListener(ListenerKey<T> key) {
		return (T) retainedListeners.get(key);
	}

	@Inject(method = "listeners", at = @At("RETURN"), cancellable = true)
	private void steelwool$addModListeners(CallbackInfoReturnable<List<PreparableReloadListener>> cir) {
		if (steelwool$collectingListeners) {
			return; // the event asks for the vanilla listeners while it is being built
		}
		if (steelwool$sortedListeners == null) {
			steelwool$collectingListeners = true;
			try {
				AddServerReloadListenersEvent event = new AddServerReloadListenersEvent((ReloadableServerResources) (Object) this, retainedListeners);
				NeoForge.EVENT_BUS.post(event);
				steelwool$sortedListeners = List.copyOf(event.sortedListeners());
			} finally {
				steelwool$collectingListeners = false;
			}
		}
		cir.setReturnValue(steelwool$sortedListeners);
	}
}
