package com.anotherdeveloper.globalstats.listeners;

import com.anotherdeveloper.globalstats.GlobalStats;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.CraftItemEvent;

public class StatListener implements Listener {

    private GlobalStats plugin;

    public StatListener(GlobalStats plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        switch (event.getBlock().getType()) {
            case DIAMOND_ORE:
            case COAL_ORE:
            case IRON_ORE:
            case GOLD_ORE:
            case EMERALD_ORE:
               plugin.oresmined++;
                plugin.blocks++;
                break;
            case DIRT:
            case COARSE_DIRT:
                plugin.dirtdug++;
            default:
                plugin.blocks++;
                break;
        }
    }

    @EventHandler
    private void onItemcraft(CraftItemEvent event) {
        plugin.itemscrafted++;
        return;
    }

    @EventHandler
    private void onArrowShoot(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.ARROW) {
            plugin.arrowsshot++;
            return;
        }
    }

    @EventHandler
    private void onPlayerKilled(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
           plugin.playerskilled++;
            return;

        }
    }

    @EventHandler
    private void onMobKilled(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            plugin.mobskilled++;
            return;
        }
    }



}
