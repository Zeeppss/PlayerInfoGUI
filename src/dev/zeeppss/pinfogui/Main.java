package dev.zeeppss.pinfogui;

import dev.zeeppss.pinfogui.listeners.OnlineClickEvent;
import dev.zeeppss.pinfogui.menus.OnlineGUI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public Main() {
    }

    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new OnlineGUI(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnlineClickEvent(), this);
    }

    @EventHandler(
            priority = EventPriority.HIGH
    )

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player)sender;
        if (commandLabel.equalsIgnoreCase("online") && sender instanceof Player) {
            OnlineGUI.onOnlineGUI(player);
        }
        return false;
    }
}

