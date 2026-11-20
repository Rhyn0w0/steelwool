package net.neoforged.neoforge.server.permission;

import java.util.Collection;
import java.util.UUID;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.server.permission.events.PermissionGatherEvent;
import net.neoforged.neoforge.server.permission.exceptions.UnregisteredPermissionException;
import net.neoforged.neoforge.server.permission.handler.DefaultPermissionHandler;
import net.neoforged.neoforge.server.permission.handler.IPermissionHandler;
import net.neoforged.neoforge.server.permission.nodes.PermissionDynamicContext;
import net.neoforged.neoforge.server.permission.nodes.PermissionNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SteelWool re-implementation of NeoForge's {@code PermissionAPI}, with the same API.
 */
public final class PermissionAPI {
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool/Permissions");
	private static IPermissionHandler activeHandler;

	public static Collection<PermissionNode<?>> getRegisteredNodes() {
		return activeHandler.getRegisteredNodes();
	}

	private PermissionAPI() {
		super();
	}

	public static Identifier getActivePermissionHandler() {
		return activeHandler.getIdentifier();
	}

	public static <T extends Object> T getPermission(ServerPlayer player, PermissionNode<T> node, PermissionDynamicContext<?>... contexts) {
		if (!activeHandler.getRegisteredNodes().contains(node)) {
			throw new UnregisteredPermissionException(node);
		}
		
		return activeHandler.getPermission(player, node, contexts);
	}

	public static <T extends Object> T getOfflinePermission(UUID player, PermissionNode<T> node, PermissionDynamicContext<?>... contexts) {
		if (!activeHandler.getRegisteredNodes().contains(node)) {
			throw new UnregisteredPermissionException(node);
		}
		
		return activeHandler.getOfflinePermission(player, node, contexts);
	}

	public static void initializePermissionAPI() {
		var handlers = NeoForge.EVENT_BUS.post(new PermissionGatherEvent.Handler());
		var nodes = NeoForge.EVENT_BUS.post(new PermissionGatherEvent.Nodes());
		// SteelWool has no NeoForge server config to pick another handler, so it always uses the default one.
		activeHandler = handlers.getAvailablePermissionHandlerFactories()
				.get(DefaultPermissionHandler.IDENTIFIER)
				.create(nodes.getNodes());
		LOGGER.debug("Using permission handler {} with {} nodes", activeHandler.getIdentifier(), nodes.getNodes().size());
	}
}
