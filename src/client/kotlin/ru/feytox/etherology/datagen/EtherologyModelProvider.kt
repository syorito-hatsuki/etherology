package ru.feytox.etherology.datagen

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.client.data.models.model.TexturedModel
import ru.feytox.etherology.registry.BlocksRegistry
import ru.feytox.etherology.registry.ItemsRegistry

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
        
        blockStateModelGenerator.createTrivialBlock(BlocksRegistry.GOLDBARK_LEAVES, TexturedModel.LEAVES)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {
        itemModelGenerator.generateFlatItem(ItemsRegistry.OCULAR, ModelTemplates.FLAT_HANDHELD_ITEM)
    }

    override fun getName(): String = javaClass.simpleName
}