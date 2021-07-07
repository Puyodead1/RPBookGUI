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

import me.randomhashtags.randompackage.RandomPackage;
import me.randomhashtags.randompackage.RandomPackageAPI;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.puyodead1.rpbookgui.utils.ItemBuilder;
import io.github.puyodead1.rpbookgui.utils.ItemStackUtils;
import io.github.puyodead1.rpbookgui.utils.RPBookGUIUtils;
import io.github.puyodead1.rpbookgui.utils.UMaterial;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.addon.EnchantRarity;
import me.randomhashtags.randompackage.api.CustomEnchants;
import me.randomhashtags.randompackage.util.RPStorage;

public class Inventories extends RPBookGUIUtils {

	/**
	 * Main Inventory
	 * @return inventory
	 */
	public static Inventory mainInventory() {
		Inventory inv = Bukkit.createInventory(null,
				toNineDenom(rarities.size()),
				"Enchantment Categories");
		int currentIndex = 0;
		for(final EnchantRarity rarity : rarities.values()) {
			if(currentIndex <= rarities.size()) {
				inv.setItem(currentIndex, new ItemBuilder(UMaterial.match("BOOK").getItemStack()).setName(rarity.getNameColors() + rarity.getIdentifier() + " Enchants").addLoreLine(RPBookGUIUtils.chatColor("&7Click to view " + rarity.getNameColors() + rarity.getIdentifier() + "&r&7 Enchantments")).toItemStack());
				currentIndex++;
			} else {
				break;
			}
		}
		return inv;
	}

	/**
	 * Enchants for a specific Rarity
	 * @param rarity
	 * @return inventory
	 */
	public static Inventory rarityInventory(EnchantRarity rarity) {
		Inventory inv = Bukkit.createInventory(null,
				toNineDenom(rarity.getEnchants().size() + 1),
				chatColor(
						rarity.getNameColors() + rarity.getIdentifier()));
		
		for(int i = 0; i < rarity.getEnchants().size(); i++) {
			final CustomEnchant ce = rarity.getEnchants().get(i);
			if(!ce.isEnabled()) continue;
			inv.addItem(ItemStackUtils.enchantBook(rarity, ce).clone());
		}
		inv.setItem(inv.getSize() - 1, ItemStackUtils.back().clone());
		return inv;
	}

	/**
	 * Inventory for enchant levels
	 * @param ce
	 * @return inventory
	 */
	public static Inventory enchantInventory(CustomEnchant ce) {
		EnchantRarity rarity = RandomPackageAPI.INSTANCE.valueOfCustomEnchantRarity(ce);
		Inventory inv = Bukkit.createInventory(null, RPBookGUIUtils.toNineDenom(ce.getMaxLevel() + 1),
				rarity.getNameColors() + ce.getName());
		int x = 0;
		for (int i = 1; i < ce.getMaxLevel() + 1; i++) {
			ItemStack is = CustomEnchants.getCustomEnchants()
					.getRevealedItem(ce, i, 100, 0, true, true).clone();
			new EnchantConstructor(ce, rarity, i, 0, 0);
			inv.setItem(x, is);
			x++;
		}
		inv.setItem(inv.getSize() - 1, ItemStackUtils.back().clone());
		return inv;
	}

	/**
	 * Inventory for editing settings
	 * @return inventory
	 */
	public static Inventory settingsInventory() {
		Inventory inv = Bukkit.createInventory(null, 36, "RPBookGUI Settings");

		for (int i = 0; i < 10; i++)
			inv.setItem(i, ItemStackUtils.glassSeperator().clone());
		inv.setItem(10, ItemStackUtils.glassSeperator2().clone());
		inv.setItem(11, ItemStackUtils.keepMenuOpenSetting().clone());
		inv.setItem(12, ItemStackUtils.glassSeperator2().clone());

		inv.setItem(13, ItemStackUtils.glassSeperator3().clone());

		inv.setItem(14, ItemStackUtils.glassSeperator2().clone());
		inv.setItem(15, ItemStackUtils.usePermissionsSetting().clone());
		inv.setItem(16, ItemStackUtils.glassSeperator2().clone());

		inv.setItem(17, ItemStackUtils.glassSeperator().clone());
		inv.setItem(18, ItemStackUtils.glassSeperator().clone());
		for (int i = 26; i < 36; i++)
			inv.setItem(i, ItemStackUtils.glassSeperator().clone());
		inv.setItem(22, ItemStackUtils.back().clone());
		return inv;
	}

	/**
	 * Inventory for editing success and destroy of an enchant book
	 * @param ce
	 * @return inventory
	 */
	public static Inventory successAndDestroyInventory(CustomEnchant ce) {
		Inventory inv = Bukkit.createInventory(null, 45,
				"Success & Destroy Configuration");
		// slot 10-12 - increase success
		// slot 14-16 - increase destroy
		// slot 28-30 - decrease success
		// slot 32-34 - decrease destroy
		// slot 22 - book

		// Success controls
		ItemStack as1 = new ItemBuilder(
				UMaterial.match("GREEN_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&a+1 Success"))
						.toItemStack();
		ItemStack rs1 = new ItemBuilder(
				UMaterial.match("RED_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&c-1 Success"))
						.toItemStack();
		ItemStack as5 = new ItemBuilder(
				UMaterial.match("GREEN_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&a+5 Success"))
						.toItemStack();
		ItemStack rs5 = new ItemBuilder(
				UMaterial.match("RED_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&c-5 Success"))
						.toItemStack();
		ItemStack as10 = new ItemBuilder(
				UMaterial.match("GREEN_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&a+10 Success"))
						.toItemStack();
		ItemStack rs10 = new ItemBuilder(
				UMaterial.match("RED_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&c-10 Success"))
						.toItemStack();

		// Destroy controls
		ItemStack ad1 = new ItemBuilder(
				UMaterial.match("GREEN_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&a+1 Destroy"))
						.toItemStack();
		ItemStack rd1 = new ItemBuilder(
				UMaterial.match("RED_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&c-1 Destroy"))
						.toItemStack();
		ItemStack ad5 = new ItemBuilder(
				UMaterial.match("GREEN_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&a+5 Destroy"))
						.toItemStack();
		ItemStack rd5 = new ItemBuilder(
				UMaterial.match("RED_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&c-5 Destroy"))
						.toItemStack();
		ItemStack ad10 = new ItemBuilder(
				UMaterial.match("GREEN_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&a+10 Destroy"))
						.toItemStack();
		ItemStack rd10 = new ItemBuilder(
				UMaterial.match("RED_WOOL").getItemStack())
						.setName(RPBookGUIUtils.chatColor("&c-10 Destroy"))
						.toItemStack();

		inv.setItem(10, as1);
		inv.setItem(11, as5);
		inv.setItem(12, as10);

		inv.setItem(14, ad10);
		inv.setItem(15, ad5);
		inv.setItem(16, ad1);

		inv.setItem(22,
				CustomEnchants.getCustomEnchants()
						.getRevealedItem(ce, EnchantConstructor.getEnchants()
								.get(ce.getIdentifier()).getEnchantLevel(), 0,
								0, true, true));

		inv.setItem(28, rs1);
		inv.setItem(29, rs5);
		inv.setItem(30, rs10);

		inv.setItem(32, rd10);
		inv.setItem(33, rd5);
		inv.setItem(34, rd1);

		return inv;
	}
}
