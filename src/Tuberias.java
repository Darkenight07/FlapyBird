import java.util.Random;

public class Tuberias {
    private int x;
    private int y;
    private int velocidad;

    public Tuberias(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
    }

    public int movimientoArribaX() {
        x = posicionAleatoria();

        while (x > 300 && x < 400) {
            x -= velocidad;
            return x;
        }
        return 0;
    }

    public int movimientoAbajoX() {
        x = posicionAleatoria();

        while (x > 300 && x < 400) {
            x -= velocidad;
            return x;
        }
        return 0;
    }

    public int posicionAleatoria() {
        Random numeroAleatorio = new Random();
        int posicion = numeroAleatorio.nextInt(101) + 300; // Numero aleatorio de 300 a 400 para la posicion de las tuberias
        System.out.println("Posicion aleatorio X: " + posicion);
        return posicion;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
