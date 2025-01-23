package pl.warchamer12.minigame.Utils;

import org.bukkit.ChatColor;

public class Util {

    public static String fixColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
