/*******************************************************************************
 * Copyright 2019 Puyodead1
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package io.github.puyodead1.rpbookgui;

import io.github.puyodead1.rpbookgui.commands.BookGUICommand;
import io.github.puyodead1.rpbookgui.commands.RarityInfo;
import io.github.puyodead1.rpbookgui.events.*;
import io.github.puyodead1.rpbookgui.utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.RandomPackageAPI;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.addon.EnchantRarity;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class RPBookGUI extends JavaPlugin {
    public static RPBookGUI getPlugin;

    @Override
    public void onEnable() {
        getPlugin = this;

        if (!Bukkit.getServer().getPluginManager().getPlugin("RandomPackage").isEnabled()) {
            Bukkit.getConsoleSender()
                    .sendMessage("RandomPackage plugin not enabled or not installed! This plugin will be disabled!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
                .chatColor("&7[&dRPBookGUI&7] &b============================================================="));
        InitRarities();
        InitCommands();
        InitConfig();
        InitEvents();
        InitMetrics();
        Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.chatColor("&7[&dRPBookGUI&7] &d========================"));
        Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.chatColor("&7[&dRPBookGUI&7] &bAuthor: &ePuyodead1"));
        Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.chatColor("&7[&dRPBookGUI&7] &bRandomPackage Version: &e"
                + getServer().getPluginManager().getPlugin("RandomPackage").getDescription().getVersion()));
        Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.chatColor("&7[&dRPBookGUI&7] &bRPBookGUI Version: &e"
                + getServer().getPluginManager().getPlugin("RPBookGUI").getDescription().getVersion()));
        Bukkit.getConsoleSender().sendMessage(
                RPBookGUIUtils.chatColor("&7[&dRPBookGUI&7] &bMinecraft Version: &e" + getServer().getVersion()));
        Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
                .chatColor("&7[&dRPBookGUI&7] &b============================================================="));
    }

    @Override
    public void onDisable() {

    }

    /**
     * Register commands
     */
    public void InitCommands() {
        getCommand("bookgui").setExecutor(new BookGUICommand());
        getCommand("rarityinfo").setExecutor(new RarityInfo());
    }

    /**
     * Copy and Initialize config
     */
    public void InitConfig() {
        long started = System.currentTimeMillis();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.chatColor(
                "&7[&dRPBookGUI&7] &bLoaded Configuration file &e(" + (System.currentTimeMillis() - started) + "ms)"));
    }

    /**
     * Register Events
     */
    public void InitEvents() {
        long started = System.currentTimeMillis();

        getServer().getPluginManager().registerEvents(new MainInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new RarityInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new EnchantInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new SuccessDestroyInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new SettingsInventoryClick(), this);

        Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
                .chatColor("&7[&dRPBookGUI&7] &bLoaded Events &e(" + (System.currentTimeMillis() - started) + "ms)"));
    }

    /**
     * Enable Metrics
     */
    public void InitMetrics() {
        long started = System.currentTimeMillis();
        new Metrics(this,4890);

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&dRPBookGUI&7] &bInitialized Metrics &e("
                + (System.currentTimeMillis() - started) + "ms)"));
    }

    /**
     * Initialize Rarities and Custom Enchants
     */
    private void InitRarities() {
        long started = System.currentTimeMillis();
        for (EnchantRarity enchantRarity : RandomPackageAPI.INSTANCE.getAllCustomEnchantRarities().values()) {
        	if(enchantRarity.getIdentifier().equals("RANDOM")) continue;
            RPBookGUIUtils.addEnchantRarity(enchantRarity);
        }

        for (CustomEnchant customEnchant : RandomPackageAPI.INSTANCE.getAllCustomEnchants(true).values()) {
            RPBookGUIUtils.addCustomEnchant(customEnchant);
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&dRPBookGUI&7] &bLoaded &e" + RPBookGUIUtils.rarities.size() + " &bEnchant Rarities and &e" + RPBookGUIUtils.enchants.size() + " &bCustom Enchants &e("
                + (System.currentTimeMillis() - started) + "ms)"));
    }
}
