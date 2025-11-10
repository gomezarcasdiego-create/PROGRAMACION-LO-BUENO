import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
public class Main {
    private static String option;

    public static void main(String[] args) {

        System.out.println("Introduce la cantidaad de numeros");
        Scanner sc = new Scanner(System.in);
        int contadorPosicion = sc.nextInt();
        System.out.println("Este es el menú");
        int[] array = new int[10];
        //ESTE MENU SE PONE PARA QUE EL USUARIO VEA LO QUE VAMOS A HACER//
        String opcion = "c";
        int contadorPosicion2 = 0;

        System.out.println("\n a modificar la coleccion"
                + "\n b Estadisticas de la coleccion"
                + "\n c Ampliar el valor de la coleccion"
                + "\n d Salir");

        sc = new Scanner(System.in);
        int [] array3 =   new int [10];

        String option = "d";

        int contadorPosicion1 = 0;
        do{
            System.out.println("Escoja la opcion deseada: ");
            System.out.println("a. modificar la coleccion");
            System.out.println("b. Estadisticas de la coleccion");
            System.out.println("c. Ampliar el valor de la coleccion");
            System.out.println("d. Salir");
            opcion = sc.nextLine();


            switch (opcion) {
                case "a":
                    System.out.println(Arrays.toString(array3));
                    break;

                case "b":
                    sc = new Scanner(System.in);
                    System.out.println("modificar la coleccion, cuantos numeros");
                    contadorPosicion1 = sc.nextInt();
                    if(contadorPosicion1 < array3.length && contadorPosicion1 <= 0){
                        array3[contadorPosicion1] = sc.nextInt();
                    }
                    else{
                        System.out.println("Estadisticas de la coleccion");
                    }
                    break;

                case "c":
                    System.out.println("Ampliar el valor de la coleccion");
                    break;

                case "d":
                    System.out.println("Salir");

                default:
                    System.out.println("Por favor escoja una opcion correcta");

            }

        }while(!option.equals("d")); //opcion.equals("d") == false

        sc = new Scanner(System.in);
        System.out.println("Introduce el valor de N");
        int nColeccion = sc.nextInt();
        double [] Coleccion = new double [contadorPosicion];
        int nPositivos = 0;
        int nNegativos = 0;
        for(int i = 0; i < 10; i++){
            System.out.println("Introduce un numero  distinto de cero: ");
            double n = sc.nextDouble();
            if(n < 0){
                nNegativos ++;
            }
            if(n > 0){
                nPositivos++;
            }
        }
        System.out.println("Hay" + nNegativos + "numeros negativos y hay " + nPositivos + " numeros positivos");

        double sumaColeccion = 0.0, maximaColeccion = Double.MIN_VALUE, minimaColeccion = Double.MAX_VALUE;

        for(int i = 0; i < Coleccion.length ; i++){
            System.out.println("Introduce el valor de la altura " + (i+1) + ": ");
            Coleccion[i] = sc.nextDouble();
            sumaColeccion += Coleccion[i];
        }

        int contadorColeccion = 0;
        for(int i = 0; i < Coleccion.length; i++){

            maximaColeccion = Math.max(Coleccion[i], maximaColeccion);
            minimaColeccion = Math.min(Coleccion[i], minimaColeccion);

        }

        System.out.println("La coleccion maxima es: " + maximaColeccion);
        System.out.println("La coleccion minima es: " + minimaColeccion);
        System.out.println("La suma de todo es: " + sumaColeccion);

        sc = new Scanner(System.in);
        System.out.println("Ampliar el valor de la coleccion");
        int nColeccion2 = sc.nextInt();
        double [] Coleccion2 = new double [contadorPosicion];
        double sumaColeccion2 = 0.0, maximaColeccion2 = Double.MIN_VALUE, minimaColeccion2 = Double.MAX_VALUE;

        for(int i = 0; i < Coleccion.length ; i++){
            System.out.println("Introduce el valor de la Coleccion " + (i+1) + ": ");
            Coleccion[i] = sc.nextDouble();
            sumaColeccion += Coleccion[i];
        }

        int contadorColeccion2 = 0;
        for(int i = 0; i < Coleccion2.length; i++){

            maximaColeccion2 = Math.max(Coleccion2[i], maximaColeccion2);
            minimaColeccion2 = Math.min(Coleccion2[i], minimaColeccion2);
        }
        System.out.println("La coleccion maxima es: " + maximaColeccion);
        System.out.println("La coleccion minima es: " + minimaColeccion);
        System.out.println("La suma de todo es: " + sumaColeccion);

        sc = new Scanner(System.in);
        do {
            option = "S";
            System.out.print("Salir: ");
            option = sc.nextLine();
            switch (option) {
                case "S":
            break;
            }
        }while(!option.equals("S")); //opcion.equals("s") == false
    }
}