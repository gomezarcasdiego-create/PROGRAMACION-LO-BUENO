package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//
//        ArrayList<Ciudad> ciudades = BDaccess.obtenerCiudades();
//        for (Ciudad ciudad : ciudades) {
//            System.out.println(ciudad.getNombre());
//        }
//
//        ArrayList<Equipo> equipos =  BDaccess.obtenerEquipos();
//        for (Equipo equipo : equipos) {
//            System.out.println(equipo.getNombre());
//        }
//
//        equipos = BDaccess.obtenerEquipos("Madrid");
//        for (Equipo equipo : equipos) {
//            System.out.println(equipo.getNombre());
//        }
//
//        ArrayList<Jugador> jugadores = BDaccess.obtenerJugadores("Valencia CF");
//        for (Jugador jugador : jugadores) {
//            System.out.println(jugador.getNombre());
//        }


        System.out.println("====MENU====");

        int opcion;
        do {
            System.out.println("1. Listado de jugadores por equipo");
            System.out.println("2. Listado de equipos");
            System.out.println("3. Registrar jugador en el equipo");
            System.out.println("4. Haz un traspaso");
            System.out.println("5. Salir");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    sc = new Scanner(System.in); 
                    System.out.println("Ingrese el nombre del equipo: ");
                    String nombre = sc.nextLine();
                    ArrayList<Jugador> jugadores = BDaccess.obtenerJugadores(nombre);
                    for(Jugador j : jugadores){
                        System.out.println(j.toString());
                    }
                    break;
                case 2:
                    System.out.println("Estos son los 20 equipos: ");
                    ArrayList<Equipo> equipos =  BDaccess.obtenerEquipos();
                    for (Equipo equipo : equipos) {
                        System.out.println(equipo.getNombre());
                    }
                    break;
                case 3:
                    System.out.println("Dame el id del jugador: Ej:(1)");
                    int id_jugador = sc.nextInt();

                    break;
                case 4:
                    sc =  new Scanner(System.in);
                    System.out.println("Ingrese el nombre del jugador que quieres traspasar: ");
                    String nombre_jugador = sc.nextLine();
                    System.out.println("Ingrese el apellido del jugador que quieres traspasar: ");
                    String apellido_jugador = sc.nextLine();
                    System.out.println("Ingrese el nombre del equipo al que se le va a traspasar: ");
                    String nombre_equipo_anterior = sc.nextLine();
                    BDaccess.traspaso(BDaccess.obtenerJugador(nombre_jugador, apellido_jugador).getId(),BDaccess.obtenerEquipoPorNombre(nombre_equipo_anterior).getId());

                    break;
                case 5:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opcion incorrecta");


            }
        }
        while (opcion != 5) ;


    }
}