package me.l0k1.coordinatePlotter.client;

import net.minecraft.client.MinecraftClient;

import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;

public class Activator {

    public static MinecraftClient mc = MinecraftClient.getInstance();
    public static Boolean onOff = false;
    public static int path = 1;
    public static Boolean disconnected = false;
    public static String FileName = MeClient.filesName();
    static FileWriter addPoints;

    static {
        try {
            addPoints = new FileWriter("LocationLogger\\"+FileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Activator() throws IOException {
    }

    public static void fileWriter(String x) throws IOException {
        addPoints.append(x);
        addPoints.flush();
    }

    public static void  onOff() throws IOException {
        onOff = !onOff;
    }

    public static void pathChoice() {
        switch (path) {
            case 1:
                mc.player.sendChatMessage("#goto 0 10000");
                break;
            case 2:
                mc.player.sendChatMessage("#goto 10000 10000");
                break;
            case 3:
                mc.player.sendChatMessage("#goto 10000 0");
                break;
            case 4:
                mc.player.sendChatMessage("#goto 10000 -10000");
                break;
            case 5:
                mc.player.sendChatMessage("#goto 0 -10000");
                break;
            case 6:
                mc.player.sendChatMessage("#goto -10000 -10000");
                break;
            case 7:
                mc.player.sendChatMessage("#goto -10000 0");
                break;
            case 8:
                mc.player.sendChatMessage("#goto -10000 10000");
                break;
        }

        ++path;
        if (path > 8) {
            path = 1;
        }


    }
    public static void disconnecter() {
        disconnected = !disconnected;
    }

}
