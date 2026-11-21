package net.neoforged.neoforge.server.permission.handler;

import java.util.Set;
import java.util.UUID;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.server.permission.nodes.PermissionDynamicContext;
import net.neoforged.neoforge.server.permission.nodes.PermissionNode;

/**
 * SteelWool re-implementation of NeoForge's {@code IPermissionHandler}, with the same API.
 */
public interface IPermissionHandler {
	Identifier getIdentifier();

	Set<PermissionNode<?>> getRegisteredNodes();

	<T extends Object> T getPermission(ServerPlayer arg0, PermissionNode<T> arg1, PermissionDynamicContext<?>... arg2);

	<T extends Object> T getOfflinePermission(UUID arg0, PermissionNode<T> arg1, PermissionDynamicContext<?>... arg2);
}
