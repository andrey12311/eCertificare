package com.swing;

import model.Datasource;
import model.Examen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test extends JPanel {
    static String quiz;
    private static String corAnswer;
    Datasource datasource;
    ArrayList<Examen> examene;
    private JLabel questionLabel;
    private int count = 1;
    private int testIndex = 0;
    private JButton nextButton;
    private JButton finishButton;
    private JCheckBox[] buttons = new JCheckBox[3];
    private ButtonGroup group;

    public Test(String tableName) {
        listener listener = new listener();
        setLayout(null);
        datasource = new Datasource();

        examene = datasource.getQuestions(tableName);
        setSize(600, 600);


        questionLabel = new JLabel(examene.get(testIndex).getQuestion() + "(1p)");
        questionLabel.setLocation(100, 100);
        questionLabel.setSize(500, 23);
        add(questionLabel);


        corAnswer = examene.get(0).getCorrAnswer();


        buttons[0] = new JCheckBox(examene.get(testIndex).getWrAnswer());
        buttons[0].setLocation(50, 200);
        buttons[0].setSize(500, 30);
        buttons[0].addItemListener(listener);
        buttons[0].addActionListener(listener);
        add(buttons[0]);

        buttons[1] = new JCheckBox(examene.get(testIndex).getWrAnswer2());
        buttons[1].setLocation(50, 300);
        buttons[1].setSize(500, 30);
        buttons[1].addItemListener(listener);
        buttons[1].addActionListener(listener);
        add(buttons[1]);


        buttons[2] = new JCheckBox(examene.get(testIndex).getCorrAnswer());
        buttons[2].setLocation(50, 400);
        buttons[2].setSize(500, 30);
        buttons[2].addItemListener(listener);
        buttons[2].addActionListener(listener);
        add(buttons[2]);
        Collections.shuffle(Arrays.asList(buttons));

        group = new ButtonGroup();
        group.add(buttons[0]);
        group.add(buttons[1]);
        group.add(buttons[2]);


        nextButton = new JButton("Next");
        nextButton.setSize(70, 20);
        nextButton.setLocation(450, 500);
        nextButton.setEnabled(false);
        nextButton.addActionListener(listener);
        add(nextButton);

        finishButton = new JButton("Finish");
        finishButton.setSize(70, 20);
        finishButton.setLocation(300, 500);
        finishButton.addActionListener(listener);
        finishButton.setEnabled(false);
        add(finishButton);
    }

    public int getExamene() {
        return this.examene.size();
    }

    private class listener implements ActionListener, ItemListener {
        String correctAnswer;
        private int countAnswers = 0;
        private String answer;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (examene.size() == 1) {
                nextButton.setEnabled(false);
                finishButton.setEnabled(true);
                if (e.getSource() == buttons[0]) {
                    this.answer = buttons[0].getText();

                } else if (e.getSource() == buttons[1]) {
                    this.answer = buttons[1].getText();

                } else if (e.getSource() == buttons[2]) {
                    this.answer = buttons[2].getText();
                } else if (e.getSource() == finishButton) {
                    datasource.insertQuizInHistory(LoginForm.aux, quiz, countAnswers);
                    JOptionPane.showMessageDialog(new JFrame(), "You got " + this.countAnswers + " points.",
                            "Congratulations!", JOptionPane.PLAIN_MESSAGE);
                    LessonsPage lessonsPage = new LessonsPage();
                    removeAll();
                    revalidate();
                    repaint();
                    add(lessonsPage);
                    return;
                }
                if (this.answer.equals(Test.corAnswer) || this.answer.equals(this.correctAnswer)) {
                    this.countAnswers++;
                }

            }
            if (e.getSource() == nextButton) {
                group.clearSelection();
                nextButton.setEnabled(false);
                testIndex++;
                count++;

                if (this.answer.equals(Test.corAnswer) || this.answer.equals(this.correctAnswer)) {

                    this.countAnswers++;
                }


                if (count == examene.size()) {
                    nextButton.setEnabled(false);
                    finishButton.setEnabled(true);
                }
                buttons[0].setText(examene.get(testIndex).getWrAnswer2());
                correctAnswer = examene.get(testIndex).getCorrAnswer();
                buttons[1].setText(examene.get(testIndex).getWrAnswer());
                buttons[2].setText(examene.get(testIndex).getCorrAnswer());
                questionLabel.setText(examene.get(testIndex).getQuestion());
                Collections.shuffle(Arrays.asList(buttons));


            } else if (e.getSource() == finishButton) {
                if (this.answer.equals(Test.corAnswer) || this.answer.equals(this.correctAnswer)) {
                    this.countAnswers++;
                }
                datasource.insertQuizInHistory(LoginForm.aux, quiz, countAnswers);
                JOptionPane.showMessageDialog(new JFrame(), "You got " + this.countAnswers + " points.",
                        "Congratulations!", JOptionPane.PLAIN_MESSAGE);
                LessonsPage lessonsPage = new LessonsPage();
                removeAll();
                revalidate();
                repaint();
                add(lessonsPage);
            } else if (e.getSource() == buttons[0]) {
                this.answer = buttons[0].getText();

            } else if (e.getSource() == buttons[1]) {
                this.answer = buttons[1].getText();

            } else if (e.getSource() == buttons[2]) {
                this.answer = buttons[2].getText();
            }
        }

        @Override
        public void itemStateChanged(ItemEvent itemEvent) {

            if ((itemEvent.getSource() == buttons[0] ||
                    itemEvent.getSource() == buttons[1] ||
                    itemEvent.getSource() == buttons[2]) && count < examene.size()) {

                nextButton.setEnabled(true);
            }
        }
    }
}

