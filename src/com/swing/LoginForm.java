package com.swing;

import model.Datasource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JPanel {
    static String aux;
    private Datasource datasource;
    private JButton loginButton;
    private JButton createAccountButton;
    private JPasswordField passwordField;
     JTextField userField;

     public LoginForm() {
        ListenButton listener = new ListenButton();
        setLayout(null);
        this.setBounds(0, 0, 600, 600);


        userField = new JTextField();
        userField.setSize(250, 30);
        userField.setLocation(250, 100);
        this.add(userField);

        passwordField = new JPasswordField(40);
        passwordField.setSize(250, 30);
        passwordField.setLocation(250, 150);
        this.add(passwordField);

        JLabel userLabel = new JLabel("Username");
        userLabel.setLocation(175, -35);
        userLabel.setSize(300, 300);
        this.add(userLabel);


        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setLocation(175, -30);
        passwordLabel.setSize(400, 400);
        this.add(passwordLabel);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setLocation(350, 200);
        createAccountButton.setSize(125, 25);
        createAccountButton.addActionListener(listener);
        this.add(createAccountButton);

        loginButton = new JButton("Login");
        loginButton.setLocation(250, 200);
        loginButton.setSize(70, 25);
        loginButton.addActionListener(listener);
        this.add(loginButton);

    }

    public String getUserField() {
        return this.userField.toString();
    }

    @SuppressWarnings("deprecation")
    private class ListenButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == createAccountButton) {
                CreateAccountForm createAccountForm = new CreateAccountForm();
                removeAll();
                revalidate();
                repaint();
                add(createAccountForm);
            } else if(actionEvent.getSource()==loginButton){

                if(userField.getText().equals("admin") && passwordField.getText().equals("admin")){
                    AdminPage a = new AdminPage();
                    removeAll();
                    revalidate();
                    repaint();
                    add(a);
                    return;
                }

                datasource = new Datasource();
                if(datasource.checkLogin(userField.getText(),passwordField.getText())) {
                    String s = userField.getText();
                    LoginForm.aux=s;
                        UserPage user = new UserPage();
                        removeAll();
                        revalidate();
                        repaint();
                        add(user);
                    }else{
                    JOptionPane.showMessageDialog(new JFrame(),"Wrong username or password!","",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
