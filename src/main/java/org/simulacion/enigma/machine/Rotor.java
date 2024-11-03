package org.simulacion.enigma.machine;

public class Rotor {
    private String wiring;
    private int position;
    private int initialPosition; // Almacena la posición inicial

    public Rotor(String wiring, int initialPosition) {
        this.wiring = wiring;
        this.position = initialPosition;
        this.initialPosition = initialPosition;
    }

    public char encodeForward(char input) {
        int index = (input - 'A' + position) % 26;
        return wiring.charAt(index);
    }

    public char encodeBackward(char input) {
        int index = wiring.indexOf(input);
        return (char) ('A' + (index - position + 26) % 26);
    }

    public void rotate() {
        position = (position + 1) % 26;
    }

    public void setPosition(int pos) {
        this.position = pos % 26;
    }

    public int getPosition() {
        return position;
    }

    // Método para resetear a la posición inicial
    public void resetPosition() {
        this.position = initialPosition;
    }
}
