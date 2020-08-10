package command.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastAnon implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("ebroadcast") || command.getName().equalsIgnoreCase("ebc")) {
            try {
                if(commandSender.hasPermission("brou.ebroadcast")) {
                    if(strings.length == 0)
                        return false;
                    String message = "";
                    for (String part : strings) {
                        if (message != "")
                            message += " ";
                        message += part;
                    }
                    Bukkit.broadcastMessage(ChatColor.YELLOW + ("[Объявление]: ")
                            + ChatColor.DARK_AQUA + (message));
                    return true;
                }
            } catch (Exception ex) {
                return false;
            }
        }
        return true;
    }
}
