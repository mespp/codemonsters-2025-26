import java.util.Scanner;

public class TrianguloFloyd {
    public static void main(String args[]) {
        System.out.print("¿De qué altura quieres triángulo?: ");
        int altura = new Scanner(System.in).nextInt();
        int num = 1;
        for (int fila = 1; fila <= altura; fila++) {
            for (int columna = 1; columna <= fila; columna++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}