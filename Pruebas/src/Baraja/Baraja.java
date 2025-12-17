package Baraja;
import java.util.ArrayList;
import java.util.List;

public class Baraja {
    private List<Carta> mazo = new ArrayList();
    private String[] palos = {"oros", "bastos", "copas", "espadas"};
    int[] numeros = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};

    public void inicializar() {
        // TODO: eliminar el mazo y poner las 40 cartas iniciales ordenadas
        eliminarTodasLasCartas();
        for (String p: palos) {
            for(int n: numeros) {
                 Carta carta = new Carta(n, p);
                 mazo.add(carta);
            }
        }
    }

    public void retirarCarta() {
        // TODO: retirar una carta del mazo
    }

    public void agregarCarta() {
        // TODO: agregar una carta al mazo
    }

    public void listarTodasLasCartas() {
        // TODO: listar las cartas del mazo
    }

    public void eliminarTodasLasCartas() {
        // TODO: borrar las cartas del mazo
        mazo.clear();
    }

    public void barajar() {
        // TODO: desordenar las cartas que contiene el mazo
    }
}

