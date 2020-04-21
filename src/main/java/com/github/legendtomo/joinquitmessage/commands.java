package com.github.legendtomo.joinquitmessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commands implements CommandExecutor {
    private main plugin;
    public commands(main pl){
        plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("joinquitmessage")){
            if (args[0].equalsIgnoreCase("reload")){
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "reload config");
            }
        }
        return false;
    }
}
