import java.util.Scanner;

public class Vocales {
    public static void main(String[] args) {
        System.out.print("Dime una letra: ");
        Scanner sc = new Scanner(System.in);
        String letra_usuario = sc.nextLine().toLowerCase();
        if (letra_usuario.equals("a") || letra_usuario.equals("e") || letra_usuario.equals("i") || letra_usuario.equals("o") || letra_usuario.equals("u") || letra_usuario.equals("á") || letra_usuario.equals("é") || letra_usuario.equals("í") || letra_usuario.equals("ó") || letra_usuario.equals("ú")) {
            System.out.println(letra_usuario + " es un vocal");
        }
        else {
                System.out.println(letra_usuario + " no es un vocal");
        }
    }
}
