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

import java.util.Objects;

/**
 * @author 锋楪技术（深圳）有限公司
 */

public class MineralsListener implements Listener {

    private static int blockNumber;
    private static int damage;
    private static int maxDurability;
    private static ItemStack playerMainHandTool;
    private static int ExpToDrop;
    // 获取本次破坏的方块
    private Material thisBreak;

    @EventHandler
    public void mineralsCoal(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.COAL_ORE
                            || blockBreakEvent.getBlock().getType() == Material.DEEPSLATE_COAL_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsIron(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.IRON_ORE
                            || blockBreakEvent.getBlock().getType() == Material.DEEPSLATE_IRON_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsLapis(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.LAPIS_ORE
                            || blockBreakEvent.getBlock().getType() == Material.DEEPSLATE_LAPIS_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsCopper(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.COPPER_ORE
                            || blockBreakEvent.getBlock().getType() == Material.DEEPSLATE_COPPER_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsGold(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.GOLD_ORE
                            || blockBreakEvent.getBlock().getType() == Material.DEEPSLATE_GOLD_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsRedStone(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.REDSTONE_ORE
                            || blockBreakEvent.getBlock().getType() == Material.DEEPSLATE_REDSTONE_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsDiamond(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.DIAMOND_ORE
                            || blockBreakEvent.getBlock().getType() == Material.DEEPSLATE_DIAMOND_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsEmerald(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.EMERALD_ORE
                            || blockBreakEvent.getBlock().getType() == Material.DEEPSLATE_EMERALD_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsNetherQuartz(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.NETHER_QUARTZ_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsNetherGold(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.NETHER_GOLD_ORE) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void mineralsAncient(BlockBreakEvent blockBreakEvent) {
        if (ChainMining.playerData.get(blockBreakEvent.getPlayer().getName()).get("chainMining")) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (blockBreakEvent.getPlayer().isSneaking()) {
                    // 检查物品
                    if (blockBreakEvent.getBlock().getType() == Material.ANCIENT_DEBRIS) {
                        // 初始化参数
                        Damageable getPlayerItem = (Damageable) blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                        playerMainHandTool = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
                        thisBreak = blockBreakEvent.getBlock().getType();
                        if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                            maxDurability = blockBreakEvent.getPlayer().getInventory().getItemInMainHand().getType().getMaxDurability();
                            damage = getPlayerItem.getDamage();
                        }
                        ExpToDrop = blockBreakEvent.getExpToDrop();
                        blockNumber = 0;
                        // 检查剩余耐久
                        if (maxDurability - damage > 0) {
                            // 执行操作
                            callbackCorruption(blockBreakEvent.getBlock());
                            // 执行完毕处理完成事务
                            if (getPlayerItem != null && getPlayerItem.hasDamage()) {
                                // 最大耐久检查
                                if (maxDurability - damage - blockNumber <= 0) {
                                    if (blockNumber == 0) {
                                        blockBreakEvent.setCancelled(true);
                                    }
                                    blockBreakEvent.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    blockBreakEvent.getPlayer().playSound(blockBreakEvent.getPlayer().getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                                } else {
                                    getPlayerItem.setDamage(damage + blockNumber);
                                    blockBreakEvent.getPlayer().getInventory().getItemInMainHand().setItemMeta(getPlayerItem);
                                    Location location = blockBreakEvent.getBlock().getLocation();
                                    if (ExpToDrop > 0) {
                                        ExperienceOrb experienceOrb = Objects.requireNonNull(location.getWorld()).spawn(location, ExperienceOrb.class);
                                        experienceOrb.setExperience(ExpToDrop * blockNumber);
                                    }
                                }
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
        while (getBlock.getType() == thisBreak) {
            // 检查耐久是否允许继续执行
            if (maxDurability - damage - blockNumber > 0) {
                // 检查允许的可获得经验内容
                getBlock.breakNaturally(playerMainHandTool);
                blockNumber++;
                callbackCorruption(getBlock);
            } else {
                break;
            }
        }
    }
}
