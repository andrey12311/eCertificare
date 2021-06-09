package com.swing;

import javax.swing.*;
import java.awt.*;

public class Polymorphism extends JFrame {
    private JTextArea area;
    JScrollPane scroll;

    public Polymorphism(){
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);

        area.setText("Polymorphism means \"many forms\", and it occurs when we have many classes that are related to each other by inheritance.\n" +
                "\n" +
                "Like we specified in the previous chapter; Inheritance lets us inherit attributes and methods from another class. \n" +
                "Polymorphism uses those methods to perform different tasks. This allows us to perform a single action in different ways.\n" +
                "\n" +
                "For example, think of a superclass called Animal that has a method called animalSound(). \n" +
                "Subclasses of Animals could be Pigs, Cats, Dogs, Birds - \n" +
                "And they also have their own implementation of an animal sound (the pig oinks, and the cat meows, etc.):\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "class Animal {\n" +
                "  public void animalSound() {\n" +
                "    System.out.println(\"The animal makes a sound\");\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "class Pig extends Animal {\n" +
                "  public void animalSound() {\n" +
                "    System.out.println(\"The pig says: wee wee\");\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "class Dog extends Animal {\n" +
                "  public void animalSound() {\n" +
                "    System.out.println(\"The dog says: bow wow\");\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "Remember from the Inheritance chapter that we use the extends keyword to inherit from a class.\n" +
                "\n");
        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);
        scroll.getViewport().add(area);
        add(scroll);
    }
}
