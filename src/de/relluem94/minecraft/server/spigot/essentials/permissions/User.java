package de.relluem94.minecraft.server.spigot.essentials.permissions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.relluem94.minecraft.server.spigot.essentials.RelluEssentials;
import de.relluem94.minecraft.server.spigot.essentials.permissions.groups.UserGroup;
import de.relluem94.minecraft.server.spigot.essentials.skills.RepairSkill;
import de.relluem94.minecraft.server.spigot.essentials.skills.SalvageSkill;
import de.relluem94.minecraft.server.spigot.essentials.skills.TreeFellerSkill;

public class User {
	private Player p;
	private Group g;
	

	
	
	public RepairSkill repair = new RepairSkill(RelluEssentials.board);
	public SalvageSkill salvage = new SalvageSkill(RelluEssentials.board);
	public TreeFellerSkill treeFeller = new TreeFellerSkill(RelluEssentials.board);
	
	
	private static FileConfiguration config = Bukkit.getPluginManager().getPlugin("RelluEssentials").getConfig();
	public static List<User> users = new ArrayList<User>();
	
	public User(Player p, Group g) {
		this.p = p;
		setGroup(g);
		users.add(this);
	}
	
	public User(Player p, String g) {
		this.p = p;
		setGroup(Group.getGroupFromName(g));
		users.add(this);
	}

	public Group getGroup() {
		return g;
	}

	public Player getPlayer() {
		return p;
	}

	public void setGroup(Group g) {
		this.g = g;
		config.set("player." + p.getUniqueId() + ".group" , g.getName());
		p.setCustomName(g.getPrefix() +  getCustomName(p));
		p.setScoreboard(RelluEssentials.board);
		g.getTeam().addEntry(p.getName());
	}
	
	public static Group getGroup(Player p) {
		if(config.getString("player." + p.getUniqueId() + ".group") != null) {
			return  Group.getGroupFromName(config.getString("player." + p.getUniqueId() + ".group"));
		}
		else {
			return new UserGroup();
		}
	}
	
	public static User getUserByPlayerName(String name) {
		for(User u: users) {
			if(u.getPlayer().getName().equalsIgnoreCase(name)) {
				return u;
			}
		}
		return null;
	}
	
	public static void removeUser(String name) {
		users.remove(getUserByPlayerName(name));
	}
	
	private String getCustomName(Player p) {
		String name = "";
		if(config.get("player." + p.getUniqueId() + ".customname") != null) {
			name += config.get("player." + p.getUniqueId() + ".customname");
		}
		else {
			name += p.getName();
		}
		
		return name;
	}
}
