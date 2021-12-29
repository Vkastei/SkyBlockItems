package com.vinkas.testPlugin;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Snow;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.block.Action;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.sql.Array;
import java.util.*;

public class CustomItems implements Listener {

    public static ItemStack hyperionItem;
    public static ItemStack terminator;
    public static ItemStack sceptre;
    public static ItemStack aots;
    public static ItemStack canon;
    public static ItemStack protbar;
    public static ItemStack spacehelm;
    public static ItemStack aotv;
    private final TestPlugin plugin = TestPlugin.getInstance();
    public int length = 10;
    public int hypedmg = 300;


    public static void init(){
        createHype();
        createTerm();
        createAots();
        createSceptre();
        createProtBar();
        createCanon();
        createSpaceHelm();
        createAotv();

    }
    private static void createAotv(){
        ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Aspect of the Void");
        item.setItemMeta(meta);
        aotv = item;

    }private static void createHype() {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Hyperion");
        item.setItemMeta(meta);
        hyperionItem = item;
    }
    private static void createSpaceHelm(){
        ItemStack item = new ItemStack(Material.RED_STAINED_GLASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Dctr's Space Helmet");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC +"A rare space helmet forged ");
        lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "from shards of moon glass.");
        lore.add("");
        lore.add(ChatColor.RESET + "" + ChatColor.GRAY + "To: " + ChatColor.GREEN + "[VIP+]ACoolBoy ");
        lore.add(ChatColor.RESET + "" + ChatColor.GRAY +"From: " + ChatColor.RED + "[ADMIN] Dctr");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Edition #420");
        lore.add(ChatColor.DARK_GRAY + "December 2021");
        lore.add("");
        lore.add(ChatColor.RED + "" + ChatColor.BOLD  + "" + ChatColor.BOLD + "SPECIAL HELMET");

        meta.setLore(lore);
        item.setItemMeta(meta);
        spacehelm = item;

    }private static void createCanon(){
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Canon");
        item.setItemMeta(meta);
        canon = item;

    }
    private static void createTerm(){
        ItemStack item2 = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item2.getItemMeta();
        meta.setDisplayName("Terminator");
        item2.setItemMeta(meta);
        terminator = item2;

    }
    private static void createAots(){
        ItemStack item3 = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta meta = item3.getItemMeta();
        meta.setDisplayName("AOTS");
        item3.setItemMeta(meta);
        aots = item3;

    }
    private static void createSceptre(){
        ItemStack item4 = new ItemStack(Material.ALLIUM, 1);
        ItemMeta meta = item4.getItemMeta();
        meta.setDisplayName("Spirit Sceptre");
        item4.setItemMeta(meta);
        sceptre = item4;

    }
    private static void createProtBar(){
        ItemStack item5= new ItemStack(Material.ORANGE_TULIP, 1);
        ItemMeta meta = item5.getItemMeta();
        meta.setDisplayName("Protective Barrier");
        item5.setItemMeta(meta);
        protbar = item5;
    }


