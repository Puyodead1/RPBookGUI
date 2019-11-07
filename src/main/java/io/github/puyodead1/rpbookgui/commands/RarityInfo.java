package io.github.puyodead1.rpbookgui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.utils.RPBookGUIUtils;
import me.randomhashtags.randompackage.addon.CustomEnchant;
import me.randomhashtags.randompackage.addon.EnchantRarity;
import me.randomhashtags.randompackage.util.RPStorage;

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
					CustomEnchant ce = RPStorage.valueOfCustomEnchant(arg, true);
					EnchantRarity rarity = RPStorage.valueOfEnchantRarity(ce);
					player.sendMessage(rarity != null
							? RPBookGUIUtils
									.chatColor(rpbgConfig.getString("messages.rarity info").replace("{ENCHANT}", arg)
											.replace("{RARITY}", rarity.getNameColors() + rarity.getIdentifier()))
							: RPBookGUIUtils.chatColor("&c&l(!) Invalid Enchant Name!"));
					return true;
				} else {
					player.sendMessage(RPBookGUIUtils.chatColor(rpbgConfig.getString("messages.no permission")));
					return false;
				}
			} else
				player.sendMessage(RPBookGUIUtils.chatColor("&c&l(!) Invalid syntax!"));

			return true;
		} else {
			sender.sendMessage(RPBookGUIUtils.chatColor(rpbgConfig.getString("messages.only players")));
			return false;
		}
	}

}
