package dev.astreal.solvexblur.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import dev.astreal.solvexblur.SolvexBlurClient;

public class BlurScreen extends Screen {

    public BlurScreen() {
        super(Text.literal("Solvex Blur"));
    }

    @Override
    protected void init() {

        addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Blur: " + (SolvexBlurClient.CONFIG.enabled ? "ON" : "OFF")),
                        b -> SolvexBlurClient.CONFIG.enabled = !SolvexBlurClient.CONFIG.enabled
                ).position(width / 2 - 60, height / 2 - 20)
                 .size(120, 20)
                 .build()
        );

        addDrawableChild(new BlurSlider(width / 2 - 60, height / 2 + 10, 120, 20));
    }
}
