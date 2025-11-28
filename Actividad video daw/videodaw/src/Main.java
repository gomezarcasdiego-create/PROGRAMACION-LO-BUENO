import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====MENU DEL VIDEOCLUB====");


        Clasepelicula pelicula = new Clasepelicula();

        int opcion;

        do{
            System.out.println("1. Crear y registrar VideoClub");
            System.out.println("2. Registrar pelicula en VideoClub");
            System.out.println("3. Crear y registrar cliente en videoclub");
            System.out.println("4. Alquilar pelicula");
            System.out.println("5. Devolver pelicula");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja pelicula");
            System.out.println("8. Salir");
            System.out.println("seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("Introduce la CIF: ");
                        String CIF = sc.nextLine();

                    System.out.println("Introduce la direccion : ");
                        String direccion = sc.nextLine();

                    System.out.println("Introduce la fecha de Apertura : ");
                        String fechaApertura = sc.nextLine();
                        break;
                case 2:
                    System.out.println("Registrar pelicula:");
                    String isAlquilada = sc.nextLine();
                        break;
                case 3:
                    System.out.println("Registrar cliente:");

                        break;
                case 4:
                    System.out.println("Alquilar pelicula:");
                        String isAlquilada2 = sc.nextLine();
                        System.out.println("Pelicula alquilada");
                        break;
                case 5:
                    System.out.println("Devolver pelicula:");

                        break;
                case 6:
                    System.out.println("Dar de baja cliente:");
                        break;
                case 7:
                    System.out.println("Dar de baja pelicula:");
                        break;
                case 8:
                    System.out.println("Saliendno del progrma...");
                        break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }while (opcion != 8);
    }
    private boolean validarCIF(String CIF){
        return CIF.matches("[0-9]{4}");
    }
}