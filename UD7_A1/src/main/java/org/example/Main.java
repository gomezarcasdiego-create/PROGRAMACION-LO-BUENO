package org.example;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(SQLDataBaseInventario.getConnection() != null){
            System.out.println("Conectado exitosamente");

            try(Scanner sc = new Scanner(System.in)){
                String opcion = "9";
                do{
                    menu();
                    opcion = sc.nextLine();

                    switch(opcion){
                        case "1":
                            obtenerProductos();
                            break;
                        case "2":

                            buscarREF(sc);

                            break;
                        case "3":
                            obtenerProductosPorTipo();

                            System.out.println("Ingresa el nombre del tipo");
                            String nombreTipoBuscar = sc.nextLine();
                            break;

                        case "4":
                            if (SQLDataAccessInventario.getProductos().isEmpty()){
                                System.out.println("No encontrado");
                            }else{
                                obtenerProductos();

                                System.out.println("Ingresa la cantidad del producto");
                                int cantadidad = sc.nextInt();


                                List <Producto> pdCant = SQLDataAccessInventario.getProductoCantidad(cantadidad);
                                System.out.println(pdCant);

                            }
                            break;
                        case "5":
                            if(SQLDataAccessInventario.getTipos().isEmpty()){
                                System.out.println("No hay tipos");

                            }else {
                                List<String> referencias = SQLDataAccessInventario.getReferenciasProducto();

                                String refN;
                                do {
                                    System.out.println("Referencia: ");
                                    refN = sc.nextLine();

                                } while (referencias.contains(refN));

                                System.out.println("Nombre producto: ");
                                String nombreN = sc.nextLine();

                                System.out.println("Descripcion producto: ");
                                String descN = sc.nextLine();

                                Scanner Sc = new Scanner(System.in);
                                obtenerTipos();
                                System.out.println("Tipo: ");
                                int idTipo = sc.nextInt();

                                System.out.println("Cantidad producto: ");
                                int cantN = sc.nextInt();

                                System.out.println("Precio producto: ");
                                double precioN = sc.nextDouble();
                                if (precioN < 0) {
                                    System.out.println("Precio inválido");
                                }

                                System.out.println("Descuento nuevo Producto: ");
                                double descuentoN = sc.nextDouble();

                                System.out.println("IVA: ");
                                int iva = sc.nextInt();

                                sc.nextLine();

                                System.out.println("Aplicar descuento a precio (s/n): ");
                                String opcionSub = sc.nextLine();

                                boolean aplicarDto = false;

                                if (opcionSub.equalsIgnoreCase("S") || opcionSub.isBlank()) {
                                    aplicarDto = true;

                                } else if (opcionSub.equalsIgnoreCase("N")) {
                                    aplicarDto = false;
                                }


                                String t5 = "";

                                Tipo tipoSeleccionado = null;

                                for (Tipo t : SQLDataAccessInventario.getTipos()) {
                                    if (t.getId() == idTipo) {
                                        tipoSeleccionado = t;
                                        break;
                                    }
                                }

                                if (tipoSeleccionado != null) {
                                    SQLDataAccessInventario.addProducto(
                                            new Producto(refN, nombreN, descN, tipoSeleccionado, cantN, precioN, (int) descuentoN, iva, aplicarDto)
                                    );
                                } else {
                                    System.out.println("Tipo no válido");
                                }
                            }

                            break;
                        case "6":
                            if (SQLDataAccessInventario.getProductos().isEmpty()) {
                                System.out.println("No hay productos que revisar por cantidad");

                            } else {
                                obtenerProductos();

                                List<String> Productos = SQLDataAccessInventario.getReferenciasProducto();

                                System.out.println("Referencia producto a Eliminar: ");
                                String p = sc.nextLine();


                                if (Productos.contains(p)) {
                                    SQLDataAccessInventario.removeProductoReferencia(p);
                                    System.out.println("Eliminado exitosamente");
                                } else {
                                    System.out.println("No existe el producto");
                                }

                                SQLDataAccessInventario.removeProductoReferencia(p);
                            }
                            break;
                        case "7":
                            if (SQLDataAccessInventario.getProductos().isEmpty()) {
                                System.out.println("No hay productos");

                            } else {

                                System.out.println("Actualizar producto(dame la REF): ");
                                String referenciaB = sc.nextLine();

                                System.out.println("nueva Descripción de el Producto: ");
                                String descripcionN = sc.nextLine();

                                System.out.println("nueva Cantidad de el Producto: ");
                                int cantidadN = sc.nextInt();

                                System.out.println("nuevoPrecio de el Producto: ");
                                double precio = sc.nextDouble();
                                if (precio < 0) {
                                    System.out.println("Precio inválido");
                                }

                                System.out.println("nuevoDescuento de el Producto: ");
                                double descuento = sc.nextDouble();

                                System.out.println("Aplicar descuento a precio (s/n): ");
                                String opcionSub1 = sc.nextLine();

                                boolean aplicarDto1 = false;

                                if (opcionSub1.equalsIgnoreCase("S") || opcionSub1.isBlank()) {
                                    aplicarDto1 = true;

                                } else if (opcionSub1.equalsIgnoreCase("N")) {
                                    aplicarDto1 = false;
                                }

                                SQLDataAccessInventario.updateProducto(referenciaB, descripcionN, cantidadN, precio, (int) descuento, aplicarDto1);

                            }

                            break;
                        case "8":
                            System.out.println("Ingresa el nombre del nuevo tipo: ");
                            String nuevoNombreTipo = sc.nextLine();
                            SQLDataAccessInventario.addTipo(new Tipo(nuevoNombreTipo));
                            System.out.println("Tipo agregado exitosamente.");
                            break;
                        case "9":
                            System.out.println("Saliendo");
                            break;

                        default:
                    }
                }while(!opcion.equals("9"));
                    }
        }else{
            System.out.println("Conexion fallida");
        }
    }

    private static void buscarREF(Scanner sc) {
        List<Producto> productos = SQLDataAccessInventario.getProductos();
        for(Producto producto : productos){
            System.out.println(producto);
        }

        System.out.println("Por favor ingrese la referenica del producto");
        String refBuscar = sc.nextLine();


        Producto pd = SQLDataAccessInventario.getProductoReferencia(refBuscar);
        System.out.println(pd);
    }

    private static void menu() {
        System.out.println("1. Mostrar todos los Productos en el Inventario.\n" +
                "2. Buscar producto por referencia.\n" +
                "3. Buscar productos por tipo.\n" +
                "4. Buscar producto por cantidad.\n" +
                "5. Insertar un nuevo producto (no permitir referencias repetidas).\n" +
                "6. Eliminar Producto por referencia.\n" +
                "7. Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto).\n" +
                "8. Insertar un nuevo tipo de producto.\n" +
                "9. Salir");
    }

    private static void obtenerProductos(){
        List<Producto> productos = SQLDataAccessInventario.getProductos();
        for(Producto producto : productos){
            System.out.println(producto);
        }
    }


    private static void obtenerProductosPorTipo(){
        List<Tipo> tipos = SQLDataAccessInventario.getTipos();
        for(Tipo tipo : tipos){
            System.out.println(tipo);
        }
    }

    private static void obtenerTipos(){
        List<Tipo> tipos = SQLDataAccessInventario.getTipos();

        if(tipos.isEmpty()){
            System.out.println("No encontrado");
        }else{
            System.out.println("Tipos encontrados");
            for(Tipo tipo : tipos){
                System.out.println(tipo);
            }
        }
    }
}