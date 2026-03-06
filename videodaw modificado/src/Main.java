import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int DNI = 0;
        Scanner sc = new Scanner(System.in);
        VideoDaw videoclub = cargarDatos();
        boolean salir = false;

//        String miDni = "72284030A";
//        System.out.println(miDni.substring(8));
//        if(comprobar(miDni)){
//            System.out.println("dni valido");
//            System.out.println(obtenerLetra(miDni));
//        } else{
//            System.out.println("DNI invalido");
//        }

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
                        System.out.println("FIFA, CSGO, VALORANT, NBA, FORTNITE");
                        String generoStr = sc.nextLine().toUpperCase();
                        Videojuego.Genero genero = Videojuego.Genero.valueOf(generoStr);
                        Videojuego nuevaVideojuego = new Videojuego(codP, titulo, genero);
                        videoclub.registrarArticulo(nuevaVideojuego);
                    }
                    break;

                case 3:
                    String dni;
                    boolean okeydni = false;
                    do{
                        System.out.print("DNI cliente: ");
                        dni = sc.nextLine();
                        okeydni = comprobarDni(dni)||comprobarNie(dni);
                        if (!okeydni){
                            System.out.println("dni incorrecto");
                        }
                    } while(!okeydni);

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
                    System.out.println("mostrarInventario");
                    videoclub.mostrarInventario();
                    break;

                case 9:
                    salir = true;
                    System.out.println("Programa terminado.");
                    guardarDatos(videoclub);
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");


            }
        }
        sc.close();
    }

    public static VideoDaw cargarDatos() {
        VideoDaw videoclub = new VideoDaw();
        File archivo = new File("articulos.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(!archivo.exists()){
            return new VideoDaw();
        } else {
            try {
                fis = new FileInputStream(archivo);

                ois = new ObjectInputStream(fis);
                videoclub = (VideoDaw) ois.readObject();
                ois.close();
                fis.close();
                return videoclub;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void guardarDatos(VideoDaw videoclub) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File("articulos.dat"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(videoclub);
            oos.close();
            fos.close();



        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("problemas en la lectura del fichero.");
        }
    }


    public static boolean comprobarDni (String dni){


        Pattern p = Pattern.compile("[0-9]{8}[A-Za-z]");
        Matcher m = p.matcher(dni);
        if(m.matches()){
            if(dni.substring(8).toLowerCase().charAt(0)==obtenerLetraDni(dni)){
                return true;
            }
            return false;
        }
        return false;
    }
    public static char obtenerLetraDni (String dni){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String numero = dni.substring(0,8);


        int resto = Integer.parseInt(numero)%23;

        return letras.toLowerCase().charAt(resto);
    }

    public static boolean comprobarNie (String nie){


        Pattern p = Pattern.compile("[XYyx][0-9]{7}[A-Za-z]");
        Matcher m = p.matcher(nie);
        if(m.matches()){
            if(nie.substring(8).toLowerCase().charAt(0)==obtenerLetraNie(nie)){
                return true;
            }
            return false;
        }
        return false;
    }
    public static char obtenerLetraNie (String nie){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String numero = nie.substring(1,8);


        int resto = Integer.parseInt(numero)%23;
        System.out.println(letras.toLowerCase().charAt(resto));
        return letras.toLowerCase().charAt(resto);
    }
}
