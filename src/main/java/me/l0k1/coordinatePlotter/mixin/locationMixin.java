package me.l0k1.coordinatePlotter.mixin;

import me.l0k1.coordinatePlotter.client.Activator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static me.l0k1.coordinatePlotter.client.TilDeath.DeathTimer;

@Mixin(PlayerEntity.class)
public class locationMixin {
	MinecraftClient mc = MinecraftClient.getInstance();
	String Position;
	int ticks;
	DecimalFormat LASFormat = new DecimalFormat("####.###");
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'at'HH.mm.ssz");
	Date date = new Date(System.currentTimeMillis());
	String finalDate = formatter.format(date);
	public String FileName = finalDate+"-points.txt";
	public File Coordinates = new File("LocationLogger\\"+FileName);
	public FileWriter addPoints = new FileWriter("LocationLogger\\"+FileName);
	boolean run = false;
	int DeathTick = 0;


	public locationMixin() throws IOException {
	}

	@Inject(at = @At("HEAD"), method = "tick()V")
	public void onTickEvent(CallbackInfo info) throws IOException {
		run = Activator.onOff;
		++ticks;
		if (ticks > 50 && run == true) {
			double posX = mc.player.getX();
			double posY = mc.player.getY();
			double posZ = mc.player.getZ();
			String realPosX = LASFormat.format(posX);
			String realPosY = LASFormat.format(posY);
			String realPosZ = LASFormat.format(posZ);
			Coordinates.setWritable(true);

			int xInts = realPosX.indexOf('.');
			int XDecimals = realPosX.length() - xInts - 1;
			if (!realPosX.contains(".")) {
				realPosX = realPosX + ".000";
			} else if (XDecimals == 1){
				realPosX = realPosX + "00";
			} else if (XDecimals == 2){
				realPosX = realPosX + "0";
			}

			int yInts = realPosY.indexOf('.');
			int yDecimals = realPosY.length() - yInts - 1;
			if (!realPosY.contains(".")) {
				realPosY = realPosY + ".000";
			} else if (yDecimals == 1){
				realPosY = realPosY + "00";
			} else if (yDecimals == 2){
				realPosY = realPosY + "0";
			}

			int zInts = realPosZ.indexOf('.');
			int zDecimals = realPosZ.length() - zInts - 1;
			if (!realPosZ.contains(".")) {
				realPosZ = realPosZ + ".000";
			} else if (zDecimals == 1){
				realPosY = realPosY + "00";
			} else if (zDecimals == 2){
				realPosZ = realPosZ + "0";
			}
			Position = realPosX + " " + realPosZ + " " + realPosY + "\n";
			//System.out.println(Position);
			addPoints.append(Position);
			addPoints.flush();


			++DeathTick;
			if (DeathTick == 6000) {
				mc.player.sendChatMessage("/kill");
				DeathTick = 0;
			}
			System.out.println(String.valueOf(DeathTick));
		}
	}

}




