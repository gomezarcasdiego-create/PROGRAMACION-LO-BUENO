import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int DNI = 0;
        Scanner sc = new Scanner(System.in);
        videoDaw videoclub = new videoDaw();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ VIDEOCLUB ---");
            System.out.println("1. Crear y registrar VideoClub en la franquicia");
            System.out.println("2. Registrar película en videoclub");
            System.out.println("3. Crear y registrar cliente en videoclub");
            System.out.println("4. Alquilar película");
            System.out.println("5. Devolver película");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja película");
            System.out.println("8. Salir");
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
                    System.out.print("Código película: ");
                    String codP = sc.nextLine();
                    System.out.print("Título película: ");
                    String titulo = sc.nextLine();
                    System.out.print("Género (ACCION, COMEDIA, TERROR, DRAMA, AVENTURA, AMOR): ");
                    String generoStr = sc.nextLine().toUpperCase();
                    Clasepelicula.Genero genero = Clasepelicula.Genero.valueOf(generoStr);
                    Clasepelicula nuevaPeli = new Clasepelicula(codP, titulo, generoStr);
                    videoclub.registrarPelicula(nuevaPeli);
                    break;

                case 3:
                    System.out.print("DNI cliente: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número de socio: ");
                    String numSocio = sc.nextLine();
                    System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
                    LocalDate fechaNac = LocalDate.parse(sc.nextLine());
                    Clasecliente nuevoCliente = new Clasecliente(dni, nombre, numSocio, fechaNac);
                    videoclub.registrarCliente(nuevoCliente);
                    break;

                case 4:
                    System.out.print("Código película a alquilar: ");
                    String codAlq = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    String dniAlq = sc.nextLine();
                    videoclub.alquilarPelicula(codAlq, dniAlq);
                    break;

                case 5:
                    System.out.print("Código película a devolver: ");
                    String codDev = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    String dniDev = sc.nextLine();
                    videoclub.devolverPelicula(codDev, dniDev);
                    break;

                case 6:
                    System.out.print("DNI cliente a dar de baja: ");
                    String dniBaja = sc.nextLine();
                    videoclub.darBajaCliente(dniBaja);
                    break;

                case 7:
                    System.out.print("Código película a dar de baja: ");
                    String codBaja = sc.nextLine();
                    videoclub.darBajaPelicula(codBaja);
                    break;

                case 8:
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