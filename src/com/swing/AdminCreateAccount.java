package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminCreateAccount extends JFrame {

    private Datasource datasource;
    private JButton createAccountButton = new JButton("Create Account");
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JTextField userField;
    private JLabel userLabel;
    private JTextField firstNameField;
    private JLabel firstNameLabel;
    private JTextField lastNameField;
    private JLabel lastNameLabel;
    private JTextField schoolField;
    private JLabel schoolLabel;


    public AdminCreateAccount() {
        ListenerForButton listener = new ListenerForButton();

        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);

        schoolField = new JTextField();
        schoolField.setLocation(250, 300);
        schoolField.setSize(250, 30);
        this.add(schoolField);

        schoolLabel = new JLabel("School");
        schoolLabel.setSize(300, 300);
        schoolLabel.setLocation(190, 160);
        this.add(schoolLabel);

        lastNameField = new JTextField();
        lastNameField.setLocation(250, 250);
        lastNameField.setSize(250, 30);
        this.add(lastNameField);

        lastNameLabel = new JLabel("Last name");
        lastNameLabel.setLocation(170, 115);
        lastNameLabel.setSize(300, 300);
        this.add(lastNameLabel);

        firstNameLabel = new JLabel("First name");
        firstNameLabel.setLocation(170, 65);
        firstNameLabel.setSize(300, 300);
        this.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setLocation(250, 200);
        firstNameField.setSize(250, 30);
        this.add(firstNameField);

        userField = new JTextField();
        userField.setSize(250, 30);
        userField.setLocation(250, 100);
        this.add(userField);


        passwordField = new JPasswordField(40);
        passwordField.setSize(250, 30);
        passwordField.setLocation(250, 150);
        this.add(passwordField);

        userLabel = new JLabel("Username");
        userLabel.setLocation(175, -40);
        userLabel.setSize(300, 300);
        this.add(userLabel);


        passwordLabel = new JLabel("Password");
        passwordLabel.setLocation(175, -35);
        passwordLabel.setSize(400, 400);
        this.add(passwordLabel);

        createAccountButton.setLocation(350, 500);
        createAccountButton.setSize(125, 25);
        createAccountButton.addActionListener(listener);
        this.add(createAccountButton);

    }

    private class ListenerForButton implements ActionListener {

        @SuppressWarnings("deprecation")
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == createAccountButton) {

                if(passwordField.getText().length()<5){
                    JOptionPane.showMessageDialog(new JFrame(), "Password must have minimum 5 characters!",
                            "", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (userField.getText().isBlank()|| passwordField.getText().isBlank() || firstNameField.getText().isBlank()
                        || lastNameField.getText().isBlank() || schoolField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Fields cannot be blank!",
                            "", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                datasource = new Datasource();
                if (datasource.register(userField.getText(), passwordField.getText(), firstNameField.getText(),
                        lastNameField.getText(), schoolField.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Account created!"
                            , "", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Username already exists!" + "", "",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
