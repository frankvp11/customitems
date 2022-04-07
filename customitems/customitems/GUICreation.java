package me.frankvanpaassen.customitems;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import org.bukkit.inventory.ItemStack;




import java.util.Objects;


import static me.frankvanpaassen.customitems.ItemManager.*;
import static me.frankvanpaassen.customitems.Sell.*;
import static me.frankvanpaassen.customitems.prices.*;


public class GUICreation implements Listener {
    public static Inventory inv = Bukkit.getServer().createInventory(null, 54, "Pickaxe Upgrader");
    public static Inventory mineCrate = Bukkit.getServer().createInventory(null, 27, "Mine Crate");
    public static Inventory rareCrate = Bukkit.getServer().createInventory(null, 27, "Rare Crate");
    public static Inventory legendaryCrate = Bukkit.getServer().createInventory(null, 27, "Legendary Crate");

    public static boolean full_mine = false;
    public static boolean full_rare = false;
    public static boolean full_leg = false;

    public static int lucky_level = 0;
    public static int demolish_level = 0;
    public static int fortune_level = 0;
    public static int efficiency_level = 0;
    public static int fracture_level = 0;
    public static int shockwave_level = 0;
    public static int max_capacity = 150;
    public static int current_amount_mine = 0;
    public static int current_amount_rare = 0;
    public static int current_amount_legendary = 0;


