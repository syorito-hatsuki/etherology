package ru.feytox.etherology.datagen

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import ru.feytox.etherology.registry.BlocksRegistry

class EtherologyModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) {
        blockStateModelGenerator.woodProvider(BlocksRegistry.GOLDBARK_LOG)
            .logWithHorizontal(BlocksRegistry.GOLDBARK_LOG).wood(BlocksRegistry.GOLDBARK_WOOD)

        blockStateModelGenerator.woodProvider(BlocksRegistry.WEEPING_GOLDBARK_LOG)
            .logWithHorizontal(BlocksRegistry.WEEPING_GOLDBARK_LOG)

        blockStateModelGenerator.woodProvider(BlocksRegistry.STRIPPED_GOLDBARK_LOG)
            .logWithHorizontal(BlocksRegistry.STRIPPED_GOLDBARK_LOG).wood(BlocksRegistry.STRIPPED_GOLDBARK_WOOD)

        blockStateModelGenerator.family(BlocksRegistry.GOLDBARK_PLANKS)
            .generateFor(EtherologyBlockFamilies.GOLDBARK_PLANKS)

        blockStateModelGenerator.createHangingSign(
            BlocksRegistry.STRIPPED_GOLDBARK_LOG,
            BlocksRegistry.GOLDBARK_HANGING_SIGN,
            BlocksRegistry.GOLDBARK_WALL_HANGING_SIGN
        )
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {

    }

    override fun getName(): String = javaClass.simpleName
}