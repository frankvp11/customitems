package me.frankvanpaassen.customitems;


import me.frankvanpaassen.customitems.ItemEvents.resetMine;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;



import static me.frankvanpaassen.customitems.ItemManager.smallKV;
import static me.frankvanpaassen.customitems.ItemManager.starterpickaxe;
import static me.frankvanpaassen.customitems.Sell.balance;
import static me.frankvanpaassen.customitems.Sell.clearingInventory;

public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
                Player player = (Player)sender;
            if (player.hasPermission("op")) {
                if (cmd.getName().equalsIgnoreCase("giveteleportsword")){
                    player.getInventory().addItem(ItemManager.TeleportSword);
                }
                if(cmd.getName().equalsIgnoreCase("givestarterpickaxe")){
                    player.getInventory().addItem(starterpickaxe);
                }
                if(cmd.getName().equalsIgnoreCase("giveminekey")){
                    player.getInventory().addItem(ItemManager.minekey);
               }
                if(cmd.getName().equalsIgnoreCase("sell")){
                    clearingInventory(player);
                }
                if(cmd.getName().equalsIgnoreCase("bal")){
                    Sell.balanceCheck(player);
                }
                if(cmd.getName().equalsIgnoreCase("rm")){
                    resetMine.reset(player);
                }
                if(cmd.getName().equalsIgnoreCase("flv")){
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.updateCommands();
                }
                if(cmd.getName().equalsIgnoreCase("balanceadd")){
                    Sell.giveBalance(player);
                }
                if(cmd.getName().equalsIgnoreCase("givesmallKV")){
                    player.getInventory().setItem(2, smallKV);
                }
                if(args.length == 2 && args[0].equalsIgnoreCase("balancegive")){
                    try {
                        int amount = Integer.parseInt(args[1]);
                        balance += amount;
                    } finally {
                        player.sendMessage("Your balance is now:" + balance);
                    }
                }
            }
            else {
                sender.sendMessage("You are not allowed to use this command");
            }
            return true;
        }
        else {
            sender.sendMessage("Only players can use that command");
            return true;
        }
    }
}
