package ru.feytox.etherology.mixin.client;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.feytox.etherology.EtherologyClient;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	@Inject(at = @At("HEAD"), method = "run")
	private void init(CallbackInfo info) {
        EtherologyClient.INSTANCE.getLogger().info("ClientMixin init");
	}
}