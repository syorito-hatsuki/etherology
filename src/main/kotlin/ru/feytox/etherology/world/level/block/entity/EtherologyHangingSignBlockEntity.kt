package ru.feytox.etherology.world.level.block.entity

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.entity.SignBlockEntity
import net.minecraft.world.level.block.state.BlockState
import ru.feytox.etherology.registry.BlocksEntitiesRegistry.ETHEROLOGY_HANGING_SIGN_ENTITY

class EtherologyHangingSignBlockEntity : SignBlockEntity {
    companion object {
        private const val MAX_TEXT_LINE_WIDTH: Int = 60
        private const val TEXT_LINE_HEIGHT: Int = 9
    }
    constructor(pos: BlockPos, state: BlockState) : super(ETHEROLOGY_HANGING_SIGN_ENTITY, pos, state)

    override fun getType(): BlockEntityType<EtherologyHangingSignBlockEntity> = ETHEROLOGY_HANGING_SIGN_ENTITY

    override fun getTextLineHeight(): Int = TEXT_LINE_HEIGHT

    override fun getMaxTextLineWidth(): Int = MAX_TEXT_LINE_WIDTH
}