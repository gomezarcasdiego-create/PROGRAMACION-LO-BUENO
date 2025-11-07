import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //Ejercicio piedra papel tijera
                Scanner sc = new Scanner(System.in);

                // --- Mostrar instrucciones ---
                System.out.println("===================================");
                System.out.println("   JUEGO: PIEDRA, PAPEL O TIJERA");
                System.out.println("===================================");
                System.out.println("Instrucciones:");
                System.out.println("P -> Piedra");
                System.out.println("L -> Papel");
                System.out.println("T -> Tijera");
                System.out.println("S -> Salir del juego");
                System.out.println("-----------------------------------");

                // --- Posibles jugadas ---
                String[] jugadas = {"P", "L", "T"};

                // --- Bucle principal ---
                boolean seguir = true;
                while (seguir) {
                    // Jugada aleatoria del ordenador
                    int aleatorio = (int) (Math.random() * 3);
                    String jugadaComputadora = jugadas[aleatorio];

                    // Pedir jugada al usuario
                    System.out.print("\nElige tu jugada (P/L/T/S): ");
                    String jugadaUsuario = sc.nextLine().toUpperCase();

                    // Si el jugador quiere salir
                    if (jugadaUsuario.equals("S")) {
                        seguir = false;
                        System.out.println("¡Gracias por jugar! ");
                    }
                    // Si la jugada es válida
                    else if (jugadaUsuario.equals("P") || jugadaUsuario.equals("L") || jugadaUsuario.equals("T")) {
                        System.out.println("La computadora eligió: " + jugadaComputadora);

                        // Decidir quién gana
                        if (jugadaUsuario.equals(jugadaComputadora)) {
                            System.out.println("🟡¡Empate!");
                        } else if (
                                (jugadaUsuario.equals("P") && jugadaComputadora.equals("T")) ||
                                        (jugadaUsuario.equals("L") && jugadaComputadora.equals("P")) ||
                                        (jugadaUsuario.equals("T") && jugadaComputadora.equals("L"))
                        ) {
                            System.out.println("¡Ganaste!");
                        } else {
                            System.out.println(" Perdiste...");
                        }
                    }
                    // Si la jugada no es válida
                    else {
                        System.out.println("⚠Jugada no válida. Intenta de nuevo.");
                    }
                }

                sc.close();
            }
        }