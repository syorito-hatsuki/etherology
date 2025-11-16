package ru.feytox.etherology.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import java.util.concurrent.CompletableFuture

class EtherologyItemTagProvider(
    output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>
) : FabricTagProvider.ItemTagProvider(output, registriesFuture) {
    override fun addTags(wrapperLookup: HolderLookup.Provider) {

    }

    private fun TagKey<Item>.addItems(vararg items: Item) {
        valueLookupBuilder(this).add(*items)
    }
}