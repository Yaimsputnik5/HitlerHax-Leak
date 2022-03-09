package mod.hitlerhax.command;

import java.util.ArrayList;

import mod.hitlerhax.Client;
import mod.hitlerhax.command.commands.Bind;
import mod.hitlerhax.command.commands.Clip;
import mod.hitlerhax.command.commands.EntityDesync;
import mod.hitlerhax.command.commands.Help;
import mod.hitlerhax.command.commands.Login;
import mod.hitlerhax.command.commands.Rotate;
import mod.hitlerhax.command.commands.Say;
import mod.hitlerhax.command.commands.Toggle;

public class CommandManager {
	private final ArrayList<Command> commands;

	public CommandManager() {
		commands = new ArrayList<>();

		// add commands
		addCommand(new Bind());
		addCommand(new Toggle());
		addCommand(new Help());
		addCommand(new Rotate());
		addCommand(new Login());
		addCommand(new Clip());
		addCommand(new EntityDesync());
		addCommand(new Say());
	}

	public void addCommand(Command c) {
		commands.add(c);
	}

	public ArrayList<Command> getCommands() {
		return commands;
	}

	public void callCommand(String input) {

		String[] split = input.split(" ");
		String command = split[0];
		String args = input.substring(command.length()).trim();

		for (Command c : getCommands()) {
			if (c.getAlias().equalsIgnoreCase(command)) {
				try {
					c.onCommand(args, args.split(" "));
				} catch (Exception e) {
					Client.addChatMessage("Invalid command usage");
					Client.addChatMessage(c.getSyntax());
					System.out.println(e.getMessage() + "\n" + e.getStackTrace());// TODO fix .say
				}
				return;
			}
		}
		Client.addChatMessage("no such command exists");
	}
}
