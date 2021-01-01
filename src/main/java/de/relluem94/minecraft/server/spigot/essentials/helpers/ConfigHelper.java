package de.relluem94.minecraft.server.spigot.essentials.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import de.relluem94.minecraft.server.spigot.essentials.RelluEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author rellu
 */
public class ConfigHelper {

    private String name;
    private File file;
    private YamlConfiguration config;

    public ConfigHelper(String name) throws IOException {
        this.name = name;

        file = new File(RelluEssentials.dataFolder, name + ".yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            config = new YamlConfiguration();
            config.options().header("Configuration File - " + name);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Returns the Config Name
     * @return String Config Name
     */
    public String getConfigName() {
        return name;
    }

    /**
     * Returns the File
     * @return File
     */
    public File getFile() {
        return file;
    }

    /**
     * Returns the Config
     * @return YamlConfiguration
     */
    public YamlConfiguration getConfig() {
        return config;
    }

    /**
     * Saves the Config
     * @throws IOException 
     */
    public void save() throws IOException {
        config.save(file);
    }

    /**
     * Reloads the Config 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws InvalidConfigurationException 
     */
    public void reload() throws IOException, FileNotFoundException, InvalidConfigurationException {
        config.load(file);
    }

    /**
     * 
     * @param path where the Location gets saved
     * @param l the Location it self
     */
    public void setLocation(String path, Location l) {
        config.set(path + ".x", l.getX());
        config.set(path + ".y", l.getBlockY());
        config.set(path + ".z", l.getBlockZ());
        config.set(path + ".yaw", l.getYaw());
        config.set(path + ".pitch", l.getPitch());
        config.set(path + ".world", l.getWorld().getName());
    }

    /**
     * 
     * @param path where the Location is saved
     * @return Location from the Config Path
     */
    public Location getLocation(String path) {
        double x, y, z;
        float yaw, pitch;
        String world;
        x = config.getDouble(path + ".x");
        y = config.getDouble(path + ".y");
        z = config.getDouble(path + ".z");
        yaw = (float) config.getDouble(path + ".yaw");
        pitch = (float) config.getDouble(path + ".pitch");
        world = config.getString(path + ".world");

        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

}
