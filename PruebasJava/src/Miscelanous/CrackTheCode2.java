package Miscelanous;// versión de Alejandro

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CrackTheCode2 {

    private static final int INTENTOS_MAX = 5;
    private static Scanner sc;
    public static void main(String[] args) {
        List<Integer> codigo = new ArrayList<>();
        // Generamos un nuevo código aleatorio
        for (int digito = 0; digito < 3; digito++) {
            codigo.add(ThreadLocalRandom.current().nextInt(0, 9 + 1));
        }
        //System.out.println("Código: " + codigo);

        // Imprimimos las instrucciones del juego
        System.out.println("He generado un código de dígitos (del 0 al 9). Tienes 5 intentos para adivinarlo. Tras cada intento daré dos pistas:");
        System.out.println("* El número de dígitos que son correctos y además están en su lugar.");
        System.out.println("* El número de dígitos que son correctos pero que están fuera de su lugar.");
        System.out.println();

        // Bucle principal del juego
        sc = new Scanner(System.in);
        for (int intento = 1; intento <= INTENTOS_MAX; intento++) {
            List<Integer> jugada = pedirJugadaAlJugador(intento);
            // Comprobamos cuántos dígitos ha acertado y si están en posición
            int correctosYEnSuSitio = numDigitosCorrectosYEnSuSitio(jugada, codigo);
            int correctosYFueraDeSitio = numDigitosCorrectosYFueraDeSitio(jugada, codigo);
            if (correctosYEnSuSitio == codigo.size()) {
                System.out.println("¡Felicidades, has acertado el código!");
                break;
            } else {
                System.out.println("Dígitos correctos y en su sitio: " + correctosYEnSuSitio);
                System.out.println("Dígitos correctos pero fuera de su sitio: " + correctosYFueraDeSitio);
            }

            System.out.println();

            if (intento == INTENTOS_MAX) {
                System.out.println("Has agotado el número máximo de intentos. El código era: " + codigo);
            }
        }
    }

    // Devuelve el código tecleado por el jugador
    private static List<Integer> pedirJugadaAlJugador(int intento) {
        while (true) {
            System.out.print("Intento " + intento + ", ¿cuál es el código?: ");
            String respuesta = sc.nextLine();
            // Comprobamos si respuesta tiene longitud 3 y parece ser un número entero
            if (respuesta.length() == 3 && respuesta.matches("\\d+")) {
                List<Integer> jugada = new ArrayList<>();
                jugada.add((int)respuesta.charAt(0) - '0');
                jugada.add((int)respuesta.charAt(1) - '0');
                jugada.add((int)respuesta.charAt(2) - '0');
                return jugada;
            }
            System.out.println("Respuesta no válida, vuelve a intentarlo");
        }
    }

    private static int numDigitosCorrectosYEnSuSitio(List<Integer> jugada, List<Integer> codigo) {
        int total = 0;
        for (int i = 0; i < codigo.size(); i++) {
            if (jugada.get(i) == codigo.get(i)) {
                total++;
            }
        }
        return total;
    }

    private static int numDigitosCorrectosYFueraDeSitio(List<Integer> jugada, List<Integer> codigo) {
        int total = 0;
        for (int i = 0; i < codigo.size(); i++) {
            for (int j = 0; j < codigo.size(); j++) {
                if (i != j && codigo.get(i) == jugada.get(j)) {
                    total++;
                    break;
                }
            }
        }
        return total;
    }
}

