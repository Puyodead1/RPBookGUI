package io.github.puyodead1.rpbookgui.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.util.RPStorage;
import me.randomhashtags.randompackage.util.universal.UMaterial;

public class EnchantInventoryClick extends RPBookGUIUtils implements Listener {

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e) {
		if (!e.isCancelled() && e.getCurrentItem() != null
				&& !e.getCurrentItem().getType().equals(Material.AIR)
				&& e.getClickedInventory() != null && e.getCursor() != null
				&& !e.getClick().equals(ClickType.DOUBLE_CLICK)) {
			ItemStack item = e.getCurrentItem();
			Player player = (Player) e.getWhoClicked();
			String invTitle = e.getView().getTitle();

			if (enchants.keySet().contains(
					Strip(invTitle).toUpperCase().replace(" ", "_"))) {
				e.setCancelled(true);

				if (item.getType()
						.equals(UMaterial.match("BOOK").getMaterial())) {
					// Note: there was the old enchant constructor removal here,
					// but
					// doesnt seem needed as there is only one enchant now
					if (RPBookGUI.getPlugin.getConfig().getBoolean(
							"settings.use success destroy configuration")) {
						player.getOpenInventory().close();
						player.openInventory(
								Inventories.successAndDestroyInventory(
										RPStorage.valueOfCustomEnchant(item)));
					} else {
						player.getInventory().addItem(item);
						if (!RPBookGUI.getPlugin.getConfig()
								.getBoolean("settings.keep inventory open"))
							player.getOpenInventory().close();
						player.sendMessage(RPBookGUIUtils
								.ChatColor(RPBookGUI.getPlugin.getConfig()
										.getString("messages.added book")
										.replace("{NAME}", item.getItemMeta()
												.getDisplayName())));
					}
				} else {
					player.getOpenInventory().close();
					player.openInventory(Inventories.mainInventory());
				}
			}
		}
	}
}
