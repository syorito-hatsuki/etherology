package ru.feytox.etherology

import com.mojang.logging.LogUtils
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.SpecialBlockRendererRegistry
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers
import net.minecraft.client.renderer.blockentity.HangingSignRenderer
import net.minecraft.client.renderer.blockentity.SignRenderer
import net.minecraft.client.renderer.special.HangingSignSpecialRenderer
import net.minecraft.client.renderer.special.StandingSignSpecialRenderer
import org.slf4j.Logger
import ru.feytox.etherology.registry.BlocksEntitiesRegistry
import ru.feytox.etherology.registry.BlocksRegistry
import ru.feytox.etherology.world.level.block.state.properties.WoodTypes

object EtherologyClient : ClientModInitializer {
    val logger: Logger = LogUtils.getLogger()

    override fun onInitializeClient() {
        BlockEntityRenderers.register(BlocksEntitiesRegistry.ETHEROLOGY_SIGN_ENTITY, ::SignRenderer)
        BlockEntityRenderers.register(BlocksEntitiesRegistry.ETHEROLOGY_HANGING_SIGN_ENTITY, ::HangingSignRenderer)

        SpecialBlockRendererRegistry.register(BlocksRegistry.GOLDBARK_SIGN,  StandingSignSpecialRenderer.Unbaked(WoodTypes.GOLDBARK))
        SpecialBlockRendererRegistry.register(BlocksRegistry.GOLDBARK_WALL_SIGN,  StandingSignSpecialRenderer.Unbaked(WoodTypes.GOLDBARK))
        SpecialBlockRendererRegistry.register(BlocksRegistry.GOLDBARK_HANGING_SIGN,  HangingSignSpecialRenderer.Unbaked(WoodTypes.GOLDBARK))
        SpecialBlockRendererRegistry.register(BlocksRegistry.GOLDBARK_WALL_HANGING_SIGN,  HangingSignSpecialRenderer.Unbaked(WoodTypes.GOLDBARK))
    }
}