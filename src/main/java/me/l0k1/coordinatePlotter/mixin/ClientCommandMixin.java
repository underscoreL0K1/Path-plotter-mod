package me.l0k1.coordinatePlotter.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.io.IOException;
import static me.l0k1.coordinatePlotter.client.Activator.onOff;


@Mixin(ClientPlayerEntity.class)
public abstract class ClientCommandMixin {

    MinecraftClient mc = MinecraftClient.getInstance();;

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    private void onSendChatMessage(String message, CallbackInfo ci) throws IOException {
        if (message.equals("%ToggleTracer")) {
            mc.player.sendChatMessage("/kill");
            onOff();
            ci.cancel();


        }
    }
}
