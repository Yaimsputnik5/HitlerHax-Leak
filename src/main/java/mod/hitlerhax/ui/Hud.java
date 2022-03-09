package mod.hitlerhax.ui;

import mod.hitlerhax.Main;
import mod.hitlerhax.setting.settings.BooleanSetting;
import mod.hitlerhax.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud extends Gui {

	private final Minecraft mc = Minecraft.getMinecraft();



	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		if (Main.moduleManager.getModule("Hud").toggled) {
			FontRenderer fr = mc.fontRenderer;

			if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
				if (((BooleanSetting) Main.settingManager.getSettingByName(Main.moduleManager.getModule("Hud"),
						"Watermark")).enabled)
					fr.drawStringWithShadow("ImpHack Revised " + Reference.RELEASE_VERSION, 2, 1, 0xa600ff);

			}
		}
	}
}

