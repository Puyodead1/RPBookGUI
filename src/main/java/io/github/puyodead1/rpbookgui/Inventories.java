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
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.RandomPackageAPI;
import me.randomhashtags.randompackage.addons.CustomEnchant;
import me.randomhashtags.randompackage.addons.EnchantRarity;
import me.randomhashtags.randompackage.api.CustomEnchants;

public class Inventories {
	
	private static RandomPackageAPI rpapi = new RandomPackageAPI();
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("SIMPLE");
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&7&lSimple Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce).clone();
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory UniqueEnchants() {
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("UNIQUE");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("ELITE");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("ULTIMATE");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("LEGENDARY");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("SOUL");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("HEROIC");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("SIMPLE");
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils
				.ChatColor("&7&lSimple Enchants - " + itemApplyTo.getType().toString().replace("DIAMOND_", "")));

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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("UNIQUE");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("ELITE");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("ULTIMATE");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("LEGENDARY");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("SOUL");
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
		List<CustomEnchant> rarities = RPBookGUIUtils.getCustomEnchants("HEROIC");
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
	
	public static Inventory Enchant(CustomEnchant ce) {
		EnchantRarity rarity = rpapi.valueOfEnchantRarity(ce);
		Inventory inv = Bukkit.createInventory(null, 18, rarity.getNameColors() + ce.getName());
		int x = 0;
		for (int i = 1; i < ce.getMaxLevel() + 1; i++) {
			ItemStack is = CustomEnchants.getCustomEnchants().getRevealedItem(ce, i, 100, 0, true, true).clone();
			new EnchantConstructor(ce, rarity, i, 0, 0);
			Bukkit.broadcastMessage("EnchantConstructor size: " + EnchantConstructor.getEnchants().size());
			inv.setItem(x, is);
			x++;
		}
		Bukkit.broadcastMessage("Final EnchantConstructor size: " + EnchantConstructor.getEnchants().size());
		inv.setItem(17, ItemStacks.Back().clone());
		return inv;
	}

	public static Inventory Settings() {
		Inventory inv = Bukkit.createInventory(null, 36, "RPBookGUI Settings");

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
	
	public static Inventory SuccessDestroySelection(ItemStack book) {
		Inventory inv = Bukkit.createInventory(null, 54, "Success & Destry Configuration");
		CustomEnchant ce = rpapi.valueOfCustomEnchant(book);
		// slot 10 - increase success
		// slot 28 - decrease success
		// slot 21 - book
		
		ItemStack addSuccess = new ItemStack(Material.GREEN_WOOL);
		ItemStack removeSuccess = new ItemStack(Material.RED_WOOL);
		
		inv.setItem(10, addSuccess);
//		inv.setItem(21, CustomEnchants.getCustomEnchants().getRevealedItem(ce, EnchantConstructor.getEnchants().get(ce.getName()).getEnchantLevel(), 0, 0, true, true));
		inv.setItem(28, removeSuccess);
		
		for(EnchantConstructor ec : EnchantConstructor.getEnchants().values()) {
			Bukkit.broadcastMessage(ec.getCustomEnchant().getIdentifier() + " " + ec.getEnchantLevel());
		}
		
		return inv;
	}
}
