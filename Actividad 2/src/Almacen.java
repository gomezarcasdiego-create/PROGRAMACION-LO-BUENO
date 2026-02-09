import java.io.*;
import java.util.*;

public class Almacen {

    static ArrayList<Producto> productos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FICHERO = "Almacen.dat";

    public static void main(String[] args) {

        cargarFichero();

        int opcion;
        do {
            System.out.println("\n1. Crear producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Guardar cambios");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: crearProducto(); break;
                case 2: mostrarProductos(); break;
                case 3: eliminarProducto(); break;
                case 4: guardarFichero(); break;
            }

        } while (opcion != 5);
    }

    static void crearProducto() {
        System.out.print("Código: ");
        int c = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String n = sc.nextLine();

        System.out.print("Cantidad: ");
        int ca = sc.nextInt();

        System.out.print("Precio: ");
        double p = sc.nextDouble();

        productos.add(new Producto(c, n, ca, p));
        System.out.println("Producto añadido");
    }

    static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    static void eliminarProducto() {
        System.out.print("Código a eliminar: ");
        int c = sc.nextInt();

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).codigo == c) {
                productos.remove(i);
                System.out.println("Producto eliminado");
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    static void guardarFichero() {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FICHERO));
            oos.writeObject(productos);
            oos.close();
            System.out.println("Cambios guardados");
        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }

    static void cargarFichero() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FICHERO));
            productos = (ArrayList<Producto>) ois.readObject();
            ois.close();
            System.out.println("Stock cargado desde fichero");
        } catch (Exception e) {
            System.out.println("No existe fichero, almacén vacío");
        }
    }
}