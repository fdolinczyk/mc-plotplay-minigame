package pl.warchamer12.minigame.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import pl.warchamer12.minigame.Minigame;
import pl.warchamer12.minigame.Utils.Util;
import pl.warchamer12.minigame.config.configManager;
import pl.warchamer12.minigame.listeners.MinigameStart;

public class JoinMinigameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        if (!player.hasPermission("minigame.join")) {
            player.sendMessage(Util.fixColor("&cBrak uprawnien do wykonania tej komendy!"));
        }

        if (Minigame.objects.players.size() > 30) {
            if (Minigame.objects.players.contains(player)) {
                Minigame.objects.removePlayerFromQUEUE(player);
            }
            player.sendMessage(Util.fixColor("&c&lGra jest aktualnie pe³na!!"));
            return true;
        } else if (Minigame.objects.players.size() < 30) {
            Minigame.objects.addPlayerToQUEUE(player);

            //teleport
            World world = Bukkit.getWorld(configManager.getInstance().getFileConfiguration().getString("queue.world"));
            double x = configManager.getInstance().getFileConfiguration().getInt("queue.x");
            double y = configManager.getInstance().getFileConfiguration().getInt("queue.y");
            double z = configManager.getInstance().getFileConfiguration().getInt("queue.z");
            player.teleport(new Location(world, x, y, z));

            MinigameStart.start();
        }
        return false;
    }

}
