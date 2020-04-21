package com.github.legendtomo.joinquitmessage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new events(this),this);

        getConfig().options().copyDefaults(true);
        saveConfig();

        getCommand("joinquitmessage").setExecutor(new commands(this));
        getCommand("joinquitmessage").setTabCompleter(new tabcompletion());
    }
}
