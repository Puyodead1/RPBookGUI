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

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.RandomPackage;
import me.randomhashtags.randompackage.addons.CustomEnchant;
import me.randomhashtags.randompackage.addons.EnchantRarity;
import me.randomhashtags.randompackage.utils.universal.UMaterial;

public class ItemStacks {

	public static ItemStack SimpleCategoryItem() {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&f&lSimple Enchants"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(RPBookGUIUtils.ChatColor("&7Click to view &f&lSimple Enchantments"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack UniqueCategoryItem() {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&a&lUnique Enchants"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(RPBookGUIUtils.ChatColor("&7Click to view &a&lUnique Enchantments"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack EliteCategoryItem() {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lElite Enchants"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(RPBookGUIUtils.ChatColor("&7Click to view &b&lElite Enchantments"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack UltimateCategoryItem() {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&e&lUltimate Enchants"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(RPBookGUIUtils.ChatColor("&7Click to view &e&lUltimate Enchantments"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack LegendaryCategoryItem() {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&6&lLegendary Enchants"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(RPBookGUIUtils.ChatColor("&7Click to view &6&lLegendary Enchantments"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack SoulCategoryItem() {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&c&lSoul Enchants"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(RPBookGUIUtils.ChatColor("&7Click to view &c&lSoul Enchantments"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack HeroicCategoryItem() {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&d&lHeroic Enchants"));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(RPBookGUIUtils.ChatColor("&7Click to view &d&lHeroic Enchantments"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack GlassSeperator() {
		ItemStack item = new ItemStack(UMaterial.match("WHITE_STAINED_GLASS_PANE").getMaterial());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack GlassSeperator2() {
		ItemStack item = new ItemStack(UMaterial.match("RED_STAINED_GLASS_PANE").getMaterial());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack GlassSeperator3() {
		ItemStack item = new ItemStack(UMaterial.match("BLUE_STAINED_GLASS_PANE").getMaterial());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack Back() {
		ItemStack item = new ItemStack(UMaterial.match("BARRIER").getMaterial());
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&c&lGo Back"));
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKit() {
		ItemStack item = new ItemStack(UMaterial.match("CHEST").getMaterial());
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&6&lCreate Kit"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to create a"));
		il.add(RPBookGUIUtils.ChatColor("&7new kit."));

		meta.setLore(il);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack EnchantBook(CustomEnchant ce) {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		EnchantRarity rarity = EnchantRarity.valueOf(ce);

		meta.setDisplayName(rarity.getNameColors() + ce.getName());
		ArrayList<String> lore = new ArrayList<String>();
		lore.addAll(ce.getLore());
		String path = ce.getAppliesTo().toString().toLowerCase().replace(",", ";").replace("[", "").replace("]", "")
				.replaceAll("\\p{Z}", "");
		FileConfiguration config = YamlConfiguration
				.loadConfiguration(new File(RandomPackage.getPlugin.getDataFolder(), "custom enchants.yml"));
		lore.add(RPBookGUIUtils.ChatColor(config.getString("enchant types." + path)));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack KeepMenuOpenSetting() {
		ItemStack is = new ItemStack(Material.CHEST);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();
		Boolean currentSetting = RPBookGUI.getPlugin.getConfig().getBoolean("settings.keep inventory open");
		String currentSettingString;
		if (currentSetting)
			currentSettingString = "&a&l&nTrue";
		else
			currentSettingString = "&c&l&nFalse";

		im.setDisplayName(RPBookGUIUtils.ChatColor("&dKeep Inventory Open"));
		il.add(RPBookGUIUtils.ChatColor("&7Keep menu open after"));
		il.add(RPBookGUIUtils.ChatColor("&7adding an item to inventory."));
		il.add(RPBookGUIUtils.ChatColor("&eClick to toggle"));
		il.add(RPBookGUIUtils.ChatColor(currentSettingString));
		im.setLore(il);
		is.setItemMeta(im);

		return is;
	}

	public static ItemStack UsePermissionsSetting() {
		ItemStack is = new ItemStack(Material.PAPER);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();
		Boolean currentSetting = RPBookGUI.getPlugin.getConfig().getBoolean("settings.use permissions");
		String currentSettingString;
		if (currentSetting)
			currentSettingString = "&a&l&nTrue";
		else
			currentSettingString = "&c&l&nFalse";

		im.setDisplayName(RPBookGUIUtils.ChatColor("&dUse Permissions"));
		il.add(RPBookGUIUtils.ChatColor("&7Permissions are needed to"));
		il.add(RPBookGUIUtils.ChatColor("&7open the Main Menu (/bookgui)."));
		il.add(RPBookGUIUtils.ChatColor("&eClick to toggle"));
		il.add(RPBookGUIUtils.ChatColor(currentSettingString));
		im.setLore(il);
		is.setItemMeta(im);

		return is;
	}

	public static ItemStack CreateKitHelmateBase() {
		ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lHelmet"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKitChestplateBase() {
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lChestplate"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKitLeggingsBase() {
		ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lLeggings"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKitBootsBase() {
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lBoots"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKitPickaxeBase() {
		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lPickaxe"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKitSwordBase() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lSword"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKitAxeBase() {
		ItemStack item = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lAxe"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKitShovelBase() {
		ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lShovel"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack CreateKitBowBase() {
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> il = new ArrayList<String>();

		meta.setDisplayName(RPBookGUIUtils.ChatColor("&b&lBow"));
		il.add(RPBookGUIUtils.ChatColor("&7Click to customize."));

		meta.setLore(il);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		item.setItemMeta(meta);
		return item;
	}
}
