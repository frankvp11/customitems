package me.frankvanpaassen.customitems;

import me.frankvanpaassen.customitems.ItemEvents.*;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class customitems extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        ItemManager.init();
        Objects.requireNonNull(this.getCommand("giveteleportsword")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("givestarterpickaxe")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("giveminekey")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("sell")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("bal")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("rm")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("flv")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("balanceadd")).setExecutor(new Commands());
        Objects.requireNonNull(this.getCommand("givesmallKV")).setExecutor(new Commands());


        this.getServer().getPluginManager().registerEvents(new TeleportSword(), this);
        this.getServer().getPluginManager().registerEvents(new GUICreation(), this);
        this.getServer().getPluginManager().registerEvents(new crateOpening(), this);
        this.getServer().getPluginManager().registerEvents(new breaking(), this);


        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
