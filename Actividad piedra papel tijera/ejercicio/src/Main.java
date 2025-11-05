import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //Ejercicio piedra papel tijera
        System.out.println("Ejercicio juego piedra papel tijera: ");
        System.out.println("\n juego de manos para dos o más personas " +
                "donde cada jugador elige entre tres gestos: piedra " +
                "(puño cerrado), papel (mano extendida)" +
                " o tijera (dedos índice y medio separados)");
        Scanner sc = new Scanner(System.in);
        int jugador1 = 0 , jugador2 = 0 , partida = 0;

        do {
            String [] opciones = {"p, l, t, s"};
            System.out.println("escribe tu elección: ");
            String eleccion = sc.nextLine();
            System.out.println("Su eleccion es: " + eleccion);
        } while(true);
    }
}