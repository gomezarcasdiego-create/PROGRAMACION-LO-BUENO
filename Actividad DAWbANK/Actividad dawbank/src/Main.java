import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Crear cuenta bancaria ===");
        System.out.print("Introduce IBAN: ");
        String iban = sc.nextLine();

        System.out.print("Introduce titular: ");
        String titular = sc.nextLine();

        cuentabancaria cuenta;

        try {
            cuenta = new cuentabancaria(iban, titular);
        } catch (Exception e) {
            System.out.println("Error al crear la cuenta: " + e.getMessage());
            return;
        }

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
                    cuenta.getMovimientos();
                    break;

                case 8:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

    }
}
