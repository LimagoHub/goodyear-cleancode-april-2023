package de.limago;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {


    public Main()  {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                beenden();
            }
        });
        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(e->ausgabe());
        add(button);
    }



    public static void main(String[] args) {

        new Main().setVisible(true);
    }

    private void ausgabe() {
        System.out.println("xxxxx");
    }

    private void beenden() {
        // Aufraeumen
        dispose();
    }






}
