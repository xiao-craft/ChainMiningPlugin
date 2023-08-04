package com.frontleaves.chainmining;

import com.frontleaves.chainmining.commands.ChangeToUse;
import com.frontleaves.chainmining.commands.PluginMenu;
import com.frontleaves.chainmining.listeners.CutTreeListener;
import com.frontleaves.chainmining.listeners.MineralsListener;
import com.frontleaves.chainmining.listeners.PlayerJoinServerListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author 锋楪技术（深圳）有限公司
 */
public final class ChainMining extends JavaPlugin {

    public static String prefix = "§8[§bFYCM§8]";

    public static HashMap<String,HashMap<String, Boolean>> playerList = new HashMap<>();

    @Override
    public void onEnable() {
        // 载入插件指令
        Objects.requireNonNull(getCommand("fycm")).setExecutor(new PluginMenu());
        Objects.requireNonNull(getCommand("fykg")).setExecutor(new ChangeToUse());
        // 载入监听器
        getServer().getPluginManager().registerEvents(new PlayerJoinServerListener(), this);
        getServer().getPluginManager().registerEvents(new MineralsListener(), this);
        getServer().getPluginManager().registerEvents(new CutTreeListener(), this);
        // Plugin startup logic
        getLogger().info("插件启动成功");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("插件卸载完毕");
    }
}
