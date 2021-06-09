package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.*;


public class LessonsHistory extends JFrame {
    private Datasource datasource;
    private JTextArea area;
    private JScrollPane scroll;

    public LessonsHistory() {
        area = new JTextArea();
        setSize(600, 600);
        scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600, 600);
        area = new JTextArea();
        area.setSize(600, 600);
        datasource = new Datasource();
        area.setSize(600, 600);
        area.setEditable(false);
        area.setFont(new Font("Courier", Font.BOLD, 12));

        scroll.getViewport().add(area);
        add(scroll);
    }

    public void setText(String s){

        area.append(s);
    }
}
