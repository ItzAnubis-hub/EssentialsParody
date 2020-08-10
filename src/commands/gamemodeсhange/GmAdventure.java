package commands.gamemodeсhange;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmAdventure implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("gma")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage("Only for the player.");
            } else {
                if(!commandSender.hasPermission("brou.gma")) {
                    commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
                } else {
                    Player player = (Player) commandSender;
                    commandSender.sendMessage("You GameMode has been changed to ADVENTURE");
                    player.setGameMode(GameMode.ADVENTURE);
                    return true;
                }
            }
        }
        return true;
    }
}
