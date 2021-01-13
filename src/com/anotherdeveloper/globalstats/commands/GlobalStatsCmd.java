package com.anotherdeveloper.globalstats.commands;

import com.anotherdeveloper.globalstats.GlobalStats;

import com.anotherdeveloper.globalstats.utils.*;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GlobalStatsCmd implements CommandExecutor {

    private GlobalStats plugin;

    public GlobalStatsCmd(GlobalStats plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (player.hasPermission("globalstats.use")) {
            if (cmd.getName().equalsIgnoreCase("globalstats")) {
                openStatMenu(player);
            }
        }

        return false;
    }

    public void openStatMenu(Player player) {

        Menu menu = new Menu(plugin.getInConfig("Menu.Title"), 6, false);

        menu.fillRange(0, 53, new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, 1)
                        .setName(Color.color(" "))
                        .toItemStack();
            }
        });

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.DIAMOND_PICKAXE, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.DiamondPickaxe.Name")))
                        .setLore("")
                        .toItemStack();
            }
        }, 10);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.DIAMOND_SHOVEL, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.DiamondShovel.Name")))
                        .setLore("")
                        .toItemStack();
            }
        }, 11);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.DIAMOND_SHOVEL, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.CraftingTable.Name")))
                        .setLore("")
                        .toItemStack();
            }
        }, 12);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.BOW, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.Bow.Name")))
                        .setLore("")
                        .toItemStack();
            }
        }, 13);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.GREEN_DYE, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.GreenDye.Name")))
                        .setLore("")
                        .toItemStack();
            }
        }, 14);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.ROTTEN_FLESH, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.RottenFlesh.Name")))
                        .setLore("")
                        .toItemStack();
            }
        }, 15);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.STONE, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.Stone.Name")))
                        .setLore("")
                        .toItemStack();
            }
        }, 16);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.DiamondPickaxe.Amount", new ObjectSet("{oresmined}", plugin.oresmined))))
                        .setLore("")
                        .toItemStack();
            }
        }, 19);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.DiamondShovel.Amount", new ObjectSet("{dirtdug}", plugin.dirtdug))))
                        .setLore("")
                        .toItemStack();
            }
        }, 20);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.CraftingTable.Amount", new ObjectSet("{itemscrafted}", plugin.itemscrafted))))
                        .setLore("")
                        .toItemStack();
            }
        }, 21);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.Bow.Amount",  new ObjectSet("{arrowsshot}", plugin.arrowsshot))))
                        .setLore("")
                        .toItemStack();
            }
        }, 22);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.GreenDye.Amount", new ObjectSet("{playerskilled}", plugin.playerskilled))))
                        .setLore("")
                        .toItemStack();
            }
        }, 23);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.RottenFlesh.Amount", new ObjectSet("{mobskilled}", plugin.mobskilled))))
                        .setLore("")
                        .toItemStack();
            }
        }, 24);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.Stone.Amount", new ObjectSet("{blocks}", plugin.blocks))))
                        .setLore("")
                        .toItemStack();
            }
        }, 25);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.Note1.Message")))
                        .setLore("")
                        .toItemStack();
            }
        }, 38);

        menu.addMenuItem(new MenuItem.UnclickableMenuItem() {
            @Override
            public ItemStack getItemStack() {
                return new ItemBuilder(Material.PAPER, 1)
                        .setName(Color.color(plugin.getInConfig("Menu.Items.Note2.Message")))
                        .setLore("")
                        .toItemStack();
            }
        }, 42);

        menu.openMenu(player);

    }
}
