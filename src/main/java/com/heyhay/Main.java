package com.heyhay;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Main {


    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.setSize(400,500);
        frame.setLocationRelativeTo(null);
        RoundedRectangle roundedRectangle = new RoundedRectangle(20,10,300,25,4,100,100,100);

        JComponent component = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.BLUE);
                g2.setStroke(new BasicStroke(3));
                g2.fill(roundedRectangle.getShape()); // fill the shape with blue color
                g2.setColor(Color.BLACK);
                g2.draw(roundedRectangle.getShape());
                g2.setColor(Color.GREEN);
                g2.draw(new RoundRectangle2D.Float(20,10,300,50,100,100));
            }
        };
        frame.add(component);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}