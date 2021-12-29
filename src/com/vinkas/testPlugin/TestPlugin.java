package com.vinkas.testPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin{
    private static TestPlugin instance;

    public static TestPlugin getInstance() {
        return TestPlugin.instance;
    }
    @Override
    public void onEnable() {

        TestPlugin.instance = this;
        CustomItems.init();

        PluginCommands commands = new PluginCommands();
        //GuiClass gclass = new GuiClass();
        getCommand("boss").setExecutor(commands);
        getCommand("necron").setExecutor(commands);
        getCommand("storm").setExecutor(commands);
        getCommand("itemsgui").setExecutor(commands);

        getServer().getPluginManager().registerEvents(new CustomItems(), this);
        getServer().getPluginManager().registerEvents(new GuiClass(), this);

    }

    @Override
    public void onDisable() {

    }
}
