package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LessonsPage extends JPanel {
    Datasource datasource = new Datasource();
    private JButton basicsButton;
    private JButton oopConceptsButton;
    private JButton keywordsButton;
    private JButton backButton;

    public LessonsPage() {
        Listener listener = new Listener();
        setLayout(null);
        setSize(600, 600);

        basicsButton = new JButton("Basics");
        basicsButton.setLocation(1, 30);
        basicsButton.setSize(200, 30);
        basicsButton.addActionListener(listener);
        add(basicsButton);

        oopConceptsButton = new JButton("OOP Concepts");
        oopConceptsButton.setSize(200, 30);
        oopConceptsButton.setLocation(1, 60);
        oopConceptsButton.addActionListener(listener);
        add(oopConceptsButton);

        keywordsButton = new JButton("Keywords");
        keywordsButton.setSize(200, 30);
        keywordsButton.setLocation(1, 90);
        keywordsButton.addActionListener(listener);
        add(keywordsButton);

        backButton = new JButton("Back");
        backButton.setSize(100, 30);
        backButton.setLocation(1, 1);
        backButton.addActionListener(listener);
        add(backButton);

    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == basicsButton) {
                Basics basics = new Basics();
                removeAll();
                revalidate();
                repaint();
                add(basics);
            } else if (e.getSource() == backButton) {
                removeAll();
                revalidate();
                repaint();
                add(new UserPage());
            } else if (e.getSource() == oopConceptsButton) {
                OopConcepts oopConcepts = new OopConcepts();
                removeAll();
                revalidate();
                repaint();
                add(oopConcepts);
            } else if (e.getSource() == keywordsButton) {
                KeyWords keyWords = new KeyWords();
                removeAll();
                revalidate();
                repaint();
                add(keyWords);
            }
        }
    }
}
