package dev.zeeppss.pinfogui.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnlineClickEvent implements Listener {

    @EventHandler
    public void onOnline(InventoryClickEvent event) {
        Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
        Player player = (Player)event.getWhoClicked();
        if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR && event.getInventory().getName().equals("Current Players [" + players.length + "]")) {
            event.setCancelled(true);
            player.updateInventory();
        }

    }
}
