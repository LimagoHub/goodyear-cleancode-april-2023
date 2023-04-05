package de.limago.gui;

import de.limago.math.Complex;
import de.limago.math.Mandelbrot;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;


public class MandelbrotView extends Frame {

    private static final int SIZE = 2048;


    private Mandelbrot mandelbrot = new Mandelbrot();

    //private final BufferedImage image = new BufferedImage(SIZE,SIZE, BufferedImage.TYPE_INT_RGB);

    public MandelbrotView() {
        addMouseListener(new MyMouseListener());
        setSize(SIZE,SIZE);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });


    }




    @Override
    public void paint(Graphics g) {

        long ende, start = System.currentTimeMillis();
        for(int x = 0 ; x < SIZE ; x ++ ){
            for(int y = 0; y < SIZE; y ++) {
                int i = mandelbrot.iterate(mandelbrot.createC(x, y, SIZE));

                g.setColor(new Color((i * 3) % 256, (i * 5) % 256, (i * 11) % 256));

                g.drawLine(x, y, x+1, y+1);
            }
        }
        ende = System.currentTimeMillis();
        System.out.println("Duration = " + (ende -start));
    }

    public static void main(String[] args) {
        new MandelbrotView().setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {
        Complex linkeUntereEcke ;
        Stack<Mandelbrot> stack = new Stack<Mandelbrot>();
        @Override
        public void mousePressed(MouseEvent e) {
            linkeUntereEcke = mandelbrot.createC(e.getX(), e.getY(), SIZE);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                Complex rechteObereEcke = mandelbrot.createC(e.getX(), e.getY(), SIZE);
                double breite = rechteObereEcke.re() - linkeUntereEcke.re();
                double hoehe = rechteObereEcke.im() - linkeUntereEcke.im();
                stack.push(mandelbrot);
                mandelbrot = new Mandelbrot(linkeUntereEcke, breite > hoehe? breite :hoehe);
            } else {
                if(! stack.isEmpty()) {
                    mandelbrot = stack.pop();
                }
            }


            repaint();

        }

    }
}
