package baraja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Baraja {
    public List<Carta> cartas;
    String[] Palos = {"Oros", "Copas", "Espadas", "Bastos"};

    public Baraja(){
        cartas = new ArrayList<>();
    }
    public void inicializar() {
        cartas.clear();
        for (String palo: Palos) {
            for(int a = 1; a<8; a++) {
                Carta carta = new Carta(palo, a);
                cartas.add(carta);
            }
            for (int b = 10; b <13; b++) {
                Carta carta = new Carta(palo,b);
                cartas.add(carta);
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta retirar() {
        return cartas.removeLast();
    }

    public void eliminar(){
        cartas.clear();
    }

    public List<Carta> listar(){
        return cartas;
    }

    public void añadir(Carta cartaUsuario) {
        for (Carta carta: cartas){
            if (carta.equals(cartaUsuario)) {
                System.out.println("Carta ya está en el mazo");
            }
        }
        cartas.add(cartaUsuario);
    }
}
