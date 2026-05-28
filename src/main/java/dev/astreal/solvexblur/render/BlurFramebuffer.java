package dev.astreal.solvexblur.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;

public class BlurFramebuffer {

    public static Framebuffer previous;
    public static Framebuffer current;

    public static void init() {
        MinecraftClient mc = MinecraftClient.getInstance();

        int w = mc.getWindow().getFramebufferWidth();
        int h = mc.getWindow().getFramebufferHeight();

        previous = new Framebuffer(w, h, true);
        current = new Framebuffer(w, h, true);
    }

    public static void resize(int w, int h) {
        previous.resize(w, h, false);
        current.resize(w, h, false);
    }

    public static void swap() {
        Framebuffer temp = previous;
        previous = current;
        current = temp;
    }
}
