# Proyecto de Simulación de la Máquina Enigma con Enfoque de Turing

Este proyecto implementa una simulación de la máquina Enigma, utilizada históricamente para cifrar y descifrar mensajes durante la Segunda Guerra Mundial. Incluye una interfaz gráfica en Java que permite al usuario encriptar y descifrar mensajes utilizando configuraciones similares a las de la máquina original. Además, el proyecto simula el enfoque de Alan Turing y su equipo en Bletchley Park para descifrar los mensajes encriptados, aplicando un algoritmo básico de prueba y error.

## Características

- **Simulación de la Máquina Enigma**: Implementación de los componentes principales, como los rotores, el reflector y el plugboard.
- **Interfaz Gráfica**: Interfaz en Java (Swing) para ingresar mensajes, configurar la máquina y ver el proceso de encriptado y descifrado.
- **Descifrado con el Enfoque de Turing**: Algoritmo de prueba y error para encontrar configuraciones de rotores que permitan descifrar mensajes.
- **Soporte para Palabras Clave Externas**: Las palabras clave para identificar posibles mensajes válidos se cargan desde un archivo JSON externo, facilitando la modificación sin alterar el código.

## Estructura del Proyecto

```plaintext
enigma-simulation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── enigma/
│   │   │       ├── machine/
│   │   │       │   ├── EnigmaMachine.java   # Simula la máquina Enigma
│   │   │       │   ├── Rotor.java           # Representa cada rotor
│   │   │       │   ├── Reflector.java       # Representa el reflector
│   │   │       │   ├── Plugboard.java       # Representa el plugboard
│   │   │       ├── cracking/
│   │   │       │   └── EnigmaCracker.java   # Algoritmo de descifrado basado en Turing
│   │   │       └── ui/
│   │   │           └── EnigmaGUI.java       # Interfaz gráfica para el usuario
│   │   └── resources/
│   │       └── keywords.json                # Archivo JSON con palabras clave
└── README.md
```

## Requisitos

- **Java 8** o superior
- **Biblioteca org.json** o **Gson** (si deseas cargar el archivo JSON)

## Configuración e Instalación

1. **Clona el repositorio**:

   ```bash
   git clone git@github.com:mgvelez/turing-machine.git
   cd turing-machine
   ```
2. **Crea el archivo JSON de palabras clave**:

   En `src/main/resources/keywords.json`, agrega las palabras clave que quieres utilizar para el descifrado. Por ejemplo:

   ```json
   {
     "keywords": ["HOLA", "MUNDO", "ENIGMA", "MENSAJE", "DECIFRADO"]
   }
   ```
3. **Compila y ejecuta el proyecto**:

   Utiliza tu IDE preferido (IntelliJ, Eclipse, NetBeans) o ejecuta los siguientes comandos en la terminal:

   ```bash
   javac -d bin src/main/java/enigma/**/*.java
   java -cp bin enigma.ui.EnigmaGUI
   ```

## Uso de la Aplicación

1. **Interfaz Principal**: Al ejecutar `EnigmaGUI`, aparecerá una ventana donde puedes ingresar un mensaje, configurar los rotores y encriptar o descifrar mensajes.

2. **Encriptar Mensajes**: Ingresa un mensaje en texto claro y selecciona las posiciones iniciales de los rotores. Luego, presiona "Encriptar" para ver el mensaje encriptado.

3. **Descifrar Mensajes**: Carga el mensaje encriptado y presiona "Descifrar" para que el algoritmo de prueba y error intente identificar la configuración correcta. Si el mensaje descifrado contiene alguna de las palabras clave, se mostrará como un posible descifrado.


## Expansión del Proyecto

- **Configuración Avanzada de la Máquina**: Se puede mejorar el modelo de Enigma agregando configuraciones adicionales para los rotores y el reflector.
- **Mejora del Algoritmo de Descifrado**: El algoritmo actual utiliza un enfoque básico de prueba y error. Esto puede mejorarse con técnicas adicionales, como el análisis de frecuencia de letras.
- **Compatibilidad Multilingüe**: Agregar soporte para caracteres de diferentes idiomas o implementar el descifrado de mensajes con caracteres especiales.

## Contribuir

Si deseas contribuir, puedes hacer un fork del proyecto, realizar cambios y enviar un pull request. ¡Todas las contribuciones son bienvenidas!



