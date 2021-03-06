package mod.hitlerhax;

import mod.hitlerhax.command.CommandManager;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.ui.clickgui.ClickGuiController;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

//class to interact with the client

public class Client {

	public static final String commandPrefix = ".";

	public static String getCommandPrefix() {
		return commandPrefix;
	}

	public Client() {
		new CommandManager();
	}

	public static void addChatMessage(String s, boolean doPrefixture) {
		String prefixture;
		if (doPrefixture) {
			prefixture = "\247b[HitlerHax]: ";
		} else {
			prefixture = "";
		}
		Minecraft.getMinecraft().player.sendMessage(new TextComponentString(prefixture + s));
	}

	public static void addChatMessage(String s) {
		Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247b[HitlerHax]: " + s));
	}

	public static volatile boolean getNextKeyPressForKeybinding = false;

	public static Module keybindModule;

	public static void waitForKeybindKeypress(Module m) {
		keybindModule = m;
		getNextKeyPressForKeybinding = true;
	}

	public static void stopWaitForKeybindPress() {
		getNextKeyPressForKeybinding = false;
		keybindModule = null;
		ClickGuiController.INSTANCE.settingController.refresh(false);
	}
}
