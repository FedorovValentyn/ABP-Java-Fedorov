package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab6 extends JFrame {

    private JPanel jPanel1; // Add this line to declare the JPanel

    public Lab6() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JButton drawPolylineButton = new JButton("Намалювати ламану");
        JButton drawArcButton = new JButton("Намалювати дугу");
        JButton drawLineButton = new JButton("Намалювати лінію");

        jPanel1 = new JPanel(); // Instantiate the JPanel

        drawPolylineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = jPanel1.getGraphics();
                int[] xPoints = {50, 100, 150, 200};
                int[] yPoints = {50, 100, 50, 100};
                int numberOfPoints = 4;

                g.drawPolyline(xPoints, yPoints, numberOfPoints);
            }
        });

        drawArcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = jPanel1.getGraphics();
                g.drawArc(0, 20, 300, 300,35,90);
            }
        });

        drawLineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement code to draw a line
                // For example, you can use Graphics2D to draw on a JPanel
                Graphics g = jPanel1.getGraphics();
                g.drawLine(100, 100, 300, 300);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(drawPolylineButton)
                                        .addComponent(drawArcButton)
                                        .addComponent(drawLineButton))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(drawPolylineButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(drawArcButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(drawLineButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    public static void lab6() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab6().setVisible(true);
            }
        });
    }
}
