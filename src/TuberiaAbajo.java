import java.util.Random;
public class TuberiaAbajo {
    private int x;
    private int y;
    private final int VELOCIDAD;

    public TuberiaAbajo(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.VELOCIDAD = velocidad;
    }

    public void movimientoX() {
        x -= VELOCIDAD;
    }

    public int poscionAleatoriaY() {
        Random numeroAleatorio = new Random();
        int posicion = numeroAleatorio.nextInt(100) + 300; // Numero aleatorio de 300 a 401 para la posicion Y de la tuberia
        return posicion;
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
