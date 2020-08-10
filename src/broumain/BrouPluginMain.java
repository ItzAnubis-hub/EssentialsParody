package broumain;

import commands.chatcmd.BroadcastAnon;
import commands.chatcmd.BroadcastMessages;
import commands.gamemodeсhange.*;
import commands.other.DeopPlayer;
import commands.other.OpPlayer;
import commands.timechange.DayChange;
import commands.timechange.NightChange;
import commands.weatherchange.DownfallChange;
import commands.weatherchange.SunChange;
import listeners.BedLeaveEvent;
import listeners.JoinPlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BrouPluginMain extends JavaPlugin  {
    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new JoinPlayerEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BedLeaveEvent(), this);

        World world = Bukkit.getWorld("world");

        Difficulty difficulty = world.getDifficulty();

        // Start of the executors commands
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


        // End of the executors commands

        getLogger().info("brouplug: ON");
    }
    @Override
    public void onDisable() {

        Plugin plugin = Bukkit.getPluginManager().getPlugin("BrouPluginMain");

        HandlerList.unregisterAll(plugin);

        getLogger().info("brouplug: OFF");

    }
}
