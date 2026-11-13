import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        configuracion config = new configuracion();

        String[] pruebas = {
            "La cifra exacta", 
            "La palabra más larga", 
            "La calculadora humana", 
            "El código secreto"
        };
        int totalPruebas = pruebas.length;

        String jugador1 = "Jugador 1";
        String jugador2 = "Jugador 2";
        int opcionPrincipal = 0;

        while (opcionPrincipal != 4) {
            System.out.println("\n========================================");
            System.out.println("   CONCURSO: CIFRAS Y LETRAS (JAVA)     ");
            System.out.println("========================================");
            System.out.println("1. Modo Concurso (Todas las pruebas)");
            System.out.println("2. Modo Rápido (Una sola prueba)");
            System.out.println("3. Configuración del juego");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Introduce un número válido.");
                scanner.next();
                System.out.print("Elige una opción: ");
            }
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine();

            if (opcionPrincipal == 1) {
                int globalJ1 = 0; 
                int globalJ2 = 0; 

                System.out.println("\n--- INICIO DEL MODO CONCURSO ---");
                System.out.println("Repeticiones configuradas: " + config.getRepeticionesPruebas());

                for (int r = 1; r <= config.getRepeticionesPruebas(); r++) {
                    if (config.getRepeticionesPruebas() > 1) {
                        System.out.println("\n>>> Ronda " + r + " de " + config.getRepeticionesPruebas() + " <<<");
                    }

                    for (int i = 0; i < totalPruebas; i++) {
                        System.out.println("\n-> Disputando Prueba " + (i + 1) + ": " + pruebas[i]);
                        int ganadorPrueba = simularEjecucionPrueba(i); 

                        if (ganadorPrueba == 1) {
                            globalJ1++;
                            System.out.println(">> ¡Gana la prueba " + jugador1 + " y suma 1 punto global!");
                        } else if (ganadorPrueba == 2) {
                            globalJ2++;
                            System.out.println(">> ¡Gana la prueba " + jugador2 + " y suma 1 punto global!");
                        } else {
                            System.out.println(">> Empate en la prueba. Ninguno suma punto global.");
                        }
                    }
                }

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
                System.out.println("\n--- SELECCIONA UNA PRUEBA ---");
                for (int i = 0; i < totalPruebas; i++) {
                    System.out.println((i + 1) + ". " + pruebas[i]);
                }
                System.out.print("Introduce el número de la prueba (1-" + totalPruebas + "): ");
                int seleccion = scanner.nextInt() - 1;
                scanner.nextLine();

                if (seleccion >= 0 && seleccion < totalPruebas) {
                    System.out.println("\n--- MODO RÁPIDO: " + pruebas[seleccion] + " ---");
                    
                    if (seleccion == 1) {
                        System.out.println("(Configuración activa - Letras: " + config.getCantidadLetras() + ")");
                    } else if (seleccion == 2) {
                        System.out.println("(Configuración activa - Operaciones: " + config.getCantidadOperaciones() + ")");
                    }

                    int ganadorPrueba = simularEjecucionPrueba(seleccion);

                    if (ganadorPrueba == 1) {
                        System.out.println("¡Ganador de la prueba: " + jugador1 + "!");
                    } else if (ganadorPrueba == 2) {
                        System.out.println("¡Ganador de la prueba: " + jugador2 + "!");
                    } else {
                        System.out.println("La prueba finaliza sin un ganador (Empate).");
                    }
                } else {
                    System.out.println("Error: La prueba seleccionada no es válida.");
                }

            } else if (opcionPrincipal == 3) {
                config.mostrarMenuConfiguracion(scanner);

            } else if (opcionPrincipal == 4) {
                System.out.println("Saliendo del programa. ¡Hasta pronto!");
            } else {
                System.out.println("Opción incorrecta, introduce un número del 1 al 4.");
            }
        }

        scanner.close();
    }

    public static int simularEjecucionPrueba(int indicePrueba) {
        // Enlaza aquí las llamadas reales a tus minijuegos
        return 0; 
    }
}