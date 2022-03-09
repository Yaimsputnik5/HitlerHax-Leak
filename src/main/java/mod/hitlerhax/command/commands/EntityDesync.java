package mod.hitlerhax.command.commands;

import mod.hitlerhax.Client;
import mod.hitlerhax.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class EntityDesync extends Command {

	@Override
	public String getAlias() {
		return "entitydesync";
	}

	@Override
	public String getDescription() {
		return "Desyncs with riding entity";
	}

	@Override
	public String getSyntax() {
		return ".entitydesync set | .entitydesync remount | .entitydesync dismount";
	}

	Entity e;

	@Override
	public void onCommand(String command, String[] args) {
		if (args[0].isEmpty()) {
			Client.addChatMessage("No arguments found");
			Client.addChatMessage(this.getSyntax());
		} else {
			switch (args[0]) {
			case "set":
				this.e = Minecraft.getMinecraft().player.ridingEntity;
				break;
			case "remount":
				if (e != null)
					Minecraft.getMinecraft().player.startRiding(e, true);
				else
					Client.addChatMessage("You must set the riding entity");
				Client.addChatMessage(this.getSyntax());
				break;
			case "dismount":
				Minecraft.getMinecraft().player.dismountRidingEntity();
				break;
			}
		}

	}
}
