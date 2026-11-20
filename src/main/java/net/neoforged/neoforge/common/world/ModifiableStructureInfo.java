package net.neoforged.neoforge.common.world;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.levelgen.structure.Structure;

/**
 * SteelWool re-implementation of NeoForge's {@code ModifiableStructureInfo}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ModifiableStructureInfo {
	private final net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo originalStructureInfo;
	private net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo modifiedStructureInfo;

	public ModifiableStructureInfo(net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo originalStructureInfo) {
		super();
		this.modifiedStructureInfo = null;
		this.originalStructureInfo = originalStructureInfo;
	}

	public net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo get() {
		throw new UnsupportedOperationException("SteelWool does not implement ModifiableStructureInfo.get yet");
	}

	public net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo getOriginalStructureInfo() {
		return this.originalStructureInfo;
	}

	public net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo getModifiedStructureInfo() {
		return this.modifiedStructureInfo;
	}

	public void applyStructureModifiers(RegistryAccess arg0, Holder<Structure> arg1, List<StructureModifier> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ModifiableStructureInfo.applyStructureModifiers yet");
	}

	public static record StructureInfo(Structure.StructureSettings structureSettings) {
		public static class Builder {
			private StructureSettingsBuilder structureSettings;

			public static net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo.Builder copyOf(net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo arg0) {
				throw new UnsupportedOperationException("SteelWool does not implement ModifiableStructureInfo.StructureInfo.Builder.copyOf yet");
			}

			private Builder(StructureSettingsBuilder structureSettings) {
				super();
				this.structureSettings = structureSettings;
			}

			public net.neoforged.neoforge.common.world.ModifiableStructureInfo.StructureInfo build() {
				throw new UnsupportedOperationException("SteelWool does not implement ModifiableStructureInfo.StructureInfo.Builder.build yet");
			}

			public StructureSettingsBuilder getStructureSettings() {
				return this.structureSettings;
			}
		}
	}
}
