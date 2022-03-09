package mod.hitlerhax.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

@Mixin(GuiScreen.class)
public abstract class HtlrMixinGuiScreen {
	@Shadow
	public List<GuiButton> buttonList;

	@Shadow
	public int width;

	@Shadow
	public int height;

	@Shadow
	public FontRenderer fontRenderer;

	@Shadow
	protected abstract <T extends GuiButton> T addButton(T buttonIn);

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}
