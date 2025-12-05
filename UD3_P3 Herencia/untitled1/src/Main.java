import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("1. Nombre del Planeta:");
            System.out.println("2. Distancia al sol:");
            System.out.println("3. Orbita al sol:");
            System.out.println("4. TieneSatelite:");
            System.out.println("5. Tiene vida:");

            opcion = sc.nextInt();
            sc.nextLine();

            


        }while(true);
    }
}