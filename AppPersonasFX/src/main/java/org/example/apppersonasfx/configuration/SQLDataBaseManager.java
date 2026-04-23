package org.example.apppersonasfx.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseManager {
    public  static Connection conexion() {
        Connection connection = null;

        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL =  "jdbc:mysql://localhost:3306/";
        final String SCHEMA = "dawpeople";
        final String USUARIO = "root";
        final String CLAVE = "daw12";

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);
//                System.out.println("Conectado correctamente");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        return connection;
    }

    public static void desconectar(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
