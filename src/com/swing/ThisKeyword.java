package com.swing;

import javax.swing.*;
import java.awt.*;

public class ThisKeyword extends JFrame {
    private JTextArea area;
    JScrollPane scroll;

    public ThisKeyword(){
        setSize(600,600);
        scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(600,600);
        area = new JTextArea();
        area.setSize(600,600);

        area.setText("There can be a lot of usage of java this keyword. In java, this is a reference variable that refers to the current object.\n" +
                "\n" +
                "Usage of java this keyword\n" +
                "\n" +
                "Here is given the 6 usage of java this keyword.\n" +
                "\n" +
                "    1.this can be used to refer current class instance variable.\n" +
                "    2.this can be used to invoke current class method (implicitly)\n" +
                "    3.this() can be used to invoke current class constructor.\n" +
                "    4.this can be passed as an argument in the method call.\n" +
                "    5.this can be passed as argument in the constructor call.\n" +
                "    6.this can be used to return the current class instance from the method\n" +
                "\n" +
                "Wrong Example:\n" +
                "\n" +
                "    class Student{  \n" +
                "    int rollno;  \n" +
                "    String name;  \n" +
                "    float fee;  \n" +
                "    Student(int rollno,String name,float fee){  \n" +
                "    rollno=rollno;  \n" +
                "    name=name;  \n" +
                "    fee=fee;  \n" +
                "    }  \n" +
                "    void display(){System.out.println(rollno+\" \"+name+\" \"+fee);}  \n" +
                "    }  \n" +
                "    class TestThis1{  \n" +
                "    public static void main(String args[]){  \n" +
                "    Student s1=new Student(111,\"ankit\",5000f);  \n" +
                "    Student s2=new Student(112,\"sumit\",6000f);  \n" +
                "    s1.display();  \n" +
                "    s2.display();  \n" +
                "    }}  \n" +
                "\n" +
                "\n" +
                "Correct example:\n" +
                "\n" +
                "class Student{  \n" +
                "int rollno;  \n" +
                "String name;  \n" +
                "float fee;  \n" +
                "Student(int rollno,String name,float fee){  \n" +
                "this.rollno=rollno;  \n" +
                "this.name=name;  \n" +
                "this.fee=fee;  \n" +
                "}  \n" +
                "void display(){System.out.println(rollno+\" \"+name+\" \"+fee);}  \n" +
                "}  \n" +
                "  \n" +
                "class TestThis2{  \n" +
                "public static void main(String args[]){  \n" +
                "Student s1=new Student(111,\"ankit\",5000f);  \n" +
                "Student s2=new Student(112,\"sumit\",6000f);  \n" +
                "s1.display();  \n" +
                "s2.display();  \n" +
                "}} ");
        area.setFont(new Font("Courier",Font.BOLD,15));
        area.setEditable(false);

        scroll.getViewport().add(area);
        add(scroll);
    }
}
