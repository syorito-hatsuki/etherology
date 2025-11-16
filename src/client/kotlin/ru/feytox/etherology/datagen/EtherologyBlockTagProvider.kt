package ru.feytox.etherology.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block
import ru.feytox.etherology.registry.BlocksRegistry
import java.util.concurrent.CompletableFuture

class EtherologyBlockTagProvider(
    output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>
) : FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun addTags(wrapperLookup: HolderLookup.Provider) {
        BlockTags.WOODEN_FENCES.addBlocks(BlocksRegistry.GOLDBARK_FENCE)
        BlockTags.WOODEN_SLABS.addBlocks(BlocksRegistry.GOLDBARK_SLAB)
        BlockTags.WOODEN_STAIRS.addBlocks(BlocksRegistry.GOLDBARK_STAIRS)
        BlockTags.WOODEN_BUTTONS.addBlocks(BlocksRegistry.GOLDBARK_BUTTON)
        BlockTags.PLANKS.addBlocks(BlocksRegistry.GOLDBARK_PLANKS)
        BlockTags.LOGS.addBlocks(
            BlocksRegistry.GOLDBARK_LOG,
            BlocksRegistry.GOLDBARK_WOOD,
            BlocksRegistry.WEEPING_GOLDBARK_LOG,
            BlocksRegistry.STRIPPED_GOLDBARK_LOG
        )
        BlockTags.FENCE_GATES.addBlocks(BlocksRegistry.GOLDBARK_FENCE_GATE)
        BlockTags.WOODEN_PRESSURE_PLATES.addBlocks(BlocksRegistry.GOLDBARK_PRESSURE_PLATE)
        BlockTags.STANDING_SIGNS.addBlocks(BlocksRegistry.GOLDBARK_SIGN)
        BlockTags.WALL_SIGNS.addBlocks(BlocksRegistry.GOLDBARK_WALL_SIGN)
        BlockTags.CEILING_HANGING_SIGNS.addBlocks(BlocksRegistry.GOLDBARK_HANGING_SIGN)
        BlockTags.WALL_HANGING_SIGNS.addBlocks(BlocksRegistry.GOLDBARK_WALL_HANGING_SIGN)
        BlockTags.WOODEN_DOORS.addBlocks(BlocksRegistry.GOLDBARK_DOOR)
        BlockTags.WOODEN_TRAPDOORS.addBlocks(BlocksRegistry.GOLDBARK_TRAPDOOR)
    }

    private fun TagKey<Block>.addBlocks(vararg blocks: Block) {
        valueLookupBuilder(this).add(*blocks)
    }
}