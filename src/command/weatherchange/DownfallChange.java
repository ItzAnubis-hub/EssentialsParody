package command.weatherchange;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DownfallChange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command,
                             String s, String[] strings) {
        if (!commandSender.hasPermission("brou.changeDownfall")) {
            commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
        } else {
            if (!(commandSender instanceof Player)) {
                return false;
            } else {
                if (command.getName().equalsIgnoreCase("rain")) {
                    World world = Bukkit.getWorld("world");

                    world.setStorm(true);

                    commandSender.sendMessage("Weather changed!");
                    return true;
                }
            }

        }
        return true;
    }

}
