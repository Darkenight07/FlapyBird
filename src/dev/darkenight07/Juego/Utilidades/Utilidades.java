package dev.darkenight07.Juego.Utilidades;

import java.util.Random;
public class Utilidades {
    public static int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
