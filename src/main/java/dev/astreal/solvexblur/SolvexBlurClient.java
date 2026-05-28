package dev.astreal.solvexblur;

import net.fabricmc.api.ClientModInitializer;
import dev.astreal.solvexblur.render.BlurRenderer;
import dev.astreal.solvexblur.input.Keybinds;

public class SolvexBlurClient implements ClientModInitializer {

    public static BlurConfig CONFIG = new BlurConfig();

    @Override
    public void onInitializeClient() {
        BlurRenderer.init();
        Keybinds.init(); // R-SHIFT GUI
    }
}
