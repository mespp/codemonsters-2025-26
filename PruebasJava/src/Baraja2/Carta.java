package Baraja2;

public class Carta {
    public String palo;
    public Integer numero;

    public Carta(String palo, Integer numero) {
        this.palo = palo;
        this.numero = numero;
    }

    @Override
    public String toString() {
        if (numero == 1) {
            return "As" + " de " + palo;
        } else if (numero == 10) {
            return "Sota" + " de " + palo;
        } else if (numero == 11) {
            return "Caballo" + " de " + palo;
        } else if (numero == 12) {
            return "Rey" + " de " + palo;
        } else {
            return numero + " de " + palo;
        }
    }

    public static int toInt(String numeroUsuario) {
        if (numeroUsuario.equals("As")) {
            return 1;
        } else if (numeroUsuario.equals("1")) {
            return 1;
        } else if (numeroUsuario.equals("2")) {
            return 2;
        } else if (numeroUsuario.equals("3")) {
            return 3;
        } else if (numeroUsuario.equals("4")) {
            return 4;
        } else if (numeroUsuario.equals("5")) {
            return 5;
        } else if (numeroUsuario.equals("6")) {
            return 6;
        } else if (numeroUsuario.equals("7")) {
            return 7;
        } else if (numeroUsuario.equals("8")) {
            return 8;
        } else if (numeroUsuario.equals("9")) {
            return 9;
        } else if (numeroUsuario.equals("sota")) {
            return 10;
        } else if (numeroUsuario.equals("10")) {
            return 10;
        } else if (numeroUsuario.equals("caballo")) {
            return 11;
        } else if (numeroUsuario.equals("11")) {
            return 11;
        } else if (numeroUsuario.equals("rey")) {
            return 12;
        } else if (numeroUsuario.equals("12")) {
            return 12;
        }
        return 999;
    }
}
