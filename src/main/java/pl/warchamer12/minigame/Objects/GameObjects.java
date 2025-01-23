package pl.warchamer12.minigame.Objects;

import org.bukkit.entity.Player;
import pl.warchamer12.minigame.Minigame;

import java.util.ArrayList;

public class GameObjects {

    private final Minigame plugin;

    public GameObjects(Minigame plugin) {
        this.plugin = plugin;
    }

    public ArrayList<Player> players = new ArrayList<>();
    public ArrayList<Player> alphaTeam = new ArrayList<>(); //max 15
    public ArrayList<Player> bravoTeam = new ArrayList<>(); //max 15

    //QUEUE
    public void addPlayerToQUEUE(Player player) {
        Player name = player.getPlayer();
        if (!players.contains(name)) {
            players.add(name);
        }
    }

    public Player getPlayerFromQUEUE(Player player) {
        Player playerName = player.getPlayer();
        if (players.contains(playerName)) {
            return playerName;
        }
        return null;
    }

    public void removePlayerFromQUEUE(Player player) {
        Player playerName = player.getPlayer();
        if (players.contains(playerName)) {
            players.remove(playerName);
        }
    }
    //END QUEUE

    //ALPHA TEAM
    public void addPlayerToAlphaTeam(Player player) {
        Player playerName = player.getPlayer();
        if (!alphaTeam.contains(playerName)) {
            alphaTeam.add(playerName);
        }
    }

    public Player getPlayerFromAlphaTeam(Player player) {
        Player playerName = player.getPlayer();
        if (alphaTeam.contains(playerName)) {
            return playerName;
        }
        return null;
    }

    public void removePlayerFromAlphaTeam(Player player) {
        Player playerName = player.getPlayer();
        if (alphaTeam.contains(playerName)) {
            alphaTeam.remove(playerName);
        }
    }
    //END ALPHA TEAM

    //BRAVO TEAM
    public void addPlayerToBravoTeam(Player player) {
        Player playerName = player.getPlayer();
        if (!bravoTeam.contains(playerName)) {
            bravoTeam.add(playerName);
        }
    }

    public Player getPlayerFromBravoTeam(Player player) {
        Player playerName = player.getPlayer();
        if (bravoTeam.contains(playerName)) {
            return playerName;
        }
        return null;
    }

    public void removePlayerFromBravoTeam(Player player) {
        Player playerName = player.getPlayer();
        if (bravoTeam.contains(playerName)) {
            bravoTeam.remove(playerName);
        }
    }
    //END BRAVO TEAM

}
