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
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.puyodead1.rpbookgui.Commands.BookGUICommand;
import io.github.puyodead1.rpbookgui.Commands.RarityInfo;
import io.github.puyodead1.rpbookgui.Events.RarityInventoryClick;
import io.github.puyodead1.rpbookgui.Events.SuccessDestroyInventoryClick;
import io.github.puyodead1.rpbookgui.Events.EnchantInventoryClick;
import io.github.puyodead1.rpbookgui.Events.MainInventoryClick;
import io.github.puyodead1.rpbookgui.Utils.FileCustomEnchant;
import io.github.puyodead1.rpbookgui.Utils.FileEnchantRarity;
import io.github.puyodead1.rpbookgui.Utils.MetricsLite;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.util.addon.RPAddon;

public class RPBookGUI extends JavaPlugin {
	public static RPBookGUI getPlugin;

	@Override
	public void onEnable() {
		getPlugin = this;

		if (!Bukkit.getServer().getPluginManager().getPlugin("RandomPackage")
				.isEnabled()) {
			Bukkit.getConsoleSender().sendMessage(
					"RandomPackage plugin not enabled or not installed! This plugin will be disabled!");
			Bukkit.getPluginManager().disablePlugin(this);
		}

		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor(
				"&7[&dRPBookGUI&7] &b============================================================="));
		InitRarities();
		InitCommands();
		InitConfig();
		InitEvents();
		InitMetrics();
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
				.ChatColor("&7[&dRPBookGUI&7] &d========================"));
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
				.ChatColor("&7[&dRPBookGUI&7] &bAuthor: &ePuyodead1"));
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor(
				"&7[&dRPBookGUI&7] &bRandomPackage Version: &e" + getServer()
						.getPluginManager().getPlugin("RandomPackage")
						.getDescription().getVersion()));
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
				.ChatColor("&7[&dRPBookGUI&7] &bRPBookGUI Version: &e"
						+ getServer().getPluginManager().getPlugin("RPBookGUI")
								.getDescription().getVersion()));
		Bukkit.getConsoleSender()
				.sendMessage(RPBookGUIUtils
						.ChatColor("&7[&dRPBookGUI&7] &bMinecraft Version: &e"
								+ getServer().getVersion()));
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor(
				"&7[&dRPBookGUI&7] &b============================================================="));
	}

	@Override
	public void onDisable() {

	}

	public void InitCommands() {
		getCommand("bookgui").setExecutor(new BookGUICommand());
		getCommand("rarityinfo").setExecutor(new RarityInfo());
	}

	public void InitConfig() {
		long started = System.currentTimeMillis();

		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		// File playerDataDir = new File(getDataFolder(), "_playerData");
		// if (!playerDataDir.exists()) {
		// Bukkit.getConsoleSender().sendMessage(
		// RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bPlayer Data Directory
		// doesn't exist, creating..."));
		// if (playerDataDir.mkdir())
		// Bukkit.getConsoleSender()
		// .sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bCreated
		// Player Data Directory."));
		// else
		// Bukkit.getConsoleSender().sendMessage(
		// RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bFailed to create Player
		// Data Directory."));
		// } else
		// Bukkit.getConsoleSender()
		// .sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bPlayer
		// Data Directory exists."));

		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
				.ChatColor("&7[&dRPBookGUI&7] &bLoaded Configuration file &e("
						+ (System.currentTimeMillis() - started) + "ms)"));
	}

	public void InitEvents() {
		long started = System.currentTimeMillis();

		getServer().getPluginManager()
				.registerEvents(new MainInventoryClick(), this);
		getServer().getPluginManager()
		.registerEvents(new RarityInventoryClick(), this);
		getServer().getPluginManager()
		.registerEvents(new EnchantInventoryClick(), this);
		getServer().getPluginManager()
		.registerEvents(new SuccessDestroyInventoryClick(), this);
		// getServer().getPluginManager().registerEvents(new PlayerJoin(),
		// this);

		Bukkit.getConsoleSender().sendMessage(
				RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bLoaded Events &e("
						+ (System.currentTimeMillis() - started) + "ms)"));
	}

	public void InitMetrics() {
		long started = System.currentTimeMillis();
		MetricsLite metrics = new MetricsLite(this);

		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils
				.ChatColor("&7[&dRPBookGUI&7] &bInitalized Metrics &e("
						+ (System.currentTimeMillis() - started) + "ms)"));
		Bukkit.getConsoleSender().sendMessage(RPBookGUIUtils.ChatColor(
				"&7[&dRPBookGUI&7] &bUsing Metrics: &e" + metrics.isEnabled()));
	}

	private void InitRarities() {
		final String separator = RPAddon.separator;
		final String p = RPAddon.rpd + separator + "custom enchants";
		final File folder = new File(p);

		if (folder.exists()) {
			for (File f : folder.listFiles()) {
				if (f.isDirectory()) {
					final File[] files = new File(p + separator + f.getName())
							.listFiles();
					if (files != null) {
						FileEnchantRarity rarity = null;
						final List<File> F = Arrays.asList(files);
						for (File k : F) {
							if (k.getName().contains("_settings")) {
								rarity = new FileEnchantRarity(f, k);
							}
						}
						if (rarity != null) {
							for (File ff : files) {
								if (!ff.getName().startsWith("_settings")) {
									final FileCustomEnchant e = new FileCustomEnchant(
											ff);
									if(e.isEnabled()) {
										rarity.getEnchants().add(e);
										RPBookGUIUtils.enchants.put(e.getIdentifier(), e);
									}
								}
							}
						}
					}
				}
			}
		}

	}
}
