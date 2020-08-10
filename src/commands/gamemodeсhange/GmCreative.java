package commands.gamemodeсhange;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCreative implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("gmc")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage("Only for the player.");
            } else {
                if(!commandSender.hasPermission("brou.gmc")) {
                    commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
                } else {
                    Player player = (Player) commandSender;
                    commandSender.sendMessage("You GameMode has been changed to CREATIVE");
                    player.setGameMode(GameMode.CREATIVE);
                    return true;
                }
            }
        }
        return true;
    }
}
