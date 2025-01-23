package pl.warchamer12.minigame.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import pl.warchamer12.minigame.Minigame;
import pl.warchamer12.minigame.Utils.TeleportUtil;
import pl.warchamer12.minigame.Utils.Util;

public class SnowballListener implements Listener {

    public void onHitPlayer(ProjectileHitEvent event) {
        String s = "snowball";

        Entity shooter = (Entity) event.getEntity().getShooter();
        Player player = (Player) event.getHitEntity();

        if (event.getEntity() instanceof Player) {
            Entity snowball = event.getEntity();
            Location location = snowball.getLocation();
            World world = event.getEntity().getWorld();
            world.createExplosion(location, 1);

            if (Minigame.objects.alphaTeam.contains(player)) {
                Minigame.objects.removePlayerFromAlphaTeam(player);
            }

            if (Minigame.objects.bravoTeam.contains(player)) {
                Minigame.objects.removePlayerFromBravoTeam(player);
            }

            player.sendMessage(Util.fixColor("&cPrzegrales!"));
            TeleportUtil.teleportToLobby(player);
        }

        if (shooter instanceof Player) {
            Player player1 = (Player) shooter;
            if (s.equalsIgnoreCase("snowball")) {
                shooter.sendMessage(Util.fixColor("&cRzuci³eœ œnie¿k¹!"));
            }

        }
    }
}
