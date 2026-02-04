import java.util.Scanner;

public class FACTORIALOCOMOSELLAME {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe un número: ");
        float num = sc.nextFloat();
        float cont = 1;
        float i = 1;
        do {
            cont = cont * i;
            i = i + 1;
            System.out.print(cont + "   ");
        } while (num != i);
        System.out.print(cont);
}
}
