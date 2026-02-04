import java.text.NumberFormat;
import java.util.Scanner;

public class CoceHuevos {
    public static int minutos(int huevos, int capacidadOlla) {
        float div = huevos / capacidadOlla;
        int paso2 = Math.round(div);
            int res = paso2 * 10;
            return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuantos huevos caben en la olla?");
        int huevos = sc.nextInt();
        System.out.print("¿Cuantos huevos quieres cocer?");
        int capacidadOlla = sc.nextInt();
        System.out.print(minutos(huevos, capacidadOlla));

    }
}