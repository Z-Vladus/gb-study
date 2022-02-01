package ru.geekbrains.lesson8.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework8App extends JFrame {
    private int value;
    private JLabel infoLabel;
    public JLabel label;
    public Homework8App() {
        setBounds(500,500,500,320);
        setTitle("Counter-Homework8");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font font = new Font("Arial",Font.BOLD,32);

        label = new JLabel(String.valueOf(value));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label,BorderLayout.CENTER);

        //покажем ошибку если значение сч. по модулю 10
        //infoLabel = new JLabel();
        //add(infoLabel,BorderLayout.CENTER);

        JButton decPlusBut = new JButton("<<");
        decPlusBut.setFont(font);
        add(decPlusBut,BorderLayout.NORTH);


        JButton decBut = new JButton("<");
        decBut.setFont(font);
        add(decBut,BorderLayout.WEST);


        JButton incBut = new JButton(">");
        incBut.setFont(font);
        add(incBut,BorderLayout.EAST);

        JButton incPlusBut = new JButton(">>");
        incPlusBut.setFont(font);
        add(incPlusBut,BorderLayout.SOUTH);


        decBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        decPlusBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value-=10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incPlusBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value+=10;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        setVisible(true);
    }
    private void validateRange () {
        if (Math.abs(value)>25) {
            label.setText(String.valueOf(value)+": value out of range");
            //infoLabel.setText("Value out of range");

        } else {
            //infoLabel.setText("");
            label.setText(String.valueOf(value));
        }
    }

    public static void main(String[] args) {
        new Homework8App();
    }
}
