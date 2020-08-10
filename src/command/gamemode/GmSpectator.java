package command.gamemode;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmSpectator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("gmsp")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage("Only for the player.");
            } else {
                if(!commandSender.hasPermission("brou.gmsp")) {
                    commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
                } else {
                    Player player = (Player) commandSender;
                    commandSender.sendMessage("You GameMode has been changed to SPECTATOR");
                    player.setGameMode(GameMode.SPECTATOR);
                    return true;
                }
            }
        }
        return true;
    }
}
