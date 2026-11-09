import java.util.Scanner;

public class modo_juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // definimos los nombres de las pruebas en un array simple
        String[] pruebas = {"Carrera de Obstáculos", "Trivial Matemático", "Pulso de Velocidad"};
        int totalPruebas = pruebas.length;

        // nombres de los jugadores
        String jugador1 = "Jugador 1";
        String jugador2 = "Jugador 2";

        // menu principal elegir modo
        System.out.println("SELECCIONA EL MODO DE JUEGO");
        System.out.println("1. Modo Concurso (Todas las pruebas)");
        System.out.println("2. Modo Rápido (Una sola prueba)");
        System.out.print("Elige opción (1 o 2): ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            // modo concurso
            int globalJ1 = 0; 
            int globalJ2 = 0; 

            System.out.println("\n--- INICIO DEL MODO CONCURSO ---");

            //recorremos todas las pruebas una a una
            for (int i = 0; i < totalPruebas; i++) {
                System.out.println("\nPrueba " + (i + 1) + ": " + pruebas[i]);

                //marcador de la prueba
                System.out.print("Puntos de " + jugador1 + " en esta prueba: ");
                int puntosPruebaJ1 = scanner.nextInt();

                System.out.print("Puntos de " + jugador2 + " en esta prueba: ");
                int puntosPruebaJ2 = scanner.nextInt();
                //logica puntos
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
            // resultado final 
            System.out.println("\n=== FIN DEL CONCURSO ===");
            System.out.println("Marcador Global -> " + jugador1 + ": " + globalJ1 + " pts | " + jugador2 + ": " + globalJ2 + " pts");

            if (globalJ1 > globalJ2) {
                System.out.println("¡El ganador del concurso es " + jugador1 + "!");
            } else if (globalJ2 > globalJ1) {
                System.out.println("¡El ganador del concurso es " + jugador2 + "!");
            } else {
                System.out.println("El concurso ha finalizado en EMPATE.");
            }

        } else if (opcion == 2) {
            // modo rapido
            System.out.println("\n--- SELECCIONA UNA PRUEBA ---");
            for (int i = 0; i < totalPruebas; i++) {
                System.out.println(i + ". " + pruebas[i]);
            }
            System.out.print("Introduce el número de la prueba: ");
            int seleccion = scanner.nextInt();

            // validamos que la prueba exista
            if (seleccion >= 0 && seleccion < totalPruebas) {
                System.out.println("\n--- MODO RÁPIDO: " + pruebas[seleccion] + " ---");

                System.out.print("Puntos de " + jugador1 + ": ");
                int puntosPruebaJ1 = scanner.nextInt();

                System.out.print("Puntos de " + jugador2 + ": ");
                int puntosPruebaJ2 = scanner.nextInt();

                // logica del modo rápido
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

        } else {
            System.out.println("Opción incorrecta.");
        }

        scanner.close();
    }
}