package me.frankvanpaassen.customitems;



import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;


import java.util.Objects;




public class Sell implements Listener {
    public static int balance = 0;


    public static void clearingInventory(Player player) {
        player.sendMessage("Selling inventory now");
        int total = 0;
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null) {

                if (Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals("mine key")) {
                    continue;
                } else if (Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals("Starter Pickaxe")) {
                    continue;
                } else if (item.getItemMeta().getDisplayName().equals("small keyvault")){
                    continue;
                }
                else {
                    total += item.getAmount();
                    item.setAmount(0);
                }
            }
            player.updateInventory();
        }
        player.sendMessage("success! You made: $" + total);
        upgradeBalance(player, total);
        total = 0;


    }


    public static void balanceCheck(Player player){
        player.sendMessage("Your balance is: " + upgradeBalance(player, 0));
    }



    public static void giveBalance(Player player) {
        upgradeBalance(player, 100000000);
        player.sendMessage("Your new balance is: " + upgradeBalance(player,0) + " tokens");
    }
    public static int upgradeBalance(Player player, int x){
        balance += x;
        return balance;
    }

}


