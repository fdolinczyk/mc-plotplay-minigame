package pl.warchamer12.minigame.Utils;

import org.bukkit.entity.Player;
import pl.warchamer12.minigame.Minigame;
import pl.warchamer12.minigame.config.configManager;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TeleportUtil {

    public static void teleportToLobby(Player player) {
        if (Minigame.objects.players.contains(player)) {
            Minigame.objects.removePlayerFromQUEUE(player);
        }

        if (Minigame.objects.alphaTeam.contains(player)) {
            Minigame.objects.removePlayerFromAlphaTeam(player);
        }

        if (Minigame.objects.bravoTeam.contains(player)) {
            Minigame.objects.removePlayerFromBravoTeam(player);
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        boolean online = false;
        try {
            String ip = configManager.getInstance().getFileConfiguration().getString("mysql.connection.lobby.socketadress");
            Integer port = configManager.getInstance().getFileConfiguration().getInt("mysql.connection.lobby.socketport");
            String name = configManager.getInstance().getFileConfiguration().getString("mysql.connection.lobby.name");

            Socket s = new Socket();
            s.connect(new InetSocketAddress(ip, port), 15); //good timeout is 10-20
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(name);
            player.sendPluginMessage(Minigame.getPlugin(Minigame.class), "BungeeCord", byteArrayOutputStream.toByteArray());
            s.close();
            online = true;
        } catch (UnknownHostException exception) {
            System.out.println("unknwonhostexception");
        } catch (IOException e) {
            player.sendTitle("", Util.fixColor("&cLobby aktualnie jest wy³¹czone!"), 3, 40, 3);
        }
    }
}
