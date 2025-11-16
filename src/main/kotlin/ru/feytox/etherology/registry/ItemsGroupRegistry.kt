package ru.feytox.etherology.registry

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import ru.feytox.etherology.Etherology.MOD_ID

object ItemsGroupRegistry {
    val ETHEROLOGY_ITEM_GROUP_KEY: ResourceKey<CreativeModeTab> = ResourceKey.create(
        Registries.CREATIVE_MODE_TAB,
        ResourceLocation.fromNamespaceAndPath(MOD_ID, "${MOD_ID}_item_group")
    )

    val ETHEROLOGY_ITEM_GROUP: CreativeModeTab = Registry.register(
        BuiltInRegistries.CREATIVE_MODE_TAB,
        ETHEROLOGY_ITEM_GROUP_KEY,
        FabricItemGroup.builder()
            .icon { ItemStack(BlocksRegistry.GOLDBARK_LOG) }
            .title(Component.translatable("itemGroup.${MOD_ID}"))
            .build()
    )

    init {
        ItemGroupEvents.modifyEntriesEvent(ETHEROLOGY_ITEM_GROUP_KEY).register {
            it.prepend(BlocksRegistry.GOLDBARK_LOG)
            it.prepend(BlocksRegistry.GOLDBARK_WOOD)
            it.prepend(BlocksRegistry.WEEPING_GOLDBARK_LOG)
            it.prepend(BlocksRegistry.STRIPPED_GOLDBARK_LOG)
            it.prepend(BlocksRegistry.GOLDBARK_PLANKS)
            it.prepend(BlocksRegistry.GOLDBARK_STAIRS)
            it.prepend(BlocksRegistry.GOLDBARK_SLAB)
            it.prepend(BlocksRegistry.GOLDBARK_FENCE)
            it.prepend(BlocksRegistry.GOLDBARK_BUTTON)

            it.prepend(BlocksRegistry.GOLDBARK_FENCE_GATE)
            it.prepend(BlocksRegistry.GOLDBARK_PRESSURE_PLATE)
            it.prepend(BlocksRegistry.GOLDBARK_SIGN)
            it.prepend(BlocksRegistry.GOLDBARK_HANGING_SIGN)
            it.prepend(BlocksRegistry.GOLDBARK_DOOR)
            it.prepend(BlocksRegistry.GOLDBARK_TRAPDOOR)
        }
    }
}