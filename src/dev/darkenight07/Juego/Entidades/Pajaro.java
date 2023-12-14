package dev.darkenight07.Juego.Entidades;

public class Pajaro {
    // Posicion del pajaro
    private int x;
    public int y;
    // Movimiento del pajaro
    private final int VELOCIDAD;
    private int veces = 8;
    private int vecesSalto = 0;
    private int angulo;
    public long ultimoSalto;

    public Pajaro(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.VELOCIDAD = velocidad;
        this.ultimoSalto = System.currentTimeMillis();
    }
    public void saltar() {
        y -= 8;
        if (y < 0) {
            System.exit(0);
        } else {
            vecesSalto++;
        }
        this.ultimoSalto = System.currentTimeMillis();
    }
    public void bajar() {
        y += VELOCIDAD;
        if (y > 400) {
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
            System.exit(0);
        } else if ((inicioTuberiaXAbajo <= x && finalTuberiaXAbajo >= x) && (inicioTuberiaYAbajo - 20 <= y && finalTuberiaYAbajo >= y)) {
            System.exit(0);
        } else if (x == inicioTuberiaXArriba || x == inicioTuberiaXAbajo) {
            puntos++;
        }
        return puntos;
    }

    public int getVeces() {
        return veces;
    }

    public int getVecesSalto() {
        return vecesSalto;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public void setVecesSalto(int vecesSalto) {
        this.vecesSalto = vecesSalto;
    }

    public int getAngulo() {
        return angulo;
    }
}
