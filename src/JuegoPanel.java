import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class JuegoPanel extends JPanel implements KeyListener {
    private Pajaro pajaro;
    private boolean saltoEnProceso = false;
    private BufferedImage fondo;

    public JuegoPanel() {
        pajaro = new Pajaro(200, 200, 2, 0);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        try {
            fondo = ImageIO.read(getClass().getResource("/img/fondo.jpg"));
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
        if (saltoEnProceso) {
            pajaro.saltar();
        } else {
            pajaro.bajar();
        }
    }
}

