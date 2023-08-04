package com.frontleaves.chainmining.commands;

import com.frontleaves.chainmining.ChainMining;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * @author 锋楪技术（深圳）有限公司
 */
public class ChangeToUse implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if ("fykg".equalsIgnoreCase(command.getName())) {
            if (args.length != 0) {
                switch (args[0]) {
                    case "cm":
                        switch (args[1]) {
                            case "on":
                                ChainMining.playerList.get(sender.getName()).put("chainMining", true);
                                sender.sendMessage(ChainMining.prefix + "§6 连锁挖矿设置为§2开启");
                                break;
                            case "off":
                                ChainMining.playerList.get(sender.getName()).put("chainMining", false);
                                sender.sendMessage(ChainMining.prefix + "§6 连锁挖矿设置为§c关闭");
                                break;
                            case "toggle":
                                if (ChainMining.playerList.get(sender.getName()).get("chainMining")) {
                                    ChainMining.playerList.get(sender.getName()).put("chainMining", false);
                                    sender.sendMessage(ChainMining.prefix + "§6 连锁挖矿切换为§c关闭");
                                } else {
                                    ChainMining.playerList.get(sender.getName()).put("chainMining", true);
                                    sender.sendMessage(ChainMining.prefix + "§6 连锁挖矿切换为§2开启");
                                }
                                break;
                            default:
                                sender.sendMessage(ChainMining.prefix + "§c 参数错误");
                                break;
                        }
                        break;
                    case "tr":
                        switch (args[1]) {
                            case "on":
                                ChainMining.playerList.get(sender.getName()).put("tree", true);
                                sender.sendMessage(ChainMining.prefix + "§6 快速砍树设置为§2开启");
                                break;
                            case "off":
                                ChainMining.playerList.get(sender.getName()).put("tree", false);
                                sender.sendMessage(ChainMining.prefix + "§6 快速砍树设置为§c关闭");
                                break;
                            case "toggle":
                                if (ChainMining.playerList.get(sender.getName()).get("tree")) {
                                    ChainMining.playerList.get(sender.getName()).put("tree", false);
                                    sender.sendMessage(ChainMining.prefix + "§6 快速砍树切换为§c关闭");
                                } else {
                                    ChainMining.playerList.get(sender.getName()).put("tree", true);
                                    sender.sendMessage(ChainMining.prefix + "§6 快速砍树切换为§2开启");
                                }
                                break;
                            default:
                                sender.sendMessage(ChainMining.prefix + "§c 参数错误");
                                break;
                        }
                        break;
                    default:
                        sender.sendMessage(ChainMining.prefix + "§c 参数不正确");
                        break;
                }
            }
        }
        return true;
    }
}
