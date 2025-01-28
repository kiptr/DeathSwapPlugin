package com.loki.deathswap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathSwapListener implements Listener {
    private final DeathSwapPlugin plugin;

    public DeathSwapListener(DeathSwapPlugin plugin) {
        this.plugin = plugin;
    }

}
