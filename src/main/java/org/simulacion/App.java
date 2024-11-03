package org.simulacion;

import org.simulacion.enigma.cracking.EnigmaCracker;
import org.simulacion.enigma.machine.EnigmaMachine;
import org.simulacion.enigma.machine.Plugboard;
import org.simulacion.enigma.machine.Reflector;
import org.simulacion.enigma.machine.Rotor;
import org.simulacion.enigma.ui.EnigmaGUI;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Rotor rotor1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 0);
        Rotor rotor2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 0);
        Rotor rotor3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 0);
        Reflector reflector = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
        Plugboard plugboard = new Plugboard();
        plugboard.addMapping('A', 'B');

        Rotor[] rotors = {rotor1, rotor2, rotor3};
        EnigmaMachine enigma = new EnigmaMachine(rotors, reflector, plugboard);
        EnigmaCracker cracker = new EnigmaCracker(enigma);

        SwingUtilities.invokeLater(() -> new EnigmaGUI(enigma, cracker).setVisible(true));
    }
}
