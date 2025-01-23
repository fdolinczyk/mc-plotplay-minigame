package pl.warchamer12.minigame.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import pl.warchamer12.minigame.Utils.TeleportUtil;
import pl.warchamer12.minigame.Utils.Util;

public class LobbyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        if (!player.hasPermission("minigame.lobby")) {
            player.sendMessage("&cBrak uprawnien do wykonania tej komendy!");
        }

        for (int i = 0; i < 4; ++i) {
            player.sendMessage(Util.fixColor(" "));
        }

        TeleportUtil.teleportToLobby(player);
        return false;
    }

}
