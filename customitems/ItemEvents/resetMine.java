package me.frankvanpaassen.customitems.ItemEvents;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class resetMine implements Listener {
    public static void reset(Player player) {
        List<Material> blocks = new ArrayList<>();
        blocks.add(Material.COBBLESTONE);
        blocks.add(Material.GOLD_ORE);
        blocks.add(Material.IRON_ORE);
        blocks.add(Material.COAL_ORE);
        for (int x = 0; x <= 50; x++) {
            for (int y = 70; y <= 170; y++) {
                for (int z = 0; z <= 50; z++) {
                    int playerblocky = player.getLocation().getBlockY();
                    int playerx = player.getLocation().getBlockX();
                    int playerz = player.getLocation().getBlockZ();
                    Location new_playerloc = new Location(player.getWorld(), playerx, 88, playerz);
                    if (playerblocky == y){
                        player.teleport(new_playerloc);
                    }
                    Location loc = new Location(player.getWorld(), x, y, z);
                    Block block = loc.getBlock();
                    Random randomelement = new Random();
                    block.setType(blocks.get(randomelement.nextInt(blocks.size())));
                }
            }
        }
    }
}