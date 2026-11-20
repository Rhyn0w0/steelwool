package net.neoforged.neoforge.registries.holdersets;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;

/**
 * SteelWool re-implementation of NeoForge's {@code CompositeHolderSet}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class CompositeHolderSet<T extends Object> extends Object implements ICustomHolderSet<T> {
	private final List<Runnable> owners;
	private final List<HolderSet<T>> components;
	private Set<Holder<T>> set;
	private List<Holder<T>> list;

	public CompositeHolderSet(List<HolderSet<T>> arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the CompositeHolderSet constructor yet");
	}

	public boolean isImmediatelyResolvable() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.isImmediatelyResolvable yet");
	}

	protected abstract Set<Holder<T>> createSet();

	public List<HolderSet<T>> getComponents() {
		return this.components;
	}

	public Set<Holder<T>> getSet() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.getSet yet");
	}

	public List<Holder<T>> getList() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.getList yet");
	}

	public void addInvalidationListener(Runnable arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.addInvalidationListener yet");
	}

	private void invalidate() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.invalidate yet");
	}

	public Stream<Holder<T>> stream() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.stream yet");
	}

	public int size() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.size yet");
	}

	public Either<TagKey<T>, List<Holder<T>>> unwrap() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.unwrap yet");
	}

	public Optional<Holder<T>> getRandomElement(RandomSource arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.getRandomElement yet");
	}

	public Holder<T> get(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.get yet");
	}

	public boolean contains(Holder<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.contains yet");
	}

	public boolean canSerializeIn(HolderOwner<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.canSerializeIn yet");
	}

	public Optional<TagKey<T>> unwrapKey() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.unwrapKey yet");
	}

	public Iterator<Holder<T>> iterator() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.iterator yet");
	}

	public List<HolderSet<T>> homogenize() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.homogenize yet");
	}

	public boolean isHomogenous() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.isHomogenous yet");
	}

	public boolean isBound() {
		throw new UnsupportedOperationException("SteelWool does not implement CompositeHolderSet.isBound yet");
	}
}
