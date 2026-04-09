package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
            System.out.println("1. Registrar equipo");
            System.out.println("2. Registrar jugador");
            System.out.println("3. Registrar jugador en el equipo");
            System.out.println("4. Haz un traspaso");
            System.out.println("5. Salir");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;

                default:
                    System.out.println("Opcion incorrecta");

            }
        }
            while (opcion != 5) ;


    }
}