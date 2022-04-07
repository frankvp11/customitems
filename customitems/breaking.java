package me.frankvanpaassen.customitems;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static me.frankvanpaassen.customitems.GUICreation.*;
import static me.frankvanpaassen.customitems.ItemManager.starterpickaxe;

public class breaking implements Listener {

    @EventHandler
    public static void onBreak(BlockBreakEvent event) {
        Location loc = event.getBlock().getLocation();
        Player player = event.getPlayer();

        int random_num = (int) Math.floor(Math.random()) * 100;
        if (player.getInventory().getItemInMainHand().equals(starterpickaxe)) {
            if (random_num <= demolish_level) {
                giveKeys(player, 9);
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            Block block = Objects.requireNonNull(loc.getWorld()).getBlockAt((int) (loc.getX() + x), (int) (loc.getY() + y), (int) (loc.getZ() + z));
                            if (block.getType().equals(Material.BEDROCK)) {
                                return;
                            } else if (block.getType().equals(Material.STONE)) {
                                player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, (fortune_level / 100)));
                                block.setType(Material.AIR);
                            } else if (block.getType().equals(Material.COAL_ORE)) {
                                player.getInventory().addItem(new ItemStack(Material.COAL, (fortune_level / 100)));
                                block.setType(Material.AIR);
                            } else if (block.getType().equals(Material.IRON_ORE)) {
                                player.getInventory().addItem(new ItemStack(Material.IRON_ORE, (fortune_level / 100)));
                                block.setType(Material.AIR);
                            } else if (block.getType().equals(Material.GOLD_ORE)) {
                                player.getInventory().addItem(new ItemStack(Material.GOLD_ORE, (fortune_level / 100)));
                                block.setType(Material.AIR);
                            } else {
                                block.setType(Material.AIR);
                            }
                        }
                    }
                }

            } else {
                Block block = event.getBlock();
                if (block.getType().equals(Material.BEDROCK)) {
                    return;
                } else if (block.getType().equals(Material.STONE)) {
                    player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, (fortune_level / 100)));
                    block.setType(Material.AIR);
                } else if (block.getType().equals(Material.COAL_ORE)) {
                    player.getInventory().addItem(new ItemStack(Material.COAL, (fortune_level / 100)));
                    block.setType(Material.AIR);
                } else if (block.getType().equals(Material.IRON_ORE)) {
                    player.getInventory().addItem(new ItemStack(Material.IRON_ORE, (fortune_level / 100)));
                    block.setType(Material.AIR);
                } else if (block.getType().equals(Material.GOLD_ORE)) {
                    player.getInventory().addItem(new ItemStack(Material.GOLD_ORE, (fortune_level / 100)));
                    block.setType(Material.AIR);
                } else {
                    block.setType(Material.AIR);

                }
            }
        }
    }

    @EventHandler
    public static void breaking(BlockBreakEvent event) {
        int chance = (fracture_level / 100);
        int random_num = (int) Math.floor(Math.random()) * 100;
        Location loc = event.getPlayer().getLocation();
        Player player = event.getPlayer();
        if (random_num < chance) {
            for (int Y = -chance; Y < chance; Y++) {
                for (int X = -chance; X < chance; X++) {
                    for (int Z = -chance; Z < chance; Z++) {
                        Block block = Objects.requireNonNull(loc.getWorld()).getBlockAt((int) (loc.getX() + X), (int) (loc.getY() + Y), (int) (loc.getZ() + Z));
                        if (block.getType().equals(Material.BEDROCK)) {
                            return;
                        } else if (block.getType().equals(Material.STONE)) {
                            player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, (fortune_level / 100)));
                            block.setType(Material.AIR);
                        } else if (block.getType().equals(Material.COAL_ORE)) {
                            player.getInventory().addItem(new ItemStack(Material.COAL, (fortune_level / 100)));
                            block.setType(Material.AIR);
                        } else if (block.getType().equals(Material.IRON_ORE)) {
                            player.getInventory().addItem(new ItemStack(Material.IRON_ORE, (fortune_level / 100)));
                            block.setType(Material.AIR);
                        } else if (block.getType().equals(Material.GOLD_ORE)) {
                            player.getInventory().addItem(new ItemStack(Material.GOLD_ORE, (fortune_level / 100)));
                            block.setType(Material.AIR);
                        } else {
                            block.setType(Material.AIR);
                        }
                    }
                }
            }
        } else {
            Block block = event.getBlock();
            if (block.getType().equals(Material.BEDROCK)) {
                return;
            } else if (block.getType().equals(Material.STONE)) {
                player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, (fortune_level / 100)));
                block.setType(Material.AIR);
            } else if (block.getType().equals(Material.COAL_ORE)) {
                player.getInventory().addItem(new ItemStack(Material.COAL, (fortune_level / 100)));
                block.setType(Material.AIR);
            } else if (block.getType().equals(Material.IRON_ORE)) {
                player.getInventory().addItem(new ItemStack(Material.IRON_ORE, (fortune_level / 100)));
                block.setType(Material.AIR);
            } else if (block.getType().equals(Material.GOLD_ORE)) {
                player.getInventory().addItem(new ItemStack(Material.GOLD_ORE, (fortune_level / 100)));
                block.setType(Material.AIR);
            } else {
                block.setType(Material.AIR);

            }


        }


    }


}
