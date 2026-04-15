package Baraja;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Baraja {
    private List<Carta> mazo = new ArrayList();
    private String[] palos = {"oros", "bastos", "copas", "espadas"};
    private int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public void inicializar() {
        eliminarTodasLasCartas();
        for (String p: palos) {
            for (int n: numeros) {
                 Carta carta = new Carta(n, p);
                 mazo.add(carta);
            }
        }
    }

    public void retirarCarta() {
        // TODO: retirar una carta del mazo
        Random aleatorio = new Random();
        int numAleatorio = aleatorio.nextInt((mazo.size() - 0) + 1) + 0;
        // System.out.println(numAleatorio);
        Carta cartaAleatoria = mazo.get(numAleatorio);
        mazo.remove(cartaAleatoria);
        System.out.println("Acabas de retirar " + cartaAleatoria);
        // System.out.println(mazo.size());
    }

    public int agregarCarta(Carta carta) {
        // TODO: lanzar una excepción si la carta ya existía
        for (Carta cartaMazo: mazo) {
            if (cartaMazo.palo.equals(carta.palo) && cartaMazo.numero == carta.numero) {
                return 0; // no agregada, ya existía una carta igual
            }
        }

        mazo.add(carta);
        return 1;
    }

    public void listarTodasLasCartas() {
        for (Carta carta : mazo) {
            System.out.println(carta);
        }
    }

    public void eliminarTodasLasCartas() {
        mazo.clear();
    }

    public void barajar() {
        Collections.shuffle(mazo);
    }
}
