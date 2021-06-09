package com.swing;

import model.Datasource;
import model.History;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryPage extends JFrame {
    private ArrayList<History> questions;
    private Datasource datasource;
    private JTextArea area;
    private JScrollPane scroll;

    public HistoryPage(){
        area = new JTextArea();
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);
        datasource = new Datasource();

        questions=datasource.getFromHistory(LoginForm.aux);

        area.setSize(600,600);
        area.setEditable(false);
        area.setFont(new Font("Courier",Font.BOLD,12));
        for (History question : questions) {
            area.append(question.getQuiz() + " " + question.getPoints() + " points \n");
        }

        scroll.getViewport().add(area);
        add(scroll);
    }
}
