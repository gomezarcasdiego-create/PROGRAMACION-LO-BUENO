import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    private static final String FICHERO = "Biblioteca.dat";
    private static Map<String, Libro> biblioteca = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cargarFichero();

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 4:
                    guardarFichero();
                    break;
                case 5:
                    guardarFichero();
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n----- BIBLIOTECA -----");
        System.out.println("1. Crear Libro");
        System.out.println("2. Mostrar Libros");
        System.out.println("3. Eliminar Libro por ISBN");
        System.out.println("4. Guardar Libros");
        System.out.println("5. Guardar y Salir");
        System.out.print("Seleccione opción: ");
    }

    private static void crearLibro() {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        if (biblioteca.containsKey(isbn)) {
            System.out.println("Error: El ISBN ya existe.");
            return;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("Fecha publicación (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        Libro libro = new Libro(isbn, titulo, autor, fecha);
        biblioteca.put(isbn, libro);

        System.out.println("Libro registrado correctamente.");
    }

    private static void mostrarLibros() {
        if (biblioteca.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : biblioteca.values()) {
            System.out.println(libro);
        }
    }

    private static void eliminarLibro() {
        System.out.print("Ingrese ISBN a eliminar: ");
        String isbn = sc.nextLine();

        if (biblioteca.remove(isbn) != null) {
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("No existe libro con ese ISBN.");
        }
    }

    private static void guardarFichero() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            oos.writeObject(biblioteca);
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar fichero: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void cargarFichero() {
        File fichero = new File(FICHERO);
        if (!fichero.exists()) {
            System.out.println("No existe fichero previo. Se creará uno nuevo.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
            biblioteca = (Map<String, Libro>) ois.readObject();
            System.out.println("Datos cargados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar fichero: " + e.getMessage());
        }
    }

    public static boolean validarISBN10(String isbn) {
        String cleanIsbn = isbn.replaceAll("-", "");
        if (cleanIsbn.length() != 10) return false;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(cleanIsbn.charAt(i));
            sum += digit * (10 - i);
        }
        char last = cleanIsbn.charAt(9);
        sum += (last == 'X') ? 10 : Character.getNumericValue(last);
        return (sum % 11 == 0);
    }
}