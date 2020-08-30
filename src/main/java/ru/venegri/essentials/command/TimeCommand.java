package ru.venegri.essentials.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
@Getter
public class TimeCommand implements CommandExecutor {

    private WorldTimeType worldTimeType;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command only for players!");
            return true;
        }

        if (worldTimeType != null) {
            if (!commandSender.hasPermission("brou." + worldTimeType.name().toLowerCase())) {
                commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
                return true;
            }

            ((Player) commandSender).getWorld().setTime(worldTimeType.getWorldTime());
            return true;
        }

        if (!commandSender.hasPermission("brou.time")) {
            commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }

        if (args.length == 0) {
            commandSender.sendMessage("Используйте - /time <время>");
            return true;
        }

        if (!isLong(args[0])) {
            commandSender.sendMessage("Указанный аргумент не является единицей времени!");
            return true;
        }

        long worldTime = Long.parseLong(args[0]);
        ((Player) commandSender).getWorld().setTime(worldTime);

        return false;
    }

    private boolean isLong(String string) {
        try {
            Long.parseLong(string);
            return true;
        }

        catch (NumberFormatException exception) {
            return false;
        }
    }

    @RequiredArgsConstructor
    @Getter
    public enum WorldTimeType {

        MORNING(0),
        DAY(1200),
        EVENING(23000),
        NIGHT(19000);

        private final long worldTime;
    }

}
