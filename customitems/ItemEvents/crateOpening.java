package me.frankvanpaassen.customitems.ItemEvents;
import me.frankvanpaassen.customitems.Sell;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static me.frankvanpaassen.customitems.GUICreation.*;
import static me.frankvanpaassen.customitems.ItemManager.*;
import static me.frankvanpaassen.customitems.Sell.upgradeBalance;

public class crateOpening implements Listener {



    @EventHandler
    public static void RightClick(PlayerInteractEvent event){
        Location minechest = new Location(event.getPlayer().getWorld(), 55, 88, 55);
        Block minechestBlock = minechest.getBlock();
        minechestBlock.setType(Material.CHEST);
        List<ItemStack> items = new ArrayList<>();
        items.add(token1);
        items.add(token2);

        Player player = event.getPlayer();
        if((event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && (player.isSneaking()))){
            event.setCancelled(true);
            if(Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equals("small keyvault")){
                player.sendMessage("Test 2 passed");
                if(Objects.requireNonNull(event.getClickedBlock()).getType().equals(Material.CHEST)){
                    player.sendMessage("Test 3 passed");
                    if(event.getClickedBlock().getLocation().equals(minechest)) {
                        for (int x = 0; x <= current_amount_mine; x++) {
                            Random randomelement = new Random();
                            ItemStack randomElement = items.get(randomelement.nextInt(items.size()));
                            if (randomElement.equals(token1)) {
                                upgradeBalance(player, 100);
                                player.sendMessage("Congratulations! You won 100 tokens");
                            } else if (randomElement.equals(token2)) {
                                upgradeBalance(player, 150);
                                player.sendMessage("Congratulations! You won 150 tokens");
                            }
                        }
                        current_amount_mine = 0;
                        player.getInventory().setItem(2, createsmallKV());
                        player.updateInventory();
                    }

                    Location rarechest = new Location(event.getPlayer().getWorld(), 57, 88, 55);
                    Block rarechestBlock = minechest.getBlock();
                    rarechestBlock.setType(Material.CHEST);
                    List<ItemStack> items2 = new ArrayList<>();
                    items2.add(token3);
                    items2.add(token4);

                    if(event.getClickedBlock().getLocation().equals(rarechest)) {
                        for (int x = 0; x <= current_amount_rare; x++) {
                            ItemStack randomElement2 = items2.get(new Random().nextInt(2));
                            if (randomElement2.equals(token3)) {
                                upgradeBalance(player, 200);
                                player.sendMessage("Congratulations! You won 200 tokens");
                            }
                            else if (randomElement2.equals(token3)) {
                                upgradeBalance(player, 250);
                                player.sendMessage("Congratulations! You won 250 tokens");
                            }
                        }
                        current_amount_rare= 0;
                        player.getInventory().setItem(2, createsmallKV());
                        player.updateInventory();
                    }
                }
            }
        }
        else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equals("mine key")){
                if(Objects.requireNonNull(event.getClickedBlock()).getType().equals(Material.CHEST)) {
                    if (event.getClickedBlock().getLocation().equals(minechest)) {
                        event.setCancelled(true);
                        Random randomelement = new Random();
                        ItemStack randomElement = items.get(randomelement.nextInt(items.size()));
                        int total_mine_key_stack = player.getInventory().getItemInMainHand().getAmount();
                        if (randomElement.equals(token1)) {
                            upgradeBalance(player, 150);
                            player.sendMessage("Congratulations! You won 100 tokens");
                            player.getInventory().getItemInMainHand().setAmount(total_mine_key_stack - 1);
                        } else if (randomElement.equals(token2)) {
                            upgradeBalance(player, 150);
                            player.sendMessage("Congratulations! You won 150 tokens");
                            player.getInventory().getItemInMainHand().setAmount(total_mine_key_stack - 1);
                        }
                    }
                }
            }
        }
    }
}
