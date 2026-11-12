public class configuracion {
    // valores por defecto
    private int repeticionesPruebas = 1;
    private int cantidadLetras = 8; // minimo 4 vocales y 4 consonantes por defecto
    private int cantidadOperaciones = 5;

    // metodo para mostrar y cambiar la configuración
    public void mostrarMenuConfiguracion(java.util.Scanner scanner) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- MENÚ DE CONFIGURACIÓN ---");
            System.out.println("1. Repeticiones de pruebas (actual: " + repeticionesPruebas + ")");
            System.out.println("2. Cantidad de letras (actual: " + cantidadLetras + ")");
            System.out.println("3. Cantidad de operaciones (actual: " + cantidadOperaciones + ")");
            System.out.println("4. Salir de configuración");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("introduce nuevas repeticiones (mínimo 1): ");
                int rep = scanner.nextInt();
                if (rep >= 1) {
                    repeticionesPruebas = rep;
                    System.out.println("configuración actualizada.");
                } else {
                    System.out.println("valor inválido.");
                }
            } else if (opcion == 2) {
                System.out.print("introduce cantidad de letras (mínimo 8, ej: 4 vocales y 4 consonantes): ");
                int letras = scanner.nextInt();
                // debe cumplir al menos 4 vocales y 4 consonantes, por lo que el total mínimo es 8
                if (letras >= 8) {
                    cantidadLetras = letras;
                    System.out.println("configuración actualizada.");
                } else {
                    System.out.println("error: debe ser al menos 8 para cumplir la norma.");
                }
            } else if (opcion == 3) {
                System.out.print("introduce cantidad de operaciones (mínimo 1): ");
                int ops = scanner.nextInt();
                if (ops >= 1) {
                    cantidadOperaciones = ops;
                    System.out.println("configuración actualizada.");
                } else {
                    System.out.println("valor inválido.");
                }
            }
        }
    }

    // getters para que el juego pueda leer los valores configurados
    public int getRepeticionesPruebas() {
        return repeticionesPruebas;
    }

    public int getCantidadLetras() {
        return cantidadLetras;
    }

    public int getCantidadOperaciones() {
        return cantidadOperaciones;
    }
}
