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

public class Lab10 extends JFrame {
    private JTextArea textArea;
    private JComboBox<String> fontComboBox;
    private JComboBox<Integer> sizeComboBox;

    public Lab10() {
        // Заголовок вікна
        super("Text Editor");

        // Ініціалізація та встановлення розмірів вікна
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ініціалізація компонентів
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Створення ComboBox для шрифту
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontComboBox = new JComboBox<>(fontNames);

        // Створення ComboBox для розміру шрифту
        Integer[] fontSizes = {8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40};
        sizeComboBox = new JComboBox<>(fontSizes);

        // Створення кнопок для збереження та відкриття файлу
        JButton saveButton = new JButton("Зберегти");
        JButton openButton = new JButton("Відкрити");

        // Додавання компонентів на панель
        JPanel controlPanel = new JPanel();
        controlPanel.add(fontComboBox);
        controlPanel.add(sizeComboBox);
        controlPanel.add(saveButton);
        controlPanel.add(openButton);

        // Додавання панелі з контрольними елементами вниз вікна
        add(controlPanel, BorderLayout.SOUTH);

        // Додавання текстового поля на вікно
        add(scrollPane, BorderLayout.CENTER);

        // Додавання обробників подій
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

        // Додавання обробника подій для текстового поля для відслідковування змін
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
        // Отримання обраного шрифту та розміру з ComboBox
        String selectedFont = (String) fontComboBox.getSelectedItem();
        int selectedSize = (int) sizeComboBox.getSelectedItem();

        // Встановлення стилю шрифта для текстового поля
        Font newFont = new Font(selectedFont, Font.PLAIN, selectedSize);
        textArea.setFont(newFont);
    }

    private void saveToFile() {
        try {
            // Отримання введеного тексту
            String text = textArea.getText();

            // Отримання обраного шрифту та розміру з ComboBox
            String selectedFont = (String) fontComboBox.getSelectedItem();
            int selectedSize = (int) sizeComboBox.getSelectedItem();

            // Збереження тексту разом із характеристиками шрифта в файл "OUTPUT.txt"
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
            // Зчитування тексту з файлу "OUTPUT.txt"
            Path filePath = Paths.get("OUTPUT.txt");
            String fileContent = new String(Files.readAllBytes(filePath));

            // Відображення тексту та характеристик шрифта у вікні редактора
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
