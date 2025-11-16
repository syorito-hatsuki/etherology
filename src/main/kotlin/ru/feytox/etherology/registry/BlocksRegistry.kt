package ru.feytox.etherology.registry

import net.minecraft.core.BlockPos
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import net.minecraft.world.level.material.PushReaction
import ru.feytox.etherology.Etherology
import ru.feytox.etherology.Etherology.MOD_ID
import ru.feytox.etherology.world.level.block.entity.EtherologyHangingSignBlockEntity
import ru.feytox.etherology.world.level.block.entity.EtherologySignBlockEntity
import ru.feytox.etherology.world.level.block.state.properties.BlockSetTypes
import ru.feytox.etherology.world.level.block.state.properties.WoodTypes

object BlocksRegistry {

    init {
        Etherology.logger.info("Initializing Blocks")
    }

    val GOLDBARK_LOG = register("goldbark_log", ::RotatedPillarBlock) {
        Blocks.logProperties(MapColor.SAND, MapColor.QUARTZ, SoundType.WOOD)
    }

    val GOLDBARK_WOOD = register("goldbark_wood", ::RotatedPillarBlock) {
        GOLDBARK_LOG.properties()
    }

    val WEEPING_GOLDBARK_LOG = register("weeping_goldbark_log", ::RotatedPillarBlock) {
        GOLDBARK_LOG.properties()
    }

    val STRIPPED_GOLDBARK_LOG = register("stripped_goldbark_log", ::RotatedPillarBlock) {
        GOLDBARK_LOG.properties()
    }

    val STRIPPED_GOLDBARK_WOOD = register("stripped_goldbark_wood", ::RotatedPillarBlock) {
        GOLDBARK_LOG.properties()
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
        GOLDBARK_PLANKS.properties()
    }

    val GOLDBARK_FENCE = register("goldbark_fence", ::FenceBlock) {
        GOLDBARK_PLANKS.properties()
    }

    val GOLDBARK_BUTTON = register("goldbark_button", { properties ->
        ButtonBlock(BlockSetTypes.GOLDBARK, 30, properties)
    }) {
        Blocks.buttonProperties()
    }

    val GOLDBARK_FENCE_GATE = register("goldbark_fence_gate", { properties ->
        FenceGateBlock(WoodTypes.GOLDBARK, properties)
    }) {
        GOLDBARK_PLANKS.properties()
    }

    val GOLDBARK_PRESSURE_PLATE = register("goldbark_pressure_plate", { properties ->
        PressurePlateBlock(BlockSetTypes.GOLDBARK, properties)
    }) {
        GOLDBARK_PLANKS.properties()
        strength(0.5f)
        forceSolidOn()
        noCollision()
        pushReaction(PushReaction.DESTROY)
    }

    val GOLDBARK_SIGN = register("goldbark_sign", { properties ->
        object : StandingSignBlock(WoodTypes.GOLDBARK, properties) {
            override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): BlockEntity =
                EtherologySignBlockEntity(blockPos, blockState)
        }
    }) {
        GOLDBARK_PLANKS.properties()
        strength(1.0f)
        forceSolidOn()
        noCollision()
    }

    val GOLDBARK_WALL_SIGN = register("goldbark_wall_sign", { properties ->
        object : WallSignBlock(WoodTypes.GOLDBARK, properties) {
            override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): BlockEntity =
                EtherologySignBlockEntity(blockPos, blockState)
        }
    }) {
        GOLDBARK_PLANKS.properties()
        Blocks.wallVariant(GOLDBARK_SIGN, true)
        strength(1.0f)
        forceSolidOn()
        noCollision()
    }

    val GOLDBARK_HANGING_SIGN = register("goldbark_hanging_sign", { properties ->
        object : CeilingHangingSignBlock(WoodTypes.GOLDBARK, properties) {
            override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): BlockEntity =
                EtherologyHangingSignBlockEntity(blockPos, blockState)
        }
    }) {
        GOLDBARK_PLANKS.properties()
        forceSolidOn()
        noCollision()
        strength(1.0F)
    }

    val GOLDBARK_WALL_HANGING_SIGN = register("goldbark_wall_hanging_sign", { properties ->
        object : WallHangingSignBlock(WoodTypes.GOLDBARK, properties) {
            override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): BlockEntity =
                EtherologyHangingSignBlockEntity(blockPos, blockState)
        }
    }) {
        GOLDBARK_PLANKS.properties()
        Blocks.wallVariant(GOLDBARK_HANGING_SIGN, true)
        forceSolidOn()
        noCollision()
        strength(1.0F)
    }

    val GOLDBARK_DOOR = register("goldbark_door", { properties ->
        DoorBlock(BlockSetTypes.GOLDBARK, properties)
    }) {
        GOLDBARK_PLANKS.properties()
        noOcclusion()
        pushReaction(PushReaction.DESTROY)
    }

    val GOLDBARK_TRAPDOOR = register("goldbark_trapdoor", { properties ->
        TrapDoorBlock(BlockSetTypes.GOLDBARK, properties)
    }) {
        GOLDBARK_PLANKS.properties()
        noOcclusion()
        isValidSpawn(Blocks::never)
    }

    private inline fun <reified T : Block> register(
        name: String, noinline factory: (Properties) -> T, settingsBuilder: Properties.() -> Unit
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
        name: String, properties: Properties, noinline factory: (Properties) -> T
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
    ) { properties ->
        StairBlock(block.defaultBlockState(), properties)
    }
}