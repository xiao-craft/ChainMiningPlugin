package com.frontleaves.chainmining.listeners;

import com.frontleaves.chainmining.ChainMining;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

/**
 * @author 锋楪技术（深圳）有限公司
 */
public class PlayerJoinServerListener implements Listener {

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent getPlayer) {
        HashMap<String, Boolean> playerData = new HashMap<>();
        playerData.put("chainMining", true);
        playerData.put("tree", true);
        playerData.put("auto", false);
        playerData.put("road", false);
        ChainMining.playerList.put(getPlayer.getPlayer().getName(), playerData);
    }

    @EventHandler
    public void playerLeaveEvent(PlayerQuitEvent getPlayer) {
        ChainMining.playerList.remove(getPlayer.getPlayer().getName());
    }
}
