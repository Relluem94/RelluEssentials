package de.relluem94.minecraft.server.spigot.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static de.relluem94.minecraft.server.spigot.essentials.Strings.*;

public class GameMode implements CommandExecutor {
	 @Override
	 public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (args.length == 0) {
			 if(sender instanceof Player) {
				 Player p = (Player) sender;
				 return gameMode(command, p);
			 }
		 }
		 else {
			 Player target = Bukkit.getPlayer(args[0]);
			 if(target != null) {
				 return gameMode(command, target);
			 }
		 }
		 return false;
	 }
	 
	 
	 private boolean gameMode(Command command, Player p) {
		 if (command.getName().equalsIgnoreCase("0")) {
			 p.setGameMode(org.bukkit.GameMode.SURVIVAL);
			 p.sendMessage(String.format(PLUGIN_COMMAND_GAMEMODE, p.getName(), "Survival"));
			 return true;
		 }
		 else if (command.getName().equalsIgnoreCase("1")) {
			 p.setGameMode(org.bukkit.GameMode.CREATIVE);
			 p.sendMessage(String.format(PLUGIN_COMMAND_GAMEMODE, p.getName(), "Creative"));
			 return true;
		 }
		 else if (command.getName().equalsIgnoreCase("2")) {
			 p.setGameMode(org.bukkit.GameMode.ADVENTURE);
			 p.sendMessage(String.format(PLUGIN_COMMAND_GAMEMODE, p.getName(), "Adventure"));
			 return true;
		 }
		 else if (command.getName().equalsIgnoreCase("3")) {
			 p.setGameMode(org.bukkit.GameMode.SPECTATOR);
			 p.sendMessage(String.format(PLUGIN_COMMAND_GAMEMODE, p.getName(), "Spectator"));
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 
}
