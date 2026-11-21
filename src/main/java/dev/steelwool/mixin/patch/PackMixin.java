package dev.steelwool.mixin.patch;

import java.util.List;
import java.util.stream.Stream;
import net.minecraft.server.packs.repository.Pack;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Adds NeoForge's hidden packs and child packs to {@link Pack}: the {@code hidden} field (which mods
 * reach with accessors), {@code isHidden()}, {@code hidden()}, {@code getChildren()},
 * {@code withChildren(List)} and {@code streamSelfAndChildren()}. SteelWool does not hide packs from
 * the pack screen or load child packs; {@code hidden()} and {@code withChildren} change this pack
 * instead of returning a copy.
 */
@Mixin(value = Pack.class, priority = 500)
public abstract class PackMixin {
	private boolean hidden;
	private List<Pack> children = List.of();

	public boolean isHidden() {
		return hidden;
	}

	public Pack hidden() {
		hidden = true;
		return (Pack) (Object) this;
	}

	public List<Pack> getChildren() {
		return children;
	}

	public Pack withChildren(List<Pack> children) {
		this.children = List.copyOf(children);
		return (Pack) (Object) this;
	}

	public Stream<Pack> streamSelfAndChildren() {
		return Stream.concat(Stream.of((Pack) (Object) this), children.stream());
	}
}
