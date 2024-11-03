package org.simulacion.enigma.ui;

import org.simulacion.enigma.cracking.EnigmaCracker;
import org.simulacion.enigma.machine.EnigmaMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnigmaGUI extends JFrame {
    private JTextArea inputText;
    private JTextArea outputText;
    private JButton encryptButton;
    private JButton crackButton;
    private EnigmaMachine enigmaMachine;
    private EnigmaCracker enigmaCracker;

    public EnigmaGUI(EnigmaMachine enigmaMachine, EnigmaCracker enigmaCracker) {
        this.enigmaMachine = enigmaMachine;
        this.enigmaCracker = enigmaCracker;
        initializeComponents();
    }

    private void initializeComponents() {
        inputText = new JTextArea(5, 20);
        outputText = new JTextArea(5, 20);
        encryptButton = new JButton("Encriptar");
        crackButton = new JButton("Descifrar");

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputText.getText();
                String encryptedMessage = enigmaMachine.encrypt(message);
                outputText.setText(encryptedMessage);
            }
        });

        crackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String encryptedMessage = outputText.getText();
                String crackedMessage = enigmaCracker.crack(encryptedMessage);
                outputText.setText(crackedMessage);
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Mensaje:"));
        add(new JScrollPane(inputText));
        add(encryptButton);
        add(crackButton);
        add(new JLabel("Resultado:"));
        add(new JScrollPane(outputText));

        setTitle("Simulación Enigma");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
