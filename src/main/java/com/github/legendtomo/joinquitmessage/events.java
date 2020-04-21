package com.github.legendtomo.joinquitmessage;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class events implements Listener {
    private main plugin;
    public events(main pl){
        this.plugin = pl;
    }

    @EventHandler
    public void JoinMessage(PlayerJoinEvent joinevent) {
        Player player = joinevent.getPlayer();
        String name = player.getName();
        boolean enabled = plugin.getConfig().getBoolean("custom-message");
        if (enabled) {
            String joinmessagecfg = plugin.getConfig().getString("joinmessage");
            String joinmessage = joinmessagecfg.replace("[player]",name);
            for (Player players : Bukkit.getOnlinePlayers()) {
                joinevent.setJoinMessage(joinmessage);
            }
        } else {
            joinevent.setJoinMessage(ChatColor.GREEN + "Join" + ChatColor.WHITE + " » " + ChatColor.GOLD + ChatColor.BOLD + name);
        }
        player.sendTitle("welcome!",null,0,60,10);

    }

    @EventHandler
    public void QuitMessage (PlayerQuitEvent quitevent) {
        Player player = quitevent.getPlayer();
        String name = player.getName();
        boolean enabled = plugin.getConfig().getBoolean("custom-message");
        if (enabled) {
            String quitmessagecfg = plugin.getConfig().getString("quitmessage");
            String quitmessage = quitmessagecfg.replace("[player]",name);
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage(quitmessage);
            }
        } else {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage(ChatColor.GREEN + "Join" + ChatColor.WHITE + " » " + ChatColor.GOLD + ChatColor.BOLD + name);
            }
        }
    }
}
