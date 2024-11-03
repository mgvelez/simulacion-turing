package org.simulacion.enigma.machine;

import java.util.HashMap;
import java.util.Map;

public class Plugboard {
    private Map<Character, Character> plugMappings = new HashMap<>();

    public void addMapping(char char1, char char2) {
        plugMappings.put(char1, char2);
        plugMappings.put(char2, char1);
    }

    public char swap(char input) {
        return plugMappings.getOrDefault(input, input);
    }
}
