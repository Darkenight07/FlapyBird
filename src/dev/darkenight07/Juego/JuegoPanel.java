package dev.darkenight07.Juego;

import dev.darkenight07.Juego.Entidades.Pajaro;
import dev.darkenight07.Juego.Entidades.Tuberia;
import dev.darkenight07.Juego.Utilidades.Utilidades;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;
import java.util.Timer;
import java.util.TimerTask;


public class JuegoPanel extends JPanel implements KeyListener {
    @Serial
    private static final long serialVersionUID = 1L;

    // Objetos
	private Pajaro pajaro;
    private Tuberia tuberiaArriba;
    private Tuberia tuberiaAbajo;
    private boolean saltoEnProceso = false;

    // Imagenes
    private BufferedImage fondo;
    private BufferedImage tuberiaArribaImg;
    private BufferedImage tuberiaAbajoImg;
    private BufferedImage pajaroImg;

    // Variables
    private int puntos = 0;
    private int vecesSaltadas = 0;
    private int numeroAleatorio = 0;
    public JuegoPanel(JFrame frame) {
        pajaro = new Pajaro(90, 90, 2);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        tuberiaArriba = new Tuberia(500, 0, 2);
        tuberiaAbajo = new Tuberia(500, 300, 2);
        

        try {
            fondo = ImageIO.read(getClass().getResource("../../../assets/img/fondo.jpg"));
            tuberiaArribaImg = ImageIO.read(getClass().getResource("../../../assets/img/tuberia_arriba.png"));
            tuberiaAbajoImg = ImageIO.read(getClass().getResource("../../../assets/img/tuberia_abajo.png"));
            pajaroImg = ImageIO.read(getClass().getResource("../../../assets/img/pajaro.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                puntos = pajaro.puntos(tuberiaArriba.getX(),tuberiaArriba.getY(),tuberiaAbajo.getX(),tuberiaAbajo.getY(),puntos);
                frame.setTitle("Flappy Bird | Puntos: " + puntos);
                repaint();

                actualizar();
                
                try {
                    Thread.sleep(10); // 10 milisegundos de pausa
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(timerTask, 0, 10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fondo != null) {
            // Dibuja el fondo
            g.drawImage(fondo,0, 0, getWidth(),getHeight(), this);
            // Dibuja la tuberia
            g.drawImage(tuberiaArribaImg, tuberiaArriba.getX(), tuberiaArriba.getY(), 90, 300, this);
            g.drawImage(tuberiaAbajoImg, tuberiaAbajo.getX(), tuberiaAbajo.getY(), 90, 300, this);
            // Dibuja el pajaro
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(Math.toRadians(pajaro.getAngulo()), pajaro.getX() + 17, pajaro.getY() + 10);
            g2d.drawImage(pajaroImg, pajaro.getX(), pajaro.getY(), 35, 20, this);
            g2d.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se usa
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            saltoEnProceso = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            saltoEnProceso = false;
        }
    }

    public void actualizar() {
        // TUBERIA DE ARRIBA

        // Cuanto menos sea el numero, mas arriba estara la tuberia
        if (tuberiaArriba.getX() == 500) {
            numeroAleatorio = Utilidades.generarNumeroAleatorio(1,7);
            tuberiaArriba.setY(GeneracionTuberias.generacionTuberias(tuberiaArriba.getY(),tuberiaAbajo.getY(),1,numeroAleatorio));
            System.out.println(numeroAleatorio);
        } else if (tuberiaArriba.getX() < -90) {
            tuberiaArriba.setX(500);
            numeroAleatorio = Utilidades.generarNumeroAleatorio(1,7);
            tuberiaArriba.setY(GeneracionTuberias.generacionTuberias(tuberiaArriba.getY(),tuberiaAbajo.getY(),1,numeroAleatorio));
            System.out.println(numeroAleatorio);
        }

        tuberiaArriba.movimientoX();

        // TUBERIA DE ABAJO

        // Cuanto mas sea el numero, mas abajo estara la tuberia
        if (tuberiaAbajo.getX() == 500) {
            tuberiaAbajo.setY(GeneracionTuberias.generacionTuberias(tuberiaArriba.getY(),tuberiaAbajo.getY(),2,numeroAleatorio));
        } else if (tuberiaAbajo.getX() < -90) {
            tuberiaAbajo.setX(500);
            tuberiaAbajo.setY(GeneracionTuberias.generacionTuberias(tuberiaArriba.getY(),tuberiaAbajo.getY(),2,numeroAleatorio));
        }

        tuberiaAbajo.movimientoX();

        // PAJARO && ROTACION

        if (saltoEnProceso) {
            if (pajaro.getVecesSalto() < pajaro.getVeces()) {
                pajaro.saltar();
                vecesSaltadas++;
                if (vecesSaltadas > 3) {
                    pajaro.setAngulo(-30);
                }
            } else {
                pajaro.bajar();
            }
        } else {
            pajaro.bajar();
            pajaro.setVecesSalto(0);
            vecesSaltadas = 0;
        }

        if (System.currentTimeMillis() - pajaro.ultimoSalto >= 1000) {
            int angulo = pajaro.getAngulo();
            angulo -= 30;
            pajaro.setAngulo(angulo);
        }
    }
}
