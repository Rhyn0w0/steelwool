package net.neoforged.neoforge.server.permission.handler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.server.permission.nodes.PermissionDynamicContext;
import net.neoforged.neoforge.server.permission.nodes.PermissionNode;

/**
 * SteelWool re-implementation of NeoForge's {@code DefaultPermissionHandler}, with the same API.
 */
public final class DefaultPermissionHandler implements IPermissionHandler {
	public static final Identifier IDENTIFIER = Identifier.fromNamespaceAndPath("neoforge", "default_handler");
	private final Set<PermissionNode<?>> registeredNodes;
	private Set<PermissionNode<?>> immutableRegisteredNodes;

	public DefaultPermissionHandler(Collection<PermissionNode<?>> permissions) {
		this.registeredNodes = new HashSet<>(permissions);
		this.immutableRegisteredNodes = Collections.unmodifiableSet(registeredNodes);
	}

	public Identifier getIdentifier() {
		return IDENTIFIER;
	}

	public Set<PermissionNode<?>> getRegisteredNodes() {
		return this.immutableRegisteredNodes;
	}

	public <T extends Object> T getPermission(ServerPlayer player, PermissionNode<T> node, PermissionDynamicContext<?>... contexts) {
		return node.getDefaultResolver().resolve(player, player.getUUID(), contexts);
	}

	public <T extends Object> T getOfflinePermission(UUID player, PermissionNode<T> node, PermissionDynamicContext<?>... contexts) {
		return node.getDefaultResolver().resolve(null, player, contexts);
	}
}
