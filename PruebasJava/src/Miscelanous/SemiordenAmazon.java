package Miscelanous;

import java.util.List;

class SemiordenAmazon {
    public static void main(String[] args) {
        int i = 0;
        List<Integer> nums = List.of(9, 12, 5, 10, 14, 3, 10);
        List<Integer> numsMenores = new java.util.ArrayList<>(List.of());
        List<Integer> numsIguales = new java.util.ArrayList<>(List.of());
        List<Integer> numsMayores = new java.util.ArrayList<>(List.of());
        List<Integer> numsOrdenados = new java.util.ArrayList<>(List.of());
        int objetivo = 10;


        for (int num: nums) {
            if (num < objetivo) {
                numsMenores.add(num);
            }
            if (num == objetivo) {
                numsIguales.add(num);
            }
            if (num > objetivo) {
                numsMayores.add(num);
            }
        }

        numsOrdenados.addAll(numsMenores);
        numsOrdenados.addAll(numsIguales);
        numsOrdenados.addAll(numsMayores);

        System.out.println(numsOrdenados);
        }
    }
