package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Lab8 {
    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;

    public static void lab8() {                                  //Варіант 12
        EventQueue.invokeLater(() -> {
            try {
                Lab8 window = new Lab8();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Lab8() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Калькулятор");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        textField1 = new JTextField();
        textField1.setColumns(10);
        frame.getContentPane().add(textField1);

        textField2 = new JTextField();
        textField2.setColumns(10);
        frame.getContentPane().add(textField2);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menu = new JMenu("Дії");
        menuBar.add(menu);

        JMenuItem sumMenuItem = new JMenuItem("Сума");
        sumMenuItem.addActionListener(new CalculateMenuItemListener("Сума"));
        sumMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        menu.add(sumMenuItem);

        JMenuItem differenceMenuItem = new JMenuItem("Різниця");
        differenceMenuItem.addActionListener(new CalculateMenuItemListener("Різниця"));
        differenceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        menu.add(differenceMenuItem);

        JMenuItem productMenuItem = new JMenuItem("Добуток");
        productMenuItem.addActionListener(new CalculateMenuItemListener("Добуток"));
        productMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK));
        menu.add(productMenuItem);
    }

    private class CalculateMenuItemListener implements ActionListener {
        private final String operation;

        public CalculateMenuItemListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());

                double result;

                switch (operation) {
                    case "Сума":
                        result = num1 + num2;
                        break;
                    case "Різниця":
                        result = num1 - num2;
                        break;
                    case "Добуток":
                        result = num1 * num2;
                        break;
                    default:
                        result = 0;
                }

                JOptionPane.showMessageDialog(frame, "Результат " + operation + ": " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Чел ти... Введи вже ти цифри в калькулятор");
            }
        }
    }
}