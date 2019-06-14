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

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.randomhashtags.randompackage.utils.classes.customenchants.CustomEnchant;
import me.randomhashtags.randompackage.utils.classes.customenchants.EnchantRarity;

public class Events implements Listener {

	@EventHandler
	public void mainInvClickEvent(InventoryClickEvent e) {
		if (e.getInventory().getTitle().equals(Inventories.MainGUI().getTitle())) {
			e.setCancelled(true);
			ItemStack item = e.getCurrentItem();
			Player player = (Player) e.getWhoClicked();

			if (item.getItemMeta().getDisplayName()
					.equals(ItemStacks.SimpleCategoryItem().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.SimpleEnchants());
			} else if (item.getItemMeta().getDisplayName()
					.equals(ItemStacks.UniqueCategoryItem().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.UniqueEnchants());
			} else if (item.getItemMeta().getDisplayName()
					.equals(ItemStacks.EliteCategoryItem().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.EliteEnchants());
			} else if (item.getItemMeta().getDisplayName()
					.equals(ItemStacks.UltimateCategoryItem().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.UltimateEnchants());
			} else if (item.getItemMeta().getDisplayName()
					.equals(ItemStacks.LegendaryCategoryItem().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.LegendaryEnchants());
			} else if (item.getItemMeta().getDisplayName()
					.equals(ItemStacks.SoulCategoryItem().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.SoulEnchants());
			} else if (item.getItemMeta().getDisplayName()
					.equals(ItemStacks.HeroicCategoryItem().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.HeroicEnchants());
			}
		}
	}

