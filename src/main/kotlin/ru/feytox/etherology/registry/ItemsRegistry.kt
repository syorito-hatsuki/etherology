package ru.feytox.etherology.registry

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import ru.feytox.etherology.Etherology
import java.util.function.Function

object ItemsRegistry {

    init {
        Etherology.logger.info("Initializing Items")
    }

    val OCULAR = register("ocular", ::Item)

    fun register(name: String, function: Function<Item.Properties, Item>): Item = Items.registerItem(
        ResourceKey.create(
            Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Etherology.MOD_ID, name)
        ), function, Item.Properties()
    )
}