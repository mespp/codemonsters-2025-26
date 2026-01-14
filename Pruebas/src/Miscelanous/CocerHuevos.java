package Miscelanous;
// está mal

import java.util.Scanner;

public class CocerHuevos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame la capacidad de la olla: ");
        int capacidadOlla = sc.nextInt();

        System.out.print("Dime cuántos huevos quieres cocer: ");
        int huevos = sc.nextInt();

        int numOllas = 0;
        int minutos = 0;

        System.out.println(numOllas + " minutos para cocer tus huevos!!!");
    }

    public static int minutos(int huevos, int capacidadOlla, int numOllas, int minutos) {
        for (int huevosRestantes = huevos; huevosRestantes > 0; huevosRestantes = huevosRestantes - capacidadOlla) {
            numOllas++;
        }
        return 10 * numOllas;
    }
}
