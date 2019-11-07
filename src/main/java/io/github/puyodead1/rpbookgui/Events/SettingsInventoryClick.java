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
import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;

public class SettingsInventoryClick extends RPBookGUIUtils implements Listener {

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e) {
		if (!e.isCancelled() && e.getCurrentItem() != null
				&& !e.getCurrentItem().getType().equals(Material.AIR)
				&& e.getClickedInventory() != null && e.getCursor() != null
				&& !e.getClick().equals(ClickType.DOUBLE_CLICK)) {
			ItemStack item = e.getCurrentItem();
			Player player = (Player) e.getWhoClicked();
			String invTitle = e.getView().getTitle();

			if (invTitle.equals("RPBookGUI Settings")) {
				e.setCancelled(true);

				if (item.getItemMeta().getDisplayName().equals(ItemStacks.Back()
						.clone().getItemMeta().getDisplayName()))
					player.getOpenInventory().close();
				if (item.getItemMeta().getDisplayName()
						.equals(ItemStacks.KeepMenuOpenSetting().clone()
								.getItemMeta().getDisplayName())) {
					RPBookGUI.getPlugin.getConfig().set("settings.keepinvopen",
							!RPBookGUI.getPlugin.getConfig()
									.getBoolean("settings.keepinvopen"));

					player.getOpenInventory().close();
					player.openInventory(Inventories.settingsInventory());
				}
				if (item.getItemMeta().getDisplayName()
						.equals(ItemStacks.UsePermissionsSetting().clone()
								.getItemMeta().getDisplayName())) {
					RPBookGUI.getPlugin.getConfig().set(
							"settings.usepermissions",
							!RPBookGUI.getPlugin.getConfig()
									.getBoolean("settings.usepermissions"));

					player.getOpenInventory().close();
					player.openInventory(Inventories.settingsInventory());
				}
			}
		}
	}
}
