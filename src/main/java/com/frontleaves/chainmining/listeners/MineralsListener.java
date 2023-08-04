package com.frontleaves.chainmining.listeners;

import com.frontleaves.chainmining.ChainMining;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * @author 锋楪技术（深圳）有限公司
 */

public class MineralsListener implements Listener {

    private static int blockNumber;
    private static int expToGive;
    private static int damage;
    private static int maxDurability;


    @EventHandler
    public void minerals(BlockBreakEvent breakEvent) {
        if (ChainMining.playerList.get(breakEvent.getPlayer().getName()).get("chainMining")) {
            if (breakEvent.getPlayer().isSneaking()) {
                // 检测这个方块能否掉落
                if (breakEvent.isDropItems()) {
                    Block getBlock = breakEvent.getBlock();
                    if (getBlock.getType() == Material.COAL_ORE || getBlock.getType() == Material.DEEPSLATE_COAL_ORE
                            || getBlock.getType() == Material.LAPIS_ORE || getBlock.getType() == Material.DEEPSLATE_LAPIS_ORE
                            || getBlock.getType() == Material.COPPER_ORE || getBlock.getType() == Material.DEEPSLATE_COPPER_ORE
                            || getBlock.getType() == Material.IRON_ORE || getBlock.getType() == Material.DEEPSLATE_IRON_ORE
                            || getBlock.getType() == Material.GOLD_ORE || getBlock.getType() == Material.DEEPSLATE_GOLD_ORE
                            || getBlock.getType() == Material.DIAMOND_ORE || getBlock.getType() == Material.DEEPSLATE_DIAMOND_ORE
                            || getBlock.getType() == Material.REDSTONE_ORE || getBlock.getType() == Material.DEEPSLATE_REDSTONE_ORE
                            || getBlock.getType() == Material.EMERALD_ORE || getBlock.getType() == Material.DEEPSLATE_EMERALD_ORE
                            || getBlock.getType() == Material.NETHER_GOLD_ORE
                            || getBlock.getType() == Material.NETHER_QUARTZ_ORE
                            || getBlock.getType() == Material.ANCIENT_DEBRIS) {
                        if (breakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                            // 预备事务
                            Player getPlayer = breakEvent.getPlayer(); // 获取破坏方块的玩家
                            Damageable getPlayerDamageable = (Damageable) breakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                            maxDurability = getPlayer.getInventory().getItemInMainHand().getType().getMaxDurability();
                            if (getPlayerDamageable != null && getPlayerDamageable.hasDamage()) {
                                // 最大耐久检查
                                damage = getPlayerDamageable.getDamage();
                            }
                            blockNumber = 0;
                            expToGive = 0;
                            if (maxDurability - damage > 0) {
                                // 执行操作
                                callbackCorruption(breakEvent.getBlock());
                                // 执行完毕处理完成事务
                                if (getPlayerDamageable != null && getPlayerDamageable.hasDamage()) {
                                    // 最大耐久检查
                                    if (maxDurability - damage - blockNumber <= 0) {
                                        if (blockNumber == 0) {
                                            breakEvent.setCancelled(true);
                                        }
                                        getPlayer.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                        getPlayer.playSound(getPlayer.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                    } else {
                                        getPlayerDamageable.setDamage(damage + blockNumber);
                                        getPlayer.getInventory().getItemInMainHand().setItemMeta(getPlayerDamageable);
                                    }
                                }
                                getPlayer.giveExp(expToGive);
                            }
                        }
                    }
                }
            }
        }
    }

    private void callbackCorruption(@NotNull Block block) {
        for (BlockFace blockFace : BlockFace.values()) {
            Block blocker = block.getRelative(blockFace);
            repetitiveStatement(blocker);
        }
    }

    private void repetitiveStatement(@NotNull Block getBlock) {
        while (getBlock.getType() == Material.COAL_ORE || getBlock.getType() == Material.DEEPSLATE_COAL_ORE
                || getBlock.getType() == Material.LAPIS_ORE || getBlock.getType() == Material.DEEPSLATE_LAPIS_ORE
                || getBlock.getType() == Material.COPPER_ORE || getBlock.getType() == Material.DEEPSLATE_COPPER_ORE
                || getBlock.getType() == Material.IRON_ORE || getBlock.getType() == Material.DEEPSLATE_IRON_ORE
                || getBlock.getType() == Material.GOLD_ORE || getBlock.getType() == Material.DEEPSLATE_GOLD_ORE
                || getBlock.getType() == Material.DIAMOND_ORE || getBlock.getType() == Material.DEEPSLATE_DIAMOND_ORE
                || getBlock.getType() == Material.REDSTONE_ORE || getBlock.getType() == Material.DEEPSLATE_REDSTONE_ORE
                || getBlock.getType() == Material.EMERALD_ORE || getBlock.getType() == Material.DEEPSLATE_EMERALD_ORE
                || getBlock.getType() == Material.NETHER_GOLD_ORE
                || getBlock.getType() == Material.NETHER_QUARTZ_ORE
                || getBlock.getType() == Material.ANCIENT_DEBRIS) {
            // 检查耐久是否允许继续执行
            if (maxDurability - damage - blockNumber > 0) {
                // 检查允许的可获得经验内容
                Random random = new Random();
                if (getBlock.getType() == Material.COAL_ORE || getBlock.getType() == Material.DEEPSLATE_COAL_ORE) {
                    expToGive += random.nextInt(2);
                } else if (getBlock.getType() == Material.LAPIS_ORE || getBlock.getType() == Material.DEEPSLATE_LAPIS_ORE) {
                    expToGive += random.nextInt(3) + 2;
                } else if (getBlock.getType() == Material.REDSTONE_ORE || getBlock.getType() == Material.DEEPSLATE_REDSTONE_ORE) {
                    expToGive += random.nextInt(4) + 1;
                } else if (getBlock.getType() == Material.EMERALD_ORE || getBlock.getType() == Material.DEEPSLATE_EMERALD_ORE
                        || getBlock.getType() == Material.DIAMOND_ORE || getBlock.getType() == Material.DEEPSLATE_DIAMOND_ORE) {
                    expToGive += random.nextInt(5) + 3;
                } else if (getBlock.getType() == Material.NETHER_GOLD_ORE) {
                    expToGive += random.nextInt(2);
                } else if (getBlock.getType() == Material.NETHER_QUARTZ_ORE) {
                    expToGive += random.nextInt(5) + 2;
                }
                getBlock.breakNaturally();
                blockNumber++;
                callbackCorruption(getBlock);
            } else {
                break;
            }
        }
    }
}
