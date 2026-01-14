import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Agenda agenda = new Agenda();
    int opcion = 0;

    do{
        System.out.println("\n----- MENÚ AGENDA -----");
        System.out.println("1. Añadir Contacto");
        System.out.println("2. Buscar Contactos");
        System.out.println("3. Eliminar Contacto");
        System.out.println("4. Visusalizar agenda");
        System.out.println("5. Número de contactos");
        System.out.println("6. Salir");

        opcion = sc.nextInt();
        sc.nextLine();

        switch(opcion){
            case 1:
                agenda.anadeContacto();
                break;
            case 2:
                agenda.buscaContacto();
                break;
            case 3:
                agenda.eliminaContacto();
                break;
            case 4:
                agenda.visualizaAgenda();
                break;
            case 5:
                System.out.println("Número de contactos: " + agenda.numeroContactos());
                break;
            case 6:
                System.out.println("Saliendo del programa");
                break;

            default:
                System.out.println("opcion invalida");
        }
    }while (opcion != 6);

    sc.close();

    }
}