package net.neoforged.neoforge.transfer.item;

import java.util.function.Predicate;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.transfer.resource.DataComponentHolderResource;
import org.slf4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemResource}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ItemResource extends Object implements DataComponentHolderResource<Item> {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	public static final net.neoforged.neoforge.transfer.item.ItemResource EMPTY = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.transfer.item.ItemResource> CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.transfer.item.ItemResource> OPTIONAL_CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.transfer.item.ItemResource> STREAM_CODEC = null /* SteelWool: TODO */;
	private final ItemStack innerStack;

	public static net.neoforged.neoforge.transfer.item.ItemResource of(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.item.ItemResource of(ItemStackTemplate arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.item.ItemResource of(ItemLike arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.item.ItemResource of(ItemLike arg0, DataComponentPatch arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.item.ItemResource of(Holder<Item> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.item.ItemResource of(Holder<Item> arg0, DataComponentPatch arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.of yet");
	}

	private ItemResource(ItemStack innerStack) {
		super();
		this.innerStack = innerStack;
	}

	public Item value() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.value yet");
	}

	public Item getItem() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.getItem yet");
	}

	public Holder<Item> typeHolder() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.typeHolder yet");
	}

	public boolean isEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.isEmpty yet");
	}

	public boolean matches(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.matches yet");
	}

	public boolean matches(ItemStackTemplate arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.matches yet");
	}

	public boolean is(ItemLike arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.is yet");
	}

	public boolean test(Predicate<ItemStack> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.test yet");
	}

	public boolean isComponentsPatchEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.isComponentsPatchEmpty yet");
	}

	public net.neoforged.neoforge.transfer.item.ItemResource withMergedPatch(DataComponentPatch arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.withMergedPatch yet");
	}

	public <D extends Object> net.neoforged.neoforge.transfer.item.ItemResource with(DataComponentType<D> arg0, D arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.with yet");
	}

	public <D extends Object> net.neoforged.neoforge.transfer.item.ItemResource with(Supplier<? extends DataComponentType<D>> arg0, D arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.with yet");
	}

	public net.neoforged.neoforge.transfer.item.ItemResource without(DataComponentType<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.without yet");
	}

	public net.neoforged.neoforge.transfer.item.ItemResource without(Supplier<? extends DataComponentType<?>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.without yet");
	}

	public DataComponentMap getComponents() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.getComponents yet");
	}

	public DataComponentPatch getComponentsPatch() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.getComponentsPatch yet");
	}

	public ItemStack toStack(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.toStack yet");
	}

	public ItemStack toStack() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.toStack yet");
	}

	public int getMaxStackSize() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.getMaxStackSize yet");
	}

	public Component getHoverName() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.getHoverName yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.equals yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.hashCode yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemResource.toString yet");
	}
}
