import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    private static List<Producto> lista = new ArrayList<>();

    public static void main(String[] args) {

        cargarProductosCSV("productos.csv");
        cargarAlmacen("almacen.dat");

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Mostrar Productos");
            System.out.println("2. Eliminar Producto por referencia");
            System.out.println("3. Guardar y Salir");
            System.out.println("4. Registrar Producto");
            System.out.print("Opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        mostrarProductos();
                        break;
                    case 2:
                        eliminarProducto(sc);
                        break;
                    case 3:
                        guardarInventario("inventario.dat");
                        System.out.println("Inventario guardado.");
                        break;
                    case 4:
                        registrarProducto(sc);
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

    private static void cargarProductosCSV(String nombreFichero) {

        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            System.out.println("No existe el archivo CSV.");
            return;
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(nombreFichero),
                        StandardCharsets.UTF_8))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                if (datos.length < 8) {
                    System.out.println("Línea incorrecta en CSV: " + linea);
                    continue;
                }

                Producto p = new Producto(
                        datos[0],
                        datos[1],
                        datos[2],
                        Integer.parseInt(datos[3]),
                        Double.parseDouble(datos[4]),
                        Integer.parseInt(datos[5]),
                        Integer.parseInt(datos[6]),
                        Boolean.parseBoolean(datos[7])
                );

                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Error al cargar CSV: " + e.getMessage());
        }
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
            System.out.println("Error al cargar almacén: " + e.getMessage());
        }
    }

    private static void mostrarProductos() {

        if (lista.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }

        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    private static void eliminarProducto(Scanner sc) {

        System.out.print("Referencia a eliminar: ");
        String ref = sc.nextLine();

        boolean eliminado = lista.removeIf(p -> p.getReferencia().equals(ref));

        if (eliminado) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void registrarProducto(Scanner sc) {

        try {

            System.out.print("Referencia: ");
            String ref = sc.nextLine();

            for (Producto p : lista) {
                if (p.getReferencia().equals(ref)) {
                    System.out.println("Referencia duplicada.");
                    return;
                }
            }

            System.out.print("Descripción: ");
            String desc = sc.nextLine();

            System.out.print("Tipo: ");
            String tipo = sc.nextLine();

            System.out.print("Cantidad: ");
            int cant = sc.nextInt();

            System.out.print("Precio: ");
            double precio = sc.nextDouble();

            System.out.print("Descuento: ");
            int dto = sc.nextInt();

            System.out.print("IVA: ");
            int iva = sc.nextInt();

            System.out.print("Aplicar descuento (true/false): ");
            boolean aplicar = sc.nextBoolean();
            sc.nextLine();

            Producto nuevo = new Producto(ref, desc, tipo, cant, precio, dto, iva, aplicar);
            lista.add(nuevo);

            System.out.println("Producto registrado correctamente.");

        } catch (InputMismatchException | ProductoException e) {
            System.out.println("Error: formato numérico incorrecto.");
            sc.nextLine();
        }
    }

    private static void guardarInventario(String nombreFichero) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(nombreFichero))) {

            oos.writeObject(lista);

        } catch (Exception e) {
            System.out.println("Error al guardar inventario: " + e.getMessage());
        }
    }
}