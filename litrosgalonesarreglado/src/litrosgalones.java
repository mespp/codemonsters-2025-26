import java.util.Scanner;

public class litrosgalones {
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
        System.out.print("Dime un volumen en litros: ");
    float litros = sc.nextFloat();
    float galones = litros * 0.264172f;
        System.out.print("Eso en galones es" + galones);
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