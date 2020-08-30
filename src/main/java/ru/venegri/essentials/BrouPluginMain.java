package ru.venegri.essentials;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.WeatherType;
import org.bukkit.plugin.java.JavaPlugin;
import ru.venegri.essentials.command.*;
import ru.venegri.essentials.command.DeopCommand;
import ru.venegri.essentials.command.OpCommand;
import ru.venegri.essentials.listener.BedLeaveListener;
import ru.venegri.essentials.listener.JoinPlayerListener;

public final class BrouPluginMain extends JavaPlugin  {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinPlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new BedLeaveListener(), this);

        // register commands
        getCommand("weather").setExecutor(new WeatherCommand(null));
        getCommand("sun").setExecutor(new WeatherCommand(WeatherType.CLEAR));
        getCommand("rain").setExecutor(new WeatherCommand(WeatherType.DOWNFALL));

        getCommand("time").setExecutor(new TimeCommand(null));
        getCommand("morning").setExecutor(new TimeCommand(TimeCommand.WorldTimeType.MORNING));
        getCommand("day").setExecutor(new TimeCommand(TimeCommand.WorldTimeType.DAY));
        getCommand("evening").setExecutor(new TimeCommand(TimeCommand.WorldTimeType.EVENING));
        getCommand("night").setExecutor(new TimeCommand(TimeCommand.WorldTimeType.NIGHT));

        getCommand("gm").setExecutor(new ChangeGamemodeCommand(null));
        getCommand("gms").setExecutor(new ChangeGamemodeCommand(GameMode.SURVIVAL));
        getCommand("gmc").setExecutor(new ChangeGamemodeCommand(GameMode.CREATIVE));
        getCommand("gma").setExecutor(new ChangeGamemodeCommand(GameMode.ADVENTURE));
        getCommand("gmsp").setExecutor(new ChangeGamemodeCommand(GameMode.SPECTATOR));

        getCommand("op").setExecutor(new OpCommand());
        getCommand("deop").setExecutor(new DeopCommand());

        getCommand("broadcast").setExecutor(new BroadcastCommand(false));
        getCommand("ebroadcast").setExecutor(new BroadcastCommand(true));

        getCommand("tp").setExecutor(new TeleportCommand(false));
        getCommand("s").setExecutor(new TeleportCommand(true));

        getCommand("fly").setExecutor(new FlyingCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("speed").setExecutor(new SpeedCommand());

        getLogger().info("brouplug: ON");
    }

    @Override
    public void onDisable() {
        getLogger().info("brouplug: OFF");
    }

}
