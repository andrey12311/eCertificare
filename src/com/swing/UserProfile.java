package com.swing;

import model.Datasource;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserProfile extends JPanel {

    private JLabel username;
    private JLabel password;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel school;
    private JButton updateButton;
    private JButton backButton;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField schoolField;
    private User u;
    private Datasource datasource;
    Listener listener;
    public UserProfile() {
        listener = new Listener();
        datasource = new Datasource();
        u = datasource.queryUsers(LoginForm.aux);

        setLayout(null);
        setSize(600, 600);

        updateButton = new JButton("Update");
        updateButton.setLocation(300,300);
        updateButton.setSize(125,25);
        updateButton.addActionListener(listener);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setLocation(1,1);
        backButton.setSize(70,25);
        add(backButton);
        backButton.addActionListener(listener);

        username = new JLabel("Username:");
        username.setSize(100, 10);
        username.setLocation(70, 70);
        add(username);

        usernameField = new JTextField(u.getUsername());
        usernameField.setSize(200,25);
        usernameField.setLocation(150,60);
        add(usernameField);

        firstName = new JLabel("First name:");
        firstName.setSize(200, 15);
        firstName.setLocation(70, 100);
        add(firstName);

        firstNameField = new JTextField(u.getFirstName());
        firstNameField.setSize(200,25);
        firstNameField.setLocation(150,100);
        add(firstNameField);

        lastName = new JLabel("Last Name:");
        lastName.setSize(200, 15);
        lastName.setLocation(70, 130);
        add(lastName);

        lastNameField = new JTextField(u.getLastName());
        lastNameField.setSize(200,25);
        lastNameField.setLocation(150,130);
        add(lastNameField);

        password = new JLabel("Password:");
        password.setSize(200, 15);
        password.setLocation(70, 160);
        add(password);

        passwordField = new JTextField(u.getPassword());
        passwordField.setSize(200,25);
        passwordField.setLocation(150,160);
        add(passwordField);

        school = new JLabel("School:");
        school.setSize(200,25);
        school.setLocation(70,190);
        add(school);

        schoolField = new JTextField(u.getSchool());
        schoolField.setSize(200,25);
        schoolField.setLocation(150,190);
        add(schoolField);
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==updateButton){
                if (usernameField.getText().isBlank()|| passwordField.getText().isBlank() || firstNameField.getText().isBlank()
                        || lastNameField.getText().isBlank() || schoolField.getText().isBlank()) {

                    JOptionPane.showMessageDialog(new JFrame(), "Fields cannot be blank!", "",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(passwordField.getText().length()<5){
                    JOptionPane.showMessageDialog(new JFrame(), "Password short!", "",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                u=datasource.updateUser(u.getUsername(),usernameField.getText(),passwordField.getText(),
                        firstNameField.getText(), lastNameField.getText(),schoolField.getText(),u);
               usernameField.setText(u.getUsername());
               passwordField.setText(u.getPassword());
               firstNameField.setText(u.getFirstName());
               lastNameField.setText(u.getLastName());
               schoolField.setText(u.getSchool());
               LoginForm.aux=u.getUsername();
                JOptionPane.showMessageDialog(new JFrame(), "Updated!", "",
                        JOptionPane.PLAIN_MESSAGE);
            }else if(e.getSource()==backButton){
                removeAll();
                revalidate();
                repaint();
                add(new UserPage());
            }
        }
    }
}
