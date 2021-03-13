package me.l0k1.coordinatePlotter.client;

import net.minecraft.client.MinecraftClient;

public class TilDeath {

    public static MinecraftClient mc = MinecraftClient.getInstance();;

    public static void DeathTimer() {
        mc.player.sendChatMessage("/kill");



    }



}
