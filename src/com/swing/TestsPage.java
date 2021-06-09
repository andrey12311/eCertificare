package com.swing;

import model.Datasource;
import model.Examen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestsPage extends JFrame {

    Examen examen;
    private JLabel question;
    private JLabel corrAnwer;
    private JLabel WrongAnswer;
    private JLabel WrongAnswer2;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextField corrAnswerField;
    private JTextField wrongAnswerField;
    private JTextField wrongAnswer2Field;
    private JTextField questionField;
    private JComboBox tests;
    private Datasource datasource;
    private JPanel panel;

    public TestsPage() {
        setLayout(null);
        setSize(600, 600);
        Listener listener = new Listener();

        datasource = new Datasource();

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(600, 600);

        tests = new JComboBox();
        tests.setSize(300, 30);
        tests.setLocation(200, 10);
        for (int i = 0; i < AdminPage.examene.size(); i++) {
            tests.addItem(AdminPage.examene.get(i).getQuestion());
        }
        tests.addActionListener(listener);
        panel.add(tests);

        updateButton = new JButton("Update");
        updateButton.setLocation(300, 300);
        updateButton.setSize(125, 25);
        updateButton.addActionListener(listener);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setLocation(400, 300);
        deleteButton.setSize(125, 25);
        deleteButton.addActionListener(listener);
        panel.add(deleteButton);

        question = new JLabel("Question:");
        question.setSize(100, 10);
        question.setLocation(40, 70);
        panel.add(question);

        questionField = new JTextField();
        questionField.setSize(400, 25);
        questionField.setLocation(150, 60);
        panel.add(questionField);

        corrAnwer = new JLabel("Correct Answer:");
        corrAnwer.setSize(200, 15);
        corrAnwer.setLocation(40, 100);
        panel.add(corrAnwer);

        corrAnswerField = new JTextField();
        corrAnswerField.setSize(200, 25);
        corrAnswerField.setLocation(150, 100);
        panel.add(corrAnswerField);

        WrongAnswer2 = new JLabel("Wrong answer 2:");
        WrongAnswer2.setSize(200, 15);
        WrongAnswer2.setLocation(40, 130);
        panel.add(WrongAnswer2);

        wrongAnswer2Field = new JTextField();
        wrongAnswer2Field.setSize(200, 25);
        wrongAnswer2Field.setLocation(150, 130);
        panel.add(wrongAnswer2Field);

        WrongAnswer = new JLabel("Wrong answer1:");
        WrongAnswer.setSize(200, 15);
        WrongAnswer.setLocation(40, 160);
        panel.add(WrongAnswer);

        wrongAnswerField = new JTextField();
        wrongAnswerField.setSize(200, 25);
        wrongAnswerField.setLocation(150, 160);
        panel.add(wrongAnswerField);

        add(panel);
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tests) {
                examen = datasource.queryQuestion(tests.getSelectedItem().toString(), AdminPage.dataBase);
                questionField.setText(examen.getQuestion());
                wrongAnswer2Field.setText(examen.getWrAnswer2());
                wrongAnswerField.setText(examen.getWrAnswer());
                corrAnswerField.setText(examen.getCorrAnswer());
            } else if (e.getSource() == deleteButton) {
                datasource.deleteQuestion(tests.getSelectedItem().toString(), AdminPage.dataBase);
                tests.remove(tests.getSelectedIndex());
                AdminPage.examene.remove(tests.getSelectedIndex());
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                panel.add(new TestsPage().panel);
            } else if (e.getSource() == updateButton) {

                if (questionField.getText().equals("") || corrAnswerField.getText().equals("") ||
                        wrongAnswer2Field.getText().equals("") || wrongAnswerField.getText().equals("")) {
                    JOptionPane.showMessageDialog(new JFrame(), "Fields cannot be blank!"
                            , "", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                datasource.updateQuestion(tests.getSelectedItem().toString(), questionField.getText(), corrAnswerField.getText()
                        , wrongAnswerField.getText(), wrongAnswer2Field.getText(), AdminPage.dataBase);

            }
        }
    }
}
