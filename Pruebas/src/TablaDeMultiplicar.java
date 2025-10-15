import java.util.Scanner;

public class TablaDeMultiplicar {
    public static void main(String[] args) {
        System.out.print("Dame un número: ");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            int numero_multiplicao = i * numero;
            System.out.println(numero + " x " + i + " = " + numero_multiplicao);
        }
    }
}
