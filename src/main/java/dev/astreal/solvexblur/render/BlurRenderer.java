package dev.astreal.solvexblur.render;

import net.minecraft.client.MinecraftClient;
import dev.astreal.solvexblur.SolvexBlurClient;

public class BlurRenderer {

    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void init() {
        BlurFramebuffer.init();
    }

    public static void render() {
        if (!SolvexBlurClient.CONFIG.enabled) return;
        if (mc.world == null) return;

        BlurFramebuffer.swap();

        mc.getFramebuffer().beginWrite(false);
        BlurFramebuffer.current.beginWrite(true);

        BlurShader.render(
                BlurFramebuffer.current.texture,
                BlurFramebuffer.previous.texture,
                SolvexBlurClient.CONFIG.intensity
        );
    }
}
