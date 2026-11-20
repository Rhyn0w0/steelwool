package net.neoforged.neoforge.server.permission.exceptions;

import net.neoforged.neoforge.server.permission.nodes.PermissionNode;

/**
 * SteelWool re-implementation of NeoForge's {@code UnregisteredPermissionException}, with the same API.
 */
public class UnregisteredPermissionException extends RuntimeException {
	private PermissionNode<?> node;

	public UnregisteredPermissionException(PermissionNode<?> node) {
		super("Permission node " + node.getNodeName() + " was not registered with PermissionGatherEvent.Nodes");
		this.node = node;
	}

	public PermissionNode<?> getNode() {
		return this.node;
	}
}
