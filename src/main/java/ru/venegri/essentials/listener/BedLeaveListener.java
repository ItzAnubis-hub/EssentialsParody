package ru.venegri.essentials.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.World;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.concurrent.ThreadLocalRandom;

public class BedLeaveListener implements Listener {

    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();

        World world = Bukkit.getWorld("world");
        long time = world.getTime();

        if (time > 12000 && time < 23450) {
            player.sendMessage("Вы еще должны спать");
            return;
        }

        int foodLevel = ThreadLocalRandom.current().nextInt(10);

        player.setFoodLevel(foodLevel);
        player.sendMessage(ChatColor.RED + "Доброе утро! Всегда наступает утро, и за ночь вы проголодались. Найдите еду.");
    }

}
