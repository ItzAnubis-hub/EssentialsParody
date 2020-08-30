package ru.venegri.essentials.command;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class TeleportCommand implements CommandExecutor {

    private final boolean teleportToSender;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command only for players!");
            return true;
        }

        String commandName = teleportToSender ? "s" : "tp";

        if (!commandSender.hasPermission("brou." + commandName)) {
            commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }

        Player playerSender = ((Player) commandSender);

        if (args.length == 0) {
            playerSender.sendMessage(String.format("Используйте - /%s %s",
                    commandName, "<игрок" + (teleportToSender ? "" : "/локация") + ">"));

            return true;
        }

        if (args.length < 3) {
            if (args.length < 2) {
                Player targetPlayer = Bukkit.getPlayer(args[0]);

                if (targetPlayer == null) {
                    commandSender.sendMessage("Данный игрок не в сети!");
                    return true;
                }

                (teleportToSender ? targetPlayer : playerSender).teleport(
                        (teleportToSender ? playerSender : targetPlayer)
                );

                return true;
            }

            Player targetPlayer1 = Bukkit.getPlayer(args[0]);
            Player targetPlayer2 = Bukkit.getPlayer(args[1]);

            if (targetPlayer1 == null || targetPlayer2 == null) {
                commandSender.sendMessage("Один из игроков не в сети!");
                return true;
            }

            targetPlayer1.teleport(targetPlayer2);
            return true;
        }

        if (!isDouble(args[0]) || !isDouble(args[1]) || !isDouble(args[2])) {
            commandSender.sendMessage("Указанная локация не является числом!");
            return true;
        }

        double locationX = Double.parseDouble(args[0].replace(",", "."));
        double locationY = Double.parseDouble(args[1].replace(",", "."));
        double locationZ = Double.parseDouble(args[2].replace(",", "."));

        Location location = new Location(playerSender.getWorld(), locationX, locationY, locationZ);

        playerSender.teleport(location);
        return false;
    }

    private boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        }

        catch (NumberFormatException exception) {
            return false;
        }
    }

}
