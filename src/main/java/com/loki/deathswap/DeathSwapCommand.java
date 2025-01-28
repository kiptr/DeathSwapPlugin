package com.loki.deathswap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathSwapCommand {
    private DeathSwapPlugin plugin;

    public DeathSwapCommand(DeathSwapPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("deathswap")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Usage: /deathswap join | /deathswap start");
                return false;
            }

            if (args[0].equalsIgnoreCase("join")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;

                    if (plugin.getPlayers().size() >= 2) {
                        player.sendMessage(ChatColor.RED + "Sorry, the game is already full.");
                        return false;
                    }

                    plugin.getPlayers().add(player);
                    player.sendMessage(ChatColor.GREEN + "You have joined the DeathSwap game!");

                    if (plugin.getPlayers().size() == 2) {
                        plugin.getServer().broadcastMessage(
                                ChatColor.GOLD + "Two players have joined! Use /deathswap start to begin.");
                    }
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("start")) {
                if (plugin.getPlayers().size() < 2) {
                    sender.sendMessage(ChatColor.RED + "You need two players to start the game.");
                    return false;
                }

                if (plugin.isGameRunning()) {
                    sender.sendMessage(ChatColor.RED + "The game is already started.");
                    return false;
                }

                plugin.setGameRunning(true);
                plugin.startDeathSwap();
                sender.sendMessage(ChatColor.GREEN + "The DeathSwap game has started!");
                return true;
            }
        }
        return false;
    }
}
