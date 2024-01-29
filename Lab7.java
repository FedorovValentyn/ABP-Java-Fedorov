package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab7 extends JFrame {

    private JLabel questionLabel;
    private JButton[] answerButtons;
    private int currentQuestionIndex;

    private String[] questions = {"Хто з перелічених людей обіймає посаду завідувача кафедри Прикладних Інформаційних Систем?"};

    private String[][] answerChoices = {
            {"Майкл Джексон", "Плескач В.Л", "Чон Джунгук (той, що з BTS)", "Порошенко П.О"}
    };

    private String[] correctAnswers = {"Плескач В.Л"};

    public Lab7() {
        initComponents();
        showQuestion(0);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionLabel = new JLabel();
        answerButtons = new JButton[4];

        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].addActionListener(new AnswerButtonListener());
        }

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(answerButtons[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(answerButtons[1], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(answerButtons[2], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(answerButtons[3], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(questionLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerButtons[0])
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerButtons[1])
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerButtons[2])
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerButtons[3])
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void showQuestion(int index) {
        if (index < questions.length) {
            questionLabel.setText(questions[index]);

            for (int i = 0; i < answerButtons.length; i++) {
                answerButtons[i].setText(answerChoices[index][i]);
            }

            currentQuestionIndex = index;
        } else {
            // Display a message or perform some action when all questions are answered
            JOptionPane.showMessageDialog(this, "Вітаю,ти провдожуєш своє навчання на ПП.");
            System.exit(0);
        }
    }

    private class AnswerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            String selectedAnswer = clickedButton.getText();

            if (selectedAnswer.equals(correctAnswers[currentQuestionIndex])) {
                JOptionPane.showMessageDialog(Lab7.this, "Правильно! Партія пишається тобою! Ось твої додаткові 5 балів від лелеченят");
            } else {
                JOptionPane.showMessageDialog(Lab7.this, "Ти розчарував партію! Тебе вигнано до КБшників");
                System.exit(0);
            }

            // Move to the next question
            showQuestion(currentQuestionIndex + 1);
        }
    }

    public static void lab7() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab7().setVisible(true);
            }
        });
    }
}
