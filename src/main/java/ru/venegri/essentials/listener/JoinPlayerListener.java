package ru.venegri.essentials.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinPlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.getName().equalsIgnoreCase("broughtmiracles")) {
            player.sendMessage(ChatColor.DARK_AQUA + "С возвращением, милорд");

            return;
        }

        player.sendMessage(ChatColor.RED + "Вы зашли на сервер " + Bukkit.getServer().getName());
    }
}
