package ru.feytox.etherology.datagen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object EtherologyDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val etherologyPack = fabricDataGenerator.createPack()

        etherologyPack.addProvider(::EtherologyModelProvider)
    }
}