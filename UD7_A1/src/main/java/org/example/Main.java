package org.example;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(SQLDataBaseInventario.getConnection() != null){
            System.out.println("Conectado exitosamente");

            try(Scanner sc = new Scanner(System.in)){
                String opcion = "9";
                do{
                    System.out.println("1. Mostrar todos los Productos en el Inventario.\n" +
                            "2. Buscar producto por referencia.\n" +
                            "3. Buscar productos por tipo.\n" +
                            "4. Buscar producto por cantidad.\n" +
                            "5. Insertar un nuevo producto (no permitir referencias repetidas).\n" +
                            "6. Eliminar Producto por referencia.\n" +
                            "7. Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto).\n" +
                            "8. Insertar un nuevo tipo de producto.\n" +
                            "9. Salir");
                    opcion = sc.nextLine();

                    switch(opcion){
                        case "1":
                            obtenerProductos();
                            break;
                        case "2":

                            break;
                        case "3":
                            break;
                        case "4":
                            break;
                        case "5":
                            break;
                        case "6":
                            break;
                        case "7":
                            break;
                        case "8":
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


    private static void obtenerProductos(){
        List<Producto> productos = SQLDataAccessInventario.getProductos();
        for(Producto producto : productos){
            System.out.println(producto);
        }
    }

    private static void obtenerProductoReferencia(){
        
    }
}