package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class QuestionFrame extends JFrame {
    private JLabel label;
    private JButton b1, b2;
    private String lesson;

    public QuestionFrame() {
        setLayout(null);
        setSize(200, 200);
        setLocation(600, 150);

        label = new JLabel("Add this lesson to history?");
        label.setSize(150, 30);
        label.setLocation(20, 30);
        add(label);


        b1 = new JButton("Yes");
        b1.setLocation(10, 60);
        b1.setSize(60, 30);
        b1.addActionListener(new Listener());
        add(b1);

        b2 = new JButton("No");
        b2.setLocation(100, 60);
        b2.setSize(60, 30);
        b2.addActionListener(new Listener());
        add(b2);
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                System.out.println(lesson);
                Datasource datasource = new Datasource();
                datasource.setLesson(LoginForm.aux,lesson);
                dispatchEvent(new WindowEvent(getOuter(), WindowEvent.WINDOW_CLOSING));
            }else{
                dispatchEvent(new WindowEvent(getOuter(), WindowEvent.WINDOW_CLOSING));
            }
        }
    }

    public void setLesson(String s){
        this.lesson=s;
    }

    public QuestionFrame getOuter() {
        return QuestionFrame.this;
    }

}
