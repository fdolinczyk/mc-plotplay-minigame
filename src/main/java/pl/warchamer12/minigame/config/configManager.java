package pl.warchamer12.minigame.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import pl.warchamer12.minigame.Minigame;

import java.io.*;

public class configManager {


    static configManager INSTANCE;

    public static File file;

    private Plugin plugin;
    private FileConfiguration fileConfiguration;

    static {
        INSTANCE = new configManager();
    }

    public static configManager getInstance() {
        return INSTANCE;
    }

    public void createFile(Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        File pathFile = new File(plugin.getDataFolder() + File.separator + "/MYSQL");
        file = new File(pathFile, File.separator + "mysqlconfig.yml");

        if (!file.exists()) {
            try {
                pathFile.mkdirs();
                file.createNewFile();
            } catch (IOException exception) {
                System.out.println("Nie udalo sie utworzyc pliku konfiguracyjnego.");
                exception.printStackTrace();
            }
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    public void saveConfiguration() {
        try {
            fileConfiguration.save(file);
        } catch (IOException exception) {
            System.out.println("Nie udalo sie zapisac pliku konfiguracyjnego.");
            exception.printStackTrace();
        }
    }

    public void reloadConfiguration() {
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public void loadConfiguration(Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        file = new File(plugin.getDataFolder(), "mysqlconfig.yml");

        if (!file.exists()) {
            try {
                InputStream inputStream = Minigame.getInstance().getResource(file.getName());
                OutputStream outputStream = new FileOutputStream(file);

                int read;
                byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != 1) {
                    outputStream.write(bytes, 0, read);
                }
                inputStream.close();
                outputStream.flush();
                outputStream.close();
            } catch (IOException exception) {
                System.out.println("Nie udalo sie zaladowac pliku konfiguracyjnego.");
                exception.printStackTrace();
            }
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
        saveConfiguration();
    }

}
