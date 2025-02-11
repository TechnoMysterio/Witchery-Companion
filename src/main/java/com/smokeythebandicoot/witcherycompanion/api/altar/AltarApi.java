package com.smokeythebandicoot.witcherycompanion.api.altar;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.msrandom.witchery.init.WitcheryBlocks;
import net.msrandom.witchery.init.WitcheryWoodTypes;

import java.util.*;

public class AltarApi {

    // Main logic for Power Sources
    public static HashMap<IBlockState, AltarPowerSource> validStates = initStateList();
    public static HashMap<Block, AltarPowerSource> validBlocks = initBlockList();


    private static HashMap<Block, AltarPowerSource> initBlockList() {
        HashMap<Block, AltarPowerSource> blocks = new HashMap<>();

        blocks.put(Blocks.GRASS, new AltarPowerSource(2, 80));
        blocks.put(Blocks.DIRT, new AltarPowerSource(1, 80));
        blocks.put(Blocks.FARMLAND, new AltarPowerSource(1, 100));
        blocks.put(Blocks.TALLGRASS, new AltarPowerSource(3, 50));
        blocks.put(Blocks.YELLOW_FLOWER, new AltarPowerSource(4, 30));
        blocks.put(Blocks.RED_FLOWER, new AltarPowerSource(4, 30));
        blocks.put(Blocks.WHEAT, new AltarPowerSource(4, 20));
        blocks.put(Blocks.WATER, new AltarPowerSource(1, 50));
        blocks.put(Blocks.RED_MUSHROOM, new AltarPowerSource(3, 20));
        blocks.put(Blocks.BROWN_MUSHROOM, new AltarPowerSource(3, 20));
        blocks.put(Blocks.CACTUS, new AltarPowerSource(3, 50));
        blocks.put(Blocks.REEDS, new AltarPowerSource(3, 50));
        blocks.put(Blocks.PUMPKIN, new AltarPowerSource(4, 20));
        blocks.put(Blocks.PUMPKIN_STEM, new AltarPowerSource(3, 20));
        blocks.put(Blocks.BROWN_MUSHROOM_BLOCK, new AltarPowerSource(3, 20));
        blocks.put(Blocks.RED_MUSHROOM_BLOCK, new AltarPowerSource(3, 20));
        blocks.put(Blocks.MELON_BLOCK, new AltarPowerSource(4, 20));
        blocks.put(Blocks.MELON_STEM, new AltarPowerSource(3, 20));
        blocks.put(Blocks.VINE, new AltarPowerSource(2, 50));
        blocks.put(Blocks.MYCELIUM, new AltarPowerSource(1, 80));
        blocks.put(Blocks.COCOA, new AltarPowerSource(3, 20));
        blocks.put(Blocks.CARROTS, new AltarPowerSource(4, 20));
        blocks.put(Blocks.POTATOES, new AltarPowerSource(4, 20));
        blocks.put(Blocks.DRAGON_EGG, new AltarPowerSource(250, 1));
        blocks.put(WitcheryBlocks.DEMON_HEART, new AltarPowerSource(40, 2));
        blocks.put(WitcheryBlocks.BELLADONNA_SEEDS, new AltarPowerSource(4, 20));
        blocks.put(WitcheryBlocks.MANDRAKE_SEEDS, new AltarPowerSource(4, 20));
        blocks.put(WitcheryBlocks.ARTICHOKE_SEEDS, new AltarPowerSource(4, 20));
        blocks.put(WitcheryBlocks.SNOWBELL_SEEDS, new AltarPowerSource(4, 20));
        blocks.put(WitcheryBlocks.SPANISH_MOSS, new AltarPowerSource(3, 20));
        blocks.put(WitcheryBlocks.GLINT_WEED, new AltarPowerSource(2, 20));
        blocks.put(WitcheryBlocks.EMPTY_CRITTER_SNARE, new AltarPowerSource(2, 10));
        blocks.put(WitcheryBlocks.BLOOD_POPPY, new AltarPowerSource(2, 10));
        blocks.put(WitcheryBlocks.GRASSPER, new AltarPowerSource(2, 10));
        blocks.put(WitcheryBlocks.WISPY_COTTON, new AltarPowerSource(3, 20));
        blocks.put(WitcheryBlocks.INFINITY_EGG, new AltarPowerSource(1000, 1));
        blocks.put(WitcheryBlocks.EMBER_MOSS, new AltarPowerSource(4, 20));
        blocks.put(WitcheryWoodTypes.ROWAN.getLeaves(), new AltarPowerSource(4, 50));
        blocks.put(WitcheryWoodTypes.ALDER.getLeaves(), new AltarPowerSource(4, 50));
        blocks.put(WitcheryWoodTypes.HAWTHORN.getLeaves(), new AltarPowerSource(4, 50));
        blocks.put(WitcheryWoodTypes.ROWAN.getLog(), new AltarPowerSource(3, 100));
        blocks.put(WitcheryWoodTypes.ALDER.getLog(), new AltarPowerSource(3, 100));
        blocks.put(WitcheryWoodTypes.HAWTHORN.getLog(), new AltarPowerSource(3, 100));

        return blocks;

    }

