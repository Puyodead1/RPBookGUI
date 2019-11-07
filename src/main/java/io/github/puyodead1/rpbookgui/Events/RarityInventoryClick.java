package io.github.puyodead1.rpbookgui.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.ItemStacks;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.util.RPStorage;
import me.randomhashtags.randompackage.util.universal.UMaterial;

public class RarityInventoryClick extends RPBookGUIUtils implements Listener {

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e) {
		if (!e.isCancelled() && e.getCurrentItem() != null
				&& !e.getCurrentItem().getType().equals(Material.AIR)
				&& e.getClickedInventory() != null && e.getCursor() != null
				&& !e.getClick().equals(ClickType.DOUBLE_CLICK)) {
			ItemStack item = e.getCurrentItem();
			Player player = (Player) e.getWhoClicked();
			String invTitle = e.getView().getTitle();

			
			if (rarities.keySet().contains(Strip(invTitle))) {
				e.setCancelled(true);
				
				if(item.getType().equals(UMaterial.match("BOOK").getMaterial())) {
					// Close if its the back button
					if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back()
							.clone().getItemMeta().getDisplayName())) {
						player.getOpenInventory().close();
						player.openInventory(Inventories.mainInventory());
					}
					player.getOpenInventory().close();
					final CustomEnchant ce = RPStorage.valueOfCustomEnchant(Strip(
							e.getCurrentItem().getItemMeta().getDisplayName()),
							true);
					player.openInventory(Inventories.enchantInventory(ce));
				} else {
					player.getOpenInventory().close();
					player.openInventory(Inventories.mainInventory());
				}
			}
		}
	}
}
