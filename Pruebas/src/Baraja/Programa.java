package Baraja;

import java.util.Scanner;

public class Programa {
    private static Baraja baraja;
    private static Scanner sc;

    public static void main(String[] args) {
        baraja = new Baraja();
        sc = new Scanner(System.in);
        seleccionar();
    }
    private static void seleccionar() {
        while (true) {
            System.out.println("HOLA. BIENVENIDO AL GESTOR DE BARAJAS. SELECCIONA LO QUE DESEAS HACER CON TU MARAVILLOSA Y PRECIADA BARAJA");
            System.out.println("Presiona (1) para inicializar");
            System.out.println("Presiona (2) para retirar una carta");
            System.out.println("Presiona (3) para agregar una carta");
            System.out.println("Presiona (4) para listar las carta");
            System.out.println("Presiona (5) para eliminar las carta");
            System.out.println("Presiona (6) para barajar");
            System.out.println("Presiona (0) para salir");

            String accion = sc.nextLine();
            if (accion.equals("1")) {
                baraja.inicializar();
            } else if (accion.equals("2")) {
                baraja.retirarCarta();
            } else if (accion.equals("3")) {
                System.out.println("Dime el palo de la carta que quieres añadir: ");
                String paloCartaEscogida = sc.nextLine();
                System.out.println("Dime el número de la carta que quieres añadir: ");
                int numeroCartaEscogida = sc.nextInt();
                Carta nuevaCarta = new Carta(numeroCartaEscogida, paloCartaEscogida);
                if (baraja.agregarCarta(nuevaCarta) == 0) {
                    System.out.println("Error: no añadida");
                } else {
                    System.out.println("Añadida");
                }
            } else if (accion.equals("4")) {
                baraja.listarTodasLasCartas();
            } else if (accion.equals("5")) {
                baraja.eliminarTodasLasCartas();
            } else if (accion.equals("6")) {
                baraja.barajar();
            } else if (accion.equals("0")) {
                break;
            } else {
                System.out.println("ESA OPCIÓN NO ES VÁLIDA!!!");
            }
        }
    }
}
