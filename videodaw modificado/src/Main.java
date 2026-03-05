import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int DNI = 0;
        Scanner sc = new Scanner(System.in);
        videoDaw videoclub = new videoDaw();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ VIDEOCLUB ---");
            System.out.println("1. Crear y registrar VideoClub en la franquicia");
            System.out.println("2. Registrar articulo en videoclub");
            System.out.println("3. Crear y registrar cliente en videoclub");
            System.out.println("4. Alquilar");
            System.out.println("5. Devolver");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja articulo");
            System.out.println("8. mostrarInventario");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese CIF del Videoclub: ");
                    String cif = sc.nextLine();
                    System.out.print("Ingrese dirección del Videoclub: ");
                    String direccion = sc.nextLine();
                    System.out.print("Ingrese fecha de alta (YYYY-MM-DD): ");
                    LocalDate fechaAlta = LocalDate.parse(sc.nextLine());
                    System.out.println("Videoclub registrado con éxito.");
                    break;

                case 2:
                    System.out.println("1. pelicula\n 2. videojuego");
                    int opcion2 = sc.nextInt();
                    sc = new Scanner(System.in);
                    System.out.print("Código Articulo: ");
                    String codP = sc.nextLine();

                    System.out.print("nombre articulo: ");
                    String titulo = sc.nextLine();
                    if(opcion2 == 1) {
                        System.out.print("Género (ACCION, COMEDIA, TERROR, DRAMA, AVENTURA, AMOR): ");
                        String generoStr = sc.nextLine().toUpperCase();
                        Pelicula.Genero genero = Pelicula.Genero.valueOf(generoStr);
                        Pelicula nuevaPeli = new Pelicula(codP, titulo, generoStr);
                        videoclub.registrarArticulo(nuevaPeli);
                    } else {
                        System.out.println("SHOOTERS, RPG, SANDBOX, MOBA, AVENTURA");
                        String generoStr = sc.nextLine().toUpperCase();
                        Videojuego.Genero genero = Videojuego.Genero.valueOf(generoStr);
                        Videojuego nuevaVideojuego = new Videojuego(codP, titulo, genero);
                        videoclub.registrarArticulo(nuevaVideojuego);
                    }
                    break;

                case 3:
                    System.out.print("DNI cliente: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número de socio: ");
                    String numSocio = sc.nextLine();
                    System.out.println("Direccion del cliente");
                    direccion = sc.nextLine();
                    System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
                    LocalDate fechaNac = LocalDate.parse(sc.nextLine());
                    Cliente nuevoCliente = null;
                    try {
                        nuevoCliente = new Cliente(dni, nombre, numSocio, fechaNac, direccion);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    videoclub.registrarCliente(nuevoCliente);
                    break;

                case 4:
                    System.out.print("Código articulo a alquilar: ");
                    String codAlq = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    String dniAlq = sc.nextLine();
                    sc = new Scanner(System.in);
                    videoclub.alquilarArticulo(codAlq, dniAlq);
                    break;

                case 5:
                    System.out.print("Código articulo a devolver: ");
                    String codDev = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    String dniDev = sc.nextLine();
                    videoclub.devolverArticulo(codDev, dniDev);
                    break;

                case 6:
                    System.out.print("DNI cliente a dar de baja: ");
                    String dniBaja = sc.nextLine();
                    videoclub.darBajaCliente(dniBaja);
                    break;

                case 7:
                    System.out.print("Código articulo a dar de baja: ");
                    String codBaja = sc.nextLine();
                    videoclub.darBajaArticulo(codBaja);
                    break;
                case 8:
                    System.out.println("mostrando Inventario");
                    videoclub.mostrarInventario();
                    break;

                case 9:
                    salir = true;
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        sc.close();
    }
}
