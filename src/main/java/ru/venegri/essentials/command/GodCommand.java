package ru.venegri.essentials.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command only for players!");
            return true;
        }

        if (!commandSender.hasPermission("brou.god")) {
            commandSender.sendMessage("недостаточно прав");
            return true;
        }

        Player player = ((Player) commandSender);

        boolean hasGodMode = player.getNoDamageTicks() <= 1;
        player.setNoDamageTicks(hasGodMode ? Integer.MAX_VALUE : 1);

        player.sendMessage("Режим Бога: " + (hasGodMode ? "включен" : "выключен"));
        return false;
    }
}
