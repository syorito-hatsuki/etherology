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
    val ETHEROLOGY_BLOCKS_ITEM_GROUP_KEY: ResourceKey<CreativeModeTab> = ResourceKey.create(
        Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, "${MOD_ID}_blocks_item_group")
    )

    val ETHEROLOGY_ITEMS_ITEM_GROUP_KEY: ResourceKey<CreativeModeTab> = ResourceKey.create(
        Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, "${MOD_ID}_items_item_group")
    )

    init {
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ETHEROLOGY_BLOCKS_ITEM_GROUP_KEY,
            FabricItemGroup.builder().icon { ItemStack(BlocksRegistry.GOLDBARK_LEAVES) }
                .title(Component.translatable("itemGroup.${MOD_ID}.blocks")).build())

        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ETHEROLOGY_ITEMS_ITEM_GROUP_KEY,
            FabricItemGroup.builder().icon { ItemStack(ItemsRegistry.OCULAR) }
                .title(Component.translatable("itemGroup.${MOD_ID}.items")).build())

        ItemGroupEvents.modifyEntriesEvent(ETHEROLOGY_BLOCKS_ITEM_GROUP_KEY).register {
            it.prepend(BlocksRegistry.GOLDBARK_LOG)
            it.prepend(BlocksRegistry.GOLDBARK_WOOD)
            it.prepend(BlocksRegistry.WEEPING_GOLDBARK_LOG)
            it.prepend(BlocksRegistry.STRIPPED_GOLDBARK_LOG)
            it.prepend(BlocksRegistry.STRIPPED_GOLDBARK_WOOD)
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

            it.prepend(BlocksRegistry.GOLDBARK_LEAVES)
        }

        ItemGroupEvents.modifyEntriesEvent(ETHEROLOGY_ITEMS_ITEM_GROUP_KEY).register {
            it.prepend(ItemsRegistry.OCULAR)
        }
    }
}