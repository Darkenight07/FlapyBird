package dev.darkenight07.Juego;

public class GeneracionTuberias {
    public static int generacionTuberias(int tuberiaArribaY,int tuberiaAbajoY,int opcion, int numeroAleatorio) {
        // Opcion 1 es tuberiaArriba
        // Opcion 2 es tuberiaAbajo

        switch (numeroAleatorio) {
            case 1:
                if (opcion == 1) {
                    tuberiaArribaY = -170;
                    return tuberiaArribaY;
                } else if (opcion == 2) {
                    tuberiaAbajoY = 230;
                    return tuberiaAbajoY;
                }
                break;
            case 2:
                if (opcion == 1) {
                    tuberiaArribaY = -100;
                    return tuberiaArribaY;
                } else if (opcion == 2) {
                    tuberiaAbajoY = 300;
                    return tuberiaAbajoY;
                }
                break;
            case 3:
                if (opcion == 1) {
                    tuberiaArribaY = -50;
                    return tuberiaArribaY;
                } else if (opcion == 2) {
                    tuberiaAbajoY = 350;
                    return tuberiaAbajoY;
                }
                break;
            case 4:
                if (opcion == 1) {
                    tuberiaArribaY = -20;
                    return tuberiaArribaY;
                } else if (opcion == 2) {
                    tuberiaAbajoY = 380;
                    return tuberiaAbajoY;
                }
                break;
            case 5:
                if (opcion == 1) {
                    tuberiaArribaY = -150;
                    return tuberiaArribaY;
                } else if (opcion == 2) {
                    tuberiaAbajoY = 300;
                    return tuberiaAbajoY;
                }
                break;
            case 6:
                if (opcion == 1) {
                    tuberiaArribaY = -200;
                    return tuberiaArribaY;
                } else if (opcion == 2) {
                    tuberiaAbajoY = 250;
                    return tuberiaAbajoY;
                }
                break;
            case 7:
                if (opcion == 1) {
                    tuberiaArribaY = -250;
                    return tuberiaArribaY;
                } else if (opcion == 2) {
                    tuberiaAbajoY = 200;
                    return tuberiaAbajoY;
                }
                break;
            default:
                break;
        }
        return 0;
    }
}
