package com.frontleaves.chainmining;

import com.frontleaves.chainmining.commands.ChangeToUse;
import com.frontleaves.chainmining.commands.PluginMenu;
import com.frontleaves.chainmining.listeners.AutoListener;
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

    public static final String PREFIX = "§8[§bFYCM§8]§r";
    public static final String VERSION = "v1.3-SNAPSHOT";

    public static HashMap<String, HashMap<String, HashMap<String, Integer>>> playerList = new HashMap<>();
    public static HashMap<String, HashMap<String, Boolean>> playerData = new HashMap<>();

    @Override
    public void onEnable() {
        // 载入插件指令
        Objects.requireNonNull(getCommand("fycm")).setExecutor(new PluginMenu());
        Objects.requireNonNull(getCommand("fykg")).setExecutor(new ChangeToUse());
        // 载入监听器
        getServer().getPluginManager().registerEvents(new PlayerJoinServerListener(), this);
        getServer().getPluginManager().registerEvents(new MineralsListener(), this);
        getServer().getPluginManager().registerEvents(new CutTreeListener(), this);
        getServer().getPluginManager().registerEvents(new AutoListener(), this);
        // Plugin startup logic
        getLogger().info("插件启动成功");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("插件卸载完毕");
    }
}
