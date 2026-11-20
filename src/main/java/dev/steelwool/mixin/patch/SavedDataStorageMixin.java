package dev.steelwool.mixin.patch;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.DataFixer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.level.storage.SavedDataStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Saved data types without a data fixer (NeoForge's 3-argument {@code SavedDataType}) are read as they are. */
@Mixin(SavedDataStorage.class)
public abstract class SavedDataStorageMixin {
	@WrapOperation(method = "readTagFromDisk", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/util/datafix/DataFixTypes;update(Lcom/mojang/datafixers/DataFixer;Lnet/minecraft/nbt/CompoundTag;II)Lnet/minecraft/nbt/CompoundTag;"))
	private CompoundTag steelwool$skipMissingFixer(DataFixTypes type, DataFixer fixer, CompoundTag tag, int fromVersion, int toVersion, Operation<CompoundTag> original) {
		return type == null ? tag : original.call(type, fixer, tag, fromVersion, toVersion);
	}
}
