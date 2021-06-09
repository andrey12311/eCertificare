package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AllQuestions extends JFrame {

    private ArrayList<String> questions;
    private Datasource datasource;
    private JTextArea area;
    private JScrollPane scroll;

    public AllQuestions(){
        area = new JTextArea();
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);
        datasource = new Datasource();


        questions=datasource.queryAllQuestions();


        area.setSize(600,600);
        area.setEditable(false);
        area.setFont(new Font("Courier",Font.BOLD,12));
        for(int i = 0 ; i < questions.size() ;i++){
            area.append(questions.get(i)+"\n");
        }

        scroll.getViewport().add(area);
        add(scroll);
    }
}