    @EventHandler
    public void OnRightClick(PlayerInteractEvent e){

        double radius = 5;
        double radPerSec = 0;
        double radPerTick = radPerSec / 0;
        boolean isRunning = false;
        List<Material> materials = Arrays.asList(Material.RED_STAINED_GLASS, Material.GREEN_STAINED_GLASS, Material.BLUE_STAINED_GLASS, Material.CYAN_STAINED_GLASS, Material.LIGHT_BLUE_STAINED_GLASS, Material.ORANGE_STAINED_GLASS);

        Player p = e.getPlayer();
        World w = p.getWorld();

        Location location = p.getLocation();
        //Hyperion
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if(p.getInventory().getItemInMainHand().equals(hyperionItem) || p.getInventory().getItemInMainHand().equals("Hyperion")){
                Location loc1 = p.getLocation();
                w.createExplosion(loc1, 0.0F, false);
                Block b = p.getTargetBlock((Set<Material>)null, length);
                Location loc = new Location(b.getWorld(), b.getX(), b.getY(), b.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
                p.teleport(loc);
                p.setHealth(20);

                for(Entity ent : p.getNearbyEntities(5, 5, 5))
                {

                    int i = 0;
                    i++;

                    //ent.remove();
                    ((LivingEntity)ent).damage(hypedmg);

                    Random r1 = new Random();
                    p.sendMessage(ChatColor.GRAY + "Your Implosion hit " + ChatColor.RED + i + ChatColor.GRAY + " enemy for " + ChatColor.RED + r1.nextInt((1000000000-100000000) + 100000000) + ChatColor.GRAY + " damage.");
                }

            }
        }if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(p.getInventory().getItemInMainHand().equals(hyperionItem) || p.getInventory().getItemInMainHand().equals("Hyperion")){
                w.createExplosion(p.getLocation(), 0.0F, false);

                p.setHealth(20);

                for(Entity ent : p.getNearbyEntities(5, 5, 5))
                {

                    int i = 0;
                    i++;

                    //ent.remove();
                    ((LivingEntity)ent).damage(hypedmg);

                    Random r1 = new Random();
                    p.sendMessage(ChatColor.GRAY + "Your Implosion hit " + ChatColor.RED + i + ChatColor.GRAY + " enemy for " + ChatColor.RED + r1.nextInt((1000000000-100000000) + 100000000) + ChatColor.GRAY + " damage.");
                }

            }
        }
        //Terminator
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if(p.getInventory().getItemInMainHand().equals(terminator)){

                Arrow arrow = p.launchProjectile(Arrow.class);

                Arrow arrow1 = p.getWorld().spawn(p.getEyeLocation(), Arrow.class);
                Arrow arrow2 = p.getWorld().spawn(p.getEyeLocation(), Arrow.class);

                arrow1.setShooter(p);
                arrow2.setShooter(p);
                arrow1.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(8)));
                arrow2.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(-8)));
                w.playSound(location, Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 1, 1);
                arrow.playEffect(EntityEffect.FIREWORK_EXPLODE);
                arrow1.playEffect(EntityEffect.FIREWORK_EXPLODE);
                arrow2.playEffect(EntityEffect.FIREWORK_EXPLODE);
                arrow.setDamage(50);
                arrow1.setDamage(50);
                arrow2.setDamage(50);



            }
        }
        //Aots
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(p.getInventory().getItemInMainHand().equals("AOTS") || p.getInventory().getItemInMainHand().equals(aots)){


                Vector vector = new Vector(p.getLocation().getX(),p.getLocation().getY(), p.getLocation().getZ() + 2);
                p.launchProjectile(Fireball.class, vector);
            }
        }
        //Spirit Sceptre
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(p.getInventory().getItemInMainHand().equals(sceptre)){
                Bat bat = w.spawn(p.getEyeLocation(), Bat.class);
                //Vector vector2 = new Vector(p.getEyeLocation().getX(), p.getEyeLocation().getY(), p.getEyeLocation().getZ());
                bat.setVelocity(p.getLocation().getDirection().multiply(6));
                //bat.setAI(false);


                /*for(Entity ent : p.getNearbyEntities(3, 3, 3))
                {
                    if (bat.getLocation() == )
                    ent.setVisualFire(true);
                    w.createExplosion(location, 2, false, false);
                    //ent.remove();
                    ((LivingEntity)ent).damage(1);

                    p.sendMessage("Ur sceptre did " + hypedmg + " dmg");
                }*/
                if(bat.getNearbyEntities(3, 3, 3).isEmpty()){
                    p.sendMessage("Penis");
                }
            }
        }
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(p.getInventory().getItemInMainHand().equals("Protective Barrier") || p.getInventory().getItemInMainHand().equals(protbar)){

                for (Entity ent : p.getNearbyEntities(5, 5, 5)){
                    if(p.getLocation().getYaw() >= 0 && p.getLocation().getYaw() <= 40){
                        Location loc = new Location(w, ent.getLocation().getX(), ent.getLocation().getY(), ent.getLocation().getZ()+ 4);
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= 40 && p.getLocation().getYaw() <= 80){

                        Location loc = new Location(w, ent.getLocation().getX() - 4, ent.getLocation().getY(), ent.getLocation().getZ() + 4);
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= 80 && p.getLocation().getYaw() <= 120){

                        Location loc = new Location(w, ent.getLocation().getX() - 4, ent.getLocation().getY(), ent.getLocation().getZ());
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= 120 && p.getLocation().getYaw() <= 160){

                        Location loc = new Location(w, ent.getLocation().getX(), ent.getLocation().getY(), ent.getLocation().getZ() - 4);
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= 160 && p.getLocation().getYaw() <= 180){

                        Location loc = new Location(w, ent.getLocation().getX() + 1, ent.getLocation().getY(), ent.getLocation().getZ() - 4);
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= -180 && p.getLocation().getYaw() <= -140){

                        Location loc = new Location(w, ent.getLocation().getX() + 1, ent.getLocation().getY(), ent.getLocation().getZ() - 4);
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= -140 && p.getLocation().getYaw() <= -100){

                        Location loc = new Location(w, ent.getLocation().getX() + 4, ent.getLocation().getY(), ent.getLocation().getZ() -1);
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= -100 && p.getLocation().getYaw() <= -60){

                        Location loc = new Location(w, ent.getLocation().getX() + 4, ent.getLocation().getY(), ent.getLocation().getZ() + 1);
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= -60 && p.getLocation().getYaw() <= -20){

                        Location loc = new Location(w, ent.getLocation().getX() + 2, ent.getLocation().getY(), ent.getLocation().getZ() + 4);
                        ent.teleport(loc);
                    }if(p.getLocation().getYaw() >= -20 && p.getLocation().getYaw() <= 0){

                        Location loc = new Location(w, ent.getLocation().getX(), ent.getLocation().getY(), ent.getLocation().getZ() + 4);
                        ent.teleport(loc);
                    }

                }



            }
        }
        //aotv
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(p.getInventory().getItemInMainHand().equals(aotv) || p.getInventory().getItemInMainHand().equals("Aspect of the Void")){
                Location loc1 = p.getLocation();
                w.playSound(loc1, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                Block b = p.getTargetBlock((Set<Material>)null, 12);
                Location loc = new Location(b.getWorld(), b.getX(), b.getY(), b.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
                p.teleport(loc);


            }
        }//aotv
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if(p.getInventory().getItemInMainHand().equals(aotv) || p.getInventory().getItemInMainHand().equals("Aspect of the Void")){
                int i = 0;




            }
        }

        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(p.getInventory().getItemInMainHand().equals("Dctr's Space Helmet") || p.getInventory().getItemInMainHand().equals(spacehelm)){
                init();
                p.getEquipment().setHelmet(spacehelm);
                p.sendMessage("Works");
                p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);

            }
        }
        Random random = new Random();
        if(p.getEquipment().getHelmet().equals("Dctr's Space Helmet") || p.getEquipment().getHelmet().equals(spacehelm)){

            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                @Override
                public void run() {
                    int i = random.nextInt(7);
                    Material randomMat = materials.get(random.nextInt(materials.size()));
                    p.getEquipment().setHelmet(new ItemStack(randomMat));
                    if(p.getEquipment().getHelmet().getType().equals(Material.AIR)){

                        Bukkit.getServer().getScheduler().cancelTasks(plugin);
                    }
                }
            }, 0L, 5L);

        }
        if ( p.getPlayer().getLocation().getBlock().getType() == Material.WATER) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
        }


    }



    public Location getLocationAroundCircle(Location center, double radius, double angleInRadian) {
        double x = center.getX() + radius * Math.cos(angleInRadian);
        double z = center.getZ() + radius * Math.sin(angleInRadian);
        double y = center.getY();

        Location loc = new Location(center.getWorld(), x, y, z);
        Vector difference = center.toVector().clone().subtract(loc.toVector()); // this sets the returned location's direction toward the center of the circle
        loc.setDirection(difference);

        return loc;
    }


}
