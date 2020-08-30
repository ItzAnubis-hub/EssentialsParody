package ru.venegri.essentials.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command only for players!");
            return true;
        }

        if (!commandSender.hasPermission("brou.speed")) {
            commandSender.sendMessage("недостаточно прав");
            return true;
        }

        if (args.length == 0) {
            commandSender.sendMessage("Используйте - /speed <скорость>");
            return true;
        }

        if (!isNumber(args[0])) {
            commandSender.sendMessage("Аргумент не является числом!");
            return true;
        }

        Player player = ((Player) commandSender);

        int speedArgument = Integer.parseInt(args[0]);
        if (speedArgument > 10) {
            speedArgument = 10;
        }

        float playerSpeed = speedArgument / 10F;

        if (player.isOnGround()) {
            player.sendMessage("Установлена скорость ходьбы: " + speedArgument);
            player.setWalkSpeed(playerSpeed);

            return true;
        }

        player.sendMessage("Установлена скорость полета: " + speedArgument);
        player.setFlySpeed(playerSpeed);

        return false;
    }

    private boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }

        catch (NumberFormatException exception) {
            return false;
        }
    }
}
