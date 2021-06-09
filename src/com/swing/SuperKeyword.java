package com.swing;

import javax.swing.*;
import java.awt.*;

public class SuperKeyword extends JFrame {
        private JTextArea area;
        JScrollPane scroll;

    public SuperKeyword(){
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);

        area.setText("The super keyword in java is a reference variable that is used to refer parent class objects.\n" +
                "  The keyword “super” came into the picture with the concept of Inheritance.\n" +
                " It is majorly used in the following contexts:\n" +
                "\n" +
                "1. Use of super with variables: \n" +
                "This scenario occurs when a derived class and base class has same data members. \n" +
                "In that case there is a possibility of ambiguity for the JVM. \n" +
                "We can understand it more clearly using this code snippet:\n" +
                "\n" +
                "\n" +
                "/* Base class vehicle */\n" +
                "class Vehicle \n" +
                "{ \n" +
                "    int maxSpeed = 120; \n" +
                "} \n" +
                "  \n" +
                "/* sub class Car extending vehicle */\n" +
                "class Car extends Vehicle \n" +
                "{ \n" +
                "    int maxSpeed = 180; \n" +
                "  \n" +
                "    void display() \n" +
                "    { \n" +
                "        /* print maxSpeed of base class (vehicle) */\n" +
                "        System.out.println(\"Maximum Speed: \" + super.maxSpeed); \n" +
                "    } \n" +
                "} \n" +
                "  \n" +
                "/* Driver program to test */\n" +
                "class Test \n" +
                "{ \n" +
                "    public static void main(String[] args) \n" +
                "    { \n" +
                "        Car small = new Car(); \n" +
                "        small.display(); \n" +
                "    } \n" +
                "} \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "2. Use of super with methods: \n" +
                "This is used when we want to call parent class method. \n" +
                "So whenever a parent and child class have same named methods then to resolve ambiguity we use super keyword. \n" +
                "This code snippet helps to understand the said usage of super keyword.\n" +
                "\n" +
                "class Student extends Person \n" +
                "{ \n" +
                "    void message() \n" +
                "    { \n" +
                "        System.out.println(\"This is student class\"); \n" +
                "    } \n" +
                "  \n" +
                "    // Note that display() is only in Student class \n" +
                "    void display() \n" +
                "    { \n" +
                "        // will invoke or call current class message() method \n" +
                "        message(); \n" +
                "  \n" +
                "        // will invoke or call parent class message() method \n" +
                "        super.message(); \n" +
                "    } \n" +
                "} \n" +
                "  \n" +
                "/* Driver program to test */\n" +
                "class Test \n" +
                "{ \n" +
                "    public static void main(String args[]) \n" +
                "    { \n" +
                "        Student s = new Student(); \n" +
                "  \n" +
                "        // calling display() of Student \n" +
                "        s.display(); \n" +
                "    } \n" +
                "} ");

        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);
            scroll.getViewport().add(area);
            add(scroll);

    }
}
