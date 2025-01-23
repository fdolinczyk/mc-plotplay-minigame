package pl.warchamer12.minigame.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import pl.warchamer12.minigame.Minigame;
import pl.warchamer12.minigame.Utils.Inventory;
import pl.warchamer12.minigame.Utils.TeleportUtil;
import pl.warchamer12.minigame.Utils.Util;

public class DeathListener implements Listener {

    public void onPlayerDeath(PlayerDeathEvent event) {
        Player killer = event.getEntity().getPlayer().getKiller();
        Player player = event.getEntity().getPlayer();

        if (Minigame.objects.alphaTeam.contains(player)) {
            Minigame.objects.removePlayerFromAlphaTeam(player);
        }
        if (Minigame.objects.bravoTeam.contains(player)) {
            Minigame.objects.removePlayerFromBravoTeam(player);
        }

        event.getEntity().getPlayer().getWorld().strikeLightningEffect(player.getLocation());
        event.getDrops().clear();

        Bukkit.broadcastMessage(Util.fixColor("&c" + killer.getName() + " zabil gracza " + player.getName()));
        player.sendMessage(Util.fixColor("&cZostales zabity przez: " + killer.getName()));
        player.sendTitle(Util.fixColor("&c&lPrzegrales!"), "", 3, 60, 3);

        Inventory.inventoryClear(player);
        TeleportUtil.teleportToLobby(player);
    }

}
