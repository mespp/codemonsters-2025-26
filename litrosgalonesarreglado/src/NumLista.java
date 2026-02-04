import java.util.List;

public class NumLista {
    public static void main(String[] args) {
        List <Integer> numeros = List.of(3, 7, -2, 5, 7, 32, 13, 42, 24, 24, 57);
        int numgrande =numeros.getFirst();
        for (int i = 0; i < numeros.size(); i++) {
            if (numgrande <= numeros.get(i)) {
                numgrande = numeros.get(i);
            }
        }
        System.out.print(numgrande);
    }
}