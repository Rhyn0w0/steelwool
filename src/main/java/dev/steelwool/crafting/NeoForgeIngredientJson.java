package dev.steelwool.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;

/**
 * Rewrites NeoForge's custom ingredients in data JSON ({@code "neoforge:ingredient_type"}) into the
 * matching Fabric API custom ingredients ({@code "fabric:type"}), which the ingredient codec on Fabric
 * understands:
 * <ul>
 * <li>{@code neoforge:difference} to {@code fabric:difference} (same fields);
 * <li>{@code neoforge:compound} to {@code fabric:any} and {@code neoforge:intersection} to
 * {@code fabric:all} ({@code children} becomes {@code ingredients});
 * <li>{@code neoforge:components} to {@code fabric:components} ({@code items} becomes {@code base};
 * {@code strict} matching is not supported and is dropped).
 * </ul>
 * Other NeoForge ingredient types are left as they are, so data using them still fails to load.
 */
public final class NeoForgeIngredientJson {
	private static final String NEOFORGE_TYPE = "neoforge:ingredient_type";
	private static final String FABRIC_TYPE = "fabric:type";

	private NeoForgeIngredientJson() {
	}

	/** Whether {@code json} contains a NeoForge custom ingredient anywhere (a cheap check before rewriting). */
	public static boolean mentions(JsonElement json) {
		return json.toString().contains(NEOFORGE_TYPE);
	}

	/** Rewrites every NeoForge custom ingredient inside {@code json}, in place. */
	public static void rewrite(JsonElement json) {
		if (json instanceof JsonArray array) {
			array.forEach(NeoForgeIngredientJson::rewrite);
		} else if (json instanceof JsonObject object) {
			for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
				rewrite(entry.getValue());
			}
			if (object.has(NEOFORGE_TYPE)) {
				rewriteIngredient(object);
			}
		}
	}

	private static void rewriteIngredient(JsonObject object) {
		String type = object.get(NEOFORGE_TYPE).getAsString();
		switch (type) {
			case "neoforge:difference" -> setType(object, "fabric:difference");
			case "neoforge:compound" -> {
				setType(object, "fabric:any");
				rename(object, "children", "ingredients");
			}
			case "neoforge:intersection" -> {
				setType(object, "fabric:all");
				rename(object, "children", "ingredients");
			}
			case "neoforge:components" -> {
				setType(object, "fabric:components");
				rename(object, "items", "base");
				object.remove("strict");
			}
			default -> {
				// Not supported: leave it, so parsing reports the unknown ingredient.
			}
		}
	}

	private static void setType(JsonObject object, String fabricType) {
		object.remove(NEOFORGE_TYPE);
		object.addProperty(FABRIC_TYPE, fabricType);
	}

	private static void rename(JsonObject object, String from, String to) {
		JsonElement value = object.remove(from);
		if (value != null) {
			object.add(to, value);
		}
	}
}
