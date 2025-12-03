package Miscelanous;

import java.util.Scanner;

public class FormacionTortuga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame cuántos legionarios hay: ");
        double numLegionarios = sc.nextInt();

        double formaciones = Math.sqrt(numLegionarios);
    }
}
