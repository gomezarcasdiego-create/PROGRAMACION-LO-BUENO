package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del programa.
 *
 * Contiene el menú interactivo para gestionar el inventario:
 * productos y tipos almacenados en base de datos.
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args argumentos de entrada
     */
    public static void main(String[] args) {

        // Comprobación de conexión a la base de datos
        if (SQLDataBaseInventario.getConnection() != null) {
            System.out.println("Conectado exitosamente");

            try (Scanner sc = new Scanner(System.in)) {

                String opcion = "9";

                // Bucle principal del menú
                do {
                    menu();
                    opcion = sc.nextLine();

                    switch (opcion) {

                        case "1":
                            // Mostrar todos los productos
                            obtenerProductos();
                            break;

                        case "2":
                            // Buscar producto por referencia
                            buscarREF(sc);
                            break;

                        case "3":
                            // Mostrar tipos y pedir uno
                            obtenerProductosPorTipo();
                            System.out.println("Ingresa el nombre del tipo");
                            String nombreTipoBuscar = sc.nextLine();
                            break;

                        case "4":
                            // Buscar producto por cantidad
                            if (SQLDataAccessInventario.getProductos().isEmpty()) {
                                System.out.println("No encontrado");
                            } else {
                                obtenerProductos();

                                System.out.println("Ingresa la cantidad del producto");
                                int cantidad = sc.nextInt();

                                List<Producto> pdCant =
                                        SQLDataAccessInventario.getProductoCantidad(cantidad);

                                System.out.println(pdCant);
                            }
                            break;

                        case "5":
                            // Insertar producto
                            if (SQLDataAccessInventario.getTipos().isEmpty()) {
                                System.out.println("No hay tipos");

                            } else {

                                List<String> referencias =
                                        SQLDataAccessInventario.getReferenciasProducto();

                                String refN;

                                // Validar referencia única
                                do {
                                    System.out.println("Referencia: ");
                                    refN = sc.nextLine();
                                } while (referencias.contains(refN));

                                System.out.println("Nombre producto: ");
                                String nombreN = sc.nextLine();

                                System.out.println("Descripcion producto: ");
                                String descN = sc.nextLine();

                                obtenerTipos();

                                System.out.println("Tipo (ID): ");
                                int idTipo = sc.nextInt();

                                System.out.println("Cantidad producto: ");
                                int cantN = sc.nextInt();

                                System.out.println("Precio producto: ");
                                double precioN = sc.nextDouble();

                                System.out.println("Descuento: ");
                                double descuentoN = sc.nextDouble();

                                System.out.println("IVA: ");
                                int iva = sc.nextInt();

                                sc.nextLine(); // limpiar buffer

                                System.out.println("Aplicar descuento (s/n): ");
                                String opcionSub = sc.nextLine();

                                boolean aplicarDto =
                                        opcionSub.equalsIgnoreCase("S") || opcionSub.isBlank();

                                // Buscar tipo seleccionado
                                Tipo tipoSeleccionado = null;

                                for (Tipo t : SQLDataAccessInventario.getTipos()) {
                                    if (t.getId() == idTipo) {
                                        tipoSeleccionado = t;
                                        break;
                                    }
                                }

                                if (tipoSeleccionado != null) {
                                    SQLDataAccessInventario.addProducto(
                                            new Producto(refN, nombreN, descN,
                                                    tipoSeleccionado, cantN,
                                                    precioN, (int) descuentoN,
                                                    iva, aplicarDto)
                                    );
                                } else {
                                    System.out.println("Tipo no válido");
                                }
                            }
                            break;

                        case "6":
                            // Eliminar producto
                            if (SQLDataAccessInventario.getProductos().isEmpty()) {
                                System.out.println("No hay productos");

                            } else {

                                obtenerProductos();

                                List<String> productos =
                                        SQLDataAccessInventario.getReferenciasProducto();

                                System.out.println("Referencia a eliminar:");
                                String p = sc.nextLine();

                                if (productos.contains(p)) {
                                    SQLDataAccessInventario.removeProductoReferencia(p);
                                    System.out.println("Eliminado correctamente");
                                } else {
                                    System.out.println("No existe");
                                }
                            }
                            break;

                        case "7":
                            // Actualizar producto
                            if (SQLDataAccessInventario.getProductos().isEmpty()) {
                                System.out.println("No hay productos");

                            } else {

                                System.out.println("Referencia:");
                                String referenciaB = sc.nextLine();

                                System.out.println("Nueva descripción:");
                                String descripcionN = sc.nextLine();

                                System.out.println("Nueva cantidad:");
                                int cantidadN = sc.nextInt();

                                System.out.println("Nuevo precio:");
                                double precio = sc.nextDouble();

                                System.out.println("Nuevo descuento:");
                                double descuento = sc.nextDouble();

                                sc.nextLine();

                                System.out.println("Aplicar descuento (s/n):");
                                String opcionSub1 = sc.nextLine();

                                boolean aplicarDto1 =
                                        opcionSub1.equalsIgnoreCase("S") || opcionSub1.isBlank();

                                SQLDataAccessInventario.updateProducto(
                                        referenciaB, descripcionN,
                                        cantidadN, precio,
                                        (int) descuento, aplicarDto1
                                );
                            }
                            break;

                        case "8":
                            // Insertar tipo
                            System.out.println("Nombre del tipo:");
                            String nuevoNombreTipo = sc.nextLine();

                            SQLDataAccessInventario.addTipo(
                                    new Tipo(nuevoNombreTipo)
                            );

                            System.out.println("Tipo agregado");
                            break;

                        case "9":
                            System.out.println("Saliendo");
                            break;
                    }

                } while (!opcion.equals("9"));
            }

        } else {
            System.out.println("Conexion fallida");
        }
    }

    /**
     * Busca un producto por referencia.
     */
    private static void buscarREF(Scanner sc) {
        List<Producto> productos = SQLDataAccessInventario.getProductos();

        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println("Referencia:");
        String refBuscar = sc.nextLine();

        Producto pd = SQLDataAccessInventario.getProductoReferencia(refBuscar);
        System.out.println(pd);
    }

    /**
     * Muestra el menú principal.
     */
    private static void menu() {
        System.out.println("""
                1. Mostrar productos
                2. Buscar por referencia
                3. Buscar por tipo
                4. Buscar por cantidad
                5. Insertar producto
                6. Eliminar producto
                7. Actualizar producto
                8. Insertar tipo
                9. Salir
                """);
    }

    /**
     * Muestra todos los productos.
     */
    private static void obtenerProductos() {
        List<Producto> productos = SQLDataAccessInventario.getProductos();

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    /**
     * Muestra todos los tipos.
     */
    private static void obtenerProductosPorTipo() {
        List<Tipo> tipos = SQLDataAccessInventario.getTipos();

        for (Tipo tipo : tipos) {
            System.out.println(tipo);
        }
    }

    /**
     * Muestra los tipos disponibles.
     */
    private static void obtenerTipos() {
        List<Tipo> tipos = SQLDataAccessInventario.getTipos();

        if (tipos.isEmpty()) {
            System.out.println("No encontrado");
        } else {
            for (Tipo tipo : tipos) {
                System.out.println(tipo);
            }
        }
    }
}