package ru.venegri.essentials.command;

import lombok.AllArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class ChangeGamemodeCommand implements CommandExecutor {

    private GameMode currentGamemode;

    private static final GameMode[] GAME_MODES = GameMode.values();


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command only for players!");
            return true;
        }

        if (currentGamemode != null) {
            if (!commandSender.hasPermission("brou.gm" + currentGamemode.name().toLowerCase().charAt(0))) {
                commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
                return true;
            }

            ((Player) commandSender).setGameMode(currentGamemode);
            commandSender.sendMessage("You GameMode has been changed to " + currentGamemode);

            return true;
        }

        if (!commandSender.hasPermission("brou.gm")) {
            commandSender.sendMessage(ChatColor.RED + "You don't have permission.");
            return true;
        }

        if (args.length == 0) {
            commandSender.sendMessage("Используйте - /gm <игровой режим>");
            return true;
        }

        String gameModeArgument = args[0];

        if (isNumber(gameModeArgument)) {
            currentGamemode = GameMode.getByValue(Integer.parseInt(gameModeArgument));
        } else {
            for (GameMode gameMode : GAME_MODES) {
                if (!gameMode.name().startsWith(gameModeArgument.toUpperCase())) {
                    continue;
                }

                currentGamemode = gameMode;
            }
        }

        if (currentGamemode == null) {
            commandSender.sendMessage("Ошибка, игровой режим не найден!");
            return true;
        }

        commandSender.sendMessage("You GameMode has been changed to " + currentGamemode);
        ((Player) commandSender).setGameMode(currentGamemode);

        currentGamemode = null;
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
