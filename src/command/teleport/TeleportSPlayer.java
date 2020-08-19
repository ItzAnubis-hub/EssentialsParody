package command.teleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TeleportSPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        try {
            if(command.getName().equalsIgnoreCase("s")){
                if (!(commandSender instanceof Player)) {
                    commandSender.sendMessage("Только для игроков");
                } else {
                    if (!commandSender.hasPermission("brou.s")) {
                        commandSender.sendMessage(ChatColor.RED + "У вас нет прав.");
                    } else {
                        String name = args[0];
                        Player player = (Player) commandSender;
                        String namePlayer = player.getName();
                        Player playerWhoTp = Bukkit.getPlayer(name);
                        String namePlayerWhoTp = playerWhoTp.getName();
                        if(args.length < 1) {
                            return false;
                        }
                        if(namePlayerWhoTp.equals(name)) {
                            commandSender.sendMessage("Телепортируем..");
                            Location loc = Bukkit.getPlayer(namePlayer).getLocation();
                            playerWhoTp.teleport(loc);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            commandSender.sendMessage("Такого игрока нет на сервере.");
        }
        return true;
    }
}
