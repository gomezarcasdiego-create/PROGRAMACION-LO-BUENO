import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int DNI = 0;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=====MENU====");
            System.out.println("1. Crear equipo");
            System.out.println("2. Registrar Ninja en el equipo");
            System.out.println("3. Mostrar el número de ninjas totales en la Aldea");
            System.out.println("4. Mostrar información de un equipo");
            System.out.println("5. Mostrar información de todos los equipos");
            System.out.println("6. Mostrar información de toda la Aldea");
            System.out.println("7. Calcular estadísticas de toda la Aldea");
            System.out.println("8. Cambiar ninja de un equipo");
            System.out.println("9. Eliminar ninja de la aldea");
            System.out.println("10. Salir de la aplicación");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese codigo del equipo: ");
                    String codigo = sc.nextLine();
                    System.out.println("Ingrese nombre del equipo: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese fecha de creacion del equipo (YYYY-MM-DD): ");
                    LocalDate fechaCreacion = LocalDate.parse(sc.nextLine());
                    System.out.println("Maximo de ninjas (200): ");
                    int maximoninjas = sc.nextInt();
                    break;

                case 2:
                    System.out.println("Registrar Ninja en el equipo:");
                    String ninja = sc.nextLine();
                    System.out.println("Ingrese idNinja: ");
                    int idNinja = sc.nextInt();
                    System.out.println("Rango: ");
                    double rango = sc.nextDouble();
                    System.out.println("Tecnica Secreta: ");
                    String TecnicaSecreta = sc.nextLine();
                    break;

                case 3:
                    System.out.println("Ninjastotales:" + Equipo.getNinjas());
                    System.out.println("Ninjastotales:");
                    String numero = sc.nextLine();
                    break;


                case 4:
                    System.out.println("información del equipo:" + Equipo.getNinjas());
                    String informacion = sc.nextLine();
                    break;

                case 5:
                    System.out.println("Mostrar información de todos los equipos:");
                    String todos = sc.nextLine();
                    break;

                case 6:
                    System.out.println("Mostrar información de toda la Aldea:");
                    String Aldea = sc.nextLine();
                    break;

                case 7:
                    System.out.println("Calcular estadísticas de toda la Aldea:");
                    String aldea = sc.nextLine();
                    break;


                case 8:
                    System.out.println("Cambiar ninja de un equipo:");
                    String cambiar = sc.nextLine();
                    break;

                case 9:
                    System.out.println("Eliminar ninja de la aldea");
                    String eliminar = sc.nextLine();
                    break;

                case 10:
                    salir = true;
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("La opcion escogida no es valida, intentelo de nuevo");

            }
        }
        sc.close();
    }

}