package commands.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class OpPlayer implements CommandExecutor {
    @Override

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("brouop")) {
            try {
                if (!commandSender.hasPermission("brou.op")) {
                    commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
                } else {

                    String playerOp = strings[0];
                    if (strings.length == 0) {
                        return false;
                    }
                    try {
                        Player playerToOp = Bukkit.getPlayer(playerOp);
                        if(playerToOp.isOnline()) {
                           if(playerToOp.isOp()) {
                               commandSender.sendMessage(ChatColor.RED + "У игрока уже есть опка!");
                           } else {
                               playerToOp.sendMessage("Вы были опнуты администратором " + commandSender.getName());
                               Bukkit.broadcastMessage(ChatColor.RED + (playerToOp.getName() + " был опнут на сервере администратором " + commandSender.getName()));
                               playerToOp.setOp(true);
                           }
                        } else {
                            commandSender.sendMessage("Данный игрок не онлайн.");
                        }
                        return true;
                    } catch (Exception ex) {
                        commandSender.sendMessage("Данный игрок не онлайн.");
                    }
                }
            }catch(Exception ex) {
                return false;
            }
        }
        return true;
    }
}
