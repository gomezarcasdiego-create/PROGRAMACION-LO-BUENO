import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int opcion;
        Scanner sc = new Scanner(System.in);

        boolean Salir = false;

        do{
            System.out.print("===MENU===\n");
            System.out.print("1. Crear producto\n");
            System.out.print("2. Mostrar productos existentes\n");
            System.out.print("3. Eliminar producto por código\n");
            System.out.print("4. Guarda productos en el fichero\n");
            System.out.print("5. Salir\n");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Creando producto\n");
                break;
                
                case 2:
                    System.out.println("Mostrar los productos\n");
                break;

                case 3:
                    System.out.println("Eliminar producto\n");
                break;

                case 4:
                    System.out.println("Guardar productos\n");
                break;

                case 5:
                    Salir = true;
                break;

                default:
            }
        }while(!Salir);
    }
}