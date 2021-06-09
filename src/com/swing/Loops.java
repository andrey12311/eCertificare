package com.swing;

import javax.swing.*;
import java.awt.*;

public class Loops extends JFrame{
    private JTextArea area;
    JScrollPane scroll;

    public Loops(){
        area = new JTextArea();
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);

        area.setText("Looping in programming languages is a feature which facilitates the execution of a set of instructions/functions \n" +
                " repeatedly while some condition evaluates to true.\n" +
                "Java provides three ways for executing the loops. While all the ways provide \n" +
                " similar basic functionality, they differ in their syntax and condition checking time.\n" +
                " \n" +
                "1.while loop: A while loop is a control flow statement that allows code to be executed repeatedly based on a given Boolean condition.\n" +
                "The while loop can be thought of as a repeating if statement.\n" +
                " Syntax:while(condition){\n" +
                "//do stuff\n" +
                "} \n" +
                "\n" +
                "Example:while(condition){\n" +
                "//do stuff\n" +
                "}\n" +
                "\n" +
                "While loop starts with the checking of condition. If it evaluated\n" +
                " to true, then the loop bodystatements are executed otherwise first statement following the loop is executed.\n" +
                "For this reason it is also called Entry control loop\n" +
                "    Once the condition is evaluated to true, the statements in the loop body are executed.\n" +
                " Normally the statements contain an update value for the variable being processed for the next iteration.\n" +
                "    When the condition becomes false, the loop terminates which marks the end of its life cycle.\n" +
                "\n" +
                "2.for loop: for loop provides a concise way of writing the loop structure. \n" +
                "Unlike a while loop, a for statement consumes the initialization, condition and increment/decrement in one\n" +
                " line thereby providing a shorter, easy to debug structure of looping.\n" +
                "\n" +
                "Syntax: for(initialization condition ; testin condition ; increment /decrement){\n" +
                "//do stuff\n" +
                "}\n" +
                "\n" +
                "Example:for(int i = 1 ; i<=10 ; i++){\n" +
                "//do stuff\n" +
                "}\n" +
                "\n" +
                "3.do while:do while loop is similar to while loop with only difference that it checks for \n" +
                "condition after executing the statements, and therefore is an example of Exit Control Loop.\n" +
                "\n" +
                "Syntax:do{\n" +
                "//do stuff\n" +
                "}while(condition);\n" +
                "\n" +
                "Example: do{\n" +
                "/do stuff\n" +
                "}while(variable=true);\n" +
                "\n");
        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);
        scroll.getViewport().add(area);
        add(scroll);
    }
}
