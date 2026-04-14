package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n====MENU====");
            System.out.println("1. Listado de jugadores por equipo");
            System.out.println("2. Listado de equipos");
            System.out.println("3. Registrar jugador en el equipo");
            System.out.println("4. Haz un traspaso");
            System.out.println("5. Listado de ciudades");
            System.out.println("6. Listado de equipos por ciudad");
            System.out.println("7. Buscar jugador por ID");
            System.out.println("8. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer tras nextInt()

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del equipo: ");
                    String nombreEquipo = sc.nextLine();

                    ArrayList<Jugador> jugadores = BDaccess.obtenerJugadores(nombreEquipo);

                    if (jugadores.isEmpty()) {
                        System.out.println("No se encontraron jugadores para ese equipo.");
                    } else {
                        for (Jugador j : jugadores) {
                            System.out.println(j.toString());
                        }
                    }
                    break;

                case 2:
                    System.out.println("Estos son los equipos: ");
                    ArrayList<Equipo> equipos = BDaccess.obtenerEquipos();
                    for (Equipo equipo : equipos) {
                        System.out.println(equipo.getNombre());
                    }
                    break;

                case 3:
                    System.out.print("Dame el ID del jugador: ");
                    int id_jugador = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Dame el ID del equipo: ");
                    int id_equipo = sc.nextInt();
                    sc.nextLine();

                    try {
                        boolean registrado = BDaccess.insertarJugador(id_equipo, id_jugador);
                        if (registrado) {
                            System.out.println("Jugador registrado correctamente en el equipo.");
                        } else {
                            System.out.println("No se pudo registrar el jugador.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al registrar el jugador: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del jugador que quieres traspasar: ");
                    String nombre_jugador = sc.nextLine();
                    System.out.print("Ingrese el apellido del jugador que quieres traspasar: ");
                    String apellido_jugador = sc.nextLine();
                    System.out.print("Ingrese el nombre del equipo al que se va a traspasar: ");
                    String nombre_equipo_nuevo = sc.nextLine();

                    Jugador jugadorTraspaso = BDaccess.obtenerJugador(nombre_jugador, apellido_jugador);
                    Equipo equipoDestino = BDaccess.obtenerEquipoPorNombre(nombre_equipo_nuevo);

                    if (jugadorTraspaso == null) {
                        boolean resultado = BDaccess.traspaso(jugadorTraspaso.getId(), equipoDestino.getId());
                        if (resultado) {
                            System.out.println("Traspaso realizado correctamente.");
                        } else {
                            System.out.println("No se pudo realizar el traspaso.");
                        }

                    } else if (equipoDestino == null) {
                        System.out.println("No se encontro el equipo de destino.");
                    } else {
                        System.out.println("No se encontro el jugador.");
                    }
                    break;

                case 5:
                    System.out.println("Listado de ciudades: ");
                    ArrayList<Ciudad> ciudades = BDaccess.obtenerCiudades();
                    for (Ciudad ciudad : ciudades) {
                        System.out.println(ciudad.getNombre());
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el nombre de la ciudad: ");
                    String nombreCiudad = sc.nextLine();

                    ArrayList<Equipo> equiposCiudad = BDaccess.obtenerEquipos(nombreCiudad);
                    if (equiposCiudad.isEmpty()) {
                        System.out.println("No se encontraron equipos para esa ciudad.");
                    } else {
                        for (Equipo equipo : equiposCiudad) {
                            System.out.println(equipo.getNombre());
                        }
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el ID del jugador: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    Jugador jugadorEncontrado = BDaccess.obtenerJugador(idBuscar);
                    if (jugadorEncontrado == null) {
                        System.out.println("No se encontro ningun jugador con ese ID.");
                    } else {
                        System.out.println(jugadorEncontrado.toString());
                    }
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta, elige entre 1 y 8.");
            }

        } while (opcion != 8);

        sc.close();
    }
}
