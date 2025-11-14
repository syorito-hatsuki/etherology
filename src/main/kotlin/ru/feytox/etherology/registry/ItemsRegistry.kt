package ru.feytox.etherology.registry

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import ru.feytox.etherology.Etherology
import ru.feytox.etherology.Etherology.MOD_ID

object ItemsRegistry {

    init {
        Etherology.logger.info("Initializing Items")
    }

    val OCULAR = register("ocular", ::Item)

    inline fun <reified T : Item> register(
        name: String, crossinline factory: (Item.Properties) -> T, settingsBuilder: Item.Properties.() -> Unit = {}
    ): T {
        val settings = Item.Properties().apply(settingsBuilder)
        return Items.registerItem(
            ResourceKey.create(
                Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name)
            ), { factory(settings) }, settings
        ) as T
    }
}