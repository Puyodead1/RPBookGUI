package io.github.puyodead1.rpbookgui.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.FireworkEffect;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.ItemStack;

import me.randomhashtags.randompackage.RandomPackageAPI;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.addon.EnchantRarity;

public class FileEnchantRarity extends RPBookGUIUtils implements EnchantRarity {
	protected static RandomPackageAPI api = RandomPackageAPI.api;
	private File folder;
	private List<String> revealedEnchantMsg, loreFormat;
	private ItemStack revealItem, revealedItem;
	private Firework firework;
	protected List<CustomEnchant> enchants;
	protected YamlConfiguration yml;

	public FileEnchantRarity(File folder, File f) {
		this.folder = folder;
		this.yml = YamlConfiguration.loadConfiguration(f);
		enchants = new ArrayList<>();
		addEnchantRarity(this);
	}

	public String getIdentifier() {
		return folder.getName();
	}

	public String[] getRevealedEnchantRarities() {
		return yml.getString("reveals enchant rarities").split(";");
	}

	public List<String> getRevealedEnchantMsg() {
		if (revealedEnchantMsg == null)
			revealedEnchantMsg = api.colorizeListString(yml.getStringList("reveal enchant msg"));
		return revealedEnchantMsg;
	}

	public ItemStack getRevealItem() {
		if (revealItem == null)
			revealItem = api.d(yml, "reveal item");
		return getClone(revealItem, null);
	}

	public ItemStack getRevealedItem() {
		if (revealedItem == null)
			revealedItem = api.d(yml, "revealed item");
		return getClone(revealedItem, null);
	}

	public String getNameColors() {
		return ChatColor.translateAlternateColorCodes('&', yml.getString("revealed item.name colors"));
	}

	public String getApplyColors() {
		return ChatColor.translateAlternateColorCodes('&', yml.getString("revealed item.apply colors"));
	}

	public boolean percentsAddUpto100() {
		return yml.getBoolean("settings.success+destroy=100");
	}

	public String getSuccess() {
		return ChatColor.translateAlternateColorCodes('&', yml.getString("settings.success"));
	}

	public String getDestroy() {
		return ChatColor.translateAlternateColorCodes('&', yml.getString("settings.destroy"));
	}

	public List<String> getLoreFormat() {
		if (loreFormat == null)
			loreFormat = api.colorizeListString(yml.getStringList("settings.lore format"));
		return loreFormat;
	}

	public int getSuccessSlot() {
		return getLoreFormat().indexOf("{SUCCESS}");
	}

	public int getDestroySlot() {
		return getLoreFormat().indexOf("{DESTROY}");
	}

	public Firework getFirework() {
		if (firework == null) {
			final String[] a = yml.getString("revealed item.firework").split(":");
			firework = api.createFirework(FireworkEffect.Type.valueOf(a[0].toUpperCase()), api.getColor(a[1]),
					api.getColor(a[2]), Integer.parseInt(a[3]));
		}
		return firework;
	}

	public List<CustomEnchant> getEnchants() {
		return enchants;
	}
}
