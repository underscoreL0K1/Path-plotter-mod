package me.l0k1.coordinatePlotter.mixin;


import me.l0k1.coordinatePlotter.client.Activator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.TimeUnit;

import static me.l0k1.coordinatePlotter.client.Activator.onOff;
import static me.l0k1.coordinatePlotter.client.Activator.pathChoice;

@Mixin(DeathScreen.class)
public class DeathMixin {
    MinecraftClient mc = MinecraftClient.getInstance();
    boolean run = false;
    @Inject(at = @At("HEAD"), method = "init")
    public void onTickEvent(CallbackInfo di) throws InterruptedException {
        run = Activator.onOff;
        //int path = pathChoice();
        System.out.println("Died");
        if (onOff == true) {
            mc.player.requestRespawn();
            pathChoice();

        }
    }



}
