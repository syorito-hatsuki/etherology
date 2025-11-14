package ru.feytox.etherology.registry

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.Blocks.logProperties
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import ru.feytox.etherology.Etherology
import ru.feytox.etherology.Etherology.MOD_ID

object BlocksRegistry {

    init {
        Etherology.logger.info("Initializing Blocks")
    }

    val GOLDBARK_LOG = register("goldbark_log", ::RotatedPillarBlock) {
        logProperties(MapColor.SAND, MapColor.QUARTZ, SoundType.WOOD)
    }

    val GOLDBARK_WOOD = register("goldbark_wood", ::RotatedPillarBlock) {
        mapColor(MapColor.SAND)
        instrument(NoteBlockInstrument.BASS)
        strength(2.0F)
        sound(SoundType.WOOD)
        ignitedByLava()
    }

    val WEEPING_GOLDBARK_LOG = register("weeping_goldbark_log", ::RotatedPillarBlock) {
        GOLDBARK_LOG.properties()
    }

    val STRIPPED_GOLDBARK_LOG = register("stripped_goldbark_log", ::RotatedPillarBlock) {
        GOLDBARK_LOG.properties()
    }

    val STRIPPED_GOLDBARK_WOOD = register("stripped_goldbark_wood", ::RotatedPillarBlock) {
        mapColor(MapColor.SAND)
        instrument(NoteBlockInstrument.BASS)
        strength(2.0F)
        sound(SoundType.WOOD)
        ignitedByLava()
    }

    val GOLDBARK_PLANKS = register("goldbark_planks", ::Block) {
        mapColor(MapColor.WOOD)
        instrument(NoteBlockInstrument.BASS)
        strength(2.0F, 3.0F)
        sound(SoundType.WOOD)
        ignitedByLava()
    }

    val GOLDBARK_STAIRS = registerStair("goldbark_stairs", GOLDBARK_PLANKS)

	val GOLDBARK_SLAB = register("goldbark_slab", ::SlabBlock) {
        mapColor(MapColor.SAND)
        instrument(NoteBlockInstrument.BASS)
        strength(2.0F, 3.0F)
        sound(SoundType.WOOD)
        ignitedByLava()
    }

    private inline fun <reified T : Block> register(
        name: String,
        noinline factory: (Properties) -> T,
        settingsBuilder: Properties.() -> Unit = {}
    ): T {
        val settings = Properties.of().apply(settingsBuilder)
        val block = Blocks.register(
            ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name)),
            { factory(settings) },
            settings
        ) as T
        Items.registerBlock(block)
        return block
    }

    private inline fun <reified T : Block> register(
        name: String,
        properties: Properties,
        noinline factory: (Properties) -> T
    ): T {
        val block = Blocks.register(
            ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name)),
            { factory(properties) },
            properties
        ) as T

        Items.registerBlock(block)
        return block
    }

    private fun registerStair(name: String, block: Block): Block = register(
        name, Properties.ofFullCopy(block)
    ) { props ->
        StairBlock(block.defaultBlockState(), props)
    }
}