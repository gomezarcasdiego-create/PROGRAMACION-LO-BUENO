import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Producto> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cargar();

        int opcion;
        do {
            System.out.println("\n1. Crear producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Guardar en fichero");
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
    }

    static void mostrar() {
        for (Producto p : lista) {
            System.out.println(p);
        }
        int cantidad = lista.size();
        if (cantidad == 0) {
            System.out.println("No existe el producto");
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
        System.out.println("No encontrado");
    }

    static void guardar() {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("Almacen.dat"));
            oos.writeObject(lista);
            oos.close();
            System.out.println("Guardado correctamente");
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
        int cantidad  = lista.size();
        if (cantidad == 0){
            System.out.println("No hay producto para guardar");
        }
    }

    static void cargar() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("Almacen.dat"));
            lista = (ArrayList<Producto>) ois.readObject();
            ois.close();
        } catch (Exception e) {
        }
    }
}
