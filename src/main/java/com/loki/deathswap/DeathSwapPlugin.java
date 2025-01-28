package com.loki.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.Location;

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

    public void startDeathSwap() {
        new BukkitRunnable() {
            int countdown = 10;

            @Override
            public void run() {
                if (countdown > 0) {
                    Bukkit.broadcastMessage(ChatColor.GOLD + "Death Swap will start in " + countdown + " seconds.");
                    countdown--;
                } else {
                    swapPlayers();
                    countdown = 10;
                }
            }
        }.runTaskTimer(this, 0L, 20L);

        new BukkitRunnable() {
            @Override
            public void run() {
                swapPlayers();
            }
        }.runTaskTimer(this, 18000L, 18000L);
    }

    public void swapPlayers() {
        if (players.size() != 2) {
            return;
        }

        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Location location1 = player1.getLocation();
        Location location2 = player2.getLocation();

        player1.teleport(location2);
        player2.teleport(location1);

        Bukkit.broadcastMessage(ChatColor.GREEN + "Players have swapped locations!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("deathswap")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Usage /deathswap join | /deathswap start");
                return false;
            }

            if (args[0].equalsIgnoreCase("join")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;

                    if (players.size() >= 2) {
                        player.sendMessage(ChatColor.RED
                                + "Sorry, the game is already full. Only 2 player allowed to do DeathSwap");
                        return false;
                    }

                    players.add(player);
                    player.sendMessage(ChatColor.GREEN + "You have joined the DeathSwap game!");

                    if (players.size() == 2) {
                        Bukkit.broadcastMessage(
                                ChatColor.GOLD + "Two players have joined! To start the game, use /deathswap start");
                    }
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("start")) {
                if (players.size() < 2) {
                    sender.sendMessage(ChatColor.RED + "You need two players to start the game.");
                    return false;
                }

                if (gameRunning) {
                    sender.sendMessage(ChatColor.RED + "The game is already started.");
                    return false;
                }

                gameRunning = true;
                sender.sendMessage(ChatColor.GREEN + "The DeathSwap game has started!");
                return true;
            }
        }
        return false;
    }
}