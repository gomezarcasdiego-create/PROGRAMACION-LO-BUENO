package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de acceso a datos (dao) para gestionar productos y tipos en base de datos.
 *
 * Contiene metodos crud (create, read, update, delete)
 * Sobre las tablas "productos" y "tipo"
 */
public class SQLDataAccessInventario {

    /**
     *Inserta un nuevo producto en la base de datos
     *
     * @param p Producto a insertar
     */
    public static void addProducto(Producto p) {
        String sql = "INSERT INTO productos (Id, Referencia, Nombre, Descripcion, Tipo, Cantidad, Precio, Descuento, Iva, AplicarDto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            //Asignacion de parametros
            statement.setInt(1, p.getId());
            statement.setNString(2, p.getReferencia());
            statement.setNString(3, p.getNombre());
            statement.setNString(4, p.getDescripcion());
            statement.setNString(5, p.getTipo().getNombre());
            statement.setInt(6, p.getCantidad());
            statement.setDouble(7, p.getPrecio());
            statement.setInt(8, p.getDescuento());
            statement.setInt(9, p.getIva());
            statement.setBoolean(10, p.isAplicarDto());

            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Inserta un nuevo tipo en la base de datos
     *
     * @param t Tipo a insertar
     */

    public static void addTipo(Tipo t) {
        String sql = "INSERT INTO tipo VALUES (?)";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setNString(1, t.getNombre());

            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene todos los products de la base de datos.
     *
     * @return Lista de productos
     */
    public static List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = SQLDataBaseInventario.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {

                // Crear tipo a partir del resultado
                Tipo t = new Tipo(rs.getNString("TIPO"));

                //Crear producto
                Producto p = new Producto(
                        rs.getInt("Id"),
                        rs.getString("Referencia"),
                        rs.getString("Nombre"),
                        rs.getString("Descripcion"),
                        t,
                        rs.getInt("Cantidad"),
                        rs.getDouble("Precio"),
                        rs.getInt("Descuento"),
                        rs.getInt("Iva"),
                        rs.getBoolean("AplicarDto")
                );
                productos.add(p);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return productos;
    }

    /**
     * Obtiene todos los tipos disponibles.
     *
     * @return Lista de tipos
     */
    public static List<Tipo> getTipos() {
        List<Tipo> tipos = new ArrayList<>();
        String sql = "SELECT * FROM tipo";

        try (Connection con = SQLDataBaseInventario.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {

                Tipo t = new Tipo(
                        rs.getInt("ID"),
                        rs.getNString("NOMBRE")
                );

                tipos.add(t);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return tipos;
    }

    /**
     * Obtiene un producto a partir de su refenrecia
     *
     * @param ref Referencia del producto
     * @return Producto encontrado o null
     */
    public static Producto getProductoReferencia(String ref) {

        String sql = "SELECT * FROM productos WHERE Referencia = ?";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, ref);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    Tipo t = new Tipo(rs.getString("TIPO"));

                    Producto p = new Producto(
                            rs.getInt("Id"),
                            rs.getString("Referencia"),
                            rs.getString("Nombre"),
                            rs.getString("Descripcion"),
                            t,
                            rs.getInt("Cantidad"),
                            rs.getDouble("Precio"),
                            rs.getInt("Descuento"),
                            rs.getInt("Iva"),
                            rs.getBoolean("AplicarDto")
                    );

                    return p;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Obtiene productos filtrados por tipo
     *
     * @param tipo Nombre del tipo
     * @return Lista de productos
     */
    public static List<Producto> getProductosTipo(String tipo){
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE tipo = ?";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setNString(1, tipo);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    Tipo t = new Tipo(rs.getString("TIPO"));

                    Producto p = new Producto(
                            rs.getInt("Id"),
                            rs.getString("Referencia"),
                            rs.getString("Nombre"),
                            rs.getString("Descripcion"),
                            t,
                            rs.getInt("Cantidad"),
                            rs.getDouble("Precio"),
                            rs.getInt("Descuento"),
                            rs.getInt("Iva"),
                            rs.getBoolean("AplicarDto")
                    );
                    productos.add(p);
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productos;
    }


    public static List<Producto> getProductoCantidad(int cantidad){
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE Cantidad = ?";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, cantidad);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    Tipo t = new Tipo(rs.getString("TIPO"));

                    Producto p = new Producto(
                            rs.getInt("Id"),
                            rs.getString("Referencia"),
                            rs.getString("Nombre"),
                            rs.getString("Descripcion"),
                            t,
                            rs.getInt("Cantidad"),
                            rs.getDouble("Precio"),
                            rs.getInt("Descuento"),
                            rs.getInt("Iva"),
                            rs.getBoolean("AplicarDto")
                    );
                    productos.add(p);
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productos;
    }

    /**
     * Elimina un producto segun su referencia
     *
     * @param ref Referencia del producto
     */
    public static void removeProductoReferencia(String ref){
        String sql = "DELETE FROM productos WHERE Referencia=?";

        try(Connection con = SQLDataBaseInventario.getConnection();
            PreparedStatement statement = con.prepareStatement(sql)){

            statement.setNString(1, ref);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un producto.
     *
     * @param referencia
     * @param des
     * @param cant
     * @param precio
     * @param descuento
     * @param aplicarDto
     */
    public static void updateProducto(String referencia, String des, int cant, double precio, int descuento, boolean aplicarDto){
        String sql = "UPDATE FROM productos SET Descripcion = ?, Cantidad = ?, Precio= ?, Descuento= ?, AplicarDto= ? WHERE Referencia = ?";

        try(Connection con = SQLDataBaseInventario.getConnection();
            PreparedStatement statement = con.prepareStatement(sql)){

            statement.setNString(1, des);
            statement.setInt(2, cant);
            statement.setDouble(3, precio);
            statement.setInt(4, descuento);
            statement.setBoolean(5, aplicarDto);
            statement.setNString(6, referencia);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Obtiene todas los referencias de productos.
     *
     * @return Lista de referencias
     */
    public static List<String> getReferenciasProducto(){
        List<String> referencias = new ArrayList<>();

        String sql = "SELECT Referencia FROM Productos";

        try(Connection con = SQLDataBaseInventario.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql)){

            while(rs.next()){
                referencias.add(rs.getNString("Referencia"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return referencias;
    }

    public static void buscarTipo(String nombre){

        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM tipo WHERE nombre = ?";


    }
}