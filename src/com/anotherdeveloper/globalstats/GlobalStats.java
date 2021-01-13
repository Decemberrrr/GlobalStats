package com.anotherdeveloper.globalstats;

import com.anotherdeveloper.globalstats.commands.GlobalStatsCmd;
import com.anotherdeveloper.globalstats.listeners.StatListener;
import com.anotherdeveloper.globalstats.utils.ObjectSet;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public class GlobalStats extends JavaPlugin  {

    private DataFile configFile;
    private DataFile statsFile;

    public Integer oresmined;
    public Integer dirtdug;
    public Integer itemscrafted;
    public Integer arrowsshot;
    public Integer playerskilled;
    public Integer mobskilled;
    public Integer blocks;

    public void onEnable() {
        this.configFile = new DataFile(this, "config", true);
        this.statsFile = new DataFile(this, "stats", true);

        System.out.println("GlobalStats: Server Stats Loading...");

        this.oresmined = statsFile.getInteger("stats.oresmined");
        this.dirtdug = statsFile.getInteger("stats.dirtdug");
        this.itemscrafted = statsFile.getInteger("stats.itemscrafted");
        this.arrowsshot = statsFile.getInteger("stats.arrowsshot");
        this.playerskilled = statsFile.getInteger("stats.playerskilled");
        this.mobskilled = statsFile.getInteger("stats.mobskilled");
        this.blocks = statsFile.getInteger("stats.blocks");

        System.out.println(statsFile.getInteger("stats.oresmined"));

        System.out.println("GlobalStats: Server Stats Loaded.");

        registerCommands();
        registerListeners();
    }

    public void onDisable() {
        statsFile.setInteger("stats.oresmined", oresmined);
        statsFile.setInteger("stats.dirtdug", dirtdug);
        statsFile.setInteger("stats.itemscrafted", itemscrafted);
        statsFile.setInteger("stats.arrowsshot", arrowsshot);
        statsFile.setInteger("stats.playerskilled", playerskilled);
        statsFile.setInteger("stats.mobskilled", mobskilled);
        statsFile.setInteger("stats.blocks", blocks);
        statsFile.saveConfig();
    }

    private void registerCommands() {
        Objects.requireNonNull(getServer().getPluginCommand("globalstats")).setExecutor(new GlobalStatsCmd(this));
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new StatListener(this), this);
    }

    public String getInConfig(String msg, ObjectSet... replacements) {
        String messageToTranslate = getConfig().getString(msg);
        if (messageToTranslate == null || messageToTranslate.isEmpty()) {
            return "";
        }
        for (ObjectSet replacement : replacements) {
            messageToTranslate = messageToTranslate.replace(replacement.getA().toString(), replacement.getB().toString());
        }
        return ChatColor.translateAlternateColorCodes('&', messageToTranslate);
    }

}
