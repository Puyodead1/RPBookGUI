package io.github.puyodead1.rpbookgui.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;

public class BookGUICommand implements CommandExecutor {

	private FileConfiguration rpbgConfig = RPBookGUI.getPlugin.getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			switch (args.length) {
				case 0 :
					if (player.hasPermission(
							rpbgConfig.getString("permissions.bookgui"))
							|| player.isOp() || !rpbgConfig
									.getBoolean("settings.use permissions")) {
						player.openInventory(Inventories.mainInventory());
						return true;
					} else {
						player.sendMessage(RPBookGUIUtils.ChatColor(rpbgConfig
								.getString("messages.no permission")));
						return false;
					}
				case 1 :
					if (args[0].equalsIgnoreCase("help")) {
						if (player
								.hasPermission(rpbgConfig
										.getString("permissions.bookgui help"))
								|| player.isOp() || !rpbgConfig.getBoolean(
										"settings.use permissions")) {
							player.sendMessage(RPBookGUIUtils.ChatColor(
									"&6==============&d&lRPBook GUI&6============================"));
							player.sendMessage(RPBookGUIUtils
									.ChatColor("&7/bookgui - Open main menu."));
							player.sendMessage(RPBookGUIUtils.ChatColor(
									"&7/bookgui help - This help message."));
//							player.sendMessage(RPBookGUIUtils.ChatColor(
//									"&7/bookgui settings - Open settings menu."));
							player.sendMessage(RPBookGUIUtils.ChatColor(
									"&7/bookgui info - show plugin info."));
							player.sendMessage(RPBookGUIUtils.ChatColor(
									"&6====================================================="));
							return true;
						} else {
							player.sendMessage(RPBookGUIUtils
									.ChatColor(rpbgConfig.getString(
											"messages.no permission")));
							return false;
						}
//					} else if (args[0].equalsIgnoreCase("settings")) {
//						if (player
//								.hasPermission(rpbgConfig.getString(
//										"permissions.bookgui settings"))
//								|| player.isOp()) {
//							player.openInventory(Inventories.settingsInventory());
//							return true;
//						} else {
//							player.sendMessage(RPBookGUIUtils
//									.ChatColor(rpbgConfig.getString(
//											"messages.no permission")));
//							return false;
//						}
					} else if (args[0].equalsIgnoreCase("info")) {
						if (player
								.hasPermission(rpbgConfig
										.getString("permissions.bookgui info"))
								|| player.isOp()) {
							player.sendMessage(RPBookGUIUtils.ChatColor(
									"&6==============&d&lRPBook GUI&6============================"));
							player.sendMessage(RPBookGUIUtils
									.ChatColor("&7+ Author: &b&lPuyodead1"));
							player.sendMessage(RPBookGUIUtils
									.ChatColor("&7+ RPBook GUI Version: &e"
											+ RPBookGUI.getPlugin
													.getDescription()
													.getVersion()));
							player.sendMessage(RPBookGUIUtils.ChatColor(
									"&7+ RandomPackage Version: &e" + Bukkit
											.getPluginManager()
											.getPlugin("RandomPackage")
											.getDescription().getVersion()));
							player.sendMessage(RPBookGUIUtils.ChatColor(
									"&6====================================================="));
							return true;
						} else {
							player.sendMessage(RPBookGUIUtils
									.ChatColor(rpbgConfig.getString(
											"messages.no permission")));
							return false;
						}
					} else if (args[0].equalsIgnoreCase("reload"))
						if (player
								.hasPermission(rpbgConfig.getString(
										"permissions.bookgui reload"))
								|| player.isOp())
							try {
								RPBookGUI.getPlugin.reloadConfig();
								player.sendMessage(RPBookGUIUtils
										.ChatColor(rpbgConfig.getString(
												"messages.config reloaded")));
								return true;
							} catch (Exception e) {
								e.printStackTrace();
								player.sendMessage(RPBookGUIUtils
										.ChatColor(rpbgConfig.getString(
												"messages.no permission")));
								return false;
							}
						else {
							player.sendMessage(RPBookGUIUtils
									.ChatColor(rpbgConfig.getString(
											"messages.no permission")));
							return false;
						}
			}
			return true;
		} else {
			sender.sendMessage(RPBookGUIUtils
					.ChatColor(rpbgConfig.getString("messages.only players")));
			return false;
		}
	}

}
