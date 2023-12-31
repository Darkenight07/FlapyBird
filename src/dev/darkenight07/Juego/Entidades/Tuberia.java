package dev.darkenight07.Juego.Entidades;

public class Tuberia {
    private int x;
    private int y;
    private final int VELOCIDAD;

    public Tuberia(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.VELOCIDAD = velocidad;
    }
    public void movimientoX() {
        x -= VELOCIDAD;
    }
    public int setX(int x) {
        return this.x = x;
    }
    public int setY(int y) {
        return this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
