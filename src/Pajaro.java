public class Pajaro {
    // Posicion del pajaro
    int x;
    int y;
    // Movimiento del pajaro
    int velocidad;
    int gravedad;

    public Pajaro(int x, int y, int velocidad, int gravedad) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.gravedad = gravedad;
    }

    public void saltar() {
        int saltoMaximo = 10;
        int contadorSalto = 0;

        while (contadorSalto < saltoMaximo) {
            y -= 1;
            contadorSalto++;
            if (y < 0) {
                System.out.println("Se acabo la partida");
                System.exit(0);
            } else {
                System.out.println("Salto: " + y + " " + contadorSalto);
            }
        }
    }
    public void bajar() {
        y += velocidad;
        if (y > 400) {
            System.out.println("Se acabo la partida");
            System.exit(0);
        } else {
            System.out.println("Bajada: " + y + " Velocidad: " + velocidad);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
