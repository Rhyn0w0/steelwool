package net.neoforged.neoforge.event.entity;

import net.minecraft.core.SectionPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityEvent}, with the same API.
 */
public abstract class EntityEvent extends Event {
	private final Entity entity;

	public EntityEvent(Entity entity) {
		super();
		this.entity = entity;
	}

	public Entity getEntity() {
		return this.entity;
	}

	public static class EnteringSection extends net.neoforged.neoforge.event.entity.EntityEvent {
		private final long packedOldPos;
		private final long packedNewPos;

		public EnteringSection(Entity arg0, long packedOldPos, long packedNewPos) {
			super(arg0);
			this.packedOldPos = packedOldPos;
			this.packedNewPos = packedNewPos;
		}

		public long getPackedOldPos() {
			return this.packedOldPos;
		}

		public long getPackedNewPos() {
			return this.packedNewPos;
		}

		public SectionPos getOldPos() {
			return SectionPos.of(packedOldPos);
		}

		public SectionPos getNewPos() {
			return SectionPos.of(packedNewPos);
		}

		public boolean didChunkChange() {
			return SectionPos.x(packedOldPos) != SectionPos.x(packedNewPos) || SectionPos.z(packedOldPos) != SectionPos.z(packedNewPos);
		}
	}

	public static class EntityConstructing extends net.neoforged.neoforge.event.entity.EntityEvent {
		public EntityConstructing(Entity arg0) {
			super(arg0);
		}
	}

	public static class Size extends net.neoforged.neoforge.event.entity.EntityEvent {
		private final Pose pose;
		private final EntityDimensions oldSize;
		private EntityDimensions newSize;

		public Size(Entity arg0, Pose arg1, EntityDimensions arg2) {
			this(arg0, arg1, arg2, arg2);
		}

		public Size(Entity arg0, Pose pose, EntityDimensions oldSize, EntityDimensions newSize) {
			super(arg0);
			this.pose = pose;
			this.oldSize = oldSize;
			this.newSize = newSize;
		}

		public Pose getPose() {
			return this.pose;
		}

		public EntityDimensions getOldSize() {
			return this.oldSize;
		}

		public EntityDimensions getNewSize() {
			return this.newSize;
		}

		public void setNewSize(EntityDimensions newSize) {
			this.newSize = newSize;
		}
	}
}
