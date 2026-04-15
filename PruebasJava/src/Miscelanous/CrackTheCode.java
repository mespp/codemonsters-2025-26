package Miscelanous;// no dice los descolocados esta versión

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrackTheCode {
    public static void main(String[] args) {
        boolean numAdivinado = false;
        boolean num1Descolocado = false;
        boolean num2Descolocado = false;
        boolean num3Descolocado = false;

        int numsAdivinados = 0;

        int numRandom1 = (int) (Math.random() * 9) + 1;
        int numRandom2 = (int) (Math.random() * 9) + 1;
        int numRandom3 = (int) (Math.random() * 9) + 1;

        List<Integer> numAdivinar = List.of(numRandom1, numRandom2, numRandom3);
        List<Integer> numUsuario = new ArrayList<>();
        System.out.print(numAdivinar);

        while (numAdivinado == false) {
            System.out.print("¡¡¡LA BOMBA VA A EXPLOTAR!!! ¡¡¡DAME UN CÓDIGO DE 3 CIFRAS AHORA MISMO SOLDADO!!!: ");
            Scanner sc = new Scanner(System.in);

            String numUsuarioRaw = sc.nextLine();
            for (int i = 0; i < 3; i++) {
                char character = numUsuarioRaw.charAt(i);
                numUsuario.add((int) character - 48);
            }

            for (int i = 0; i < 3; i++) {
                if (numAdivinar.get(i) == numUsuario.get(i)) {
                    numsAdivinados = numsAdivinados + 1;
                }
            }

            /*
            if (numAdivinar.get(0) == numUsuario.get(1) || numAdivinar.get(0) == numUsuario.get(2)) {
                num1Descolocado = true;
            }
            if (numAdivinar.get(1) == numUsuario.get(1) || numAdivinar.get(0) == numUsuario.get(2)) {
                num2Descolocado = true;
            }
            if (numAdivinar.get(2) == numUsuario.get(2) || numAdivinar.get(0) == numUsuario.get(1)) {
                num3Descolocado = true;
            }
            */

            if (numsAdivinados == 3) {
                System.out.println("¡¡¡HAS DEFUSADO LA BOMBA SOLDADO!!! ¡¡¡HAS SALVADO A TU PATRIA!!!");
                break;
            }
            else {
                System.out.println("HAS AVERIGUADO " + numsAdivinados + " NÚMEROS SOLDADO, SIGUE ASÍ");
            }

            System.out.print(numUsuarioRaw);
            System.out.print(numUsuario);
        }
    }
}
