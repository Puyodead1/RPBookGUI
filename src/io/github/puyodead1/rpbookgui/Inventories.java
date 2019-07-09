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
package io.github.puyodead1.rpbookgui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.api.CustomEnchants;
import me.randomhashtags.randompackage.utils.classes.customenchants.CustomEnchant;
import me.randomhashtags.randompackage.utils.classes.customenchants.EnchantRarity;

public class Inventories {
	// TODO: get the round method working, round to closest multiple of 9 depending
	// on the number of enchants.

	public static Inventory MainGUI() {
		Inventory inv = Bukkit.createInventory(null, 9, "Enchantment Categories");
		inv.setItem(0, ItemStacks.GlassSeperator().clone());
		inv.setItem(1, ItemStacks.SimpleCategoryItem().clone());
		inv.setItem(2, ItemStacks.UniqueCategoryItem().clone());
		inv.setItem(3, ItemStacks.EliteCategoryItem().clone());
		inv.setItem(4, ItemStacks.UltimateCategoryItem().clone());
		inv.setItem(5, ItemStacks.LegendaryCategoryItem().clone());
		inv.setItem(6, ItemStacks.SoulCategoryItem().clone());
		inv.setItem(7, ItemStacks.HeroicCategoryItem().clone());
		inv.setItem(8, ItemStacks.GlassSeperator().clone());
		return inv;
	}

