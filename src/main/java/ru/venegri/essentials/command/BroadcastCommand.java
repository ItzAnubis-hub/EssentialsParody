package ru.venegri.essentials.command;

import com.google.common.base.Joiner;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

@RequiredArgsConstructor
public class BroadcastCommand implements CommandExecutor {

    private final boolean anonymous;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!commandSender.hasPermission("brou.ebroadcast")) {
            commandSender.sendMessage("недостаточно прав");
            return true;
        }

        if (args.length == 0) {
            return false;
        }

        Bukkit.broadcastMessage("§e[Объявление]: §3" + Joiner.on(" ").join(args)
                + (anonymous ? "" : " \n§7отправил игрок: §e" + commandSender.getName()));

        return false;
    }
}
