package ru.venegri.essentials.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command only for players!");
            return true;
        }

        if (!commandSender.hasPermission("brou.flying")) {
            commandSender.sendMessage("недостаточно прав");
            return true;
        }

        Player player = ((Player) commandSender);
        player.setAllowFlight(!player.getAllowFlight());

        player.sendMessage("Полет: " + (player.getAllowFlight() ? "включен" : "выключен"));
        return false;
    }
}
