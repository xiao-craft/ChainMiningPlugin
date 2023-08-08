package com.frontleaves.chainmining.listeners;

import com.frontleaves.chainmining.ChainMining;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author 锋楪技术（深圳）有限公司
 */
public class AutoListener implements Listener {

    private static Material thisBreak;
    private static int maxDurability;
    private static int damage;
    private static int blockNumber;
    private static ItemStack playerMainHandTool;
    private Location breakLocation;
    // 获取方向配置
    private int getX;
    private int getY;
    private int getZ;
    private int relativeDistanceX;
    private int relativeDistanceY;
    private int relativeDistanceZ;

    @EventHandler
    public void autoBreakBlockEvent(BlockBreakEvent blockBreakEvent) {
        // 检查玩家的操作是否被打开
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("auto")) {
            // 检查玩家的游戏模式
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                // 检查玩家是否蹲下
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查玩家当前是否可以破坏物品
                    ItemStack getPlayerHandItem = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                    Collection<ItemStack> getCollection = blockBreakEvent.getBlock().getDrops(getPlayerHandItem);
                    // 如果凋落物不为空
                    if (!getCollection.isEmpty()) {
                        // 前置准备
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        Damageable getPlayerMindHandItem = (Damageable) playerMainHandTool.getItemMeta();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        blockNumber = 0;
                        int expToDrop = blockBreakEvent.getExpToDrop();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        HashMap<String, Integer> getAutoMap = ChainMining.playerList.get(blockBreakEvent.getPlayer().getName()).get("typeAuto");
                        getX = getAutoMap.get("length");
                        getY = getAutoMap.get("height");
                        getZ = getAutoMap.get("width");
                        // 检查玩家手中物品有无耐久
                        if (getPlayerMindHandItem != null && getPlayerMindHandItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerMindHandItem.getDamage();
                        }
                        // 执行破坏操作
                        directionOfOperation(blockBreakEvent.getBlock());
                        // 后置操作
                        if (getPlayerMindHandItem != null && getPlayerMindHandItem.hasDamage()) {
                            // 最大耐久检查
                            if (maxDurability - damage - blockNumber <= 0) {
                                if (blockNumber == 0) {
                                    blockBreakEvent.setCancelled(true);
                                }
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            } else {
                                getPlayerMindHandItem.setDamage(damage + blockNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerMindHandItem);
                                Location location = blockBreakEvent.getBlock().getLocation();
                                if (expToDrop > 0) {
                                    ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                    experienceOrb.setExperience(expToDrop * blockNumber);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void directionOfOperation(Block getBlock) {
        for (BlockFace blockFace : BlockFace.values()) {
            Block blocker = getBlock.getRelative(blockFace);
            repetitiveStatement(blocker);
        }
    }

    private void repetitiveStatement(@NotNull Block getBlock) {
        while (getBlock.getType() == thisBreak) {
            if (maxDurability - damage - blockNumber > 0) {
                relativeDistanceX = Math.abs(breakLocation.getBlockX() - getBlock.getLocation().getBlockX());
                relativeDistanceY = Math.abs(breakLocation.getBlockY() - getBlock.getLocation().getBlockY());
                relativeDistanceZ = Math.abs(breakLocation.getBlockZ() - getBlock.getLocation().getBlockZ());
                // 具体执行操作
                if (relativeDistanceX <= getX && relativeDistanceY <= getY && relativeDistanceZ <= getZ) {
                    getBlock.breakNaturally(playerMainHandTool);
                    blockNumber++;
                    directionOfOperation(getBlock);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
}
