package me.l0k1.coordinatePlotter;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.system.CallbackI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlotterMod implements ModInitializer {
	public static MinecraftClient mc = MinecraftClient.getInstance();
	public boolean run;



	public PlotterMod() throws IOException {
	}


	@Override
	public void onInitialize() {

	}
}
