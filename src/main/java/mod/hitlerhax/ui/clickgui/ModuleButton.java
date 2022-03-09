package mod.hitlerhax.ui.clickgui;

import mod.hitlerhax.module.Module;
import mod.hitlerhax.util.font.FontUtils;
import mod.hitlerhax.util.render.ColorUtil;
import net.minecraft.client.Minecraft;

public class ModuleButton {
	public final int x;
	public int y;
	public final int width;
	public final int height;

	public final Module module;

	final ClickGuiFrame parent;

	final Minecraft mc = Minecraft.getMinecraft();

	public ModuleButton(Module module, int x, int y, ClickGuiFrame parent) {
		this.module = module;
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.width = parent.width;
		this.height = 14;
	}

	public void draw(int mouseX, int mouseY) {
		if (module.toggled) {
			FontUtils.drawString(module.getName(), x + 2, y + 2, new ColorUtil(255, 150, 50));
		} else {
			FontUtils.drawString(module.getName(), x + 2, y + 2, new ColorUtil(180, 240, 255));
		}

	}

	public void onClick(int x, int y, int button) {
		if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height) {
			module.toggle();
		}
	}
}
