package command.teleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class TeleportPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            if (command.getName().equalsIgnoreCase("tp")) {
                if (!(commandSender instanceof Player)) {
                    commandSender.sendMessage("Only player.");
                } else {
                    if (!commandSender.hasPermission("brou.tp")) {
                        commandSender.sendMessage(ChatColor.RED + "У вас нет прав.");
                    } else {
                        String name = args[0];
                        Player player = (Player) commandSender;
                        if(Bukkit.getPlayer(name).getName().equals(name)) {
                            commandSender.sendMessage("Телепортирование..");
                            player.teleport(Bukkit.getPlayer(name));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            commandSender.sendMessage(ChatColor.DARK_RED + ("ОШИБКА: ")
                    + ChatColor.RED + " Игрока нет на сервере." );
        }

        return true;
    }
}
