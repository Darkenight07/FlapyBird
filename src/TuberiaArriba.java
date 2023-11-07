import java.util.Random;
public class TuberiaArriba {
    private int x;
    private int y;
    private int velocidad;

    public TuberiaArriba(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
    }

    public void movimientoX() {
        x -= velocidad;
        System.out.println("Tuberia Arriba X: " + x);
    }

    public int posicionAleatoriaX() {
        Random numeroAleatorio = new Random();
        int posicion = numeroAleatorio.nextInt(101) + 450; // Numero aleatorio de 400 a 500 para la posicion X de la tuberia
        System.out.println("Posicion aleatorio Tuberia Arriba X: " + posicion);
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