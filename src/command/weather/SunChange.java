package command.weather;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SunChange implements CommandExecutor {
    Player player;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command,
                             String s, String[] strings) {
        World world = Bukkit.getWorld("world");
        if(command.getName().equalsIgnoreCase("sun")) {
            if (!(commandSender.hasPermission("brou.sun"))) {
                commandSender.sendMessage(ChatColor.RED + "Don't have any permission");

            } else {
                if(!(commandSender instanceof Player)) {
                    commandSender.sendMessage("Only Player usage");
                    return false;
                } else {
                    try {
                        if(strings.length > 0) {
                            return false;
                        } else {
                            commandSender.sendMessage("Weather is clear.");

                            world.setStorm(false);

                            return true;
                        }

                    } catch (Exception ex) {

                        return false;
                    }
                }
            }
        }
        return true;
    }
}
