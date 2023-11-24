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
        int posicion = numeroAleatorio.nextInt(100) + 300; // Numero aleatorio de 250 a 450 para la posicion Y de la tuberia
        System.out.println("Tuberia Abajo Y: " + posicion);
        return posicion;
    }

    public int generarNumeroAleatorio(int min, int max) {
        Random numeroAleatorio = new Random();
        int numeroAleatorio_ = numeroAleatorio.nextInt(max) + min;
        return numeroAleatorio_;
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
