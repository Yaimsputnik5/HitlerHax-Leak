package mod.hitlerhax.module.modules.hud;

import mod.hitlerhax.module.Category;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.setting.settings.BooleanSetting;

public class Hud extends Module {

	final BooleanSetting watermark = new BooleanSetting("Watermark", this, true);
	final BooleanSetting arraylist = new BooleanSetting("ArrayList", this, false);
	final BooleanSetting coords = new BooleanSetting("Coordinates", this, false);
	final BooleanSetting fps = new BooleanSetting("FPS", this, false);
	final BooleanSetting armor = new BooleanSetting("Armor", this, false);
	final BooleanSetting welcome = new BooleanSetting("Welcome", this, false);


	public Hud() {
		super("Hud", "In-Game Overlay", Category.HUD);

		addSetting(watermark);
		addSetting(arraylist);
		addSetting(coords);
		addSetting(fps);
		addSetting(armor);
		addSetting(welcome);
		
	}
}
