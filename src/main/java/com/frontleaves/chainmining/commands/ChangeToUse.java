package com.frontleaves.chainmining.commands;

import com.frontleaves.chainmining.ChainMining;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 锋楪技术（深圳）有限公司
 */
public class ChangeToUse implements CommandExecutor, TabExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if ("fykg".equalsIgnoreCase(command.getName())) {
            if (args.length != 0) {
                switch (args[0]) {
                    case "cm":
                        switch (args[1]) {
                            case "on":
                                ChainMining.playerData.get(sender.getName()).put("chainMining", true);
                                ChainMining.playerData.get(sender.getName()).put("auto", false);
                                ChainMining.playerData.get(sender.getName()).put("road", false);
                                sender.sendMessage(ChainMining.PREFIX + "§6 连锁挖矿设置为§2开启");
                                break;
                            case "off":
                                ChainMining.playerData.get(sender.getName()).put("chainMining", false);
                                ChainMining.playerData.get(sender.getName()).put("auto", false);
                                ChainMining.playerData.get(sender.getName()).put("road", false);
                                sender.sendMessage(ChainMining.PREFIX + "§6 连锁挖矿设置为§c关闭");
                                break;
                            case "toggle":
                                if (ChainMining.playerData.get(sender.getName()).get("chainMining")) {
                                    ChainMining.playerData.get(sender.getName()).put("chainMining", false);
                                    ChainMining.playerData.get(sender.getName()).put("auto", false);
                                    ChainMining.playerData.get(sender.getName()).put("road", false);
                                    sender.sendMessage(ChainMining.PREFIX + "§6 连锁挖矿切换为§c关闭");
                                } else {
                                    ChainMining.playerData.get(sender.getName()).put("chainMining", true);
                                    ChainMining.playerData.get(sender.getName()).put("auto", false);
                                    ChainMining.playerData.get(sender.getName()).put("road", false);
                                    sender.sendMessage(ChainMining.PREFIX + "§6 连锁挖矿切换为§2开启");
                                }
                                break;
                            default:
                                sender.sendMessage(ChainMining.PREFIX + "§c 参数错误");
                                break;
                        }
                        break;
                    case "tr":
                        switch (args[1]) {
                            case "on":
                                ChainMining.playerData.get(sender.getName()).put("tree", true);
                                ChainMining.playerData.get(sender.getName()).put("auto", false);
                                ChainMining.playerData.get(sender.getName()).put("road", false);
                                sender.sendMessage(ChainMining.PREFIX + "§6 快速砍树设置为§2开启");
                                break;
                            case "off":
                                ChainMining.playerData.get(sender.getName()).put("tree", false);
                                ChainMining.playerData.get(sender.getName()).put("auto", false);
                                ChainMining.playerData.get(sender.getName()).put("road", false);
                                sender.sendMessage(ChainMining.PREFIX + "§6 快速砍树设置为§c关闭");
                                break;
                            case "toggle":
                                if (ChainMining.playerData.get(sender.getName()).get("tree")) {
                                    ChainMining.playerData.get(sender.getName()).put("tree", false);
                                    ChainMining.playerData.get(sender.getName()).put("auto", false);
                                    ChainMining.playerData.get(sender.getName()).put("road", false);
                                    sender.sendMessage(ChainMining.PREFIX + "§6 快速砍树切换为§c关闭");
                                } else {
                                    ChainMining.playerData.get(sender.getName()).put("tree", true);
                                    ChainMining.playerData.get(sender.getName()).put("auto", false);
                                    ChainMining.playerData.get(sender.getName()).put("road", false);
                                    sender.sendMessage(ChainMining.PREFIX + "§6 快速砍树切换为§2开启");
                                }
                                break;
                            default:
                                sender.sendMessage(ChainMining.PREFIX + "§c 参数错误");
                                break;
                        }
                        break;
                    case "auto":
                    case "set":
                        // 执行操作
                        ChainMining.playerData.get(sender.getName()).put("auto", true);
                        ChainMining.playerData.get(sender.getName()).put("tree", false);
                        ChainMining.playerData.get(sender.getName()).put("chainMining", false);
                        ChainMining.playerData.get(sender.getName()).put("road", false);
                        // 设置范围
                        if ("auto".equals(args[0])) {
                            ChainMining.playerList.get(sender.getName()).get("typeAuto").put("length", 2);
                            ChainMining.playerList.get(sender.getName()).get("typeAuto").put("width", 2);
                            ChainMining.playerList.get(sender.getName()).get("typeAuto").put("height", 1);
                            sender.sendMessage(ChainMining.PREFIX + "§6 快速破坏已开启§e(其他破坏方式已关闭)");
                        } else {
                            boolean returnInfo = false;
                            if (!args[1].isEmpty() && Integer.parseInt(args[1]) >= 1 && Integer.parseInt(args[1]) <= 5) {
                                ChainMining.playerList.get(sender.getName()).get("typeAuto").put("length", Integer.valueOf(args[1]));
                            } else {
                                ChainMining.playerList.get(sender.getName()).get("typeAuto").put("length", 1);
                                returnInfo = true;
                            }
                            if (!args[2].isEmpty() && Integer.parseInt(args[2]) >= 1 && Integer.parseInt(args[2]) <= 5) {
                                ChainMining.playerList.get(sender.getName()).get("typeAuto").put("height", Integer.valueOf(args[1]));
                            } else {
                                ChainMining.playerList.get(sender.getName()).get("typeAuto").put("height", 1);
                                returnInfo = true;
                            }
                            if (!args[3].isEmpty() && Integer.parseInt(args[3]) >= 1 && Integer.parseInt(args[3]) <= 5) {
                                ChainMining.playerList.get(sender.getName()).get("typeAuto").put("width", Integer.valueOf(args[1]));
                            } else {
                                ChainMining.playerList.get(sender.getName()).get("typeAuto").put("width", 1);
                                returnInfo = true;
                            }
                            sender.sendMessage(ChainMining.PREFIX + "§6 自定义快速破坏已开启§e(其他破坏方式已关闭)");
                            if (returnInfo) {
                                sender.sendMessage(ChainMining.PREFIX + "§c 未补全或值小于 1 部分已默认设置为 1 ，最大不可超过 5");
                            }
                        }
                        break;
                    case "road":
                        // 执行操作
                        ChainMining.playerData.get(sender.getName()).put("road", true);
                        ChainMining.playerData.get(sender.getName()).put("auto", false);
                        ChainMining.playerData.get(sender.getName()).put("tree", false);
                        ChainMining.playerData.get(sender.getName()).put("chainMining", false);
                        sender.sendMessage(ChainMining.PREFIX + "§6 道路模式已开启§e(其他破坏方式已关闭)");
                        break;
                    default:
                        sender.sendMessage(ChainMining.PREFIX + "§c 参数不正确");
                        break;
                }
            }
        }
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1) {
            tab.add("cm");
            tab.add("tr");
            tab.add("auto");
            tab.add("road");
            tab.add("set");
        } else if (args.length == 2 && ("cm".equals(args[0]) || "tr".equals(args[0]))) {
            tab.add("on");
            tab.add("off");
            tab.add("toggle");
        } else if (args.length == 2 && "set".equals(args[0])) {
            tab.add("x");
        } else if (args.length == 3 && "set".equals(args[0])) {
            tab.add("y");
        } else if (args.length == 4 && "set".equals(args[0])) {
            tab.add("z");
        }
        return tab;
    }
}
