import java.util.Scanner;
public class DawBank {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int opcion;
      System.out.println("Elige una opcion");
      do{
          System.out.println("======Menú Principal======");
          System.out.println("0. Datos de la cuenta"); //Mostrará el IBAN, el titular y el saldo.
          System.out.println("1. IBAN");
          System.out.println("2. Titular");
          System.out.println("3. Saldo");
          System.out.println("4. Ingreso");
          System.out.println("5. Retirada");
          System.out.println("6. Movimientos");
          System.out.println("7. Salir");
          opcion = sc.nextInt();

        switch (opcion) {
            case 0:
                System.out.println("Datos de la cuenta");
                break;

            case 1:
                System.out.println("IBAN");
                break;

            case 2:
                System.out.println("Titular");
                break;

            case 3:
                System.out.println("Saldo");
                break;

            case 4:
                System.out.println("Ingreso");
                break;

            case 5:
                System.out.println("Retirada");
                break;

            case 6:
                System.out.println("Movimientos");
                break;

            case 7:
                System.out.println("salir");
                break;
            default:
                System.out.println("Opción inválida. Intenta de nuevo");
        }
      }while (opcion != 7);
    }
}
