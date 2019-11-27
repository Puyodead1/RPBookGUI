/*******************************************************************************
 * Copyright 2019 Puyodead1
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package io.github.puyodead1.rpbookgui.utils;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.puyodead1.rpbookgui.RPBookGUI;
import me.randomhashtags.randompackage.RandomPackage;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.addon.EnchantRarity;

public class ItemStackUtils {

	public static ItemStack glassSeperator() {
		ItemStack item = new ItemStack(UMaterial.match("WHITE_STAINED_GLASS_PANE").getMaterial());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack glassSeperator2() {
		ItemStack item = new ItemStack(UMaterial.match("RED_STAINED_GLASS_PANE").getMaterial());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack glassSeperator3() {
		ItemStack item = new ItemStack(UMaterial.match("BLUE_STAINED_GLASS_PANE").getMaterial());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack back() {
		ItemStack item = new ItemStack(UMaterial.match("BARRIER").getMaterial());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.chatColor("&c&lGo Back"));
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack enchantBook(EnchantRarity rarity, CustomEnchant ce) {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(rarity.getNameColors() + ce.getName());
		ArrayList<String> lore = new ArrayList<String>();
		lore.addAll(ce.getLore());
		String path = ce.getAppliesTo().toString().toLowerCase().replace(",", ";").replace("[", "").replace("]", "")
				.replaceAll("\\p{Z}", "");
		FileConfiguration config = YamlConfiguration
				.loadConfiguration(new File(RandomPackage.getPlugin.getDataFolder(), "custom enchants/_settings.yml"));
		lore.add(RPBookGUIUtils.chatColor(config.getString("enchant types." + path)));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack keepMenuOpenSetting() {
		ItemStack is = new ItemStack(Material.CHEST);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();
		Boolean currentSetting = RPBookGUI.getPlugin.getConfig().getBoolean("settings.keep inventory open");
		String currentSettingString;
		if (currentSetting)
			currentSettingString = "&a&l&nTrue";
		else
			currentSettingString = "&c&l&nFalse";

		im.setDisplayName(RPBookGUIUtils.chatColor("&dKeep Inventory Open"));
		il.add(RPBookGUIUtils.chatColor("&7Keep menu open after"));
		il.add(RPBookGUIUtils.chatColor("&7adding an item to inventory."));
		il.add(RPBookGUIUtils.chatColor("&eClick to toggle"));
		il.add(RPBookGUIUtils.chatColor(currentSettingString));
		im.setLore(il);
		is.setItemMeta(im);

		return is;
	}

	public static ItemStack usePermissionsSetting() {
		ItemStack is = new ItemStack(Material.PAPER);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();
		Boolean currentSetting = RPBookGUI.getPlugin.getConfig().getBoolean("settings.use permissions");
		String currentSettingString;
		if (currentSetting)
			currentSettingString = "&a&l&nTrue";
		else
			currentSettingString = "&c&l&nFalse";

		im.setDisplayName(RPBookGUIUtils.chatColor("&dUse Permissions"));
		il.add(RPBookGUIUtils.chatColor("&7Permissions are needed to"));
		il.add(RPBookGUIUtils.chatColor("&7open the Main Menu (/bookgui)."));
		il.add(RPBookGUIUtils.chatColor("&eClick to toggle"));
		il.add(RPBookGUIUtils.chatColor(currentSettingString));
		im.setLore(il);
		is.setItemMeta(im);

		return is;
	}
}
