package com.vinkas.testPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.w3c.dom.css.RGBColor;

public class stormArmor {
    public static ItemStack chest() {
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);

        ItemMeta meta0 = chest.hasItemMeta() ? chest.getItemMeta() : Bukkit.getItemFactory().getItemMeta(chest.getType());

        LeatherArmorMeta leatherArmorMeta0 = (LeatherArmorMeta) meta0;

        leatherArmorMeta0.setColor(Color.fromRGB(22, 138, 183));
        leatherArmorMeta0.setDisplayName("Storm's Chestplate");
        chest.setItemMeta(leatherArmorMeta0);

        return chest;
    }public static ItemStack chestForGui() {
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);

        ItemMeta meta0 = chest.hasItemMeta() ? chest.getItemMeta() : Bukkit.getItemFactory().getItemMeta(chest.getType());

        LeatherArmorMeta leatherArmorMeta0 = (LeatherArmorMeta) meta0;

        leatherArmorMeta0.setColor(Color.fromRGB(22, 138, 183));
        leatherArmorMeta0.setDisplayName("Storm's Armor");
        chest.setItemMeta(leatherArmorMeta0);

        return chest;
    }public static ItemStack leggings() {

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);

        ItemMeta meta1 = leggings.hasItemMeta() ? leggings.getItemMeta() : Bukkit.getItemFactory().getItemMeta(leggings.getType());

        LeatherArmorMeta leatherArmorMeta1 = (LeatherArmorMeta) meta1;

        leatherArmorMeta1.setColor(Color.fromRGB(21, 156, 181));
        leatherArmorMeta1.setDisplayName("Storm's Leggings");
        leggings.setItemMeta(leatherArmorMeta1);

        return leggings;
    }public static ItemStack boots() {

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

        ItemMeta meta2 = boots.hasItemMeta() ? boots.getItemMeta() : Bukkit.getItemFactory().getItemMeta(boots.getType());

        LeatherArmorMeta leatherArmorMeta2 = (LeatherArmorMeta) meta2;

        leatherArmorMeta2.setColor(Color.fromRGB(27, 179, 212));
        leatherArmorMeta2.setDisplayName("Storm's Boots");

        boots.setItemMeta(leatherArmorMeta2);
        return boots;
    }
}
