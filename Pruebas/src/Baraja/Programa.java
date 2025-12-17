package Baraja;

import java.util.Scanner;

public class Programa {
    static Baraja baraja;

    public static void main(String[] args) {
        baraja = new Baraja();

        Scanner sc = new Scanner(System.in);
        System.out.println("HOLA. BIENVENIDO AL GESTOR DE BARAJAS EDICIÓN 2025 v67. SELECCIONA LO QUE DESEAS HACER CON TU MARAVILLOSA Y PRECIADA BARAJA");
        System.out.println("Presiona (1) para inicializar");
        System.out.println("Presiona (2) para retirar una carta");
        System.out.println("Presiona (3) para agregar una carta");
        System.out.println("Presiona (4) para listar las carta");
        System.out.println("Presiona (5) para eliminar las carta");
        System.out.println("Presiona (6) para barajar");

        int accion = sc.nextInt();
        if (accion == 1) {
            baraja.inicializar();
        } else if (accion == 2) {
            baraja.retirarCarta();
        } else if (accion == 3) {
            baraja.agregarCarta();
        } else if (accion == 4) {
            baraja.listarTodasLasCartas();
        } else if (accion == 5) {
            baraja.eliminarTodasLasCartas();
        } else if (accion == 6) {
            baraja.barajar();
        } else {
            System.out.println("POR EL SANTO 67!!! ESA OPCIÓN NO ES VÁLIDA!!!");
        }
    }
}
