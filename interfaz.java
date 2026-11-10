 import java.util.Scanner;
 
 public class interfaz{


 class ejercicio3cifraexacta {
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

class Ejercicio3palabralarga {
 
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== LA PALABRA MÁS LARGA =====");
 
        String letras = Ejercicio3palabralarga.generarLetras();
 
        int puntosJ1 = turno("Jugador 1", "Jugador 2", letras);
        int puntosJ2 = turno("Jugador 2", "Jugador 1", letras);
 
        System.out.println();
        System.out.println("Jugador 1: " + puntosJ1 + " letras");
        System.out.println("Jugador 2: " + puntosJ2 + " letras");
 
        int ganador = Ejercicio3palabralarga.ganador(puntosJ1, puntosJ2);
        if (ganador == 0) {
            System.out.println("Empate");
        } else {
            System.out.println("¡Gana el jugador " + ganador + "!");
        }
    }

    static int turno(String jugador, String rival, String letras) {
        System.out.println();
        System.out.println("--- Turno de " + jugador + " ---");

        String conEspacios = "";
        for (int i = 0; i < letras.length(); i++) {
            conEspacios = conEspacios + letras.charAt(i) + " ";
        }
        System.out.println("Letras: " + conEspacios);

        String palabra = "";
        while (palabra.isEmpty()) {
            System.out.print("Tu palabra (sin tildes): ");
            palabra = teclado.nextLine().trim().toUpperCase();
            if (palabra.isEmpty()) {
                System.out.println("Error: no has escrito nada.");
            }
        }

        boolean existe = preguntarSiNo(rival + ", ¿existe \"" + palabra + "\" en español? (s/n): ");

        int puntos = Ejercicio3palabralarga.puntosPalabra(palabra, existe, letras);
 
        if (puntos == 0) {
            System.out.println("Palabra no válida: 0 puntos.");
        } else {
            System.out.println("¡Palabra válida! " + puntos + " letras.");
        }
        return puntos;
    }

    static boolean preguntarSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = teclado.nextLine().trim().toLowerCase();
            if (texto.equals("s")) {
                return true;
            }
            if (texto.equals("n")) {
                return false;
            }
            System.out.println("Error: responde s o n.");
        }
    }
}

public class Ejercicio3Calculadorahumana {
 
    static Scanner teclado = new Scanner(System.in);
 

    static int cantidadOperaciones = 5;
 
    public static void main(String[] args) {
        System.out.println("===== LA CALCULADORA HUMANA =====");
        System.out.println(cantidadOperaciones + " operaciones por jugador. Cada fallo suma 20 segundos.");
 
        int segundosJ1 = turno("Jugador 1");
        int segundosJ2 = turno("Jugador 2");
 
        System.out.println();
        System.out.println("Jugador 1: " + segundosJ1 + " segundos");
        System.out.println("Jugador 2: " + segundosJ2 + " segundos");
 
        int ganador = Ejercicio3Calculadorahumana.ganador(segundosJ1, segundosJ2);
        if (ganador == 0) {
            System.out.println("Empate");
        } else {
            System.out.println("¡Gana el jugador " + ganador + "!");
        }
    }
 
    static int turno(String jugador) {
        System.out.println();
        System.out.println("--- Turno de " + jugador + " ---");
        System.out.print("Pulsa Enter cuando estés listo/a...");
        teclado.nextLine();
 
        int actual = Ejercicio3Calculadorahumana.numeroAleatorio(1, 100);   
        int errores = 0;
        long milisegundos = 0;
 
        for (int i = 1; i <= cantidadOperaciones; i++) {
            char operacion = Ejercicio3Calculadorahumana.operacionAleatoria();
            int valor;
            if (operacion == '/') {
                valor = Ejercicio3Calculadorahumana.buscarDivisor(actual);
                if (valor == 0) {
                    operacion = '+';
                    valor = Ejercicio3Calculadorahumana.valorAleatorio(operacion);
                }
            } else {
                valor = Ejercicio3Calculadorahumana.valorAleatorio(operacion);
            }
            int correcto = Ejercicio3Calculadorahumana.calcular(actual, valor, operacion);
 
            long inicio = System.currentTimeMillis();
            int respuesta = leerEntero("(" + i + "/" + cantidadOperaciones + ") "
                    + actual + " " + operacion + " " + valor + " = ");
            milisegundos = milisegundos + (System.currentTimeMillis() - inicio);

            if (respuesta == correcto) {
                System.out.println("¡Correcto!");
            } else {
                errores++;
                System.out.println("Incorrecto. El resultado correcto era " + correcto);
            }

            actual = correcto;
        }
 
        int segundos = Ejercicio3Calculadorahumana.segundosFinales(milisegundos, errores);
        System.out.println(jugador + ": " + errores + " fallo(s), " + segundos + " segundos en total");
        return segundos;
    }

    static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = teclado.nextLine().trim();
            if (Ejercicio3Calculadorahumana.esNumero(texto)) {
                return Integer.parseInt(texto);
            }
            System.out.println("Error: escribe un número entero.");
        }
    }
}
}


class Ejercicio4Interfaz {
 
    static Scanner teclado = new Scanner(System.in);
 
    public static void main(String[] args) {
        System.out.println("===== EL CÓDIGO SECRETO =====");
        System.out.println("He pensado un código de 4 cifras distintas (0-9).");
        System.out.println("Cada jugador tiene 10 intentos.");
 
        String codigo = Ejercicio4Logica.generarCodigo();
 
        int intentosJ1 = turno("Jugador 1", codigo);
        limpiarPantalla(); 
        int intentosJ2 = turno("Jugador 2", codigo);
 
        System.out.println();
        System.out.println("El código era: " + codigo);
        System.out.println("Jugador 1: " + intentosJ1 + " intentos");
        System.out.println("Jugador 2: " + intentosJ2 + " intentos");
 
        int ganador = Ejercicio4Logica.ganador(intentosJ1, intentosJ2);
        if (ganador == 0) {
            System.out.println("Empate");
        } else {
            System.out.println("¡Gana el jugador " + ganador + "!");
        }
    }
 
    static int turno(String jugador, String codigo) {
        System.out.println();
        System.out.println("--- Turno de " + jugador + " ---");
 
        for (int intentos = 1; intentos <= 10; intentos++) {
            String intento;
            while (true) {
                System.out.print("Intento " + intentos + "/10: ");
                intento = teclado.nextLine().trim();
                if (Ejercicio4Logica.intentoValido(intento)) {
                    break;
                }
                System.out.println("Error: escribe 4 dígitos distintos.");
            }
 
            int fijas = Ejercicio4Logica.contarFijas(codigo, intento);
            int medias = Ejercicio4Logica.contarMedias(codigo, intento);
 
            if (fijas == 4) {
                System.out.println("¡Lo has descubierto en " + intentos + " intento(s)!");
                return intentos;
            }
            System.out.println("Fijas: " + fijas + " | Medias: " + medias);
        }
 
        System.out.println("Se acabaron los intentos.");
        return 11;
    }
 
    static void limpiarPantalla() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}