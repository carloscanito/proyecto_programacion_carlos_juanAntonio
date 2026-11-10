import java.util.Scanner;
public class logica {

 
public class Ejercicio3CifraExacta {
 
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





 class Ejercicio3palabralarga {

    static int numeroAleatorio(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    static char letraAleatoria(String conjunto) {
        return conjunto.charAt(numeroAleatorio(0, conjunto.length() - 1));
    }

    static String mezclar(String texto) {
        String resultado = "";
        while (texto.length() > 0) {
            int pos = numeroAleatorio(0, texto.length() - 1);
            resultado = resultado + texto.charAt(pos);
            texto = texto.substring(0, pos) + texto.substring(pos + 1);
        }
        return resultado;
    }

    static String generarLetras() {
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJLMNÑPQRSTVXZ";
        String resultado = "";
 
        for (int i = 0; i < 4; i++) {         
            resultado = resultado + letraAleatoria(vocales);
        }
        for (int i = 0; i < 4; i++) {        
            resultado = resultado + letraAleatoria(consonantes);
        }
        for (int i = 8; i < 10; i++) {        
            if (numeroAleatorio(1, 100) <= 40) {
                resultado = resultado + letraAleatoria(vocales);
            } else {
                resultado = resultado + letraAleatoria(consonantes);
            }
        }
        return mezclar(resultado);
    }

    static int contarLetra(String texto, char letra) {
        int veces = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == letra) {
                veces++;
            }
        }
        return veces;
    }

    static boolean sePuedeFormar(String palabra, String disponibles) {
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (contarLetra(palabra, c) > contarLetra(disponibles, c)) {
                return false;
            }
        }
        return true;
    }

    static int puntosPalabra(String palabra, boolean existe, String disponibles) {
        if (existe && sePuedeFormar(palabra, disponibles)) {
            return palabra.length();
        }
        return 0;
    }

    static int ganador(int puntosJ1, int puntosJ2) {
        if (puntosJ1 > puntosJ2) {
            return 1;
        } else if (puntosJ2 > puntosJ1) {
            return 2;
        }
        return 0;
    }
}
}





 class Ejercicio3Calculadorahumana {
 
    static int numeroAleatorio(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
 
    static char operacionAleatoria() {
        int n = numeroAleatorio(1, 4);
        if (n == 1) {
            return '+';
        } else if (n == 2) {
            return '-';
        } else if (n == 3) {
            return '*';
        }
        return '/';
    }
 
    static int valorAleatorio(char operacion) {
        if (operacion == '+' || operacion == '-') {
            return numeroAleatorio(10, 99);
        }
        return numeroAleatorio(2, 9);
    }
 
    static int buscarDivisor(int numero) {
        for (int intento = 0; intento < 30; intento++) {
            int candidato = numeroAleatorio(2, 9);
            if (numero % candidato == 0) {
                return candidato;
            }
        }
        return 0;
    }

    static int calcular(int numero, int valor, char operacion) {
        if (operacion == '+') {
            return numero + valor;
        } else if (operacion == '-') {
            return numero - valor;
        } else if (operacion == '*') {
            return numero * valor;
        }
        return numero / valor;
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
 
    static int segundosFinales(long milisegundos, int errores) {
        return (int) (milisegundos / 1000) + errores * 20;
    }
 
    static int ganador(int segundosJ1, int segundosJ2) {
        if (segundosJ1 < segundosJ2) {
            return 1;
        } else if (segundosJ2 < segundosJ1) {
            return 2;
        }
        return 0;
    }
}




class Ejercicio4Logica {
 
    static int numeroAleatorio(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    static String generarCodigo() {
        String codigo = "";
        while (codigo.length() < 4) {
            char cifra = (char) ('0' + numeroAleatorio(0, 9));
            if (codigo.indexOf(cifra) < 0) {   
                codigo = codigo + cifra;
            }
        }
        return codigo;
    }

    static int contarCaracter(String texto, char caracter) {
        int veces = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == caracter) {
                veces++;
            }
        }
        return veces;
    }

    static boolean intentoValido(String intento) {
        if (intento.length() != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            char c = intento.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
            if (contarCaracter(intento, c) > 1) {
                return false;
            }
        }
        return true;
    }

    static int contarFijas(String codigo, String intento) {
        int fijas = 0;
        for (int i = 0; i < 4; i++) {
            if (codigo.charAt(i) == intento.charAt(i)) {
                fijas++;
            }
        }
        return fijas;
    }

    static int contarMedias(String codigo, String intento) {
        int medias = 0;
        for (int i = 0; i < 4; i++) {
            char c = intento.charAt(i);
            if (codigo.charAt(i) != c && codigo.indexOf(c) >= 0) {
                medias++;
            }
        }
        return medias;
    }

    static int ganador(int intentosJ1, int intentosJ2) {
        if (intentosJ1 < intentosJ2) {
            return 1;
        } else if (intentosJ2 < intentosJ1) {
            return 2;
        }
        return 0;
    }
}
