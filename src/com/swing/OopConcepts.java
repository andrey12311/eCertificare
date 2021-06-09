package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OopConcepts extends JPanel {
    public static final String DB_NAME = "OOPConcepts";
    Datasource datasource;
    private JButton testButton;
    private JButton encapsulationButton;
    private JButton polymorphismButton;
    private JButton inheritenceButton;
    private JButton backButton;
    private JLabel label;
    static String lectie;

    public OopConcepts() {
        Listener listener = new Listener();

        setLayout(null);
        setSize(600, 600);

        datasource = new Datasource();

        label = new JLabel("OOP Concepts");
        label.setLocation(220, 1);
        label.setSize(200, 100);
        label.setFont(new Font("Courier", Font.BOLD, 20));
        add(label);

        inheritenceButton = new JButton("Inheritence");
        inheritenceButton.setLocation(1, 100);
        inheritenceButton.setSize(120, 25);
        inheritenceButton.addActionListener(listener);
        add(inheritenceButton);


        encapsulationButton = new JButton("Encapsulation");
        encapsulationButton.setLocation(1, 125);
        encapsulationButton.setSize(120, 25);
        encapsulationButton.addActionListener(listener);
        add(encapsulationButton);

        polymorphismButton = new JButton("Polymorphism");
        polymorphismButton.setLocation(1, 150);
        polymorphismButton.setSize(120, 25);
        polymorphismButton.addActionListener(listener);
        add(polymorphismButton);

        testButton = new JButton("Test");
        testButton.setLocation(1, 200);
        testButton.setSize(120, 25);
        testButton.addActionListener(listener);
        if (datasource.checkLessons(LoginForm.aux, "OopConcepts")) {
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
            lectie=inheritenceButton.getText();
            if (e.getSource() == inheritenceButton) {
                if(!datasource.checkLessons(LoginForm.aux,"OopConcepts")){
                        datasource.setLesson(LoginForm.aux, "OopConcepts");
                        removeAll();
                        revalidate();
                        repaint();
                        add(new OopConcepts());
                } if(!datasource.checkLessons(LoginForm.aux,lectie)){
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }

                Inheritence inheritence = new Inheritence();
                inheritence.setVisible(true);

            } else if (e.getSource() == encapsulationButton) {
                lectie=encapsulationButton.getText();
                if(!datasource.checkLessons(LoginForm.aux,"OopConcepts")){
                    datasource.setLesson(LoginForm.aux, "OopConcepts");
                    removeAll();
                    revalidate();
                    repaint();
                    add(new OopConcepts());
                }
                if(!datasource.checkLessons(LoginForm.aux,lectie)){
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }
                Encapsulation encapsulation = new Encapsulation();
                encapsulation.setVisible(true);

            } else if (e.getSource() == polymorphismButton) {
                lectie=polymorphismButton.getText();
                if(!datasource.checkLessons(LoginForm.aux,"OopConcepts")){
                    datasource.setLesson(LoginForm.aux, "OopConcepts");
                    removeAll();
                    revalidate();
                    repaint();
                    add(new OopConcepts());

                }
                if(!datasource.checkLessons(LoginForm.aux,lectie)){
                    QuestionFrame questionFrame = new QuestionFrame();
                    questionFrame.setLesson(lectie);
                    questionFrame.setVisible(true);
                }
                Polymorphism polymorphism = new Polymorphism();
                polymorphism.setVisible(true);
            } else if (e.getSource() == backButton) {
                LessonsPage lessonsPage = new LessonsPage();
                removeAll();
                revalidate();
                repaint();
                add(lessonsPage);
            } else if (e.getSource() == testButton) {
                Test.quiz="OOP Concepts";
                removeAll();
                revalidate();
                repaint();
                add(new Test(DB_NAME));

            }
        }
    }
}
