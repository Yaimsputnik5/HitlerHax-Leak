package mod.hitlerhax;

import mod.hitlerhax.command.CommandManager;
import mod.hitlerhax.config.Config;
import mod.hitlerhax.event.HtlrEventBus;
import mod.hitlerhax.event.HtlrEventHandler;
import mod.hitlerhax.event.HtlrEventManager;
import mod.hitlerhax.module.ModuleManager;
import mod.hitlerhax.module.modules.hud.HudArmor;
import mod.hitlerhax.module.modules.hud.HudArrayList;
import mod.hitlerhax.module.modules.hud.HudCoords;
import mod.hitlerhax.module.modules.hud.HudFPS;
import mod.hitlerhax.module.modules.hud.HudWatermark;
import mod.hitlerhax.module.modules.hud.HudWelcome;
import mod.hitlerhax.setting.SettingManager;
import mod.hitlerhax.sound.SongManager;
import mod.hitlerhax.ui.clickgui.ClickGuiController;
import mod.hitlerhax.util.Reference;
import mod.hitlerhax.util.font.HtlrFontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//main class, contains all event handlers etc.

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.RELEASE_VERSION)
@SideOnly(Side.CLIENT)
public class Main {

	public static long startTimeStamp = 0;
	public static HtlrFontRenderer customFontRenderer;

	final Minecraft mc = Minecraft.getMinecraft();

	public static ModuleManager moduleManager;
	public static Config config;

	public static final HudCoords hudCoords = new HudCoords();
	public static final HudArrayList hudArrayList = new HudArrayList();
	public static final HudWatermark hudVersion = new HudWatermark();
	public static final HudFPS hudFps = new HudFPS();
	public static final HudArmor hudArmor = new HudArmor();
	public static final HudWelcome hudWelcome = new HudWelcome();

	public static CommandManager cmdManager;
	public static SettingManager settingManager;
	public static HtlrEventManager eventManager;
	public static SongManager songManager;
	private static ClickGuiController gui;
	public static boolean configLoaded = false;

	@Instance
	public Main instance;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		if (event.getSide() == Side.SERVER)
			return;

		HtlrEventHandler.INSTANCE = new HtlrEventHandler();

		// register HUD
		MinecraftForge.EVENT_BUS.register(instance);
		MinecraftForge.EVENT_BUS.register(hudCoords);
		MinecraftForge.EVENT_BUS.register(hudArrayList);
		MinecraftForge.EVENT_BUS.register(hudVersion);
		MinecraftForge.EVENT_BUS.register(hudFps);
		MinecraftForge.EVENT_BUS.register(hudArmor);
		MinecraftForge.EVENT_BUS.register(hudWelcome);

		moduleManager = new ModuleManager();
		cmdManager = new CommandManager();
		settingManager = new SettingManager();
		eventManager = new HtlrEventManager();
		songManager = new SongManager();
		config = new Config();
		config.Load();
		configLoaded = true;

		MinecraftForge.EVENT_BUS.register(eventManager);

		HtlrEventBus.EVENT_BUS.subscribe(eventManager);

		startTimeStamp = System.currentTimeMillis();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (event.getSide() == Side.SERVER)
			return;
		Main.moduleManager.getModule("ClientFont").toggle();
		Main.moduleManager.getModule("ClientFont").toggle();
	}

	public static ClickGuiController getGui() {
		return gui;
	}

	public static HtlrEventHandler get_event_handler() {
		return HtlrEventHandler.INSTANCE;
	}
}
