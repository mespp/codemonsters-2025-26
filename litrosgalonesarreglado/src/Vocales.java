import java.util.Scanner;

public class Vocales {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
            System.out.print("Escribe un caracter: ");
        String caracter = sc.nextLine();
        if (caracter.equals("a") || caracter.equals("e") || caracter.equals("i") || caracter.equals("o") || caracter.equals("u")){
            System.out.print(caracter + " es una vocal");
        } else {
            System.out.print(caracter + " no es una vocal");
        }
        }
}


// for (int cont = 0; cont < 5 ; cont++)

// Ahí tienes un bucle gratis

// If (edad 17 = 10 || altura > 20) {
//  Código;
//}

// ¡Guau! ¿Un condicional? ¡Es tu día de suerte!

// If (edad 17 = 10 || altura > 20) {
//  Código;
//  } else (o else if) {
//  Código
// }