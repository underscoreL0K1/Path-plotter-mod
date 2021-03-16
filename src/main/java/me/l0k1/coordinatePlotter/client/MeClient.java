package me.l0k1.coordinatePlotter.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Environment(EnvType.CLIENT)
public class MeClient implements ClientModInitializer {

    public static MinecraftClient mc = MinecraftClient.getInstance();
    public boolean run;
    public static String FileName;
    public static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'at'HH.mm.ssz");
    public static Date date = new Date(System.currentTimeMillis());
    public static String finalDate = formatter.format(date);


    public static String filesName() {
        FileName = finalDate+"-points.txt";
        return FileName;
    }


    @Override
    public void onInitializeClient() {
        FileName = filesName();
        File Coordinates = new File("LocationLogger\\"+FileName);
        Coordinates.setWritable(true);

    }


}
