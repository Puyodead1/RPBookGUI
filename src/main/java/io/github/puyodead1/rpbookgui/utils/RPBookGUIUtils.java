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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.addon.EnchantRarity;
import me.randomhashtags.randompackage.api.CustomEnchants;

public class RPBookGUIUtils {

	public static LinkedHashMap<String, EnchantRarity> rarities = new LinkedHashMap<>();
	public static LinkedHashMap<String, CustomEnchant> enchants = new LinkedHashMap<>();

	/**
	 * Easier way to translate color codes
	 * @param msg
	 * @return string
	 */
	public static String chatColor(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	/**
	 * Sends messages to me (Puyodead1)
	 * @param msg
	 */
	public static void sendDebugMessage(String msg) {
		Bukkit.getServer().getPlayer("Puyodead1").sendMessage(msg);
	}

	/**
	 * Formats enchant names, replaces spaces with _
	 * @param item
	 * @return string
	 * @deprecated
	 */
	public static String formatEnchantName(ItemStack item) {
		return ChatColor.stripColor(item.getItemMeta().getDisplayName()
				.replace(" ", "_").toUpperCase());
	}

	/**
	 * Nearest multiple of 9 from a number
	 * @param from
	 * @return int
	 */
	public static int toNineDenom(int from) {
		return ((((from / 9) + ((from % 9 == 0) ? 0 : 1)) * 9));
	}

	/**
	 * Easier way to strip colors
	 * @param message
	 * @return
	 */
	public static String stripColor(String message) {
		return ChatColor.stripColor(message);
	}

	/**
	 * Checks if an item is being applied to the correct item
	 * @param enchant
	 * @param is
	 * @return boolean
	 * @deprecated
	 */
	public static boolean isOnCorrectItem(CustomEnchant enchant, ItemStack is) {
		final String i = is != null ? is.getType().name() : null;
		if (enchant != null && i != null)
			for (String s : enchant.getAppliesTo())
				if (i.endsWith(s.toUpperCase()))
					return true;
		return false;
	}

	/**
	 * Gets a list of custom enchants of a rarity
	 * @param rarity
	 * @return List<CustomEnchant>
	 * @deprecated
	 */
	public static List<CustomEnchant> getCustomEnchants(String rarity) {
		List<CustomEnchant> enchants = CustomEnchants.getCustomEnchants()
				.getCustomEnchantRarity(rarity.toUpperCase()).getEnchants();
		return enchants.stream().filter(e -> e.isEnabled())
				.collect(Collectors.toList());
	}

	/**
	 * Adds a new enchant rarity
	 * @param rarity
	 */
	public static void addEnchantRarity(EnchantRarity rarity) {
		final String identifier = rarity.getIdentifier();
		rarities.put(identifier, rarity);
	}

	public static void addCustomEnchant(CustomEnchant customEnchant) {
		enchants.put(customEnchant.getIdentifier(), customEnchant);
	}

	/**
	 * Clones an item
	 * @param is
	 * @param def
	 * @return ItemStack
	 */
	public static final ItemStack getClone(ItemStack is, ItemStack def) {
		return is != null ? is.clone() : def;
	}

}
