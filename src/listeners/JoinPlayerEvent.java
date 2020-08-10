package listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinPlayerEvent implements Listener {
    @EventHandler
    public void player_join(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String name = player.getName();

        if(name.equals("broughtmiracles")) {
            player.sendMessage(ChatColor.DARK_AQUA + "С возвращением, милорд");
        } else {
            player.sendMessage(ChatColor.RED + "Вы зашли на сервер + " + Bukkit.getServer().getName());
        }
    }
}
