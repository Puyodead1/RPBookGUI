package io.github.puyodead1.rpbookgui.events;

import io.github.puyodead1.rpbookgui.utils.UMaterial;
import me.randomhashtags.randompackage.RandomPackageAPI;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.api.CustomEnchants;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.util.RPStorage;

public class EnchantInventoryClick extends RPBookGUIUtils implements Listener {

	@EventHandler
	public void clickEvent(InventoryClickEvent e) {
		if (e.isCancelled() || e.getCurrentItem() == null
				|| e.getCurrentItem().getType().equals(Material.AIR)
				|| e.getClickedInventory() == null || e.getCursor() == null
				|| e.getClick().equals(ClickType.DOUBLE_CLICK)) return;

		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		String invTitle = e.getView().getTitle();

		if (enchants.containsKey(
				stripColor(invTitle).toUpperCase().replace(" ", "_"))) {
			e.setCancelled(true);

			if (item.getType()
					.equals(UMaterial.match("BOOK").getMaterial())) {
				if (RPBookGUI.getPlugin.getConfig().getBoolean(
						"settings.use success destroy configuration")) {
					player.getOpenInventory().close();
					final CustomEnchant ce = RandomPackageAPI.INSTANCE.valueOfCustomEnchant(item);
					final int level = CustomEnchants.getCustomEnchants().getEnchantmentLevel(item.getItemMeta().getDisplayName());
					player.openInventory(
							Inventories.successAndDestroyInventory(
									ce, level));

				} else {
					player.getInventory().addItem(item);
					if (!RPBookGUI.getPlugin.getConfig()
							.getBoolean("settings.keep inventory open"))
						player.getOpenInventory().close();
					player.sendMessage(RPBookGUIUtils
							.chatColor(RPBookGUI.getPlugin.getConfig()
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
