package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value;
    private JLabel infoLabel;
    public CounterApp(){
        setBounds(500,500,300,120);
        setTitle("Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font font = new Font("Arial",Font.BOLD,32);

        JLabel label = new JLabel(String.valueOf(value));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label,BorderLayout.CENTER);

        //покажем ошибку если значение сч. по модулю 10
        infoLabel = new JLabel();
        add(infoLabel,BorderLayout.NORTH);


        JButton decBut = new JButton("<");
        decBut.setFont(font);
        add(decBut,BorderLayout.WEST);

        JButton incBut = new JButton(">");
        incBut.setFont(font);
        add(incBut,BorderLayout.EAST);

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

        setVisible(true);
    }

    private void validateRange () {
        if (Math.abs(value)>10) {
            infoLabel.setText("Value out of range");
        } else {
            infoLabel.setText("");
        }
    }


    public static void main(String[] args) {
        new CounterApp();
    }
}
