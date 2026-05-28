package dev.astreal.solvexblur.input;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import dev.astreal.solvexblur.gui.BlurScreen;

public class Keybinds {

    public static KeyBinding openGui;

    public static void init() {
        openGui = new KeyBinding(
                "Open Solvex Blur",
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "SolvexBlur"
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openGui.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new BlurScreen());
            }
        });
    }
}
