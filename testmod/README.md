# SteelWool test mod

A small NeoForge mod used by SteelWool's game tests (`./gradlew runGameTest` in the repository root).
It follows NeoForge's example mod (MDK) and adds a command, a recipe, a mixin and an
`@EventBusSubscriber` class.

It is a separate Gradle build that uses NeoForge's ModDevGradle plugin, so it is compiled against
NeoForge's patched Minecraft exactly like a real NeoForge mod. The root build includes it with
`includeBuild 'testmod'`.
