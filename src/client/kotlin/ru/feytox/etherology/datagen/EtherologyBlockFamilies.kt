package ru.feytox.etherology.datagen

import net.minecraft.data.BlockFamilies
import net.minecraft.data.BlockFamily
import ru.feytox.etherology.registry.BlocksRegistry

object EtherologyBlockFamilies {
    val BIRCH_PLANKS: BlockFamily = BlockFamilies.familyBuilder(BlocksRegistry.GOLDBARK_PLANKS)
//        .button(Blocks.BIRCH_BUTTON)
//        .fence(Blocks.BIRCH_FENCE)
//        .fenceGate(Blocks.BIRCH_FENCE_GATE)
//        .pressurePlate(Blocks.BIRCH_PRESSURE_PLATE)
//        .sign(Blocks.BIRCH_SIGN, Blocks.BIRCH_WALL_SIGN)
        .slab(BlocksRegistry.GOLDBARK_SLAB)
        .stairs(BlocksRegistry.GOLDBARK_STAIRS)
//        .door(Blocks.BIRCH_DOOR)
//        .trapdoor(Blocks.BIRCH_TRAPDOOR)
        .recipeGroupPrefix("wooden")
        .recipeUnlockedBy("has_planks")
        .family
}