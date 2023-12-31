package dev.darkenight07.Juego;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String  [] args)  {
        JFrame frame = new JFrame("Flappy Bird | Puntos: " );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JuegoPanel panel = new JuegoPanel(frame);
        frame.add(panel, BorderLayout.CENTER);
        panel.requestFocusInWindow();

        // Siempre activo, es un bucle
        frame.setVisible(true);
    }
}