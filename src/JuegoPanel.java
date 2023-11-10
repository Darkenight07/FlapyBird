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
    public boolean saltoEnProceso = false;
    private BufferedImage fondo;
    public BufferedImage tuberiaArribaImg;
    public BufferedImage tuberiaAbajoImg;
    public int puntos = 0;
    
    public JuegoPanel(JFrame frame) {
        pajaro = new Pajaro(90, 90, 2, 0);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        tuberiaArriba = new TuberiaArriba(500, 0, 2);
        tuberiaAbajo = new TuberiaAbajo(500, 300, 2);
        

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
                    puntos = pajaro.puntos(tuberiaArriba.getX(),tuberiaArriba.getY(),tuberiaAbajo.getX(),tuberiaAbajo.getY(),puntos);
                    frame.setTitle("Flappy Bird | Puntos: " + puntos);

                    repaint();
                    try {
                        Thread.sleep(10); // 10 milisegundos de pausa
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    actualizar();
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
            g.drawImage(tuberiaArribaImg, tuberiaArriba.getX(), tuberiaArriba.getY(), 90, 300, this);
            g.drawImage(tuberiaAbajoImg, tuberiaAbajo.getX(), tuberiaAbajo.getY(), 90, 300, this);
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

        // TUBERIA DE ARRIBA

        if (tuberiaArriba.getX() == 500) {
            tuberiaArriba.setY(tuberiaArriba.posicionAleatoriaY());
        } else if (tuberiaArriba.getX() < -90) {
            tuberiaArriba.setX(500);
            tuberiaArriba.setY(tuberiaArriba.posicionAleatoriaY());
        }

        tuberiaArriba.movimientoX();


        // TUBERIA DE ABAJO

        if (tuberiaAbajo.getX() == 500) {
            tuberiaAbajo.setY(tuberiaAbajo.poscionAleatoriaY());
        } else if (tuberiaAbajo.getX() < -90) {
            tuberiaAbajo.setX(500);
            tuberiaAbajo.setY(tuberiaAbajo.poscionAleatoriaY());
        }

        tuberiaAbajo.movimientoX();


        // PAJARO
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
