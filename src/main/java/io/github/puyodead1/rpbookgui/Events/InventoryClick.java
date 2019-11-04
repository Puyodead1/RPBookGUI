package io.github.puyodead1.rpbookgui.Events;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.puyodead1.rpbookgui.EnchantConstructor;
import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.ItemStacks;
import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import io.github.puyodead1.rpbookgui.Utils.UMaterial;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.addon.EnchantRarity;
import me.randomhashtags.randompackage.api.CustomEnchants;
import me.randomhashtags.randompackage.util.RPStorage;

public class InventoryClick implements Listener {

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e) {
		if (!e.isCancelled() && e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)
				&& e.getClickedInventory() != null && e.getCursor() != null
				&& !e.getClick().equals(ClickType.DOUBLE_CLICK)) {
			ItemStack ci = e.getCurrentItem();
			Player player = (Player) e.getWhoClicked();
			String invTitle = e.getView().getTitle();

			/*
			 * Main inv click
			 */
			if (invTitle.equals("Enchantment Categories")) {
				e.setCancelled(true);

				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.SimpleCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.SimpleEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.UniqueCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.UniqueEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.EliteCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.EliteEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.UltimateCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.UltimateEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.LegendaryCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.LegendaryEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.SoulCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.SoulEnchants());
				} else if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.HeroicCategoryItem().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.HeroicEnchants());
				}
			}
			/*
			 * Settings inv click
			 */
			if (invTitle.equals("RPBookGUI Settings")) {
				e.setCancelled(true);

				if (ci.getItemMeta().getDisplayName().equals(ItemStacks.Back().clone().getItemMeta().getDisplayName()))
					player.getOpenInventory().close();
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.KeepMenuOpenSetting().clone().getItemMeta().getDisplayName())) {
					RPBookGUI.getPlugin.getConfig().set("settings.keepinvopen",
							!RPBookGUI.getPlugin.getConfig().getBoolean("settings.keepinvopen"));

					player.getOpenInventory().close();
					player.openInventory(Inventories.Settings());
				}
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.UsePermissionsSetting().clone().getItemMeta().getDisplayName())) {
					RPBookGUI.getPlugin.getConfig().set("settings.usepermissions",
							!RPBookGUI.getPlugin.getConfig().getBoolean("settings.usepermissions"));

					player.getOpenInventory().close();
					player.openInventory(Inventories.Settings());
				}
			}

			/*
			 * Heroic inv click
			 */
			if (invTitle.equals(RPBookGUIUtils.ChatColor("&d&lHeroic Enchantments"))) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = RPStorage.valueOfCustomEnchant(
							ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.getOpenInventory().close();
					player.openInventory(Inventories.Enchant(ce));
				}
			}

			/*
			 * soul inv click
			 */
			if (invTitle.equals(RPBookGUIUtils.ChatColor("&c&lSoul Enchantments"))) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = RPStorage.valueOfCustomEnchant(
							ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.getOpenInventory().close();
					player.openInventory(Inventories.Enchant(ce));
				}
			}
			/*
			 * Legendary inv click
			 */
			if (invTitle.equals(RPBookGUIUtils.ChatColor("&6&lLegendary Enchantments"))) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = RPStorage.valueOfCustomEnchant(
							ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.getOpenInventory().close();
					player.openInventory(Inventories.Enchant(ce));
				}
			}

			/*
			 * Ultimate inv click
			 */
			if (invTitle.equals(RPBookGUIUtils.ChatColor("&e&lUltimate Enchantments"))) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = RPStorage.valueOfCustomEnchant(
							ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.getOpenInventory().close();
					player.openInventory(Inventories.Enchant(ce));
				}
			}
			/*
			 * Elite inv click
			 */
			if (invTitle.equals(RPBookGUIUtils.ChatColor("&b&lElite Enchantments"))) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = RPStorage.valueOfCustomEnchant(
							ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.getOpenInventory().close();
					player.openInventory(Inventories.Enchant(ce));
				}
			}

			/*
			 * Unique inv click
			 */
			if (invTitle.equals(RPBookGUIUtils.ChatColor("&a&lUnique Enchantments"))) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = RPStorage.valueOfCustomEnchant(
							ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
					player.getOpenInventory().close();
					player.openInventory(Inventories.Enchant(ce));
				}
			}
			/*
			 * Simple inv click
			 */
			if (invTitle.equals(RPBookGUIUtils.ChatColor("&7&lSimple Enchantments"))) {
				e.setCancelled(true);
				if (ci.getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().clone().getItemMeta().getDisplayName())) {
					player.getOpenInventory().close();
					player.openInventory(Inventories.MainGUI());
				}
				if (e.getCurrentItem().getType().equals(UMaterial.match("BOOK").getMaterial())) {
					CustomEnchant ce = RPStorage
							.valueOfCustomEnchant(RPBookGUIUtils.FormatEnchantName(e.getCurrentItem()));
					player.getOpenInventory().close();
					player.openInventory(Inventories.Enchant(ce));
				}
			}

			/*
			 * Enchant inv click
			 */
			CustomEnchant enchant = RPStorage.valueOfCustomEnchant(invTitle);
			if (enchant != null) {
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName()
						.equals(ItemStacks.Back().getItemMeta().getDisplayName())
						&& e.getCurrentItem().getType().equals(ItemStacks.Back().clone().clone().getType())) {
					player.getOpenInventory().close();
					switch (RPStorage.valueOfEnchantRarity(enchant).getIdentifier()) {
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

						CustomEnchant ce = RPStorage.valueOfCustomEnchant(ci);
						EnchantRarity rarity = RPStorage.valueOfEnchantRarity(ce);

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

						for (EnchantConstructor ec : EnchantConstructor.getEnchants().values()) {
							if (!ChatColor.stripColor(ec.getRevealItem().getItemMeta().getDisplayName())
									.equals(ChatColor.stripColor(ci.getItemMeta().getDisplayName()))) {
								EnchantConstructor.getEnchants().remove(ec.getCustomEnchant().getIdentifier());
							}
						}
						if (RPBookGUI.getPlugin.getConfig().getBoolean("settings.use success destroy configuration")) {
							player.getOpenInventory().close();
							player.openInventory(Inventories.SuccessDestroySelection(ci));
						} else {
							player.getInventory().addItem(ci);
							if (!RPBookGUI.getPlugin.getConfig().getBoolean("settings.keep inventory open"))
								player.getOpenInventory().close();
							player.sendMessage(RPBookGUIUtils
									.ChatColor(RPBookGUI.getPlugin.getConfig().getString("messages.added book")
											.replace("{NAME}", ci.getItemMeta().getDisplayName())));
						}
					}
				}
			}

			if (invTitle.equals("Success & Destry Configuration")) {
				e.setCancelled(true);
				if (e.getCurrentItem().getType().equals(Material.BOOK)) {
					player.getInventory().addItem(e.getCurrentItem().clone());
					player.getOpenInventory().close();
				} else {
					// TODO: prevent negatives
					String incrementType = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())
							.substring(0, 1);
					String[] split = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())
							.substring(1).split(" ");
					int amount = Integer.parseInt(split[0]);
					String type = split[1].toLowerCase();
	
					int currentSuccess = Integer.parseInt(ChatColor
							.stripColor(e.getInventory().getItem(22).getItemMeta().getLore().get(0)).split("%")[0]);
					int currentDestroy = Integer.parseInt(ChatColor
							.stripColor(e.getInventory().getItem(22).getItemMeta().getLore().get(1)).split("%")[0]);

					Entry<String, EnchantConstructor> entry = EnchantConstructor.getEnchants().entrySet().iterator()
							.next();
					CustomEnchant ce = RPStorage.valueOfCustomEnchant(entry.getKey());

					if (type.equals("success")) {
						if (incrementType.equals("+")) {
							final int newAmount = (currentSuccess + amount);
							ItemStack eb = CustomEnchants.getCustomEnchants().getRevealedItem(ce,
									EnchantConstructor.getEnchants().get(ce.getIdentifier()).getEnchantLevel(),
									newAmount > 0 && newAmount <= 100 ? newAmount : currentSuccess, currentDestroy, true, true);
							e.getInventory().setItem(22, eb);
							player.updateInventory();
						} else if (incrementType.equals("-")) {
							final int newAmount = (currentSuccess - amount);
							ItemStack eb = CustomEnchants.getCustomEnchants().getRevealedItem(ce,
									EnchantConstructor.getEnchants().get(ce.getIdentifier()).getEnchantLevel(),
									newAmount > 0 && newAmount <= 100 ? newAmount : currentSuccess, currentDestroy, true, true);
							e.getInventory().setItem(22, eb);
							player.updateInventory();
						}
					} else if (type.equals("destroy")) {
						if (incrementType.equals("+")) {
							final int newAmount = (currentDestroy + amount);
							ItemStack eb = CustomEnchants.getCustomEnchants().getRevealedItem(ce,
									EnchantConstructor.getEnchants().get(ce.getIdentifier()).getEnchantLevel(),
									currentSuccess, newAmount > 0 && newAmount <= 100 ? newAmount : currentDestroy, true, true);
							e.getInventory().setItem(22, eb);
							player.updateInventory();
						} else if (incrementType.equals("-")) {
							final int newAmount = (currentDestroy - amount);
							ItemStack eb = CustomEnchants.getCustomEnchants().getRevealedItem(ce,
									EnchantConstructor.getEnchants().get(ce.getIdentifier()).getEnchantLevel(),
									currentSuccess, newAmount > 0 && newAmount <= 100 ? newAmount : currentDestroy, true, true);
							e.getInventory().setItem(22, eb);
							player.updateInventory();
						}
					}
				}
			}
		}
	}
}
