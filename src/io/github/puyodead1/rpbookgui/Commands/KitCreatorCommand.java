package io.github.puyodead1.rpbookgui.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import io.github.puyodead1.rpbookgui.Inventories;
import io.github.puyodead1.rpbookgui.RPBookGUI;
import io.github.puyodead1.rpbookgui.Utils.RPBookGUIUtils;

public class KitCreatorCommand implements CommandExecutor {

	private RPBookGUI rpbg = RPBookGUI.getPlugin;
	private FileConfiguration rpbgConfig = rpbg.getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission(rpbgConfig.getString("permissions.kitcreator")) || player.isOp() || !rpbgConfig.getBoolean("settings.usepermissions")) {
				player.openInventory(Inventories.KitCreatorKitsInv(player.getUniqueId()));
				return true;
			} else {
				player.sendMessage(RPBookGUIUtils.ChatColor(rpbg.getConfig().getString("messages.no-permission")));
				return false;
			}
		} else {
			sender.sendMessage(RPBookGUIUtils.ChatColor(rpbgConfig.getString("messages.only-players")));
			return false;
		}
	}

}
