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
        HashMap<String, HashMap<String, Integer>> typeData = new HashMap<>();
        HashMap<String, Boolean> playerData = new HashMap<>();
        HashMap<String, Integer> infoDataForAuto = new HashMap<>();
        HashMap<String, Integer> infoDataForRoad = new HashMap<>();

        playerData.put("chainMining", true);
        playerData.put("tree", true);
        playerData.put("auto", false);
        playerData.put("road", false);

        infoDataForAuto.put("length", 2);
        infoDataForAuto.put("width", 2);
        infoDataForAuto.put("height", 1);

        infoDataForRoad.put("width", 1);
        infoDataForRoad.put("height", 2);

        typeData.put("typeAuto", infoDataForAuto);
        typeData.put("typeRoad", infoDataForRoad);
        ChainMining.playerData.put(getPlayer.getPlayer().getName(), playerData);
        ChainMining.playerList.put(getPlayer.getPlayer().getName(), typeData);
    }

    @EventHandler
    public void playerLeaveEvent(PlayerQuitEvent getPlayer) {
        ChainMining.playerList.remove(getPlayer.getPlayer().getName());
        ChainMining.playerData.remove(getPlayer.getPlayer().getName());
    }
}
