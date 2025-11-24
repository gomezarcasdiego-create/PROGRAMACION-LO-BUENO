import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("====MENU DEL VIDEOCLUB====");
    System.out.println("Introduce la CIF: ");
    String CIF = sc.nextLine();

    System.out.println("Introduce la direccion : ");
    String direccion = sc.nextLine();

    System.out.println("Introduce la fecha de Apertura : ");
    String fechaApertura = sc.nextLine();

    Clasepelicula pelicula = new Clasepelicula();

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
                System.out.println("CIF: " + CIF);
                System.out.println("direccion:" + direccion);
                System.out.println("fechaApertura:" + fechaApertura);
            case 2:
                System.out.println("Registrar pelicula en videoclub");
            case 3:
                System.out.println("Crear y registrar cliente en videoclub");
            case 4:
                System.out.println("Alquilar pelicula" + pelicula.isAlquilada);
                String isAlquilada = sc.nextLine();

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
    public class validarCIF{
        public boolean validarCIF(String CIF) {
            if (CIF == null || CIF.length() != 9) {
              return false;
            }
            return false;
        }

    }
    private boolean validarCIF(String CIF){

        if(CIF.length() !=9) return false;

        String letras = CIF.substring(0,2);
        String numeros =  CIF.substring(2);

        if(!letras.contains(letras)) return false;

        if(!numeros.contains(letras)) return false;

        return true;
    }
}