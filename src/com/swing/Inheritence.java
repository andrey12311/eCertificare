package com.swing;

import javax.swing.*;
import java.awt.*;

public class Inheritence extends JFrame {
    private JTextArea area;
    JScrollPane scroll;

    public Inheritence(){
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);

        area.setText("In Java, it is possible to inherit attributes and methods from one class to another.\n" +
                " We group the \"inheritance concept\" into two categories:\n" +
                "\n" +
                "    subclass (child) - the class that inherits from another class\n" +
                "    superclass (parent) - the class being inherited from\n" +
                "\n" +
                "To inherit from a class, use the extends keyword.\n" +
                "\n" +
                "In the example below, the Car class (subclass) inherits the attributes and methods from the Vehicle class (superclass):\n" +
                "\n" +
                "Example:\n" +
                "class Vehicle {\n" +
                "  protected String brand = \"Ford\";        // Vehicle attribute\n" +
                "  public void honk() {                    // Vehicle method\n" +
                "    System.out.println(\"Tuut, tuut!\");\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "class Car extends Vehicle {\n" +
                "  private String modelName = \"Mustang\";    // Car attribute\n" +
                "  public static void main(String[] args) {\n" +
                "\n" +
                "    // Create a myCar object\n" +
                "    Car myCar = new Car();\n" +
                "\n" +
                "    // Call the honk() method (from the Vehicle class) on the myCar object\n" +
                "    myCar.honk();\n" +
                "\n" +
                "    // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class\n" +
                "    System.out.println(myCar.brand + \" \" + myCar.modelName);\n" +
                "  }\n" +
                "}\n");

        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);
        scroll.getViewport().add(area);
        add(scroll);

    }
}
