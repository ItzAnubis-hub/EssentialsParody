package commands.gamemodeсhange;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmChange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            if (command.getName().equalsIgnoreCase("gm")) {
                if (!(commandSender instanceof Player)) {
                    commandSender.sendMessage("Only player can do this");

                } else {

                    if (!commandSender.hasPermission("brou.gamemode")) {
                        commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
                    } else {
                        Player send = (Player) commandSender;

                        String gamemode = strings[0];
                        if (strings.length == 0) {
                            return false;
                        } else {
                            switch (gamemode) {
                                case "0":
                                    commandSender.sendMessage("You GameMode has been changed to SURVIVAL");
                                    send.setGameMode(GameMode.SURVIVAL);
                                    return true;
                                case "1":
                                    commandSender.sendMessage("You GameMode has been changed to CREATIVE");
                                    send.setGameMode(GameMode.CREATIVE);
                                    return true;
                                case "2":
                                    commandSender.sendMessage("You GameMode has been changed to ADVENTURE");
                                    send.setGameMode(GameMode.ADVENTURE);
                                    return true;
                                case "3":
                                    commandSender.sendMessage("You GameMode has been changed to SPECTATOR");
                                    send.setGameMode(GameMode.SPECTATOR);
                                    return true;
                            }
                        }
                    }
                }
            }
        } catch(Exception ex) {
            return false;
        }
        return true;
    }
}
