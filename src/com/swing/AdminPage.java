package com.swing;


import model.Datasource;
import model.Examen;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminPage extends JPanel {

    private JButton searchButton;
    private JTextField examenField;
    private JButton refreshButton;
    private JButton addQuestionButton;
    private JButton allQuestionsButton;
    private JComboBox box;
    private Datasource datasource;
    private JComboBox testName;
    private  ArrayList<String> users;
    private String[] DB_NAMES={"Basics","OOPConcepts","KeyWords"};
    public static ArrayList<Examen> examene;
    public static String dataBase;
    User u;

    public AdminPage() {
        setLayout(null);
        setSize(600, 600);

        datasource = new Datasource();
       this.users = datasource.queryAllUsers();
       this.users.add("Add account");

       testName = new JComboBox(DB_NAMES);
       testName.setLocation(430,30);
       testName.setSize(100,20);
       add(testName);

        box = new JComboBox(users.toArray());
        box.setLocation(200, 70);
        box.setSize(200, 20);
        box.setRenderer(new MyComboBoxRenderer("Select user"));
        box.setSelectedIndex(-1);
        box.addItemListener(new boxListener());
        add(box);

        searchButton = new JButton("Search");
        searchButton.setSize(80, 20);
        searchButton.setLocation(350, 30);
        searchButton.addActionListener(new Listener());
        add(searchButton);

        refreshButton = new JButton("refersh");
        refreshButton.setLocation(1,1);
        refreshButton.setSize(100,25);
        refreshButton.addActionListener(new Listener());
        add(refreshButton);

        addQuestionButton = new JButton("Add Question");
        addQuestionButton.setSize(150,30);
        addQuestionButton.setLocation(1,70);
        addQuestionButton.addActionListener(new Listener());
        add(addQuestionButton);

        allQuestionsButton = new JButton("All questions");
        allQuestionsButton.setSize(130,30);
        allQuestionsButton.setLocation(1,140);
        allQuestionsButton.addActionListener(new Listener());
        add(allQuestionsButton);

        examenField = new JTextField("Search the question here");
        examenField.setSize(150, 20);
        examenField.setLocation(200, 30);
        examenField.addMouseListener(new ListenForMouse());
        add(examenField);
    }


    private static class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
        private String _title;

        public MyComboBoxRenderer(String title) {
            _title = title;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean hasFocus) {
            if (index == -1 && value == null) setText(_title);
            else setText(value.toString());
            return this;
        }
    }

    private class boxListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                if(e.getItem()=="Add account"){
                    AdminCreateAccount adminCreateAccount = new AdminCreateAccount();
                    adminCreateAccount.setVisible(true);
                }else{
                    u = datasource.queryUsers(e.getItem().toString());
                    AdminModifyUsers adminModifyUsers = new AdminModifyUsers(e.getItem().toString());
                    adminModifyUsers.setVisible(true);
                }
            }
        }
    }
    private class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==refreshButton) {
                AdminPage adminPage = new AdminPage();
                removeAll();
                revalidate();
                repaint();
                add(adminPage);
            }else if(e.getSource()==searchButton){
                if(examenField.getText().isBlank()){
                    JOptionPane.showMessageDialog(new JFrame(), "Field cannot be blank!",
                            "", JOptionPane.ERROR_MESSAGE);
                    return;
                }

               if(testExists()) {
                   TestsPage testsPage = new TestsPage();
                   testsPage.setVisible(true);
               }else  JOptionPane.showMessageDialog(new JFrame(), "Can't find the question",
                       "", JOptionPane.ERROR_MESSAGE);

            }else if(e.getSource()==addQuestionButton){
                AddQuestionForm addQuestionForm = new AddQuestionForm();
                addQuestionForm.setVisible(true);
            }else if(e.getSource()==allQuestionsButton){
                AllQuestions allQuestions = new AllQuestions();
                allQuestions.setVisible(true);
            }
        }

        private boolean testExists(){
            if(datasource.searchTest(testName.getSelectedItem().toString(),examenField.getText())!=null) {
                examene = datasource.searchTest(testName.getSelectedItem().toString(), examenField.getText());
                dataBase=testName.getSelectedItem().toString();
                return true;
            }
            else return false;
        }
    }
    private class ListenForMouse implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if(examenField.getText().equals("Search the question here"))
            examenField.setText("");
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}