    @EventHandler
    public static void OnRClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            if (player.getInventory().getItemInMainHand().equals(starterpickaxe)) {
                inv.setItem(0, createluckybook());
                inv.setItem(1, createdemolishbook());
                inv.setItem(2, createfortunebook());
                inv.setItem(3, createefficiencybook());
                inv.setItem(4, createfracturebook());
                inv.setItem(5, createshockwavebook());
                player.openInventory(inv);
            }
        }

        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            Block block = event.getClickedBlock();
            if (block.getX() == 57 && block.getY() == 88 && block.getZ() == 55) {
                event.setCancelled(true);
                mineCrate.setItem(0, createtoken1());
                mineCrate.setItem(1, createtoken2());
                player.openInventory(mineCrate);
            }
            else if (block.getX() == 57 && block.getY() == 88 && block.getZ() == 55) {
                event.setCancelled(true);
                rareCrate.setItem(0, createtoken3());
                rareCrate.setItem(1, createtoken4());
                player.openInventory(rareCrate);
            }
            else if (block.getX() == 55 && block.getY() == 88 && block.getZ() == 57){
                event.setCancelled(true);
                legendaryCrate.setItem(0, createtoken5());
                legendaryCrate.setItem(1, createtoken6());
                player.openInventory(legendaryCrate);
            }
        }
    }


    @EventHandler
    public static void onInventoryClick(InventoryClickEvent e) {
        if (!e.getInventory().equals(inv)) return;
        e.setCancelled(true);
        final ItemStack clickedItem = e.getCurrentItem();
        // verify current item is not null
        if (clickedItem == null || clickedItem.getType().isAir()) return;
        final Player p = (Player) e.getWhoClicked();
        if (Objects.requireNonNull(Objects.requireNonNull(clickedItem.getItemMeta()).getLore()).contains("Lucky enchant:")) {
            if (e.getClick().isShiftClick()) {
                if (isupgradeable_lucky(lucky_level, 100)) {
                    if (balance > (luckyPrice(lucky_level, 100))) {
                        balance -= luckyPrice(lucky_level, 100);
                        lucky_level += 100;
                        p.sendMessage(String.valueOf(balance));
                        p.sendMessage("Your lucky level is now " + lucky_level);
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        inv.setItem(0, createluckybook());
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isLeftClick()) {
                if (isupgradeable_lucky(lucky_level, 1)) {

                    if (balance > (luckyPrice(lucky_level, 1))) {
                        balance -= luckyPrice(lucky_level, 1);
                        lucky_level += 1;
                        p.sendMessage(String.valueOf(balance));
                        p.sendMessage("Your lucky level is now " + lucky_level);
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        inv.setItem(0, createluckybook());
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isRightClick()) {
                if (isupgradeable_lucky(lucky_level, 10)) {

                    if (balance > luckyPrice(lucky_level, 10)) {
                        balance -= luckyPrice(lucky_level, 10);
                        lucky_level += 10;
                        p.sendMessage(String.valueOf(balance));
                        p.sendMessage("Your lucky level is now " + lucky_level);
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        inv.setItem(0, createluckybook());
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else {
                e.setCancelled(true);
                p.sendMessage("Unable to upgrade lucky at this time. Try checking balance");
            }
        } else if (Objects.requireNonNull(clickedItem.getItemMeta()).getDisplayName().equals("Demolish enchant")) {
            if (e.getClick().isShiftClick()) {
                if (isupgradeable_demolish(demolish_level, 100)) {
                    if (balance > (demolishPrice(demolish_level, 100))) {
                        balance -= demolishPrice(demolish_level, 100);
                        demolish_level += 100;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(1, createdemolishbook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isLeftClick()) {
                if (isupgradeable_demolish(demolish_level, 1)) {

                    if (balance > (demolishPrice(demolish_level, 1))) {
                        balance -= demolishPrice(demolish_level, 1);
                        demolish_level += 1;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(1, createdemolishbook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isRightClick()) {
                if (isupgradeable_demolish(demolish_level, 10)) {

                    if (balance > demolishPrice(demolish_level, 10)) {
                        balance -= demolishPrice(demolish_level, 10);
                        demolish_level += 10;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(1, createdemolishbook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else {
                e.setCancelled(true);
                p.sendMessage("Unable to upgrade demolish at this time. Try checking balance");
            }
        } else if (Objects.requireNonNull(clickedItem.getItemMeta()).getDisplayName().equals("Fortune enchant")) {
            if (e.getClick().isShiftClick()) {
                if (isupgradeable_fortune(fortune_level, 100)) {
                    if (balance > (fortunePrice(fortune_level, 100))) {
                        balance -= fortunePrice(fortune_level, 100);
                        fortune_level += 100;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(2, createfortunebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isLeftClick()) {
                if (isupgradeable_fortune(fortune_level, 1)) {

                    if (balance > (fortunePrice(fortune_level, 1))) {
                        balance -= fortunePrice(fortune_level, 1);
                        fortune_level += 1;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(2, createfortunebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isRightClick()) {
                if (isupgradeable_fortune(fortune_level, 10)) {

                    if (balance > fortunePrice(fortune_level, 10)) {
                        balance -= fortunePrice(fortune_level, 10);
                        fortune_level += 10;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(2, createfortunebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else {
                e.setCancelled(true);
                p.sendMessage("Unable to upgrade fortune at this time. Try checking balance");
            }
        } else if (Objects.requireNonNull(clickedItem.getItemMeta()).getDisplayName().equals("Efficiency enchant")) {
            if (e.getClick().isShiftClick()) {
                if (isupgradeable_efficiency(efficiency_level, 100)) {
                    if (balance > (efficiencyPrice(efficiency_level, 100))) {
                        balance -= efficiencyPrice(efficiency_level, 100);
                        efficiency_level += 100;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(3, createefficiencybook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isLeftClick()) {
                if (isupgradeable_efficiency(efficiency_level, 1)) {

                    if (balance > (efficiencyPrice(efficiency_level, 1))) {
                        balance -= efficiencyPrice(efficiency_level, 1);
                        efficiency_level += 1;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(3, createefficiencybook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isRightClick()) {
                if (isupgradeable_efficiency(efficiency_level, 10)) {

                    if (balance > efficiencyPrice(efficiency_level, 10)) {
                        balance -= efficiencyPrice(efficiency_level, 10);
                        efficiency_level += 10;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(3, createefficiencybook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else {
                e.setCancelled(true);
                p.sendMessage("Unable to upgrade efficiency at this time. Try checking balance");
            }
        } else if (Objects.requireNonNull(clickedItem.getItemMeta()).getDisplayName().equals("Fracture enchant")) {
            if (e.getClick().isShiftClick()) {
                if (isupgradeable_fracture(fracture_level, 100)) {
                    if (balance > (fracturePrice(fracture_level, 100))) {
                        balance -= fracturePrice(fracture_level, 100);
                        fracture_level += 100;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(4, createfracturebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isLeftClick()) {
                if (isupgradeable_fracture(fracture_level, 1)) {
                    if (balance > (fracturePrice(fracture_level, 1))) {
                        balance -= fracturePrice(fracture_level, 1);
                        fracture_level += 1;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(4, createfracturebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isRightClick()) {
                if (isupgradeable_fracture(fracture_level, 10)) {

                    if (balance > fracturePrice(fracture_level, 10)) {
                        balance -= fracturePrice(fracture_level, 10);
                        fracture_level += 10;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(4, createfracturebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else {
                e.setCancelled(true);
                p.sendMessage("Unable to upgrade fracture at this time. Try checking balance");
            }
        }
        else if (Objects.requireNonNull(clickedItem.getItemMeta()).getDisplayName().equals("shockwave enchant")) {
            if (e.getClick().isShiftClick()) {
                if (isupgradeable_shockwave(shockwave_level, 100)) {
                    if (balance > (shockwavePrice(shockwave_level, 100))) {
                        balance -= shockwavePrice(shockwave_level, 100);
                        shockwave_level += 100;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(5, createshockwavebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isLeftClick()) {
                if (isupgradeable_shockwave(shockwave_level, 1)) {
                    if (balance > (shockwavePrice(shockwave_level, 1))) {
                        balance -= shockwavePrice(shockwave_level, 1);
                        shockwave_level += 1;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(5, createshockwavebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else if (e.getClick().isRightClick()) {
                if (isupgradeable_shockwave(fracture_level, 10)) {
                    if (balance > shockwavePrice(shockwave_level, 10)) {
                        balance -= shockwavePrice(shockwave_level, 10);
                        shockwave_level += 10;
                        p.sendMessage(String.valueOf(balance));
                        inv.setItem(5, createshockwavebook());
                        p.getInventory().getItemInMainHand().setType(Material.AIR);
                        p.getInventory().setItemInMainHand(starterpickaxe);
                        p.openInventory(inv);
                        p.updateInventory();
                    }
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            } else {
                e.setCancelled(true);
                p.sendMessage("Unable to upgrade shockwave at this time. Try checking balance");
            }
        }

    }





    public static void giveKeys(Player player, int y) {
        int random_num_mine = (int) Math.floor(Math.random()) * 100;
        int num_keys = y - (int) Math.floor(lucky_level / 100.0);
        if (random_num_mine < (lucky_level / 200)) {
            for (int x = 0; x <= num_keys - 1; x++) {
                if (current_amount_mine < max_capacity) {
                    current_amount_mine += 1;
                    player.getInventory().setItem(2, createsmallKV());
                    full_mine = false;
                } else {
                    player.getInventory().addItem(ItemManager.minekey);
                    full_mine = true;
                }
            }
        }
        int random_num_rare = y - (int) Math.floor(Math.random() * 100);
        if (random_num_rare < (lucky_level / 125)) {
            for (int x = 0; x <= (num_keys / 1.2); x++) {
                if (current_amount_rare < max_capacity) {
                    current_amount_rare += 1;
                    player.getInventory().setItem(2, createsmallKV());
                    full_rare = false;
                } else {
                    player.getInventory().addItem(ItemManager.rarekey);
                    full_rare = true;
                }
            }
        }
        int random_num_leg = y - (int) Math.floor(Math.random() * 100);
        if (random_num_leg < (lucky_level / 225)) {
            for (int x = 0; x <= (num_keys / 1.2); x++) {
                if (current_amount_legendary < max_capacity) {
                    current_amount_legendary += 1;
                    player.getInventory().setItem(2, createsmallKV());
                    full_leg = false;
                } else {
                    player.getInventory().addItem(legendarykey);
                    full_leg = true;
                }
            }
        }
        if (full_mine) {
            player.sendMessage("Your keyvault is full");
        } else if (full_rare) {
            player.sendMessage("Your keyvault is full");
        }
    }
}




