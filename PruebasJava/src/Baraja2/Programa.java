package Baraja2;
import java.util.List;
import java.util.Scanner;
import static baraja.Carta.toInt;

public class Programa {
    private static Scanner sc;
    private static Baraja baraja = new Baraja();

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean quiereSalir = false;
        do {
            // Muestra el menú principal para que el usario pueda seleccionar lo que quiere hacer
            System.out.println("-= PROGRAMA GESTOR DE BARAJA =-");
            System.out.println();
            System.out.println("i - Inicializar la baraja");
            System.out.println("a - Añadir a la baraja");
            System.out.println("b - Barajar la baraja");
            System.out.println("r - Retirar una carta");
            System.out.println("l - Listar la baraja");
            System.out.println("e - Eliminar la baraja");
            System.out.println("s - Salir");

            System.out.print("? ");
            String opcionSeleccionada = sc.nextLine().trim().toLowerCase();

            if (opcionSeleccionada.equals("i")) {
                baraja.inicializar();

            } else if (opcionSeleccionada.equals("b")) {
                baraja.barajar();

            } else if (opcionSeleccionada.equals("r")) {
                Carta cartaRetirada = baraja.retirar();
                System.out.println(cartaRetirada);

            } else if (opcionSeleccionada.equals("e")) {
                baraja.eliminar();

            } else if (opcionSeleccionada.equals("l")) {
                List<Carta> cartas = baraja.listar();
                for (Carta carta: cartas) {
                    System.out.println(carta);
                }

            } else if (opcionSeleccionada.equals("a")) {
                System.out.println("¿Cúal es el número de la carta que quieres añadir?");
                String numeroUsuario = sc.next();
                int numero = toInt(numeroUsuario);
                System.out.println("¿De qué palo es la carta que quieres añadir?");
                String palo = sc.next().trim().toLowerCase();
                Carta cartaUsuario = new Carta(palo, numero);
                baraja.añadir(cartaUsuario);
                System.out.println();

            } else if (opcionSeleccionada.equals("s")) {
                quiereSalir = true;
            }

            /* else {
                System.out.println("Opción no válida");
            } */
        } while (!quiereSalir);
    }
}