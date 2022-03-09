package mod.hitlerhax.command.commands;

import mod.hitlerhax.Client;
import mod.hitlerhax.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketPlayer;

public class Clip extends Command {
	@Override
	public String getAlias() {
		return "clip";
	}

	@Override
	public String getDescription() {
		return "Sets the player position";
	}

	@Override
	public String getSyntax() {
		return ".clip [x] [y] [z]";
	}

	@Override
	public void onCommand(String command, String[] args) {
		if (args[0].isEmpty() || args[1].isEmpty() || args[2].isEmpty()) {
			Client.addChatMessage("No arguments found");
			Client.addChatMessage(this.getSyntax());
		} else {
			if (Minecraft.getMinecraft().player.ridingEntity == null) {
				Minecraft.getMinecraft().player.setPosition(
						Minecraft.getMinecraft().player.posX + Double.parseDouble(args[0]),
						Minecraft.getMinecraft().player.posY + Double.parseDouble(args[1]),
						Minecraft.getMinecraft().player.posZ + Double.parseDouble(args[2]));
			} else {
				Minecraft.getMinecraft().player.ridingEntity.setPosition(
						Minecraft.getMinecraft().player.ridingEntity.posX + Double.parseDouble(args[0]),
						Minecraft.getMinecraft().player.ridingEntity.posY + Double.parseDouble(args[1]),
						Minecraft.getMinecraft().player.ridingEntity.posZ + Double.parseDouble(args[2]));
			}
			Minecraft.getMinecraft().player.connection
					.sendPacket(new CPacketPlayer.Position(Minecraft.getMinecraft().player.posX,
							Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ, false));
		}
	}
}
