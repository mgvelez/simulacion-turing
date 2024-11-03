package org.simulacion.enigma.machine;

public class EnigmaMachine {
    private Rotor[] rotors;
    private Reflector reflector;
    private Plugboard plugboard;

    public EnigmaMachine(Rotor[] rotors, Reflector reflector, Plugboard plugboard) {
        this.rotors = rotors;
        this.reflector = reflector;
        this.plugboard = plugboard;
    }

    public String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();

        for (char ch : message.toUpperCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = plugboard.swap(ch);

                // Paso a través de los rotores en el sentido de ida
                for (Rotor rotor : rotors) {
                    ch = rotor.encodeForward(ch);
                }

                // Reflexión del carácter en el reflector
                ch = reflector.reflect(ch);

                // Paso a través de los rotores en el sentido de regreso
                for (int i = rotors.length - 1; i >= 0; i--) {
                    ch = rotors[i].encodeBackward(ch);
                }

                ch = plugboard.swap(ch); // Intercambio final en el plugboard

                // Rotación del primer rotor
                rotors[0].rotate();
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }

    public void reset() {
        for (Rotor rotor : rotors) {
            rotor.resetPosition();
        }
    }

    public Rotor[] getRotors() {
        return rotors;
    }
}
