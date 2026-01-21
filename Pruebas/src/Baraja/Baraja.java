package Baraja;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class Baraja {
    private List<Carta> mazo = new ArrayList();
    private String[] palos = {"oros", "bastos", "copas", "espadas"};
    private int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private List<Carta> mazoBackup = mazo;

    public void inicializar() {
        // TODO: eliminar el mazo y poner las 40 cartas iniciales ordenadas
        eliminarTodasLasCartas();
        for (String p: palos) {
            for (int n: numeros) {
                 Carta carta = new Carta(n, p);
                 mazo.add(carta);
            }
        }
        // System.out.println(mazo);
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

    public void agregarCarta(Carta carta) {
        // TODO: agregar una carta al mazo y lanzar una excepción si la carta ya existía
        int tamanoLista = mazoBackup.size();
        Random aleatorio = new Random();
        int numAleatorio = aleatorio.nextInt((tamanoLista - 0) + 1) + 0;
        Carta cartaAleatoria = mazoBackup.get(numAleatorio);
        mazo.add(cartaAleatoria);
        System.out.println("Acabas de agregar " + cartaAleatoria);
    }

    public void listarTodasLasCartas() {
        // TODO: listar las cartas del mazo
        for (Carta carta : mazo) {
            System.out.println(carta);
        }
    }

    public void eliminarTodasLasCartas() {
        mazo.clear();
    }

    public void barajar() {
        // TODO: desordenar las cartas que contiene el mazo
        Collections.shuffle(mazo);
        // System.out.println(mazo);
    }
}
