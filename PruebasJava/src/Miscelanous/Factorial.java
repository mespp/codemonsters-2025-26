package Miscelanous;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame un número: ");
        int numero = sc.nextInt();

        int resultado = 1;
        for (int i = numero; i > 1; i--) {
            resultado = resultado * i;
        }

        System.out.print("el factorial de " + numero + " es " + resultado);
    }
}

