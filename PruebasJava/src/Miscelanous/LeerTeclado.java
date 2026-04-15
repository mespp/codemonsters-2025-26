package Miscelanous;

import java.util.Scanner;

public class LeerTeclado {
    public static void main(String[] args) {
        System.out.print("¿Cuál es tu nombre?: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("¡Hola " + nombre + "!");
    }
}
