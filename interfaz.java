public class interfaz {
    static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine().trim();
    }
    static int leerEnteroLibre(String mensaje) {
        while (true) {
            String texto = leerTexto(mensaje);
            if (esNumero(texto)) {
                return Integer.parseInt(texto);
            }
            System.out.println("Error: escribe un número entero.");
        }
    }
    static char leerOperacion() {
        while (true) {
            String texto = leerTexto("Operación (+, -, *, /): ");
            if (texto.length() == 1 && "+-*/".indexOf(texto.charAt(0)) >= 0) {
                return texto.charAt(0);
            }
            System.out.println("Error: escribe solo + - * o /");
        }
    }
    static int leerAuxiliar(String mensaje) {
        while (true) {
            int n = leerEnteroLibre(mensaje);
            if (esAuxiliar(n)) {
                return n;
            }
            System.out.println("Error: ese número no está en la lista.");
        }
    }
    static int rondaCifraExacta() {
        generarCifra();
 
        int resultadoJ1 = turnoCifraExacta(nombreJ1);
        int resultadoJ2 = turnoCifraExacta(nombreJ2);
 
        int difJ1 = Math.abs(objetivo - resultadoJ1);
        int difJ2 = Math.abs(objetivo - resultadoJ2);
 
        System.out.println();
        System.out.println("Objetivo: " + objetivo);
        System.out.println(nombreJ1 + ": " + resultadoJ1 + " (diferencia " + difJ1 + ")");
        System.out.println(nombreJ2 + ": " + resultadoJ2 + " (diferencia " + difJ2 + ")");
 
        return ganadorMenor(difJ1, difJ2);   
    }
    static int turnoCifraExacta(String jugador) {
        System.out.println();
        System.out.println("--- Turno de " + jugador + " ---");
        System.out.println("Objetivo: " + objetivo);
        System.out.println("Números: " + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6);
 
        int resultado = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println();
            System.out.println("Operación " + i + " de 5");
 
            int a;
            if (i == 1) {
                a = leerAuxiliar("Primer número: ");
            } else {
                a = resultado;
                System.out.println("Resultado actual: " + a);
            }

            int b;
            char operacion;
            boolean posible;
            do {
                b = leerAuxiliar("Segundo número: ");
                operacion = leerOperacion();
                posible = operacionPosible(a, b, operacion);
                if (!posible) {
                    System.out.println("No se puede (dividir entre 0, división no exacta o resta negativa).");
                }
            } while (!posible);
 
            resultado = calcular(a, b, operacion);
            System.out.println(a + " " + operacion + " " + b + " = " + resultado);
        }
        return resultado;
    }
}