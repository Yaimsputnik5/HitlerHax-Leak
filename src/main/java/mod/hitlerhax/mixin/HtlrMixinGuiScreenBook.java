package mod.hitlerhax.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import mod.hitlerhax.Main;
import mod.hitlerhax.module.modules.utilities.BookWriter;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.nbt.NBTTagList;

@Mixin(value = GuiScreenBook.class, priority = Integer.MAX_VALUE)
public abstract class HtlrMixinGuiScreenBook extends HtlrMixinGuiScreen {

	@Shadow
	private int currPage;

	@Shadow
	private NBTTagList bookPages;

	@Shadow
	private boolean bookIsModified;

	@Shadow
	@Final
	private boolean bookIsUnsigned;

	@Inject(method = "initGui", at = @At("NEW"))
	public void initGui(CallbackInfo info) {
		if (this.bookIsUnsigned) {

			((BookWriter) Main.moduleManager.getModule("BookWriter")).addButtons(this.getWidth());
			this.addButton(((BookWriter) Main.moduleManager.getModule("BookWriter")).read);
			this.addButton(((BookWriter) Main.moduleManager.getModule("BookWriter")).reset);
			this.addButton(((BookWriter) Main.moduleManager.getModule("BookWriter")).write);
		}
	}

	@Inject(method = "actionPerformed", at = @At("RETURN"))
	protected void actionPerformed(GuiButton button, CallbackInfo info) {
		((BookWriter) Main.moduleManager.getModule("BookWriter")).actionPerformed(button, this.bookPages, this.currPage,
				this.bookIsModified);
	}

	@Inject(method = "drawScreen", at = @At("RETURN"))
	public void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo info) {
		((BookWriter) Main.moduleManager.getModule("BookWriter")).drawScreen(this.bookIsUnsigned, this.getWidth(),
				this.getHeight(), mouseX, mouseY, partialTicks);
	}

	@Inject(method = "updateButtons", at = @At("HEAD"))
	private void updateButtons(CallbackInfo info) {
		((BookWriter) Main.moduleManager.getModule("BookWriter")).updateButtons(this.bookIsUnsigned);
	}

}
