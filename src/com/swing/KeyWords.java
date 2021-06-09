package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyWords extends JPanel {
    public static final String DB_NAME_KEYWORDS = "KeyWords";
    static String lectie;
    Datasource datasource;
    private JButton thisButton;
    private JButton finalButton;
    private JButton superButton;
    private JButton backButton;
    private JButton testButton;
    private JLabel label;

    public KeyWords() {
        Listener listener = new Listener();

        setLayout(null);
        setSize(600, 600);

        datasource = new Datasource();

        label = new JLabel("Keywords");
        label.setLocation(220, 1);
        label.setSize(100, 100);
        label.setFont(new Font("Courier", Font.BOLD, 20));
        add(label);

        thisButton = new JButton("This keyword");
        thisButton.setLocation(1, 100);
        thisButton.setSize(120, 25);
        thisButton.addActionListener(listener);
        add(thisButton);


        superButton = new JButton("Super keyword");
        superButton.setLocation(1, 125);
        superButton.setSize(120, 25);
        superButton.addActionListener(listener);
        add(superButton);

        finalButton = new JButton("Final keyword");
        finalButton.setLocation(1, 150);
        finalButton.setSize(120, 25);
        finalButton.addActionListener(listener);
        add(finalButton);

        testButton = new JButton("Test");
        testButton.setLocation(1, 200);
        testButton.setSize(120, 25);
        testButton.addActionListener(listener);
        if (datasource.checkLessons(LoginForm.aux, "Keywords") &&
                datasource.getQuestions("KeyWords").size() > 0) {
            testButton.setEnabled(true);
        } else testButton.setEnabled(false);
        add(testButton);

        backButton = new JButton("Back");
        backButton.setSize(100, 25);
        backButton.setLocation(1, 1);
        backButton.addActionListener(listener);
        add(backButton);
    }


    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == superButton) {
                lectie = superButton.getText();
                if (!datasource.checkLessons(LoginForm.aux, "Keywords")) {
                    datasource.setLesson(LoginForm.aux, "Keywords");
                    removeAll();
                    revalidate();
                    repaint();
                    add(new KeyWords());
                }
                if (!datasource.checkLessons(LoginForm.aux, lectie)) {
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }
                SuperKeyword superKeyword = new SuperKeyword();
                superKeyword.setVisible(true);
            } else if (e.getSource() == finalButton) {
                lectie = finalButton.getText();
                if (!datasource.checkLessons(LoginForm.aux, "Keywords")) {
                    datasource.setLesson(LoginForm.aux, "Keywords");
                    removeAll();
                    revalidate();
                    repaint();
                    add(new KeyWords());
                }
                if (!datasource.checkLessons(LoginForm.aux, lectie)) {
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }
                FinalKeyword finalKeyword = new FinalKeyword();
                finalKeyword.setVisible(true);
            } else if (e.getSource() == thisButton) {
                lectie = thisButton.getText();
                if (!datasource.checkLessons(LoginForm.aux, "Keywords")) {
                    datasource.setLesson(LoginForm.aux, "Keywords");
                    removeAll();
                    revalidate();
                    repaint();
                    add(new KeyWords());
                }
                if (!datasource.checkLessons(LoginForm.aux, lectie)) {
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }
                ThisKeyword thisKeyword = new ThisKeyword();
                thisKeyword.setVisible(true);
            } else if (e.getSource() == backButton) {
                removeAll();
                revalidate();
                repaint();
                add(new LessonsPage());
            } else if (e.getSource() == testButton) {
                Test.quiz = "Key Words";
                removeAll();
                revalidate();
                repaint();
                add(new Test(DB_NAME_KEYWORDS));
            }
        }
    }
}
