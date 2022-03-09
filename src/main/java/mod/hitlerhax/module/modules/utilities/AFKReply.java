package mod.hitlerhax.module.modules.utilities;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import mod.hitlerhax.event.events.HtlrEventPacket;
import mod.hitlerhax.module.Category;
import mod.hitlerhax.setting.settings.StringSetting;
import net.minecraft.network.play.server.SPacketChat;

public class AFKReply extends mod.hitlerhax.module.Module {
	public AFKReply() {
		super("AFKReply", "replies for you when you are AFK", Category.UTILITIES);
	}

	StringSetting msg = new StringSetting("Message", this, "[HitlerHax AFKReply]: I'm currently AFK!");

	@EventHandler
	private final Listener<HtlrEventPacket.ReceivePacket> PacketRecieveEvent = new Listener<>(event -> {
		if (event.get_packet() instanceof SPacketChat) {
			String m = ((SPacketChat) event.get_packet()).getChatComponent().getFormattedText();
			if (m.contains('\u00A7' + "d") && m.contains("whispers: ")) {
				mc.player.sendChatMessage("/r " + msg.value);
			}
		}
	});
}
