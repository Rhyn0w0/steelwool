package net.neoforged.neoforge.server.permission.nodes;

import java.util.UUID;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;

/**
 * SteelWool re-implementation of NeoForge's {@code PermissionNode}, with the same API.
 */
public final class PermissionNode<T extends Object> extends Object {
	private final String nodeName;
	private final PermissionType<T> type;
	private final net.neoforged.neoforge.server.permission.nodes.PermissionNode.PermissionResolver<T> defaultResolver;
	private final PermissionDynamicContextKey<?>[] dynamics;
	private Component readableName;
	private Component description;

	public PermissionNode(Identifier nodeName, PermissionType<T> type, net.neoforged.neoforge.server.permission.nodes.PermissionNode.PermissionResolver<T> defaultResolver, PermissionDynamicContextKey... dynamics) {
		this(nodeName.getNamespace(), nodeName.getPath(), type, defaultResolver, dynamics);
	}

	public PermissionNode(String modId, String nodeName, PermissionType<T> type, net.neoforged.neoforge.server.permission.nodes.PermissionNode.PermissionResolver<T> defaultResolver, PermissionDynamicContextKey... dynamics) {
		this(modId + "." + nodeName, type, defaultResolver, dynamics);
	}

	private PermissionNode(String nodeName, PermissionType<T> type, net.neoforged.neoforge.server.permission.nodes.PermissionNode.PermissionResolver<T> defaultResolver, PermissionDynamicContextKey... dynamics) {
		super();
		this.nodeName = nodeName;
		this.type = type;
		this.dynamics = dynamics;
		this.defaultResolver = defaultResolver;
	}

	public net.neoforged.neoforge.server.permission.nodes.PermissionNode setInformation(Component readableName, Component description) {
		this.readableName = readableName;
		this.description = description;
		return this;
	}

	public String getNodeName() {
		return this.nodeName;
	}

	public PermissionType<T> getType() {
		return this.type;
	}

	public PermissionDynamicContextKey<?>[] getDynamics() {
		return this.dynamics;
	}

	public net.neoforged.neoforge.server.permission.nodes.PermissionNode.PermissionResolver<T> getDefaultResolver() {
		return this.defaultResolver;
	}

	public Component getReadableName() {
		return this.readableName;
	}

	public Component getDescription() {
		return this.description;
	}

	public boolean equals(Object o) {
		return this == o || o instanceof PermissionNode<?> other && nodeName.equals(other.nodeName);
	}

	public int hashCode() {
		return nodeName.hashCode();
	}

	public interface PermissionResolver<T extends Object> {
		T resolve(ServerPlayer arg0, UUID arg1, PermissionDynamicContext<?>... arg2);
	}
}
