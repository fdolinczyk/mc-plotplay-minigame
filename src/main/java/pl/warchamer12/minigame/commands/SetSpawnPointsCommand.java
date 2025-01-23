package pl.warchamer12.minigame.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.warchamer12.minigame.Utils.Util;
import pl.warchamer12.minigame.config.configManager;

public class SetSpawnPointsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        if (!player.hasPermission("minigame.spawnpoints")) {
            player.sendMessage(Util.fixColor("&cBrak uprawnien do wykonania tej komendy!"));
        }
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("blue") || args[1].equalsIgnoreCase("red")) {
                switch (args[1]) {
                    case "1":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "2":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "3":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "4":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "5":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "6":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "7":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "8":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "9":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    case "10":
                        setSpawn(Integer.valueOf(args[1]));
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla: " + args[1]));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + args[1]);
                }
            } else {
                player.sendMessage(Util.fixColor("&c/setspawnpoint [blue/red] <1-10>"));
            }
        }

        return false;
    }

    public void setSpawn(Integer name) {
        World world = Bukkit.getWorld(configManager.getInstance().getFileConfiguration().getString(name + ".world"));
        double x = configManager.getInstance().getFileConfiguration().getInt(name + ".x");
        double y = configManager.getInstance().getFileConfiguration().getInt(name + ".y");
        double z = configManager.getInstance().getFileConfiguration().getInt(name + ".z");
    }

}
