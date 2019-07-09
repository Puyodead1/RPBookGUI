package io.github.puyodead1.rpbookgui.Events;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.ItemStacks;
import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.utils.classes.customenchants.CustomEnchant;
import me.randomhashtags.randompackage.utils.classes.customenchants.EnchantRarity;
import me.randomhashtags.randompackage.utils.universal.UMaterial;

public class InventoryClick implements Listener {

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e) {
		if (!e.isCancelled() && e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)
				&& e.getClickedInventory() != null && e.getCursor() != null
				&& !e.getClick().equals(ClickType.DOUBLE_CLICK)) {
			ItemStack ci = e.getCurrentItem();
			Player player = (Player) e.getWhoClicked();

			/*
			 * Main inv click
			 */
			if (e.getInventory().getTitle().equals(Inventories.MainGUI().getTitle())) {
				e.setCancelled(true);

				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.SimpleCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.SimpleEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.UniqueCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.UniqueEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.EliteCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.EliteEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.UltimateCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.UltimateEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.LegendaryCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.LegendaryEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.SoulCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.SoulEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.HeroicCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.HeroicEnchants());
				}
			}
			/*
			 * Settings inv click
			 */
			if (e.getClickedInventory().getTitle().equals(Inventories.SettingsInv().getTitle())) {
				e.setCancelled(true);

				if (ci.getItemMeta().getDisplayName().equals(ItemStacks.Back().clone().getItemMeta().getDisplayName()))
					player.closeInventory();
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.KeepMenuOpenSetting().clone().getItemMeta().getDisplayName())) {
					RPBookGUI.getPlugin.getConfig().set("settings.keepinvopen",
							!RPBookGUI.getPlugin.getConfig().getBoolean("settings.keepinvopen"));

					player.closeInventory();
					player.openInventory(Inventories.SettingsInv());
				}
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.UsePermissionsSetting().clone().getItemMeta().getDisplayName())) {
					RPBookGUI.getPlugin.getConfig().set("settings.usepermissions",
							!RPBookGUI.getPlugin.getConfig().getBoolean("settings.usepermissions"));

					player.closeInventory();
					player.openInventory(Inventories.SettingsInv());
				}
			}

			/*
			 * Heroic inv click
			 */
			if (e.getClickedInventory().getTitle().equals(Inventories.HeroicEnchants().getTitle())) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = CustomEnchant
							.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.closeInventory();
					player.openInventory(Inventories.EnchantInv(ce));
				}
			}

			/*
			 * soul inv click
			 */
			if (e.getClickedInventory().getTitle().equals(Inventories.SoulEnchants().getTitle())) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = CustomEnchant
							.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.closeInventory();
					player.openInventory(Inventories.EnchantInv(ce));
				}
			}
			/*
			 * Legendary inv click
			 */
			if (e.getClickedInventory().getTitle().equals(Inventories.LegendaryEnchants().getTitle())) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = CustomEnchant
							.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.closeInventory();
					player.openInventory(Inventories.EnchantInv(ce));
				}
			}

			/*
			 * Ultimate inv click
			 */
			if (e.getClickedInventory().getTitle().equals(Inventories.UltimateEnchants().getTitle())) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = CustomEnchant
							.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.closeInventory();
					player.openInventory(Inventories.EnchantInv(ce));
				}
			}
			/*
			 * Elite inv click
			 */
			if (e.getClickedInventory().getTitle().equals(Inventories.EliteEnchants().getTitle())) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = CustomEnchant
							.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.closeInventory();
					player.openInventory(Inventories.EnchantInv(ce));
				}
			}

			/*
			 * Unique inv click
			 */
			if (e.getClickedInventory().getTitle().equals(Inventories.UniqueEnchants().getTitle())) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = CustomEnchant
							.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.closeInventory();
					player.openInventory(Inventories.EnchantInv(ce));
				}
			}
			/*
			 * Simple inv click
			 */
			if (e.getClickedInventory().getTitle().equals(Inventories.SimpleEnchants().getTitle())) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.closeInventory();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = CustomEnchant
							.valueOf(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.closeInventory();
					player.openInventory(Inventories.EnchantInv(ce));
				}
			}

			/*
			 * Enchant inv click
			 */
			CustomEnchant enchant = CustomEnchant.valueOf(e.getClickedInventory().getTitle());
			if (enchant != null) {
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().getItemMeta().getDisplayName())
						&& e.getCurrentItem().getType().equals(ItemStacks.Back().clone().clone().getType())) {
					player.closeInventory();
					switch (EnchantRarity.valueOf(enchant).getName()) {
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
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					e.setCancelled(true);
					if (RPBookGUI.getPlugin.getConfig().getBoolean("settings.try to apply to item in hand")
							&& RPBookGUIUtils.isOnCorrectItem(enchant, player.getItemInHand())) {

						CustomEnchant ce = CustomEnchant.valueOf(ci);
						EnchantRarity rarity = EnchantRarity.valueOf(ce);

						ItemStack o = player.getInventory().getItemInMainHand();
						ItemMeta m = o.getItemMeta();

						if (m.getLore() == null) {
							ArrayList<String> lores = new ArrayList<String>();
							lores.add(
									rarity.getApplyColors() + ChatColor.stripColor(ci.getItemMeta().getDisplayName()));
							m.setLore(lores);
						} else {
							ArrayList<String> lores = new ArrayList<String>();
							lores.addAll(m.getLore());
							lores.add(
									rarity.getApplyColors() + ChatColor.stripColor(ci.getItemMeta().getDisplayName()));
							m.setLore(lores);
						}

						o.setItemMeta(m);
						player.updateInventory();

						player.sendMessage(RPBookGUIUtils
								.ChatColor(RPBookGUI.getPlugin.getConfig().getString("messages.added enchant")
										.replace("{NAME}", ci.getItemMeta().getDisplayName())
										.replace("{ITEM}", player.getItemInHand().getType().name())));
					} else {
						player.getInventory().addItem(ci);
						if (!RPBookGUI.getPlugin.getConfig().getBoolean("settings.keep inventory open"))
							player.closeInventory();
						player.sendMessage(RPBookGUIUtils
								.ChatColor(RPBookGUI.getPlugin.getConfig().getString("messages.added book")
										.replace("{NAME}", ci.getItemMeta().getDisplayName())));
					}
				}
			}
		}
	}
}
