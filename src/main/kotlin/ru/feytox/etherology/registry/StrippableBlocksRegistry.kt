package ru.feytox.etherology.registry

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry

object StrippableBlocksRegistry {
    init {
        StrippableBlockRegistry.register(BlocksRegistry.GOLDBARK_LOG, BlocksRegistry.STRIPPED_GOLDBARK_LOG)
        StrippableBlockRegistry.register(BlocksRegistry.WEEPING_GOLDBARK_LOG, BlocksRegistry.STRIPPED_GOLDBARK_LOG)

        StrippableBlockRegistry.register(BlocksRegistry.GOLDBARK_WOOD, BlocksRegistry.STRIPPED_GOLDBARK_WOOD)
    }
}