    private static HashMap<IBlockState, AltarPowerSource> initStateList() {
        return new HashMap<>();
    }


    /** Registers a new Block as a valid block that recharges Altar */
    public static void registerBlock(Block block, int factor, int limit) {
        validBlocks.put(block, new AltarPowerSource(factor, limit));
    }

    /** Registers a new Blockstate as a valid block that recharges Altar */
    public static void registerBlockstate(IBlockState state, int factor, int limit) {
        validStates.put(state, new AltarPowerSource(factor, limit));
    }

    /** Registers a new Class as a valid block that recharges Altar */
    public static void registerClass(Class<?> clazz, int factor, int limit) {
        for (Block block : ForgeRegistries.BLOCKS.getValuesCollection()) {
            if (block.getClass() == clazz) {
                validBlocks.put(block, new AltarPowerSource(factor, limit));
            }
        }
    }


    /** Un-registers a new Block as a valid block that recharges Altar */
    public static void removeBlock(Block block) {
        validBlocks.remove(block);
    }

    /** Un-registers a new Blockstate as a valid block that recharged Altar */
    public static void removeBlockstate(IBlockState state) {
        validStates.remove(state);
    }

    /** Un-registers a Class as a valid block that recharged Altar */
    public static void removeClass(Class<?> clazz) {
        List<Block> toRemove = new ArrayList<>();
        for (Block block : validBlocks.keySet()) {
            if (block.getClass() == clazz) {
                toRemove.add(block);
            }
        }

        for (Block block : toRemove) {
            validBlocks.remove(block);
        }
    }


    /** Returns true if the block can recharge Bark Belt */
    public static boolean canRechargeAltar(Block block) {
        return validBlocks.containsKey(block);
    }

    /** Returns true if the blockstate can recharge Bark Belt */
    public static boolean canRechargeAltar(IBlockState state) {
        return validBlocks.containsKey(state.getBlock()) || validStates.containsKey(state);
    }

    /** Returns the AltarPowerSource of the block. If the block can't recharge the Altar, returns null */
    public static AltarPowerSource getPowerSource(Block block) {
        if (validBlocks.containsKey(block)) return validBlocks.get(block);
        return null;
    }

    /** Returns the AltarPowerSource of the blockstate. If the blockstate can't recharge the Altar, returns null */
    public static AltarPowerSource getPowerSource(IBlockState state) {
        if (validStates.containsKey(state)) return validStates.get(state);
        return getPowerSource(state.getBlock());
    }

    /** Returns a Set of Sets of blockstates that can recharge the Altar */
    public static Set<Set<IBlockState>> getRechargers() {
        Set<Set<IBlockState>> finalStates = new HashSet<>();
        for (Block block : validBlocks.keySet()) {
            Set<IBlockState> blockStates = new HashSet<>(block.getBlockState().getValidStates());
            finalStates.add(blockStates);
        }
        for (IBlockState state : validStates.keySet()) {
            // Avoid duplicate entries when player specifies both block and blockstate
            if (!validBlocks.containsKey(state.getBlock()))
                finalStates.add(Collections.singleton(state));
        }
        return finalStates;
    }


    public static class AltarPowerSource {

        private final int factor;
        private final int limit;

        public AltarPowerSource(int factor, int limit) {
            this.factor = factor;
            this.limit = limit;
        }

        public int getFactor() {
            return factor;
        }

        public int getLimit() {
            return limit;
        }

    }
}
