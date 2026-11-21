package net.neoforged.neoforge.common.crafting;

import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.block.Block;

/**
 * SteelWool re-implementation of NeoForge's {@code BlockTagIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BlockTagIngredient implements ICustomIngredient {
	public static final MapCodec<net.neoforged.neoforge.common.crafting.BlockTagIngredient> CODEC = null /* SteelWool: TODO */;
	protected final TagKey<Block> tag;
	protected HolderSet<Item> items;

	public BlockTagIngredient(TagKey<Block> tag) {
		super();
		this.tag = tag;
	}

	protected HolderSet<Item> dissolve() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagIngredient.dissolve yet");
	}

	public Stream<Holder<Item>> items() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagIngredient.items yet");
	}

	public boolean test(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagIngredient.test yet");
	}

	public TagKey<Block> getTag() {
		return this.tag;
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagIngredient.isSimple yet");
	}

	public IngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagIngredient.getType yet");
	}

	public SlotDisplay display() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagIngredient.display yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagIngredient.equals yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagIngredient.hashCode yet");
	}
}
