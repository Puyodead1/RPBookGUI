package io.github.puyodead1.rpbookgui;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.addon.EnchantRarity;
import me.randomhashtags.randompackage.api.CustomEnchants;

public class EnchantConstructor {
	private CustomEnchant customEnchant;
	private EnchantRarity enchantRarity;
	private int enchantLevel;
	private ItemStack revealItem;
	private int success;
	private int destroy;
	
	private static HashMap<String, EnchantConstructor> enchants = new HashMap<String, EnchantConstructor>();
	
	public EnchantConstructor(CustomEnchant customEnchant, EnchantRarity enchantRarity, int enchantLevel, int success, int destroy) {
		this.customEnchant = customEnchant;
		this.enchantRarity = enchantRarity;
		this.enchantLevel = enchantLevel;
		this.revealItem = CustomEnchants.getCustomEnchants().getRevealedItem(customEnchant, enchantLevel, success, destroy, true, true);
		this.success = success;
		this.destroy = destroy;
		
		enchants.put(customEnchant.getIdentifier(), this);
		
		// Bukkit.broadcastMessage("EnchantConstructor added: " + customEnchant.getIdentifier() + " " + enchantLevel);
	}

	public CustomEnchant getCustomEnchant() {
		return customEnchant;
	}

	public void setCustomEnchant(CustomEnchant customEnchant) {
		this.customEnchant = customEnchant;
	}

	public EnchantRarity getEnchantRarity() {
		return enchantRarity;
	}

	public void setEnchantRarity(EnchantRarity enchantRarity) {
		this.enchantRarity = enchantRarity;
	}

	public int getEnchantLevel() {
		return enchantLevel;
	}

	public void setEnchantLevel(int enchantLevel) {
		this.enchantLevel = enchantLevel;
	}
	

	public ItemStack getRevealItem() {
		return revealItem;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getDestroy() {
		return destroy;
	}

	public void setDestroy(int destroy) {
		this.destroy = destroy;
	}

	public static HashMap<String, EnchantConstructor> getEnchants() {
		return enchants;
	}
	
}
