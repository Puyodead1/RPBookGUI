package io.github.puyodead1.rpbookgui.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.utils.classes.customenchants.CustomEnchant;
import me.randomhashtags.randompackage.utils.classes.customenchants.EnchantRarity;

public class RarityInfo implements CommandExecutor {

	private FileConfiguration rpbgConfig = RPBookGUI.getPlugin.getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 1) {
				if (player.hasPermission(rpbgConfig.getString("permissions.rarityinfo")) || player.isOp()
						|| !rpbgConfig.getBoolean("settings.use permissions")) {
					String arg = args[0];
					arg = arg.substring(0, 1).toUpperCase() + arg.substring(1, arg.length()).toLowerCase();
					CustomEnchant ce = CustomEnchant.valueOf(arg);
					EnchantRarity rarity = EnchantRarity.valueOf(ce);
					player.sendMessage(rarity != null
							? RPBookGUIUtils
									.ChatColor(rpbgConfig.getString("messages.rarity info").replace("{ENCHANT}", arg)
											.replace("{RARITY}", rarity.getNameColors() + rarity.getName()))
							: RPBookGUIUtils.ChatColor("&c&l(!) Invalid Enchant Name!"));
					return true;
				} else {
					player.sendMessage(RPBookGUIUtils.ChatColor(rpbgConfig.getString("messages.no permission")));
					return false;
				}
			} else
				player.sendMessage(RPBookGUIUtils.ChatColor("&c&l(!) Invalid syntax!"));

			return true;
		} else {
			sender.sendMessage(RPBookGUIUtils.ChatColor(rpbgConfig.getString("messages.only players")));
			return false;
		}
	}

}
