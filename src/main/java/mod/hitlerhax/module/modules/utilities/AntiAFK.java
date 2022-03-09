package mod.hitlerhax.module.modules.utilities;

import mod.hitlerhax.module.Category;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.setting.settings.BooleanSetting;
import mod.hitlerhax.setting.settings.IntSetting;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiAFK extends Module {
	public AntiAFK() {
		super("AntiAFK", "Prevents AFK Kick", Category.UTILITIES);

		addSetting(walk);
		addSetting(rotate);
	}

	BooleanSetting walk = new BooleanSetting("Walk", this, true);
	IntSetting rotate = new IntSetting("Rotate", this, 1);

	@SubscribeEvent
	public void onUpdateInput(final InputUpdateEvent event) {
		if (walk.enabled)
			event.getMovementInput().moveForward = 1.0f;
		mc.player.rotationYaw += rotate.value;
	}
}
