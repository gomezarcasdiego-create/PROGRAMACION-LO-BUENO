import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Taller {

    private HashMap<String, Coche> coches;
    private Scanner sc;

    public Taller() {
        coches = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void anadeCoche() {
        System.out.print("Introduce matrícula: ");
        String matricula = sc.nextLine().toUpperCase();

        if (!validarMatricula(matricula)) {
            System.out.println("Matrícula no válida.");
            return;
        }

        if (coches.containsKey(matricula)) {
            System.out.println("Ya existe un coche con esa matrícula.");
            return;
        }

        System.out.print("Introduce marca: ");
        String marca = sc.nextLine();

        System.out.print("Introduce color: ");
        String color = sc.nextLine();

        Coche coche = new Coche(color, marca, matricula);
        coches.put(matricula, coche);

        System.out.println("Coche añadido correctamente.");
    }

    public void eliminaCoche() {
        System.out.print("Introduce matrícula del coche a eliminar: ");
        String matricula = sc.nextLine().toUpperCase();

        if (coches.remove(matricula) != null) {
            System.out.println("Coche eliminado correctamente.");
        } else {
            System.out.println("No existe ningún coche con esa matrícula.");
        }
    }

    public void visualizaMatriculas() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el taller.");
            return;
        }

        System.out.println("Matrículas en el taller:");
        for (String matricula : coches.keySet()) {
            System.out.println(matricula);
        }
    }

    public void visualizaCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el taller.");
            return;
        }

        System.out.println("Coches en el taller:");
        for (Coche coche : coches.values()) {
            System.out.println("Marca: " + coche.getMarca() +
                    ", Color: " + coche.getColor());
        }
    }

    public void visualizaTaller() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el taller.");
            return;
        }

        System.out.println("Contenido completo del taller:");
        for (Map.Entry<String, Coche> entrada : coches.entrySet()) {
            System.out.println(entrada.getValue().toString());
        }
    }

    private boolean validarMatricula(String matricula) {
        return matricula.matches("\\d{4}[A-Z]{3}");
    }
}

