import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // inicializamos la configuración con valores por defecto
        configuracion config = new configuracion();

        // nombres de las pruebas oficiales del proyecto
        String[] pruebas = {
            "La cifra exacta", 
            "La palabra más larga", 
            "La calculadora humana", 
            "El código secreto (Prueba Original)"
        };
        int totalPruebas = pruebas.length;

        String jugador1 = "Jugador 1";
        String jugador2 = "Jugador 2";

        int opcionPrincipal = 0;

        // bucle general del menú principal
        while (opcionPrincipal != 4) {
            System.out.println("\n========================================");
            System.out.println("   CONCURSO: CIFRAS Y LETRAS (JAVA)     ");
            System.out.println("========================================");
            System.out.println("1. Modo Concurso (Todas las pruebas)");
            System.out.println("2. Modo Rápido (Una sola prueba)");
            System.out.println("3. Configuración del juego");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            opcionPrincipal = scanner.nextInt();

            if (opcionPrincipal == 1) {
                // modo Concurso
                int globalJ1 = 0; 
                int globalJ2 = 0; 

                System.out.println("\n--- INICIO DEL MODO CONCURSO ---");
                System.out.println("repeticiones configuradas por prueba: " + config.getRepeticionesPruebas());

                //bucle de repetición según la configuración
                for (int r = 1; r <= config.getRepeticionesPruebas(); r++) {
                    if (config.getRepeticionesPruebas() > 1) {
                        System.out.println("\n>>> Ronda " + r + " de " + config.getRepeticionesPruebas() + " <<<");
                    }

                    for (int i = 0; i < totalPruebas; i++) {
                        System.out.println("\n-> Disputando Prueba " + (i + 1) + ": " + pruebas[i]);

                        // Aqui se enlazarían los puntos obtenidos en cada prueba correspondiente de tu interfaz
                        System.out.print("Puntos de " + jugador1 + " en " + pruebas[i] + ": ");
                        int puntosPruebaJ1 = scanner.nextInt();

                        System.out.print("Puntos de " + jugador2 + " en " + pruebas[i] + ": ");
                        int puntosPruebaJ2 = scanner.nextInt();

                        // Lógica de puntos globales por prueba
                        if (puntosPruebaJ1 > puntosPruebaJ2) {
                            globalJ1++;
                            System.out.println(">> ¡Gana la prueba " + jugador1 + " y suma 1 punto global!");
                        } else if (puntosPruebaJ2 > puntosPruebaJ1) {
                            globalJ2++;
                            System.out.println(">> ¡Gana la prueba " + jugador2 + " y suma 1 punto global!");
                        } else {
                            System.out.println(">> Empate en la prueba. Ninguno suma punto global.");
                        }
                    }
                }

                //resultado final del concurso
                System.out.println("\n=== FIN DEL CONCURSO ===");
                System.out.println("Marcador Global -> " + jugador1 + ": " + globalJ1 + " pts | " + jugador2 + ": " + globalJ2 + " pts");

                if (globalJ1 > globalJ2) {
                    System.out.println("¡El ganador del concurso es " + jugador1 + "!");
                } else if (globalJ2 > globalJ1) {
                    System.out.println("¡El ganador del concurso es " + jugador2 + "!");
                } else {
                    System.out.println("El concurso ha finalizado en EMPATE.");
                }

            } else if (opcionPrincipal == 2) {
                // Modo Rápido
                System.out.println("\n--- SELECCIONA UNA PRUEBA ---");
                for (int i = 0; i < totalPruebas; i++) {
                    System.out.println((i + 1) + ". " + pruebas[i]);
                }
                System.out.print("Introduce el número de la prueba: ");
                int seleccion = scanner.nextInt() - 1;

                if (seleccion >= 0 && seleccion < totalPruebas) {
                    System.out.println("\n--- MODO RÁPIDO: " + pruebas[seleccion] + " ---");
                    
                    // Aplicando parámetros de configuración específicos si procede
                    if (seleccion == 1) {
                        System.out.println("(Configuración activa - Letras: " + config.getCantidadLetras() + ")");
                    } else if (seleccion == 2) {
                        System.out.println("(Configuración activa - Operaciones: " + config.getCantidadOperaciones() + ")");
                    }

                    System.out.print("Puntos de " + jugador1 + ": ");
                    int puntosPruebaJ1 = scanner.nextInt();

                    System.out.print("Puntos de " + jugador2 + ": ");
                    int puntosPruebaJ2 = scanner.nextInt();

                    if (puntosPruebaJ1 > puntosPruebaJ2) {
                        System.out.println("¡Ganador de la prueba: " + jugador1 + "!");
                    } else if (puntosPruebaJ2 > puntosPruebaJ1) {
                        System.out.println("¡Ganador de la prueba: " + jugador2 + "!");
                    } else {
                        System.out.println("La prueba finaliza sin un ganador (Empate).");
                    }
                } else {
                    System.out.println("Error: La prueba seleccionada no es válida.");
                }

            } else if (opcionPrincipal == 3) {
                // menu de configuración de la clase configuracion.java
                config.mostrarMenuConfiguracion(scanner);

            } else if (opcionPrincipal == 4) {
                System.out.println("Saliendo del programa. ¡Hasta pronto!");
            } else {
                System.out.println("Opción incorrecta, introduce un número del 1 al 4.");
            }
        }

        scanner.close();
    }
}