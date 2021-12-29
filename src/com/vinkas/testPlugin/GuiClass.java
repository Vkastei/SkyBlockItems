package com.vinkas.testPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class GuiClass implements Listener {

    public static Inventory inv;

    public GuiClass() {
        inv = Bukkit.createInventory(null, 9, "Items");
        initializeItems();
    }


    public void initializeItems() {
        inv.addItem(CustomItems.hyperionItem);
        inv.addItem(CustomItems.terminator);
        inv.addItem(CustomItems.spacehelm);
        inv.addItem(CustomItems.protbar);
        inv.addItem(CustomItems.canon);
        inv.addItem(CustomItems.aotv);
        inv.addItem(CustomItems.sceptre);
        inv.addItem(blackArmor.chestForGui());
        inv.addItem(stormArmor.chestForGui());
    }
    @EventHandler
    public void onInventoryClick(InventoryDragEvent e1) {

        if (e1.getInventory().equals(inv)) {
            e1.setCancelled(true);
        }
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if(e.getInventory().equals(inv)){

            if(e.getCurrentItem().equals(CustomItems.hyperionItem)){
                e.setCancelled(true);
                p.getInventory().addItem(CustomItems.hyperionItem);
            }if(e.getCurrentItem().equals(CustomItems.terminator)){
                e.setCancelled(true);
                p.getInventory().addItem(CustomItems.terminator);
            }if(e.getCurrentItem().equals(CustomItems.canon)){
                e.setCancelled(true);
                p.getInventory().addItem(CustomItems.canon);
            }if(e.getCurrentItem().equals(CustomItems.aotv)){
                e.setCancelled(true);
                p.getInventory().addItem(CustomItems.aotv);
            }if(e.getCurrentItem().equals(CustomItems.sceptre)){
                e.setCancelled(true);
                p.getInventory().addItem(CustomItems.sceptre);
            }if(e.getCurrentItem().equals(CustomItems.spacehelm)){
                e.setCancelled(true);
                p.getInventory().addItem(CustomItems.spacehelm);
            }if(e.getCurrentItem().equals(CustomItems.protbar)){
                e.setCancelled(true);
                p.getInventory().addItem(CustomItems.protbar);
            }if(e.getCurrentItem().equals(blackArmor.chestForGui())){
                e.setCancelled(true);
                p.getInventory().addItem(blackArmor.chest());
                p.getInventory().addItem(blackArmor.boots());
                p.getInventory().addItem(blackArmor.leggings());
            }if(e.getCurrentItem().equals(stormArmor.chestForGui())){
                e.setCancelled(true);
                p.getInventory().addItem(stormArmor.chest());
                p.getInventory().addItem(stormArmor.boots());
                p.getInventory().addItem(stormArmor.leggings());
            }
        }

    }


}
