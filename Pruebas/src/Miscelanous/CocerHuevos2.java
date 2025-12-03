package Miscelanous;

import java.util.Scanner;

public class CocerHuevos2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame la capacidad de la olla: ");
        int capacidadOlla = sc.nextInt();

        System.out.print("Dime cuántos huevos quieres cocer: ");
        int huevos = sc.nextInt();

        int minutos = 0;

        int huevos_empaquetados = huevos / capacidadOlla;

        if (huevos_empaquetados < 1) {
            huevos_empaquetados = 1;
        }
        minutos = huevos_empaquetados * 10;

        System.out.println(minutos + " minutos para cocer tus huevos!!!");
    }
}
