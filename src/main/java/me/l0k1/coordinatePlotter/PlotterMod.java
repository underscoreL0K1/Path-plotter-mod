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
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		//MinecraftClient mc = new MinecraftClient.getInstance();
		//this.mc = MinecraftClient.getInstance();
		run = false;
/*
		System.out.println(finalDate);
		try {
			if (Coordinates.createNewFile()) {
				System.out.println("File created: " + Coordinates.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Coordinates.setWritable(true); */
		System.out.println("Hello Fabric world!");








	}
}
