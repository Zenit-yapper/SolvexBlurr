package dev.astreal.solvexblur.gui;

import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;
import dev.astreal.solvexblur.SolvexBlurClient;

public class BlurSlider extends SliderWidget {

    public BlurSlider(int x, int y, int w, int h) {
        super(x, y, w, h, Text.literal("Strength"), SolvexBlurClient.CONFIG.intensity);
    }

    @Override
    protected void updateMessage() {
        setMessage(Text.literal("Strength: " + String.format("%.2f", SolvexBlurClient.CONFIG.intensity)));
    }

    @Override
    protected void applyValue() {
        SolvexBlurClient.CONFIG.intensity = (float) this.value;
    }
}
