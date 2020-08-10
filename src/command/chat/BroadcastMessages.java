package command.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastMessages implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("broadcast") || command.getName().equalsIgnoreCase("bc")) {
            try {
                if(commandSender.hasPermission("brou.broadcast")) {
                    if(strings.length == 0)
                        return false;
                    String message = "";
                    for (String part : strings) {
                        if (message != "")
                            message += " ";
                        message += part;
                    }
                    Bukkit.broadcastMessage(ChatColor.YELLOW + ("[Объявление]: ")
                            + ChatColor.DARK_AQUA + (message)
                            + ChatColor.GOLD + ChatColor.BOLD + (" (отправил игрок: ") + commandSender.getName() + ")");
                    return true;
                }
            } catch (Exception ex) {
                return false;
            }
        }
        return true;
    }
}
