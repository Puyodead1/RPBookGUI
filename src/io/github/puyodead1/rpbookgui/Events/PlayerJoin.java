package io.github.puyodead1.rpbookgui.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import io.github.puyodead1.rpbookgui.Utils.PlayerConfigs;

public class PlayerJoin implements Listener {

	@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent e) {
		Player player = (Player) e.getPlayer();
		PlayerConfigs.createPlayerConfig(player.getUniqueId());
	}
}
