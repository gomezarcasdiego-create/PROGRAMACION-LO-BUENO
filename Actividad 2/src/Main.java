import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Producto> lista = new ArrayList<>();
    static final String FICHERO = "Almacen.dat";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cargar();  // 🔹 Cargar datos al iniciar

        int opcion;

        do {
            System.out.println("\n1. Crear producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Guardar productos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: crear(); break;
                case 2: mostrar(); break;
                case 3: eliminar(); break;
                case 4: guardar(); break;
            }

        } while (opcion != 5);
    }

    static void crear() {
        System.out.print("Código: ");
        int c = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String n = sc.nextLine();

        System.out.print("Cantidad: ");
        int ca = sc.nextInt();

        System.out.print("Precio: ");
        double p = sc.nextDouble();

        lista.add(new Producto(c, n, ca, p));
        System.out.println("Producto añadido");
    }

    static void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("No hay productos");
        } else {
            for (Producto p : lista) {
                System.out.println(p);
            }
        }
    }

    static void eliminar() {
        System.out.print("Código a eliminar: ");
        int c = sc.nextInt();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).codigo == c) {
                lista.remove(i);
                System.out.println("Producto eliminado");
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    static void guardar() {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FICHERO));
            oos.writeObject(lista);
            oos.close();
            System.out.println("Datos guardados en Almacen.dat");
        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }

    static void cargar() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FICHERO));
            lista = (ArrayList<Producto>) ois.readObject();
            ois.close();
            System.out.println("Datos cargados del fichero");
        } catch (Exception e) {
            System.out.println("No existe fichero, almacén vacío");
        }
    }
}