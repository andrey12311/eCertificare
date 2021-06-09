package com.swing;

import javax.swing.*;
import java.awt.*;

public class DataTypes extends JFrame {
    private JTextArea area;
    JScrollPane scroll;

    public DataTypes(){
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
      //  setLayout(null);
        area = new JTextArea();
        area.setSize(600,600);
        area.setText("There are majorly two types of languages.\n" +
                "\n" +
                "  First one is Statically typed language where each variable and expression type is already known " +
                "at compile time."+"\n"+"Once a variable is declared to be of a certain data type, it cannot hold values of other data types.\n" +
                "    Example: C, C++, Java.\n" +
                "    The other is Dynamically typed languages. These languages can receive different data types over time.\n" +
                "    Example: Ruby, Python\n" +
                "\n" +
                "Java is statically typed and also a strongly typed language because in Java, each type of data\n"+
                "(such as integer, character, hexadecimal, packed decimal, and so forth) is predefined as part of" +
                " the programming \n language and all constants or variables defined for a given program must " +
                "be described with one of the data types \n \n Java has two categories of data:\n" +
                "\n" +
                "    Primitive Data Type: such as boolean, char, int, short, byte, long, float and double\n" +
                "    Non-Primitive Data Type or Object Data type: such as String, Array, etc.\n \n" +
                "Boolean: boolean data type represents only one bit of information either true or false \n but the size" +
                " of boolean data type is virtual machine-dependent. \n Values of type boolean are not converted implicitly " +
                "or explicitly (with casts) to any other type.\n But the programmer can easily write conversion code.\n\n" +
                "Syntax:boolean booleanVar ; example:boolean var=true \n \n float: The float data type is a single-precision 32-bit IEEE 754 floating" +
                " point.\n Use a float (instead of double) if you need to save memory in large arrays of floating point numbers. \n" +
                "Syntax:float floatVar ;example:float n=5.5 . \n\n Double: The double data type is a double-precision 64-bit IEEE 754 floating point" +
                ".\nFor decimal values, this data type is generally the default choice \n\n Syntax:double doubleVar ; example:double n=10.0\n" +
                "Int: It is a 32-bit signed two’s complement integer \n\n Syntax:int intVar ; example:int n = 100");
        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);
        scroll.getViewport().add(area);
        add(scroll);
    }
}
