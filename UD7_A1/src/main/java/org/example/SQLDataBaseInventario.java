package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexion a la base de datos
 *
 * Lee lo parametros de configuracion desde un archivo externo
 * (application.dat) y proporcionan un metodo para obtener la conexion.
 */
public class SQLDataBaseInventario {

    /** Driver JDBC utilizado para la conexion */
    private static String DRIVER;

    /** URL base de la base de datos */
    static String URL;

    /** Esquema de la base de datos */
    private static String SCHEMA;

    /** Usuario de la base de datos */
    static String USUARIO;

    /** Contraseña de la base de datos */
    static String CLAVE;

    /**
     * Bloque estático que se ejecuta al cargar la clase.
     *
     * Se encarga de leer el archivo de configuracion
     * "application.dat" y cargar los parametros necesarios
     * para la conexio a la base de datos.
     */
    static {
        try(
                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/application.dat"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    switch (parts[0].trim()) {
                        case "driver":
                            DRIVER = parts[1].trim();
                            break;
                        case "url":
                            URL = parts[1].trim();
                            break;
                        case "schema":
                            SCHEMA = parts[1].trim();
                            break;
                        case "usuario":
                            USUARIO = parts[1].trim();
                            break;
                        case "clave":
                            CLAVE = parts[1].trim();
                            break;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }

    /**
     * Obtiene una conexion a la base de datos.
     *
     * @return Connection objeto conexion, o null si ocurre un error
     */

    public static Connection getConnection() {
        Connection connection = null;

        try {
            //Cargar el driver JDBC
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        return connection;
    }
}