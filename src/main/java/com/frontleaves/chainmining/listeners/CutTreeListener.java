package com.frontleaves.chainmining.listeners;

import com.frontleaves.chainmining.ChainMining;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.jetbrains.annotations.NotNull;

/**
 * @author 锋楪技术（深圳）有限公司
 */
public class CutTreeListener implements Listener {

    private int oakNumber;
    // 本次木头（需要扣除耐久）
    private Material thisBreak;
    // 本次树叶
    private Material thisLeaves;
    // 获取破坏位置
    private Location breakLocation;
    private int relativeDistanceX;
    private int relativeDistanceZ;
    // 最大破坏能力
    private int damage;
    private int maxDamage;
    // 获取玩家手中工具
    private ItemStack playerMainHandTool;

    @EventHandler
    public void oakLog(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.OAK_LOG
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_OAK_LOG) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.OAK_LEAVES;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void birchLog(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.BIRCH_LOG
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_BIRCH_LOG) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.BIRCH_LEAVES;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void jungleLog(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.JUNGLE_LOG
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_JUNGLE_LOG) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.JUNGLE_LEAVES;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void acaciaLog(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.ACACIA_LOG
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_ACACIA_LOG) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.ACACIA_LEAVES;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void darkOrkLog(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.DARK_OAK_LOG
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_DARK_OAK_LOG) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.DARK_OAK_LEAVES;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mangroveLog(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.MANGROVE_LOG
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_MANGROVE_LOG) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.MANGROVE_LEAVES;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void cherryLog(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.CHERRY_LOG
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_CHERRY_LOG) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.CHERRY_LEAVES;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void crimsonStem(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.CRIMSON_STEM
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_CRIMSON_STEM) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.CRIMSON_FUNGUS;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void warpedStem(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.WARPED_STEM
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_WARPED_STEM) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.WARPED_FUNGUS;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void spruceLog(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.SPRUCE_LOG
                            || blockBreakEvent.getBlock().getType() == Material.STRIPPED_SPRUCE_LOG) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        thisLeaves = Material.BIRCH_LEAVES;
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(0, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void oakLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.OAK_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void spruceLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.SPRUCE_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void birchLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.BIRCH_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void jungleLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.JUNGLE_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void acaciaLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.ACACIA_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mangroveLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.MANGROVE_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void azaleaLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.AZALEA_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void cherryLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.CHERRY_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void floweringAzaleaLeaves(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.FLOWERING_AZALEA_LEAVES) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void bambooBlock(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.BAMBOO_BLOCK) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void crimsonFungus(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.CRIMSON_FUNGUS) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void warpedFungus(@NotNull BlockBreakEvent blockBreakEvent) {
        // 检查玩家是否开启
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("tree")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查能否掉落物品
                    if (blockBreakEvent.getBlock().getType() == Material.WARPED_FUNGUS) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        thisLeaves = blockBreakEvent.getBlock().getType();
                        breakLocation = blockBreakEvent.getBlock().getLocation();
                        oakNumber = 0;
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDamage = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        // 进行砍树
                        anyWay(1, blockBreakEvent.getBlock());
                        // 对物品造成破坏
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            if (damage + oakNumber < maxDamage) {
                                getPlayerItem.setDamage(damage + oakNumber);
                                blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                            } else {
                                blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
        }
    }

    private void cutOakAndLeaves(@NotNull Block getBlock) {
        while (getBlock.getType() == thisBreak) {
            if (damage + oakNumber < maxDamage) {
                relativeDistanceX = breakLocation.getBlockX() - getBlock.getLocation().getBlockX();
                relativeDistanceZ = breakLocation.getBlockZ() - getBlock.getLocation().getBlockZ();
                if (relativeDistanceX < 0) {
                    relativeDistanceX = -relativeDistanceX;
                }
                if (relativeDistanceZ < 0) {
                    relativeDistanceZ = -relativeDistanceZ;
                }
                if (relativeDistanceX <= 5 && relativeDistanceZ <= 5) {
                    getBlock.breakNaturally(playerMainHandTool);
                    oakNumber++;
                    anyWay(0, getBlock);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        while (getBlock.getType() == thisLeaves) {
            if (damage + oakNumber < maxDamage) {
                relativeDistanceX = breakLocation.getBlockX() - getBlock.getLocation().getBlockX();
                relativeDistanceZ = breakLocation.getBlockZ() - getBlock.getLocation().getBlockZ();
                if (relativeDistanceX < 0) {
                    relativeDistanceX = -relativeDistanceX;
                }
                if (relativeDistanceZ < 0) {
                    relativeDistanceZ = -relativeDistanceZ;
                }
                if (relativeDistanceX <= 5 && relativeDistanceZ <= 5) {
                    getBlock.breakNaturally(playerMainHandTool);
                    anyWay(0, getBlock);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private void cutLeaves(@NotNull Block getBlock) {
        while (getBlock.getType() == thisLeaves) {
            if (damage + oakNumber < maxDamage) {
                relativeDistanceX = breakLocation.getBlockX() - getBlock.getLocation().getBlockX();
                relativeDistanceZ = breakLocation.getBlockZ() - getBlock.getLocation().getBlockZ();
                if (relativeDistanceX < 0) {
                    relativeDistanceX = -relativeDistanceX;
                }
                if (relativeDistanceZ < 0) {
                    relativeDistanceZ = -relativeDistanceZ;
                }
                if (relativeDistanceX <= 3 && relativeDistanceZ <= 3) {
                    getBlock.breakNaturally(playerMainHandTool);
                    oakNumber++;
                    anyWay(1, getBlock);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private void anyWay(int cutType, Block getBlock) {
        for (BlockFace blockFace : BlockFace.values()) {
            if (cutType == 0 && blockFace == BlockFace.DOWN) {
                continue;
            }
            Block sideBlock = getBlock.getRelative(blockFace);
            if (sideBlock.getType() != Material.AIR) {
                if (cutType == 0) {
                    cutOakAndLeaves(sideBlock);
                } else {
                    cutLeaves(sideBlock);
                }
            }
        }
    }
}
