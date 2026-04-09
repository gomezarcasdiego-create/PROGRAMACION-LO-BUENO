package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BDaccess {


    public static ArrayList<Ciudad> obtenerCiudades() {
        ArrayList<Ciudad> ciudades = new ArrayList();
        String sql = "SELECT * FROM ciudad";

        try (Connection con = BD.conexion()) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Ciudad c = new Ciudad(
                        rs.getInt("Id"),
                        rs.getString("nombre")

                );
                ciudades.add(c);
            }


            BD.desconectar(con);

            return ciudades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Equipo> obtenerEquipos() {
        ArrayList<Equipo> equipos = new ArrayList();
        String sql = "SELECT * FROM equipo";

        try (Connection con = BD.conexion()) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Equipo e = new Equipo(
                        rs.getInt("Id_ciudad"),
                        rs.getInt("Id"),
                        rs.getString("Nombre"),
                        LocalDate.parse(rs.getDate("fecha_fundacion").toString()),
                        rs.getString("nombre_campo")

                );
                equipos.add(e);
            }
            return equipos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Equipo> obtenerEquipos(String ciudad) {
        ArrayList<Equipo> equipos = new ArrayList();
        String sql = "SELECT * FROM equipo WHERE id_ciudad = (SELECT id FROM ciudad WHERE nombre like ?) ";

        try (Connection con = BD.conexion()) {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, ciudad);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Equipo e = new Equipo(
                        rs.getInt("Id_ciudad"),
                        rs.getInt("Id"),
                        rs.getString("Nombre"),
                        LocalDate.parse(rs.getDate("fecha_fundacion").toString()),
                        rs.getString("nombre_campo")

                );
                equipos.add(e);
            }
            return equipos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Equipo obtenerEquipo(int id_equipo) {
        String sql = "SELECT * FROM equipo WHERE id = ?";
        Equipo e = null;
        try (Connection con = BD.conexion()) {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id_equipo);
            ResultSet rs = statement.executeQuery();

            rs.next();

                e = new Equipo(
                        rs.getInt("Id_ciudad"),
                        rs.getInt("Id"),
                        rs.getString("Nombre"),
                        LocalDate.parse(rs.getDate("fecha_fundacion").toString()),
                        rs.getString("nombre_campo")

                );


            return e;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }



    public static ArrayList<Jugador> obtenerJugadores(String equipo) {
        ArrayList<Jugador> jugadores = new ArrayList();
        String sql = "SELECT * FROM jugador, equipo_jugador WHERE jugador.id = equipo_jugador.id_jugador and  equipo_jugador.id_equipo = (SELECT id FROM equipo WHERE nombre like ?) and equipo_jugador.fecha_fin is null";

        try (Connection con = BD.conexion()) {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, equipo);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Jugador j = new Jugador(
                        rs.getInt("Id"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Posicion"),
                        rs.getString("pierna_Habil")

                );
                jugadores.add(j);
            }
            return jugadores;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Jugador obtenerJugador(int id_jugador) {
        String sql = "SELECT * FROM jugador  WHERE id = ?";
        Jugador j = null;
        try (Connection con = BD.conexion()) {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id_jugador);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                j = new Jugador(
                        rs.getInt("Id"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Posicion"),
                        rs.getString("pierna_Habil")

                );

            }
            return j;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Equipo> obtenerEquipoJugador(String equipo) {
        ArrayList<Equipo> equipos = new ArrayList();
        String sql = "SELECT * FROM equipo";

        try (Connection con = BD.conexion()) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Equipo e = new Equipo(
                        rs.getInt("Id_ciudad"),
                        rs.getInt("Id"),
                        rs.getString("Nombre"),
                        LocalDate.parse(rs.getDate("fecha_fundacion").toString()),
                        rs.getString("nombre_campo")

                );
                equipos.add(e);
            }


            BD.desconectar(con);

            return equipos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarJugador(int id_jugador) {
        String sql = "DELETE FROM jugador WHERE id = ?";
        return false;
    }

    public static boolean eliminarEquipo(int id_equipo, int  id_jugador) throws SQLException {
        String sql = "update equipo_jugador set fecha_fin = curdate() WHERE id_equipo = ? and id_jugador = ?";
        Connection con = null;
        PreparedStatement statement = con.prepareStatement(sql);
        try {
            statement.setInt(1, id_jugador);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet rs = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean eliminarJugador(int equipo, int id_jugador) throws SQLException {
        String sql = "DELETE FROM EquipoJugador WHERE id_equipo = ? and id_jugador = ?";
        Connection con = BD.conexion();
        PreparedStatement statement = con.prepareStatement(sql);

        try{
            statement.setInt(1, id_jugador);
            statement.setInt(1, equipo);
            statement.executeQuery();
            con.close();
            return true;
        }catch(SQLException e){
           return false;
        }
    }

    public static int ultimoDorsal(int equipo) throws SQLException {
        String sql = "SELECT MAX(dorsal) FROM EquipoJugador WHERE id_equipo like ?";
        Connection con = BD.conexion();
        PreparedStatement statement = con.prepareStatement(sql);

        try{
            statement.setInt(1, equipo);
            return statement.executeQuery().getInt(1);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public static boolean insertarJugador(int equipo, int id_jugador) throws SQLException {
        String sql = "INSERT INTO EquipoJugador (id_equipo, id_jugador, fecha_inicio, fecha_fin, dorsal) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = BD.conexion();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, equipo);
            statement.setInt(2, id_jugador);
            statement.setDate(3, Date.valueOf(LocalDate.now()));
            statement.setDate(4, null);
            statement.setInt(5, ultimoDorsal(equipo) + 1);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean traspaso(int id_jugador, int id_nuevoEquipo) {
        Equipo actual = obtenerEquipo(id_jugador);
        Equipo nuevo = obtenerEquipo(id_nuevoEquipo);

        Jugador jugador = obtenerJugador(id_jugador);




        String sql = "DELETE FROM EquipoJugador WHERE id_equipo = ? and id_jugador = ?";
        Connection con = BD.conexion();


        try{
            con.setAutoCommit(false);

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id_jugador);
            statement.setInt(1, actual.getId());
            statement.executeQuery();


             sql = "insert into EquipoJugador (id_equipo, id_jugador, fecha_inicio, fecha_fin, dorsal) values (?, ?, ?, ?, ?)";

            statement = con.prepareStatement(sql);
                statement.setInt(1, nuevo.getId());
                statement.setInt(2, id_jugador);
                statement.setDate(3, Date.valueOf(LocalDate.now()));
                statement.setDate(4, null);
                statement.setInt(5, ultimoDorsal(nuevo.getId())+1);

                statement.executeQuery();
                con.commit();
                con.close();
                return true;
        }catch(SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
        return false;
    }
}