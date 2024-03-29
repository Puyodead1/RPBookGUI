package io.github.puyodead1.rpbookgui.events;

import java.util.Map.Entry;

import me.randomhashtags.randompackage.RandomPackageAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.EnchantConstructor;
import io.github.puyodead1.rpbookgui.utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.api.CustomEnchants;
import me.randomhashtags.randompackage.util.RPStorage;

public class SuccessDestroyInventoryClick extends RPBookGUIUtils
		implements
			Listener {

	@EventHandler
	public void clickEvent(InventoryClickEvent e) {
		if (!e.isCancelled() && e.getCurrentItem() != null
				&& !e.getCurrentItem().getType().equals(Material.AIR)
				&& e.getClickedInventory() != null && e.getCursor() != null
				&& !e.getClick().equals(ClickType.DOUBLE_CLICK)) {
			Player player = (Player) e.getWhoClicked();
			String invTitle = e.getView().getTitle();

			if ("Success & Destroy Configuration".equals(invTitle)) {
				e.setCancelled(true);
				if (e.getCurrentItem().getType().equals(Material.BOOK)) {
					EnchantConstructor.getEnchants().clear();
					player.getInventory().addItem(e.getCurrentItem().clone());
					player.getOpenInventory().close();
				} else {
					String incrementType = stripColor(
							e.getCurrentItem().getItemMeta().getDisplayName())
									.substring(0, 1);
					String[] split = stripColor(
							e.getCurrentItem().getItemMeta().getDisplayName())
									.substring(1).split(" ");
					int amount = Integer.parseInt(split[0]);
					String type = split[1].toLowerCase();

					int currentSuccess = Integer.parseInt(ChatColor
							.stripColor(e.getInventory().getItem(22)
									.getItemMeta().getLore().get(0))
							.split("%")[0]);
					int currentDestroy = Integer.parseInt(ChatColor
							.stripColor(e.getInventory().getItem(22)
									.getItemMeta().getLore().get(1))
							.split("%")[0]);

					Entry<String, EnchantConstructor> entry = EnchantConstructor
							.getEnchants().entrySet().iterator().next();
					CustomEnchant ce = RandomPackageAPI.INSTANCE.valueOfCustomEnchant(entry.getKey(), true);

					if ("success".equals(type)) {
						if ("+".equals(incrementType)) {
							final int newAmount = (currentSuccess + amount);
							ItemStack eb = CustomEnchants.getCustomEnchants()
									.getRevealedItem(ce,
											EnchantConstructor.getEnchants()
													.get(ce.getIdentifier())
													.getEnchantLevel(),
											newAmount >= 0 && newAmount <= 100
													? newAmount
													: currentSuccess,
											currentDestroy, true, true);
							e.getInventory().setItem(22, eb);
							player.updateInventory();
						} else if ("-".equals(incrementType)) {
							final int newAmount = (currentSuccess - amount);
							ItemStack eb = CustomEnchants.getCustomEnchants()
									.getRevealedItem(ce,
											EnchantConstructor.getEnchants()
													.get(ce.getIdentifier())
													.getEnchantLevel(),
											newAmount >= 0 && newAmount <= 100
													? newAmount
													: currentSuccess,
											currentDestroy, true, true);
							e.getInventory().setItem(22, eb);
							player.updateInventory();
						}
					} else if ("destroy".equals(type)) {
						if ("+".equals(incrementType)) {
							final int newAmount = (currentDestroy + amount);
							ItemStack eb = CustomEnchants.getCustomEnchants()
									.getRevealedItem(ce,
											EnchantConstructor.getEnchants()
													.get(ce.getIdentifier())
													.getEnchantLevel(),
											currentSuccess,
											newAmount >= 0 && newAmount <= 100
													? newAmount
													: currentDestroy,
											true, true);
							e.getInventory().setItem(22, eb);
							player.updateInventory();
						} else if ("-".equals(incrementType)) {
							final int newAmount = (currentDestroy - amount);
							ItemStack eb = CustomEnchants.getCustomEnchants()
									.getRevealedItem(ce,
											EnchantConstructor.getEnchants()
													.get(ce.getIdentifier())
													.getEnchantLevel(),
											currentSuccess,
											newAmount >= 0 && newAmount <= 100
													? newAmount
													: currentDestroy,
											true, true);
							e.getInventory().setItem(22, eb);
							player.updateInventory();
						}
					}
				}
			}
		}
	}
}
