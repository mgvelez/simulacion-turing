package org.simulacion.enigma.machine;

public class Reflector {
    private String wiring; // Configuración del reflector

    public Reflector(String wiring) {
        this.wiring = wiring;
    }

    /**
     * Refleja un carácter de entrada utilizando la configuración del reflector.
     *
     * @param input El carácter que se debe reflejar.
     * @return El carácter reflejado de acuerdo con la configuración interna.
     */
    public char reflect(char input) {
        int index = input - 'A'; // Convierte el carácter a un índice (0-25)
        return wiring.charAt(index); // Devuelve el carácter reflejado según el wiring
    }
}
