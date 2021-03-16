package me.l0k1.coordinatePlotter.mixin;

import me.l0k1.coordinatePlotter.PlotterMod;
import me.l0k1.coordinatePlotter.client.Activator;
import me.l0k1.coordinatePlotter.client.MeClient;
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

import static me.l0k1.coordinatePlotter.client.Activator.*;


@Mixin(PlayerEntity.class)
public class locationMixin {
	MinecraftClient mc = MinecraftClient.getInstance();
	String Position;
	int ticks;

	DecimalFormat LASFormat = new DecimalFormat("####.###");
	boolean run = false;
	boolean disVal = false;
	int DeathTick = 0;


	public locationMixin() throws IOException {
	}
	@Inject(at = @At("HEAD"), method = "tick()V")
	public void onTickEvent(CallbackInfo info) throws IOException {
		run = Activator.onOff;
		disVal = Activator.disconnected;
		++ticks;
		if (disVal && ticks > 40) {
			disconnecter();
			mc.player.sendChatMessage("/kill");
		}
		if (ticks > 50 && run == true) {
			double posX = mc.player.getX();
			double posY = mc.player.getY();
			double posZ = mc.player.getZ();
			String realPosX = LASFormat.format(posX);
			String realPosY = LASFormat.format(posY);
			String realPosZ = LASFormat.format(posZ);
			Position = realPosZ + " " + realPosX + " " + realPosY + "\n";
			//System.out.println(Position);


			fileWriter(Position);

			++DeathTick;
			if (DeathTick == 6000) {
				mc.player.sendChatMessage("/kill");
				DeathTick = 0;
			}
			//System.out.println(String.valueOf(DeathTick));
		}
	}

}




