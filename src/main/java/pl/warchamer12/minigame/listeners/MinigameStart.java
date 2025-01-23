package pl.warchamer12.minigame.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.warchamer12.minigame.Minigame;
import pl.warchamer12.minigame.Utils.Util;

public class MinigameStart {

    public static void start() {
        if (Minigame.objects.players.size() >= 20 && Minigame.objects.players.size() <= 30) {
            for (Player players : Minigame.objects.players) {
                new BukkitRunnable() {
                    private int timeStart = 11;

                    @Override
                    public void run() {
                        timeStart--;

                        if (timeStart <= 10 && timeStart >= 2) {
                            players.sendTitle(Util.fixColor("&2&lGra startuje za:"), Util.fixColor("&c&l" + timeStart), 3, 20, 3);
                            players.playSound(players.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);
                        }
                        if (timeStart == 1) {
                            players.sendTitle(Util.fixColor("&2&lGra startuje za:"), Util.fixColor("&c&l" + timeStart), 3, 20, 3);
                            players.playSound(players.getLocation(), Sound.BLOCK_ANVIL_LAND, 3, 3);
                            teleportTeams(players);
                            timeStart = 11;
                        }
                    }
                }.runTaskTimer(Minigame.getInstance(), 20L, 20L);
            }
        } else if (Minigame.objects.players.size() < 20) {
            for (Player players : Minigame.objects.players) {
                players.sendMessage(Util.fixColor("&c&lOczekiwanie na graczy. W lobby jest aktualnie: " + Minigame.objects.players.size()));
            }
        }
    }

    public static void teleportTeams(Player player) {
        player.setFreezeTicks(111);
        player.sendMessage(Util.fixColor("&cZostaniesz odmro¿ony za 5 sekund gdy rozgrywka wystartuje!"));

        new BukkitRunnable() {
            private int starting = 6;

            @Override
            public void run() {
                starting--;

                if (starting <= 5 && starting >= 2) {
                    player.sendTitle(Util.fixColor("&2&lPrzygotuj siê:"), Util.fixColor("&c&l" + starting), 3, 20, 3);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);
                }
                if (starting == 1) {
                    player.sendTitle(Util.fixColor("&2&lSTART!"), Util.fixColor("&2Niech wygra najlepszy!"), 3, 20, 3);
                    player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 3, 3);
                    starting = 6;
                }
            }
        }.runTaskTimer(Minigame.getInstance(), 20L, 20L);
    }

}
