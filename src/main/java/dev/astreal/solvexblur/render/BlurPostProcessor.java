package dev.astreal.solvexblur.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.util.Window;
import dev.astreal.solvexblur.SolvexBlurClient;

public class BlurPostProcessor {

    private static MinecraftClient mc = MinecraftClient.getInstance();
    private static ShaderProgram shader;

    public static void setShader(ShaderProgram program) {
        shader = program;
    }

    public static void render() {
        if (!SolvexBlurClient.CONFIG.enabled) return;
        if (mc.world == null) return;
        if (shader == null) return;

        float intensity = SolvexBlurClient.CONFIG.intensity;

        // Swap frames BEFORE rendering
        BlurFramebuffer.swap();

        Window window = mc.getWindow();

        RenderSystem.enableBlend();

        // Bind shader
        shader.bind();

        shader.getUniform("Intensity").set(intensity);

        // Bind textures
        mc.getFramebuffer().beginRead();
        BlurFramebuffer.previous.beginRead();

        // Draw fullscreen quad (THIS is what makes blur appear)
        drawFullscreenQuad();

        RenderSystem.disableBlend();
    }

    private static void drawFullscreenQuad() {
        // Minecraft handles quad rendering internally via framebuffer draw
        mc.getFramebuffer().draw(window.getFramebufferWidth(), window.getFramebufferHeight());
    }
}
