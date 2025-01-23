package pl.warchamer12.minigame.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.warchamer12.minigame.Minigame;
import pl.warchamer12.minigame.Utils.Inventory;
import pl.warchamer12.minigame.Utils.TeleportUtil;
import pl.warchamer12.minigame.Utils.Util;

public class LeaveListener implements Listener {

    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (Minigame.objects.players.contains(player.getName())) {
            Minigame.objects.removePlayerFromQUEUE(player);
        }

        if (Minigame.objects.alphaTeam.contains(player.getName())) {
            Minigame.objects.removePlayerFromAlphaTeam(player);
        }

        if (Minigame.objects.bravoTeam.contains(player.getName())) {
            Minigame.objects.removePlayerFromBravoTeam(player);
        }

        player.sendTitle(Util.fixColor("&c&lPrzegrales!"), "", 1, 40, 1);

        Inventory.inventoryClear(player);
        TeleportUtil.teleportToLobby(player);
    }

}
