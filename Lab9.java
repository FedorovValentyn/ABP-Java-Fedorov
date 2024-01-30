package MyPackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Lab9 extends JFrame {                           //Варіант 12
    private JTable table;
    private DefaultTableModel tableModel;

    public Lab9() {

        super("Магазин одягу");


        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);


        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);


        JButton addButton = new JButton("Додати запис");
        JButton deleteButton = new JButton("Видалити запис");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);


        add(buttonPanel, BorderLayout.SOUTH);


        addButton.addActionListener(new ActionListener() {
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


        loadFromDatabase();
    }

    private void loadFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "Valik25122005!";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM shop")) {

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String isAviable = resultSet.getString("isAviable");
                String wasBought = resultSet.getString("wasBought");
                String wasSold = resultSet.getString("wasSold");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");

                tableModel.addRow(new Object[]{id, isAviable, wasBought, wasSold, name, price});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRecord() {

    }

    private void deleteRecord() {
        
    }

    public static void lab9() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab9().setVisible(true);
            }
        });
    }
}
