package io.github.puyodead1.rpbookgui.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.addon.EnchantRarity;

public class MainInventoryClick extends RPBookGUIUtils implements Listener {
	
	@EventHandler
	public void clickEvent(InventoryClickEvent e) {
		if (!e.isCancelled() && e.getCurrentItem() != null
				&& !e.getCurrentItem().getType().equals(Material.AIR)
				&& e.getClickedInventory() != null && e.getCursor() != null
				&& !e.getClick().equals(ClickType.DOUBLE_CLICK)) {
			ItemStack item = e.getCurrentItem();
			Player player = (Player) e.getWhoClicked();
			String invTitle = e.getView().getTitle();
			
			if("Enchantment Categories".equals(invTitle)) {
				String itemName = item.getItemMeta().getDisplayName().split(" ")[0];
				itemName = stripColor(itemName).toUpperCase();

				// TODO: this is terrible
				for(final EnchantRarity rarity : rarities.values()) {
					if(itemName.equals(rarity.getIdentifier())) {
						e.setCancelled(true);
						player.getOpenInventory().close();
						player.openInventory(Inventories.rarityInventory(rarity));
						return;
					}
				}
			}
		}
	}
}
