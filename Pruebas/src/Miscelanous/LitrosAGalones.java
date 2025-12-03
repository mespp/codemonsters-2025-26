package Miscelanous;

import java.util.Scanner;

public class LitrosAGalones {
    public static void main(String[] args) {
        System.out.print("¿Qué cantidad quieres convertir a galones (exprésala en litros)? ");
        Scanner sc = new Scanner(System.in);
        double litros = sc.nextDouble();
        double galones = litros * 0.264172;
        System.out.println("La cantidad convertida a galones da un total de " + galones + " litros");
    }
}
