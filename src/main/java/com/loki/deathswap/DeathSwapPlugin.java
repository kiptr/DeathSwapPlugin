package com.loki.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.ArrayList;

public class DeathSwapPlugin extends JavaPlugin {
    private boolean gameRunning = false;
    private List<Player> players = new ArrayList<>();

    @Override
    public void onEnable() {
        getLogger().info("DeathSwap Plugin Enabled!");
        getServer().getPluginManager().registerEvents(new DeathSwapListener(this), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("DeathSwap Plugin Disabled!");
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public boolean isPLayerInGame(Player player) {
        return players.contains(player);
    }

    public void endGame(String winnerName) {
        Bukkit.broadcastMessage("The game is over! " + winnerName + " wins!");
        players.clear();
        gameRunning = false;
    }
}