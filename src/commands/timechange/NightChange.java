package commands.timechange;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightChange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("night")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "Only player can use this command.");
            } else {
                if(!(commandSender.hasPermission("brou.NightChange"))) {
                    commandSender.sendMessage(ChatColor.RED + "You don't have any permission to do that.");

                } else {
                    World world = Bukkit.getWorld("world");

                    world.setTime(13000);

                    commandSender.sendMessage("Time has been changed to night");
                    return true;
                }
            }
        }

        return true;
    }
}
