package me.l0k1.coordinatePlotter.mixin;

import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.screen.PlayerScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.l0k1.coordinatePlotter.client.Activator.disconnecter;

@Mixin(DisconnectedScreen.class)
public class ConnectMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    public void toggler(CallbackInfo ds) {
        disconnecter();
    }



}
