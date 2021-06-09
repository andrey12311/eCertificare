package com.swing;

import javax.swing.*;
import java.awt.*;

public class FinalKeyword extends JFrame {
    private JTextArea area;
    JScrollPane scroll;

    public FinalKeyword(){
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);

        area.setText("\n" +
                "When a variable is declared with final keyword, its value can’t be modified, essentially, a constant.\n" +
                " This also means that you must initialize a final variable. If the final variable is a reference, this means \n" +
                "that the variable cannot be re-bound to reference another object, but internal state of the object pointed \n" +
                "by that reference variable can be changed i.e. you can add or remove elements from final array or final collection.\n" +
                " It is good practice to represent final variables in all uppercase, using underscore to separate words.\n" +
                "\n" +
                "Initializing a final variable :\n" +
                "We must initialize a final variable, otherwise compiler will throw compile-time error\n" +
                ".A final variable can only be initialized once, either via an initializer or an assignment statement. \n" +
                "There are three ways to initialize a final variable :\n" +
                "\n" +
                "\n" +
                "   1. You can initialize a final variable when it is declared.This approach is the most common. \n" +
                "A final variable is called blank final variable,if it is not initialized while declaration. \n" +
                "Below are the two ways to initialize a blank final variable.\n" +
                "  2. A blank final variable can be initialized inside instance-initializer block or inside constructor.\n" +
                " If you have more than one constructor in your class then it must be initialized in all of them, otherwise compile time error will be thrown.\n" +
                "    3.A blank final static variable can be initialized inside static block. \n" +
                "\n" +
                "Example:\n" +
                "final int i = 4 ;\n" +
                "final double pi = 3.14;\n");
        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);
        scroll.getViewport().add(area);
        add(scroll);
    }

}
