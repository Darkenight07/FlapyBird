import java.util.Random;
public class TuberiaAbajo {
    private int x;
    private int y;
    private int velocidad;

    public TuberiaAbajo(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
    }

    public void movimientoX() {
        x -= velocidad;
        // System.out.println("Tuberia Abajo X: " + x);
    }

    public int poscionAleatoriaY() {
        Random numeroAleatorio = new Random();
        int posicion = numeroAleatorio.nextInt(100) + 300; // Numero aleatorio de 300 a 401 para la posicion Y de la tuberia
        return posicion;
    }


    public int setX(int x) {
        return this.x = x;
    }
    public int setY(int y) {return this.y = y; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}