public class Pajaro {
    // Posicion del pajaro
    private int x;
    public int y;
    // Movimiento del pajaro
    private final int VELOCIDAD;
    public int veces = 60;
    public int vecesSalto = 0;

    public Pajaro(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.VELOCIDAD = velocidad;
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
                vecesSalto++;
            }
        }
    }
    public void bajar() {
        y += VELOCIDAD;
        if (y > 400) {
            System.out.println("Se acabo la partida");
            System.exit(0);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int puntos(int tuberiaArribaX, int tuberiaArribaY, int tuberiaAbajoX, int tuberiaAbajoY, int puntos) {
        final int ALTURA_TUBERIA_ARRIBA = 300;
        final int BAJO_TUBERIA_ABAJO = 300;
        
        int ANCHO_TUBERIA_ARRIBA = 90;
        int ANCHO_TUBERIA_ABAJO = 90;

        int inicioTuberiaXArriba = tuberiaArribaX;
        int finalTuberiaXArriba = tuberiaArribaX + ANCHO_TUBERIA_ARRIBA;
        int inicioTuberiaYArriba = tuberiaArribaY;
        int finalTuberiaYArriba = tuberiaArribaY + ALTURA_TUBERIA_ARRIBA;

        int inicioTuberiaXAbajo = tuberiaAbajoX;
        int finalTuberiaXAbajo = tuberiaAbajoX + ANCHO_TUBERIA_ABAJO;
        int inicioTuberiaYAbajo = tuberiaAbajoY;
        int finalTuberiaYAbajo = tuberiaAbajoY + BAJO_TUBERIA_ABAJO;

        if((inicioTuberiaXArriba <= x && finalTuberiaXArriba >= x) && (inicioTuberiaYArriba <= y && finalTuberiaYArriba >= y)) {
            System.out.println("Colisionando");
            System.exit(0);
        } else if ((inicioTuberiaXAbajo <= x && finalTuberiaXAbajo >= x) && (inicioTuberiaYAbajo <= y && finalTuberiaYAbajo >= y)) {
            System.out.println("Colisionando");
            System.exit(0);
        } else if (x == inicioTuberiaXArriba || x == inicioTuberiaXAbajo) {
            puntos++;
            System.out.println("Puntos: " + puntos);
        }

        return puntos;

    }
}
