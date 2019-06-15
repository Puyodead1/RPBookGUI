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

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.puyodead1.rpbookgui.Commands.BookGUICommand;
import io.github.puyodead1.rpbookgui.Commands.KitCreatorCommand;
import io.github.puyodead1.rpbookgui.Events.InventoryClick;
import io.github.puyodead1.rpbookgui.Events.PlayerJoin;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;

public class RPBookGUI extends JavaPlugin {
	public static RPBookGUI getPlugin;

	public void onEnable() {
		getPlugin = this;
		
		Bukkit.getConsoleSender().sendMessage(
				RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &b============================================================="));
		InitCommands();
		InitConfig();
		InitEvents();
		InitMetrics();
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &d========================"));
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bAuthor: &ePuyodead1"));
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bRandomPackage Version: &e"
				+ getServer().getPluginManager().getPlugin("RandomPackage").getDescription().getVersion()));
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bRPBookGUI Version: &e"
				+ getServer().getPluginManager().getPlugin("RPBookGUI").getDescription().getVersion()));
		Bukkit.getConsoleSender()
				.sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bMinecraft Version: &e" + getServer().getVersion()));
		Bukkit.getConsoleSender().sendMessage(
				RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &b============================================================="));
	}

	public void onDisable() {

	}

	public void InitCommands() {
		getCommand("bookgui").setExecutor(new BookGUICommand());
		getCommand("kitcreator").setExecutor(new KitCreatorCommand());
	}

	public void InitConfig() {
		long started = System.currentTimeMillis();

		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		File playerDataDir = new File(this.getDataFolder(), "_playerData");
		if(!playerDataDir.exists()) {
			Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bPlayer Data Directory doesn't exist, creating..."));
			if(playerDataDir.mkdir()) {
				Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bCreated Player Data Directory."));
			} else {
				Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bFailed to create Player Data Directory."));
			}
		} else {
			Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bPlayer Data Directory exists."));
		}

		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bLoaded Configuration file &e("
				+ (System.currentTimeMillis() - started) + "ms)"));
	}

	public void InitEvents() {
		long started = System.currentTimeMillis();

		getServer().getPluginManager().registerEvents(new InventoryClick(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
				.ChatColor("&7[&dRPBookGUI&7] &bLoaded Events &e(" + (System.currentTimeMillis() - started) + "ms)"));
	}

	public void InitMetrics() {
		long started = System.currentTimeMillis();
		MetricsLite metrics = new MetricsLite(this);

		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor(
				"&7[&dRPBookGUI&7] &bInitalized Metrics &e(" + (System.currentTimeMillis() - started) + "ms)"));
		Bukkit.getConsoleSender()
				.sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bUsing Metrics: &e" + metrics.isEnabled()));
	}
}
