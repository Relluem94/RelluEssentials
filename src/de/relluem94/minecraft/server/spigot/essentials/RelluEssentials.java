package de.relluem94.minecraft.server.spigot.essentials;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.relluem94.minecraft.server.spigot.essentials.commands.Cookies;
import de.relluem94.minecraft.server.spigot.essentials.commands.Day;
import de.relluem94.minecraft.server.spigot.essentials.commands.Enderchest;
import de.relluem94.minecraft.server.spigot.essentials.commands.Fly;
import de.relluem94.minecraft.server.spigot.essentials.commands.GameMode;
import de.relluem94.minecraft.server.spigot.essentials.commands.Inventory;
import de.relluem94.minecraft.server.spigot.essentials.commands.Nick;
import de.relluem94.minecraft.server.spigot.essentials.commands.Night;
import de.relluem94.minecraft.server.spigot.essentials.commands.PermissionsGroup;
import de.relluem94.minecraft.server.spigot.essentials.commands.PortableCraftingBench;
import de.relluem94.minecraft.server.spigot.essentials.commands.Rain;
import de.relluem94.minecraft.server.spigot.essentials.commands.Spawn;
import de.relluem94.minecraft.server.spigot.essentials.commands.Storm;
import de.relluem94.minecraft.server.spigot.essentials.commands.Suicide;
import de.relluem94.minecraft.server.spigot.essentials.commands.Sun;
import de.relluem94.minecraft.server.spigot.essentials.events.BetterBlockDrop;
import de.relluem94.minecraft.server.spigot.essentials.events.BetterChatFormat;
import de.relluem94.minecraft.server.spigot.essentials.events.BetterMobs;
import de.relluem94.minecraft.server.spigot.essentials.events.BetterPlayerJoin;
import de.relluem94.minecraft.server.spigot.essentials.events.BetterPlayerQuit;
import de.relluem94.minecraft.server.spigot.essentials.events.BetterSavety;
import de.relluem94.minecraft.server.spigot.essentials.events.BetterSoil;
import de.relluem94.minecraft.server.spigot.essentials.events.NoDeathMessage;
import de.relluem94.minecraft.server.spigot.essentials.events.skills.AutoReplant;
import de.relluem94.minecraft.server.spigot.essentials.events.skills.Repair;
import de.relluem94.minecraft.server.spigot.essentials.events.skills.Salvage;
import de.relluem94.minecraft.server.spigot.essentials.events.skills.TreeFeller;
import de.relluem94.minecraft.server.spigot.essentials.permissions.User;




public class RelluEssentials extends JavaPlugin{
	
	private PluginManager pm = this.getServer().getPluginManager();
	
	@Override
	public void onEnable() {
		/*  Config */
		this.saveDefaultConfig();
		
		/*	Commands	*/
		this.getCommand("0").setExecutor(new GameMode());
		this.getCommand("1").setExecutor(new GameMode());
		this.getCommand("2").setExecutor(new GameMode());
		this.getCommand("3").setExecutor(new GameMode());
		this.getCommand("fly").setExecutor(new Fly());
		this.getCommand("cookie").setExecutor(new Cookies());
		this.getCommand("craft").setExecutor(new PortableCraftingBench());
		this.getCommand("sun").setExecutor(new Sun());
		this.getCommand("rain").setExecutor(new Rain());
		this.getCommand("storm").setExecutor(new Storm());
		this.getCommand("spawn").setExecutor(new Spawn());
		this.getCommand("day").setExecutor(new Day());
		this.getCommand("night").setExecutor(new Night());
		this.getCommand("enderchest").setExecutor(new Enderchest());
		this.getCommand("inv").setExecutor(new Inventory());
		this.getCommand("setGroup").setExecutor(new PermissionsGroup());
		this.getCommand("nick").setExecutor(new Nick());
		this.getCommand("suicide").setExecutor(new Suicide());
		
		
		/*	Events	*/
		pm.registerEvents(new BetterChatFormat(), this);
		pm.registerEvents(new BetterPlayerJoin(), this);
		pm.registerEvents(new BetterPlayerQuit(), this);
		pm.registerEvents(new BetterBlockDrop(), this);
		pm.registerEvents(new BetterMobs(), this);
		pm.registerEvents(new BetterSoil(), this);
		pm.registerEvents(new BetterSavety(), this);
		pm.registerEvents(new NoDeathMessage(), this);
		
		/*  Skill Events */
		pm.registerEvents(new Repair(), this);
		pm.registerEvents(new Salvage(), this);
		pm.registerEvents(new TreeFeller(), this);
		pm.registerEvents(new AutoReplant(), this);
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			new User(p, User.getGroup(p));
		}
	}
	
	@Override
	public void onDisable() {
		this.saveConfig();
	}
	

}
