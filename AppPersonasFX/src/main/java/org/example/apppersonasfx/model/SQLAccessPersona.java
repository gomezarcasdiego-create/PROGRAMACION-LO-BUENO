package org.example.apppersonasfx.model;

import org.example.apppersonasfx.configuration.SQLDataBaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessPersona {


    public static List<Persona> getAllpersonas(){
        List<Persona> personas = new LinkedList<>();

        String sql = "SELECT * FROM personas";

        try(Connection connection = SQLDataBaseManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSets = statement.executeQuery(sqlpersonas)){

            while (resultSets.next()){
                String dni = resultSets.getNString(1);
                String name = resultSets.getNString(2);
                String surname = resultSets.getNString(3);
                String email = resultSets.getNString(4);
                int age = resultSets.getInt(5);
                String phone = resultSets.getNString(6);

                Persona p = Persona.builder()
                                .dni(dni)
                        

                personas.add(p);
            }
        }
        return null;
    }

    public static Persona getPersonaByID(int id) {

        Persona p = null;
        String sql = "SELECT * FROM personas WHERE dni = ?";

        try (Connection connection = SQLDataBaseManager.getConnection());

            PreparedStatement statement = connection.preparedStatement(sqlpersonas){

        }
        return p;
    }

    public static Persona getPersonaByEmail(String email){
        return null;
    }

    public static Persona getPersonaByName(String name){
        return null;
    }

    public boolean createPersona(Persona persona){
        return false;
    }

    public boolean updatePersona(Persona persona){
        return false;
    }

    public boolean deletePersona(int id){
        return false;
    }

}
