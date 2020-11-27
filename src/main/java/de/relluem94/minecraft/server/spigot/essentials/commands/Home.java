package main.java.de.relluem94.minecraft.server.spigot.essentials.commands;

import static main.java.de.relluem94.minecraft.server.spigot.essentials.Strings.*;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.java.de.relluem94.minecraft.server.spigot.essentials.permissions.Permission;

public class Home implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("home")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (Permission.isAuthorized(p, 1)) {
						p.teleport(p.getBedSpawnLocation());
						p.sendMessage(String.format(PLUGIN_COMMAND_HOME, p.getWorld().getName()));
						return true;
					}
					else {
						p.sendMessage(PLUGIN_COMMAND_PERMISSION_MISSING);
						return true;
					}
				}
			}
			else {
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null) {
					if (sender instanceof Player) {
						Player p = (Player) sender;
						if (Permission.isAuthorized(p, 4)) {
							target.teleport(target.getBedSpawnLocation());
							target.sendMessage(String.format(PLUGIN_COMMAND_HOME, target.getWorld().getName()));
							return true;
						}
						else {
							p.sendMessage(PLUGIN_COMMAND_PERMISSION_MISSING);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}