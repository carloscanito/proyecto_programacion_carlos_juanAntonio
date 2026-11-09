import java.util.Scanner;
public class logica {

 
public class Ejercicio1CifraExacta {
 
    static Scanner teclado = new Scanner(System.in);
 
    static String nombreJ1 = "Jugador 1";
    static String nombreJ2 = "Jugador 2";
 
    static int objetivo;                          // número que hay que alcanzar
    static int num1, num2, num3, num4, num5, num6; // los 6 números auxiliares
 
    public static void main(String[] args) {
        System.out.println("===== LA CIFRA EXACTA =====");
 
        String nombre = leerTexto("Nombre del jugador 1 (Enter = Jugador 1): ");
        if (!nombre.isEmpty()) {
            nombreJ1 = nombre;
        }
        nombre = leerTexto("Nombre del jugador 2 (Enter = Jugador 2): ");
        if (!nombre.isEmpty()) {
            nombreJ2 = nombre;
        }
 
        int ganador = rondaCifraExacta();
 
        System.out.println();
        if (ganador == 0) {
            System.out.println("*** Empate ***");
        } else {
            System.out.println("*** ¡Gana " + nombreGanador(ganador) + "! ***");
        }
    }

    static void generarCifra() {
        objetivo = numeroAleatorio(100, 999);
        num1 = numeroAleatorio(1, 10);
        num2 = numeroAleatorio(1, 10);
        num3 = numeroAleatorio(1, 10);
        num4 = numeroAleatorio(1, 10);
        num5 = numeroAleatorio(1, 10);
        num6 = numeroAleatorio(1, 10);
    }
 
    static int numeroAleatorio(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
 
    static boolean esAuxiliar(int n) {
        return n == num1 || n == num2 || n == num3 || n == num4 || n == num5 || n == num6;
    }
 
    static boolean operacionPosible(int a, int b, char operacion) {
        if (operacion == '/') {
            return b != 0 && a % b == 0;
        }
        if (operacion == '-') {
            return a >= b;
        }
        return true;  
    }

    static int calcular(int a, int b, char operacion) {
        if (operacion == '+') {
            return a + b;
        } else if (operacion == '-') {
            return a - b;
        } else if (operacion == '*') {
            return a * b;
        }
        return a / b;
    }

    static boolean esNumero(String texto) {
        int inicio = 0;
        if (texto.startsWith("-")) {
            inicio = 1;
        }
        int cifras = texto.length() - inicio;
        if (cifras < 1 || cifras > 9) {
            return false;
        }
        for (int i = inicio; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    static int ganadorMenor(int valorJ1, int valorJ2) {
        if (valorJ1 < valorJ2) {
            return 1;
        } else if (valorJ2 < valorJ1) {
            return 2;
        }
        return 0;
    }
 
    static String nombreGanador(int ganador) {
        if (ganador == 1) {
            return nombreJ1;
        }
        return nombreJ2;
    }
}