import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int DNI = 0;
        Scanner sc = new Scanner(System.in);
        Empresa emp = new Empresa();
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ EMPRESA ---");
            System.out.println("1. Registrar trabajador en empresa");
            System.out.println("2. Mostrar informacion ");
            System.out.println("3. Mostrar el numero de trabajadores");
            System.out.println("4. Mostrar informacion departamento");
            System.out.println("5. Eliminar trabajador");
            System.out.println("6. guardar informacion");
            System.out.println("7. guardar cambios y salir");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println("introduce el nombre del director: ");
                    String regex = "^[A-Z]{3,}";
                    String director = sc.next();
                    System.out.print("Introduce el dni director: ");
                    String comprobarDni = sc.next();
                    System.out.print("registrar gerenteDep: ");
                    String GerenteDep = sc.next();
                    System.out.println("trabajador registrado con éxito.");
                    break;

                case 2:
                    System.out.println(emp.mostrarInfoTrabajadores());
                    break;

                case 3:
                    emp.mostrarInfoTrabajadores();
                   break;

                case 4:
                    emp.mostrarInfoTrabajadores();
                    break;

                case 5:
                    emp.trabajadoresEliminados();
                    System.out.println("dame el dni del trabajador:");
                    String dni = sc.next();
                    System.out.println("trabajador eliminado");
                    break;

                case 6:
                    guardarDatos("Empresa.dat");
                    break;

                case 7:
                    salir = true;
                    System.out.println("Programa terminado.");
                    guardarDatos(String.valueOf(emp));
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");


            }
        }
        sc.close();
    }

    private static Pattern comprobarDni() {
        return Pattern.compile("^[A-Za-z]{8,}$");
    }

    public static Empresa cargarDatos() {
        Empresa emp = new Empresa();
        File archivo = new File("empresa.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(!archivo.exists()){
            return new Empresa();
        } else {
            try {
                fis = new FileInputStream(archivo);

                ois = new ObjectInputStream(fis);
                emp = (Empresa) ois.readObject();
                ois.close();
                fis.close();
                return new Empresa();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void guardarDatos(String empresa) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File("empresa.dat"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(empresa);
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