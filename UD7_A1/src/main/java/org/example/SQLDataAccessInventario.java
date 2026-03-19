package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLDataAccessInventario {

    public static void addProducto(Producto p) {
        String sql = "INSERT INTO PRODUCTOS VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setNString(1, p.getReferencia());
            statement.setNString(2, p.getNombre());
            statement.setNString(3, p.getDescripcion());
            statement.setNString(4, p.getTipo().getNombre());
            statement.setInt(5, p.getCantidad());
            statement.setDouble(6, p.getPrecio());
            statement.setInt(7, p.getDescuento());
            statement.setInt(8, p.getIva());
            statement.setBoolean(9, p.isAplicarDto());

            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addTipo(Tipo t) {
        String sql = "INSERT INTO TIPO VALUES (?)";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setNString(1, t.getNombre());

            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTOS";

        try (Connection con = SQLDataBaseInventario.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {

                Tipo t = new Tipo(rs.getNString("TIPO"));

                Producto p = new Producto(
                        rs.getInt("ID"),
                        rs.getNString("REFERENCIA"),
                        rs.getNString("NOMBRE"),
                        rs.getNString("DESCRIPCION"),
                        t,
                        rs.getInt("CANTIDAD"),
                        rs.getDouble("PRECIO"),
                        rs.getInt("DESCUENTO"),
                        rs.getInt("IVA"),
                        rs.getBoolean("APLICARDTO")
                );
                productos.add(p);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return productos;
    }

    public static List<Tipo> getTipos() {
        List<Tipo> tipos = new ArrayList<>();
        String sql = "SELECT * FROM TIPOS";

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

    public static Producto getProductoReferencia(String referencia) {

        String sql = "SELECT * FROM PRODUCTOS WHERE REFERENCIA = ?";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, referencia);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    Tipo t = new Tipo(rs.getString("TIPO"));

                    Producto p = new Producto(
                            rs.getInt("ID"),
                            rs.getString("REFERENCIA"),
                            rs.getString("NOMBRE"),
                            rs.getString("DESCRIPCION"),
                            t,
                            rs.getInt("CANTIDAD"),
                            rs.getDouble("PRECIO"),
                            rs.getInt("DESCUENTO"),
                            rs.getInt("IVA"),
                            rs.getBoolean("APLICARDTO")
                    );

                    return p;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static List<Producto> getProductosTipo(String tipo){
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTOS WHERE TIPO = ?";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setNString(1, tipo);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    Tipo t = new Tipo(rs.getString("TIPO"));

                    Producto p = new Producto(
                            rs.getInt("ID"),
                            rs.getString("REFERENCIA"),
                            rs.getString("NOMBRE"),
                            rs.getString("DESCRIPCION"),
                            t,
                            rs.getInt("CANTIDAD"),
                            rs.getDouble("PRECIO"),
                            rs.getInt("DESCUENTO"),
                            rs.getInt("IVA"),
                            rs.getBoolean("APLICARDTO")
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
        String sql = "SELECT * FROM PRODUCTOS WHERE CANTIDAD = ?";

        try (Connection con = SQLDataBaseInventario.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, cantidad);

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {

                    Tipo t = new Tipo(rs.getString("TIPO"));

                    Producto p = new Producto(
                            rs.getInt("ID"),
                            rs.getString("REFERENCIA"),
                            rs.getString("NOMBRE"),
                            rs.getString("DESCRIPCION"),
                            t,
                            rs.getInt("CANTIDAD"),
                            rs.getDouble("PRECIO"),
                            rs.getInt("DESCUENTO"),
                            rs.getInt("IVA"),
                            rs.getBoolean("APLICARDTO")
                    );
                    productos.add(p);
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productos;
    }


    public static void removeProductoReferencia(String ref){
        String sql = "DELETE FROM PRODUCTOS WHERE REFERENCIA=?";

        try(Connection con = SQLDataBaseInventario.getConnection();
            PreparedStatement statement = con.prepareStatement(sql)){

            statement.setNString(1, ref);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateProducto(String referencia, String des, int cant, double precio, int descuento, boolean aplicarDto){
        String sql = "UPDATE FROM PRODUCTOS SET DESCRIPCION = ?, CANTIDAD = ?, PRECIO= ?, DESCUENTO= ?, APLICARDTO= ? WHERE REFERENCIA = ?";

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

    public static List<String> getReferenciasProducto(){
        List<String> referencias = new ArrayList<>();

        String sql = "SELECT REFERENCIA FROM PRODUCTOS";

        try(Connection con = SQLDataBaseInventario.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql)){

            while(rs.next()){
                referencias.add(rs.getNString("REFERENCIA"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return referencias;
    }
}