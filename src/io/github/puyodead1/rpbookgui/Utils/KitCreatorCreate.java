package io.github.puyodead1.rpbookgui.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitCreatorCreate {
	
	public static void CreateKit(Player p, ItemStack[] arrayOfItemStack) {
		FileConfiguration playerConfig = PlayerConfigs.getPlayerConfig(p.getUniqueId());

		int ownedKits = playerConfig.getInt("kits.ownedKits");
		int kitName;
		if (ownedKits == 0) {
			kitName = 0;
		} else {
			kitName = ownedKits + 1;
		}

		List items = new ArrayList();
		int bookNr = 0;
		byte b;
		int j;
		String metaText = "";

		for (j = arrayOfItemStack.length, b = 0; b < j;) {
			ItemStack i = arrayOfItemStack[b];
			if (i instanceof ItemStack) {

				if (i.hasItemMeta()) {

					ItemMeta meta = i.getItemMeta();

					if (meta.hasEnchants()) {
						for (Enchantment e : meta.getEnchants().keySet()) {
							metaText = String.valueOf(metaText) + " " + e.getName().toLowerCase() + ":"
									+ meta.getEnchantLevel(e);
						}
					}

					if (meta.hasDisplayName()) {

						String name = "";
						name = meta.getDisplayName();
						name = name.replace(" ", "_");
						metaText = String.valueOf(metaText) + " name:" + name;
					}

					if (meta.hasLore()) {

						metaText = String.valueOf(metaText) + " lore:";
						for (String s : meta.getLore()) {
							metaText = String.valueOf(metaText) + s.replace(" ", "_") + "|";
						}
						metaText = metaText.substring(0, metaText.length() - 1);
					}
				}

				items.add(String.valueOf(i.getType()) + metaText);
				metaText = "";
			}
			b++;
		}
		//
		playerConfig.set("kits." + kitName + ".items", items);
		playerConfig.set("kits." + kitName + ".item", "STONE");
		playerConfig.set("kits.owned-kits", ownedKits + 1);
		try {
			playerConfig.save(PlayerConfigs.getPlayerConfigFile(p.getUniqueId()));
			playerConfig.load(PlayerConfigs.getPlayerConfigFile(p.getUniqueId()));
		}catch(IOException e) {
			Bukkit.getServer().getLogger().log(
			          Level.SEVERE, 
			          "Unable to save configuration file! Caused by: " + 
			          e.getMessage());
		}
		catch(InvalidConfigurationException e) {
			Bukkit.getServer().getLogger().log(Level.SEVERE, 
			          "Invalid configuration! Caused by: " + e.getMessage());
		}
	}
}
