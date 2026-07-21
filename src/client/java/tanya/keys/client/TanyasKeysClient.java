package tanya.keys.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class TanyasKeysClient implements ClientModInitializer {

	public static final String MOD_ID = "tanyaskeys";

	private static final Identifier HUD_ID = Identifier.fromNamespaceAndPath(MOD_ID, "wasd_display");

	private static final int COLOR_IDLE = 0xAA202020;
	private static final int COLOR_PRESSED = 0xFF55FF55;
	private static final int COLOR_BORDER = 0xFFFFFFFF;
	private static final int COLOR_TEXT = 0xFFFFFFFF;

	private static final int KEY_SIZE = 20;
	private static final int GAP = 2;

	@Override
	public void onInitializeClient() {
		HudElementRegistry.addLast(HUD_ID, TanyasKeysClient::render);
	}

	private static void render(GuiGraphicsExtractor graphics, DeltaTracker tickCounter) {
		Minecraft mc = Minecraft.getInstance();

		var options = mc.options;

		int totalWidth = (KEY_SIZE + GAP) * 3 - GAP;
		int totalHeight = KEY_SIZE * 3 + GAP * 2;

		int margin = 12;
		int baseX = mc.getWindow().getGuiScaledWidth() - totalWidth - margin;
		int baseY = margin;

		int spaceWidth = totalWidth;

		drawKey(graphics, mc.font, "W", baseX + KEY_SIZE + GAP, baseY, KEY_SIZE, KEY_SIZE, options.keyUp);
		drawKey(graphics, mc.font, "A", baseX, baseY + KEY_SIZE + GAP, KEY_SIZE, KEY_SIZE, options.keyLeft);
		drawKey(graphics, mc.font, "S", baseX + KEY_SIZE + GAP, baseY + KEY_SIZE + GAP, KEY_SIZE, KEY_SIZE, options.keyDown);
		drawKey(graphics, mc.font, "D", baseX + (KEY_SIZE + GAP) * 2, baseY + KEY_SIZE + GAP, KEY_SIZE, KEY_SIZE, options.keyRight);
		drawKey(graphics, mc.font, "SPACE", baseX, baseY + (KEY_SIZE + GAP) * 2, spaceWidth, KEY_SIZE, options.keyJump);
		
	}

	private static void drawKey(GuiGraphicsExtractor graphics, Font font, String label, int x, int y, int width, int height, KeyMapping key) {
		boolean pressed = key.isDown();
		int bg = pressed ? COLOR_PRESSED : COLOR_IDLE;

		graphics.fill(x, y, x + width, y + height, bg);
		graphics.outline(x, y, width, height, COLOR_BORDER);

		int textWidth = font.width(label);
		graphics.text(font, label, x + (width - textWidth) / 2, y + (height - font.lineHeight) / 2, COLOR_TEXT, false);
	}
}