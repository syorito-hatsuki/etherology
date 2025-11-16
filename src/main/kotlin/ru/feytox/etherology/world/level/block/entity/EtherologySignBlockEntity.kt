package ru.feytox.etherology.world.level.block.entity

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.entity.SignBlockEntity
import net.minecraft.world.level.block.state.BlockState
import ru.feytox.etherology.registry.BlocksEntitiesRegistry.ETHEROLOGY_SIGN_ENTITY

class EtherologySignBlockEntity : SignBlockEntity {
    constructor(pos: BlockPos, state: BlockState) : super(ETHEROLOGY_SIGN_ENTITY, pos, state)

    override fun getType(): BlockEntityType<EtherologySignBlockEntity> = ETHEROLOGY_SIGN_ENTITY
}