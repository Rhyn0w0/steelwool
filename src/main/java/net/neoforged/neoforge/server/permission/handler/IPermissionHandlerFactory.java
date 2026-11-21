package net.neoforged.neoforge.server.permission.handler;

import java.util.Collection;

import net.neoforged.neoforge.server.permission.nodes.PermissionNode;

/**
 * SteelWool re-implementation of NeoForge's {@code IPermissionHandlerFactory}, with the same API.
 */
public interface IPermissionHandlerFactory {
	IPermissionHandler create(Collection<PermissionNode<?>> arg0);
}
