package Miscelanous;

import java.util.List;

public class NumMayor {

    public static void main(String[] args) {
        List<Integer> numeros = List.of(3, 7, -1, 12, 11, 11);

        Integer num_mayor = -2147483648;
        for (int num: numeros) {
            if (num > num_mayor) {
                num_mayor = num;
            }
        }
        System.out.println(num_mayor);
    }
}
