package com.swing;

import model.Datasource;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuestionForm extends JFrame {
    private JLabel question;
    private JLabel corrAnwer;
    private JLabel WrongAnswer;
    private JLabel WrongAnswer2;
    private JTextField corrAnswerField;
    private JTextField wrongAnswerField;
    private JTextField wrongAnswer2Field;
    private JTextField questionField;
    private JComboBox tests;
    private Datasource datasource;
    private JButton addButton;
    private JPanel panel;



    public AddQuestionForm(){
        setLayout(null);
        setSize(600, 600);

        datasource = new Datasource();

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(600,600);

        addButton = new JButton("Add question");
        addButton.setSize(120,30);
        addButton.setLocation(200,500);
        addButton.addActionListener(new Listener());
        panel.add(addButton);

        tests = new JComboBox();
        tests.setSize(300,30);
        tests.setLocation(200,10);
        tests.addItem("Basics");
        tests.addItem("KeyWords");
        tests.addItem("OOPConcepts");
        panel.add(tests);

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

    private class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(questionField.getText().isBlank() || corrAnswerField.getText().isBlank() ||
             wrongAnswer2Field.getText().isBlank() || wrongAnswerField.getText().isBlank()){
                JOptionPane.showMessageDialog(new JFrame(), "Fields cannot be blank!"
                        , "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if( datasource.addQuestion(questionField.getText(),corrAnswerField.getText(),wrongAnswerField.getText(),
                    wrongAnswer2Field.getText(),tests.getSelectedItem().toString())){
                JOptionPane.showMessageDialog(new JFrame(), "Question added!"
                        , "", JOptionPane.PLAIN_MESSAGE);
            }else  JOptionPane.showMessageDialog(new JFrame(), "Question already exists!"
                    , "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
