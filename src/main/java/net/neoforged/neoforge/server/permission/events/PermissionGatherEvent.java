package net.neoforged.neoforge.server.permission.events;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.server.permission.handler.DefaultPermissionHandler;
import net.neoforged.neoforge.server.permission.handler.IPermissionHandlerFactory;
import net.neoforged.neoforge.server.permission.nodes.PermissionNode;

/**
 * SteelWool re-implementation of NeoForge's {@code PermissionGatherEvent}, with the same API.
 */
public abstract class PermissionGatherEvent extends Event {
	public PermissionGatherEvent() {
		super();
	}

	public static class Handler extends net.neoforged.neoforge.server.permission.events.PermissionGatherEvent {
		private Map<Identifier, IPermissionHandlerFactory> availableHandlers;

		public Handler() {
			this.availableHandlers = new HashMap<>();
			availableHandlers.put(DefaultPermissionHandler.IDENTIFIER, DefaultPermissionHandler::new);
		}

		public Map<Identifier, IPermissionHandlerFactory> getAvailablePermissionHandlerFactories() {
			return Collections.unmodifiableMap(availableHandlers);
		}

		public void addPermissionHandler(Identifier identifier, IPermissionHandlerFactory handlerFactory) {
			if (availableHandlers.containsKey(identifier)) {
				throw new IllegalArgumentException("Attempted to overwrite permission handler " + identifier);
			}
			
			availableHandlers.put(identifier, handlerFactory);
		}
	}

	public static class Nodes extends net.neoforged.neoforge.server.permission.events.PermissionGatherEvent {
		private final Set<PermissionNode<?>> nodes;

		public Nodes() {
			this.nodes = new HashSet<>();
		}

		public Collection<PermissionNode<?>> getNodes() {
			return Collections.unmodifiableSet(nodes);
		}

		public void addNodes(PermissionNode<?>... nodes) {
			for (var node : nodes) {
				if (!this.nodes.add(node)) {
					throw new IllegalArgumentException("Tried to register duplicate permission node " + node.getNodeName());
				}
			}
		}

		public void addNodes(Iterable<PermissionNode<?>> nodes) {
			for (var node : nodes) {
				if (!this.nodes.add(node)) {
					throw new IllegalArgumentException("Tried to register duplicate permission node " + node.getNodeName());
				}
			}
		}
	}
}
