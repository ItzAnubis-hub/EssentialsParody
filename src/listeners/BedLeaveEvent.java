package listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.World;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedLeaveEvent implements Listener {
    @EventHandler
    public void realBedCycle  (PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        try {
            World world = Bukkit.getWorld("world");
            long time = world.getTime();
            if(time > 12000 && time < 23450) {
               player.sendMessage("Вы еще должны спать");
            } else {
                int food_level = (int) (Math.random() * 10);

                player.setFoodLevel(food_level);

                player.sendMessage(ChatColor.RED +
                        "Доброе утро! Всегда наступает утро, и за ночь вы проголодались." +
                        " Найдите еду.");
            }
        } catch(Exception ex) {
            System.out.println("Вылетела ошибка");
        }
    }
}
