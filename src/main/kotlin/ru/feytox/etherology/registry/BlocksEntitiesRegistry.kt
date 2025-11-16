package ru.feytox.etherology.registry

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.entity.BlockEntityType
import ru.feytox.etherology.Etherology.MOD_ID
import ru.feytox.etherology.world.level.block.entity.EtherologyHangingSignBlockEntity
import ru.feytox.etherology.world.level.block.entity.EtherologySignBlockEntity


object BlocksEntitiesRegistry {
    val ETHEROLOGY_SIGN_ENTITY: BlockEntityType<EtherologySignBlockEntity> = Registry.register(
        BuiltInRegistries.BLOCK_ENTITY_TYPE,
        ResourceLocation.fromNamespaceAndPath(MOD_ID, "sign"),
        FabricBlockEntityTypeBuilder.create(
            ::EtherologySignBlockEntity,
            BlocksRegistry.GOLDBARK_SIGN,
            BlocksRegistry.GOLDBARK_WALL_SIGN
        ).build()
    )

    val ETHEROLOGY_HANGING_SIGN_ENTITY: BlockEntityType<EtherologyHangingSignBlockEntity> = Registry.register(
        BuiltInRegistries.BLOCK_ENTITY_TYPE,
        ResourceLocation.fromNamespaceAndPath(MOD_ID, "hanging_sign"),
        FabricBlockEntityTypeBuilder.create(
            ::EtherologyHangingSignBlockEntity,
            BlocksRegistry.GOLDBARK_HANGING_SIGN,
            BlocksRegistry.GOLDBARK_WALL_HANGING_SIGN
        ).build()
    )
}