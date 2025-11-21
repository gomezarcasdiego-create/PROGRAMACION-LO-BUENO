import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("====MENU DEL VIDEOCLUB====");

    int opcion;

    do{
        System.out.println("1. Crear y registrar VideoClub en la franquicia");
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
                System.out.println("Crear y registrar VideoClub ne la franquicia");
            case 2:
                System.out.println("Registrar pelicula en videoclub");
            case 3:
                System.out.println("Crear y registrar cliente en videoclub");
            case 4:
                System.out.println("Alquilar pelicula");
            case 5:
                System.out.println("Devolver pelicula");
            case 6:
                System.out.println("Dar de baja cliente");
            case 7:
                System.out.println("Dar de baja pelicula");
            case 8:
                System.out.println("saliendno del progrma");
                break;

            default:
                System.out.println("Opcion incorrecta");
        }
    }while (opcion != 8);

    }
}