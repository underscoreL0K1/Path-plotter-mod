package me.l0k1.coordinatePlotter.client;

import java.io.IOException;

public class Activator {

    public static Boolean onOff = false;


    public static void  onOff() throws IOException {
        onOff = !onOff;
    }

}
