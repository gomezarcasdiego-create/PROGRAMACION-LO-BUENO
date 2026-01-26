import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static class Ejercicio1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Introduce un valor entero: ");
                int A = sc.nextInt();
                System.out.println("Valor introducido: " + A);
            } catch (InputMismatchException e) {
                System.out.println("Valor introducido incorrecto");
            }
            sc.close();
        }
    }

    public class Ejercicio2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            try {
                System.out.print("Introduce A: ");
                int A = sc.nextInt();

                System.out.print("Introduce B: ");
                int B = sc.nextInt();

                int resultado = A / B;
                System.out.println("Resultado: " + resultado);

            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir valores enteros");
            } catch (ArithmeticException e) {
                System.out.println("Error: división por cero");
            }

            sc.close();
        }
    }

    public class Ejercicio3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double[] vector = new double[5];
            int i = 0;

            while (i < vector.length) {
                try {
                    System.out.print("Introduce un valor double (" + (i + 1) + "/5): ");
                    vector[i] = sc.nextDouble();
                    i++;
                } catch (InputMismatchException e) {
                    System.out.println("Error: debes introducir un número decimal");
                    sc.next();
                }
            }

            System.out.println("Vector completo:");
            for (double v : vector) {
                System.out.println(v);
            }

            sc.close();
        }
    }

    public class Ejercicio4 {
        public static void imprimePositivo(int p) throws Exception {
            if (p < 0) {
                throw new Exception("El numero no es positivo");
            }
            System.out.println("Positivo: " + p);
        }

        public static void imprimeNegativo(int n) throws Exception {
            if (n < 0) {
                throw new Exception("El numero no es negativo");
            }
            System.out.println("Negativo: " + n);
        }
        public static void main(String[] args) {
            int [] valores = {5, -3, 0, 10, -7};

            for (int v : valores) {
                try {
                    imprimePositivo(v);
                    imprimeNegativo(v);
                } catch (Exception e) {
                    System.out.println("Error: " + v + ": " + e.getMessage());
                }
            }
        }
    }

    public class Ejercicio5 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            try{
                Gato g1 = new Gato("Misu", 3);
                g1.imprimir();

                Gato g2 = new Gato("Lu", -1);
                g2.imprimir();
            } catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }

            try {
                Gato g3 = new Gato("Toby", 2);
                g3.imprimir();
            } catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public class Ejercicio6 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Gato> gatos = new ArrayList<>();

            while (gatos.size() < 5) {
                try {
                    System.out.print("Introduce el nombre: ");
                    String nombre = sc.next();

                    System.out.print("Introduce el edad: ");
                    int edad = sc.nextInt();

                    Gato g = new Gato(nombre, edad);
                    gatos.add(g);
                    System.out.println("Gato añadido correctamente");

                }catch (InputMismatchException e) {
                    System.out.println("Error: debes introducir valores enteros");
                    sc.next();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            System.out.println("\nLista de gatos:");
            for (Gato g : gatos) {
                System.out.println(g);
            }
            
            sc.close();
        }
    }

}