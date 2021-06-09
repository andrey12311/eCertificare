package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Basics extends JPanel {

    public static final String DB_NAME = "Basics";
    private JButton dataTypesButton;
    private JButton loopsButton;
    private JButton statementsButton;
    private JButton backButton;
    private JButton testButton;
    private JLabel basicsLabel;
    static String lectie;
    Datasource datasource;

    public Basics() {
        Listener listener = new Listener();

        setLayout(null);
        setSize(600, 600);
        datasource = new Datasource();

        basicsLabel = new JLabel("Basics");
        basicsLabel.setLocation(220, 1);
        basicsLabel.setSize(100, 100);
        basicsLabel.setFont(new Font("Courier", Font.BOLD, 20));
        add(basicsLabel);

        dataTypesButton = new JButton("Data Types");
        dataTypesButton.setLocation(1, 100);
        dataTypesButton.setSize(120, 25);
        dataTypesButton.addActionListener(listener);
        add(dataTypesButton);


        loopsButton = new JButton("Loops");
        loopsButton.setLocation(1, 125);
        loopsButton.setSize(120, 25);
        loopsButton.addActionListener(listener);
        add(loopsButton);

        statementsButton = new JButton("Statements");
        statementsButton.setLocation(1, 150);
        statementsButton.setSize(120, 25);
        statementsButton.addActionListener(listener);
        add(statementsButton);

        testButton = new JButton("Test");
        testButton.setLocation(1, 200);
        testButton.setSize(120, 25);
        testButton.addActionListener(listener);
        if(datasource.checkLessons(LoginForm.aux,"Basics")){
            testButton.setEnabled(true);
        }else testButton.setEnabled(false);
        add(testButton);

        backButton = new JButton("Back");
        backButton.setSize(100, 25);
        backButton.setLocation(1, 1);
        backButton.addActionListener(listener);
        add(backButton);
    }

    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == statementsButton) {
                lectie=statementsButton.getText();
                if(!datasource.checkLessons(LoginForm.aux,"Basics")) {
                    datasource.setLesson(LoginForm.aux, "Basics");
                    removeAll();
                    revalidate();
                    repaint();
                    add(new Basics());
                }
                if(!datasource.checkLessons(LoginForm.aux,lectie)){
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }
                Statements statements = new Statements();
                statements.setVisible(true);
            } else if (e.getSource() == loopsButton) {
                lectie=loopsButton.getText();
                if(!datasource.checkLessons(LoginForm.aux,"Basics")) {
                    datasource.setLesson(LoginForm.aux, "Basics");
                    removeAll();
                    revalidate();
                    repaint();
                    add(new Basics());
                }
                if(!datasource.checkLessons(LoginForm.aux,lectie)){
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }
                Loops loops = new Loops();
                loops.setVisible(true);
            } else if (e.getSource() == dataTypesButton) {
                lectie=dataTypesButton.getText();
                if(!datasource.checkLessons(LoginForm.aux,"Basics")) {
                    datasource.setLesson(LoginForm.aux, "Basics");
                    removeAll();
                    revalidate();
                    repaint();
                    add(new Basics());
                }
                if(!datasource.checkLessons(LoginForm.aux,lectie)){
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }
                DataTypes dataTypes = new DataTypes();
                dataTypes.setVisible(true);
            } else if (e.getSource() == backButton) {
                LessonsPage lessonsPage = new LessonsPage();
                removeAll();
                revalidate();
                repaint();
                add(lessonsPage);
            } else if (e.getSource() == testButton) {
                Test.quiz = "Basics";
                removeAll();
                revalidate();
                repaint();
                add(new Test(DB_NAME));
            }
        }
    }
}
