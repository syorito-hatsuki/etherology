package ru.feytox.etherology

import com.mojang.logging.LogUtils
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import ru.feytox.etherology.registry.*

object Etherology : ModInitializer {
    const val MOD_ID = "etherology"
    val logger: Logger = LogUtils.getLogger()

    override fun onInitialize() {
        logger.info("${javaClass.simpleName} initialized with mod-id $MOD_ID")
        BlocksRegistry
        BlocksEntitiesRegistry
        ItemsGroupRegistry
        ItemsRegistry
        StrippableBlocksRegistry
    }
}