	public static Inventory SimpleEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("SIMPLE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&f&lSimple Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory UniqueEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("UNIQUE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&a&lUnique Enchantments"));
		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce).clone();
			inv.setItem(i, is);
		}
		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory EliteEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("ELITE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&b&lElite Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory UltimateEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("ULTIMATE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&e&lUltimate Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory LegendaryEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("LEGENDARY").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&6&lLegendary Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory SoulEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("SOUL").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&c&lSoul Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory HeroicEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("HEROIC").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&d&lHeroic Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	/**/
	public static Inventory SimpleEnchants(ItemStack itemApplyTo) {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("SIMPLE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils
				.ChatColor("&f&lSimple Enchants - " + itemApplyTo.getType().toString().replace("DIAMOND_", "")));

		List<CustomEnchant> enchantsForIS = new ArrayList<CustomEnchant>();

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			if (RPBookGUIUtils.isOnCorrectItem(ce, itemApplyTo))
				enchantsForIS.add(ce);
		}

		for (int i = 0; i < enchantsForIS.size(); i++) {
			ItemStack is = ItemStacks.EnchantBook(enchantsForIS.get(i)).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory UniqueEnchants(ItemStack itemApplyTo) {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("UNIQUE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils
				.ChatColor("&a&lUnique Enchants - " + itemApplyTo.getType().toString().replace("DIAMOND_", "")));

		List<CustomEnchant> enchantsForIS = new ArrayList<CustomEnchant>();

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			if (RPBookGUIUtils.isOnCorrectItem(ce, itemApplyTo))
				enchantsForIS.add(ce);
		}

		for (int i = 0; i < enchantsForIS.size(); i++) {
			ItemStack is = ItemStacks.EnchantBook(enchantsForIS.get(i)).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory EliteEnchants(ItemStack itemApplyTo) {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("ELITE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils
				.ChatColor("&b&lElite Enchants - " + itemApplyTo.getType().toString().replace("DIAMOND_", "")));

		List<CustomEnchant> enchantsForIS = new ArrayList<CustomEnchant>();

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			if (RPBookGUIUtils.isOnCorrectItem(ce, itemApplyTo))
				enchantsForIS.add(ce);
		}

		for (int i = 0; i < enchantsForIS.size(); i++) {
			ItemStack is = ItemStacks.EnchantBook(enchantsForIS.get(i)).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory UltimateEnchants(ItemStack itemApplyTo) {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("ULTIMATE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils
				.ChatColor("&e&lUltimate Enchants - " + itemApplyTo.getType().toString().replace("DIAMOND_", "")));

		List<CustomEnchant> enchantsForIS = new ArrayList<CustomEnchant>();

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			if (RPBookGUIUtils.isOnCorrectItem(ce, itemApplyTo))
				enchantsForIS.add(ce);
		}

		for (int i = 0; i < enchantsForIS.size(); i++) {
			ItemStack is = ItemStacks.EnchantBook(enchantsForIS.get(i)).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory LegendaryEnchants(ItemStack itemApplyTo) {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("LEGENDARY").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils
				.ChatColor("&6&lLegendary Enchants - " + itemApplyTo.getType().toString().replace("DIAMOND_", "")));

		List<CustomEnchant> enchantsForIS = new ArrayList<CustomEnchant>();

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			if (RPBookGUIUtils.isOnCorrectItem(ce, itemApplyTo))
				enchantsForIS.add(ce);
		}

		for (int i = 0; i < enchantsForIS.size(); i++) {
			ItemStack is = ItemStacks.EnchantBook(enchantsForIS.get(i)).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory SoulEnchants(ItemStack itemApplyTo) {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("SOUL").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils
				.ChatColor("&c&lSoul Enchants - " + itemApplyTo.getType().toString().replace("DIAMOND_", "")));

		List<CustomEnchant> enchantsForIS = new ArrayList<CustomEnchant>();

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			if (RPBookGUIUtils.isOnCorrectItem(ce, itemApplyTo))
				enchantsForIS.add(ce);
		}

		for (int i = 0; i < enchantsForIS.size(); i++) {
			ItemStack is = ItemStacks.EnchantBook(enchantsForIS.get(i)).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory HeroicEnchants(ItemStack itemApplyTo) {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("HEROIC").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils
				.ChatColor("&d&lHeroic Enchants - " + itemApplyTo.getType().toString().replace("DIAMOND_", "")));

		List<CustomEnchant> enchantsForIS = new ArrayList<CustomEnchant>();

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			if (RPBookGUIUtils.isOnCorrectItem(ce, itemApplyTo))
				enchantsForIS.add(ce);
		}

		for (int i = 0; i < enchantsForIS.size(); i++) {
			ItemStack is = ItemStacks.EnchantBook(enchantsForIS.get(i)).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory EnchantInv(CustomEnchant ce) {
		EnchantRarity rarity = EnchantRarity.valueOf(ce);
		Inventory inv = Bukkit.createInventory(null, 18, rarity.getNameColors() + ce.getName());
		int x = 0;
		for (int i = 1; i < ce.getMaxLevel() + 1; i++) {
			ItemStack is = CustomEnchants.getCustomEnchants().getRevealedItem(ce, i, 100, 0, true, true).clone();
			inv.setItem(x, is);
			x++;
		}
		inv.setItem(17, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory SettingsInv() {
		Inventory inv = Bukkit.createInventory(null, 36, RPBookGUIUtils.ChatColor("&6&lRPBookGUI Settings"));

		for (int i = 0; i < 10; i++)
			inv.setItem(i, ItemStacks.GlassSeperator().clone());
		inv.setItem(10, ItemStacks.GlassSeperator2().clone());
		inv.setItem(11, ItemStacks.KeepMenuOpenSetting().clone());
		inv.setItem(12, ItemStacks.GlassSeperator2().clone());

		inv.setItem(13, ItemStacks.GlassSeperator3().clone());

		inv.setItem(14, ItemStacks.GlassSeperator2().clone());
		inv.setItem(15, ItemStacks.UsePermissionsSetting().clone());
		inv.setItem(16, ItemStacks.GlassSeperator2().clone());

		inv.setItem(17, ItemStacks.GlassSeperator().clone());
		inv.setItem(18, ItemStacks.GlassSeperator().clone());
		for (int i = 26; i < 36; i++)
			inv.setItem(i, ItemStacks.GlassSeperator().clone());
		inv.setItem(22, ItemStacks.Back().clone());
		return inv;
	}
}
