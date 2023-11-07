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
        System.out.println("Tuberia Abajo X: " + x);
    }

    public int posicionAleatoriaX() {
        Random numeroAleatorio = new Random();
        int posicion = numeroAleatorio.nextInt(101) + 600; // Numero aleatorio de 600 a 700 para la posicion X de la tuberia
        System.out.println("Posicion aleatorio Tuberia Abajo X: " + posicion);
        return posicion;
    }


    public int setX(int x) {
        return this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}