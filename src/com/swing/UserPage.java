package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JPanel {
    private JButton myProfileButton;
    private JButton lessonsButton;
    private JButton historyButton;
    private JButton lessonsHistoryButton;

    public UserPage() {
        Listen listener = new Listen();
        setLayout(null);
        setSize(600, 600);

        myProfileButton = new JButton("My Profile");
        myProfileButton.setSize(125, 25);
        myProfileButton.setLocation(1, 100);
        myProfileButton.addActionListener(listener);
        this.add(myProfileButton);

        lessonsButton = new JButton("Chapters");
        lessonsButton.setSize(125, 25);
        lessonsButton.setLocation(1, 150);
        lessonsButton.addActionListener(listener);
        this.add(lessonsButton);

        historyButton = new JButton("Quiz history");
        historyButton.setLocation(1, 200);
        historyButton.setSize(125, 25);
        historyButton.addActionListener(listener);
        add(historyButton);

        lessonsHistoryButton = new JButton("Lessons history");
        lessonsHistoryButton.setSize(125, 25);
        lessonsHistoryButton.setLocation(1, 250);
        lessonsHistoryButton.addActionListener(listener);
        add(lessonsHistoryButton);
    }

    private class Listen implements ActionListener {
        Datasource datasource = new Datasource();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == myProfileButton) {
                UserProfile profile = new UserProfile();
                removeAll();
                revalidate();
                repaint();
                add(profile);

            } else if (e.getSource() == lessonsButton) {
                LessonsPage l = new LessonsPage();
                removeAll();
                revalidate();
                repaint();
                add(l);

            } else if (e.getSource() == historyButton) {
                HistoryPage historyPage = new HistoryPage();
                historyPage.setVisible(true);

            } else if (e.getSource() == lessonsHistoryButton) {
                LessonsHistory lessonsHistory = new LessonsHistory();
                if (datasource.checkLessons(LoginForm.aux, "Data Types")) {
                    lessonsHistory.setText("Data Types lesson \n");
                }
                if (datasource.checkLessons(LoginForm.aux, "Statements")) {
                    lessonsHistory.setText("Statements lesson \n");
                }
                if (datasource.checkLessons(LoginForm.aux, "Loops")) {
                    lessonsHistory.setText("Loops lesson \n");
                }
                if (datasource.checkLessons(LoginForm.aux, "Inheritence")) {
                    lessonsHistory.setText("Inheritence lesson \n");
                }
                if (datasource.checkLessons(LoginForm.aux, "Encapsulation")) {
                    lessonsHistory.setText("Encapsulation lesson \n");
                }
                if (datasource.checkLessons(LoginForm.aux, "Polymorphism")) {
                    lessonsHistory.setText("Polymorphism lesson \n");
                }
                if (datasource.checkLessons(LoginForm.aux, "This keyword")) {
                    lessonsHistory.setText("This keyword lesson\n");
                }
                if (datasource.checkLessons(LoginForm.aux, "Final keyword")) {
                    lessonsHistory.setText("Final keyword lesson\n");
                }
                if (datasource.checkLessons(LoginForm.aux, "Super keyword")) {
                    lessonsHistory.setText("Super keyword lesson \n");
                }
                lessonsHistory.setVisible(true);
            }
        }
    }
}
