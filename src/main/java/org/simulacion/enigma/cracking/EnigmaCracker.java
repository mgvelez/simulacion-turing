package org.simulacion.enigma.cracking;

import org.json.JSONArray;
import org.json.JSONObject;
import org.simulacion.enigma.machine.EnigmaMachine;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EnigmaCracker {
    private EnigmaMachine enigma;
    private List<String> commonWords;

    public EnigmaCracker(EnigmaMachine enigma) {
        this.enigma = enigma;
        this.commonWords = loadKeywords("src/main/resources/keywords.json"); // Ruta al archivo JSON
    }

    public String crack(String encryptedMessage) {
        for (int i = 0; i < 26; i++) {
            enigma.reset(); // Resetear posiciones de los rotores
            enigma.getRotors()[0].setPosition(i); // Cambiar la posición del primer rotor
            String decryptedMessage = enigma.encrypt(encryptedMessage); // Intento de descifrado

            if (isReadable(decryptedMessage)) {
                System.out.println("Posible configuración encontrada: Rotor 1 posición " + i);
                return decryptedMessage; // Devolver el mensaje descifrado posible
            }
        }
        return "No se encontró una configuración válida.";
    }

    private boolean isReadable(String message) {
        for (String word : commonWords) {
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private List<String> loadKeywords(String filePath) {
        List<String> keywords = new ArrayList<>();
        try (InputStream is = Files.newInputStream(Paths.get(filePath))) {
            // Leer el archivo JSON
            String jsonText = new String(is.readAllBytes());
            JSONObject jsonObj = new JSONObject(jsonText);
            JSONArray jsonArray = jsonObj.getJSONArray("keywords");

            // Añadir cada palabra clave al listado
            for (int i = 0; i < jsonArray.length(); i++) {
                keywords.add(jsonArray.getString(i).toUpperCase());
            }
        } catch (Exception e) {
            System.err.println("Error al leer las palabras clave desde el archivo JSON: " + e.getMessage());
        }
        return keywords;
    }
}
