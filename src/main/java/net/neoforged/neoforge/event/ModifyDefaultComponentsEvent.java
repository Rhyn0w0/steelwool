package net.neoforged.neoforge.event;

import java.util.List;
import java.util.Map;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ModifyDefaultComponentsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ModifyDefaultComponentsEvent extends Event implements IModBusEvent {
	private final Map<Item, net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.Initializer> modifiersByItem;
	private final List<Pair<net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.ItemWithComponentsPredicate, net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.Initializer>> modifiersByPredicate;

	public ModifyDefaultComponentsEvent(Map<Item, net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.Initializer> modifiersByItem, List<Pair<net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.ItemWithComponentsPredicate, net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.Initializer>> modifiersByPredicate) {
		super();
		this.modifiersByItem = modifiersByItem;
		this.modifiersByPredicate = modifiersByPredicate;
	}

	public void modify(ItemLike arg0, net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.Initializer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ModifyDefaultComponentsEvent.modify yet");
	}

	public void modifyMatching(net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.ItemWithComponentsPredicate arg0, net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.Initializer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ModifyDefaultComponentsEvent.modifyMatching yet");
	}

	public interface Initializer {
		void run(DataComponentMap.Builder arg0, HolderLookup.Provider arg1, Item arg2);

		default net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.Initializer andThen(net.neoforged.neoforge.event.ModifyDefaultComponentsEvent.Initializer arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ModifyDefaultComponentsEvent.Initializer.andThen yet");
		}
	}

	public interface ItemWithComponentsPredicate {
		boolean test(Item arg0, DataComponentGetter arg1);
	}
}
