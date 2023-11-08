public class Pajaro {

    public int puntos;
    private TuberiaArriba tuberiaArriba = new TuberiaArriba(500, 0, 2);
    private TuberiaAbajo tuberiaAbajo = new TuberiaAbajo(600, 300, 2);

    // Posicion del pajaro
    private int x;
    private int y;
    // Movimiento del pajaro
    private int velocidad;
    private int gravedad;
    public int veces = 60;
    public int vecesSalto = 0;

    public Pajaro(int x, int y, int velocidad, int gravedad) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.gravedad = gravedad;
    }

    public void saltar() {
        int saltoMaximo = 60;
        int contadorSalto = 0;

        while (contadorSalto < saltoMaximo) {
            y -= 1;
            contadorSalto++;
            if (y < 0) {
                System.out.println("Se acabo la partida");
                System.exit(0);
            } else {
                // System.out.println("Salto: " + y + " Contador Salto: " + contadorSalto + " Veces Salto: " + vecesSalto);
                vecesSalto++;
            }
        }

    }
    public void bajar() {
        y += velocidad;
        if (y > 400) {
            System.out.println("Se acabo la partida");
            System.exit(0);
        } else {
            // System.out.println("Bajada: " + y + " Velocidad: " + velocidad);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void puntos() {
        // Falta implementar
    }
}
