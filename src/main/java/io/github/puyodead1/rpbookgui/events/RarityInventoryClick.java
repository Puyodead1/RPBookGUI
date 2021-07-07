package io.github.puyodead1.rpbookgui.events;

import io.github.puyodead1.rpbookgui.utils.UMaterial;
import me.randomhashtags.randompackage.RandomPackageAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.utils.ItemStackUtils;
import io.github.puyodead1.rpbookgui.utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.util.RPStorage;

public class RarityInventoryClick extends RPBookGUIUtils implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        if (e.isCancelled() || e.getCurrentItem() == null || e.getCurrentItem() == null
                || e.getCurrentItem().getType().equals(Material.AIR)
                || e.getClickedInventory() == null || e.getCursor() == null
                || e.getClick().equals(ClickType.DOUBLE_CLICK))
            return;

        ItemStack item = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();
        String invTitle = e.getView().getTitle();

        if (rarities.containsKey(stripColor(invTitle))) {
            e.setCancelled(true);

            if (item.getType().equals(UMaterial.match("BOOK").getMaterial())) {
                // Close if its the back button
                if (item.getItemMeta().getDisplayName().equals(ItemStackUtils.back()
                        .clone().getItemMeta().getDisplayName())) {
                    player.getOpenInventory().close();
                    player.openInventory(Inventories.mainInventory());
                }
                player.getOpenInventory().close();
                final CustomEnchant ce = RandomPackageAPI.INSTANCE.valueOfCustomEnchant(stripColor(
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
