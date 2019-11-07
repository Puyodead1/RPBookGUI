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
package io.github.puyodead1.rpbookgui.Utils;

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

	public static String ChatColor(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	public static void SendDebugMessge(String msg) {
		Bukkit.getServer().getPlayer("Puyodead1").sendMessage(msg);
	}

	public static String FormatEnchantName(ItemStack item) {
		return ChatColor.stripColor(item.getItemMeta().getDisplayName()
				.replace(" ", "_").toUpperCase());
	}

	public static int toNineDenom(int from) {
		return ((((from / 9) + ((from % 9 == 0) ? 0 : 1)) * 9));
	}

	public static String Strip(String message) {
		return ChatColor.stripColor(message);
	}

	public static boolean isOnCorrectItem(CustomEnchant enchant, ItemStack is) {
		final String i = is != null ? is.getType().name() : null;
		if (enchant != null && i != null)
			for (String s : enchant.getAppliesTo())
				if (i.endsWith(s.toUpperCase()))
					return true;
		return false;
	}

	public static List<CustomEnchant> getCustomEnchants(String rarity) {
		List<CustomEnchant> enchants = CustomEnchants.getCustomEnchants()
				.getEnchantRarity(rarity.toUpperCase()).getEnchants();
		return enchants.stream().filter(e -> e.isEnabled())
				.collect(Collectors.toList());
	}

	public static void addEnchantRarity(EnchantRarity rarity) {
		final String identifier = rarity.getIdentifier();
		rarities.put(identifier, rarity);
	}

	public static final ItemStack getClone(ItemStack is, ItemStack def) {
		return is != null ? is.clone() : def;
	}

}
