package com.swing;


import javax.swing.*;

public class MainFrame extends JFrame {
    LoginForm loginForm = new LoginForm();

    public MainFrame() {
        setSize(600, 600);
        setTitle("eCertificare");
        add(loginForm);
        setVisible(true);
        setLocation(450, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
