import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JuegoPanel extends JPanel implements KeyListener {
    private Pajaro pajaro;
    private boolean saltoEnProceso = false;

    public JuegoPanel() {
        pajaro = new Pajaro(200, 200, 1, 0);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    pajaro.bajar();

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
        g.setColor(Color.BLACK);
        g.fillRect(pajaro.getX(), pajaro.getY(), 20, 20);
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
        }
        pajaro.bajar();
    }
}

