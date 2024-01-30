package MyPackage;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab10 extends JFrame {                                  //Варіант 12
    private JTextArea textArea;
    private JComboBox<String> fontComboBox;
    private JComboBox<Integer> sizeComboBox;

    public Lab10() {
        super("Text Editor");

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontComboBox = new JComboBox<>(fontNames);

        Integer[] fontSizes = {8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40};
        sizeComboBox = new JComboBox<>(fontSizes);

        JButton saveButton = new JButton("Зберегти");
        JButton openButton = new JButton("Відкрити");

        JPanel controlPanel = new JPanel();
        controlPanel.add(fontComboBox);
        controlPanel.add(sizeComboBox);
        controlPanel.add(saveButton);
        controlPanel.add(openButton);

        add(controlPanel, BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFont();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFont();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFont();
            }
        });
    }

    private void updateFont() {
        String selectedFont = (String) fontComboBox.getSelectedItem();
        int selectedSize = (int) sizeComboBox.getSelectedItem();

        Font newFont = new Font(selectedFont, Font.PLAIN, selectedSize);
        textArea.setFont(newFont);
    }

    private void saveToFile() {
        try {
            String text = textArea.getText();

            String selectedFont = (String) fontComboBox.getSelectedItem();
            int selectedSize = (int) sizeComboBox.getSelectedItem();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT.txt"))) {
                writer.write("Font: " + selectedFont + "\n");
                writer.write("Size: " + selectedSize + "\n\n");
                writer.write(text);
            }

            JOptionPane.showMessageDialog(this, "Текст успішно збережено у файл OUTPUT.txt", "Інформація", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Помилка при збереженні файлу", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openFile() {
        try {
            Path filePath = Paths.get("OUTPUT.txt");
            String fileContent = new String(Files.readAllBytes(filePath));

            textArea.setText(fileContent);
            JOptionPane.showMessageDialog(this, "Текст успішно відкрито з файлу OUTPUT.txt", "Інформація", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Помилка при відкритті файлу", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void lab10() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab10().setVisible(true);
            }
        });
    }
}
