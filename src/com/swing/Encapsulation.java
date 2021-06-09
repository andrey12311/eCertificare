package com.swing;

import javax.swing.*;
import java.awt.*;

public class Encapsulation extends JFrame {
    private JTextArea area;
    JScrollPane scroll;

    public Encapsulation(){
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);

        area.setText("We can create a fully encapsulated class in Java by making all the data members of the class private. \n" +
                "Now we can use setter and getter methods to set and get the data in it.\n" +
                "The Java Bean class is the example of a fully encapsulated class.\n" +
                "\n" +
                "dvantage of Encapsulation in Java\n" +
                "\n" +
                "By providing only a setter or getter method, you can make the class read-only or write-only. \n" +
                "In other words, you can skip the getter or setter methods.\n" +
                "\n" +
                "It provides you the control over the data. \n" +
                "Suppose you want to set the value of id which should be greater than 100 only, you can write the logic inside the setter method. \n" +
                "You can write the logic not to store the negative numbers in the setter methods.\n" +
                "\n" +
                "It is a way to achieve data hiding in Java because other class will not be able to access the data through the private data members.\n" +
                "\n" +
                "The encapsulate class is easy to test. So, it is better for unit testing.\n" +
                "\n" +
                "The standard IDE's are providing the facility to generate the getters and setters. \n" +
                "So, it is easy and fast to create an encapsulated class in Java.\n" +
                "\n" +
                "Example:\n" +
                "    //A Java class which is a fully encapsulated class.  \n" +
                "    //It has a private data member and getter and setter methods.  \n" +
                "    package com.javatpoint;  \n" +
                "\n" +
                "    public class Student{  \n" +
                "    //private data member  \n" +
                "    private String name;  \n" +
                "    //getter method for name  \n" +
                "    public String getName(){  \n" +
                "    return name;  \n" +
                "      }  \n" +
                "    //setter method for name  \n" +
                "    public void setName(String name){  \n" +
                "    this.name=name  \n" +
                "        }  \n" +
                "    }  \n");
        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);
        scroll.getViewport().add(area);
        add(scroll);
    }
}
