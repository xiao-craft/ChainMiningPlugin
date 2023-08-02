package com.frontleaves.chainmining;

import com.frontleaves.chainmining.commands.PluginMenu;
import com.frontleaves.chainmining.listeners.MineralsListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author 锋楪技术（深圳）有限公司
 */
public final class ChainMining extends JavaPlugin {

    @Override
    public void onEnable() {
        // 载入插件指令
        getCommand("fycm").setExecutor(new PluginMenu(this));
        // 载入监听器
        getServer().getPluginManager().registerEvents(new MineralsListener(), this);
        // Plugin startup logic
        getLogger().info("插件启动成功");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("插件卸载完毕");
    }
}
