package command.timechange;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayChange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        World world = Bukkit.getWorld("world");
        if(command.getName().equalsIgnoreCase("day")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage("Only player can use this command");
                return false;
            } else {
                if(!commandSender.hasPermission("brou.DayChange")) {
                    commandSender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                } else {
                    world.setTime(1000);
                    commandSender.sendMessage("Time has been changed to day");
                }
            }
        }

        return true;
    }
}
