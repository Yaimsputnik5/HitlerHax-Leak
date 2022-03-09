package mod.hitlerhax.module.modules.combat;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import mod.hitlerhax.Main;
import mod.hitlerhax.event.HtlrEventBus;
import mod.hitlerhax.event.events.HtlrEventPacket;
import mod.hitlerhax.module.Category;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.module.modules.render.Esp;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;

public class FootEXP extends Module {

	public FootEXP() {
		super("FootEXP", "FootEXP", Category.COMBAT);
		toggled = true;

	}
	public void onEnable() {
		if(((SpeedEXP)Main.moduleManager.getModule("SpeedEXP")).footEXP.isEnabled()) {
			
		
		HtlrEventBus.EVENT_BUS.subscribe(this);
		}
	}
	
	public void onDisable() {
		HtlrEventBus.EVENT_BUS.unsubscribe(this);
	}
	
	@EventHandler
	public Listener<HtlrEventPacket.SendPacket> listener = new Listener<>(event -> {
		if(event.get_packet() instanceof CPacketPlayerTryUseItem && mc.player.getHeldItemMainhand().getItem() instanceof ItemExpBottle) {
			mc.player.connection.sendPacket(new CPacketPlayer.Rotation(mc.player.rotationYaw, 90.0f, mc.player.onGround));
		}
	});

}
