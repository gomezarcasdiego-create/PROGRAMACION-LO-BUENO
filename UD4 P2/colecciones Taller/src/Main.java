import java.util.Scanner;

public class Main {
    public static <no> void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Taller taller = new Taller();
        int opcion = 0;

        do {
            System.out.println("\n----MENU TALLER----");
            System.out.println("1. Añadir Coche");
            System.out.println("2. Eliminar Coche");
            System.out.println("3. Salir");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    taller.anadeCoche();
                    break;

                case 2:
                    taller.eliminaCoche();
                    break;

                case 3:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 3);

        System.out.println("\n---- ESTADO FINAL DEL TALLER ----");
        taller.visualizaTaller();
    }
}