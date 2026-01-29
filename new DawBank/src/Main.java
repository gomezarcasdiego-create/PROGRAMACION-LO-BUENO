import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Crear cuenta bancaria ===");




        String IBAN;
        do {
            System.out.println("Introduzca el IBAN (XX0000000000000000000000):");
            IBAN = sc.nextLine().toUpperCase().trim();
        } while (!checkIBAN(IBAN));

        String titular;
        do{
            System.out.println("introduce el titular: ");
            titular = sc.nextLine().toUpperCase().trim();
        }while (!checktitular(titular));
        cuentabancaria cuenta = new cuentabancaria(IBAN, titular);

        int opcion;

        do {
            System.out.println("\n====== MENÚ PRINCIPAL ======");
            System.out.println("1. Datos de la cuenta");
            System.out.println("2. IBAN");
            System.out.println("3. Titular");
            System.out.println("4. Saldo");
            System.out.println("5. Ingreso");
            System.out.println("6. Retirada");
            System.out.println("7. Movimientos");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("IBAN: " + cuenta.getIBAN());
                    System.out.println("Titular: " + cuenta.getTitular());
                    System.out.println("Saldo: " + cuenta.getSaldo() + "€");
                    break;


                case 2:
                    System.out.println("IBAN: " + cuenta.getIBAN());
                    break;

                case 3:
                    System.out.println("Titular: " + cuenta.getTitular());
                    break;

                case 4:
                    System.out.println("Saldo disponible: " + cuenta.getSaldo() + "€");
                    break;

                case 5:
                    System.out.print("Cantidad a ingresar: ");
                    double ingreso = sc.nextDouble();
                    cuenta.ingresar(ingreso);
                    break;

                case 6:
                    System.out.print("Cantidad a retirar: ");
                    double retirada = sc.nextDouble();
                    cuenta.retirar(retirada);
                    break;

                case 7:
                    System.out.println("MOVIMIENTOS");
                    cuenta.recorrer();
                    System.out.println("saldo" + cuenta.getSaldo());
                    cuenta.getSaldo();
                    break;

                case 8:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

    }

    public static boolean checkIBAN(String IBAN) {
        String regex = "^[A-Z]{2}[0-9]{22}$";
        return Pattern.matches(regex, IBAN);
    }

    public static boolean checktitular(String titular) {
        String regex = "^[A-Z]{3,}";
        return Pattern.matches(regex, titular);
    }
}