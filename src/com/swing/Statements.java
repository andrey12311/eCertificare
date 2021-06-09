package com.swing;

import javax.swing.*;
import java.awt.*;


public class Statements extends JFrame {
    private JTextArea area;
    JScrollPane scroll;

    public Statements(){
        area = new JTextArea();
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);
        area.setText("Decision Making in programming is similar to decision making in real life.\n" +
                " In programming also we face some situations where we want a certain block of code to be executed\n" +
                " when some condition is fulfilled.\n" +
                "A programming language uses control statements to control the flow of execution of program based on certain condition.s. \n" +
                "These  are used to cause the flow of execution to advance and branch based on changes to the state of a program.\n" +
                "Java’s Selection statements:\n" +
                "\n" +
                "    if\n" +
                "    if-else\n" +
                "    nested-if\n" +
                "    if-else-if\n" +
                "    switch-case\n" +
                "    jump – break, continue, return\n" +
                "\n" +
                "    These statements allow you to control the flow of your program’s execution based upon conditions\n" +
                "   known only during run time. \n" +
                "\n" +
                "if: if statement is the most simple decision making statement.\n" +
                " It is used to decide whether a certain statement or block of statements will be executed\n" +
                " or not i.e if a certain condition is true then a block of statement is executed otherwise not.\n" +
                "Syntax:if(condition){\n" +
                "// do stuff if condition is true\n" +
                "}\n" +
                "\n" +
                "if-else: The if statement alone tells us that if a condition is true it will execute a block of statements\n" +
                " and if the condition is false it won’t. But what if we want to do something else if the condition is false. \n" +
                "Here comes the else statement. We can use the else statement with if statement to execute a block of code\n" +
                " when the condition is false.\n" +
                "Syntax:if(condition){\n" +
                "// do stuff if condition is true\n" +
                "}else{\n" +
                "//execute if condition is false\n" +
                "}\n" +
                "\n" +
                "\n");
        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);
        scroll.getViewport().add(area);
        add(scroll);
    }
}
