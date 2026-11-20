package net.neoforged.neoforge.common.loot;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

/**
 * SteelWool re-implementation of NeoForge's {@code LootTableIdCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LootTableIdCondition implements LootItemCondition {
	public static final MapCodec<net.neoforged.neoforge.common.loot.LootTableIdCondition> CODEC = null /* SteelWool: TODO */;
	public static final Identifier UNKNOWN_LOOT_TABLE = null /* SteelWool: TODO */;
	private final Identifier targetLootTableId;

	private LootTableIdCondition(Identifier targetLootTableId) {
		super();
		this.targetLootTableId = targetLootTableId;
	}

	public MapCodec<? extends LootItemCondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement LootTableIdCondition.codec yet");
	}

	public boolean test(LootContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement LootTableIdCondition.test yet");
	}

	public static net.neoforged.neoforge.common.loot.LootTableIdCondition.Builder builder(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement LootTableIdCondition.builder yet");
	}

	public static class Builder implements LootItemCondition.Builder {
		private final Identifier targetLootTableId;

		public Builder(Identifier arg0) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the LootTableIdCondition.Builder constructor yet");
		}

		public LootItemCondition build() {
			throw new UnsupportedOperationException("SteelWool does not implement LootTableIdCondition.Builder.build yet");
		}
	}
}