	@EventHandler
	public void SimpleInvClickEvent(InventoryClickEvent e) {
		if (e.getClickedInventory().getTitle().equals(Inventories.SimpleEnchants().getTitle())) {
			Player player = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			e.setCancelled(true);
			if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.MainGUI());
			}
			if (e.getCurrentItem().getType().equals(Material.BOOK)) {
				CustomEnchant ce = CustomEnchant
						.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
				player.closeInventory();
				player.openInventory(Inventories.EnchantInv(ce));
			}
		}
	}

	@EventHandler
	public void UniqueInvClickEvent(InventoryClickEvent e) {
		if (e.getClickedInventory().getTitle().equals(Inventories.UniqueEnchants().getTitle())) {
			Player player = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			e.setCancelled(true);
			if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.MainGUI());
			}
			if (e.getCurrentItem().getType().equals(Material.BOOK)) {
				CustomEnchant ce = CustomEnchant
						.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
				player.closeInventory();
				player.openInventory(Inventories.EnchantInv(ce));
			}
		}
	}

	@EventHandler
	public void EliteInvClickEvent(InventoryClickEvent e) {
		if (e.getClickedInventory().getTitle().equals(Inventories.EliteEnchants().getTitle())) {
			Player player = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			e.setCancelled(true);
			if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.MainGUI());
			}
			if (e.getCurrentItem().getType().equals(Material.BOOK)) {
				CustomEnchant ce = CustomEnchant
						.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
				player.closeInventory();
				player.openInventory(Inventories.EnchantInv(ce));
			}
		}
	}

	@EventHandler
	public void UltimateInvClickEvent(InventoryClickEvent e) {
		if (e.getClickedInventory().getTitle().equals(Inventories.UltimateEnchants().getTitle())) {
			Player player = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			e.setCancelled(true);
			if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.MainGUI());
			}
			if (e.getCurrentItem().getType().equals(Material.BOOK)) {
				CustomEnchant ce = CustomEnchant
						.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
				player.closeInventory();
				player.openInventory(Inventories.EnchantInv(ce));
			}
		}
	}

	@EventHandler
	public void LegendaryInvClickEvent(InventoryClickEvent e) {
		if (e.getClickedInventory().getTitle().equals(Inventories.LegendaryEnchants().getTitle())) {
			Player player = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			e.setCancelled(true);
			if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.MainGUI());
			}
			if (e.getCurrentItem().getType().equals(Material.BOOK)) {
				CustomEnchant ce = CustomEnchant
						.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
				player.closeInventory();
				player.openInventory(Inventories.EnchantInv(ce));
			}
		}
	}

	@EventHandler
	public void SoulInvClickEvent(InventoryClickEvent e) {
		if (e.getClickedInventory().getTitle().equals(Inventories.SoulEnchants().getTitle())) {
			Player player = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			e.setCancelled(true);
			if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.MainGUI());
			}
			if (e.getCurrentItem().getType().equals(Material.BOOK)) {
				CustomEnchant ce = CustomEnchant
						.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
				player.closeInventory();
				player.openInventory(Inventories.EnchantInv(ce));
			}
		}
	}

	@EventHandler
	public void HeroicInvClickEvent(InventoryClickEvent e) {
		if (e.getClickedInventory().getTitle().equals(Inventories.HeroicEnchants().getTitle())) {
			Player player = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			e.setCancelled(true);
			if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
				player.openInventory(Inventories.MainGUI());
			}
			if (e.getCurrentItem().getType().equals(Material.BOOK)) {
				CustomEnchant ce = CustomEnchant
						.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
				player.closeInventory();
				player.openInventory(Inventories.EnchantInv(ce));
			}
		}
	}

	@EventHandler
	public void EnchantInvClickEvent(InventoryClickEvent e) {
		CustomEnchant ce = CustomEnchant.valueOf(e.getClickedInventory().getTitle());
		if (ce != null) {
			Player player = (Player) e.getWhoClicked();
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
				switch (EnchantRarity.valueOf(ce).getName()) {
				case "SIMPLE":
					player.openInventory(Inventories.SimpleEnchants());
					break;
				case "UNIQUE":
					player.openInventory(Inventories.UniqueEnchants());
					break;
				case "ELITE":
					player.openInventory(Inventories.EliteEnchants());
					break;
				case "ULTIMATE":
					player.openInventory(Inventories.UltimateEnchants());
					break;
				case "LEGENDARY":
					player.openInventory(Inventories.LegendaryEnchants());
					break;
				case "SOUL":
					player.openInventory(Inventories.SoulEnchants());
					break;
				case "HEROIC":
					player.openInventory(Inventories.HeroicEnchants());
					break;
				}
			}
			if (e.getCurrentItem().getType().equals(Material.BOOK)) {
				ItemStack is = e.getCurrentItem().clone();
				player.getInventory().addItem(is);
				if (!RPBookGUI.getPlugin.getConfig().getBoolean("settings.keepinvopen")) {
					player.closeInventory();
				}
				player.sendMessage(Utils.ChatColor(RPBookGUI.getPlugin.getConfig().getString("messages.added-book")
						.replace("{NAME}", is.getItemMeta().getDisplayName())));
			}
		}
	}

	@EventHandler
	public void SettingsInvClickEvent(InventoryClickEvent e) {
		if (e.getClickedInventory().getTitle().equals(Inventories.SettingsInv().getTitle())) {
			e.setCancelled(true);
			Player player = (Player) e.getWhoClicked();
			ItemStack is = e.getCurrentItem();

			if (is.getItemMeta().getDisplayName().equals(ItemStacks.Back().getItemMeta().getDisplayName())) {
				player.closeInventory();
			}
			if (is.getItemMeta().getDisplayName()
					.equals(ItemStacks.KeepMenuOpenSetting().getItemMeta().getDisplayName())) {
				RPBookGUI.getPlugin.getConfig().set("settings.keepinvopen",
						!RPBookGUI.getPlugin.getConfig().getBoolean("settings.keepinvopen"));

				player.closeInventory();
				player.openInventory(Inventories.SettingsInv());
			}
			if (is.getItemMeta().getDisplayName()
					.equals(ItemStacks.UsePermissionsSetting().getItemMeta().getDisplayName())) {
				RPBookGUI.getPlugin.getConfig().set("settings.usepermissions",
						!RPBookGUI.getPlugin.getConfig().getBoolean("settings.usepermissions"));

				player.closeInventory();
				player.openInventory(Inventories.SettingsInv());
			}
		}
	}
}
