package dev.zeeppss.pinfogui.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OnlineGUI implements Listener {
    public static void onOnlineGUI(Player player) {
        Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
        ItemStack item = new ItemStack(Material.SKULL_ITEM);
        ItemMeta meta = item.getItemMeta();
        item.setDurability((short)3);
        Inventory inv = Bukkit.createInventory(player, 27, "Current Players [" + players.length + "]");

        for(int i = 0; i < players.length; ++i) {
            meta.setDisplayName(ChatColor.GREEN + players[i].getName());
            ArrayList<String> lore = new ArrayList();
            lore.add(ChatColor.WHITE + "Hold Items: " + ChatColor.GREEN + players[i].getItemInHand());
            lore.add(ChatColor.WHITE + "Current Level : " + ChatColor.GREEN + players[i].getLevel());
            lore.add(ChatColor.WHITE + "Health : " + ChatColor.GREEN + players[i].getHealth());
            lore.add(ChatColor.WHITE + "Food Level : " + ChatColor.GREEN + players[i].getFoodLevel());
            lore.add(ChatColor.WHITE + "Gamemode: " + ChatColor.GREEN + players[i].getGameMode());
            lore.add(ChatColor.WHITE + "Time: " + ChatColor.GREEN + players[i].getPlayerTime());
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(i, item);
        }
        player.openInventory(inv);
    }
}
