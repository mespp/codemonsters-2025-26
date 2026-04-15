package Miscelanous;

import java.util.Scanner;

public class TrianguloDeFloyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame la altura para el triángulo: ");
        int altura = sc.nextInt();

        int contador = 1;

        for (int i = 1; i <= altura; i++) {
            for (int r = i; r >= 1; r--) {
                System.out.print(contador + " ");
                contador++;
            }
            System.out.println(" ");

        }
    }
}
