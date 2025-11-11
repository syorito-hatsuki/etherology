package ru.feytox.etherology

import com.mojang.logging.LogUtils
import net.fabricmc.api.ClientModInitializer
import org.slf4j.Logger

object EtherologyClient : ClientModInitializer {
    val logger: Logger = LogUtils.getLogger()

	override fun onInitializeClient() {
	}
}