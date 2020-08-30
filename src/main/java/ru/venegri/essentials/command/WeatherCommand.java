package ru.venegri.essentials.command;

import lombok.AllArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class WeatherCommand implements CommandExecutor {

    private WeatherType currentWeatherType;

    private static final WeatherType[] WEATHER_TYPES = WeatherType.values();


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command only for players!");
            return true;
        }

        if (currentWeatherType == null) {
            if (!commandSender.hasPermission("brou.weather")) {
                commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
                return true;
            }

            if (args.length == 0) {
                commandSender.sendMessage("Используйте - /weather <погода>");
                return true;
            }

            String weatherArgument = args[0];
            for (WeatherType weatherType : WEATHER_TYPES) {

                if (!weatherType.name().equals(weatherArgument.toUpperCase())) {
                    continue;
                }

                ((Player) commandSender).getWorld().setWeatherDuration(weatherType.ordinal());
                break;
            }

            commandSender.sendMessage("Данного типа погоды не существует!");
            return true;
        }

        if (!commandSender.hasPermission("brou." + currentWeatherType.name().toLowerCase())) {
            commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }

        ((Player) commandSender).getWorld().setWeatherDuration(currentWeatherType.ordinal());
        return false;
    }

}
