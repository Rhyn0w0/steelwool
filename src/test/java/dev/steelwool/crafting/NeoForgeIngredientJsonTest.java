package dev.steelwool.crafting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

class NeoForgeIngredientJsonTest {
	private static JsonObject json(String text) {
		return JsonParser.parseString(text).getAsJsonObject();
	}

	@Test
	void differenceBecomesFabricDifference() {
		JsonObject recipe = json("""
				{"type": "minecraft:crafting_shapeless", "ingredients": [
				  {"neoforge:ingredient_type": "neoforge:difference", "base": "#c:ingots", "subtracted": "minecraft:iron_ingot"}]}""");
		assertTrue(NeoForgeIngredientJson.mentions(recipe));
		NeoForgeIngredientJson.rewrite(recipe);
		assertEquals(json("""
				{"type": "minecraft:crafting_shapeless", "ingredients": [
				  {"base": "#c:ingots", "subtracted": "minecraft:iron_ingot", "fabric:type": "fabric:difference"}]}"""), recipe);
	}

	@Test
	void nestedCompoundAndIntersectionAreRewritten() {
		JsonObject ingredient = json("""
				{"neoforge:ingredient_type": "neoforge:compound", "children": [
				  {"neoforge:ingredient_type": "neoforge:intersection", "children": ["#c:a", "#c:b"]}, "minecraft:stone"]}""");
		NeoForgeIngredientJson.rewrite(ingredient);
		assertEquals(json("""
				{"fabric:type": "fabric:any", "ingredients": [
				  {"fabric:type": "fabric:all", "ingredients": ["#c:a", "#c:b"]}, "minecraft:stone"]}"""), ingredient);
	}

	@Test
	void componentsBecomeFabricComponentsWithoutStrict() {
		JsonObject ingredient = json("""
				{"neoforge:ingredient_type": "neoforge:components", "items": "minecraft:potion", "components": {"minecraft:damage": 1}, "strict": true}""");
		NeoForgeIngredientJson.rewrite(ingredient);
		assertEquals(json("""
				{"fabric:type": "fabric:components", "base": "minecraft:potion", "components": {"minecraft:damage": 1}}"""), ingredient);
	}

	@Test
	void unknownTypesAndPlainDataAreLeftAlone() {
		JsonObject unknown = json("""
				{"neoforge:ingredient_type": "neoforge:block_tag", "tag": "minecraft:logs"}""");
		NeoForgeIngredientJson.rewrite(unknown);
		assertEquals(json("""
				{"neoforge:ingredient_type": "neoforge:block_tag", "tag": "minecraft:logs"}"""), unknown);
		assertFalse(NeoForgeIngredientJson.mentions(json("{\"item\": \"minecraft:stone\"}")));
	}
}
