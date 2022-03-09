package mod.hitlerhax.module.modules.client;

import java.awt.Font;

import mod.hitlerhax.Main;
import mod.hitlerhax.module.Category;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.setting.settings.ModeSetting;
import mod.hitlerhax.util.font.HtlrFontRenderer;

public class ClientFont extends Module {
	public ModeSetting font = new ModeSetting("font", this, "Comic Sans Ms", "Comic Sans Ms", "Arial", "Verdana");

	public ClientFont() {
		super("ClientFont", "changes the font the client uses.", Category.CLIENT);
		this.addSetting(font);
	}

	@Override
	public void onEnable() {
		if (font.is("Comic Sans Ms")) {
			Main.customFontRenderer = new HtlrFontRenderer(new Font("Comic Sans MS", Font.PLAIN, 18), true, true);
		}

		if (font.is("Arial")) {
			Main.customFontRenderer = new HtlrFontRenderer(new Font("Arial", Font.PLAIN, 18), true, true);
		}

		if (font.is("Verdana")) {
			Main.customFontRenderer = new HtlrFontRenderer(new Font("Verdana", Font.PLAIN, 18), true, true);
		}
	}
}