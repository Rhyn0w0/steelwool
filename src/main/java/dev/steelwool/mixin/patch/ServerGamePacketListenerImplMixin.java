package dev.steelwool.mixin.patch;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Target for the call {@code SteelWoolMixinPlugin} rewrites: NeoForge's pick-block handler calls
 * {@code BlockState.getCloneItemStack(pos, level, includeData, player)} instead of vanilla's
 * overload, and mods' mixins target that call. Lowest priority, so the call is rewritten before
 * other mods' injectors look for it.
 */
@Mixin(value = ServerGamePacketListenerImpl.class, priority = 1)
public abstract class ServerGamePacketListenerImplMixin {
}
