package de.limago;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame{


    public Main()  {


        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(e->ausgabe());
        add(button);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                beenden();
            }
        });
    }

    private void beenden() {
        dispose();
    }

    private void ausgabe() {
        System.out.println("Button wurde gedrückt");
    }


    public static void main(String[] args) {

        new Main().setVisible(true);
    }




//    private class MyActionListerner implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("Button wurde gedrückt");
//        }
//    }

}
