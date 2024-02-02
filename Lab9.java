package MyPackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Lab9 extends JFrame {
    private final DefaultTableModel tableModel;
    private final JTable table;

    public Lab9() {
        super("Магазин одягу");


        try {                                       //хз шо це, але в індусів таке було, воно ніби й не мішає
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Shop".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        setSize(600, 400);                                                              // сетаєм фрейм
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        tableModel = new DefaultTableModel();                                                               // створюємо таблицю з відповідними назвами колонок
        String[] columnNames = {"ID", "Available", "Bought", "Sold", "Name", "Price"};
        tableModel.setColumnIdentifiers(columnNames);


        loadFromDatabase();                                                                                 // завантажуємо дані з ДБ


        table = new JTable(tableModel);                                                                            //ініціалізуємо таблицю


        JScrollPane scrollPane = new JScrollPane(table);                                                        // скрол панелька і її розміри
        scrollPane.setPreferredSize(new Dimension(300, 300));
        add(scrollPane, BorderLayout.CENTER);


        JButton addButton = new JButton("Додати запис");                                                    //додаємо кнопки для модифікації таблиці
        JButton deleteButton = new JButton("Видалити запис");


        JPanel buttonPanel = new JPanel();                                                                          // розміщуємо кнопки на панельці
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {                                                            // додаємо зчитувача дій над кнопками і функцій , які будуть виконуватись при натисканні
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
    }

    private void loadFromDatabase() {                                                                                       // метод для конекта до ДБ
        String url = "jdbc:mysql://localhost:3306/fedorov";
        String username = "root";
        String password = "Valik25122005!";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM shop")) {

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");                                                                    //прописую всі колонки з ДБ і додатково виводжу в консольку
                String isAviable = resultSet.getString("isAviable");
                String wasBought = resultSet.getString("wasBought");
                String wasSold = resultSet.getString("wasSold");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");

                System.out.println("Виведенно рядок: " + id + ", " + isAviable + ", " + wasBought + ", " + wasSold + ", " + name + ", " + price);

                tableModel.addRow(new Object[]{id, isAviable, wasBought, wasSold, name, price});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRecord() {
        String newName = JOptionPane.showInputDialog(this, "Введіть назву:");
        String newPrice = JOptionPane.showInputDialog(this, "Введіть ціну:");
        String newId = JOptionPane.showInputDialog(this, "Введіть ID:");
        String newWasBought = JOptionPane.showInputDialog(this, "Введіть кількість, яку було поставлено:");
        String newSold = JOptionPane.showInputDialog(this, "Введіть кількість, яку продали:");
        String newIsAviable = JOptionPane.showInputDialog(this, "Введіть 1 чи доступний товар для купівлі:");

        String url = "jdbc:mysql://localhost:3306/fedorov";
        String username = "root";
        String password = "Valik25122005!";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Check if the ID already exists
            PreparedStatement checkStmt = connection.prepareStatement("SELECT COUNT(*) FROM shop WHERE id = ?");
            checkStmt.setString(1, newId);
            ResultSet resultSet = checkStmt.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Запис з таким ID вже існує.", "Помилка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO shop (name, price, id, wasBought, wasSold, isAviable) VALUES (?, ?, ?, ?, ?, ?)");
            insertStmt.setString(1, newName);
            insertStmt.setString(2, newPrice);
            insertStmt.setString(3, newId);
            insertStmt.setString(4, newWasBought);
            insertStmt.setString(5, newSold);
            insertStmt.setString(6, newIsAviable);
            insertStmt.executeUpdate();

            loadFromDatabase();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Помилка при додаванні запису: " + e.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteRecord() {                                                                                                       // метод видалення рядків з таблиці
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Виберіть рядок для видалення.", "Помилка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idToDelete = (int) tableModel.getValueAt(selectedRow, 0);

        String url = "jdbc:mysql://localhost:3306/fedorov";
        String username = "root";
        String password = "Valik25122005!";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM shop WHERE id = ?")) {

            preparedStatement.setInt(1, idToDelete);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Рядок успішно видалений.");
                loadFromDatabase();
            } else {
                JOptionPane.showMessageDialog(this, "Рядок не було видалено.", "Помилка", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Помилка при видаленні запису: " + e.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }


    static void lab9() {
        SwingUtilities.invokeLater(() -> {
            new Lab9().setVisible(true);
        });
    }
}
