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

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RPBookGUI extends JavaPlugin {
	public static RPBookGUI getPlugin;

	public void onEnable() {
		getPlugin = this;
		
		Bukkit.getConsoleSender().sendMessage(
				Utils.ChatColor("&7[&dRPBookGUI&7] &b============================================================="));
		InitConfig();
		InitEvents();
		InitMetrics();
		Bukkit.getConsoleSender().sendMessage(Utils.ChatColor("&7[&dRPBookGUI&7] &d========================"));
		Bukkit.getConsoleSender().sendMessage(Utils.ChatColor("&7[&dRPBookGUI&7] &bAuthor: &ePuyodead1"));
		Bukkit.getConsoleSender().sendMessage(Utils.ChatColor("&7[&dRPBookGUI&7] &bRandomPackage Version: &e"
				+ getServer().getPluginManager().getPlugin("RandomPackage").getDescription().getVersion()));
		Bukkit.getConsoleSender().sendMessage(Utils.ChatColor("&7[&dRPBookGUI&7] &bRPBookGUI Version: &e"
				+ getServer().getPluginManager().getPlugin("RPBookGUI").getDescription().getVersion()));
		Bukkit.getConsoleSender()
				.sendMessage(Utils.ChatColor("&7[&dRPBookGUI&7] &bMinecraft Version: &e" + getServer().getVersion()));
		Bukkit.getConsoleSender().sendMessage(
				Utils.ChatColor("&7[&dRPBookGUI&7] &b============================================================="));
	}

	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().toLowerCase().equals("bookgui")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Utils.ChatColor(getConfig().getString("messages.only-players")));
				return false;
			}
			Player player = (Player) sender;
			if (args.length == 0) {
				if (sender.hasPermission("bookgui.use") || sender.isOp()
						|| getConfig().getBoolean("settings.usepermissions")) {
					player.openInventory(Inventories.MainGUI());
					return true;
				} else {
					player.sendMessage(Utils.ChatColor(getConfig().getString("messages.no-permission")));
					return false;
				}
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("help")) {
					if (sender.hasPermission("bookgui.help") || sender.isOp()
							|| getConfig().getBoolean("settings.usepermissions")) {
						player.sendMessage(
								Utils.ChatColor("&6==============&d&lRPBook GUI&6============================"));
						player.sendMessage(Utils.ChatColor("&7/bookgui - Open main menu."));
						player.sendMessage(Utils.ChatColor("&7/bookgui help - This help message."));
						player.sendMessage(Utils.ChatColor("&7/bookgui settings - Open settings menu."));
						player.sendMessage(Utils.ChatColor("&7/bookgui info - show plugin info."));
						player.sendMessage(Utils.ChatColor("&6====================================================="));
						return true;
					} else {
						player.sendMessage(Utils.ChatColor(getConfig().getString("messages.no-permission")));
						return false;
					}
				} else if (args[0].equalsIgnoreCase("settings")) {
					if (sender.hasPermission("bookgui.settings") || sender.isOp()) {
						player.openInventory(Inventories.SettingsInv());
						return true;
					} else {
						player.sendMessage(Utils.ChatColor(getConfig().getString("messages.no-permission")));
						return false;
					}
				} else if (args[0].equalsIgnoreCase("info")) {
					if (sender.hasPermission("bookgui.info") || sender.isOp()
							|| getConfig().getBoolean("settings.usepermissions")) {
						player.sendMessage(
								Utils.ChatColor("&6==============&d&lRPBook GUI&6============================"));
						player.sendMessage(Utils.ChatColor("&7+ Author: &b&lPuyodead1"));
						player.sendMessage(
								Utils.ChatColor("&7+ RPBook GUI Version: &e" + this.getDescription().getVersion()));
						player.sendMessage(Utils.ChatColor("&7+ RandomPackage Version: &e"
								+ Bukkit.getPluginManager().getPlugin("RandomPackage").getDescription().getVersion()));
						player.sendMessage(Utils.ChatColor("&6====================================================="));
						return true;
					} else {
						player.sendMessage(Utils.ChatColor(getConfig().getString("messages.no-permission")));
						return false;
					}
				} else if (args[0].equalsIgnoreCase("reload")) {
					if (sender.hasPermission("bookgui.reload") || sender.isOp()) {
						try {
							reloadConfig();
							player.sendMessage(Utils.ChatColor(getConfig().getString("messages.config-reloaded")));
						} catch (Exception e) {
							e.printStackTrace();
							player.sendMessage(Utils.ChatColor(getConfig().getString("messages.no-permission")));
						}
						return true;
					} else {
						player.sendMessage(Utils.ChatColor(getConfig().getString("messages.no-permission")));
						return false;
					}
				}
			}
		} else {
			sender.sendMessage(Utils.ChatColor(getConfig().getString("messages.no-permission")));
			return false;
		}
		return false;
	}

	public void InitConfig() {
		long started = System.currentTimeMillis();

		getConfig().options().copyDefaults(true);
		saveDefaultConfig();

		Bukkit.getConsoleSender().sendMessage(Utils.ChatColor("&7[&dRPBookGUI&7] &bLoaded Configuration file &e("
				+ (System.currentTimeMillis() - started) + "ms)"));
	}

	public void InitEvents() {
		long started = System.currentTimeMillis();

		getServer().getPluginManager().registerEvents(new Events(), this);

		Bukkit.getConsoleSender().sendMessage(Utils
				.ChatColor("&7[&dRPBookGUI&7] &bLoaded Events &e(" + (System.currentTimeMillis() - started) + "ms)"));
	}

	public void InitMetrics() {
		long started = System.currentTimeMillis();
		MetricsLite metrics = new MetricsLite(this);

		Bukkit.getConsoleSender().sendMessage(Utils.ChatColor(
				"&7[&dRPBookGUI&7] &bInitalized Metrics &e(" + (System.currentTimeMillis() - started) + "ms)"));
		Bukkit.getConsoleSender()
				.sendMessage(Utils.ChatColor("&7[&dRPBookGUI&7] &bUsing Metrics: &e" + metrics.isEnabled()));
	}
}
