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
        // System.out.println("Tuberia Arriba X: " + x);
    }

    public int posicionAleatoriaY() {
        Random numeroAleatorio = new Random();
        int posicion = numeroAleatorio.nextInt(40) - 100 ; // Numero aleatorio de 20 a 111 para la posicion X de la tuberia
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