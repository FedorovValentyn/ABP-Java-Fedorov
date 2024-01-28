package MyPackage;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private JLabel label;
    public Panel() {
        label = new JLabel("Valentyn Fedorov");
        label.setFont(new Font("Serif", Font.ITALIC + Font.BOLD,20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLUE);
        this.add(label);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);             // Щоб очисти панельку перед малюванням

        g.setColor(Color.BLUE);
        g.fillRect(200, 200, 200, 200);

        Polygon triangle = new Polygon();
        triangle.addPoint(200, 400);
        triangle.addPoint(400, 400);
        triangle.addPoint(300, 200);

        g.setColor(Color.GREEN);
        g.fillPolygon(triangle);


        g.setColor(Color.RED);
        g.fillOval(225, 225, 150, 150);
    }

}

