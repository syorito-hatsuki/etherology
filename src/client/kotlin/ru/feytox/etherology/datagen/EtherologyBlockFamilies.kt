package ru.feytox.etherology.datagen

import net.minecraft.data.BlockFamilies
import net.minecraft.data.BlockFamily
import ru.feytox.etherology.registry.BlocksRegistry

object EtherologyBlockFamilies {
    val GOLDBARK_PLANKS: BlockFamily = BlockFamilies.familyBuilder(BlocksRegistry.GOLDBARK_PLANKS)
        .button(BlocksRegistry.GOLDBARK_BUTTON)
        .fence(BlocksRegistry.GOLDBARK_FENCE)
        .fenceGate(BlocksRegistry.GOLDBARK_FENCE_GATE)
        .pressurePlate(BlocksRegistry.GOLDBARK_PRESSURE_PLATE)
        .sign(
            BlocksRegistry.GOLDBARK_SIGN,
            BlocksRegistry.GOLDBARK_WALL_SIGN
        )
        .slab(BlocksRegistry.GOLDBARK_SLAB)
        .stairs(BlocksRegistry.GOLDBARK_STAIRS)
        .door(BlocksRegistry.GOLDBARK_DOOR)
        .trapdoor(BlocksRegistry.GOLDBARK_TRAPDOOR)
        .recipeGroupPrefix("wooden")
        .recipeUnlockedBy("has_planks")
        .family
}