import javax.swing.*;

public class Pajaro {
    // Posicion del pajaro
    private int x;
    private int y;
    // Movimiento del pajaro
    private int velocidad;
    private int gravedad;
    public int veces = 60;
    public int vecesSalto = 0;
    
    public int puntos;

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

    public int puntos(int tuberiaArribaX, int tuberiaArribaY, int tuberiaAbajoX, int tuberiaAbajoY, int puntos) {
        final int ALTURA_TUBERIA_ARRIBA = 300;
        final int BAJO_TUBERIA_ABAJO = 300;
        int ANCHO_TUBERIA_ARRIBA = 70;
        int ANCHO_TUBERIA_ABAJO = 70;

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
        }

        return puntos;

    }
}
