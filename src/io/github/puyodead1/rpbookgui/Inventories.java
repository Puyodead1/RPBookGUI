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

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.Utils.PlayerConfigs;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.api.CustomEnchants;
import me.randomhashtags.randompackage.utils.classes.customenchants.CustomEnchant;
import me.randomhashtags.randompackage.utils.classes.customenchants.EnchantRarity;

public class Inventories {
	// TODO: get the round method working, round to closest multiple of 9 depending
	// on the number of enchants.

	public static Inventory MainGUI() {
		Inventory inv = Bukkit.createInventory(null, 9, "Enchantment Categories");
		inv.setItem(0, ItemStacks.GlassSeperator());
		inv.setItem(1, ItemStacks.SimpleCategoryItem());
		inv.setItem(2, ItemStacks.UniqueCategoryItem());
		inv.setItem(3, ItemStacks.EliteCategoryItem());
		inv.setItem(4, ItemStacks.UltimateCategoryItem());
		inv.setItem(5, ItemStacks.LegendaryCategoryItem());
		inv.setItem(6, ItemStacks.SoulCategoryItem());
		inv.setItem(7, ItemStacks.HeroicCategoryItem());
		inv.setItem(8, ItemStacks.GlassSeperator());
		return inv;
	}

	public static Inventory SimpleEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("SIMPLE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&f&lSimple Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce);
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back());
		return inv;
	}

	public static Inventory UniqueEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("UNIQUE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&a&lUnique Enchantments"));
		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce);
			inv.setItem(i, is);
		}
		inv.setItem(53, ItemStacks.Back());
		return inv;
	}

	public static Inventory EliteEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("ELITE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&b&lElite Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce);
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back());
		return inv;
	}

	public static Inventory UltimateEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("ULTIMATE").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&e&lUltimate Enchantments"));
		;

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce);
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back());
		return inv;
	}

	public static Inventory LegendaryEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("LEGENDARY").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&6&lLegendary Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce);
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back());
		return inv;
	}

	public static Inventory SoulEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("SOUL").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&c&lSoul Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce);
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back());
		return inv;
	}

	public static Inventory HeroicEnchants() {
		List<CustomEnchant> rarities = EnchantRarity.rarities.get("HEROIC").getEnchants();
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&d&lHeroic Enchantments"));

		for (int i = 0; i < rarities.size(); i++) {
			CustomEnchant ce = rarities.get(i);
			ItemStack is = ItemStacks.EnchantBook(ce);
			inv.setItem(i, is);
		}

		inv.setItem(53, ItemStacks.Back());
		return inv;
	}

	public static Inventory EnchantInv(CustomEnchant ce) {
		EnchantRarity rarity = EnchantRarity.valueOf(ce);
		Inventory inv = Bukkit.createInventory(null, 18, rarity.getNameColors() + ce.getName());
		int x = 0;
		for (int i = 1; i < ce.getMaxLevel() + 1; i++) {
			ItemStack is = CustomEnchants.getCustomEnchants().getRevealedItem(ce, i, 100, 0, true, true);
			inv.setItem(x, is);
			x++;
		}
		inv.setItem(17, ItemStacks.Back());
		return inv;
	}

	public static Inventory SettingsInv() {
		Inventory inv = Bukkit.createInventory(null, 36, RPBookGUIUtils.ChatColor("&6&lRPBookGUI Settings"));

		for (int i = 0; i < 10; i++) {
			inv.setItem(i, ItemStacks.GlassSeperator());
		}
		inv.setItem(10, ItemStacks.GlassSeperator2());
		inv.setItem(11, ItemStacks.KeepMenuOpenSetting());
		inv.setItem(12, ItemStacks.GlassSeperator2());

		inv.setItem(13, ItemStacks.GlassSeperator3());

		inv.setItem(14, ItemStacks.GlassSeperator2());
		inv.setItem(15, ItemStacks.UsePermissionsSetting());
		inv.setItem(16, ItemStacks.GlassSeperator2());

		inv.setItem(17, ItemStacks.GlassSeperator());
		inv.setItem(18, ItemStacks.GlassSeperator());
		for (int i = 26; i < 36; i++) {
			inv.setItem(i, ItemStacks.GlassSeperator());
		}
		inv.setItem(22, ItemStacks.Back());
		return inv;
	}

	public static Inventory KitCreatorKitsInv(UUID uuid) {
		FileConfiguration playerConfig = PlayerConfigs.getPlayerConfig(uuid);
		int ownedKits = playerConfig.getInt("kits.owned-kits");

		// TODO: round to nearest multiple of 9 by amount of kits.
		Inventory inv = Bukkit.createInventory(null, 9, RPBookGUIUtils.ChatColor("&6&lKitCreator - Kits"));

//		for(int i = 0; i < ownedKits; i++) {
//			List<String> kits = playerConfig.getStringList("kits.kits." + i);
//			for(String kit : kits) {
//				Bukkit.getServer().getPlayer(uuid).sendMessage(kit);
//			}
//		}

		if (ownedKits == 0) {
			for (int a = 0; a < inv.getSize(); a++) {
				inv.setItem(a, ItemStacks.GlassSeperator());
			}
			inv.setItem(8, ItemStacks.CreateKit());
		} else {
			for (int i = 0; i < ownedKits; i++) {
				List<String> kits = playerConfig.getStringList("kits.kits." + i);
				Material mat = Material.valueOf(playerConfig.getString("kits.kits." + i + ".item"));
				ItemStack is = new ItemStack(mat);
				inv.setItem(i, is);
			}
		}

		return inv;
	}

	public static Inventory KitCreatorOverviewInv() {
		Inventory inv = Bukkit.createInventory(null, 54, RPBookGUIUtils.ChatColor("&6&lKit Creator - Kit Editor"));

		for (int i = 0; i < 54; i++) {
			inv.setItem(i, ItemStacks.GlassSeperator());
		}

		inv.setItem(13, new ItemStack(Material.DIAMOND_HELMET));
		inv.setItem(16, new ItemStack(Material.BOW));
		inv.setItem(21, new ItemStack(Material.DIAMOND_SWORD));
		inv.setItem(22, new ItemStack(Material.DIAMOND_CHESTPLATE));
		inv.setItem(23, new ItemStack(Material.DIAMOND_AXE));
		inv.setItem(25, new ItemStack(Material.DIAMOND_PICKAXE));
		inv.setItem(31, new ItemStack(Material.DIAMOND_LEGGINGS));
		inv.setItem(34, new ItemStack(Material.DIAMOND_SHOVEL));
		inv.setItem(40, new ItemStack(Material.DIAMOND_BOOTS));

		return inv;
	}
}
