package net.neoforged.neoforge.event.entity.living;

import java.util.List;

import net.minecraft.world.entity.Mob;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code MobSplitEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class MobSplitEvent extends Event implements ICancellableEvent {
	protected final Mob parent;
	protected final List<Mob> children;

	public MobSplitEvent(Mob parent, List<Mob> children) {
		super();
		this.parent = parent;
		this.children = children;
	}

	public Mob getParent() {
		return this.parent;
	}

	public List<Mob> getChildren() {
		return this.children;
	}

	public void setCanceled(boolean arg0) {
		ICancellableEvent.super.setCanceled(arg0);
	}
}
