import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class JuegoPanel extends JPanel implements KeyListener {
    private Pajaro pajaro;
    private TuberiaArriba tuberiaArriba;
    private TuberiaAbajo tuberiaAbajo;
    private boolean saltoEnProceso = false;
    private BufferedImage fondo;
    public BufferedImage tuberiaArribaImg;
    public BufferedImage tuberiaAbajoImg;


    public JuegoPanel() {
        pajaro = new Pajaro(90, 90, 2, 0);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        tuberiaArriba = new TuberiaArriba(500, 0, 1);
        tuberiaAbajo = new TuberiaAbajo(700, 300, 1);


        try {
            fondo = ImageIO.read(getClass().getResource("/img/fondo.jpg"));
            tuberiaArribaImg = ImageIO.read(getClass().getResource("/img/tuberia_arriba.png"));
            tuberiaAbajoImg = ImageIO.read(getClass().getResource("/img/tuberia_abajo.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    actualizar();
                    repaint();
                    try {
                        Thread.sleep(10); // 10 milisegundos de pausa
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        hilo.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fondo != null) {
            // Dibuja el fondo
            g.drawImage(fondo,0, 0, getWidth(),getHeight(), this);
            // Dibuja la tuberia
            g.drawImage(tuberiaArribaImg, tuberiaArriba.getX(), tuberiaArriba.getY(), 90, 190, this);
            g.drawImage(tuberiaAbajoImg, tuberiaAbajo.getX(), tuberiaAbajo.getY(), 100, 300, this);
            // Dibuja el pajaro
            g.setColor(Color.BLACK);
            g.fillRect(pajaro.getX(), pajaro.getY(), 20, 20);
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
        int vecesTuberiaArriba = 0;
        int vecesTuberiaAbajo = 0;

        // TUBERIA ARRIBA
        if (tuberiaArriba.getX() == 500 && vecesTuberiaArriba == 0) {
            tuberiaArriba.setX(tuberiaArriba.posicionAleatoriaX());
            vecesTuberiaArriba++;
        } else if (tuberiaArriba.getX() >= 450 && tuberiaArriba.getX() <= 500 && vecesTuberiaArriba == 1) {
            vecesTuberiaArriba--;
        }
        tuberiaArriba.movimientoX();

        if (tuberiaArriba.getX() < -90 ) {
            tuberiaArriba.setX(tuberiaArriba.posicionAleatoriaX());
        }

        // TUBERIA ABAJO
        if (tuberiaAbajo.getX() == 700 && vecesTuberiaAbajo == 0) {
            tuberiaAbajo.setX(tuberiaAbajo.posicionAleatoriaX());
            vecesTuberiaAbajo++;
        } else if (tuberiaAbajo.getX() >= 600 && tuberiaAbajo.getX() <= 700 && vecesTuberiaAbajo == 1) {
            vecesTuberiaAbajo--;
        }

        tuberiaAbajo.movimientoX();

        if (tuberiaAbajo.getX() < -90 ) {
            tuberiaAbajo.setX(tuberiaAbajo.posicionAleatoriaX());
        }


        if (saltoEnProceso) {
            if (pajaro.vecesSalto < pajaro.veces) {
                pajaro.saltar();
            } else {
                pajaro.bajar();
            }
        } else {
            pajaro.bajar();
            pajaro.vecesSalto = 0;
        }

    }

}