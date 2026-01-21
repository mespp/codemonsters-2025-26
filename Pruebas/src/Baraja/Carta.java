package Baraja;

public class Carta {
    public String palo;
    public int numero;

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    @Override
    public String toString() {
        if (numero == 10) {
            String tipo = "Sota";
            return tipo + " de " + palo;
        }
        if (numero == 11) {
            String tipo = "Caballo";
            return tipo + " de " + palo;
        }
        if (numero == 12) {
            String tipo = "Rey";
            return tipo + " de " + palo;
        }
        else {
            return numero + " de " + palo;
        }
    }
}
