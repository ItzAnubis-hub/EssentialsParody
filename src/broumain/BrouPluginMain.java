package broumain;

import command.chat.BroadcastAnon;
import command.chat.BroadcastMessages;
import command.gamemode.*;
import command.operator.DeopPlayer;
import command.operator.OpPlayer;
import command.time.DayChange;
import command.time.NightChange;
import command.weatherchange.DownfallChange;
import command.weatherchange.SunChange;
import listener.BedLeaveListener;
import listener.JoinPlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BrouPluginMain extends JavaPlugin  {
    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new JoinPlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new BedLeaveListener(), this);

        World world = Bukkit.getWorld("world");

        Difficulty difficulty = world.getDifficulty();

        // Start of the executors command
        getCommand("sun").setExecutor(new SunChange());
        getCommand("rain").setExecutor(new DownfallChange());
        getCommand("day").setExecutor(new DayChange());
        getCommand("night").setExecutor(new NightChange());
        getCommand("gm").setExecutor(new GmChange());
        getCommand("op").setExecutor(new OpPlayer());
        getCommand("deop").setExecutor(new DeopPlayer());
        getCommand("gms").setExecutor(new GmSurvival());
        getCommand("gmc").setExecutor(new GmCreative());
        getCommand("gma").setExecutor(new GmAdventure());
        getCommand("gmsp").setExecutor(new GmSpectator());
        getCommand("broadcast").setExecutor(new BroadcastMessages());
        getCommand("bc").setExecutor(new BroadcastMessages());
        getCommand("ebroadcast").setExecutor(new BroadcastAnon());
        getCommand("ebc").setExecutor(new BroadcastAnon());


        // End of the executors command

        getLogger().info("brouplug: ON");
    }
    @Override
    public void onDisable() {

        Plugin plugin = Bukkit.getPluginManager().getPlugin("BrouPluginMain");

        HandlerList.unregisterAll(plugin);

        getLogger().info("brouplug: OFF");

    }
}
