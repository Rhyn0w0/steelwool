# Testing SteelWool

SteelWool is a Fabric mod that loads NeoForge mods from a `mods/neoforge/` folder. This bundle has everything you need to try it in a normal Minecraft install.

## What's in this bundle

```
INSTRUCTIONS.md                     this file
fabric-installer-<version>.jar      installs Fabric Loader
mods/
  steelwool-<version>.jar           SteelWool
  fabric-api-<version>.jar          Fabric API (SteelWool needs it)
  neoforge/
    steelwool_testmod-<version>.jar a small NeoForge mod to test with
```

The test mod is a real NeoForge mod, built with NeoForge's own tooling. It adds:

- a block (**Test Block**) and an edible item (**Test Item**)
- a creative tab (**SteelWool Test Mod**), and the Test Block in the Building Blocks tab
- a config file, `config/steelwool_testmod-local.toml`
- a recipe: 1 dirt → 1 Test Item (crafting grid)
- a command: `/steelwooltest`

## Requirements

- Minecraft **Java Edition 26.3**
- Java **25**. The official Minecraft launcher ships it, so you only need it separately for a dedicated server.

## Option A: singleplayer (client)

1. **Install Fabric Loader.** Double-click `fabric-installer-*.jar`, or run `java -jar fabric-installer-*.jar`. Choose the **Client** tab, Minecraft **26.3**, Loader **0.20.1** or newer, and click **Install**.
2. **Open your game folder.** In the Minecraft launcher, the new **fabric-loader-26.3** installation uses `.minecraft` by default:
   - Windows: `%APPDATA%\.minecraft`
   - macOS: `~/Library/Application Support/minecraft`
   - Linux: `~/.minecraft`

   Using a separate **game directory** for this installation (Installations → Edit → Game directory) keeps it apart from your normal game.
3. **Copy this bundle's `mods` folder** into the game folder, merging it with any existing `mods` folder. You should end up with `mods/steelwool-*.jar`, `mods/fabric-api-*.jar` and `mods/neoforge/steelwool_testmod-*.jar`.
4. **Start** the fabric-loader-26.3 installation from the launcher.

## Option B: dedicated server

1. Make an empty folder and run `java -jar fabric-installer-*.jar server -mcversion 26.3 -downloadMinecraft` in it.
2. Copy this bundle's `mods` folder into it.
3. Run `java -jar fabric-server-launch.jar nogui` once and accept the EULA by setting `eula=true` in `eula.txt`. Then run it again.

## What to check

Tick off what works and note anything that doesn't.

**Startup (`logs/latest.log`)**

- [ ] `Found 1 NeoForge mod(s) in …/mods/neoforge: [steelwool_testmod 1.0.0]`
- [ ] `HELLO FROM COMMON SETUP` and `The magic number is... 42`
- [ ] The game reaches the title screen (client) or prints `Done` (server) without crashing.

**In game**

- [ ] A **SteelWool Test Mod** creative tab exists. It may be on a later tab page; use the arrows next to the tabs. It contains the Test Item.
- [ ] The **Building Blocks** tab contains the **Test Block**.
- [ ] Item names show as "Test Item" / "Test Block", not as `item.steelwool_testmod.test_item`. This checks that the NeoForge mod's language file loaded.
- [ ] You can place the Test Block and eat the Test Item.
- [ ] Crafting 1 dirt gives 1 Test Item. This checks that the NeoForge mod's data pack loaded.
- [ ] `/steelwooltest` replies **"Hello from a NeoForge mod running on Fabric!"**
- [ ] `config/steelwool_testmod-local.toml` exists. Change `magicNumber`, restart, and the log shows the new number.

**Expected for now (not bugs)**

- The Test Block and Test Item show the purple/black "missing texture" look. The test mod ships no textures or models.
- The log warns `Missing model for variant: 'Block{steelwool_testmod:test_block}'`. That's for the same reason.

## Trying other NeoForge mods

Put any NeoForge **26.3** mod jar in `mods/neoforge/`. Most mods will not load yet: SteelWool only implements part of NeoForge so far (see the "What is supported" table in the project README).

If a mod needs something missing, the game stops with a message such as:

```
NeoForge mod 'somemod' failed to load: ... It uses NeoForge API 'net.neoforged....', which SteelWool does not support yet
```

That message tells us what to add next.

## Reporting results

For each problem, send:

1. what you did and what happened
2. `logs/latest.log`, and the newest file in `crash-reports/` if the game crashed
3. the list of jars in `mods/` and `mods/neoforge/`
