import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import java.util.ArrayList;
import java.util.List;



public class Main {

    private static BufferedReader BufferedReader;

    public class Inventario {
        static List<Producto> productos = new ArrayList<>();
    }

    private static List<Producto> lista = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        cargarProductosCSV("productos.csv");
        cargarAlmacen("almacen.dat");

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Mostrar Productos");
            System.out.println("2. Eliminar Producto por referencia");
            System.out.println("3. Guardar y Salir");
            System.out.print("Opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        mostrarProductos();
                        break;
                    case 2:
                        eliminarProducto();
                        break;
                    case 3:
                        guardarInventario("inventario.dat");
                        System.out.println("Inventario guardado.");
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número.");
                sc.nextLine();
            }

        } while (opcion != 3);

        sc.close();
    }

    private static void guardarInventario(String s) {
    }

    private static boolean cargarProductosCSV(String nombreFichero) throws IOException {

        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            System.out.println("No existe el archivo CSV.");
            return false;
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(nombreFichero),
                        StandardCharsets.UTF_8))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                if (datos.length < 5) {
                    System.out.println("" + linea);

                }
            }

        }
        return false;
    }


    private static void cargarAlmacen(String nombreFichero) {

        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            System.out.println("No existe almacen.dat, se crea nuevo inventario.");
            return;
        }


        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(nombreFichero))) {

            lista = (List<Producto>) ois.readObject();

        } catch (Exception e) {
            System.out.println("");
        }
    }

    public static void mostrarProductos() {
        try {
            BufferedReader  = new BufferedReader(new FileReader("productos.csv"));
            String linea;

            while ((linea = readLine()) != null) {
                System.out.println(linea);
            }

            close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

    }

    private static String readLine() {
        return "";
    }


    public static void eliminarProducto() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la referencia a eliminar: ");
        String ref = sc.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader("productos.csv"));
            ArrayList<String> lineas = new ArrayList<>();
            String linea;
            boolean eliminado = false;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                if (!datos[1].equalsIgnoreCase(ref)) {
                    lineas.add(linea);
                } else {
                    eliminado = true;
                }
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("productos.csv"));

            for (String l : lineas) {
                bw.write(l);
                bw.newLine();
            }

            bw.close();

            if (eliminado) {
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("No se encontró esa referencia.");
            }

        } catch (IOException e) {
            System.out.println("Error con el archivo.");
        }
    }
}