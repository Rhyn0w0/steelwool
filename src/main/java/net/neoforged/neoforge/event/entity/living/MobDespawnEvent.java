package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ServerLevelAccessor;

/**
 * SteelWool re-implementation of NeoForge's {@code MobDespawnEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class MobDespawnEvent extends MobSpawnEvent {
	protected net.neoforged.neoforge.event.entity.living.MobDespawnEvent.Result result;

	public MobDespawnEvent(Mob arg0, ServerLevelAccessor arg1) {
		super((Mob) null, (ServerLevelAccessor) null, (double) 0, (double) 0, (double) 0);
		throw new UnsupportedOperationException("SteelWool does not implement the MobDespawnEvent constructor yet");
	}

	public void setResult(net.neoforged.neoforge.event.entity.living.MobDespawnEvent.Result result) {
		this.result = result;
	}

	public net.neoforged.neoforge.event.entity.living.MobDespawnEvent.Result getResult() {
		return this.result;
	}

	public enum Result {
		ALLOW, DEFAULT, DENY;
	}
}
