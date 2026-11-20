"""Tests for how compat_check.py explains a failed server start. Run: python3 -m unittest discover compat"""

import unittest

from compat_check import explain


class ExplainTest(unittest.TestCase):
    def test_steelwool_missing_api_message(self):
        output = [
            "Caused by: dev.steelwool.loading.ModLoadingFailure: NeoForge mod 'appleskin' failed to load: its mod class "
            "squeek.appleskin.AppleSkin threw an exception while being constructed. It uses NeoForge API "
            "'net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent', which SteelWool does not support yet",
        ]
        self.assertEqual(explain(output),
                         ("missing-api", "net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent"))

    def test_missing_neoforge_class_outside_mod_construction(self):
        output = [
            "java.lang.RuntimeException: Mixin plugin failed",
            "Caused by: java.lang.NoClassDefFoundError: net/neoforged/fml/loading/FMLLoader",
            "Caused by: java.lang.ClassNotFoundException: net.neoforged.fml.loading.FMLLoader",
        ]
        self.assertEqual(explain(output), ("missing-api", "net.neoforged.fml.loading.FMLLoader"))

    def test_missing_dependency(self):
        output = [
            "dev.steelwool.loading.ModLoadingFailure: SteelWool cannot load the NeoForge mods:",
            " - Mod 'jei' requires 'mezz_config' [0.6.10,1.0.0), which is not installed",
        ]
        self.assertEqual(explain(output),
                         ("dependency", "Mod 'jei' requires 'mezz_config' [0.6.10,1.0.0), which is not installed"))

    def test_mixin_injection_failure_uses_deepest_cause(self):
        output = [
            "Caused by: org.spongepowered.asm.mixin.transformer.throwables.MixinTransformerError: An unexpected critical error was encountered",
            "Caused by: org.spongepowered.asm.mixin.throwables.MixinApplyError: Mixin [ae2.mixins.json:AnvilMenuMixin] FAILED during APPLY",
            "Caused by: org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException: Critical injection failure: "
            "@ModifyExpressionValue could not find any targets matching 'createResultInternal' [INJECT_PREPARE Applicator Phase]",
        ]
        self.assertEqual(explain(output), (
            "mixin",
            "InvalidInjectionException: Critical injection failure: @ModifyExpressionValue could not find any targets "
            "matching 'createResultInternal'"))

    def test_mixin_target_missing(self):
        output = [
            "[23:42:33] [main/ERROR]: Mixin prepare for mod (unknown) failed preparing client.SalmonRendererAccessor in "
            "journeymap.mixins.json: org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException @Mixin target "
            "net.minecraft.client.renderer.entity.SalmonRenderer was not found",
        ]
        category, reason = explain(output)
        self.assertEqual(category, "mixin")
        self.assertIn("SalmonRenderer was not found", reason)

    def test_other_crash_uses_deepest_cause(self):
        output = [
            "java.lang.RuntimeException: Could not execute entrypoint stage 'main'",
            "Caused by: java.lang.IllegalStateException: outer",
            "Caused by: java.nio.file.NoSuchFileException: config/ferritecore-mixin.toml",
        ]
        self.assertEqual(explain(output), ("crash", "NoSuchFileException: config/ferritecore-mixin.toml"))


if __name__ == "__main__":
    unittest.main()
