package com.vinkas.testPlugin;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.concurrent.ThreadLocalRandom;

public class PluginCommands implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        if(!(sender instanceof Player)){
            sender.sendMessage("This Plugin Works!");
            return true;
        }

        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("boss1")){
            Giant zombie = player.getWorld().spawn(player.getLocation(), Giant.class);
            zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000);
            zombie.setHealth(1000);
            zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        }

       if(cmd.getName().equalsIgnoreCase("itemsgui")){
           player.sendMessage("opened: " + ChatColor.RED + "Skyblock Items GUI");
           GuiClass gc = new GuiClass();
           player.openInventory(GuiClass.inv);
       }
        if(cmd.getName().equalsIgnoreCase("blackStorm")){

            player.getEquipment().setChestplate(blackArmor.chest());
            player.getEquipment().setLeggings(blackArmor.leggings());
            player.getEquipment().setBoots(blackArmor.boots());
        }if(cmd.getName().equalsIgnoreCase("storm")){
            player.getEquipment().setChestplate(stormArmor.chest());
            player.getEquipment().setLeggings(stormArmor.leggings());
            player.getEquipment().setBoots(stormArmor.boots());
        }
        return true;

    }



}
