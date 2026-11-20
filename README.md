<img src="assets/icon.svg" width="64" height="64" alt="">

# SteelWool

SteelWool is a [Fabric](https://fabricmc.net/) mod for Minecraft that acts as a **translation layer for [NeoForge](https://neoforged.net/) mods**.

## Goal

When SteelWool is installed and loaded by Fabric, it looks for a `neoforge` folder inside the game's `mods` folder and loads every NeoForge mod in it **as if it were a Fabric mod**. Players can then run NeoForge mods next to their Fabric mods without switching mod loaders.

```
.minecraft/
└── mods/
    ├── steelwool-x.y.z.jar      <- SteelWool (a normal Fabric mod)
    ├── some-fabric-mod.jar      <- loaded by Fabric as usual
    └── neoforge/                <- SteelWool scans this folder
        ├── some-neoforge-mod.jar
        └── another-neoforge-mod.jar
```

## How it should work

1. **Discovery:** at startup, SteelWool finds `mods/neoforge/` and lists the NeoForge mod jars inside it.
2. **Translation:** SteelWool reads each jar's NeoForge metadata (`META-INF/neoforge.mods.toml`) and maps the mod's NeoForge APIs, events, registries and lifecycle hooks onto their Fabric or vanilla counterparts.
3. **Loading:** the translated mods are added to the game as if they were Fabric mods, so they load, register content and run next to native Fabric mods.

## Status

The project is at an early stage. Only the goal is set so far. No code is written yet.

## Contributing / AI agents

If you are an AI coding agent working in this repo, this README is your main source of project context. [AGENTS.md](AGENTS.md) and [CLAUDE.md](CLAUDE.md) both point here.
