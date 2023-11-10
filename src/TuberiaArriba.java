import java.util.Random;
public class TuberiaArriba {
    private int x;
    private int y;
    private final int VELOCIDAD;

    public TuberiaArriba(int x, int y, int VELOCIDAD) {
        this.x = x;
        this.y = y;
        this.VELOCIDAD= VELOCIDAD;
    }

    public void movimientoX() {
        x -= VELOCIDAD;
        // System.out.println("Tuberia Arriba X: " + x);
    }

    public int posicionAleatoriaY() {
        Random numeroAleatorio = new Random();
        int posicion = numeroAleatorio.nextInt(40) - 100 ; // Numero aleatorio de 20 a 111 para la posicion X de la tuberia
        System.out.println("Tuberia Arriba Y " + posicion);
        return posicion;
    }

    public int setX(int x) {return this.x = x;}
    public int setY(int y) {return this.y = y; }

    public int getX() {return x;}
    public int getY() {return y;}
}
