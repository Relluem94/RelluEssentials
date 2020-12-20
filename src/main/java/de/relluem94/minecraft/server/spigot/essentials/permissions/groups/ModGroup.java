package main.java.de.relluem94.minecraft.server.spigot.essentials.permissions.groups;

import main.java.de.relluem94.minecraft.server.spigot.essentials.permissions.Group;
import main.java.de.relluem94.minecraft.server.spigot.essentials.permissions.enums.Groups;

public class ModGroup extends Group {

    public ModGroup() {
        super(Groups.MOD.getName(), Groups.MOD.getId(), Groups.MOD.getPrefix());
        getTeam().setCanSeeFriendlyInvisibles(true);
    }

}
