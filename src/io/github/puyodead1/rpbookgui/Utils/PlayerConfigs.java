package io.github.puyodead1.rpbookgui.Utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import io.github.puyodead1.rpbookgui.RPBookGUI;

public class PlayerConfigs {

	private static RPBookGUI rpbg = RPBookGUI.getPlugin;

	public static FileConfiguration getPlayerConfig(UUID uuid) {
		String playerUUID = uuid.toString();
		FileConfiguration config = YamlConfiguration
				.loadConfiguration(new File(rpbg.getDataFolder() + File.separator +  "_playerData", playerUUID + ".yml"));

		return config;
	}
	
	public static File getPlayerConfigFile(UUID uuid) {
		String playerUUID = uuid.toString();
		File file = new File(rpbg.getDataFolder() + File.separator +  "_playerData", playerUUID + ".yml");
		
		return file;
	}

	public static boolean savePlayerConfig(UUID uuid, File playerFile) {
		try {
			getPlayerConfig(uuid).save(playerFile);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean createPlayerConfig(UUID uuid) {
		long started = System.currentTimeMillis();
		String playerUUID = uuid.toString();
		File playerFile = new File(rpbg.getDataFolder() + File.separator +  "_playerData", playerUUID + ".yml");

		if (!playerFile.exists()) {
			try {
				playerFile.createNewFile();
				FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);
				
				playerConfig.set("kits.owned-kits", 0);
				playerConfig.save(playerFile);
				
				Bukkit.getConsoleSender()
						.sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &bCreated player config for &e"
								+ Bukkit.getServer().getPlayer(uuid).getName()) + " (took " + (System.currentTimeMillis() - started) + "ms)");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				Bukkit.getConsoleSender()
				.sendMessage(RPBookGUIUtils.ChatColor("&7[&dRPBookGUI&7] &cFailed to save player config for &e"
						+ Bukkit.getServer().getPlayer(uuid).getName()));
				return false;
			}
		} else {
			return true;
		}
	}
}
