package me.frankvanpaassen.customitems;

import org.bukkit.Material;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.frankvanpaassen.customitems.GUICreation.*;


public class ItemManager {

    public static ItemStack TeleportSword;
    public static ItemStack minekey;
    public static ItemStack rarekey;
    public static ItemStack legendarykey;
    public static ItemStack token1 = createtoken1();
    public static ItemStack token2 = createtoken2();
    public static ItemStack token3 = createtoken3();
    public static ItemStack token4 = createtoken4();
    public static ItemStack token5 = createtoken5();
    public static ItemStack token6 = createtoken6();
    public static ItemStack starterpickaxe = createStarterPick();
    public static ItemStack efficiencybook = createefficiencybook();
    public static ItemStack fortunebook = createfortunebook();
    public static ItemStack luckybook = createluckybook();
    public static ItemStack demolishbook = createdemolishbook();
    public static ItemStack fracturebook = createfracturebook();
    public static ItemStack shockwavebook = createshockwavebook();
    public static ItemStack smallKV = createsmallKV();


    public static void init() {
        createTeleportSword();
        createminekey();
        createrarekey();

    }

    private static void createTeleportSword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Teleport Sword");
        List<String> lore = new ArrayList<>();
        lore.add("This sword has teleport powers.");
        lore.add("Item Ability (Right Click):");
        lore.add("Teleport 8 blocks ahead");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        TeleportSword = item;
    }


    private static void createminekey(){
        ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("mine key");
        List<String> lore = new ArrayList<>();
        lore.add("mine crate key");
        lore.add("Open at /warp crates");
        meta.setLore(lore);
        item.setItemMeta(meta);
        minekey = item;

    }
    private static void createrarekey(){
        ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("rare key");
        List<String> lore = new ArrayList<>();
        lore.add("rare crate key");
        lore.add("Open at /warp crates");
        meta.setLore(lore);
        item.setItemMeta(meta);
        rarekey = item;
    }
    private static void createlegendarykey(){
        ItemStack item = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("legendary key");
        List<String> lore = new ArrayList<>();
        lore.add("legendary crate key");
        lore.add("Open at /warp crates");
        meta.setLore(lore);
        item.setItemMeta(meta);
        legendarykey = item;
    }
    public static ItemStack createsmallKV() {
        ItemStack item = new ItemStack(Material.DISPENSER, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("small keyvault");
        List<String> lore = new ArrayList<>();
        lore.add("" + current_amount_mine + "/ " + "150" + " Mine Keys");
        lore.add("" + current_amount_rare + "/" + "100" + "Rare keys");
        meta.setLore(lore);
        item.setItemMeta(meta);
        smallKV = item;
        return smallKV;
    }
    public static ItemStack createdemolishbook() {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Demolish enchant");
        List<String> lore = new ArrayList<>();
        lore.add("Demolish enchant:");
        lore.add("Upgrading gives you a chance to break 3x3x3 blocks");
        lore.add("Current level: " + demolish_level);
        meta.setLore(lore);
        item.setItemMeta(meta);
        demolishbook = item;
        return item;
    }
    public static ItemStack createefficiencybook() {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Efficiency enchant");
        List<String> lore = new ArrayList<>();
        lore.add("Efficiency enchant:");
        lore.add("Upgrading me lets you mine faster");
        lore.add("Current level: " + efficiency_level);
        meta.setLore(lore);
        item.setItemMeta(meta);
        efficiencybook = item;
        return item;
    }

    public static ItemStack createfortunebook() {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Fortune enchant");
        List<String> lore = new ArrayList<>();
        lore.add("Fortune enchant:");
        lore.add("Upgrading me gives you more blocks");
        lore.add("Current level: " + fortune_level);
        meta.setLore(lore);
        item.setItemMeta(meta);
        fortunebook = item;
        return item;
    }

    public static ItemStack createluckybook() {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Lucky enchant");
        List<String> lore = new ArrayList<>();
        lore.add("Lucky enchant:");
        lore.add("Upgrading me gives you more keys");
        lore.add("Current level: " + (lucky_level));
        meta.setLore(lore);
        item.setItemMeta(meta);
        luckybook = item;
        return item;
    }

    public static ItemStack createfracturebook() {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Fracture enchant");
        List<String> lore = new ArrayList<>();
        lore.add("Fracture enchant:");
        lore.add("Upgrading me gives you a chance to strike down lightning");
        lore.add("Current level: " + (fracture_level));
        meta.setLore(lore);
        item.setItemMeta(meta);
        fracturebook = item;
        return item;
    }
    public static ItemStack createshockwavebook() {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("shockwave enchant");
        List<String> lore = new ArrayList<>();
        lore.add("shockwave enchant:");
        lore.add("Upgrading me gives you a chance to clear a whole layer of the mine");
        lore.add("Current level: " + (shockwave_level));
        meta.setLore(lore);
        item.setItemMeta(meta);
        shockwavebook = item;
        return item;
    }


    public static ItemStack createtoken1() {
        ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Token1");
        List<String> lore = new ArrayList<>();
        lore.add("Worth:");
        lore.add("$100");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createtoken2() {
        ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Token2");
        List<String> lore = new ArrayList<>();
        lore.add("Worth:");
        lore.add("$150");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createtoken3() {
        ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Token3");
        List<String> lore = new ArrayList<>();
        lore.add("Worth:");
        lore.add("$200");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createtoken4() {
        ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Token4");
        List<String> lore = new ArrayList<>();
        lore.add("Worth:");
        lore.add("$250");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }



    public static ItemStack createtoken5() {
        ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Token5");
        List<String> lore = new ArrayList<>();
        lore.add("Worth:");
        lore.add("$2000");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createtoken6() {
        ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Token6");
        List<String> lore = new ArrayList<>();
        lore.add("Worth:");
        lore.add("$2500");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack createStarterPick() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Starter Pickaxe");
        meta.addEnchant(Enchantment.DIG_SPEED, 15 + efficiency_level, true);
        List<String> lore = new ArrayList<>();
        lore.add("Starter pickaxe");
        lore.add("Efficency:" + efficiency_level);
        lore.add("Lucky:" + lucky_level);
        lore.add("Fortune:" + fortune_level);
        lore.add("Demolish" + demolish_level);
        lore.add("Fracture" + fracture_level);
        lore.add("ShockWave:" + shockwave_level);
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        starterpickaxe = item;
        return item;
    }

}



    

