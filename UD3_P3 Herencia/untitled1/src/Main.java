import java.util.Scanner;

public class Main {

    static Planetas[] planetas = new Planetas[10]; // máximo 10 planetas
    static int numPlanetas = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n--- SISTEMA SOLAR ---");
            System.out.println("1. Insertar planeta");
            System.out.println("2. Eliminar planeta");
            System.out.println("3. Insertar satélite");
            System.out.println("4. Eliminar satélite");
            System.out.println("5. Mostrar sistema solar");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarPlaneta();
                case 2 -> eliminarPlaneta();
                case 3 -> insertarSatelite();
                case 4 -> eliminarSatelite();
                case 5 -> mostrarTodo();
            }

        } while (opcion != 0);
    }

    static void insertarPlaneta() {
        if (numPlanetas < 10) {
            System.out.print("Nombre del planeta: ");
            String nombre = sc.nextLine();
            planetas[numPlanetas] = new Planetas(nombre);
            numPlanetas++;
            System.out.println("Planeta insertado.");
        } else {
            System.out.println("No se pueden añadir más planetas.");
        }
    }

    static void eliminarPlaneta() {
        System.out.print("Nombre del planeta a eliminar: ");
        String nombre = sc.nextLine();

        for (int i = 0; i < numPlanetas; i++) {
            if (planetas[i].getNombre().equalsIgnoreCase(nombre)) {
                planetas[i] = planetas[numPlanetas - 1];
                numPlanetas--;
                System.out.println("Planeta eliminado.");
                return;
            }
        }
        System.out.println("Planeta no encontrado.");
    }

    static void insertarSatelite() {
        System.out.print("Planeta al que pertenece: ");
        String nombrePlaneta = sc.nextLine();

        for (int i = 0; i < numPlanetas; i++) {
            if (planetas[i].getNombre().equalsIgnoreCase(nombrePlaneta)) {
                System.out.print("Nombre del satélite: ");
                String nombreSat = sc.nextLine();
                planetas[i].insertarSatelite(nombreSat);
                return;
            }
        }
        System.out.println("Planeta no encontrado.");
    }

    static void eliminarSatelite() {
        System.out.print("Planeta del satélite: ");
        String nombrePlaneta = sc.nextLine();

        for (int i = 0; i < numPlanetas; i++) {
            if (planetas[i].getNombre().equalsIgnoreCase(nombrePlaneta)) {
                System.out.print("Nombre del satélite a eliminar: ");
                String nombreSat = sc.nextLine();
                planetas[i].eliminarSatelite(nombreSat);
                return;
            }
        }
        System.out.println("Planeta no encontrado.");
    }

    static void mostrarTodo() {
        if (numPlanetas == 0) {
            System.out.println("No hay planetas.");
        } else {
            for (int i = 0; i < numPlanetas; i++) {
                planetas[i].mostrar();
            }
        }
    }
}

