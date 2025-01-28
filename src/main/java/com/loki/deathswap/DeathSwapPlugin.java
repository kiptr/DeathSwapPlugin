package com.loki.deathswap;

import org.bukkit.plugin.java.JavaPlugin;

public class DeathSwapPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("DeathSwap Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("DeathSwap Plugin Disabled!");
    }
}