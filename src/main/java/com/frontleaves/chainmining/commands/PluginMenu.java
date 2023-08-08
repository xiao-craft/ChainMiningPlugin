package com.frontleaves.chainmining.commands;

import com.frontleaves.chainmining.ChainMining;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * @author 锋楪技术（深圳）有限公司
 */
public class PluginMenu implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if ("fycm".equalsIgnoreCase(command.getName())) {
            if (args.length == 0) {
                sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                sender.sendMessage("§2连锁挖矿 §aChainMining");
                sender.sendMessage("§1作者：§3锋楪技术§8[§9筱锋xiao_lfeng§8]");
                sender.sendMessage("§6使用方法：§e/fycm help");
                sender.sendMessage("§c当前版本：§4v1.2-SNAPSHOT");
                sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
            } else {
                if ("help".equals(args[0])) {
                    if (args.length == 1) {
                        sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                        sender.sendMessage("§6/fycm help info §7--关于操作方法");
                        sender.sendMessage("§6/fycm help operate §7--查看如何使用");
                        sender.sendMessage("§6/fycm help scope §7--切换不同范围");
                        sender.sendMessage("§6/fycm status §7--查看当前状态");
                        sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                    } else {
                        switch (args[1]) {
                            case "info":
                                sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                sender.sendMessage("本插件的使用方法大致分为如下四点：");
                                sender.sendMessage("- 您可以单独使用连锁挖矿和快速砍树，两者可直接打开不会受到影响");
                                sender.sendMessage("- 当您开启全局模式时候其他连锁挖矿、快速砍树和开路模式将会失效");
                                sender.sendMessage("- 当您开启开路模式时候其他连锁挖矿、快速砍树和全局模式将会失效");
                                sender.sendMessage("- 切换范围仅在全局模式适用，开路模式消耗盔甲耐久");
                                sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                break;
                            case "operate":
                                if (args.length == 2) {
                                    sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                    sender.sendMessage("§6/fykg cm on §7--启动连锁挖矿");
                                    sender.sendMessage("§6/fykg cm off §7--关闭连锁挖矿");
                                    sender.sendMessage("§6/fykg cm toggle §7--切换连锁挖矿");
                                    sender.sendMessage("§6/fykg tr on §7--启动快速砍树");
                                    sender.sendMessage("§6/fykg tr off §7--关闭快速砍树");
                                    sender.sendMessage("§6/fykg tr toggle §7--切换快速砍树");
                                    sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                    sender.sendMessage("§31 §8/ §32");
                                } else {
                                    if ("1".equals(args[2])) {
                                        sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                        sender.sendMessage("§6/fykg cm on §7--启动连锁挖矿");
                                        sender.sendMessage("§6/fykg cm off §7--关闭连锁挖矿");
                                        sender.sendMessage("§6/fykg cm toggle §7--切换连锁挖矿");
                                        sender.sendMessage("§6/fykg tr on §7--启动快速砍树");
                                        sender.sendMessage("§6/fykg tr off §7--关闭快速砍树");
                                        sender.sendMessage("§6/fykg tr toggle §7--切换快速砍树");
                                        sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                        sender.sendMessage("§31 §8/ §32");
                                    } else if ("2".equals(args[2])) {
                                        sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                        sender.sendMessage("§6/fykg auto on §7--启动连锁挖矿");
                                        sender.sendMessage("§6/fykg auto off §7--关闭连锁挖矿");
                                        sender.sendMessage("§6/fykg auto toggle §7--切换连锁挖矿");
                                        sender.sendMessage("§6/fykg road on §7--启动快速砍树");
                                        sender.sendMessage("§6/fykg road off §7--关闭快速砍树");
                                        sender.sendMessage("§6/fykg road toggle §7--切换快速砍树");
                                        sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                        sender.sendMessage("§31 §8/ §32");
                                    } else {
                                        sender.sendMessage(ChainMining.prefix + "§c 超出页面");
                                    }
                                }
                                break;
                            case "scope":
                                sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                sender.sendMessage("§6/fycm all  §7--切换快速砍树");
                                sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                                break;
                            default:
                                sender.sendMessage(ChainMining.prefix + "§c 参数错误，输入 /fycm 查看指令帮助");
                                break;
                        }
                    }
                } else if ("status".equals(args[0])) {
                    sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                    sender.sendMessage("§6连锁挖矿：§3" + ChainMining.playerList.get(sender.getName()).get("chainMining"));
                    sender.sendMessage("§6快速砍树：§3" + ChainMining.playerList.get(sender.getName()).get("tree"));
                    sender.sendMessage("§6全局操作：§3" + ChainMining.playerList.get(sender.getName()).get("auto"));
                    sender.sendMessage("§6开路模式：§3" + ChainMining.playerList.get(sender.getName()).get("road"));
                    sender.sendMessage("§7§l§m=]========§2§l 连锁挖矿§a§lChainMining§7§l§m ========[=");
                } else {
                    sender.sendMessage(ChainMining.prefix + "§c 输入 /fycm 查看指令帮助");
                }
            }
        }
        return true;
    }
}
