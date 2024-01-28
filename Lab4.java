package MyPackage;

import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;

public class Lab4 extends JFrame {
    public static void lab4() {
        JFrame frame = new JFrame("Shapes");
        frame.setSize(600,600);
        frame.setLocation(500,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel());
        frame.setVisible(true);
    }
}
